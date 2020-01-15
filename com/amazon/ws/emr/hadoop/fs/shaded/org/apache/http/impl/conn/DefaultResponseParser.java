package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NoHttpResponseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.AbstractMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
public class DefaultResponseParser
  extends AbstractMessageParser<HttpMessage>
{
  private final Log log = LogFactory.getLog(getClass());
  private final HttpResponseFactory responseFactory;
  private final CharArrayBuffer lineBuf;
  private final int maxGarbageLines;
  
  public DefaultResponseParser(SessionInputBuffer buffer, LineParser parser, HttpResponseFactory responseFactory, HttpParams params)
  {
    super(buffer, parser, params);
    Args.notNull(responseFactory, "Response factory");
    this.responseFactory = responseFactory;
    lineBuf = new CharArrayBuffer(128);
    maxGarbageLines = getMaxGarbageLines(params);
  }
  
  protected int getMaxGarbageLines(HttpParams params)
  {
    return params.getIntParameter("http.connection.max-status-line-garbage", Integer.MAX_VALUE);
  }
  
  protected HttpMessage parseHead(SessionInputBuffer sessionBuffer)
    throws IOException, HttpException
  {
    int count = 0;
    ParserCursor cursor = null;
    for (;;)
    {
      lineBuf.clear();
      int i = sessionBuffer.readLine(lineBuf);
      if ((i == -1) && (count == 0)) {
        throw new NoHttpResponseException("The target server failed to respond");
      }
      cursor = new ParserCursor(0, lineBuf.length());
      if (lineParser.hasProtocolVersion(lineBuf, cursor)) {
        break;
      }
      if ((i == -1) || (count >= maxGarbageLines)) {
        throw new ProtocolException("The server failed to respond with a valid HTTP response");
      }
      if (log.isDebugEnabled()) {
        log.debug("Garbage in response: " + lineBuf.toString());
      }
      count++;
    }
    StatusLine statusline = lineParser.parseStatusLine(lineBuf, cursor);
    return responseFactory.newHttpResponse(statusline, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */