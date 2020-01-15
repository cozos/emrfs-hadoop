package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicLineFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineFormatter;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpRequestWriterFactory
  implements HttpMessageWriterFactory<HttpRequest>
{
  public static final DefaultHttpRequestWriterFactory INSTANCE = new DefaultHttpRequestWriterFactory();
  private final LineFormatter lineFormatter;
  
  public DefaultHttpRequestWriterFactory(LineFormatter lineFormatter)
  {
    this.lineFormatter = (lineFormatter != null ? lineFormatter : BasicLineFormatter.INSTANCE);
  }
  
  public DefaultHttpRequestWriterFactory()
  {
    this(null);
  }
  
  public HttpMessageWriter<HttpRequest> create(SessionOutputBuffer buffer)
  {
    return new DefaultHttpRequestWriter(buffer, lineFormatter);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpRequestWriterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */