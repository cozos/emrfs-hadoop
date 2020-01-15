package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ClientProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CookieStore;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.Configurable;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.params.HttpClientParamConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Lookup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoutePlanner;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieSpecProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.ClientExecChain;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParamsNames;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.BasicHttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
class InternalHttpClient
  extends CloseableHttpClient
  implements Configurable
{
  private final Log log = LogFactory.getLog(getClass());
  private final ClientExecChain execChain;
  private final HttpClientConnectionManager connManager;
  private final HttpRoutePlanner routePlanner;
  private final Lookup<CookieSpecProvider> cookieSpecRegistry;
  private final Lookup<AuthSchemeProvider> authSchemeRegistry;
  private final CookieStore cookieStore;
  private final CredentialsProvider credentialsProvider;
  private final RequestConfig defaultConfig;
  private final List<Closeable> closeables;
  
  public InternalHttpClient(ClientExecChain execChain, HttpClientConnectionManager connManager, HttpRoutePlanner routePlanner, Lookup<CookieSpecProvider> cookieSpecRegistry, Lookup<AuthSchemeProvider> authSchemeRegistry, CookieStore cookieStore, CredentialsProvider credentialsProvider, RequestConfig defaultConfig, List<Closeable> closeables)
  {
    Args.notNull(execChain, "HTTP client exec chain");
    Args.notNull(connManager, "HTTP connection manager");
    Args.notNull(routePlanner, "HTTP route planner");
    this.execChain = execChain;
    this.connManager = connManager;
    this.routePlanner = routePlanner;
    this.cookieSpecRegistry = cookieSpecRegistry;
    this.authSchemeRegistry = authSchemeRegistry;
    this.cookieStore = cookieStore;
    this.credentialsProvider = credentialsProvider;
    this.defaultConfig = defaultConfig;
    this.closeables = closeables;
  }
  
  private HttpRoute determineRoute(HttpHost target, HttpRequest request, HttpContext context)
    throws HttpException
  {
    HttpHost host = target;
    if (host == null) {
      host = (HttpHost)request.getParams().getParameter("http.default-host");
    }
    return routePlanner.determineRoute(host, request, context);
  }
  
  private void setupContext(HttpClientContext context)
  {
    if (context.getAttribute("http.auth.target-scope") == null) {
      context.setAttribute("http.auth.target-scope", new AuthState());
    }
    if (context.getAttribute("http.auth.proxy-scope") == null) {
      context.setAttribute("http.auth.proxy-scope", new AuthState());
    }
    if (context.getAttribute("http.authscheme-registry") == null) {
      context.setAttribute("http.authscheme-registry", authSchemeRegistry);
    }
    if (context.getAttribute("http.cookiespec-registry") == null) {
      context.setAttribute("http.cookiespec-registry", cookieSpecRegistry);
    }
    if (context.getAttribute("http.cookie-store") == null) {
      context.setAttribute("http.cookie-store", cookieStore);
    }
    if (context.getAttribute("http.auth.credentials-provider") == null) {
      context.setAttribute("http.auth.credentials-provider", credentialsProvider);
    }
    if (context.getAttribute("http.request-config") == null) {
      context.setAttribute("http.request-config", defaultConfig);
    }
  }
  
  protected CloseableHttpResponse doExecute(HttpHost target, HttpRequest request, HttpContext context)
    throws IOException, ClientProtocolException
  {
    Args.notNull(request, "HTTP request");
    HttpExecutionAware execAware = null;
    if ((request instanceof HttpExecutionAware)) {
      execAware = (HttpExecutionAware)request;
    }
    try
    {
      HttpRequestWrapper wrapper = HttpRequestWrapper.wrap(request, target);
      HttpClientContext localcontext = HttpClientContext.adapt(context != null ? context : new BasicHttpContext());
      
      RequestConfig config = null;
      if ((request instanceof Configurable)) {
        config = ((Configurable)request).getConfig();
      }
      if (config == null)
      {
        HttpParams params = request.getParams();
        if ((params instanceof HttpParamsNames))
        {
          if (!((HttpParamsNames)params).getNames().isEmpty()) {
            config = HttpClientParamConfig.getRequestConfig(params, defaultConfig);
          }
        }
        else {
          config = HttpClientParamConfig.getRequestConfig(params, defaultConfig);
        }
      }
      if (config != null) {
        localcontext.setRequestConfig(config);
      }
      setupContext(localcontext);
      HttpRoute route = determineRoute(target, wrapper, localcontext);
      return execChain.execute(route, wrapper, localcontext, execAware);
    }
    catch (HttpException httpException)
    {
      throw new ClientProtocolException(httpException);
    }
  }
  
  public RequestConfig getConfig()
  {
    return defaultConfig;
  }
  
  public void close()
  {
    if (closeables != null) {
      for (Closeable closeable : closeables) {
        try
        {
          closeable.close();
        }
        catch (IOException ex)
        {
          log.error(ex.getMessage(), ex);
        }
      }
    }
  }
  
  public HttpParams getParams()
  {
    throw new UnsupportedOperationException();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.InternalHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */