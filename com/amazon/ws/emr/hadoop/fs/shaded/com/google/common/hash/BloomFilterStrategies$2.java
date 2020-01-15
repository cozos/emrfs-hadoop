package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Longs;

 enum BloomFilterStrategies$2
{
  BloomFilterStrategies$2()
  {
    super(paramString, paramInt, null);
  }
  
  public <T> boolean put(T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.BitArray bits)
  {
    long bitSize = bits.bitSize();
    byte[] bytes = Hashing.murmur3_128().hashObject(object, funnel).getBytesInternal();
    long hash1 = lowerEight(bytes);
    long hash2 = upperEight(bytes);
    
    boolean bitsChanged = false;
    long combinedHash = hash1;
    for (int i = 0; i < numHashFunctions; i++)
    {
      bitsChanged |= bits.set((combinedHash & 0x7FFFFFFFFFFFFFFF) % bitSize);
      combinedHash += hash2;
    }
    return bitsChanged;
  }
  
  public <T> boolean mightContain(T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.BitArray bits)
  {
    long bitSize = bits.bitSize();
    byte[] bytes = Hashing.murmur3_128().hashObject(object, funnel).getBytesInternal();
    long hash1 = lowerEight(bytes);
    long hash2 = upperEight(bytes);
    
    long combinedHash = hash1;
    for (int i = 0; i < numHashFunctions; i++)
    {
      if (!bits.get((combinedHash & 0x7FFFFFFFFFFFFFFF) % bitSize)) {
        return false;
      }
      combinedHash += hash2;
    }
    return true;
  }
  
  private long lowerEight(byte[] bytes)
  {
    return Longs.fromBytes(bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]);
  }
  
  private long upperEight(byte[] bytes)
  {
    return Longs.fromBytes(bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.BloomFilterStrategies.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */