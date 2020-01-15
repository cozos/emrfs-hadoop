package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccessKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccessKeyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$23
  implements Callable<DeleteAccessKeyResult>
{
  AmazonIdentityManagementAsyncClient$23(AmazonIdentityManagementAsyncClient this$0, DeleteAccessKeyRequest paramDeleteAccessKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteAccessKeyResult call()
    throws Exception
  {
    DeleteAccessKeyResult result = null;
    try
    {
      result = this$0.executeDeleteAccessKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */