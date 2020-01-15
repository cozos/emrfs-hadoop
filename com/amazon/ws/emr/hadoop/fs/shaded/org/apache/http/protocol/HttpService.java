package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpServerConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.MethodNotSupportedException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.UnsupportedHttpVersionException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ByteArrayEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultHttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EncodingUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class HttpService
{
  private volatile HttpParams params = null;
  private volatile HttpProcessor processor = null;
  private volatile HttpRequestHandlerMapper handlerMapper = null;
  private volatile ConnectionReuseStrategy connStrategy = null;
  private volatile HttpResponseFactory responseFactory = null;
  private volatile HttpExpectationVerifier expectationVerifier = null;
  
  @Deprecated
  public HttpService(HttpProcessor processor, ConnectionReuseStrategy connStrategy, HttpResponseFactory responseFactory, HttpRequestHandlerResolver handlerResolver, HttpExpectationVerifier expectationVerifier, HttpParams params)
  {
    this(processor, connStrategy, responseFactory, new HttpRequestHandlerResolverAdapter(handlerResolver), expectationVerifier);
  }
  
  @Deprecated
  public HttpService(HttpProcessor processor, ConnectionReuseStrategy connStrategy, HttpResponseFactory responseFactory, HttpRequestHandlerResolver handlerResolver, HttpParams params)
  {
    this(processor, connStrategy, responseFactory, new HttpRequestHandlerResolverAdapter(handlerResolver), null);
  }
  
  @Deprecated
  public HttpService(HttpProcessor proc, ConnectionReuseStrategy connStrategy, HttpResponseFactory responseFactory)
  {
    setHttpProcessor(proc);
    setConnReuseStrategy(connStrategy);
    setResponseFactory(responseFactory);
  }
  
  public HttpService(HttpProcessor processor, ConnectionReuseStrategy connStrategy, HttpResponseFactory responseFactory, HttpRequestHandlerMapper handlerMapper, HttpExpectationVerifier expectationVerifier)
  {
    this.processor = ((HttpProcessor)Args.notNull(processor, "HTTP processor"));
    this.connStrategy = (connStrategy != null ? connStrategy : DefaultConnectionReuseStrategy.INSTANCE);
    
    this.responseFactory = (responseFactory != null ? responseFactory : DefaultHttpResponseFactory.INSTANCE);
    
    this.handlerMapper = handlerMapper;
    this.expectationVerifier = expectationVerifier;
  }
  
  public HttpService(HttpProcessor processor, ConnectionReuseStrategy connStrategy, HttpResponseFactory responseFactory, HttpRequestHandlerMapper handlerMapper)
  {
    this(processor, connStrategy, responseFactory, handlerMapper, null);
  }
  
  public HttpService(HttpProcessor processor, HttpRequestHandlerMapper handlerMapper)
  {
    this(processor, null, null, handlerMapper, null);
  }
  
  @Deprecated
  public void setHttpProcessor(HttpProcessor processor)
  {
    Args.notNull(processor, "HTTP processor");
    this.processor = processor;
  }
  
  @Deprecated
  public void setConnReuseStrategy(ConnectionReuseStrategy connStrategy)
  {
    Args.notNull(connStrategy, "Connection reuse strategy");
    this.connStrategy = connStrategy;
  }
  
  @Deprecated
  public void setResponseFactory(HttpResponseFactory responseFactory)
  {
    Args.notNull(responseFactory, "Response factory");
    this.responseFactory = responseFactory;
  }
  
  @Deprecated
  public void setParams(HttpParams params)
  {
    this.params = params;
  }
  
  @Deprecated
  public void setHandlerResolver(HttpRequestHandlerResolver handlerResolver)
  {
    handlerMapper = new HttpRequestHandlerResolverAdapter(handlerResolver);
  }
  
  @Deprecated
  public void setExpectationVerifier(HttpExpectationVerifier expectationVerifier)
  {
    this.expectationVerifier = expectationVerifier;
  }
  
  @Deprecated
  public HttpParams getParams()
  {
    return params;
  }
  
  public void handleRequest(HttpServerConnection conn, HttpContext context)
    throws IOException, HttpException
  {
    context.setAttribute("http.connection", conn);
    
    HttpRequest request = null;
    HttpResponse response = null;
    try
    {
      request = conn.receiveRequestHeader();
      if ((request instanceof HttpEntityEnclosingRequest)) {
        if (((HttpEntityEnclosingRequest)request).expectContinue())
        {
          response = responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, context);
          if (expectationVerifier != null) {
            try
            {
              expectationVerifier.verify(request, response, context);
            }
            catch (HttpException ex)
            {
              response = responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, context);
              
              handleException(ex, response);
            }
          }
          if (response.getStatusLine().getStatusCode() < 200)
          {
            conn.sendResponseHeader(response);
            conn.flush();
            response = null;
            conn.receiveRequestEntity((HttpEntityEnclosingRequest)request);
          }
        }
        else
        {
          conn.receiveRequestEntity((HttpEntityEnclosingRequest)request);
        }
      }
      context.setAttribute("http.request", request);
      if (response == null)
      {
        response = responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, context);
        
        processor.process(request, context);
        doService(request, response, context);
      }
      if ((request instanceof HttpEntityEnclosingRequest))
      {
        HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
        EntityUtils.consume(entity);
      }
    }
    catch (HttpException ex)
    {
      response = responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, context);
      
      handleException(ex, response);
    }
    context.setAttribute("http.response", response);
    
    processor.process(response, context);
    conn.sendResponseHeader(response);
    if (canResponseHaveBody(request, response)) {
      conn.sendResponseEntity(response);
    }
    conn.flush();
    if (!connStrategy.keepAlive(response, context)) {
      conn.close();
    }
  }
  
  private boolean canResponseHaveBody(HttpRequest request, HttpResponse response)
  {
    if ((request != null) && ("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod()))) {
      return false;
    }
    int status = response.getStatusLine().getStatusCode();
    return (status >= 200) && (status != 204) && (status != 304) && (status != 205);
  }
  
  protected void handleException(HttpException ex, HttpResponse response)
  {
    if ((ex instanceof MethodNotSupportedException)) {
      response.setStatusCode(501);
    } else if ((ex instanceof UnsupportedHttpVersionException)) {
      response.setStatusCode(505);
    } else if ((ex instanceof ProtocolException)) {
      response.setStatusCode(400);
    } else {
      response.setStatusCode(500);
    }
    String message = ex.getMessage();
    if (message == null) {
      message = ex.toString();
    }
    byte[] msg = EncodingUtils.getAsciiBytes(message);
    ByteArrayEntity entity = new ByteArrayEntity(msg);
    entity.setContentType("text/plain; charset=US-ASCII");
    response.setEntity(entity);
  }
  
  protected void doService(HttpRequest request, HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    HttpRequestHandler handler = null;
    if (handlerMapper != null) {
      handler = handlerMapper.lookup(request);
    }
    if (handler != null) {
      handler.handle(request, response, context);
    } else {
      response.setStatusCode(501);
    }
  }
  
  @Deprecated
  private static class HttpRequestHandlerResolverAdapter
    implements HttpRequestHandlerMapper
  {
    private final HttpRequestHandlerResolver resolver;
    
    public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver resolver)
    {
      this.resolver = resolver;
    }
    
    public HttpRequestHandler lookup(HttpRequest request)
    {
      return resolver.lookup(request.getRequestLine().getUri());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */