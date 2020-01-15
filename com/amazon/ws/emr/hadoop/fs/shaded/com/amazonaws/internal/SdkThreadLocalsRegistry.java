package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import java.util.ArrayList;
import java.util.List;

@SdkProtectedApi
public final class SdkThreadLocalsRegistry
{
  private static final List<ThreadLocal<?>> threadLocals = new ArrayList();
  
  public static synchronized <T> ThreadLocal<T> register(ThreadLocal<T> threadLocal)
  {
    threadLocals.add(threadLocal);
    return threadLocal;
  }
  
  public static synchronized void remove()
  {
    for (ThreadLocal<?> t : threadLocals) {
      t.remove();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkThreadLocalsRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */