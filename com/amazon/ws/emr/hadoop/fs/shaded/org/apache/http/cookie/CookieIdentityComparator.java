package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.io.Serializable;
import java.util.Comparator;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class CookieIdentityComparator
  implements Serializable, Comparator<Cookie>
{
  private static final long serialVersionUID = 4466565437490631532L;
  
  public int compare(Cookie c1, Cookie c2)
  {
    int res = c1.getName().compareTo(c2.getName());
    if (res == 0)
    {
      String d1 = c1.getDomain();
      if (d1 == null) {
        d1 = "";
      } else if (d1.indexOf('.') == -1) {
        d1 = d1 + ".local";
      }
      String d2 = c2.getDomain();
      if (d2 == null) {
        d2 = "";
      } else if (d2.indexOf('.') == -1) {
        d2 = d2 + ".local";
      }
      res = d1.compareToIgnoreCase(d2);
    }
    if (res == 0)
    {
      String p1 = c1.getPath();
      if (p1 == null) {
        p1 = "/";
      }
      String p2 = c2.getPath();
      if (p2 == null) {
        p2 = "/";
      }
      res = p1.compareTo(p2);
    }
    return res;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieIdentityComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */