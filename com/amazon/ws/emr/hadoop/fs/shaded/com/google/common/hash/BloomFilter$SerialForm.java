package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.io.Serializable;

class BloomFilter$SerialForm<T>
  implements Serializable
{
  final long[] data;
  final int numHashFunctions;
  final Funnel<? super T> funnel;
  final BloomFilter.Strategy strategy;
  private static final long serialVersionUID = 1L;
  
  BloomFilter$SerialForm(BloomFilter<T> bf)
  {
    data = access$000data;
    numHashFunctions = BloomFilter.access$100(bf);
    funnel = BloomFilter.access$200(bf);
    strategy = BloomFilter.access$300(bf);
  }
  
  Object readResolve()
  {
    return new BloomFilter(new BloomFilterStrategies.BitArray(data), numHashFunctions, funnel, strategy, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.BloomFilter.SerialForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */