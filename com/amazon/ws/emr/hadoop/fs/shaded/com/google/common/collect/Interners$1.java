package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentMap;

final class Interners$1
  implements Interner<E>
{
  Interners$1(ConcurrentMap paramConcurrentMap) {}
  
  public E intern(E sample)
  {
    E canonical = val$map.putIfAbsent(Preconditions.checkNotNull(sample), sample);
    return canonical == null ? sample : canonical;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Interners.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */