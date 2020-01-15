package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;

class ImmutableMultiset$EntrySetSerializedForm<E>
  implements Serializable
{
  final ImmutableMultiset<E> multiset;
  
  ImmutableMultiset$EntrySetSerializedForm(ImmutableMultiset<E> multiset)
  {
    this.multiset = multiset;
  }
  
  Object readResolve()
  {
    return multiset.entrySet();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultiset.EntrySetSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */