package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

 enum BloomFilterStrategies$1
{
  BloomFilterStrategies$1()
  {
    super(paramString, paramInt, null);
  }
  
  public <T> boolean put(T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.BitArray bits)
  {
    long bitSize = bits.bitSize();
    long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
    int hash1 = (int)hash64;
    int hash2 = (int)(hash64 >>> 32);
    
    boolean bitsChanged = false;
    for (int i = 1; i <= numHashFunctions; i++)
    {
      int combinedHash = hash1 + i * hash2;
      if (combinedHash < 0) {
        combinedHash ^= 0xFFFFFFFF;
      }
      bitsChanged |= bits.set(combinedHash % bitSize);
    }
    return bitsChanged;
  }
  
  public <T> boolean mightContain(T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.BitArray bits)
  {
    long bitSize = bits.bitSize();
    long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
    int hash1 = (int)hash64;
    int hash2 = (int)(hash64 >>> 32);
    for (int i = 1; i <= numHashFunctions; i++)
    {
      int combinedHash = hash1 + i * hash2;
      if (combinedHash < 0) {
        combinedHash ^= 0xFFFFFFFF;
      }
      if (!bits.get(combinedHash % bitSize)) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.BloomFilterStrategies.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */