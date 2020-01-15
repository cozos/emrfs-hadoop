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
public class DefaultBHttpClientConnectionFactory
  implements HttpConnectionFactory<DefaultBHttpClientConnection>
{
  public static final DefaultBHttpClientConnectionFactory INSTANCE = new DefaultBHttpClientConnectionFactory();
  private final ConnectionConfig cconfig;
  private final ContentLengthStrategy incomingContentStrategy;
  private final ContentLengthStrategy outgoingContentStrategy;
  private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
  private final HttpMessageParserFactory<HttpResponse> responseParserFactory;
  
  public DefaultBHttpClientConnectionFactory(ConnectionConfig cconfig, ContentLengthStrategy incomingContentStrategy, ContentLengthStrategy outgoingContentStrategy, HttpMessageWriterFactory<HttpRequest> requestWriterFactory, HttpMessageParserFactory<HttpResponse> responseParserFactory)
  {
    this.cconfig = (cconfig != null ? cconfig : ConnectionConfig.DEFAULT);
    this.incomingContentStrategy = incomingContentStrategy;
    this.outgoingContentStrategy = outgoingContentStrategy;
    this.requestWriterFactory = requestWriterFactory;
    this.responseParserFactory = responseParserFactory;
  }
  
  public DefaultBHttpClientConnectionFactory(ConnectionConfig cconfig, HttpMessageWriterFactory<HttpRequest> requestWriterFactory, HttpMessageParserFactory<HttpResponse> responseParserFactory)
  {
    this(cconfig, null, null, requestWriterFactory, responseParserFactory);
  }
  
  public DefaultBHttpClientConnectionFactory(ConnectionConfig cconfig)
  {
    this(cconfig, null, null, null, null);
  }
  
  public DefaultBHttpClientConnectionFactory()
  {
    this(null, null, null, null, null);
  }
  
  public DefaultBHttpClientConnection createConnection(Socket socket)
    throws IOException
  {
    DefaultBHttpClientConnection conn = new DefaultBHttpClientConnection(cconfig.getBufferSize(), cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(cconfig), ConnSupport.createEncoder(cconfig), cconfig.getMessageConstraints(), incomingContentStrategy, outgoingContentStrategy, requestWriterFactory, responseParserFactory);
    
    conn.bind(socket);
    return conn;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultBHttpClientConnectionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */