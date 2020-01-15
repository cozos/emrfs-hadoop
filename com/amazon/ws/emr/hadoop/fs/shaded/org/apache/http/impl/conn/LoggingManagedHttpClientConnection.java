package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriterFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

class LoggingManagedHttpClientConnection
  extends DefaultManagedHttpClientConnection
{
  private final Log log;
  private final Log headerlog;
  private final Wire wire;
  
  public LoggingManagedHttpClientConnection(String id, Log log, Log headerlog, Log wirelog, int buffersize, int fragmentSizeHint, CharsetDecoder chardecoder, CharsetEncoder charencoder, MessageConstraints constraints, ContentLengthStrategy incomingContentStrategy, ContentLengthStrategy outgoingContentStrategy, HttpMessageWriterFactory<HttpRequest> requestWriterFactory, HttpMessageParserFactory<HttpResponse> responseParserFactory)
  {
    super(id, buffersize, fragmentSizeHint, chardecoder, charencoder, constraints, incomingContentStrategy, outgoingContentStrategy, requestWriterFactory, responseParserFactory);
    
    this.log = log;
    this.headerlog = headerlog;
    wire = new Wire(wirelog, id);
  }
  
  public void close()
    throws IOException
  {
    if (super.isOpen())
    {
      if (log.isDebugEnabled()) {
        log.debug(getId() + ": Close connection");
      }
      super.close();
    }
  }
  
  public void setSocketTimeout(int timeout)
  {
    if (log.isDebugEnabled()) {
      log.debug(getId() + ": set socket timeout to " + timeout);
    }
    super.setSocketTimeout(timeout);
  }
  
  public void shutdown()
    throws IOException
  {
    if (log.isDebugEnabled()) {
      log.debug(getId() + ": Shutdown connection");
    }
    super.shutdown();
  }
  
  protected InputStream getSocketInputStream(Socket socket)
    throws IOException
  {
    InputStream in = super.getSocketInputStream(socket);
    if (wire.enabled()) {
      in = new LoggingInputStream(in, wire);
    }
    return in;
  }
  
  protected OutputStream getSocketOutputStream(Socket socket)
    throws IOException
  {
    OutputStream out = super.getSocketOutputStream(socket);
    if (wire.enabled()) {
      out = new LoggingOutputStream(out, wire);
    }
    return out;
  }
  
  protected void onResponseReceived(HttpResponse response)
  {
    if ((response != null) && (headerlog.isDebugEnabled()))
    {
      headerlog.debug(getId() + " << " + response.getStatusLine().toString());
      Header[] headers = response.getAllHeaders();
      for (Header header : headers) {
        headerlog.debug(getId() + " << " + header.toString());
      }
    }
  }
  
  protected void onRequestSubmitted(HttpRequest request)
  {
    if ((request != null) && (headerlog.isDebugEnabled()))
    {
      headerlog.debug(getId() + " >> " + request.getRequestLine().toString());
      Header[] headers = request.getAllHeaders();
      for (Header header : headers) {
        headerlog.debug(getId() + " >> " + header.toString());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.LoggingManagedHttpClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */