package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.logging.Logger;

class $FinalizableReferenceQueue$SystemLoader
  implements .FinalizableReferenceQueue.FinalizerLoader
{
  public Class<?> loadFinalizer()
  {
    ClassLoader systemLoader;
    try
    {
      systemLoader = ClassLoader.getSystemClassLoader();
    }
    catch (SecurityException e)
    {
      .FinalizableReferenceQueue.access$000().info("Not allowed to access system class loader.");
      return null;
    }
    if (systemLoader != null) {
      try
      {
        return systemLoader.loadClass("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$Finalizer");
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..FinalizableReferenceQueue.SystemLoader
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */