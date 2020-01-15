package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import java.util.concurrent.Callable;

class MultipartCopyManager$2
  implements Callable<CopyPartResult>
{
  MultipartCopyManager$2(MultipartCopyManager this$0, CopyPartRequest paramCopyPartRequest) {}
  
  public CopyPartResult call()
    throws Exception
  {
    return MultipartCopyManager.access$1700(this$0).copyPart(val$copyPartRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.MultipartCopyManager.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */