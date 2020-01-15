package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE)
public class BestMatchSpec
  extends DefaultCookieSpec
{
  public BestMatchSpec(String[] datepatterns, boolean oneHeader)
  {
    super(datepatterns, oneHeader);
  }
  
  public BestMatchSpec()
  {
    this(null, false);
  }
  
  public String toString()
  {
    return "best-match";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BestMatchSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */