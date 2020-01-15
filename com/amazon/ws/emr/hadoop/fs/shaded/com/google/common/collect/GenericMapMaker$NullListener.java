package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;

@GwtIncompatible("To be supported")
 enum GenericMapMaker$NullListener
  implements MapMaker.RemovalListener<Object, Object>
{
  INSTANCE;
  
  private GenericMapMaker$NullListener() {}
  
  public void onRemoval(MapMaker.RemovalNotification<Object, Object> notification) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.GenericMapMaker.NullListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */