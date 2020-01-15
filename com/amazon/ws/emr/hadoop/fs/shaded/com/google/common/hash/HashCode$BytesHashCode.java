package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.security.MessageDigest;

final class HashCode$BytesHashCode
  extends HashCode
  implements Serializable
{
  final byte[] bytes;
  private static final long serialVersionUID = 0L;
  
  HashCode$BytesHashCode(byte[] bytes)
  {
    this.bytes = ((byte[])Preconditions.checkNotNull(bytes));
  }
  
  public int bits()
  {
    return bytes.length * 8;
  }
  
  public byte[] asBytes()
  {
    return (byte[])bytes.clone();
  }
  
  public int asInt()
  {
    Preconditions.checkState(bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", new Object[] { Integer.valueOf(bytes.length) });
    
    return bytes[0] & 0xFF | (bytes[1] & 0xFF) << 8 | (bytes[2] & 0xFF) << 16 | (bytes[3] & 0xFF) << 24;
  }
  
  public long asLong()
  {
    Preconditions.checkState(bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", new Object[] { Integer.valueOf(bytes.length) });
    
    return padToLong();
  }
  
  public long padToLong()
  {
    long retVal = bytes[0] & 0xFF;
    for (int i = 1; i < Math.min(bytes.length, 8); i++) {
      retVal |= (bytes[i] & 0xFF) << i * 8;
    }
    return retVal;
  }
  
  void writeBytesToImpl(byte[] dest, int offset, int maxLength)
  {
    System.arraycopy(bytes, 0, dest, offset, maxLength);
  }
  
  byte[] getBytesInternal()
  {
    return bytes;
  }
  
  boolean equalsSameBits(HashCode that)
  {
    return MessageDigest.isEqual(bytes, that.getBytesInternal());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashCode.BytesHashCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */