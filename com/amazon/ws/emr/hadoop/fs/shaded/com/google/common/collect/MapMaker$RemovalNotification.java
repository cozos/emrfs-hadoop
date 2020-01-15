package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class MapMaker$RemovalNotification<K, V>
  extends ImmutableEntry<K, V>
{
  private static final long serialVersionUID = 0L;
  private final MapMaker.RemovalCause cause;
  
  MapMaker$RemovalNotification(@Nullable K key, @Nullable V value, MapMaker.RemovalCause cause)
  {
    super(key, value);
    this.cause = cause;
  }
  
  public MapMaker.RemovalCause getCause()
  {
    return cause;
  }
  
  public boolean wasEvicted()
  {
    return cause.wasEvicted();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker.RemovalNotification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */