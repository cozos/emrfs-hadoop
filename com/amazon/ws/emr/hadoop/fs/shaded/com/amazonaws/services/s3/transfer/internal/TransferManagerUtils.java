package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Encryption;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PauseStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManagerConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class TransferManagerUtils
{
  private static final Log log = LogFactory.getLog(TransferManagerUtils.class);
  
  public static ThreadPoolExecutor createDefaultExecutorService()
  {
    ThreadFactory threadFactory = new ThreadFactory()
    {
      private int threadCount = 1;
      
      public Thread newThread(Runnable r)
      {
        Thread thread = new Thread(r);
        thread.setName("s3-transfer-manager-worker-" + threadCount++);
        return thread;
      }
    };
    return (ThreadPoolExecutor)Executors.newFixedThreadPool(10, threadFactory);
  }
  
  public static boolean isUploadParallelizable(PutObjectRequest putObjectRequest, boolean isUsingEncryption)
  {
    if (isUsingEncryption) {
      return false;
    }
    return getRequestFile(putObjectRequest) != null;
  }
  
  public static long getContentLength(PutObjectRequest putObjectRequest)
  {
    File file = getRequestFile(putObjectRequest);
    if (file != null) {
      return file.length();
    }
    if ((putObjectRequest.getInputStream() != null) && 
      (putObjectRequest.getMetadata().getContentLength() > 0L)) {
      return putObjectRequest.getMetadata().getContentLength();
    }
    return -1L;
  }
  
  public static long calculateOptimalPartSize(PutObjectRequest putObjectRequest, TransferManagerConfiguration configuration)
  {
    double contentLength = getContentLength(putObjectRequest);
    double optimalPartSize = contentLength / 10000.0D;
    
    optimalPartSize = Math.ceil(optimalPartSize);
    return Math.max(optimalPartSize, configuration.getMinimumUploadPartSize());
  }
  
  public static boolean shouldUseMultipartUpload(PutObjectRequest putObjectRequest, TransferManagerConfiguration configuration)
  {
    long contentLength = getContentLength(putObjectRequest);
    return contentLength > configuration.getMultipartUploadThreshold();
  }
  
  public static File getRequestFile(PutObjectRequest putObjectRequest)
  {
    if (putObjectRequest.getFile() != null) {
      return putObjectRequest.getFile();
    }
    return null;
  }
  
  public static long calculateOptimalPartSizeForCopy(CopyObjectRequest copyObjectRequest, TransferManagerConfiguration configuration, long contentLengthOfSource)
  {
    double optimalPartSize = contentLengthOfSource / 10000.0D;
    
    optimalPartSize = Math.ceil(optimalPartSize);
    return Math.max(optimalPartSize, configuration
      .getMultipartCopyPartSize());
  }
  
  public static PauseStatus determinePauseStatus(Transfer.TransferState transferState, boolean forceCancel)
  {
    if (forceCancel)
    {
      if (transferState == Transfer.TransferState.Waiting) {
        return PauseStatus.CANCELLED_BEFORE_START;
      }
      if (transferState == Transfer.TransferState.InProgress) {
        return PauseStatus.CANCELLED;
      }
    }
    if (transferState == Transfer.TransferState.Waiting) {
      return PauseStatus.NOT_STARTED;
    }
    return PauseStatus.NO_EFFECT;
  }
  
  public static boolean isDownloadParallelizable(AmazonS3 s3, GetObjectRequest getObjectRequest, Integer partCount)
  {
    ValidationUtils.assertNotNull(s3, "S3 client");
    ValidationUtils.assertNotNull(getObjectRequest, "GetObjectRequest");
    if (((s3 instanceof AmazonS3Encryption)) || (getObjectRequest.getRange() != null) || 
      (getObjectRequest.getPartNumber() != null) || (partCount == null)) {
      return false;
    }
    return true;
  }
  
  public static Long getContentLengthFromContentRange(ObjectMetadata metadata)
  {
    ValidationUtils.assertNotNull(metadata, "Object metadata");
    
    String contentRange = (String)metadata.getRawMetadataValue("Content-Range");
    if (contentRange != null) {
      try
      {
        String[] tokens = contentRange.split("[ -/]+");
        return Long.valueOf(Long.parseLong(tokens[3]));
      }
      catch (Exception e)
      {
        log.info(String.format("Error parsing 'Content-Range' header value: %s. So returning null value for content length", new Object[] { contentRange }), e);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferManagerUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */