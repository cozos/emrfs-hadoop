package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $FinalizableReferenceQueue$DirectLoader
  implements .FinalizableReferenceQueue.FinalizerLoader
{
  public Class<?> loadFinalizer()
  {
    try
    {
      return Class.forName("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$Finalizer");
    }
    catch (ClassNotFoundException e)
    {
      throw new AssertionError(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..FinalizableReferenceQueue.DirectLoader
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */