package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.io.Serializable;

final class HashCode$LongHashCode
  extends HashCode
  implements Serializable
{
  final long hash;
  private static final long serialVersionUID = 0L;
  
  HashCode$LongHashCode(long hash)
  {
    this.hash = hash;
  }
  
  public int bits()
  {
    return 64;
  }
  
  public byte[] asBytes()
  {
    return new byte[] { (byte)(int)hash, (byte)(int)(hash >> 8), (byte)(int)(hash >> 16), (byte)(int)(hash >> 24), (byte)(int)(hash >> 32), (byte)(int)(hash >> 40), (byte)(int)(hash >> 48), (byte)(int)(hash >> 56) };
  }
  
  public int asInt()
  {
    return (int)hash;
  }
  
  public long asLong()
  {
    return hash;
  }
  
  public long padToLong()
  {
    return hash;
  }
  
  void writeBytesToImpl(byte[] dest, int offset, int maxLength)
  {
    for (int i = 0; i < maxLength; i++) {
      dest[(offset + i)] = ((byte)(int)(hash >> i * 8));
    }
  }
  
  boolean equalsSameBits(HashCode that)
  {
    return hash == that.asLong();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashCode.LongHashCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */