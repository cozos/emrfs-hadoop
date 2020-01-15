package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;

abstract class AbstractS3GenericCall<O, I extends AmazonWebServiceRequest>
  extends AbstractS3Call<O, I, AmazonS3>
  implements S3GenericCall<O>
{
  public AbstractS3GenericCall(I request)
  {
    super(request);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.AbstractS3GenericCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */