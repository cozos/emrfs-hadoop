package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.concurrent.FutureCallback;
import java.util.concurrent.Future;

public abstract interface ConnPool<T, E>
{
  public abstract Future<E> lease(T paramT, Object paramObject, FutureCallback<E> paramFutureCallback);
  
  public abstract void release(E paramE, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.ConnPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */