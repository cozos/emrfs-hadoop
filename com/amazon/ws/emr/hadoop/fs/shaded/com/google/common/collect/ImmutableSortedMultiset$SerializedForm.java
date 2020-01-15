package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Set;

final class ImmutableSortedMultiset$SerializedForm<E>
  implements Serializable
{
  Comparator<? super E> comparator;
  E[] elements;
  int[] counts;
  
  ImmutableSortedMultiset$SerializedForm(SortedMultiset<E> multiset)
  {
    comparator = multiset.comparator();
    int n = multiset.entrySet().size();
    elements = ((Object[])new Object[n]);
    counts = new int[n];
    int i = 0;
    for (Multiset.Entry<E> entry : multiset.entrySet())
    {
      elements[i] = entry.getElement();
      counts[i] = entry.getCount();
      i++;
    }
  }
  
  Object readResolve()
  {
    int n = elements.length;
    ImmutableSortedMultiset.Builder<E> builder = new ImmutableSortedMultiset.Builder(comparator);
    for (int i = 0; i < n; i++) {
      builder.addCopies(elements[i], counts[i]);
    }
    return builder.build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedMultiset.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */