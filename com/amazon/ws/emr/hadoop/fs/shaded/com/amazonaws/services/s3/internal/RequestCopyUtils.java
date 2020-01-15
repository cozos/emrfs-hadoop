package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;

@SdkInternalApi
public class RequestCopyUtils
{
  public static GetObjectMetadataRequest createGetObjectMetadataRequestFrom(GetObjectRequest getObjectRequest)
  {
    return 
    
      new GetObjectMetadataRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey()).withVersionId(getObjectRequest.getVersionId()).withRequesterPays(getObjectRequest.isRequesterPays()).withSSECustomerKey(getObjectRequest.getSSECustomerKey()).withPartNumber(getObjectRequest.getPartNumber());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.RequestCopyUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */