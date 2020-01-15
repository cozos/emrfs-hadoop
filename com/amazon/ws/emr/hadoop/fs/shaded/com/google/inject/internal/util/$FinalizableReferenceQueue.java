package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class $FinalizableReferenceQueue
{
  private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
  private static final String FINALIZER_CLASS_NAME = "com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$Finalizer";
  private static final Method startFinalizer;
  final ReferenceQueue<Object> queue;
  final boolean threadStarted;
  
  static
  {
    Class<?> finalizer = loadFinalizer(new FinalizerLoader[] { new SystemLoader(), new DecoupledLoader(), new DirectLoader() });
    
    startFinalizer = getStartFinalizer(finalizer);
  }
  
  public $FinalizableReferenceQueue()
  {
    boolean threadStarted = false;
    ReferenceQueue<Object> queue;
    try
    {
      queue = (ReferenceQueue)startFinalizer.invoke(null, new Object[] { .FinalizableReference.class, this });
      
      threadStarted = true;
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
    catch (Throwable t)
    {
      logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", t);
      
      queue = new ReferenceQueue();
    }
    this.queue = queue;
    this.threadStarted = threadStarted;
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
        ((.FinalizableReference)reference).finalizeReferent();
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
    public abstract Class<?> loadFinalizer();
  }
  
  static class SystemLoader
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
        .FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
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
  
  static class DecoupledLoader
    implements .FinalizableReferenceQueue.FinalizerLoader
  {
    private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Google Collections to your system class path.";
    
    public Class<?> loadFinalizer()
    {
      try
      {
        ClassLoader finalizerLoader = newLoader(getBaseUrl());
        return finalizerLoader.loadClass("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$Finalizer");
      }
      catch (Exception e)
      {
        .FinalizableReferenceQueue.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Google Collections to your system class path.", e);
      }
      return null;
    }
    
    URL getBaseUrl()
      throws IOException
    {
      String finalizerPath = "com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$Finalizer".replace('.', '/') + ".class";
      URL finalizerUrl = getClass().getClassLoader().getResource(finalizerPath);
      if (finalizerUrl == null) {
        throw new FileNotFoundException(finalizerPath);
      }
      String urlString = finalizerUrl.toString();
      if (!urlString.endsWith(finalizerPath)) {
        throw new IOException("Unsupported path style: " + urlString);
      }
      urlString = urlString.substring(0, urlString.length() - finalizerPath.length());
      
      return new URL(urlString);
    }
    
    URLClassLoader newLoader(URL base)
    {
      return new URLClassLoader(new URL[] { base });
    }
  }
  
  static class DirectLoader
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
  
  static Method getStartFinalizer(Class<?> finalizer)
  {
    try
    {
      return finalizer.getMethod("startFinalizer", new Class[] { Class.class, Object.class });
    }
    catch (NoSuchMethodException e)
    {
      throw new AssertionError(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..FinalizableReferenceQueue
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */