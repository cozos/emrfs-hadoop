package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ReasonPhraseCatalog;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicStatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Locale;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpResponseFactory
  implements HttpResponseFactory
{
  public static final DefaultHttpResponseFactory INSTANCE = new DefaultHttpResponseFactory();
  protected final ReasonPhraseCatalog reasonCatalog;
  
  public DefaultHttpResponseFactory(ReasonPhraseCatalog catalog)
  {
    reasonCatalog = ((ReasonPhraseCatalog)Args.notNull(catalog, "Reason phrase catalog"));
  }
  
  public DefaultHttpResponseFactory()
  {
    this(EnglishReasonPhraseCatalog.INSTANCE);
  }
  
  public HttpResponse newHttpResponse(ProtocolVersion ver, int status, HttpContext context)
  {
    Args.notNull(ver, "HTTP version");
    Locale loc = determineLocale(context);
    String reason = reasonCatalog.getReason(status, loc);
    StatusLine statusline = new BasicStatusLine(ver, status, reason);
    return new BasicHttpResponse(statusline, reasonCatalog, loc);
  }
  
  public HttpResponse newHttpResponse(StatusLine statusline, HttpContext context)
  {
    Args.notNull(statusline, "Status line");
    return new BasicHttpResponse(statusline, reasonCatalog, determineLocale(context));
  }
  
  protected Locale determineLocale(HttpContext context)
  {
    return Locale.getDefault();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultHttpResponseFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */