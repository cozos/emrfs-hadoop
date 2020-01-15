package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

import java.util.Map;

class StrLookup$MapStrLookup<V>
  extends StrLookup<V>
{
  private final Map<String, V> map;
  
  StrLookup$MapStrLookup(Map<String, V> map)
  {
    this.map = map;
  }
  
  public String lookup(String key)
  {
    if (map == null) {
      return null;
    }
    Object obj = map.get(key);
    if (obj == null) {
      return null;
    }
    return obj.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrLookup.MapStrLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */