package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class LaxRedirectStrategy
  extends DefaultRedirectStrategy
{
  public static final LaxRedirectStrategy INSTANCE = new LaxRedirectStrategy();
  private static final String[] REDIRECT_METHODS = { "GET", "POST", "HEAD", "DELETE" };
  
  protected boolean isRedirectable(String method)
  {
    for (String m : REDIRECT_METHODS) {
      if (m.equalsIgnoreCase(method)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.LaxRedirectStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */