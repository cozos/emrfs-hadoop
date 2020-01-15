package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.lang.ref.WeakReference;

public abstract class FinalizableWeakReference<T>
  extends WeakReference<T>
  implements FinalizableReference
{
  protected FinalizableWeakReference(T referent, FinalizableReferenceQueue queue)
  {
    super(referent, queue);
    queue.cleanUp();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.FinalizableWeakReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */