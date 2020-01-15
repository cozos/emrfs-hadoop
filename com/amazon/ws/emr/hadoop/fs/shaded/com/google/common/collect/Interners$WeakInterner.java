package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;

class Interners$WeakInterner<E>
  implements Interner<E>
{
  private final MapMakerInternalMap<E, Dummy> map;
  
  private Interners$WeakInterner()
  {
    map = new MapMaker().weakKeys().keyEquivalence(Equivalence.equals()).makeCustomMap();
  }
  
  public E intern(E sample)
  {
    for (;;)
    {
      MapMakerInternalMap.ReferenceEntry<E, Dummy> entry = map.getEntry(sample);
      if (entry != null)
      {
        E canonical = entry.getKey();
        if (canonical != null) {
          return canonical;
        }
      }
      Dummy sneaky = (Dummy)map.putIfAbsent(sample, Dummy.VALUE);
      if (sneaky == null) {
        return sample;
      }
    }
  }
  
  private static enum Dummy
  {
    VALUE;
    
    private Dummy() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Interners.WeakInterner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */