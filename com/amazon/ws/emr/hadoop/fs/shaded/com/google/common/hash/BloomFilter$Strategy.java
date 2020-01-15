package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.io.Serializable;

abstract interface BloomFilter$Strategy
  extends Serializable
{
  public abstract <T> boolean put(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray);
  
  public abstract <T> boolean mightContain(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray);
  
  public abstract int ordinal();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.BloomFilter.Strategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */