package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$20
  implements Callable<GenerateDataKeyWithoutPlaintextResult>
{
  AWSKMSAsyncClient$20(AWSKMSAsyncClient this$0, GenerateDataKeyWithoutPlaintextRequest paramGenerateDataKeyWithoutPlaintextRequest, AsyncHandler paramAsyncHandler) {}
  
  public GenerateDataKeyWithoutPlaintextResult call()
    throws Exception
  {
    GenerateDataKeyWithoutPlaintextResult result = null;
    try
    {
      result = this$0.executeGenerateDataKeyWithoutPlaintext(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */