package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DelegatingInvocationHandler<T>
  implements InvocationHandler
{
  private T delegate;
  
  public Object invoke(Object proxy, Method method, Object[] args)
    throws Throwable
  {
    if (delegate == null) {
      throw new IllegalStateException("This is a proxy used to support circular references involving constructors. The object we're proxying is not constructed yet. Please wait until after injection has completed to use this object.");
    }
    try
    {
      return method.invoke(delegate, args);
    }
    catch (IllegalAccessException e)
    {
      throw new RuntimeException(e);
    }
    catch (IllegalArgumentException e)
    {
      throw new RuntimeException(e);
    }
    catch (InvocationTargetException e)
    {
      throw e.getTargetException();
    }
  }
  
  public T getDelegate()
  {
    return (T)delegate;
  }
  
  void setDelegate(T delegate)
  {
    this.delegate = delegate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.DelegatingInvocationHandler
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */