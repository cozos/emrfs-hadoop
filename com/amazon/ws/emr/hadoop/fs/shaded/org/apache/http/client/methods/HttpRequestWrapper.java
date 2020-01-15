package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.AbstractHttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicRequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.net.URI;

public class HttpRequestWrapper
  extends AbstractHttpMessage
  implements HttpUriRequest
{
  private final HttpRequest original;
  private final HttpHost target;
  private final String method;
  private RequestLine requestLine;
  private ProtocolVersion version;
  private URI uri;
  
  private HttpRequestWrapper(HttpRequest request, HttpHost target)
  {
    original = ((HttpRequest)Args.notNull(request, "HTTP request"));
    this.target = target;
    version = original.getRequestLine().getProtocolVersion();
    method = original.getRequestLine().getMethod();
    if ((request instanceof HttpUriRequest)) {
      uri = ((HttpUriRequest)request).getURI();
    } else {
      uri = null;
    }
    setHeaders(request.getAllHeaders());
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return version != null ? version : original.getProtocolVersion();
  }
  
  public void setProtocolVersion(ProtocolVersion version)
  {
    this.version = version;
    requestLine = null;
  }
  
  public URI getURI()
  {
    return uri;
  }
  
  public void setURI(URI uri)
  {
    this.uri = uri;
    requestLine = null;
  }
  
  public String getMethod()
  {
    return method;
  }
  
  public void abort()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isAborted()
  {
    return false;
  }
  
  public RequestLine getRequestLine()
  {
    if (requestLine == null)
    {
      String requestUri;
      String requestUri;
      if (uri != null) {
        requestUri = uri.toASCIIString();
      } else {
        requestUri = original.getRequestLine().getUri();
      }
      if ((requestUri == null) || (requestUri.isEmpty())) {
        requestUri = "/";
      }
      requestLine = new BasicRequestLine(method, requestUri, getProtocolVersion());
    }
    return requestLine;
  }
  
  public HttpRequest getOriginal()
  {
    return original;
  }
  
  public HttpHost getTarget()
  {
    return target;
  }
  
  public String toString()
  {
    return getRequestLine() + " " + headergroup;
  }
  
  static class HttpEntityEnclosingRequestWrapper
    extends HttpRequestWrapper
    implements HttpEntityEnclosingRequest
  {
    private HttpEntity entity;
    
    HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest request, HttpHost target)
    {
      super(target, null);
      entity = request.getEntity();
    }
    
    public HttpEntity getEntity()
    {
      return entity;
    }
    
    public void setEntity(HttpEntity entity)
    {
      this.entity = entity;
    }
    
    public boolean expectContinue()
    {
      Header expect = getFirstHeader("Expect");
      return (expect != null) && ("100-continue".equalsIgnoreCase(expect.getValue()));
    }
  }
  
  public static HttpRequestWrapper wrap(HttpRequest request)
  {
    return wrap(request, null);
  }
  
  public static HttpRequestWrapper wrap(HttpRequest request, HttpHost target)
  {
    Args.notNull(request, "HTTP request");
    if ((request instanceof HttpEntityEnclosingRequest)) {
      return new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)request, target);
    }
    return new HttpRequestWrapper(request, target);
  }
  
  @Deprecated
  public HttpParams getParams()
  {
    if (params == null) {
      params = original.getParams().copy();
    }
    return params;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */