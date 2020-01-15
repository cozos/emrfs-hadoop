package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthSchemeProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.nio.charset.Charset;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicSchemeFactory
  implements AuthSchemeFactory, AuthSchemeProvider
{
  private final Charset charset;
  
  public BasicSchemeFactory(Charset charset)
  {
    this.charset = charset;
  }
  
  public BasicSchemeFactory()
  {
    this(null);
  }
  
  public AuthScheme newInstance(HttpParams params)
  {
    return new BasicScheme();
  }
  
  public AuthScheme create(HttpContext context)
  {
    return new BasicScheme(charset);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.BasicSchemeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */