package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicRequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpProtocolParams;
import java.net.URI;

public abstract class HttpRequestBase
  extends AbstractExecutionAwareRequest
  implements HttpUriRequest, Configurable
{
  private ProtocolVersion version;
  private URI uri;
  private RequestConfig config;
  
  public abstract String getMethod();
  
  public void setProtocolVersion(ProtocolVersion version)
  {
    this.version = version;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return version != null ? version : HttpProtocolParams.getVersion(getParams());
  }
  
  public URI getURI()
  {
    return uri;
  }
  
  public RequestLine getRequestLine()
  {
    String method = getMethod();
    ProtocolVersion ver = getProtocolVersion();
    URI uriCopy = getURI();
    String uritext = null;
    if (uriCopy != null) {
      uritext = uriCopy.toASCIIString();
    }
    if ((uritext == null) || (uritext.isEmpty())) {
      uritext = "/";
    }
    return new BasicRequestLine(method, uritext, ver);
  }
  
  public RequestConfig getConfig()
  {
    return config;
  }
  
  public void setConfig(RequestConfig config)
  {
    this.config = config;
  }
  
  public void setURI(URI uri)
  {
    this.uri = uri;
  }
  
  public void started() {}
  
  public void releaseConnection()
  {
    reset();
  }
  
  public String toString()
  {
    return getMethod() + " " + getURI() + " " + getProtocolVersion();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */