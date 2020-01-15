package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ResponseHeaderHandlerChain<T>
  extends S3XmlResponseHandler<T>
{
  private final List<HeaderHandler<T>> headerHandlers;
  
  public ResponseHeaderHandlerChain(Unmarshaller<T, InputStream> responseUnmarshaller, HeaderHandler<T>... headerHandlers)
  {
    super(responseUnmarshaller);
    this.headerHandlers = Arrays.asList(headerHandlers);
  }
  
  public AmazonWebServiceResponse<T> handle(HttpResponse response)
    throws Exception
  {
    AmazonWebServiceResponse<T> awsResponse = super.handle(response);
    
    T result = awsResponse.getResult();
    if (result != null) {
      for (HeaderHandler<T> handler : headerHandlers) {
        handler.handle(result, response);
      }
    }
    return awsResponse;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ResponseHeaderHandlerChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */