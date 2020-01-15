package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.FileLocks;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.FileLockException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.AbstractDownloadCallable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CompleteMultipartDownload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadMonitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadS3ObjectCallable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLProtocolException;

@SdkInternalApi
final class DownloadCallable
  extends AbstractDownloadCallable
{
  private static final Log LOG = LogFactory.getLog(DownloadCallable.class);
  private final AmazonS3 s3;
  private final GetObjectRequest req;
  private final boolean resumeExistingDownload;
  private final DownloadImpl download;
  private final long origStartingByte;
  private Integer lastFullyMergedPartNumber;
  private Long lastFullyMergedPartPosition;
  private final boolean resumeOnRetry;
  private long expectedFileLength;
  private static boolean testing;
  
  DownloadCallable(AmazonS3 s3, CountDownLatch latch, GetObjectRequest req, boolean resumeExistingDownload, DownloadImpl download, File dstfile, long origStartingByte, long expectedFileLength, long timeout, ScheduledExecutorService timedExecutor, ExecutorService executor, Integer lastFullyDownloadedPartNumber, boolean isDownloadParallel, boolean resumeOnRetry)
  {
    super(constructCallableConfig(executor, dstfile, latch, download, isDownloadParallel, timedExecutor, timeout));
    if ((s3 == null) || (req == null) || (download == null)) {
      throw new IllegalArgumentException();
    }
    this.s3 = s3;
    this.req = req;
    this.resumeExistingDownload = resumeExistingDownload;
    this.download = download;
    this.origStartingByte = origStartingByte;
    this.expectedFileLength = expectedFileLength;
    lastFullyMergedPartNumber = lastFullyDownloadedPartNumber;
    this.resumeOnRetry = resumeOnRetry;
  }
  
  DownloadCallable withLastFullyMergedPartPosition(Long lastFullyMergedPartPosition)
  {
    this.lastFullyMergedPartPosition = lastFullyMergedPartPosition;
    return this;
  }
  
  protected void downloadAsSingleObject()
  {
    S3Object s3Object = retryableDownloadS3ObjectToFile(dstfile, new DownloadTaskImpl(s3, download, req));
    
    updateDownloadStatus(s3Object);
  }
  
  protected void downloadInParallel()
    throws Exception
  {
    downloadInParallel(ServiceUtils.getPartCount(req, s3).intValue());
  }
  
  protected void setState(Transfer.TransferState transferState)
  {
    download.setState(transferState);
  }
  
  private void updateDownloadStatus(S3Object result)
  {
    if (result == null)
    {
      download.setState(Transfer.TransferState.Canceled);
      download.setMonitor(new DownloadMonitor(download, null));
    }
    else
    {
      download.setState(Transfer.TransferState.Completed);
    }
  }
  
  private void downloadInParallel(int partCount)
    throws Exception
  {
    if (lastFullyMergedPartNumber == null) {
      lastFullyMergedPartNumber = Integer.valueOf(0);
    }
    if (lastFullyMergedPartPosition == null) {
      lastFullyMergedPartPosition = Long.valueOf(0L);
    }
    long previousPartLength = 0L;
    long filePositionToWrite = lastFullyMergedPartPosition.longValue();
    
    ServiceUtils.createParentDirectoryIfNecessary(dstfile);
    
    truncateDestinationFileIfNecessary();
    if (!FileLocks.lock(dstfile)) {
      throw new FileLockException("Fail to lock " + dstfile);
    }
    for (int i = lastFullyMergedPartNumber.intValue() + 1; i <= partCount; i++)
    {
      filePositionToWrite += previousPartLength;
      
      GetObjectRequest getPartRequest = (GetObjectRequest)new GetObjectRequest(req.getBucketName(), req.getKey(), req.getVersionId()).withUnmodifiedSinceConstraint(req.getUnmodifiedSinceConstraint()).withModifiedSinceConstraint(req.getModifiedSinceConstraint()).withResponseHeaders(req.getResponseHeaders()).withSSECustomerKey(req.getSSECustomerKey()).withGeneralProgressListener(req.getGeneralProgressListener());
      
      getPartRequest.setMatchingETagConstraints(req.getMatchingETagConstraints());
      getPartRequest.setNonmatchingETagConstraints(req.getNonmatchingETagConstraints());
      getPartRequest.setRequesterPays(req.isRequesterPays());
      
      getPartRequest.setPartNumber(Integer.valueOf(i));
      
      futures.add(executor.submit(new DownloadS3ObjectCallable(serviceCall(getPartRequest), dstfile, filePositionToWrite)));
      
      previousPartLength = ServiceUtils.getPartSize(req, s3, i);
    }
    Future<File> future = executor.submit(new CompleteMultipartDownload(futures, dstfile, download, 
      lastFullyMergedPartNumber = Integer.valueOf(lastFullyMergedPartNumber.intValue() + 1)));
    ((DownloadMonitor)download.getMonitor()).setFuture(future);
  }
  
  private Callable<S3Object> serviceCall(final GetObjectRequest request)
  {
    new Callable()
    {
      public S3Object call()
        throws Exception
      {
        return s3.getObject(request);
      }
    };
  }
  
  private void truncateDestinationFileIfNecessary()
  {
    RandomAccessFile raf = null;
    if (!FileLocks.lock(dstfile)) {
      throw new FileLockException("Fail to lock " + dstfile);
    }
    try
    {
      raf = new RandomAccessFile(dstfile, "rw");
      if (lastFullyMergedPartNumber.intValue() == 0)
      {
        raf.setLength(0L);
      }
      else
      {
        long lastByte = ServiceUtils.getLastByteInPart(s3, req, lastFullyMergedPartNumber);
        if (dstfile.length() < lastByte) {
          throw new SdkClientException("File " + dstfile.getAbsolutePath() + " has been modified since last pause.");
        }
        raf.setLength(lastByte + 1L);
        download.getProgress().updateProgress(lastByte + 1L);
      }
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to append part file to dstfile " + e.getMessage(), e);
    }
    finally
    {
      IOUtils.closeQuietly(raf, LOG);
      FileLocks.unlock(dstfile);
    }
  }
  
  private void adjustRequest(GetObjectRequest req)
  {
    long[] range = req.getRange();
    long lastByte = range[1];
    long totalBytesToDownload = lastByte - origStartingByte + 1L;
    if (dstfile.exists())
    {
      if (!FileLocks.lock(dstfile)) {
        throw new FileLockException("Fail to lock " + dstfile + " for range adjustment");
      }
      try
      {
        expectedFileLength = dstfile.length();
        long startingByte = origStartingByte + expectedFileLength;
        LOG.info("Adjusting request range from " + Arrays.toString(range) + " to " + 
        
          Arrays.toString(new long[] { startingByte, lastByte }) + " for file " + dstfile);
        
        req.setRange(startingByte, lastByte);
        totalBytesToDownload = lastByte - startingByte + 1L;
      }
      finally
      {
        FileLocks.unlock(dstfile);
      }
    }
    if (totalBytesToDownload < 0L) {
      throw new IllegalArgumentException("Unable to determine the range for download operation. lastByte=" + lastByte + ", origStartingByte=" + origStartingByte + ", expectedFileLength=" + expectedFileLength + ", totalBytesToDownload=" + totalBytesToDownload);
    }
  }
  
  private S3Object retryableDownloadS3ObjectToFile(File file, ServiceUtils.RetryableS3DownloadTask retryableS3DownloadTask)
  {
    boolean hasRetried = false;
    for (;;)
    {
      boolean appendData = (resumeExistingDownload) || ((resumeOnRetry) && (hasRetried));
      if ((appendData) && (hasRetried)) {
        adjustRequest(req);
      }
      S3Object s3Object = retryableS3DownloadTask.getS3ObjectStream();
      if (s3Object == null) {
        return null;
      }
      try
      {
        if ((testing) && (resumeExistingDownload) && (!hasRetried)) {
          throw new SdkClientException("testing");
        }
        ServiceUtils.downloadToFile(s3Object, file, retryableS3DownloadTask
          .needIntegrityCheck(), appendData, expectedFileLength);
        
        return s3Object;
      }
      catch (AmazonClientException ace)
      {
        if (!ace.isRetryable()) {
          throw ace;
        }
        Throwable cause = ace.getCause();
        if ((((cause instanceof SocketException)) && (!cause.getMessage().equals("Connection reset"))) || ((cause instanceof SSLProtocolException))) {
          throw ace;
        }
        if (hasRetried) {
          throw ace;
        }
        LOG.info("Retry the download of object " + s3Object.getKey() + " (bucket " + s3Object.getBucketName() + ")", ace);
        hasRetried = true;
      }
      finally
      {
        s3Object.getObjectContent().abort();
      }
    }
  }
  
  static void setTesting(boolean b)
  {
    testing = b;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.DownloadCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */