package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Contract(threading=ThreadingBehavior.SAFE)
public class UriPatternMatcher<T>
{
  private final Map<String, T> map;
  
  public UriPatternMatcher()
  {
    map = new HashMap();
  }
  
  public synchronized Set<Map.Entry<String, T>> entrySet()
  {
    return new HashSet(map.entrySet());
  }
  
  public synchronized void register(String pattern, T obj)
  {
    Args.notNull(pattern, "URI request pattern");
    map.put(pattern, obj);
  }
  
  public synchronized void unregister(String pattern)
  {
    if (pattern == null) {
      return;
    }
    map.remove(pattern);
  }
  
  @Deprecated
  public synchronized void setHandlers(Map<String, T> map)
  {
    Args.notNull(map, "Map of handlers");
    this.map.clear();
    this.map.putAll(map);
  }
  
  @Deprecated
  public synchronized void setObjects(Map<String, T> map)
  {
    Args.notNull(map, "Map of handlers");
    this.map.clear();
    this.map.putAll(map);
  }
  
  @Deprecated
  public synchronized Map<String, T> getObjects()
  {
    return map;
  }
  
  public synchronized T lookup(String path)
  {
    Args.notNull(path, "Request path");
    
    T obj = map.get(path);
    String bestMatch;
    if (obj == null)
    {
      bestMatch = null;
      for (String pattern : map.keySet()) {
        if (matchUriRequestPattern(pattern, path)) {
          if ((bestMatch == null) || (bestMatch.length() < pattern.length()) || ((bestMatch.length() == pattern.length()) && (pattern.endsWith("*"))))
          {
            obj = map.get(pattern);
            bestMatch = pattern;
          }
        }
      }
    }
    return obj;
  }
  
  protected boolean matchUriRequestPattern(String pattern, String path)
  {
    if (pattern.equals("*")) {
      return true;
    }
    return ((pattern.endsWith("*")) && (path.startsWith(pattern.substring(0, pattern.length() - 1)))) || ((pattern.startsWith("*")) && (path.endsWith(pattern.substring(1, pattern.length()))));
  }
  
  public String toString()
  {
    return map.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.UriPatternMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */