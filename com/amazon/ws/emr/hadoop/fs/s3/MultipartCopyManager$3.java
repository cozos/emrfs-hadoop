package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.slf4j.Logger;

class MultipartCopyManager$3
  implements Callable<String>
{
  MultipartCopyManager$3(MultipartCopyManager this$0, List paramList, String paramString) {}
  
  public String call()
    throws Exception
  {
    try
    {
      List<PartETag> partETags = Lists.newArrayList();
      int i = 0;
      for (Future<CopyPartResult> copyPartFuture : val$copyPartFutures)
      {
        boolean log = false;
        if (!copyPartFuture.isDone())
        {
          log = true;
          MultipartCopyManager.LOG.debug("Waiting for part " + i);
        }
        CopyPartResult copyPartResult = (CopyPartResult)copyPartFuture.get();
        if (log) {
          MultipartCopyManager.LOG.debug("Done waiting for part " + copyPartResult.getPartNumber());
        }
        partETags.add(copyPartResult.getPartETag());
      }
      MultipartCopyManager.access$2000(this$0, new CompleteMultipartUploadRequest(
        MultipartCopyManager.access$1800(this$0), MultipartCopyManager.access$1900(this$0), val$uploadId, partETags));
    }
    catch (ExecutionException|InterruptedException e)
    {
      MultipartCopyManager.LOG.error(String.format("Failed to copy from '%s/%s' to '%s/%s'. Trying to abort multipart upload: %s", new Object[] {
        MultipartCopyManager.access$2100(this$0), MultipartCopyManager.access$2200(this$0), MultipartCopyManager.access$1800(this$0), MultipartCopyManager.access$1900(this$0), val$uploadId }), e);
      AbortMultipartUploadRequest request = new AbortMultipartUploadRequest(MultipartCopyManager.access$1800(this$0), MultipartCopyManager.access$1900(this$0), val$uploadId);
      try
      {
        MultipartCopyManager.access$1700(this$0).abortMultipartUpload(request);
        MultipartCopyManager.LOG.info(String.format("Aborted multipart upload: %s", new Object[] { val$uploadId }));
      }
      catch (AmazonClientException amazonClientException)
      {
        MultipartCopyManager.LOG.error(String.format("Failed to abort multipart upload: %s", new Object[] { val$uploadId }), amazonClientException);
      }
      throw new IOException(e);
    }
    return MultipartCopyManager.access$1900(this$0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartCopyManager.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */