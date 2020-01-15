package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class ByteString
  implements Iterable<Byte>
{
  static final int CONCATENATE_BY_COPY_SIZE = 128;
  static final int MIN_READ_FROM_CHUNK_SIZE = 256;
  static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
  public static final ByteString EMPTY = new LiteralByteString(new byte[0]);
  
  public abstract byte byteAt(int paramInt);
  
  public abstract ByteIterator iterator();
  
  public abstract int size();
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public ByteString substring(int beginIndex)
  {
    return substring(beginIndex, size());
  }
  
  public abstract ByteString substring(int paramInt1, int paramInt2);
  
  public boolean startsWith(ByteString prefix)
  {
    return (size() >= prefix.size()) && (substring(0, prefix.size()).equals(prefix));
  }
  
  public static ByteString copyFrom(byte[] bytes, int offset, int size)
  {
    byte[] copy = new byte[size];
    System.arraycopy(bytes, offset, copy, 0, size);
    return new LiteralByteString(copy);
  }
  
  public static ByteString copyFrom(byte[] bytes)
  {
    return copyFrom(bytes, 0, bytes.length);
  }
  
  public static ByteString copyFrom(ByteBuffer bytes, int size)
  {
    byte[] copy = new byte[size];
    bytes.get(copy);
    return new LiteralByteString(copy);
  }
  
  public static ByteString copyFrom(ByteBuffer bytes)
  {
    return copyFrom(bytes, bytes.remaining());
  }
  
  public static ByteString copyFrom(String text, String charsetName)
    throws UnsupportedEncodingException
  {
    return new LiteralByteString(text.getBytes(charsetName));
  }
  
  public static ByteString copyFromUtf8(String text)
  {
    try
    {
      return new LiteralByteString(text.getBytes("UTF-8"));
    }
    catch (UnsupportedEncodingException e)
    {
      throw new RuntimeException("UTF-8 not supported?", e);
    }
  }
  
  public static ByteString readFrom(InputStream streamToDrain)
    throws IOException
  {
    return readFrom(streamToDrain, 256, 8192);
  }
  
  public static ByteString readFrom(InputStream streamToDrain, int chunkSize)
    throws IOException
  {
    return readFrom(streamToDrain, chunkSize, chunkSize);
  }
  
  public static ByteString readFrom(InputStream streamToDrain, int minChunkSize, int maxChunkSize)
    throws IOException
  {
    Collection<ByteString> results = new ArrayList();
    
    int chunkSize = minChunkSize;
    for (;;)
    {
      ByteString chunk = readChunk(streamToDrain, chunkSize);
      if (chunk == null) {
        break;
      }
      results.add(chunk);
      chunkSize = Math.min(chunkSize * 2, maxChunkSize);
    }
    return copyFrom(results);
  }
  
  private static ByteString readChunk(InputStream in, int chunkSize)
    throws IOException
  {
    byte[] buf = new byte[chunkSize];
    int bytesRead = 0;
    while (bytesRead < chunkSize)
    {
      int count = in.read(buf, bytesRead, chunkSize - bytesRead);
      if (count == -1) {
        break;
      }
      bytesRead += count;
    }
    if (bytesRead == 0) {
      return null;
    }
    return copyFrom(buf, 0, bytesRead);
  }
  
  public ByteString concat(ByteString other)
  {
    int thisSize = size();
    int otherSize = other.size();
    if (thisSize + otherSize >= 2147483647L) {
      throw new IllegalArgumentException("ByteString would be too long: " + thisSize + "+" + otherSize);
    }
    return RopeByteString.concatenate(this, other);
  }
  
  public static ByteString copyFrom(Iterable<ByteString> byteStrings)
  {
    Collection<ByteString> collection;
    Collection<ByteString> collection;
    if (!(byteStrings instanceof Collection))
    {
      collection = new ArrayList();
      for (ByteString byteString : byteStrings) {
        collection.add(byteString);
      }
    }
    else
    {
      collection = (Collection)byteStrings;
    }
    ByteString result;
    ByteString result;
    if (collection.isEmpty()) {
      result = EMPTY;
    } else {
      result = balancedConcat(collection.iterator(), collection.size());
    }
    return result;
  }
  
  private static ByteString balancedConcat(Iterator<ByteString> iterator, int length)
  {
    assert (length >= 1);
    ByteString result;
    ByteString result;
    if (length == 1)
    {
      result = (ByteString)iterator.next();
    }
    else
    {
      int halfLength = length >>> 1;
      ByteString left = balancedConcat(iterator, halfLength);
      ByteString right = balancedConcat(iterator, length - halfLength);
      result = left.concat(right);
    }
    return result;
  }
  
  public void copyTo(byte[] target, int offset)
  {
    copyTo(target, 0, offset, size());
  }
  
  public void copyTo(byte[] target, int sourceOffset, int targetOffset, int numberToCopy)
  {
    if (sourceOffset < 0) {
      throw new IndexOutOfBoundsException("Source offset < 0: " + sourceOffset);
    }
    if (targetOffset < 0) {
      throw new IndexOutOfBoundsException("Target offset < 0: " + targetOffset);
    }
    if (numberToCopy < 0) {
      throw new IndexOutOfBoundsException("Length < 0: " + numberToCopy);
    }
    if (sourceOffset + numberToCopy > size()) {
      throw new IndexOutOfBoundsException("Source end offset < 0: " + (sourceOffset + numberToCopy));
    }
    if (targetOffset + numberToCopy > target.length) {
      throw new IndexOutOfBoundsException("Target end offset < 0: " + (targetOffset + numberToCopy));
    }
    if (numberToCopy > 0) {
      copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
    }
  }
  
  protected abstract void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void copyTo(ByteBuffer paramByteBuffer);
  
  public byte[] toByteArray()
  {
    int size = size();
    byte[] result = new byte[size];
    copyToInternal(result, 0, 0, size);
    return result;
  }
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract ByteBuffer asReadOnlyByteBuffer();
  
  public abstract List<ByteBuffer> asReadOnlyByteBufferList();
  
  public abstract String toString(String paramString)
    throws UnsupportedEncodingException;
  
  public String toStringUtf8()
  {
    try
    {
      return toString("UTF-8");
    }
    catch (UnsupportedEncodingException e)
    {
      throw new RuntimeException("UTF-8 not supported?", e);
    }
  }
  
  public abstract boolean isValidUtf8();
  
  protected abstract int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract InputStream newInput();
  
  public abstract CodedInputStream newCodedInput();
  
  public static Output newOutput(int initialCapacity)
  {
    return new Output(initialCapacity);
  }
  
  public static Output newOutput()
  {
    return new Output(128);
  }
  
  public static abstract interface ByteIterator
    extends Iterator<Byte>
  {
    public abstract byte nextByte();
  }
  
  public static final class Output
    extends OutputStream
  {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final int initialCapacity;
    private final ArrayList<ByteString> flushedBuffers;
    private int flushedBuffersTotalBytes;
    private byte[] buffer;
    private int bufferPos;
    
    Output(int initialCapacity)
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
  
  static CodedBuilder newCodedBuilder(int size)
  {
    return new CodedBuilder(size, null);
  }
  
  protected abstract int getTreeDepth();
  
  protected abstract boolean isBalanced();
  
  protected abstract int peekCachedHashCode();
  
  protected abstract int partialHash(int paramInt1, int paramInt2, int paramInt3);
  
  static final class CodedBuilder
  {
    private final CodedOutputStream output;
    private final byte[] buffer;
    
    private CodedBuilder(int size)
    {
      buffer = new byte[size];
      output = CodedOutputStream.newInstance(buffer);
    }
    
    public ByteString build()
    {
      output.checkNoSpaceLeft();
      
      return new LiteralByteString(buffer);
    }
    
    public CodedOutputStream getCodedOutput()
    {
      return output;
    }
  }
  
  public String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ByteString
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */