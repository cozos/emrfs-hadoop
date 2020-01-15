package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class $Finalizer
  extends Thread
{
  private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
  private static final String FINALIZABLE_REFERENCE = "com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$FinalizableReference";
  private final WeakReference<Class<?>> finalizableReferenceClassReference;
  private final PhantomReference<Object> frqReference;
  
  public static ReferenceQueue<Object> startFinalizer(Class<?> finalizableReferenceClass, Object frq)
  {
    if (!finalizableReferenceClass.getName().equals("com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util.$FinalizableReference")) {
      throw new IllegalArgumentException("Expected com.google.inject.internal.util.FinalizableReference.");
    }
    Finalizer finalizer = new Finalizer(finalizableReferenceClass, frq);
    finalizer.start();
    return queue;
  }
  
  private final ReferenceQueue<Object> queue = new ReferenceQueue();
  
  private $Finalizer(Class<?> finalizableReferenceClass, Object frq)
  {
    super(Finalizer.class.getName());
    
    finalizableReferenceClassReference = new WeakReference(finalizableReferenceClass);
    
    frqReference = new PhantomReference(frq, queue);
    
    setDaemon(true);
  }
  
  public void run()
  {
    try
    {
      try
      {
        for (;;)
        {
          cleanUp(queue.remove());
        }
      }
      catch (InterruptedException e) {}
    }
    catch (ShutDown shutDown) {}
  }
  
  private void cleanUp(Reference<?> reference)
    throws .Finalizer.ShutDown
  {
    Method finalizeReferentMethod = getFinalizeReferentMethod();
    do
    {
      reference.clear();
      if (reference == frqReference) {
        throw new ShutDown(null);
      }
      try
      {
        finalizeReferentMethod.invoke(reference, new Object[0]);
      }
      catch (Throwable t)
      {
        logger.log(Level.SEVERE, "Error cleaning up after reference.", t);
      }
    } while ((reference = queue.poll()) != null);
  }
  
  private Method getFinalizeReferentMethod()
    throws .Finalizer.ShutDown
  {
    Class<?> finalizableReferenceClass = (Class)finalizableReferenceClassReference.get();
    if (finalizableReferenceClass == null) {
      throw new ShutDown(null);
    }
    try
    {
      return finalizableReferenceClass.getMethod("finalizeReferent", new Class[0]);
    }
    catch (NoSuchMethodException e)
    {
      throw new AssertionError(e);
    }
  }
  
  private static class ShutDown
    extends Exception
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Finalizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */