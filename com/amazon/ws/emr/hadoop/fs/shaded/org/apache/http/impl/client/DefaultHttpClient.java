package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestAddCookies;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestAuthCache;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestClientConnControl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestDefaultHeaders;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestProxyAuthentication;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestTargetAuthentication;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.ResponseProcessCookies;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpConnectionParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpProtocolParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.SyncBasicHttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.BasicHttpProcessor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HTTP;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestContent;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestExpectContinue;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestTargetHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.RequestUserAgent;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.VersionInfo;
import java.nio.charset.Charset;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
public class DefaultHttpClient
  extends AbstractHttpClient
{
  public DefaultHttpClient(ClientConnectionManager conman, HttpParams params)
  {
    super(conman, params);
  }
  
  public DefaultHttpClient(ClientConnectionManager conman)
  {
    super(conman, null);
  }
  
  public DefaultHttpClient(HttpParams params)
  {
    super(null, params);
  }
  
  public DefaultHttpClient()
  {
    super(null, null);
  }
  
  protected HttpParams createHttpParams()
  {
    HttpParams params = new SyncBasicHttpParams();
    setDefaultHttpParams(params);
    return params;
  }
  
  public static void setDefaultHttpParams(HttpParams params)
  {
    HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(params, HTTP.DEF_CONTENT_CHARSET.name());
    HttpConnectionParams.setTcpNoDelay(params, true);
    HttpConnectionParams.setSocketBufferSize(params, 8192);
    HttpProtocolParams.setUserAgent(params, VersionInfo.getUserAgent("Apache-HttpClient", "com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client", DefaultHttpClient.class));
  }
  
  protected BasicHttpProcessor createHttpProcessor()
  {
    BasicHttpProcessor httpproc = new BasicHttpProcessor();
    httpproc.addInterceptor(new RequestDefaultHeaders());
    
    httpproc.addInterceptor(new RequestContent());
    httpproc.addInterceptor(new RequestTargetHost());
    
    httpproc.addInterceptor(new RequestClientConnControl());
    httpproc.addInterceptor(new RequestUserAgent());
    httpproc.addInterceptor(new RequestExpectContinue());
    
    httpproc.addInterceptor(new RequestAddCookies());
    httpproc.addInterceptor(new ResponseProcessCookies());
    
    httpproc.addInterceptor(new RequestAuthCache());
    httpproc.addInterceptor(new RequestTargetAuthentication());
    httpproc.addInterceptor(new RequestProxyAuthentication());
    return httpproc;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */