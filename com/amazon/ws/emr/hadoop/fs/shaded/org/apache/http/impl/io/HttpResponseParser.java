package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NoHttpResponseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;

@Deprecated
public class HttpResponseParser
  extends AbstractMessageParser<HttpMessage>
{
  private final HttpResponseFactory responseFactory;
  private final CharArrayBuffer lineBuf;
  
  public HttpResponseParser(SessionInputBuffer buffer, LineParser parser, HttpResponseFactory responseFactory, HttpParams params)
  {
    super(buffer, parser, params);
    this.responseFactory = ((HttpResponseFactory)Args.notNull(responseFactory, "Response factory"));
    lineBuf = new CharArrayBuffer(128);
  }
  
  protected HttpMessage parseHead(SessionInputBuffer sessionBuffer)
    throws IOException, HttpException, ParseException
  {
    lineBuf.clear();
    int i = sessionBuffer.readLine(lineBuf);
    if (i == -1) {
      throw new NoHttpResponseException("The target server failed to respond");
    }
    ParserCursor cursor = new ParserCursor(0, lineBuf.length());
    StatusLine statusline = lineParser.parseStatusLine(lineBuf, cursor);
    return responseFactory.newHttpResponse(statusline, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.HttpResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */