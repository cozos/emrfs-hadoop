package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
public final class HashingOutputStream
  extends FilterOutputStream
{
  private final Hasher hasher;
  
  public HashingOutputStream(HashFunction hashFunction, OutputStream out)
  {
    super((OutputStream)Preconditions.checkNotNull(out));
    hasher = ((Hasher)Preconditions.checkNotNull(hashFunction.newHasher()));
  }
  
  public void write(int b)
    throws IOException
  {
    hasher.putByte((byte)b);
    out.write(b);
  }
  
  public void write(byte[] bytes, int off, int len)
    throws IOException
  {
    hasher.putBytes(bytes, off, len);
    out.write(bytes, off, len);
  }
  
  public HashCode hash()
  {
    return hasher.hash();
  }
  
  public void close()
    throws IOException
  {
    out.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashingOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */