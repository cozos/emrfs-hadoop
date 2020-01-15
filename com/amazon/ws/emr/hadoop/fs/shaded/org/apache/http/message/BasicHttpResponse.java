package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ReasonPhraseCatalog;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Locale;

public class BasicHttpResponse
  extends AbstractHttpMessage
  implements HttpResponse
{
  private StatusLine statusline;
  private ProtocolVersion ver;
  private int code;
  private String reasonPhrase;
  private HttpEntity entity;
  private final ReasonPhraseCatalog reasonCatalog;
  private Locale locale;
  
  public BasicHttpResponse(StatusLine statusline, ReasonPhraseCatalog catalog, Locale locale)
  {
    this.statusline = ((StatusLine)Args.notNull(statusline, "Status line"));
    ver = statusline.getProtocolVersion();
    code = statusline.getStatusCode();
    reasonPhrase = statusline.getReasonPhrase();
    reasonCatalog = catalog;
    this.locale = locale;
  }
  
  public BasicHttpResponse(StatusLine statusline)
  {
    this.statusline = ((StatusLine)Args.notNull(statusline, "Status line"));
    ver = statusline.getProtocolVersion();
    code = statusline.getStatusCode();
    reasonPhrase = statusline.getReasonPhrase();
    reasonCatalog = null;
    locale = null;
  }
  
  public BasicHttpResponse(ProtocolVersion ver, int code, String reason)
  {
    Args.notNegative(code, "Status code");
    statusline = null;
    this.ver = ver;
    this.code = code;
    reasonPhrase = reason;
    reasonCatalog = null;
    locale = null;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return ver;
  }
  
  public StatusLine getStatusLine()
  {
    if (statusline == null) {
      statusline = new BasicStatusLine(ver != null ? ver : HttpVersion.HTTP_1_1, code, reasonPhrase != null ? reasonPhrase : getReason(code));
    }
    return statusline;
  }
  
  public HttpEntity getEntity()
  {
    return entity;
  }
  
  public Locale getLocale()
  {
    return locale;
  }
  
  public void setStatusLine(StatusLine statusline)
  {
    this.statusline = ((StatusLine)Args.notNull(statusline, "Status line"));
    ver = statusline.getProtocolVersion();
    code = statusline.getStatusCode();
    reasonPhrase = statusline.getReasonPhrase();
  }
  
  public void setStatusLine(ProtocolVersion ver, int code)
  {
    Args.notNegative(code, "Status code");
    statusline = null;
    this.ver = ver;
    this.code = code;
    reasonPhrase = null;
  }
  
  public void setStatusLine(ProtocolVersion ver, int code, String reason)
  {
    Args.notNegative(code, "Status code");
    statusline = null;
    this.ver = ver;
    this.code = code;
    reasonPhrase = reason;
  }
  
  public void setStatusCode(int code)
  {
    Args.notNegative(code, "Status code");
    statusline = null;
    this.code = code;
    reasonPhrase = null;
  }
  
  public void setReasonPhrase(String reason)
  {
    statusline = null;
    reasonPhrase = reason;
  }
  
  public void setEntity(HttpEntity entity)
  {
    this.entity = entity;
  }
  
  public void setLocale(Locale locale)
  {
    this.locale = ((Locale)Args.notNull(locale, "Locale"));
    statusline = null;
  }
  
  protected String getReason(int code)
  {
    return reasonCatalog != null ? reasonCatalog.getReason(code, locale != null ? locale : Locale.getDefault()) : null;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(getStatusLine());
    sb.append(' ');
    sb.append(headergroup);
    if (entity != null)
    {
      sb.append(' ');
      sb.append(entity);
    }
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHttpResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */