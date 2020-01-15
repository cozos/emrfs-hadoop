package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import javax.annotation.Nullable;

public abstract interface FutureCallback<V>
{
  public abstract void onSuccess(@Nullable V paramV);
  
  public abstract void onFailure(Throwable paramThrowable);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.FutureCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */