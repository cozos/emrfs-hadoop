package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestClientConnControl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.URIUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionKeepAliveStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.ConnectionShutdownException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpProcessor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpRequestExecutor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.ImmutableHttpProcessor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestContent;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestTargetHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestUserAgent;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.VersionInfo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class MinimalClientExec
  implements ClientExecChain
{
  private final Log log = LogFactory.getLog(getClass());
  private final HttpRequestExecutor requestExecutor;
  private final HttpClientConnectionManager connManager;
  private final ConnectionReuseStrategy reuseStrategy;
  private final ConnectionKeepAliveStrategy keepAliveStrategy;
  private final HttpProcessor httpProcessor;
  
  public MinimalClientExec(HttpRequestExecutor requestExecutor, HttpClientConnectionManager connManager, ConnectionReuseStrategy reuseStrategy, ConnectionKeepAliveStrategy keepAliveStrategy)
  {
    Args.notNull(requestExecutor, "HTTP request executor");
    Args.notNull(connManager, "Client connection manager");
    Args.notNull(reuseStrategy, "Connection reuse strategy");
    Args.notNull(keepAliveStrategy, "Connection keep alive strategy");
    httpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[] { new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(VersionInfo.getUserAgent("Apache-HttpClient", "com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client", getClass())) });
    
    this.requestExecutor = requestExecutor;
    this.connManager = connManager;
    this.reuseStrategy = reuseStrategy;
    this.keepAliveStrategy = keepAliveStrategy;
  }
  
  static void rewriteRequestURI(HttpRequestWrapper request, HttpRoute route)
    throws ProtocolException
  {
    try
    {
      URI uri = request.getURI();
      if (uri != null)
      {
        if (uri.isAbsolute()) {
          uri = URIUtils.rewriteURI(uri, null, true);
        } else {
          uri = URIUtils.rewriteURI(uri);
        }
        request.setURI(uri);
      }
    }
    catch (URISyntaxException ex)
    {
      throw new ProtocolException("Invalid URI: " + request.getRequestLine().getUri(), ex);
    }
  }
  
  public CloseableHttpResponse execute(HttpRoute route, HttpRequestWrapper request, HttpClientContext context, HttpExecutionAware execAware)
    throws IOException, HttpException
  {
    Args.notNull(route, "HTTP route");
    Args.notNull(request, "HTTP request");
    Args.notNull(context, "HTTP context");
    
    rewriteRequestURI(request, route);
    
    ConnectionRequest connRequest = connManager.requestConnection(route, null);
    if (execAware != null)
    {
      if (execAware.isAborted())
      {
        connRequest.cancel();
        throw new RequestAbortedException("Request aborted");
      }
      execAware.setCancellable(connRequest);
    }
    RequestConfig config = context.getRequestConfig();
    HttpClientConnection managedConn;
    try
    {
      int timeout = config.getConnectionRequestTimeout();
      managedConn = connRequest.get(timeout > 0 ? timeout : 0L, TimeUnit.MILLISECONDS);
    }
    catch (InterruptedException interrupted)
    {
      Thread.currentThread().interrupt();
      throw new RequestAbortedException("Request aborted", interrupted);
    }
    catch (ExecutionException ex)
    {
      Throwable cause = ex.getCause();
      if (cause == null) {
        cause = ex;
      }
      throw new RequestAbortedException("Request execution failed", cause);
    }
    ConnectionHolder releaseTrigger = new ConnectionHolder(log, connManager, managedConn);
    try
    {
      if (execAware != null)
      {
        if (execAware.isAborted())
        {
          releaseTrigger.close();
          throw new RequestAbortedException("Request aborted");
        }
        execAware.setCancellable(releaseTrigger);
      }
      if (!managedConn.isOpen())
      {
        int timeout = config.getConnectTimeout();
        connManager.connect(managedConn, route, timeout > 0 ? timeout : 0, context);
        
        connManager.routeComplete(managedConn, route, context);
      }
      int timeout = config.getSocketTimeout();
      if (timeout >= 0) {
        managedConn.setSocketTimeout(timeout);
      }
      HttpHost target = null;
      HttpRequest original = request.getOriginal();
      if ((original instanceof HttpUriRequest))
      {
        URI uri = ((HttpUriRequest)original).getURI();
        if (uri.isAbsolute()) {
          target = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        }
      }
      if (target == null) {
        target = route.getTargetHost();
      }
      context.setAttribute("http.target_host", target);
      context.setAttribute("http.request", request);
      context.setAttribute("http.connection", managedConn);
      context.setAttribute("http.route", route);
      
      httpProcessor.process(request, context);
      HttpResponse response = requestExecutor.execute(request, managedConn, context);
      httpProcessor.process(response, context);
      if (reuseStrategy.keepAlive(response, context))
      {
        long duration = keepAliveStrategy.getKeepAliveDuration(response, context);
        releaseTrigger.setValidFor(duration, TimeUnit.MILLISECONDS);
        releaseTrigger.markReusable();
      }
      else
      {
        releaseTrigger.markNonReusable();
      }
      HttpEntity entity = response.getEntity();
      if ((entity == null) || (!entity.isStreaming()))
      {
        releaseTrigger.releaseConnection();
        return new HttpResponseProxy(response, null);
      }
      return new HttpResponseProxy(response, releaseTrigger);
    }
    catch (ConnectionShutdownException ex)
    {
      InterruptedIOException ioex = new InterruptedIOException("Connection has been shut down");
      
      ioex.initCause(ex);
      throw ioex;
    }
    catch (HttpException ex)
    {
      releaseTrigger.abortConnection();
      throw ex;
    }
    catch (IOException ex)
    {
      releaseTrigger.abortConnection();
      throw ex;
    }
    catch (RuntimeException ex)
    {
      releaseTrigger.abortConnection();
      throw ex;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.MinimalClientExec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */