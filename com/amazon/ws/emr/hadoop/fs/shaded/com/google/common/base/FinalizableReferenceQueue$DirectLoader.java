package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

class FinalizableReferenceQueue$DirectLoader
  implements FinalizableReferenceQueue.FinalizerLoader
{
  public Class<?> loadFinalizer()
  {
    try
    {
      return Class.forName("com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.internal.Finalizer");
    }
    catch (ClassNotFoundException e)
    {
      throw new AssertionError(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.FinalizableReferenceQueue.DirectLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */