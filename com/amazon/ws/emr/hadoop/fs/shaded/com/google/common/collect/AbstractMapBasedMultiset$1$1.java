package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$1$1
  extends Multisets.AbstractEntry<E>
{
  AbstractMapBasedMultiset$1$1(AbstractMapBasedMultiset.1 param1, Map.Entry paramEntry) {}
  
  public E getElement()
  {
    return (E)val$mapEntry.getKey();
  }
  
  public int getCount()
  {
    Count count = (Count)val$mapEntry.getValue();
    if ((count == null) || (count.get() == 0))
    {
      Count frequency = (Count)AbstractMapBasedMultiset.access$000(this$1.this$0).get(getElement());
      if (frequency != null) {
        return frequency.get();
      }
    }
    return count == null ? 0 : count.get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultiset.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */