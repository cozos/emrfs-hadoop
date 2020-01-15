package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CRC32ChecksumCalculatingInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public class HttpResponse
{
  private final Request<?> request;
  private final HttpRequestBase httpRequest;
  private String statusText;
  private int statusCode;
  private InputStream content;
  private Map<String, String> headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  private HttpContext context;
  
  public HttpResponse(Request<?> request, HttpRequestBase httpRequest)
  {
    this(request, httpRequest, null);
  }
  
  public HttpResponse(Request<?> request, HttpRequestBase httpRequest, HttpContext context)
  {
    this.request = request;
    this.httpRequest = httpRequest;
    this.context = context;
  }
  
  public Request<?> getRequest()
  {
    return request;
  }
  
  public HttpRequestBase getHttpRequest()
  {
    return httpRequest;
  }
  
  public Map<String, String> getHeaders()
  {
    return headers;
  }
  
  public String getHeader(String headerName)
  {
    return (String)headers.get(headerName);
  }
  
  public void addHeader(String name, String value)
  {
    headers.put(name, value);
  }
  
  public void setContent(InputStream content)
  {
    this.content = content;
  }
  
  public InputStream getContent()
  {
    return content;
  }
  
  public void setStatusText(String statusText)
  {
    this.statusText = statusText;
  }
  
  public String getStatusText()
  {
    return statusText;
  }
  
  public void setStatusCode(int statusCode)
  {
    this.statusCode = statusCode;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public long getCRC32Checksum()
  {
    if (context == null) {
      return 0L;
    }
    CRC32ChecksumCalculatingInputStream crc32ChecksumInputStream = (CRC32ChecksumCalculatingInputStream)context.getAttribute(CRC32ChecksumCalculatingInputStream.class.getName());
    return crc32ChecksumInputStream == null ? 0L : crc32ChecksumInputStream.getCRC32Checksum();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */