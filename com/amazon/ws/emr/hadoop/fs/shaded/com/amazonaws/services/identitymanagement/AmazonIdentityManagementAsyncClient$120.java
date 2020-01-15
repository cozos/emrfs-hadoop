package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagRoleResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$120
  implements Callable<TagRoleResult>
{
  AmazonIdentityManagementAsyncClient$120(AmazonIdentityManagementAsyncClient this$0, TagRoleRequest paramTagRoleRequest, AsyncHandler paramAsyncHandler) {}
  
  public TagRoleResult call()
    throws Exception
  {
    TagRoleResult result = null;
    try
    {
      result = this$0.executeTagRole(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.120
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */