package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;

@SdkInternalApi
public abstract interface UploadObjectStrategy<RequestT, ResponseT>
{
  public abstract ObjectMetadata invokeServiceCall(Request<RequestT> paramRequest);
  
  public abstract ResponseT createResult(ObjectMetadata paramObjectMetadata, String paramString);
  
  public abstract String md5ValidationErrorSuffix();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.UploadObjectStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */