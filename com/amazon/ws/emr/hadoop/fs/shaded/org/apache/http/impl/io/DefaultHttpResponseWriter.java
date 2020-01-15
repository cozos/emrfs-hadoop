package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineFormatter;
import java.io.IOException;

public class DefaultHttpResponseWriter
  extends AbstractMessageWriter<HttpResponse>
{
  public DefaultHttpResponseWriter(SessionOutputBuffer buffer, LineFormatter formatter)
  {
    super(buffer, formatter);
  }
  
  public DefaultHttpResponseWriter(SessionOutputBuffer buffer)
  {
    super(buffer, null);
  }
  
  protected void writeHeadLine(HttpResponse message)
    throws IOException
  {
    lineFormatter.formatStatusLine(lineBuf, message.getStatusLine());
    sessionBuffer.writeLine(lineBuf);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpResponseWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */