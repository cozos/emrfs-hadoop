package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSSHPublicKeysRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSSHPublicKeysResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$98
  implements Callable<ListSSHPublicKeysResult>
{
  AmazonIdentityManagementAsyncClient$98(AmazonIdentityManagementAsyncClient this$0, ListSSHPublicKeysRequest paramListSSHPublicKeysRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListSSHPublicKeysResult call()
    throws Exception
  {
    ListSSHPublicKeysResult result = null;
    try
    {
      result = this$0.executeListSSHPublicKeys(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.98
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */