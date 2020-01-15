package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public final class ByteString$Output
  extends OutputStream
{
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private final int initialCapacity;
  private final ArrayList<ByteString> flushedBuffers;
  private int flushedBuffersTotalBytes;
  private byte[] buffer;
  private int bufferPos;
  
  ByteString$Output(int initialCapacity)
  {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Buffer size < 0");
    }
    this.initialCapacity = initialCapacity;
    flushedBuffers = new ArrayList();
    buffer = new byte[initialCapacity];
  }
  
  public synchronized void write(int b)
  {
    if (bufferPos == buffer.length) {
      flushFullBuffer(1);
    }
    buffer[(bufferPos++)] = ((byte)b);
  }
  
  public synchronized void write(byte[] b, int offset, int length)
  {
    if (length <= buffer.length - bufferPos)
    {
      System.arraycopy(b, offset, buffer, bufferPos, length);
      bufferPos += length;
    }
    else
    {
      int copySize = buffer.length - bufferPos;
      System.arraycopy(b, offset, buffer, bufferPos, copySize);
      offset += copySize;
      length -= copySize;
      
      flushFullBuffer(length);
      System.arraycopy(b, offset, buffer, 0, length);
      bufferPos = length;
    }
  }
  
  public synchronized ByteString toByteString()
  {
    flushLastBuffer();
    return ByteString.copyFrom(flushedBuffers);
  }
  
  private byte[] copyArray(byte[] buffer, int length)
  {
    byte[] result = new byte[length];
    System.arraycopy(buffer, 0, result, 0, Math.min(buffer.length, length));
    return result;
  }
  
  public void writeTo(OutputStream out)
    throws IOException
  {
    ByteString[] cachedFlushBuffers;
    byte[] cachedBuffer;
    int cachedBufferPos;
    synchronized (this)
    {
      cachedFlushBuffers = (ByteString[])flushedBuffers.toArray(new ByteString[flushedBuffers.size()]);
      
      cachedBuffer = buffer;
      cachedBufferPos = bufferPos;
    }
    for (ByteString byteString : cachedFlushBuffers) {
      byteString.writeTo(out);
    }
    out.write(copyArray(cachedBuffer, cachedBufferPos));
  }
  
  public synchronized int size()
  {
    return flushedBuffersTotalBytes + bufferPos;
  }
  
  public synchronized void reset()
  {
    flushedBuffers.clear();
    flushedBuffersTotalBytes = 0;
    bufferPos = 0;
  }
  
  public String toString()
  {
    return String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  private void flushFullBuffer(int minSize)
  {
    flushedBuffers.add(new LiteralByteString(buffer));
    flushedBuffersTotalBytes += buffer.length;
    
    int newSize = Math.max(initialCapacity, Math.max(minSize, flushedBuffersTotalBytes >>> 1));
    
    buffer = new byte[newSize];
    bufferPos = 0;
  }
  
  private void flushLastBuffer()
  {
    if (bufferPos < buffer.length)
    {
      if (bufferPos > 0)
      {
        byte[] bufferCopy = copyArray(buffer, bufferPos);
        flushedBuffers.add(new LiteralByteString(bufferCopy));
      }
    }
    else
    {
      flushedBuffers.add(new LiteralByteString(buffer));
      
      buffer = EMPTY_BYTE_ARRAY;
    }
    flushedBuffersTotalBytes += bufferPos;
    bufferPos = 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ByteString.Output
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */