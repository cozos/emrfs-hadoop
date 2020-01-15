package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicLineFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;

public abstract class AbstractMessageWriter<T extends HttpMessage>
  implements HttpMessageWriter<T>
{
  protected final SessionOutputBuffer sessionBuffer;
  protected final CharArrayBuffer lineBuf;
  protected final LineFormatter lineFormatter;
  
  @Deprecated
  public AbstractMessageWriter(SessionOutputBuffer buffer, LineFormatter formatter, HttpParams params)
  {
    Args.notNull(buffer, "Session input buffer");
    sessionBuffer = buffer;
    lineBuf = new CharArrayBuffer(128);
    lineFormatter = (formatter != null ? formatter : BasicLineFormatter.INSTANCE);
  }
  
  public AbstractMessageWriter(SessionOutputBuffer buffer, LineFormatter formatter)
  {
    sessionBuffer = ((SessionOutputBuffer)Args.notNull(buffer, "Session input buffer"));
    lineFormatter = (formatter != null ? formatter : BasicLineFormatter.INSTANCE);
    lineBuf = new CharArrayBuffer(128);
  }
  
  protected abstract void writeHeadLine(T paramT)
    throws IOException;
  
  public void write(T message)
    throws IOException, HttpException
  {
    Args.notNull(message, "HTTP message");
    writeHeadLine(message);
    for (HeaderIterator it = message.headerIterator(); it.hasNext();)
    {
      Header header = it.nextHeader();
      sessionBuffer.writeLine(lineFormatter.formatHeader(lineBuf, header));
    }
    lineBuf.clear();
    sessionBuffer.writeLine(lineBuf);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.AbstractMessageWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */