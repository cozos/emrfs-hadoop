package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteRangeCapturingInputStream
  extends SdkFilterInputStream
{
  private final long startingPosition;
  private final long endingPosition;
  private long streamPosition;
  private int blockPosition = 0;
  private final byte[] block;
  private long markedStreamPosition;
  private int markedBlockPosition;
  
  public ByteRangeCapturingInputStream(InputStream in, long startingPosition, long endingPosition)
  {
    super(in);
    if (startingPosition >= endingPosition) {
      throw new IllegalArgumentException("Invalid byte range specified: the starting position must be less than the ending position");
    }
    this.startingPosition = startingPosition;
    this.endingPosition = endingPosition;
    int blockSize = (int)(endingPosition - startingPosition);
    block = new byte[blockSize];
  }
  
  public byte[] getBlock()
  {
    return block;
  }
  
  public int read()
    throws IOException
  {
    int data = super.read();
    if (data == -1) {
      return -1;
    }
    if ((streamPosition >= startingPosition) && (streamPosition <= endingPosition)) {
      block[(blockPosition++)] = ((byte)data);
    }
    streamPosition += 1L;
    return data;
  }
  
  public synchronized void mark(int readlimit)
  {
    super.mark(readlimit);
    if (markSupported())
    {
      markedStreamPosition = streamPosition;
      markedBlockPosition = blockPosition;
    }
  }
  
  public synchronized void reset()
    throws IOException
  {
    super.reset();
    if (markSupported())
    {
      streamPosition = markedStreamPosition;
      blockPosition = markedBlockPosition;
    }
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    int bytesRead = super.read(b, off, len);
    if (bytesRead == -1) {
      return -1;
    }
    if ((streamPosition + bytesRead >= startingPosition) && (streamPosition <= endingPosition)) {
      for (int i = 0; i < bytesRead; i++) {
        if ((streamPosition + i >= startingPosition) && (streamPosition + i < endingPosition)) {
          block[(blockPosition++)] = b[(off + i)];
        }
      }
    }
    streamPosition += bytesRead;
    return bytesRead;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.ByteRangeCapturingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */