package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultHttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicLineParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineParser;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpRequestParserFactory
  implements HttpMessageParserFactory<HttpRequest>
{
  public static final DefaultHttpRequestParserFactory INSTANCE = new DefaultHttpRequestParserFactory();
  private final LineParser lineParser;
  private final HttpRequestFactory requestFactory;
  
  public DefaultHttpRequestParserFactory(LineParser lineParser, HttpRequestFactory requestFactory)
  {
    this.lineParser = (lineParser != null ? lineParser : BasicLineParser.INSTANCE);
    this.requestFactory = (requestFactory != null ? requestFactory : DefaultHttpRequestFactory.INSTANCE);
  }
  
  public DefaultHttpRequestParserFactory()
  {
    this(null, null);
  }
  
  public HttpMessageParser<HttpRequest> create(SessionInputBuffer buffer, MessageConstraints constraints)
  {
    return new DefaultHttpRequestParser(buffer, lineParser, requestFactory, constraints);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpRequestParserFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */