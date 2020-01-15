package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NoSuchElementException;

@Beta
public class ForwardingNavigableMap$StandardDescendingMap
  extends Maps.DescendingMap<K, V>
{
  public ForwardingNavigableMap$StandardDescendingMap(ForwardingNavigableMap paramForwardingNavigableMap) {}
  
  NavigableMap<K, V> forward()
  {
    return this$0;
  }
  
  protected Iterator<Map.Entry<K, V>> entryIterator()
  {
    new Iterator()
    {
      private Map.Entry<K, V> toRemove = null;
      private Map.Entry<K, V> nextOrNull = forward().lastEntry();
      
      public boolean hasNext()
      {
        return nextOrNull != null;
      }
      
      public Map.Entry<K, V> next()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        try
        {
          return nextOrNull;
        }
        finally
        {
          toRemove = nextOrNull;
          nextOrNull = forward().lowerEntry(nextOrNull.getKey());
        }
      }
      
      public void remove()
      {
        CollectPreconditions.checkRemove(toRemove != null);
        forward().remove(toRemove.getKey());
        toRemove = null;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */