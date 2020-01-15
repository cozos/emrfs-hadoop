package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

class Multimaps$MapMultimap$1
  extends Sets.ImprovedAbstractSet<V>
{
  Multimaps$MapMultimap$1(Multimaps.MapMultimap paramMapMultimap, Object paramObject) {}
  
  public Iterator<V> iterator()
  {
    new Iterator()
    {
      int i;
      
      public boolean hasNext()
      {
        return (i == 0) && (this$0.map.containsKey(val$key));
      }
      
      public V next()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        i += 1;
        return (V)this$0.map.get(val$key);
      }
      
      public void remove()
      {
        CollectPreconditions.checkRemove(i == 1);
        i = -1;
        this$0.map.remove(val$key);
      }
    };
  }
  
  public int size()
  {
    return this$0.map.containsKey(val$key) ? 1 : 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.MapMultimap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */