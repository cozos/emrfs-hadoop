package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.util.logging.Logger;

class FinalizableReferenceQueue$SystemLoader
  implements FinalizableReferenceQueue.FinalizerLoader
{
  @VisibleForTesting
  static boolean disabled;
  
  public Class<?> loadFinalizer()
  {
    if (disabled) {
      return null;
    }
    ClassLoader systemLoader;
    try
    {
      systemLoader = ClassLoader.getSystemClassLoader();
    }
    catch (SecurityException e)
    {
      FinalizableReferenceQueue.access$000().info("Not allowed to access system class loader.");
      return null;
    }
    if (systemLoader != null) {
      try
      {
        return systemLoader.loadClass("com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.internal.Finalizer");
      }
      catch (ClassNotFoundException e)
      {
        return null;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.FinalizableReferenceQueue.SystemLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */