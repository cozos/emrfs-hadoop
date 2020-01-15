package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class ResponseMetadataCache$InternalCache
  extends LinkedHashMap<Integer, ResponseMetadata>
{
  private static final long serialVersionUID = 1L;
  private int maxSize;
  
  ResponseMetadataCache$InternalCache(int maxSize)
  {
    super(maxSize);
    this.maxSize = maxSize;
  }
  
  protected boolean removeEldestEntry(Map.Entry<Integer, ResponseMetadata> eldest)
  {
    return size() > maxSize;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ResponseMetadataCache.InternalCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */