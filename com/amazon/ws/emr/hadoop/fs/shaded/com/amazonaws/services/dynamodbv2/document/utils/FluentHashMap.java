package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils;

import java.util.LinkedHashMap;

public class FluentHashMap<K, V>
  extends LinkedHashMap<K, V>
{
  private static final long serialVersionUID = 4857340227048063855L;
  
  public FluentHashMap<K, V> delete(Object key)
  {
    remove(key);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils.FluentHashMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */