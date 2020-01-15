package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class GetInstanceProfileFunction
  implements SdkFunction<GetInstanceProfileRequest, GetInstanceProfileResult>
{
  private final AmazonIdentityManagement client;
  
  public GetInstanceProfileFunction(AmazonIdentityManagement client)
  {
    this.client = client;
  }
  
  public GetInstanceProfileResult apply(GetInstanceProfileRequest getInstanceProfileRequest)
  {
    return client.getInstanceProfile(getInstanceProfileRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters.GetInstanceProfileFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */