package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.lang.ref.PhantomReference;

public abstract class $FinalizablePhantomReference<T>
  extends PhantomReference<T>
  implements .FinalizableReference
{
  protected $FinalizablePhantomReference(T referent, .FinalizableReferenceQueue queue)
  {
    super(referent, queue);
    queue.cleanUp();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..FinalizablePhantomReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */