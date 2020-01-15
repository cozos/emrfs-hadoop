package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceLinkedRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceLinkedRoleResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$18
  implements Callable<CreateServiceLinkedRoleResult>
{
  AmazonIdentityManagementAsyncClient$18(AmazonIdentityManagementAsyncClient this$0, CreateServiceLinkedRoleRequest paramCreateServiceLinkedRoleRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateServiceLinkedRoleResult call()
    throws Exception
  {
    CreateServiceLinkedRoleResult result = null;
    try
    {
      result = this$0.executeCreateServiceLinkedRole(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */