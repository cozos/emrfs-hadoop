package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

 enum Hashing$ChecksumType
  implements Supplier<Checksum>
{
  CRC_32(32),  ADLER_32(32);
  
  private final int bits;
  
  private Hashing$ChecksumType(int bits)
  {
    this.bits = bits;
  }
  
  public abstract Checksum get();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Hashing.ChecksumType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */