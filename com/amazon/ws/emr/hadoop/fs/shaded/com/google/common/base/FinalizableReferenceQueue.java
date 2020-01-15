package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class FinalizableReferenceQueue
  implements Closeable
{
  private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
  private static final String FINALIZER_CLASS_NAME = "com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.internal.Finalizer";
  private static final Method startFinalizer;
  final ReferenceQueue<Object> queue;
  final PhantomReference<Object> frqRef;
  final boolean threadStarted;
  
  static
  {
    Class<?> finalizer = loadFinalizer(new FinalizerLoader[] { new SystemLoader(), new DecoupledLoader(), new DirectLoader() });
    
    startFinalizer = getStartFinalizer(finalizer);
  }
  
  public FinalizableReferenceQueue()
  {
    queue = new ReferenceQueue();
    frqRef = new PhantomReference(this, queue);
    boolean threadStarted = false;
    try
    {
      startFinalizer.invoke(null, new Object[] { FinalizableReference.class, queue, frqRef });
      threadStarted = true;
    }
    catch (IllegalAccessException impossible)
    {
      throw new AssertionError(impossible);
    }
    catch (Throwable t)
    {
      logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", t);
    }
    this.threadStarted = threadStarted;
  }
  
  public void close()
  {
    frqRef.enqueue();
    cleanUp();
  }
  
  void cleanUp()
  {
    if (threadStarted) {
      return;
    }
    Reference<?> reference;
    while ((reference = queue.poll()) != null)
    {
      reference.clear();
      try
      {
        ((FinalizableReference)reference).finalizeReferent();
      }
      catch (Throwable t)
      {
        logger.log(Level.SEVERE, "Error cleaning up after reference.", t);
      }
    }
  }
  
  private static Class<?> loadFinalizer(FinalizerLoader... loaders)
  {
    for (FinalizerLoader loader : loaders)
    {
      Class<?> finalizer = loader.loadFinalizer();
      if (finalizer != null) {
        return finalizer;
      }
    }
    throw new AssertionError();
  }
  
  static abstract interface FinalizerLoader
  {
    @Nullable
    public abstract Class<?> loadFinalizer();
  }
  
  static class SystemLoader
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
        FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
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
  
  static class DecoupledLoader
    implements FinalizableReferenceQueue.FinalizerLoader
  {
    private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.";
    
    public Class<?> loadFinalizer()
    {
      try
      {
        ClassLoader finalizerLoader = newLoader(getBaseUrl());
        return finalizerLoader.loadClass("com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.internal.Finalizer");
      }
      catch (Exception e)
      {
        FinalizableReferenceQueue.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.", e);
      }
      return null;
    }
    
    /* Error */
    URL getBaseUrl()
      throws java.io.IOException
    {
      // Byte code:
      //   0: ldc 35
      //   2: bipush 46
      //   4: bipush 47
      //   6: invokevirtual 69	java/lang/String:replace	(CC)Ljava/lang/String;
      //   9: invokestatic 73	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   12: ldc 75
      //   14: invokevirtual 79	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   17: astore_1
      //   18: aload_0
      //   19: invokevirtual 82	java/lang/Object:getClass	()Ljava/lang/Class;
      //   22: invokevirtual 88	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
      //   25: aload_1
      //   26: invokevirtual 92	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
      //   29: astore_2
      //   30: aload_2
      //   31: ifnonnull +12 -> 43
      //   34: new 94	java/io/FileNotFoundException
      //   37: dup
      //   38: aload_1
      //   39: invokespecial 97	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
      //   42: athrow
      //   43: aload_2
      //   44: invokevirtual 103	java/net/URL:toString	()Ljava/lang/String;
      //   47: astore_3
      //   48: aload_3
      //   49: aload_1
      //   50: invokevirtual 107	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   53: ifne +39 -> 92
      //   56: new 63	java/io/IOException
      //   59: dup
      //   60: ldc 109
      //   62: aload_3
      //   63: invokestatic 73	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   66: dup
      //   67: invokevirtual 113	java/lang/String:length	()I
      //   70: ifeq +9 -> 79
      //   73: invokevirtual 79	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   76: goto +12 -> 88
      //   79: pop
      //   80: new 65	java/lang/String
      //   83: dup_x1
      //   84: swap
      //   85: invokespecial 114	java/lang/String:<init>	(Ljava/lang/String;)V
      //   88: invokespecial 115	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   91: athrow
      //   92: aload_3
      //   93: iconst_0
      //   94: aload_3
      //   95: invokevirtual 113	java/lang/String:length	()I
      //   98: aload_1
      //   99: invokevirtual 113	java/lang/String:length	()I
      //   102: isub
      //   103: invokevirtual 119	java/lang/String:substring	(II)Ljava/lang/String;
      //   106: astore_3
      //   107: new 99	java/net/URL
      //   110: dup
      //   111: aload_2
      //   112: aload_3
      //   113: invokespecial 122	java/net/URL:<init>	(Ljava/net/URL;Ljava/lang/String;)V
      //   116: areturn
      // Line number table:
      //   Java source line #308	-> byte code offset #0
      //   Java source line #309	-> byte code offset #18
      //   Java source line #310	-> byte code offset #30
      //   Java source line #311	-> byte code offset #34
      //   Java source line #315	-> byte code offset #43
      //   Java source line #316	-> byte code offset #48
      //   Java source line #317	-> byte code offset #56
      //   Java source line #319	-> byte code offset #92
      //   Java source line #320	-> byte code offset #107
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	117	0	this	DecoupledLoader
      //   18	99	1	finalizerPath	String
      //   30	87	2	finalizerUrl	URL
      //   48	69	3	urlString	String
    }
    
    URLClassLoader newLoader(URL base)
    {
      return new URLClassLoader(new URL[] { base }, null);
    }
  }
  
  static class DirectLoader
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
  
  static Method getStartFinalizer(Class<?> finalizer)
  {
    try
    {
      return finalizer.getMethod("startFinalizer", new Class[] { Class.class, ReferenceQueue.class, PhantomReference.class });
    }
    catch (NoSuchMethodException e)
    {
      throw new AssertionError(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.FinalizableReferenceQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */