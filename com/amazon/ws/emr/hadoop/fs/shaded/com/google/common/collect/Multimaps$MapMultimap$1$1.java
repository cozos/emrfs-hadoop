package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

class Multimaps$MapMultimap$1$1
  implements Iterator<V>
{
  int i;
  
  Multimaps$MapMultimap$1$1(Multimaps.MapMultimap.1 param1) {}
  
  public boolean hasNext()
  {
    return (i == 0) && (this$1.this$0.map.containsKey(this$1.val$key));
  }
  
  public V next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    i += 1;
    return (V)this$1.this$0.map.get(this$1.val$key);
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(i == 1);
    i = -1;
    this$1.this$0.map.remove(this$1.val$key);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.MapMultimap.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */