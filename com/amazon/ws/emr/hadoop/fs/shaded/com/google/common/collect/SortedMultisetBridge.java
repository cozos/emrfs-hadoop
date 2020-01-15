package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.SortedSet;

abstract interface SortedMultisetBridge<E>
  extends Multiset<E>
{
  public abstract SortedSet<E> elementSet();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SortedMultisetBridge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */