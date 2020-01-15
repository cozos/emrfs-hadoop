package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import java.io.IOException;

@Deprecated
public class HttpRequestWriter
  extends AbstractMessageWriter<HttpRequest>
{
  public HttpRequestWriter(SessionOutputBuffer buffer, LineFormatter formatter, HttpParams params)
  {
    super(buffer, formatter, params);
  }
  
  protected void writeHeadLine(HttpRequest message)
    throws IOException
  {
    lineFormatter.formatRequestLine(lineBuf, message.getRequestLine());
    sessionBuffer.writeLine(lineBuf);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.HttpRequestWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */