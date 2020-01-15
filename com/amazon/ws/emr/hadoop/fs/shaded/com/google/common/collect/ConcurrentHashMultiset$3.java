package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

class ConcurrentHashMultiset$3
  extends ForwardingIterator<Multiset.Entry<E>>
{
  private Multiset.Entry<E> last;
  
  ConcurrentHashMultiset$3(ConcurrentHashMultiset paramConcurrentHashMultiset, Iterator paramIterator) {}
  
  protected Iterator<Multiset.Entry<E>> delegate()
  {
    return val$readOnlyIterator;
  }
  
  public Multiset.Entry<E> next()
  {
    last = ((Multiset.Entry)super.next());
    return last;
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(last != null);
    this$0.setCount(last.getElement(), 0);
    last = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ConcurrentHashMultiset.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */