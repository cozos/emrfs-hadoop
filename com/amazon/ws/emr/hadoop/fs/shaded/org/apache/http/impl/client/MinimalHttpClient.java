package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ClientProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.Configurable;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.MinimalClientExec;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.BasicHttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.BasicHttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpRequestExecutor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
class MinimalHttpClient
  extends CloseableHttpClient
{
  private final HttpClientConnectionManager connManager;
  private final MinimalClientExec requestExecutor;
  private final HttpParams params;
  
  public MinimalHttpClient(HttpClientConnectionManager connManager)
  {
    this.connManager = ((HttpClientConnectionManager)Args.notNull(connManager, "HTTP connection manager"));
    requestExecutor = new MinimalClientExec(new HttpRequestExecutor(), connManager, DefaultConnectionReuseStrategy.INSTANCE, DefaultConnectionKeepAliveStrategy.INSTANCE);
    
    params = new BasicHttpParams();
  }
  
  protected CloseableHttpResponse doExecute(HttpHost target, HttpRequest request, HttpContext context)
    throws IOException, ClientProtocolException
  {
    Args.notNull(target, "Target host");
    Args.notNull(request, "HTTP request");
    HttpExecutionAware execAware = null;
    if ((request instanceof HttpExecutionAware)) {
      execAware = (HttpExecutionAware)request;
    }
    try
    {
      HttpRequestWrapper wrapper = HttpRequestWrapper.wrap(request);
      HttpClientContext localcontext = HttpClientContext.adapt(context != null ? context : new BasicHttpContext());
      
      HttpRoute route = new HttpRoute(target);
      RequestConfig config = null;
      if ((request instanceof Configurable)) {
        config = ((Configurable)request).getConfig();
      }
      if (config != null) {
        localcontext.setRequestConfig(config);
      }
      return requestExecutor.execute(route, wrapper, localcontext, execAware);
    }
    catch (HttpException httpException)
    {
      throw new ClientProtocolException(httpException);
    }
  }
  
  public HttpParams getParams()
  {
    return params;
  }
  
  public void close()
  {
    connManager.shutdown();
  }
  
  public ClientConnectionManager getConnectionManager()
  {
    new ClientConnectionManager()
    {
      public void shutdown()
      {
        connManager.shutdown();
      }
      
      public ClientConnectionRequest requestConnection(HttpRoute route, Object state)
      {
        throw new UnsupportedOperationException();
      }
      
      public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit)
      {
        throw new UnsupportedOperationException();
      }
      
      public SchemeRegistry getSchemeRegistry()
      {
        throw new UnsupportedOperationException();
      }
      
      public void closeIdleConnections(long idletime, TimeUnit tunit)
      {
        connManager.closeIdleConnections(idletime, tunit);
      }
      
      public void closeExpiredConnections()
      {
        connManager.closeExpiredConnections();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.MinimalHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */