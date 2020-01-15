package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
public abstract interface RemovalListener<K, V>
{
  public abstract void onRemoval(RemovalNotification<K, V> paramRemovalNotification);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.RemovalListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */