package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;

class AbstractTable$Values
  extends AbstractCollection<V>
{
  AbstractTable$Values(AbstractTable paramAbstractTable) {}
  
  public Iterator<V> iterator()
  {
    return this$0.valuesIterator();
  }
  
  public boolean contains(Object o)
  {
    return this$0.containsValue(o);
  }
  
  public void clear()
  {
    this$0.clear();
  }
  
  public int size()
  {
    return this$0.size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractTable.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */