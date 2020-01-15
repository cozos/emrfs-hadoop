package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionClosedException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;

@Deprecated
public class HttpRequestParser
  extends AbstractMessageParser<HttpMessage>
{
  private final HttpRequestFactory requestFactory;
  private final CharArrayBuffer lineBuf;
  
  public HttpRequestParser(SessionInputBuffer buffer, LineParser parser, HttpRequestFactory requestFactory, HttpParams params)
  {
    super(buffer, parser, params);
    this.requestFactory = ((HttpRequestFactory)Args.notNull(requestFactory, "Request factory"));
    lineBuf = new CharArrayBuffer(128);
  }
  
  protected HttpMessage parseHead(SessionInputBuffer sessionBuffer)
    throws IOException, HttpException, ParseException
  {
    lineBuf.clear();
    int i = sessionBuffer.readLine(lineBuf);
    if (i == -1) {
      throw new ConnectionClosedException("Client closed connection");
    }
    ParserCursor cursor = new ParserCursor(0, lineBuf.length());
    RequestLine requestline = lineParser.parseRequestLine(lineBuf, cursor);
    return requestFactory.newHttpRequest(requestline);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.HttpRequestParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */