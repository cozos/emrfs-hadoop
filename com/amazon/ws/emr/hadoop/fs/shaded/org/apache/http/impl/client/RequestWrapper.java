package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpUriRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.AbstractHttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicRequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.HeaderGroup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpProtocolParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.net.URI;
import java.net.URISyntaxException;

@Deprecated
public class RequestWrapper
  extends AbstractHttpMessage
  implements HttpUriRequest
{
  private final HttpRequest original;
  private URI uri;
  private String method;
  private ProtocolVersion version;
  private int execCount;
  
  public RequestWrapper(HttpRequest request)
    throws ProtocolException
  {
    Args.notNull(request, "HTTP request");
    original = request;
    setParams(request.getParams());
    setHeaders(request.getAllHeaders());
    if ((request instanceof HttpUriRequest))
    {
      uri = ((HttpUriRequest)request).getURI();
      method = ((HttpUriRequest)request).getMethod();
      version = null;
    }
    else
    {
      RequestLine requestLine = request.getRequestLine();
      try
      {
        uri = new URI(requestLine.getUri());
      }
      catch (URISyntaxException ex)
      {
        throw new ProtocolException("Invalid request URI: " + requestLine.getUri(), ex);
      }
      method = requestLine.getMethod();
      version = request.getProtocolVersion();
    }
    execCount = 0;
  }
  
  public void resetHeaders()
  {
    headergroup.clear();
    setHeaders(original.getAllHeaders());
  }
  
  public String getMethod()
  {
    return method;
  }
  
  public void setMethod(String method)
  {
    Args.notNull(method, "Method name");
    this.method = method;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    if (version == null) {
      version = HttpProtocolParams.getVersion(getParams());
    }
    return version;
  }
  
  public void setProtocolVersion(ProtocolVersion version)
  {
    this.version = version;
  }
  
  public URI getURI()
  {
    return uri;
  }
  
  public void setURI(URI uri)
  {
    this.uri = uri;
  }
  
  public RequestLine getRequestLine()
  {
    ProtocolVersion ver = getProtocolVersion();
    String uritext = null;
    if (uri != null) {
      uritext = uri.toASCIIString();
    }
    if ((uritext == null) || (uritext.isEmpty())) {
      uritext = "/";
    }
    return new BasicRequestLine(getMethod(), uritext, ver);
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
  
  public HttpRequest getOriginal()
  {
    return original;
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public int getExecCount()
  {
    return execCount;
  }
  
  public void incrementExecCount()
  {
    execCount += 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.RequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */