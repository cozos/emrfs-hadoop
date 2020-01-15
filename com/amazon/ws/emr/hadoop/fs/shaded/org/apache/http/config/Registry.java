package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading=ThreadingBehavior.SAFE)
public final class Registry<I>
  implements Lookup<I>
{
  private final Map<String, I> map;
  
  Registry(Map<String, I> map)
  {
    this.map = new ConcurrentHashMap(map);
  }
  
  public I lookup(String key)
  {
    if (key == null) {
      return null;
    }
    return (I)map.get(key.toLowerCase(Locale.ROOT));
  }
  
  public String toString()
  {
    return map.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.Registry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */