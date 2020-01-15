package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException.ErrorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;

@SdkInternalApi
class AwsErrorResponseHandler
  implements HttpResponseHandler<AmazonServiceException>
{
  private final HttpResponseHandler<AmazonServiceException> delegate;
  private final AWSRequestMetrics awsRequestMetrics;
  
  AwsErrorResponseHandler(HttpResponseHandler<AmazonServiceException> errorResponseHandler, AWSRequestMetrics awsRequestMetrics)
  {
    delegate = errorResponseHandler;
    this.awsRequestMetrics = awsRequestMetrics;
  }
  
  public AmazonServiceException handle(HttpResponse response)
    throws Exception
  {
    AmazonServiceException ase = handleAse(response);
    ase.setStatusCode(response.getStatusCode());
    ase.setServiceName(response.getRequest().getServiceName());
    awsRequestMetrics.addPropertyWith(AWSRequestMetrics.Field.AWSRequestID, ase.getRequestId())
      .addPropertyWith(AWSRequestMetrics.Field.AWSErrorCode, ase.getErrorCode())
      .addPropertyWith(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(ase.getStatusCode()));
    return ase;
  }
  
  private AmazonServiceException handleAse(HttpResponse response)
    throws Exception
  {
    int statusCode = response.getStatusCode();
    try
    {
      return (AmazonServiceException)delegate.handle(response);
    }
    catch (InterruptedException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      if (statusCode == 413)
      {
        AmazonServiceException exception = new AmazonServiceException("Request entity too large");
        exception.setServiceName(response.getRequest().getServiceName());
        exception.setStatusCode(statusCode);
        exception.setErrorType(AmazonServiceException.ErrorType.Client);
        exception.setErrorCode("Request entity too large");
        return exception;
      }
      if ((statusCode >= 500) && (statusCode < 600))
      {
        AmazonServiceException exception = new AmazonServiceException(response.getStatusText());
        exception.setServiceName(response.getRequest().getServiceName());
        exception.setStatusCode(statusCode);
        exception.setErrorType(AmazonServiceException.ErrorType.Service);
        exception.setErrorCode(response.getStatusText());
        return exception;
      }
      throw e;
    }
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return delegate.needsConnectionLeftOpen();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AwsErrorResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */