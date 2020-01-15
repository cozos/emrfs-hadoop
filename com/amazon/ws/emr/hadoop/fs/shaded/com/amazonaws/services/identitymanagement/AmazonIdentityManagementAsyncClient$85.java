package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$85
  implements Callable<ListGroupsResult>
{
  AmazonIdentityManagementAsyncClient$85(AmazonIdentityManagementAsyncClient this$0, ListGroupsRequest paramListGroupsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListGroupsResult call()
    throws Exception
  {
    ListGroupsResult result = null;
    try
    {
      result = this$0.executeListGroups(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.85
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */