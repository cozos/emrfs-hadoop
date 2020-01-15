package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

@SdkInternalApi
public class ResponseMetadataCache
  implements MetadataCache
{
  private final InternalCache internalCache;
  
  public ResponseMetadataCache(int maxEntries)
  {
    internalCache = new InternalCache(maxEntries);
  }
  
  public synchronized void add(Object obj, ResponseMetadata metadata)
  {
    if (obj == null) {
      return;
    }
    internalCache.put(Integer.valueOf(System.identityHashCode(obj)), metadata);
  }
  
  public synchronized ResponseMetadata get(Object obj)
  {
    return (ResponseMetadata)internalCache.get(Integer.valueOf(System.identityHashCode(obj)));
  }
  
  private static final class InternalCache
    extends LinkedHashMap<Integer, ResponseMetadata>
  {
    private static final long serialVersionUID = 1L;
    private int maxSize;
    
    InternalCache(int maxSize)
    {
      super();
      this.maxSize = maxSize;
    }
    
    protected boolean removeEldestEntry(Map.Entry<Integer, ResponseMetadata> eldest)
    {
      return size() > maxSize;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ResponseMetadataCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */