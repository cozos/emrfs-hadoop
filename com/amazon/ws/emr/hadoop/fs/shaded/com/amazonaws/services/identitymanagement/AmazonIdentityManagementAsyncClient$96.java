package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$96
  implements Callable<ListRolesResult>
{
  AmazonIdentityManagementAsyncClient$96(AmazonIdentityManagementAsyncClient this$0, ListRolesRequest paramListRolesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListRolesResult call()
    throws Exception
  {
    ListRolesResult result = null;
    try
    {
      result = this$0.executeListRoles(val$finalRequest);
    }
    catch (Exception ex)
    {
      if (val$asyncHandler != null) {
        val$asyncHandler.onError(ex);
      }
      throw ex;
    }
    if (val$asyncHandler != null) {
      val$asyncHandler.onSuccess(val$finalRequest, result);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.96
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */