package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricInputStreamEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.ThroughputMetricType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.internal.ServiceMetricTypeGuesser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.BasicHttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.InputStreamEntity;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class RepeatableInputStreamRequestEntity
  extends BasicHttpEntity
{
  private boolean firstAttempt = true;
  private InputStreamEntity inputStreamRequestEntity;
  private InputStream content;
  private static final Log log = LogFactory.getLog(RepeatableInputStreamRequestEntity.class);
  private IOException originalException;
  
  public RepeatableInputStreamRequestEntity(Request<?> request)
  {
    setChunked(false);
    
    long contentLength = -1L;
    try
    {
      String contentLengthString = (String)request.getHeaders().get("Content-Length");
      if (contentLengthString != null) {
        contentLength = Long.parseLong(contentLengthString);
      }
    }
    catch (NumberFormatException nfe)
    {
      log.warn("Unable to parse content length from request.  Buffering contents in memory.");
    }
    String contentType = (String)request.getHeaders().get("Content-Type");
    
    ThroughputMetricType type = ServiceMetricTypeGuesser.guessThroughputMetricType(request, "UploadThroughput", "UploadByteCount");
    
    content = getContent(request);
    inputStreamRequestEntity = (type == null ? new InputStreamEntity(content, contentLength) : new MetricInputStreamEntity(type, content, contentLength));
    
    inputStreamRequestEntity.setContentType(contentType);
    
    setContent(content);
    setContentType(contentType);
    setContentLength(contentLength);
  }
  
  private InputStream getContent(Request<?> request)
  {
    return request.getContent() == null ? new ByteArrayInputStream(new byte[0]) : request
      .getContent();
  }
  
  public boolean isChunked()
  {
    return false;
  }
  
  public boolean isRepeatable()
  {
    return (content.markSupported()) || (inputStreamRequestEntity.isRepeatable());
  }
  
  public void writeTo(OutputStream output)
    throws IOException
  {
    try
    {
      if ((!firstAttempt) && (isRepeatable())) {
        content.reset();
      }
      firstAttempt = false;
      inputStreamRequestEntity.writeTo(output);
    }
    catch (IOException ioe)
    {
      if (originalException == null) {
        originalException = ioe;
      }
      throw originalException;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.RepeatableInputStreamRequestEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */