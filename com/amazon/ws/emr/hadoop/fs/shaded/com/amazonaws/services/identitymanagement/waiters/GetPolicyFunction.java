package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class GetPolicyFunction
  implements SdkFunction<GetPolicyRequest, GetPolicyResult>
{
  private final AmazonIdentityManagement client;
  
  public GetPolicyFunction(AmazonIdentityManagement client)
  {
    this.client = client;
  }
  
  public GetPolicyResult apply(GetPolicyRequest getPolicyRequest)
  {
    return client.getPolicy(getPolicyRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters.GetPolicyFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */