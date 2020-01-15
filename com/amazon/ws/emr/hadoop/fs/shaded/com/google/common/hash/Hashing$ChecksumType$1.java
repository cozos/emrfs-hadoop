package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

 enum Hashing$ChecksumType$1
{
  Hashing$ChecksumType$1(int x0)
  {
    super(paramString, paramInt, x0, null);
  }
  
  public Checksum get()
  {
    return new CRC32();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Hashing.ChecksumType.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */