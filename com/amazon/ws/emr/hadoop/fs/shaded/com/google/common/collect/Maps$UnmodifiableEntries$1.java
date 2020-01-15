package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class Maps$UnmodifiableEntries$1
  extends UnmodifiableIterator<Map.Entry<K, V>>
{
  Maps$UnmodifiableEntries$1(Maps.UnmodifiableEntries paramUnmodifiableEntries, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$delegate.hasNext();
  }
  
  public Map.Entry<K, V> next()
  {
    return Maps.unmodifiableEntry((Map.Entry)val$delegate.next());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.UnmodifiableEntries.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */