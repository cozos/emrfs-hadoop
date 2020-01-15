package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
class Striped$LargeLazyStriped<L>
  extends Striped.PowerOfTwoStriped<L>
{
  final ConcurrentMap<Integer, L> locks;
  final Supplier<L> supplier;
  final int size;
  
  Striped$LargeLazyStriped(int stripes, Supplier<L> supplier)
  {
    super(stripes);
    size = (mask == -1 ? Integer.MAX_VALUE : mask + 1);
    this.supplier = supplier;
    locks = new MapMaker().weakValues().makeMap();
  }
  
  public L getAt(int index)
  {
    if (size != Integer.MAX_VALUE) {
      Preconditions.checkElementIndex(index, size());
    }
    L existing = locks.get(Integer.valueOf(index));
    if (existing != null) {
      return existing;
    }
    L created = supplier.get();
    existing = locks.putIfAbsent(Integer.valueOf(index), created);
    return (L)MoreObjects.firstNonNull(existing, created);
  }
  
  public int size()
  {
    return size;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.LargeLazyStriped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */