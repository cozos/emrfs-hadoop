package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

final class UploadObserverContext$BasicStore
  implements UploadObserverContext.Store
{
  public String toString()
  {
    return "UploadObserverContext.BasicStore(storedValues=" + storedValues + ")";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof BasicStore)) {
      return false;
    }
    BasicStore other = (BasicStore)o;Object this$storedValues = storedValues;Object other$storedValues = storedValues;return this$storedValues == null ? other$storedValues == null : this$storedValues.equals(other$storedValues);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $storedValues = storedValues;result = result * 59 + ($storedValues == null ? 43 : $storedValues.hashCode());return result;
  }
  
  private final Map<UploadObserverContext.Store.Key<?>, Object> storedValues = new HashMap();
  
  public <T> T get(@NonNull UploadObserverContext.Store.Key<T> key)
  {
    if (key == null) {
      throw new NullPointerException("key");
    }
    return (T)storedValues.get(key);
  }
  
  public <T> void put(@NonNull UploadObserverContext.Store.Key<T> key, T value)
  {
    if (key == null) {
      throw new NullPointerException("key");
    }
    storedValues.put(key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserverContext.BasicStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */