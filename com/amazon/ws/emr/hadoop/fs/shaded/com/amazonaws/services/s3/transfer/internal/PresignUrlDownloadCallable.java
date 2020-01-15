package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.FileLocks;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.FileLockException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
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
public class PresignUrlDownloadCallable
  extends AbstractDownloadCallable
{
  private static final Log LOG = LogFactory.getLog(PresignUrlDownloadCallable.class);
  private final AmazonS3 s3;
  private final PresignedUrlDownloadRequest request;
  private final PresignedUrlDownloadImpl download;
  private final long perRequestDownloadSize;
  private final Long startByte;
  private final Long endByte;
  private final boolean resumeOnRetry;
  private long expectedFileLength;
  private static boolean testing;
  
  public PresignUrlDownloadCallable(ExecutorService executor, File dstfile, CountDownLatch latch, PresignedUrlDownloadImpl download, boolean isDownloadParallel, ScheduledExecutorService timedExecutor, long timeout, AmazonS3 s3, PresignedUrlDownloadRequest request, long perRequestDownloadSize, Long startByte, Long endByte, boolean resumeOnRetry)
  {
    super(constructCallableConfig(executor, dstfile, latch, download, isDownloadParallel, timedExecutor, timeout));
    if ((s3 == null) || (request == null) || (download == null)) {
      throw new IllegalArgumentException();
    }
    this.s3 = s3;
    this.request = request;
    this.download = download;
    this.perRequestDownloadSize = perRequestDownloadSize;
    this.startByte = startByte;
    this.endByte = endByte;
    this.resumeOnRetry = resumeOnRetry;
    
    expectedFileLength = 0L;
  }
  
  protected void downloadAsSingleObject()
  {
    S3Object s3Object = retryableDownloadS3ObjectToFile(dstfile, new PresignedUrlRetryableDownloadTaskImpl(s3, download, request));
    
    updateDownloadStatus(s3Object);
  }
  
  protected void downloadInParallel()
    throws Exception
  {
    downloadInParallelUsingRange();
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
  
  private S3Object retryableDownloadS3ObjectToFile(File file, ServiceUtils.RetryableS3DownloadTask retryableS3DownloadTask)
  {
    boolean hasRetried = false;
    for (;;)
    {
      boolean appendData = (resumeOnRetry) && (canResumeDownload()) && (hasRetried);
      if (appendData) {
        adjustRequest(request);
      }
      S3Object s3Object = retryableS3DownloadTask.getS3ObjectStream();
      if (s3Object == null) {
        return null;
      }
      try
      {
        if ((testing) && (!hasRetried)) {
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
        LOG.debug("Retry the download of object " + s3Object.getKey() + " (bucket " + s3Object
          .getBucketName() + ")", ace);
        hasRetried = true;
      }
      finally
      {
        s3Object.getObjectContent().abort();
      }
    }
  }
  
  private boolean canResumeDownload()
  {
    return (startByte != null) && (endByte != null);
  }
  
  private void adjustRequest(PresignedUrlDownloadRequest request)
  {
    long start = -1L;
    long end = -1L;
    if (request.getRange() != null)
    {
      long[] range = request.getRange();
      start = range[0];
      end = range[1];
    }
    else
    {
      start = startByte.longValue();
      end = endByte.longValue();
    }
    if (dstfile.exists())
    {
      if (!FileLocks.lock(dstfile)) {
        throw new FileLockException("Fail to lock " + dstfile + " for range adjustment");
      }
      try
      {
        expectedFileLength = dstfile.length();
        long newStart = start + expectedFileLength;
        LOG.debug("Adjusting request range from " + Arrays.toString(new long[] { start, end }) + " to " + 
          Arrays.toString(new long[] { newStart, end }) + " for file " + dstfile);
        
        request.setRange(newStart, end);
        
        long totalBytesToDownload = end - newStart + 1L;
        if (totalBytesToDownload < 0L) {
          throw new IllegalArgumentException("Unable to determine the range for download operation. lastByte=" + end + ", StartingByte=" + newStart + ", expectedFileLength=" + expectedFileLength + ", totalBytesToDownload=" + totalBytesToDownload);
        }
      }
      finally
      {
        FileLocks.unlock(dstfile);
      }
    }
  }
  
  private void downloadInParallelUsingRange()
    throws Exception
  {
    ServiceUtils.createParentDirectoryIfNecessary(dstfile);
    if (!FileLocks.lock(dstfile)) {
      throw new FileLockException("Fail to lock " + dstfile);
    }
    long currentStart = startByte.longValue();
    long currentEnd = 0L;
    long filePositionToWrite = 0L;
    while (currentStart <= endByte.longValue())
    {
      currentEnd = currentStart + perRequestDownloadSize - 1L;
      if (currentEnd > endByte.longValue()) {
        currentEnd = endByte.longValue();
      }
      PresignedUrlDownloadRequest rangeRequest = request.clone();
      rangeRequest.setRange(currentStart, currentEnd);
      
      Callable<S3Object> s3Object = serviceCall(rangeRequest);
      futures.add(executor.submit(new DownloadS3ObjectCallable(s3Object, dstfile, filePositionToWrite)));
      
      filePositionToWrite += perRequestDownloadSize;
      currentStart = currentEnd + 1L;
    }
    Future<File> future = executor.submit(completeAllFutures());
    
    ((DownloadMonitor)download.getMonitor()).setFuture(future);
  }
  
  private Callable<S3Object> serviceCall(final PresignedUrlDownloadRequest presignedUrlDownloadRequest)
  {
    new Callable()
    {
      public S3Object call()
        throws Exception
      {
        return 
          s3.download(presignedUrlDownloadRequest).getS3Object();
      }
    };
  }
  
  private Callable<File> completeAllFutures()
  {
    new Callable()
    {
      /* Error */
      public File call()
        throws Exception
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
        //   4: getfield 37	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:futures	Ljava/util/List;
        //   7: invokeinterface 43 1 0
        //   12: astore_1
        //   13: aload_1
        //   14: invokeinterface 49 1 0
        //   19: ifeq +23 -> 42
        //   22: aload_1
        //   23: invokeinterface 53 1 0
        //   28: checkcast 55	java/util/concurrent/Future
        //   31: astore_2
        //   32: aload_2
        //   33: invokeinterface 58 1 0
        //   38: pop
        //   39: goto -26 -> 13
        //   42: aload_0
        //   43: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
        //   46: invokestatic 62	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:access$100	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignedUrlDownloadImpl;
        //   49: getstatic 66	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/Transfer$TransferState:Completed	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/Transfer$TransferState;
        //   52: invokevirtual 72	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignedUrlDownloadImpl:setState	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/Transfer$TransferState;)V
        //   55: aload_0
        //   56: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
        //   59: getfield 76	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:dstfile	Ljava/io/File;
        //   62: invokestatic 82	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/internal/FileLocks:unlock	(Ljava/io/File;)Z
        //   65: pop
        //   66: goto +17 -> 83
        //   69: astore_3
        //   70: aload_0
        //   71: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
        //   74: getfield 76	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:dstfile	Ljava/io/File;
        //   77: invokestatic 82	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/internal/FileLocks:unlock	(Ljava/io/File;)Z
        //   80: pop
        //   81: aload_3
        //   82: athrow
        //   83: aload_0
        //   84: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
        //   87: getfield 76	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:dstfile	Ljava/io/File;
        //   90: areturn
        // Line number table:
        //   Java source line #265	-> byte code offset #0
        //   Java source line #266	-> byte code offset #32
        //   Java source line #267	-> byte code offset #39
        //   Java source line #269	-> byte code offset #42
        //   Java source line #271	-> byte code offset #55
        //   Java source line #272	-> byte code offset #66
        //   Java source line #271	-> byte code offset #69
        //   Java source line #272	-> byte code offset #81
        //   Java source line #274	-> byte code offset #83
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	91	0	this	2
        //   12	11	1	localIterator	java.util.Iterator
        //   31	2	2	future	Future<Long>
        //   69	13	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   0	55	69	finally
      }
    };
  }
  
  @SdkTestInternalApi
  public static void setTesting(boolean b)
  {
    testing = b;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PresignUrlDownloadCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */