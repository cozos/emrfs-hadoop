package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;

final class ByteSource$SlicedByteSource
  extends ByteSource
{
  private final long offset;
  private final long length;
  
  private ByteSource$SlicedByteSource(ByteSource paramByteSource, long offset, long length)
  {
    Preconditions.checkArgument(offset >= 0L, "offset (%s) may not be negative", new Object[] { Long.valueOf(offset) });
    Preconditions.checkArgument(length >= 0L, "length (%s) may not be negative", new Object[] { Long.valueOf(length) });
    this.offset = offset;
    this.length = length;
  }
  
  public InputStream openStream()
    throws IOException
  {
    return sliceStream(this$0.openStream());
  }
  
  public InputStream openBufferedStream()
    throws IOException
  {
    return sliceStream(this$0.openBufferedStream());
  }
  
  private InputStream sliceStream(InputStream in)
    throws IOException
  {
    if (offset > 0L) {
      try
      {
        ByteStreams.skipFully(in, offset);
      }
      catch (Throwable e)
      {
        Closer closer = Closer.create();
        closer.register(in);
        try
        {
          throw closer.rethrow(e);
        }
        finally
        {
          closer.close();
        }
      }
    }
    return ByteStreams.limit(in, length);
  }
  
  public ByteSource slice(long offset, long length)
  {
    Preconditions.checkArgument(offset >= 0L, "offset (%s) may not be negative", new Object[] { Long.valueOf(offset) });
    Preconditions.checkArgument(length >= 0L, "length (%s) may not be negative", new Object[] { Long.valueOf(length) });
    long maxLength = this.length - offset;
    return this$0.slice(this.offset + offset, Math.min(length, maxLength));
  }
  
  public boolean isEmpty()
    throws IOException
  {
    return (length == 0L) || (super.isEmpty());
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(this$0.toString()));long l1 = offset;long l2 = length;return 50 + str.length() + str + ".slice(" + l1 + ", " + l2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteSource.SlicedByteSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */