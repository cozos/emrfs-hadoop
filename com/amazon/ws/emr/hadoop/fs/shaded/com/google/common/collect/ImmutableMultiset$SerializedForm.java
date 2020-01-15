package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.util.Set;

class ImmutableMultiset$SerializedForm
  implements Serializable
{
  final Object[] elements;
  final int[] counts;
  private static final long serialVersionUID = 0L;
  
  ImmutableMultiset$SerializedForm(Multiset<?> multiset)
  {
    int distinct = multiset.entrySet().size();
    elements = new Object[distinct];
    counts = new int[distinct];
    int i = 0;
    for (Multiset.Entry<?> entry : multiset.entrySet())
    {
      elements[i] = entry.getElement();
      counts[i] = entry.getCount();
      i++;
    }
  }
  
  Object readResolve()
  {
    LinkedHashMultiset<Object> multiset = LinkedHashMultiset.create(elements.length);
    for (int i = 0; i < elements.length; i++) {
      multiset.add(elements[i], counts[i]);
    }
    return ImmutableMultiset.copyOf(multiset);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultiset.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */