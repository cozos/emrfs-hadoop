package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class HashingInputStream
  extends FilterInputStream
{
  private final Hasher hasher;
  
  public HashingInputStream(HashFunction hashFunction, InputStream in)
  {
    super((InputStream)Preconditions.checkNotNull(in));
    hasher = ((Hasher)Preconditions.checkNotNull(hashFunction.newHasher()));
  }
  
  public int read()
    throws IOException
  {
    int b = in.read();
    if (b != -1) {
      hasher.putByte((byte)b);
    }
    return b;
  }
  
  public int read(byte[] bytes, int off, int len)
    throws IOException
  {
    int numOfBytesRead = in.read(bytes, off, len);
    if (numOfBytesRead != -1) {
      hasher.putBytes(bytes, off, numOfBytesRead);
    }
    return numOfBytesRead;
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public void mark(int readlimit) {}
  
  public void reset()
    throws IOException
  {
    throw new IOException("reset not supported");
  }
  
  public HashCode hash()
  {
    return hasher.hash();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */