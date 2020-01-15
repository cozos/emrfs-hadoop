package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ServiceUnavailableRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
public class AutoRetryHttpClient
  implements HttpClient
{
  private final HttpClient backend;
  private final ServiceUnavailableRetryStrategy retryStrategy;
  private final Log log = LogFactory.getLog(getClass());
  
  public AutoRetryHttpClient(HttpClient client, ServiceUnavailableRetryStrategy retryStrategy)
  {
    Args.notNull(client, "HttpClient");
    Args.notNull(retryStrategy, "ServiceUnavailableRetryStrategy");
    backend = client;
    this.retryStrategy = retryStrategy;
  }
  
  public AutoRetryHttpClient()
  {
    this(new DefaultHttpClient(), new DefaultServiceUnavailableRetryStrategy());
  }
  
  public AutoRetryHttpClient(ServiceUnavailableRetryStrategy config)
  {
    this(new DefaultHttpClient(), config);
  }
  
  public AutoRetryHttpClient(HttpClient client)
  {
    this(client, new DefaultServiceUnavailableRetryStrategy());
  }
  
  public HttpResponse execute(HttpHost target, HttpRequest request)
    throws IOException
  {
    HttpContext defaultContext = null;
    return execute(target, request, defaultContext);
  }
  
  public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler)
    throws IOException
  {
    return (T)execute(target, request, responseHandler, null);
  }
  
  public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context)
    throws IOException
  {
    HttpResponse resp = execute(target, request, context);
    return (T)responseHandler.handleResponse(resp);
  }
  
  public HttpResponse execute(HttpUriRequest request)
    throws IOException
  {
    HttpContext context = null;
    return execute(request, context);
  }
  
  public HttpResponse execute(HttpUriRequest request, HttpContext context)
    throws IOException
  {
    URI uri = request.getURI();
    HttpHost httpHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
    
    return execute(httpHost, request, context);
  }
  
  public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler)
    throws IOException
  {
    return (T)execute(request, responseHandler, null);
  }
  
  public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context)
    throws IOException
  {
    HttpResponse resp = execute(request, context);
    return (T)responseHandler.handleResponse(resp);
  }
  
  public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context)
    throws IOException
  {
    for (int c = 1;; c++)
    {
      HttpResponse response = backend.execute(target, request, context);
      try
      {
        if (retryStrategy.retryRequest(response, c, context))
        {
          EntityUtils.consume(response.getEntity());
          long nextInterval = retryStrategy.getRetryInterval();
          try
          {
            log.trace("Wait for " + nextInterval);
            Thread.sleep(nextInterval);
          }
          catch (InterruptedException e)
          {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
          }
        }
        else
        {
          return response;
        }
      }
      catch (RuntimeException ex)
      {
        try
        {
          EntityUtils.consume(response.getEntity());
        }
        catch (IOException ioex)
        {
          log.warn("I/O error consuming response content", ioex);
        }
        throw ex;
      }
    }
  }
  
  public ClientConnectionManager getConnectionManager()
  {
    return backend.getConnectionManager();
  }
  
  public HttpParams getParams()
  {
    return backend.getParams();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.AutoRetryHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */