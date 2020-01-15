package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateOpenIDConnectProviderThumbprintRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateOpenIDConnectProviderThumbprintResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$129
  implements Callable<UpdateOpenIDConnectProviderThumbprintResult>
{
  AmazonIdentityManagementAsyncClient$129(AmazonIdentityManagementAsyncClient this$0, UpdateOpenIDConnectProviderThumbprintRequest paramUpdateOpenIDConnectProviderThumbprintRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateOpenIDConnectProviderThumbprintResult call()
    throws Exception
  {
    UpdateOpenIDConnectProviderThumbprintResult result = null;
    try
    {
      result = this$0.executeUpdateOpenIDConnectProviderThumbprint(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.129
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */