package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class GetUserFunction
  implements SdkFunction<GetUserRequest, GetUserResult>
{
  private final AmazonIdentityManagement client;
  
  public GetUserFunction(AmazonIdentityManagement client)
  {
    this.client = client;
  }
  
  public GetUserResult apply(GetUserRequest getUserRequest)
  {
    return client.getUser(getUserRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters.GetUserFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */