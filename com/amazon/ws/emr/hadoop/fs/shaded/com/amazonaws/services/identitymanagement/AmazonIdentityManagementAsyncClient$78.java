package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccessKeysRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccessKeysResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$78
  implements Callable<ListAccessKeysResult>
{
  AmazonIdentityManagementAsyncClient$78(AmazonIdentityManagementAsyncClient this$0, ListAccessKeysRequest paramListAccessKeysRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListAccessKeysResult call()
    throws Exception
  {
    ListAccessKeysResult result = null;
    try
    {
      result = this$0.executeListAccessKeys(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.78
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */