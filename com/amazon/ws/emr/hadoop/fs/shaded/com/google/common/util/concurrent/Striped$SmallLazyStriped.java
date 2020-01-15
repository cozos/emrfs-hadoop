package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

@VisibleForTesting
class Striped$SmallLazyStriped<L>
  extends Striped.PowerOfTwoStriped<L>
{
  final AtomicReferenceArray<ArrayReference<? extends L>> locks;
  final Supplier<L> supplier;
  final int size;
  final ReferenceQueue<L> queue = new ReferenceQueue();
  
  Striped$SmallLazyStriped(int stripes, Supplier<L> supplier)
  {
    super(stripes);
    size = (mask == -1 ? Integer.MAX_VALUE : mask + 1);
    locks = new AtomicReferenceArray(size);
    this.supplier = supplier;
  }
  
  public L getAt(int index)
  {
    if (size != Integer.MAX_VALUE) {
      Preconditions.checkElementIndex(index, size());
    }
    ArrayReference<? extends L> existingRef = (ArrayReference)locks.get(index);
    L existing = existingRef == null ? null : existingRef.get();
    if (existing != null) {
      return existing;
    }
    L created = supplier.get();
    ArrayReference<L> newRef = new ArrayReference(created, index, queue);
    while (!locks.compareAndSet(index, existingRef, newRef))
    {
      existingRef = (ArrayReference)locks.get(index);
      existing = existingRef == null ? null : existingRef.get();
      if (existing != null) {
        return existing;
      }
    }
    drainQueue();
    return created;
  }
  
  private void drainQueue()
  {
    Reference<? extends L> ref;
    while ((ref = queue.poll()) != null)
    {
      ArrayReference<? extends L> arrayRef = (ArrayReference)ref;
      
      locks.compareAndSet(index, arrayRef, null);
    }
  }
  
  public int size()
  {
    return size;
  }
  
  private static final class ArrayReference<L>
    extends WeakReference<L>
  {
    final int index;
    
    ArrayReference(L referent, int index, ReferenceQueue<L> queue)
    {
      super(queue);
      this.index = index;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Striped.SmallLazyStriped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */