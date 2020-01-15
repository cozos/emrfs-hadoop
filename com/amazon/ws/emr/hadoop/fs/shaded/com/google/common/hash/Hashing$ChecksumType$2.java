package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.util.zip.Adler32;
import java.util.zip.Checksum;

 enum Hashing$ChecksumType$2
{
  Hashing$ChecksumType$2(int x0)
  {
    super(paramString, paramInt, x0, null);
  }
  
  public Checksum get()
  {
    return new Adler32();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Hashing.ChecksumType.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */