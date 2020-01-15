package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

class AbstractBiMap$ValueSet
  extends ForwardingSet<V>
{
  final Set<V> valuesDelegate = this$0.inverse.keySet();
  
  private AbstractBiMap$ValueSet(AbstractBiMap paramAbstractBiMap) {}
  
  protected Set<V> delegate()
  {
    return valuesDelegate;
  }
  
  public Iterator<V> iterator()
  {
    return Maps.valueIterator(this$0.entrySet().iterator());
  }
  
  public Object[] toArray()
  {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] array)
  {
    return standardToArray(array);
  }
  
  public String toString()
  {
    return standardToString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractBiMap.ValueSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */