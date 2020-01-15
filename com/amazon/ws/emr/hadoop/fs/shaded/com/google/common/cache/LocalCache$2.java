package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$2
  extends AbstractQueue<Object>
{
  public boolean offer(Object o)
  {
    return true;
  }
  
  public Object peek()
  {
    return null;
  }
  
  public Object poll()
  {
    return null;
  }
  
  public int size()
  {
    return 0;
  }
  
  public Iterator<Object> iterator()
  {
    return ImmutableSet.of().iterator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */