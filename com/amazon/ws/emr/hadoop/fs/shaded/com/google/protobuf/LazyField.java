package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

class LazyField
{
  private final MessageLite defaultInstance;
  private final ExtensionRegistryLite extensionRegistry;
  private ByteString bytes;
  private volatile MessageLite value;
  private volatile boolean isDirty = false;
  
  public LazyField(MessageLite defaultInstance, ExtensionRegistryLite extensionRegistry, ByteString bytes)
  {
    this.defaultInstance = defaultInstance;
    this.extensionRegistry = extensionRegistry;
    this.bytes = bytes;
  }
  
  public MessageLite getValue()
  {
    ensureInitialized();
    return value;
  }
  
  public MessageLite setValue(MessageLite value)
  {
    MessageLite originalValue = this.value;
    this.value = value;
    bytes = null;
    isDirty = true;
    return originalValue;
  }
  
  public int getSerializedSize()
  {
    if (isDirty) {
      return value.getSerializedSize();
    }
    return bytes.size();
  }
  
  public ByteString toByteString()
  {
    if (!isDirty) {
      return bytes;
    }
    synchronized (this)
    {
      if (!isDirty) {
        return bytes;
      }
      bytes = value.toByteString();
      isDirty = false;
      return bytes;
    }
  }
  
  public int hashCode()
  {
    ensureInitialized();
    return value.hashCode();
  }
  
  public boolean equals(Object obj)
  {
    ensureInitialized();
    return value.equals(obj);
  }
  
  public String toString()
  {
    ensureInitialized();
    return value.toString();
  }
  
  private void ensureInitialized()
  {
    if (value != null) {
      return;
    }
    synchronized (this)
    {
      if (value != null) {
        return;
      }
      try
      {
        if (bytes != null) {
          value = ((MessageLite)defaultInstance.getParserForType().parseFrom(bytes, extensionRegistry));
        }
      }
      catch (IOException e) {}
    }
  }
  
  static class LazyEntry<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, LazyField> entry;
    
    private LazyEntry(Map.Entry<K, LazyField> entry)
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
  
  static class LazyIterator<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> iterator;
    
    public LazyIterator(Iterator<Map.Entry<K, Object>> iterator)
    {
      this.iterator = iterator;
    }
    
    public boolean hasNext()
    {
      return iterator.hasNext();
    }
    
    public Map.Entry<K, Object> next()
    {
      Map.Entry<K, ?> entry = (Map.Entry)iterator.next();
      if ((entry.getValue() instanceof LazyField)) {
        return new LazyField.LazyEntry(entry, null);
      }
      return entry;
    }
    
    public void remove()
    {
      iterator.remove();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.LazyField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */