package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.zip.Checksum;

final class ChecksumHashFunction$ChecksumHasher
  extends AbstractByteHasher
{
  private final Checksum checksum;
  
  private ChecksumHashFunction$ChecksumHasher(ChecksumHashFunction paramChecksumHashFunction, Checksum checksum)
  {
    this.checksum = ((Checksum)Preconditions.checkNotNull(checksum));
  }
  
  protected void update(byte b)
  {
    checksum.update(b);
  }
  
  protected void update(byte[] bytes, int off, int len)
  {
    checksum.update(bytes, off, len);
  }
  
  public HashCode hash()
  {
    long value = checksum.getValue();
    if (ChecksumHashFunction.access$100(this$0) == 32) {
      return HashCode.fromInt((int)value);
    }
    return HashCode.fromLong(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.ChecksumHashFunction.ChecksumHasher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */