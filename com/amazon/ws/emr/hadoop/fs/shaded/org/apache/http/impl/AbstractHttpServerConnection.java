package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnectionMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpServerConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.EntityDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.EntitySerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.LaxContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.StrictContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpRequestParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.HttpResponseWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.EofSensor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpTransportMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Deprecated
public abstract class AbstractHttpServerConnection
  implements HttpServerConnection
{
  private final EntitySerializer entityserializer;
  private final EntityDeserializer entitydeserializer;
  private SessionInputBuffer inbuffer = null;
  private SessionOutputBuffer outbuffer = null;
  private EofSensor eofSensor = null;
  private HttpMessageParser<HttpRequest> requestParser = null;
  private HttpMessageWriter<HttpResponse> responseWriter = null;
  private HttpConnectionMetricsImpl metrics = null;
  
  public AbstractHttpServerConnection()
  {
    entityserializer = createEntitySerializer();
    entitydeserializer = createEntityDeserializer();
  }
  
  protected abstract void assertOpen()
    throws IllegalStateException;
  
  protected EntityDeserializer createEntityDeserializer()
  {
    return new EntityDeserializer(new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0)));
  }
  
  protected EntitySerializer createEntitySerializer()
  {
    return new EntitySerializer(new StrictContentLengthStrategy());
  }
  
  protected HttpRequestFactory createHttpRequestFactory()
  {
    return DefaultHttpRequestFactory.INSTANCE;
  }
  
  protected HttpMessageParser<HttpRequest> createRequestParser(SessionInputBuffer buffer, HttpRequestFactory requestFactory, HttpParams params)
  {
    return new DefaultHttpRequestParser(buffer, null, requestFactory, params);
  }
  
  protected HttpMessageWriter<HttpResponse> createResponseWriter(SessionOutputBuffer buffer, HttpParams params)
  {
    return new HttpResponseWriter(buffer, null, params);
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
    requestParser = createRequestParser(inbuffer, createHttpRequestFactory(), params);
    
    responseWriter = createResponseWriter(outbuffer, params);
    
    metrics = createConnectionMetrics(inbuffer.getMetrics(), outbuffer.getMetrics());
  }
  
  public HttpRequest receiveRequestHeader()
    throws HttpException, IOException
  {
    assertOpen();
    HttpRequest request = (HttpRequest)requestParser.parse();
    metrics.incrementRequestCount();
    return request;
  }
  
  public void receiveRequestEntity(HttpEntityEnclosingRequest request)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    assertOpen();
    HttpEntity entity = entitydeserializer.deserialize(inbuffer, request);
    request.setEntity(entity);
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
  
  public void sendResponseHeader(HttpResponse response)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    assertOpen();
    responseWriter.write(response);
    if (response.getStatusLine().getStatusCode() >= 200) {
      metrics.incrementResponseCount();
    }
  }
  
  public void sendResponseEntity(HttpResponse response)
    throws HttpException, IOException
  {
    if (response.getEntity() == null) {
      return;
    }
    entityserializer.serialize(outbuffer, response, response.getEntity());
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
    catch (IOException ex) {}
    return true;
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    return metrics;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.AbstractHttpServerConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */