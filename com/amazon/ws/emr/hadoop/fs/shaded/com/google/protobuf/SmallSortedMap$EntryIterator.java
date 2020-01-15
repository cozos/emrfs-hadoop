package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SmallSortedMap$EntryIterator
  implements Iterator<Map.Entry<K, V>>
{
  private int pos = -1;
  private boolean nextCalledBeforeRemove;
  private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
  
  private SmallSortedMap$EntryIterator(SmallSortedMap paramSmallSortedMap) {}
  
  public boolean hasNext()
  {
    return (pos + 1 < SmallSortedMap.access$400(this$0).size()) || (getOverflowIterator().hasNext());
  }
  
  public Map.Entry<K, V> next()
  {
    nextCalledBeforeRemove = true;
    if (++pos < SmallSortedMap.access$400(this$0).size()) {
      return (Map.Entry)SmallSortedMap.access$400(this$0).get(pos);
    }
    return (Map.Entry)getOverflowIterator().next();
  }
  
  public void remove()
  {
    if (!nextCalledBeforeRemove) {
      throw new IllegalStateException("remove() was called before next()");
    }
    nextCalledBeforeRemove = false;
    SmallSortedMap.access$200(this$0);
    if (pos < SmallSortedMap.access$400(this$0).size()) {
      SmallSortedMap.access$500(this$0, pos--);
    } else {
      getOverflowIterator().remove();
    }
  }
  
  private Iterator<Map.Entry<K, V>> getOverflowIterator()
  {
    if (lazyOverflowIterator == null) {
      lazyOverflowIterator = SmallSortedMap.access$600(this$0).entrySet().iterator();
    }
    return lazyOverflowIterator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.SmallSortedMap.EntryIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */