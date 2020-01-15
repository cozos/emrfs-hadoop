package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapUtils
{
  public static Map copy(Map source)
  {
    if (source == null) {
      return null;
    }
    Map result = new HashMap();
    result.putAll(source);
    return result;
  }
  
  public static Map prefix(Map source, String prefix)
  {
    if (source == null) {
      return null;
    }
    Map result = new HashMap();
    
    Iterator iter = source.entrySet().iterator();
    while (iter.hasNext())
    {
      Map.Entry entry = (Map.Entry)iter.next();
      Object key = entry.getKey();
      Object value = entry.getValue();
      result.put(prefix + '.' + key.toString(), value);
    }
    return result;
  }
  
  public static Map merge(Map lhs, Map rhs)
  {
    Map result = null;
    if ((lhs == null) || (lhs.size() == 0))
    {
      result = copy(rhs);
    }
    else if ((rhs == null) || (rhs.size() == 0))
    {
      result = copy(lhs);
    }
    else
    {
      result = copy(lhs);
      result.putAll(rhs);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.util.MapUtils
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */