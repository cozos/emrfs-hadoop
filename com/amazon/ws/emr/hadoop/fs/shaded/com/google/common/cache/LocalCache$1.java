package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class LocalCache$1
  implements LocalCache.ValueReference<Object, Object>
{
  public Object get()
  {
    return null;
  }
  
  public int getWeight()
  {
    return 0;
  }
  
  public LocalCache.ReferenceEntry<Object, Object> getEntry()
  {
    return null;
  }
  
  public LocalCache.ValueReference<Object, Object> copyFor(ReferenceQueue<Object> queue, @Nullable Object value, LocalCache.ReferenceEntry<Object, Object> entry)
  {
    return this;
  }
  
  public boolean isLoading()
  {
    return false;
  }
  
  public boolean isActive()
  {
    return false;
  }
  
  public Object waitForValue()
  {
    return null;
  }
  
  public void notifyNewValue(Object newValue) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */