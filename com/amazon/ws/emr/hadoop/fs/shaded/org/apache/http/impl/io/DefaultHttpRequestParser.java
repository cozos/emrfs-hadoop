package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ConnectionClosedException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultHttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;

public class DefaultHttpRequestParser
  extends AbstractMessageParser<HttpRequest>
{
  private final HttpRequestFactory requestFactory;
  private final CharArrayBuffer lineBuf;
  
  @Deprecated
  public DefaultHttpRequestParser(SessionInputBuffer buffer, LineParser lineParser, HttpRequestFactory requestFactory, HttpParams params)
  {
    super(buffer, lineParser, params);
    this.requestFactory = ((HttpRequestFactory)Args.notNull(requestFactory, "Request factory"));
    lineBuf = new CharArrayBuffer(128);
  }
  
  public DefaultHttpRequestParser(SessionInputBuffer buffer, LineParser lineParser, HttpRequestFactory requestFactory, MessageConstraints constraints)
  {
    super(buffer, lineParser, constraints);
    this.requestFactory = (requestFactory != null ? requestFactory : DefaultHttpRequestFactory.INSTANCE);
    
    lineBuf = new CharArrayBuffer(128);
  }
  
  public DefaultHttpRequestParser(SessionInputBuffer buffer, MessageConstraints constraints)
  {
    this(buffer, null, null, constraints);
  }
  
  public DefaultHttpRequestParser(SessionInputBuffer buffer)
  {
    this(buffer, null, null, MessageConstraints.DEFAULT);
  }
  
  protected HttpRequest parseHead(SessionInputBuffer sessionBuffer)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpRequestParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */