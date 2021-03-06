package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineFormatter;
import java.io.IOException;

public class DefaultHttpRequestWriter
  extends AbstractMessageWriter<HttpRequest>
{
  public DefaultHttpRequestWriter(SessionOutputBuffer buffer, LineFormatter formatter)
  {
    super(buffer, formatter);
  }
  
  public DefaultHttpRequestWriter(SessionOutputBuffer buffer)
  {
    this(buffer, null);
  }
  
  protected void writeHeadLine(HttpRequest message)
    throws IOException
  {
    lineFormatter.formatRequestLine(lineBuf, message.getRequestLine());
    sessionBuffer.writeLine(lineBuf);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpRequestWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */