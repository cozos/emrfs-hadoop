package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AbstractBiMap$KeySet
  extends ForwardingSet<K>
{
  private AbstractBiMap$KeySet(AbstractBiMap paramAbstractBiMap) {}
  
  protected Set<K> delegate()
  {
    return AbstractBiMap.access$200(this$0).keySet();
  }
  
  public void clear()
  {
    this$0.clear();
  }
  
  public boolean remove(Object key)
  {
    if (!contains(key)) {
      return false;
    }
    AbstractBiMap.access$300(this$0, key);
    return true;
  }
  
  public boolean removeAll(Collection<?> keysToRemove)
  {
    return standardRemoveAll(keysToRemove);
  }
  
  public boolean retainAll(Collection<?> keysToRetain)
  {
    return standardRetainAll(keysToRetain);
  }
  
  public Iterator<K> iterator()
  {
    return Maps.keyIterator(this$0.entrySet().iterator());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractBiMap.KeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */