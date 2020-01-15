package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccountAliasesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccountAliasesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$79
  implements Callable<ListAccountAliasesResult>
{
  AmazonIdentityManagementAsyncClient$79(AmazonIdentityManagementAsyncClient this$0, ListAccountAliasesRequest paramListAccountAliasesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListAccountAliasesResult call()
    throws Exception
  {
    ListAccountAliasesResult result = null;
    try
    {
      result = this$0.executeListAccountAliases(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.79
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */