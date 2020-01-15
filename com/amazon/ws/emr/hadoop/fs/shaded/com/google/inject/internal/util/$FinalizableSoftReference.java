package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.lang.ref.SoftReference;

public abstract class $FinalizableSoftReference<T>
  extends SoftReference<T>
  implements .FinalizableReference
{
  protected $FinalizableSoftReference(T referent, .FinalizableReferenceQueue queue)
  {
    super(referent, queue);
    queue.cleanUp();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..FinalizableSoftReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */