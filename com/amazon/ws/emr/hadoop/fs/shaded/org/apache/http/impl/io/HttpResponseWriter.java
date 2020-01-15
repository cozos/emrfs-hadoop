package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;

@Deprecated
public class HttpResponseWriter
  extends AbstractMessageWriter<HttpResponse>
{
  public HttpResponseWriter(SessionOutputBuffer buffer, LineFormatter formatter, HttpParams params)
  {
    super(buffer, formatter, params);
  }
  
  protected void writeHeadLine(HttpResponse message)
    throws IOException
  {
    lineFormatter.formatStatusLine(lineBuf, message.getStatusLine());
    sessionBuffer.writeLine(lineBuf);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.HttpResponseWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */