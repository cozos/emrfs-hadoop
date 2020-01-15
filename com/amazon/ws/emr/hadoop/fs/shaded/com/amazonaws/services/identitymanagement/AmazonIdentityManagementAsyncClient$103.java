package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserTagsResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$103
  implements Callable<ListUserTagsResult>
{
  AmazonIdentityManagementAsyncClient$103(AmazonIdentityManagementAsyncClient this$0, ListUserTagsRequest paramListUserTagsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListUserTagsResult call()
    throws Exception
  {
    ListUserTagsResult result = null;
    try
    {
      result = this$0.executeListUserTags(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.103
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */