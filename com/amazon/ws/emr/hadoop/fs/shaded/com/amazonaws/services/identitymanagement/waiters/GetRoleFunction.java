package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class GetRoleFunction
  implements SdkFunction<GetRoleRequest, GetRoleResult>
{
  private final AmazonIdentityManagement client;
  
  public GetRoleFunction(AmazonIdentityManagement client)
  {
    this.client = client;
  }
  
  public GetRoleResult apply(GetRoleRequest getRoleRequest)
  {
    return client.getRole(getRoleRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters.GetRoleFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */