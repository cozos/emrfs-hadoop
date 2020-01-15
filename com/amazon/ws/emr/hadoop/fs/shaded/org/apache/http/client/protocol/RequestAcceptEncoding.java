package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.util.List;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class RequestAcceptEncoding
  implements HttpRequestInterceptor
{
  private final String acceptEncoding;
  
  public RequestAcceptEncoding(List<String> encodings)
  {
    if ((encodings != null) && (!encodings.isEmpty()))
    {
      StringBuilder buf = new StringBuilder();
      for (int i = 0; i < encodings.size(); i++)
      {
        if (i > 0) {
          buf.append(",");
        }
        buf.append((String)encodings.get(i));
      }
      acceptEncoding = buf.toString();
    }
    else
    {
      acceptEncoding = "gzip,deflate";
    }
  }
  
  public RequestAcceptEncoding()
  {
    this(null);
  }
  
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    RequestConfig requestConfig = clientContext.getRequestConfig();
    if ((!request.containsHeader("Accept-Encoding")) && (requestConfig.isContentCompressionEnabled())) {
      request.addHeader("Accept-Encoding", acceptEncoding);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestAcceptEncoding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */