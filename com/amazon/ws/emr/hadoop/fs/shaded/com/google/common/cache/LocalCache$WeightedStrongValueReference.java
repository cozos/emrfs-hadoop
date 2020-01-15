package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

final class LocalCache$WeightedStrongValueReference<K, V>
  extends LocalCache.StrongValueReference<K, V>
{
  final int weight;
  
  LocalCache$WeightedStrongValueReference(V referent, int weight)
  {
    super(referent);
    this.weight = weight;
  }
  
  public int getWeight()
  {
    return weight;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.WeightedStrongValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */