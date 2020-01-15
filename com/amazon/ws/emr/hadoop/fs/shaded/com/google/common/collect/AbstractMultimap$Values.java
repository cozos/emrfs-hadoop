package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;
import javax.annotation.Nullable;

class AbstractMultimap$Values
  extends AbstractCollection<V>
{
  AbstractMultimap$Values(AbstractMultimap paramAbstractMultimap) {}
  
  public Iterator<V> iterator()
  {
    return this$0.valueIterator();
  }
  
  public int size()
  {
    return this$0.size();
  }
  
  public boolean contains(@Nullable Object o)
  {
    return this$0.containsValue(o);
  }
  
  public void clear()
  {
    this$0.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMultimap.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */