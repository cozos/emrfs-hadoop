package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

public class ImmutableSortedMultiset$Builder<E>
  extends ImmutableMultiset.Builder<E>
{
  public ImmutableSortedMultiset$Builder(Comparator<? super E> comparator)
  {
    super(TreeMultiset.create((Comparator)Preconditions.checkNotNull(comparator)));
  }
  
  public Builder<E> add(E element)
  {
    super.add(element);
    return this;
  }
  
  public Builder<E> addCopies(E element, int occurrences)
  {
    super.addCopies(element, occurrences);
    return this;
  }
  
  public Builder<E> setCount(E element, int count)
  {
    super.setCount(element, count);
    return this;
  }
  
  public Builder<E> add(E... elements)
  {
    super.add(elements);
    return this;
  }
  
  public Builder<E> addAll(Iterable<? extends E> elements)
  {
    super.addAll(elements);
    return this;
  }
  
  public Builder<E> addAll(Iterator<? extends E> elements)
  {
    super.addAll(elements);
    return this;
  }
  
  public ImmutableSortedMultiset<E> build()
  {
    return ImmutableSortedMultiset.copyOfSorted((SortedMultiset)contents);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedMultiset.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */