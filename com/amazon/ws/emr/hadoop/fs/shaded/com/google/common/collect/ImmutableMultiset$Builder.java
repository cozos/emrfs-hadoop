package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;

public class ImmutableMultiset$Builder<E>
  extends ImmutableCollection.Builder<E>
{
  final Multiset<E> contents;
  
  public ImmutableMultiset$Builder()
  {
    this(LinkedHashMultiset.create());
  }
  
  ImmutableMultiset$Builder(Multiset<E> contents)
  {
    this.contents = contents;
  }
  
  public Builder<E> add(E element)
  {
    contents.add(Preconditions.checkNotNull(element));
    return this;
  }
  
  public Builder<E> addCopies(E element, int occurrences)
  {
    contents.add(Preconditions.checkNotNull(element), occurrences);
    return this;
  }
  
  public Builder<E> setCount(E element, int count)
  {
    contents.setCount(Preconditions.checkNotNull(element), count);
    return this;
  }
  
  public Builder<E> add(E... elements)
  {
    super.add(elements);
    return this;
  }
  
  public Builder<E> addAll(Iterable<? extends E> elements)
  {
    if ((elements instanceof Multiset))
    {
      Multiset<? extends E> multiset = Multisets.cast(elements);
      for (Multiset.Entry<? extends E> entry : multiset.entrySet()) {
        addCopies(entry.getElement(), entry.getCount());
      }
    }
    else
    {
      super.addAll(elements);
    }
    return this;
  }
  
  public Builder<E> addAll(Iterator<? extends E> elements)
  {
    super.addAll(elements);
    return this;
  }
  
  public ImmutableMultiset<E> build()
  {
    return ImmutableMultiset.copyOf(contents);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultiset.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */