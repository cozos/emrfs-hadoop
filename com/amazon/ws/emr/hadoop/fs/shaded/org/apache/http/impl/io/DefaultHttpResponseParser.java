package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NoHttpResponseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultHttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.IOException;

public class DefaultHttpResponseParser
  extends AbstractMessageParser<HttpResponse>
{
  private final HttpResponseFactory responseFactory;
  private final CharArrayBuffer lineBuf;
  
  @Deprecated
  public DefaultHttpResponseParser(SessionInputBuffer buffer, LineParser lineParser, HttpResponseFactory responseFactory, HttpParams params)
  {
    super(buffer, lineParser, params);
    this.responseFactory = ((HttpResponseFactory)Args.notNull(responseFactory, "Response factory"));
    lineBuf = new CharArrayBuffer(128);
  }
  
  public DefaultHttpResponseParser(SessionInputBuffer buffer, LineParser lineParser, HttpResponseFactory responseFactory, MessageConstraints constraints)
  {
    super(buffer, lineParser, constraints);
    this.responseFactory = (responseFactory != null ? responseFactory : DefaultHttpResponseFactory.INSTANCE);
    
    lineBuf = new CharArrayBuffer(128);
  }
  
  public DefaultHttpResponseParser(SessionInputBuffer buffer, MessageConstraints constraints)
  {
    this(buffer, null, null, constraints);
  }
  
  public DefaultHttpResponseParser(SessionInputBuffer buffer)
  {
    this(buffer, null, null, MessageConstraints.DEFAULT);
  }
  
  protected HttpResponse parseHead(SessionInputBuffer sessionBuffer)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */