package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HTTP;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.nio.charset.Charset;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public final class AuthParams
{
  public static String getCredentialCharset(HttpParams params)
  {
    Args.notNull(params, "HTTP parameters");
    String charset = (String)params.getParameter("http.auth.credential-charset");
    if (charset == null) {
      charset = HTTP.DEF_PROTOCOL_CHARSET.name();
    }
    return charset;
  }
  
  public static void setCredentialCharset(HttpParams params, String charset)
  {
    Args.notNull(params, "HTTP parameters");
    params.setParameter("http.auth.credential-charset", charset);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.params.AuthParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */