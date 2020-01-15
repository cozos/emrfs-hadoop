package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElementIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ConnectionKeepAliveStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeaderElementIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class DefaultConnectionKeepAliveStrategy
  implements ConnectionKeepAliveStrategy
{
  public static final DefaultConnectionKeepAliveStrategy INSTANCE = new DefaultConnectionKeepAliveStrategy();
  
  public long getKeepAliveDuration(HttpResponse response, HttpContext context)
  {
    Args.notNull(response, "HTTP response");
    HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator("Keep-Alive"));
    while (it.hasNext())
    {
      HeaderElement he = it.nextElement();
      String param = he.getName();
      String value = he.getValue();
      if ((value != null) && (param.equalsIgnoreCase("timeout"))) {
        try
        {
          return Long.parseLong(value) * 1000L;
        }
        catch (NumberFormatException ignore) {}
      }
    }
    return -1L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */