package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;

final class ByteSource$ConcatenatedByteSource
  extends ByteSource
{
  private final Iterable<? extends ByteSource> sources;
  
  ByteSource$ConcatenatedByteSource(Iterable<? extends ByteSource> sources)
  {
    this.sources = ((Iterable)Preconditions.checkNotNull(sources));
  }
  
  public InputStream openStream()
    throws IOException
  {
    return new MultiInputStream(sources.iterator());
  }
  
  public boolean isEmpty()
    throws IOException
  {
    for (ByteSource source : sources) {
      if (!source.isEmpty()) {
        return false;
      }
    }
    return true;
  }
  
  public long size()
    throws IOException
  {
    long result = 0L;
    for (ByteSource source : sources) {
      result += source.size();
    }
    return result;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(sources));return 19 + str.length() + "ByteSource.concat(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteSource.ConcatenatedByteSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */