package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class Punycode
{
  private static final Idn impl;
  
  static
  {
    Idn _impl;
    try
    {
      _impl = new JdkIdn();
    }
    catch (Exception e)
    {
      _impl = new Rfc3492Idn();
    }
    impl = _impl;
  }
  
  public static String toUnicode(String punycode)
  {
    return impl.toUnicode(punycode);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.Punycode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */