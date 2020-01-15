package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccountAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccountAliasResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$9
  implements Callable<CreateAccountAliasResult>
{
  AmazonIdentityManagementAsyncClient$9(AmazonIdentityManagementAsyncClient this$0, CreateAccountAliasRequest paramCreateAccountAliasRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateAccountAliasResult call()
    throws Exception
  {
    CreateAccountAliasResult result = null;
    try
    {
      result = this$0.executeCreateAccountAlias(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */