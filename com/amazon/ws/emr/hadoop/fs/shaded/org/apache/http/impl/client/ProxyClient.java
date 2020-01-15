package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.params.HttpClientParamConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestClientConnControl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpConnectionFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteInfo.LayerType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteInfo.TunnelType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.BufferedHttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultConnectionReuseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.BasicSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.DigestSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.HttpAuthenticator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.KerberosSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.SPNegoSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.TunnelRefusedException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.BasicHttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParamConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.BasicHttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpProcessor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpRequestExecutor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.ImmutableHttpProcessor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestTargetHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestUserAgent;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.Socket;

public class ProxyClient
{
  private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
  private final ConnectionConfig connectionConfig;
  private final RequestConfig requestConfig;
  private final HttpProcessor httpProcessor;
  private final HttpRequestExecutor requestExec;
  private final ProxyAuthenticationStrategy proxyAuthStrategy;
  private final HttpAuthenticator authenticator;
  private final AuthState proxyAuthState;
  private final AuthSchemeRegistry authSchemeRegistry;
  private final ConnectionReuseStrategy reuseStrategy;
  
  public ProxyClient(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory, ConnectionConfig connectionConfig, RequestConfig requestConfig)
  {
    this.connFactory = (connFactory != null ? connFactory : ManagedHttpClientConnectionFactory.INSTANCE);
    this.connectionConfig = (connectionConfig != null ? connectionConfig : ConnectionConfig.DEFAULT);
    this.requestConfig = (requestConfig != null ? requestConfig : RequestConfig.DEFAULT);
    httpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[] { new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent() });
    
    requestExec = new HttpRequestExecutor();
    proxyAuthStrategy = new ProxyAuthenticationStrategy();
    authenticator = new HttpAuthenticator();
    proxyAuthState = new AuthState();
    authSchemeRegistry = new AuthSchemeRegistry();
    authSchemeRegistry.register("Basic", new BasicSchemeFactory());
    authSchemeRegistry.register("Digest", new DigestSchemeFactory());
    authSchemeRegistry.register("NTLM", new NTLMSchemeFactory());
    authSchemeRegistry.register("Negotiate", new SPNegoSchemeFactory());
    authSchemeRegistry.register("Kerberos", new KerberosSchemeFactory());
    reuseStrategy = new DefaultConnectionReuseStrategy();
  }
  
  @Deprecated
  public ProxyClient(HttpParams params)
  {
    this(null, HttpParamConfig.getConnectionConfig(params), HttpClientParamConfig.getRequestConfig(params));
  }
  
  public ProxyClient(RequestConfig requestConfig)
  {
    this(null, null, requestConfig);
  }
  
  public ProxyClient()
  {
    this(null, null, null);
  }
  
  @Deprecated
  public HttpParams getParams()
  {
    return new BasicHttpParams();
  }
  
  @Deprecated
  public AuthSchemeRegistry getAuthSchemeRegistry()
  {
    return authSchemeRegistry;
  }
  
  public Socket tunnel(HttpHost proxy, HttpHost target, Credentials credentials)
    throws IOException, HttpException
  {
    Args.notNull(proxy, "Proxy host");
    Args.notNull(target, "Target host");
    Args.notNull(credentials, "Credentials");
    HttpHost host = target;
    if (host.getPort() <= 0) {
      host = new HttpHost(host.getHostName(), 80, host.getSchemeName());
    }
    HttpRoute route = new HttpRoute(host, requestConfig.getLocalAddress(), proxy, false, RouteInfo.TunnelType.TUNNELLED, RouteInfo.LayerType.PLAIN);
    
    ManagedHttpClientConnection conn = (ManagedHttpClientConnection)connFactory.create(route, connectionConfig);
    
    HttpContext context = new BasicHttpContext();
    
    HttpRequest connect = new BasicHttpRequest("CONNECT", host.toHostString(), HttpVersion.HTTP_1_1);
    
    BasicCredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(new AuthScope(proxy), credentials);
    
    context.setAttribute("http.target_host", target);
    context.setAttribute("http.connection", conn);
    context.setAttribute("http.request", connect);
    context.setAttribute("http.route", route);
    context.setAttribute("http.auth.proxy-scope", proxyAuthState);
    context.setAttribute("http.auth.credentials-provider", credsProvider);
    context.setAttribute("http.authscheme-registry", authSchemeRegistry);
    context.setAttribute("http.request-config", requestConfig);
    
    requestExec.preProcess(connect, httpProcessor, context);
    HttpResponse response;
    for (;;)
    {
      if (!conn.isOpen())
      {
        Socket socket = new Socket(proxy.getHostName(), proxy.getPort());
        conn.bind(socket);
      }
      authenticator.generateAuthResponse(connect, proxyAuthState, context);
      
      response = requestExec.execute(connect, conn, context);
      
      int status = response.getStatusLine().getStatusCode();
      if (status < 200) {
        throw new HttpException("Unexpected response to CONNECT request: " + response.getStatusLine());
      }
      if (!authenticator.isAuthenticationRequested(proxy, response, proxyAuthStrategy, proxyAuthState, context)) {
        break;
      }
      if (!authenticator.handleAuthChallenge(proxy, response, proxyAuthStrategy, proxyAuthState, context)) {
        break;
      }
      if (reuseStrategy.keepAlive(response, context))
      {
        HttpEntity entity = response.getEntity();
        EntityUtils.consume(entity);
      }
      else
      {
        conn.close();
      }
      connect.removeHeaders("Proxy-Authorization");
    }
    int status = response.getStatusLine().getStatusCode();
    if (status > 299)
    {
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        response.setEntity(new BufferedHttpEntity(entity));
      }
      conn.close();
      throw new TunnelRefusedException("CONNECT refused by proxy: " + response.getStatusLine(), response);
    }
    return conn.getSocket();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.ProxyClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */