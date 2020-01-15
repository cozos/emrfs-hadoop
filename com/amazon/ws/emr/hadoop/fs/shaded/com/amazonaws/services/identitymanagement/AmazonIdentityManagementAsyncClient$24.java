package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountAliasResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$24
  implements Callable<DeleteAccountAliasResult>
{
  AmazonIdentityManagementAsyncClient$24(AmazonIdentityManagementAsyncClient this$0, DeleteAccountAliasRequest paramDeleteAccountAliasRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteAccountAliasResult call()
    throws Exception
  {
    DeleteAccountAliasResult result = null;
    try
    {
      result = this$0.executeDeleteAccountAlias(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.24
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */