package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.SAFE)
public class ResponseDate
  implements HttpResponseInterceptor
{
  private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator();
  
  public void process(HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    int status = response.getStatusLine().getStatusCode();
    if ((status >= 200) && (!response.containsHeader("Date")))
    {
      String httpdate = DATE_GENERATOR.getCurrentDate();
      response.setHeader("Date", httpdate);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.ResponseDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */