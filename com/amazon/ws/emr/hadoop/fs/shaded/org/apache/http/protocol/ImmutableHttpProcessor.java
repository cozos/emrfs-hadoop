package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.io.IOException;
import java.util.List;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public final class ImmutableHttpProcessor
  implements HttpProcessor
{
  private final HttpRequestInterceptor[] requestInterceptors;
  private final HttpResponseInterceptor[] responseInterceptors;
  
  public ImmutableHttpProcessor(HttpRequestInterceptor[] requestInterceptors, HttpResponseInterceptor[] responseInterceptors)
  {
    if (requestInterceptors != null)
    {
      int l = requestInterceptors.length;
      this.requestInterceptors = new HttpRequestInterceptor[l];
      System.arraycopy(requestInterceptors, 0, this.requestInterceptors, 0, l);
    }
    else
    {
      this.requestInterceptors = new HttpRequestInterceptor[0];
    }
    if (responseInterceptors != null)
    {
      int l = responseInterceptors.length;
      this.responseInterceptors = new HttpResponseInterceptor[l];
      System.arraycopy(responseInterceptors, 0, this.responseInterceptors, 0, l);
    }
    else
    {
      this.responseInterceptors = new HttpResponseInterceptor[0];
    }
  }
  
  public ImmutableHttpProcessor(List<HttpRequestInterceptor> requestInterceptors, List<HttpResponseInterceptor> responseInterceptors)
  {
    if (requestInterceptors != null)
    {
      int l = requestInterceptors.size();
      this.requestInterceptors = ((HttpRequestInterceptor[])requestInterceptors.toArray(new HttpRequestInterceptor[l]));
    }
    else
    {
      this.requestInterceptors = new HttpRequestInterceptor[0];
    }
    if (responseInterceptors != null)
    {
      int l = responseInterceptors.size();
      this.responseInterceptors = ((HttpResponseInterceptor[])responseInterceptors.toArray(new HttpResponseInterceptor[l]));
    }
    else
    {
      this.responseInterceptors = new HttpResponseInterceptor[0];
    }
  }
  
  @Deprecated
  public ImmutableHttpProcessor(HttpRequestInterceptorList requestInterceptors, HttpResponseInterceptorList responseInterceptors)
  {
    if (requestInterceptors != null)
    {
      int count = requestInterceptors.getRequestInterceptorCount();
      this.requestInterceptors = new HttpRequestInterceptor[count];
      for (int i = 0; i < count; i++) {
        this.requestInterceptors[i] = requestInterceptors.getRequestInterceptor(i);
      }
    }
    else
    {
      this.requestInterceptors = new HttpRequestInterceptor[0];
    }
    if (responseInterceptors != null)
    {
      int count = responseInterceptors.getResponseInterceptorCount();
      this.responseInterceptors = new HttpResponseInterceptor[count];
      for (int i = 0; i < count; i++) {
        this.responseInterceptors[i] = responseInterceptors.getResponseInterceptor(i);
      }
    }
    else
    {
      this.responseInterceptors = new HttpResponseInterceptor[0];
    }
  }
  
  public ImmutableHttpProcessor(HttpRequestInterceptor... requestInterceptors)
  {
    this(requestInterceptors, null);
  }
  
  public ImmutableHttpProcessor(HttpResponseInterceptor... responseInterceptors)
  {
    this(null, responseInterceptors);
  }
  
  public void process(HttpRequest request, HttpContext context)
    throws IOException, HttpException
  {
    for (HttpRequestInterceptor requestInterceptor : requestInterceptors) {
      requestInterceptor.process(request, context);
    }
  }
  
  public void process(HttpResponse response, HttpContext context)
    throws IOException, HttpException
  {
    for (HttpResponseInterceptor responseInterceptor : responseInterceptors) {
      responseInterceptor.process(response, context);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.ImmutableHttpProcessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */