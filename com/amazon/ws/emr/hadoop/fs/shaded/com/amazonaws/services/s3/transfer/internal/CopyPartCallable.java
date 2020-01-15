package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import java.util.concurrent.Callable;

public class CopyPartCallable
  implements Callable<PartETag>
{
  private final AmazonS3 s3;
  private final CopyPartRequest request;
  
  public CopyPartCallable(AmazonS3 s3, CopyPartRequest request)
  {
    this.s3 = s3;
    this.request = request;
  }
  
  public PartETag call()
    throws Exception
  {
    return s3.copyPart(request).getPartETag();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CopyPartCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */