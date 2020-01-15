package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.BasicHttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

public abstract class AbstractHttpMessage
  implements HttpMessage
{
  protected HeaderGroup headergroup;
  @Deprecated
  protected HttpParams params;
  
  @Deprecated
  protected AbstractHttpMessage(HttpParams params)
  {
    headergroup = new HeaderGroup();
    this.params = params;
  }
  
  protected AbstractHttpMessage()
  {
    this(null);
  }
  
  public boolean containsHeader(String name)
  {
    return headergroup.containsHeader(name);
  }
  
  public Header[] getHeaders(String name)
  {
    return headergroup.getHeaders(name);
  }
  
  public Header getFirstHeader(String name)
  {
    return headergroup.getFirstHeader(name);
  }
  
  public Header getLastHeader(String name)
  {
    return headergroup.getLastHeader(name);
  }
  
  public Header[] getAllHeaders()
  {
    return headergroup.getAllHeaders();
  }
  
  public void addHeader(Header header)
  {
    headergroup.addHeader(header);
  }
  
  public void addHeader(String name, String value)
  {
    Args.notNull(name, "Header name");
    headergroup.addHeader(new BasicHeader(name, value));
  }
  
  public void setHeader(Header header)
  {
    headergroup.updateHeader(header);
  }
  
  public void setHeader(String name, String value)
  {
    Args.notNull(name, "Header name");
    headergroup.updateHeader(new BasicHeader(name, value));
  }
  
  public void setHeaders(Header[] headers)
  {
    headergroup.setHeaders(headers);
  }
  
  public void removeHeader(Header header)
  {
    headergroup.removeHeader(header);
  }
  
  public void removeHeaders(String name)
  {
    if (name == null) {
      return;
    }
    for (HeaderIterator i = headergroup.iterator(); i.hasNext();)
    {
      Header header = i.nextHeader();
      if (name.equalsIgnoreCase(header.getName())) {
        i.remove();
      }
    }
  }
  
  public HeaderIterator headerIterator()
  {
    return headergroup.iterator();
  }
  
  public HeaderIterator headerIterator(String name)
  {
    return headergroup.iterator(name);
  }
  
  @Deprecated
  public HttpParams getParams()
  {
    if (params == null) {
      params = new BasicHttpParams();
    }
    return params;
  }
  
  @Deprecated
  public void setParams(HttpParams params)
  {
    this.params = ((HttpParams)Args.notNull(params, "HTTP parameters"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.AbstractHttpMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */