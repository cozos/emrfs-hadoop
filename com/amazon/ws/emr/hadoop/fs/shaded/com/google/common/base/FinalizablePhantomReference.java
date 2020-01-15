package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.lang.ref.PhantomReference;

public abstract class FinalizablePhantomReference<T>
  extends PhantomReference<T>
  implements FinalizableReference
{
  protected FinalizablePhantomReference(T referent, FinalizableReferenceQueue queue)
  {
    super(referent, queue);
    queue.cleanUp();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.FinalizablePhantomReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */