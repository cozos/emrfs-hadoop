package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
public class BasicHttpContext
  implements HttpContext
{
  private final HttpContext parentContext;
  private final Map<String, Object> map;
  
  public BasicHttpContext()
  {
    this(null);
  }
  
  public BasicHttpContext(HttpContext parentContext)
  {
    map = new ConcurrentHashMap();
    this.parentContext = parentContext;
  }
  
  public Object getAttribute(String id)
  {
    Args.notNull(id, "Id");
    Object obj = map.get(id);
    if ((obj == null) && (parentContext != null)) {
      obj = parentContext.getAttribute(id);
    }
    return obj;
  }
  
  public void setAttribute(String id, Object obj)
  {
    Args.notNull(id, "Id");
    if (obj != null) {
      map.put(id, obj);
    } else {
      map.remove(id);
    }
  }
  
  public Object removeAttribute(String id)
  {
    Args.notNull(id, "Id");
    return map.remove(id);
  }
  
  public void clear()
  {
    map.clear();
  }
  
  public String toString()
  {
    return map.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.BasicHttpContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */