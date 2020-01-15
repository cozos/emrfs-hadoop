package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpServerConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpRequestParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpResponseWriterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class DefaultBHttpServerConnection
  extends BHttpConnectionBase
  implements HttpServerConnection
{
  private final HttpMessageParser<HttpRequest> requestParser;
  private final HttpMessageWriter<HttpResponse> responseWriter;
  
  public DefaultBHttpServerConnection(int buffersize, int fragmentSizeHint, CharsetDecoder chardecoder, CharsetEncoder charencoder, MessageConstraints constraints, ContentLengthStrategy incomingContentStrategy, ContentLengthStrategy outgoingContentStrategy, HttpMessageParserFactory<HttpRequest> requestParserFactory, HttpMessageWriterFactory<HttpResponse> responseWriterFactory)
  {
    super(buffersize, fragmentSizeHint, chardecoder, charencoder, constraints, incomingContentStrategy != null ? incomingContentStrategy : DisallowIdentityContentLengthStrategy.INSTANCE, outgoingContentStrategy);
    
    requestParser = (requestParserFactory != null ? requestParserFactory : DefaultHttpRequestParserFactory.INSTANCE).create(getSessionInputBuffer(), constraints);
    
    responseWriter = (responseWriterFactory != null ? responseWriterFactory : DefaultHttpResponseWriterFactory.INSTANCE).create(getSessionOutputBuffer());
  }
  
  public DefaultBHttpServerConnection(int buffersize, CharsetDecoder chardecoder, CharsetEncoder charencoder, MessageConstraints constraints)
  {
    this(buffersize, buffersize, chardecoder, charencoder, constraints, null, null, null, null);
  }
  
  public DefaultBHttpServerConnection(int buffersize)
  {
    this(buffersize, buffersize, null, null, null, null, null, null, null);
  }
  
  protected void onRequestReceived(HttpRequest request) {}
  
  protected void onResponseSubmitted(HttpResponse response) {}
  
  public void bind(Socket socket)
    throws IOException
  {
    super.bind(socket);
  }
  
  public HttpRequest receiveRequestHeader()
    throws HttpException, IOException
  {
    ensureOpen();
    HttpRequest request = (HttpRequest)requestParser.parse();
    onRequestReceived(request);
    incrementRequestCount();
    return request;
  }
  
  public void receiveRequestEntity(HttpEntityEnclosingRequest request)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    ensureOpen();
    HttpEntity entity = prepareInput(request);
    request.setEntity(entity);
  }
  
  public void sendResponseHeader(HttpResponse response)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    ensureOpen();
    responseWriter.write(response);
    onResponseSubmitted(response);
    if (response.getStatusLine().getStatusCode() >= 200) {
      incrementResponseCount();
    }
  }
  
  public void sendResponseEntity(HttpResponse response)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    ensureOpen();
    HttpEntity entity = response.getEntity();
    if (entity == null) {
      return;
    }
    OutputStream outstream = prepareOutput(response);
    entity.writeTo(outstream);
    outstream.close();
  }
  
  public void flush()
    throws IOException
  {
    ensureOpen();
    doFlush();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultBHttpServerConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */