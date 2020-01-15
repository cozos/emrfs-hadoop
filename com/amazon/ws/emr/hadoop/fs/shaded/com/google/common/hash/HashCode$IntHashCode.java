package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.UnsignedInts;
import java.io.Serializable;

final class HashCode$IntHashCode
  extends HashCode
  implements Serializable
{
  final int hash;
  private static final long serialVersionUID = 0L;
  
  HashCode$IntHashCode(int hash)
  {
    this.hash = hash;
  }
  
  public int bits()
  {
    return 32;
  }
  
  public byte[] asBytes()
  {
    return new byte[] { (byte)hash, (byte)(hash >> 8), (byte)(hash >> 16), (byte)(hash >> 24) };
  }
  
  public int asInt()
  {
    return hash;
  }
  
  public long asLong()
  {
    throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
  }
  
  public long padToLong()
  {
    return UnsignedInts.toLong(hash);
  }
  
  void writeBytesToImpl(byte[] dest, int offset, int maxLength)
  {
    for (int i = 0; i < maxLength; i++) {
      dest[(offset + i)] = ((byte)(hash >> i * 8));
    }
  }
  
  boolean equalsSameBits(HashCode that)
  {
    return hash == that.asInt();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashCode.IntHashCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */