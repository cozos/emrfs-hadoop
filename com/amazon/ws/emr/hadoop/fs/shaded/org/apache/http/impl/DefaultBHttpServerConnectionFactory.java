package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnectionFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.ConnectionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriterFactory;
import java.io.IOException;
import java.net.Socket;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultBHttpServerConnectionFactory
  implements HttpConnectionFactory<DefaultBHttpServerConnection>
{
  public static final DefaultBHttpServerConnectionFactory INSTANCE = new DefaultBHttpServerConnectionFactory();
  private final ConnectionConfig cconfig;
  private final ContentLengthStrategy incomingContentStrategy;
  private final ContentLengthStrategy outgoingContentStrategy;
  private final HttpMessageParserFactory<HttpRequest> requestParserFactory;
  private final HttpMessageWriterFactory<HttpResponse> responseWriterFactory;
  
  public DefaultBHttpServerConnectionFactory(ConnectionConfig cconfig, ContentLengthStrategy incomingContentStrategy, ContentLengthStrategy outgoingContentStrategy, HttpMessageParserFactory<HttpRequest> requestParserFactory, HttpMessageWriterFactory<HttpResponse> responseWriterFactory)
  {
    this.cconfig = (cconfig != null ? cconfig : ConnectionConfig.DEFAULT);
    this.incomingContentStrategy = incomingContentStrategy;
    this.outgoingContentStrategy = outgoingContentStrategy;
    this.requestParserFactory = requestParserFactory;
    this.responseWriterFactory = responseWriterFactory;
  }
  
  public DefaultBHttpServerConnectionFactory(ConnectionConfig cconfig, HttpMessageParserFactory<HttpRequest> requestParserFactory, HttpMessageWriterFactory<HttpResponse> responseWriterFactory)
  {
    this(cconfig, null, null, requestParserFactory, responseWriterFactory);
  }
  
  public DefaultBHttpServerConnectionFactory(ConnectionConfig cconfig)
  {
    this(cconfig, null, null, null, null);
  }
  
  public DefaultBHttpServerConnectionFactory()
  {
    this(null, null, null, null, null);
  }
  
  public DefaultBHttpServerConnection createConnection(Socket socket)
    throws IOException
  {
    DefaultBHttpServerConnection conn = new DefaultBHttpServerConnection(cconfig.getBufferSize(), cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(cconfig), ConnSupport.createEncoder(cconfig), cconfig.getMessageConstraints(), incomingContentStrategy, outgoingContentStrategy, requestParserFactory, responseWriterFactory);
    
    conn.bind(socket);
    return conn;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultBHttpServerConnectionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */