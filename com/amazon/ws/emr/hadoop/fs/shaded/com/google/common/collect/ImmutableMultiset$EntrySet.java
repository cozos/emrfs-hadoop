package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Set;

final class ImmutableMultiset$EntrySet
  extends ImmutableSet<Multiset.Entry<E>>
{
  private static final long serialVersionUID = 0L;
  
  private ImmutableMultiset$EntrySet(ImmutableMultiset paramImmutableMultiset) {}
  
  boolean isPartialView()
  {
    return this$0.isPartialView();
  }
  
  public UnmodifiableIterator<Multiset.Entry<E>> iterator()
  {
    return asList().iterator();
  }
  
  ImmutableList<Multiset.Entry<E>> createAsList()
  {
    new ImmutableAsList()
    {
      public Multiset.Entry<E> get(int index)
      {
        return this$0.getEntry(index);
      }
      
      ImmutableCollection<Multiset.Entry<E>> delegateCollection()
      {
        return ImmutableMultiset.EntrySet.this;
      }
    };
  }
  
  public int size()
  {
    return this$0.elementSet().size();
  }
  
  public boolean contains(Object o)
  {
    if ((o instanceof Multiset.Entry))
    {
      Multiset.Entry<?> entry = (Multiset.Entry)o;
      if (entry.getCount() <= 0) {
        return false;
      }
      int count = this$0.count(entry.getElement());
      return count == entry.getCount();
    }
    return false;
  }
  
  public int hashCode()
  {
    return this$0.hashCode();
  }
  
  Object writeReplace()
  {
    return new ImmutableMultiset.EntrySetSerializedForm(this$0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultiset.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */