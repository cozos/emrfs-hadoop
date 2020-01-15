package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

 enum MapMaker$RemovalCause
{
  EXPLICIT,  REPLACED,  COLLECTED,  EXPIRED,  SIZE;
  
  private MapMaker$RemovalCause() {}
  
  abstract boolean wasEvicted();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker.RemovalCause
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */