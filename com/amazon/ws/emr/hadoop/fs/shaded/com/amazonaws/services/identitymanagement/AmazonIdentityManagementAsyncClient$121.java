package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.TagUserResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$121
  implements Callable<TagUserResult>
{
  AmazonIdentityManagementAsyncClient$121(AmazonIdentityManagementAsyncClient this$0, TagUserRequest paramTagUserRequest, AsyncHandler paramAsyncHandler) {}
  
  public TagUserResult call()
    throws Exception
  {
    TagUserResult result = null;
    try
    {
      result = this$0.executeTagUser(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.121
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */