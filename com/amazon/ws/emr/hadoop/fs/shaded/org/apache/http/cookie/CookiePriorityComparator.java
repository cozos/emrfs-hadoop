package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.BasicClientCookie;
import java.util.Comparator;
import java.util.Date;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class CookiePriorityComparator
  implements Comparator<Cookie>
{
  public static final CookiePriorityComparator INSTANCE = new CookiePriorityComparator();
  
  private int getPathLength(Cookie cookie)
  {
    String path = cookie.getPath();
    return path != null ? path.length() : 1;
  }
  
  public int compare(Cookie c1, Cookie c2)
  {
    int l1 = getPathLength(c1);
    int l2 = getPathLength(c2);
    
    int result = l2 - l1;
    if ((result == 0) && ((c1 instanceof BasicClientCookie)) && ((c2 instanceof BasicClientCookie)))
    {
      Date d1 = ((BasicClientCookie)c1).getCreationDate();
      Date d2 = ((BasicClientCookie)c2).getCreationDate();
      if ((d1 != null) && (d2 != null)) {
        return (int)(d1.getTime() - d2.getTime());
      }
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookiePriorityComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */