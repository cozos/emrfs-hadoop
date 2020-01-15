package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
final class Hashing$ConcatenatedHashFunction
  extends AbstractCompositeHashFunction
{
  private final int bits;
  
  Hashing$ConcatenatedHashFunction(HashFunction... functions)
  {
    super(functions);
    int bitSum = 0;
    for (HashFunction function : functions) {
      bitSum += function.bits();
    }
    bits = bitSum;
  }
  
  HashCode makeHash(Hasher[] hashers)
  {
    byte[] bytes = new byte[bits / 8];
    int i = 0;
    for (Hasher hasher : hashers)
    {
      HashCode newHash = hasher.hash();
      i += newHash.writeBytesTo(bytes, i, newHash.bits() / 8);
    }
    return HashCode.fromBytesNoCopy(bytes);
  }
  
  public int bits()
  {
    return bits;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof ConcatenatedHashFunction))
    {
      ConcatenatedHashFunction other = (ConcatenatedHashFunction)object;
      if ((bits != bits) || (functions.length != functions.length)) {
        return false;
      }
      for (int i = 0; i < functions.length; i++) {
        if (!functions[i].equals(functions[i])) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int hash = bits;
    for (HashFunction function : functions) {
      hash ^= function.hashCode();
    }
    return hash;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Hashing.ConcatenatedHashFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */