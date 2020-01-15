package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicLineFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.LineFormatter;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpResponseWriterFactory
  implements HttpMessageWriterFactory<HttpResponse>
{
  public static final DefaultHttpResponseWriterFactory INSTANCE = new DefaultHttpResponseWriterFactory();
  private final LineFormatter lineFormatter;
  
  public DefaultHttpResponseWriterFactory(LineFormatter lineFormatter)
  {
    this.lineFormatter = (lineFormatter != null ? lineFormatter : BasicLineFormatter.INSTANCE);
  }
  
  public DefaultHttpResponseWriterFactory()
  {
    this(null);
  }
  
  public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer buffer)
  {
    return new DefaultHttpResponseWriter(buffer, lineFormatter);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.DefaultHttpResponseWriterFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */