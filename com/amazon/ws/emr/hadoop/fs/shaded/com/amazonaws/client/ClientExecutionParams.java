package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

@SdkProtectedApi
@NotThreadSafe
public class ClientExecutionParams<Input, Output>
{
  private Input input;
  private Marshaller<Request<Input>, Input> marshaller;
  private HttpResponseHandler<Output> responseHandler;
  private HttpResponseHandler<? extends SdkBaseException> errorResponseHandler;
  private RequestConfig requestConfig;
  
  public Marshaller<Request<Input>, Input> getMarshaller()
  {
    return marshaller;
  }
  
  public ClientExecutionParams<Input, Output> withMarshaller(Marshaller<Request<Input>, Input> marshaller)
  {
    this.marshaller = marshaller;
    return this;
  }
  
  public Input getInput()
  {
    return (Input)input;
  }
  
  public ClientExecutionParams<Input, Output> withInput(Input input)
  {
    this.input = input;
    return this;
  }
  
  public HttpResponseHandler<Output> getResponseHandler()
  {
    return responseHandler;
  }
  
  public ClientExecutionParams<Input, Output> withResponseHandler(HttpResponseHandler<Output> responseHandler)
  {
    this.responseHandler = responseHandler;
    return this;
  }
  
  public HttpResponseHandler<? extends SdkBaseException> getErrorResponseHandler()
  {
    return errorResponseHandler;
  }
  
  public ClientExecutionParams<Input, Output> withErrorResponseHandler(HttpResponseHandler<? extends SdkBaseException> errorResponseHandler)
  {
    this.errorResponseHandler = errorResponseHandler;
    return this;
  }
  
  public RequestConfig getRequestConfig()
  {
    return requestConfig;
  }
  
  public ClientExecutionParams<Input, Output> withRequestConfig(RequestConfig requestConfig)
  {
    this.requestConfig = requestConfig;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.ClientExecutionParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */