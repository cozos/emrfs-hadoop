package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpResponseParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class DefaultBHttpClientConnection
  extends BHttpConnectionBase
  implements HttpClientConnection
{
  private final HttpMessageParser<HttpResponse> responseParser;
  private final HttpMessageWriter<HttpRequest> requestWriter;
  
  public DefaultBHttpClientConnection(int buffersize, int fragmentSizeHint, CharsetDecoder chardecoder, CharsetEncoder charencoder, MessageConstraints constraints, ContentLengthStrategy incomingContentStrategy, ContentLengthStrategy outgoingContentStrategy, HttpMessageWriterFactory<HttpRequest> requestWriterFactory, HttpMessageParserFactory<HttpResponse> responseParserFactory)
  {
    super(buffersize, fragmentSizeHint, chardecoder, charencoder, constraints, incomingContentStrategy, outgoingContentStrategy);
    
    requestWriter = (requestWriterFactory != null ? requestWriterFactory : DefaultHttpRequestWriterFactory.INSTANCE).create(getSessionOutputBuffer());
    
    responseParser = (responseParserFactory != null ? responseParserFactory : DefaultHttpResponseParserFactory.INSTANCE).create(getSessionInputBuffer(), constraints);
  }
  
  public DefaultBHttpClientConnection(int buffersize, CharsetDecoder chardecoder, CharsetEncoder charencoder, MessageConstraints constraints)
  {
    this(buffersize, buffersize, chardecoder, charencoder, constraints, null, null, null, null);
  }
  
  public DefaultBHttpClientConnection(int buffersize)
  {
    this(buffersize, buffersize, null, null, null, null, null, null, null);
  }
  
  protected void onResponseReceived(HttpResponse response) {}
  
  protected void onRequestSubmitted(HttpRequest request) {}
  
  public void bind(Socket socket)
    throws IOException
  {
    super.bind(socket);
  }
  
  public boolean isResponseAvailable(int timeout)
    throws IOException
  {
    ensureOpen();
    try
    {
      return awaitInput(timeout);
    }
    catch (SocketTimeoutException ex) {}
    return false;
  }
  
  public void sendRequestHeader(HttpRequest request)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    ensureOpen();
    requestWriter.write(request);
    onRequestSubmitted(request);
    incrementRequestCount();
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest request)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    ensureOpen();
    HttpEntity entity = request.getEntity();
    if (entity == null) {
      return;
    }
    OutputStream outstream = prepareOutput(request);
    entity.writeTo(outstream);
    outstream.close();
  }
  
  public HttpResponse receiveResponseHeader()
    throws HttpException, IOException
  {
    ensureOpen();
    HttpResponse response = (HttpResponse)responseParser.parse();
    onResponseReceived(response);
    if (response.getStatusLine().getStatusCode() >= 200) {
      incrementResponseCount();
    }
    return response;
  }
  
  public void receiveResponseEntity(HttpResponse response)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    ensureOpen();
    HttpEntity entity = prepareInput(response);
    response.setEntity(entity);
  }
  
  public void flush()
    throws IOException
  {
    ensureOpen();
    doFlush();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultBHttpClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */