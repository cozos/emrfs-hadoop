package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Map.Entry;

class LazyField$LazyEntry<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, LazyField> entry;
  
  private LazyField$LazyEntry(Map.Entry<K, LazyField> entry)
  {
    this.entry = entry;
  }
  
  public K getKey()
  {
    return (K)entry.getKey();
  }
  
  public Object getValue()
  {
    LazyField field = (LazyField)entry.getValue();
    if (field == null) {
      return null;
    }
    return field.getValue();
  }
  
  public LazyField getField()
  {
    return (LazyField)entry.getValue();
  }
  
  public Object setValue(Object value)
  {
    if (!(value instanceof MessageLite)) {
      throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
    return ((LazyField)entry.getValue()).setValue((MessageLite)value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.LazyField.LazyEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */