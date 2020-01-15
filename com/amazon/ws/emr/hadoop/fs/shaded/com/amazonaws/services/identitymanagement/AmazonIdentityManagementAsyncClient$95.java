package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRoleTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRoleTagsResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$95
  implements Callable<ListRoleTagsResult>
{
  AmazonIdentityManagementAsyncClient$95(AmazonIdentityManagementAsyncClient this$0, ListRoleTagsRequest paramListRoleTagsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListRoleTagsResult call()
    throws Exception
  {
    ListRoleTagsResult result = null;
    try
    {
      result = this$0.executeListRoleTags(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.95
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */