package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterState;

@SdkInternalApi
class RoleExists
{
  static class IsNoSuchEntityMatcher
    extends WaiterAcceptor<GetRoleResult>
  {
    public boolean matches(AmazonServiceException e)
    {
      return "NoSuchEntity".equals(e.getErrorCode());
    }
    
    public WaiterState getState()
    {
      return WaiterState.RETRY;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters.RoleExists
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */