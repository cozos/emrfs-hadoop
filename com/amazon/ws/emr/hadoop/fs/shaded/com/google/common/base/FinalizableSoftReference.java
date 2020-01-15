package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.lang.ref.SoftReference;

public abstract class FinalizableSoftReference<T>
  extends SoftReference<T>
  implements FinalizableReference
{
  protected FinalizableSoftReference(T referent, FinalizableReferenceQueue queue)
  {
    super(referent, queue);
    queue.cleanUp();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.FinalizableSoftReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */