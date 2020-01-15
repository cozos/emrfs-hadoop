package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.DecompressingEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.DeflateInputStreamFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.GZIPInputStreamFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.InputStreamFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Lookup;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.RegistryBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.util.Locale;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class ResponseContentEncoding
  implements HttpResponseInterceptor
{
  public static final String UNCOMPRESSED = "http.client.response.uncompressed";
  private final Lookup<InputStreamFactory> decoderRegistry;
  private final boolean ignoreUnknown;
  
  public ResponseContentEncoding(Lookup<InputStreamFactory> decoderRegistry, boolean ignoreUnknown)
  {
    this.decoderRegistry = (decoderRegistry != null ? decoderRegistry : RegistryBuilder.create().register("gzip", GZIPInputStreamFactory.getInstance()).register("x-gzip", GZIPInputStreamFactory.getInstance()).register("deflate", DeflateInputStreamFactory.getInstance()).build());
    
    this.ignoreUnknown = ignoreUnknown;
  }
  
  public ResponseContentEncoding(boolean ignoreUnknown)
  {
    this(null, ignoreUnknown);
  }
  
  public ResponseContentEncoding(Lookup<InputStreamFactory> decoderRegistry)
  {
    this(decoderRegistry, true);
  }
  
  public ResponseContentEncoding()
  {
    this(null);
  }
  
  public void process(HttpResponse response, HttpContext context)
    throws HttpException, IOException
  {
    HttpEntity entity = response.getEntity();
    
    HttpClientContext clientContext = HttpClientContext.adapt(context);
    RequestConfig requestConfig = clientContext.getRequestConfig();
    if ((requestConfig.isContentCompressionEnabled()) && (entity != null) && (entity.getContentLength() != 0L))
    {
      Header ceheader = entity.getContentEncoding();
      if (ceheader != null)
      {
        HeaderElement[] codecs = ceheader.getElements();
        for (HeaderElement codec : codecs)
        {
          String codecname = codec.getName().toLowerCase(Locale.ROOT);
          InputStreamFactory decoderFactory = (InputStreamFactory)decoderRegistry.lookup(codecname);
          if (decoderFactory != null)
          {
            response.setEntity(new DecompressingEntity(response.getEntity(), decoderFactory));
            response.removeHeaders("Content-Length");
            response.removeHeaders("Content-Encoding");
            response.removeHeaders("Content-MD5");
          }
          else if ((!"identity".equals(codecname)) && (!ignoreUnknown))
          {
            throw new HttpException("Unsupported Content-Encoding: " + codec.getName());
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.ResponseContentEncoding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */