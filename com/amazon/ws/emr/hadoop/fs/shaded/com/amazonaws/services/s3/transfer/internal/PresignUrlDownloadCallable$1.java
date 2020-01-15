package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import java.util.concurrent.Callable;

class PresignUrlDownloadCallable$1
  implements Callable<S3Object>
{
  PresignUrlDownloadCallable$1(PresignUrlDownloadCallable this$0, PresignedUrlDownloadRequest paramPresignedUrlDownloadRequest) {}
  
  public S3Object call()
    throws Exception
  {
    return 
      PresignUrlDownloadCallable.access$000(this$0).download(val$presignedUrlDownloadRequest).getS3Object();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PresignUrlDownloadCallable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */