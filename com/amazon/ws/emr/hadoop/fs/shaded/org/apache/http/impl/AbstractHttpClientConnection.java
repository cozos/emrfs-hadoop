package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnectionMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.EntityDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.EntitySerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.LaxContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.StrictContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpResponseParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.HttpRequestWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.EofSensor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpTransportMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.net.SocketTimeoutException;

@Deprecated
public abstract class AbstractHttpClientConnection
  implements HttpClientConnection
{
  private final EntitySerializer entityserializer;
  private final EntityDeserializer entitydeserializer;
  private SessionInputBuffer inbuffer = null;
  private SessionOutputBuffer outbuffer = null;
  private EofSensor eofSensor = null;
  private HttpMessageParser<HttpResponse> responseParser = null;
  private HttpMessageWriter<HttpRequest> requestWriter = null;
  private HttpConnectionMetricsImpl metrics = null;
  
  public AbstractHttpClientConnection()
  {
    entityserializer = createEntitySerializer();
    entitydeserializer = createEntityDeserializer();
  }
  
  protected abstract void assertOpen()
    throws IllegalStateException;
  
  protected EntityDeserializer createEntityDeserializer()
  {
    return new EntityDeserializer(new LaxContentLengthStrategy());
  }
  
  protected EntitySerializer createEntitySerializer()
  {
    return new EntitySerializer(new StrictContentLengthStrategy());
  }
  
  protected HttpResponseFactory createHttpResponseFactory()
  {
    return DefaultHttpResponseFactory.INSTANCE;
  }
  
  protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer buffer, HttpResponseFactory responseFactory, HttpParams params)
  {
    return new DefaultHttpResponseParser(buffer, null, responseFactory, params);
  }
  
  protected HttpMessageWriter<HttpRequest> createRequestWriter(SessionOutputBuffer buffer, HttpParams params)
  {
    return new HttpRequestWriter(buffer, null, params);
  }
  
  protected HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics inTransportMetric, HttpTransportMetrics outTransportMetric)
  {
    return new HttpConnectionMetricsImpl(inTransportMetric, outTransportMetric);
  }
  
  protected void init(SessionInputBuffer inbuffer, SessionOutputBuffer outbuffer, HttpParams params)
  {
    this.inbuffer = ((SessionInputBuffer)Args.notNull(inbuffer, "Input session buffer"));
    this.outbuffer = ((SessionOutputBuffer)Args.notNull(outbuffer, "Output session buffer"));
    if ((inbuffer instanceof EofSensor)) {
      eofSensor = ((EofSensor)inbuffer);
    }
    responseParser = createResponseParser(inbuffer, createHttpResponseFactory(), params);
    
    requestWriter = createRequestWriter(outbuffer, params);
    
    metrics = createConnectionMetrics(inbuffer.getMetrics(), outbuffer.getMetrics());
  }
  
  public boolean isResponseAvailable(int timeout)
    throws IOException
  {
    assertOpen();
    try
    {
      return inbuffer.isDataAvailable(timeout);
    }
    catch (SocketTimeoutException ex) {}
    return false;
  }
  
  public void sendRequestHeader(HttpRequest request)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    assertOpen();
    requestWriter.write(request);
    metrics.incrementRequestCount();
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest request)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    assertOpen();
    if (request.getEntity() == null) {
      return;
    }
    entityserializer.serialize(outbuffer, request, request.getEntity());
  }
  
  protected void doFlush()
    throws IOException
  {
    outbuffer.flush();
  }
  
  public void flush()
    throws IOException
  {
    assertOpen();
    doFlush();
  }
  
  public HttpResponse receiveResponseHeader()
    throws HttpException, IOException
  {
    assertOpen();
    HttpResponse response = (HttpResponse)responseParser.parse();
    if (response.getStatusLine().getStatusCode() >= 200) {
      metrics.incrementResponseCount();
    }
    return response;
  }
  
  public void receiveResponseEntity(HttpResponse response)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    assertOpen();
    HttpEntity entity = entitydeserializer.deserialize(inbuffer, response);
    response.setEntity(entity);
  }
  
  protected boolean isEof()
  {
    return (eofSensor != null) && (eofSensor.isEof());
  }
  
  public boolean isStale()
  {
    if (!isOpen()) {
      return true;
    }
    if (isEof()) {
      return true;
    }
    try
    {
      inbuffer.isDataAvailable(1);
      return isEof();
    }
    catch (SocketTimeoutException ex)
    {
      return false;
    }
    catch (IOException ex) {}
    return true;
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    return metrics;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.AbstractHttpClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */