package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetParametersForImportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetParametersForImportResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$24
  implements Callable<GetParametersForImportResult>
{
  AWSKMSAsyncClient$24(AWSKMSAsyncClient this$0, GetParametersForImportRequest paramGetParametersForImportRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetParametersForImportResult call()
    throws Exception
  {
    GetParametersForImportResult result = null;
    try
    {
      result = this$0.executeGetParametersForImport(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.24
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */