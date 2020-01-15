package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ascii;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashCode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.HashFunction;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class ByteSource$ByteArrayByteSource
  extends ByteSource
{
  protected final byte[] bytes;
  
  protected ByteSource$ByteArrayByteSource(byte[] bytes)
  {
    this.bytes = ((byte[])Preconditions.checkNotNull(bytes));
  }
  
  public InputStream openStream()
  {
    return new ByteArrayInputStream(bytes);
  }
  
  public InputStream openBufferedStream()
    throws IOException
  {
    return openStream();
  }
  
  public boolean isEmpty()
  {
    return bytes.length == 0;
  }
  
  public long size()
  {
    return bytes.length;
  }
  
  public byte[] read()
  {
    return (byte[])bytes.clone();
  }
  
  public long copyTo(OutputStream output)
    throws IOException
  {
    output.write(bytes);
    return bytes.length;
  }
  
  public <T> T read(ByteProcessor<T> processor)
    throws IOException
  {
    processor.processBytes(bytes, 0, bytes.length);
    return (T)processor.getResult();
  }
  
  public HashCode hash(HashFunction hashFunction)
    throws IOException
  {
    return hashFunction.hashBytes(bytes);
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(Ascii.truncate(BaseEncoding.base16().encode(bytes), 30, "...")));return 17 + str.length() + "ByteSource.wrap(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteSource.ByteArrayByteSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */