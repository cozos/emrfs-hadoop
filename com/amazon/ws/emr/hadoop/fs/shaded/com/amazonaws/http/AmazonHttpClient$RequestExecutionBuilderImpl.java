package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.AmazonWebServiceRequestAdapter;
import java.util.Collections;
import java.util.List;

class AmazonHttpClient$RequestExecutionBuilderImpl
  implements AmazonHttpClient.RequestExecutionBuilder
{
  private Request<?> request;
  private RequestConfig requestConfig;
  private HttpResponseHandler<? extends SdkBaseException> errorResponseHandler;
  private ExecutionContext executionContext = new ExecutionContext();
  
  private AmazonHttpClient$RequestExecutionBuilderImpl(AmazonHttpClient paramAmazonHttpClient) {}
  
  public AmazonHttpClient.RequestExecutionBuilder request(Request<?> request)
  {
    this.request = request;
    return this;
  }
  
  public AmazonHttpClient.RequestExecutionBuilder errorResponseHandler(HttpResponseHandler<? extends SdkBaseException> errorResponseHandler)
  {
    this.errorResponseHandler = errorResponseHandler;
    return this;
  }
  
  public AmazonHttpClient.RequestExecutionBuilder executionContext(ExecutionContext executionContext)
  {
    this.executionContext = executionContext;
    return this;
  }
  
  public AmazonHttpClient.RequestExecutionBuilder requestConfig(RequestConfig requestConfig)
  {
    this.requestConfig = requestConfig;
    return this;
  }
  
  public <Output> Response<Output> execute(HttpResponseHandler<Output> responseHandler)
  {
    RequestConfig config = requestConfig != null ? requestConfig : new AmazonWebServiceRequestAdapter(request.getOriginalRequest());
    return 
    
      AmazonHttpClient.RequestExecutor.access$500(new AmazonHttpClient.RequestExecutor(this$0, request, config, AmazonHttpClient.access$300(this$0, errorResponseHandler), AmazonHttpClient.access$300(this$0, responseHandler), executionContext, getRequestHandlers(), null));
  }
  
  public Response<Void> execute()
  {
    return execute(null);
  }
  
  private List<RequestHandler2> getRequestHandlers()
  {
    List<RequestHandler2> requestHandler2s = executionContext.getRequestHandler2s();
    if (requestHandler2s == null) {
      return Collections.emptyList();
    }
    return requestHandler2s;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient.RequestExecutionBuilderImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */