package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeyPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeyPoliciesResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$28
  implements Callable<ListKeyPoliciesResult>
{
  AWSKMSAsyncClient$28(AWSKMSAsyncClient this$0, ListKeyPoliciesRequest paramListKeyPoliciesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListKeyPoliciesResult call()
    throws Exception
  {
    ListKeyPoliciesResult result = null;
    try
    {
      result = this$0.executeListKeyPolicies(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */