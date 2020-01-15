package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import java.util.concurrent.Callable;

class DownloadCallable$1
  implements Callable<S3Object>
{
  DownloadCallable$1(DownloadCallable this$0, GetObjectRequest paramGetObjectRequest) {}
  
  public S3Object call()
    throws Exception
  {
    return DownloadCallable.access$000(this$0).getObject(val$request);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.DownloadCallable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */