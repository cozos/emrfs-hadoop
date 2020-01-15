package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultHttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicLineParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineParser;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpResponseParserFactory
  implements HttpMessageParserFactory<HttpResponse>
{
  public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
  private final LineParser lineParser;
  private final HttpResponseFactory responseFactory;
  
  public DefaultHttpResponseParserFactory(LineParser lineParser, HttpResponseFactory responseFactory)
  {
    this.lineParser = (lineParser != null ? lineParser : BasicLineParser.INSTANCE);
    this.responseFactory = (responseFactory != null ? responseFactory : DefaultHttpResponseFactory.INSTANCE);
  }
  
  public DefaultHttpResponseParserFactory()
  {
    this(null, null);
  }
  
  public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer, MessageConstraints constraints)
  {
    return new DefaultHttpResponseParser(buffer, lineParser, responseFactory, constraints);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpResponseParserFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */