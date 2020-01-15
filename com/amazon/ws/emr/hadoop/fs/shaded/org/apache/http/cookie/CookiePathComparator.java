package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.io.Serializable;
import java.util.Comparator;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class CookiePathComparator
  implements Serializable, Comparator<Cookie>
{
  public static final CookiePathComparator INSTANCE = new CookiePathComparator();
  private static final long serialVersionUID = 7523645369616405818L;
  
  private String normalizePath(Cookie cookie)
  {
    String path = cookie.getPath();
    if (path == null) {
      path = "/";
    }
    if (!path.endsWith("/")) {
      path = path + '/';
    }
    return path;
  }
  
  public int compare(Cookie c1, Cookie c2)
  {
    String path1 = normalizePath(c1);
    String path2 = normalizePath(c2);
    if (path1.equals(path2)) {
      return 0;
    }
    if (path1.startsWith(path2)) {
      return -1;
    }
    if (path2.startsWith(path1)) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookiePathComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */