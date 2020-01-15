package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class LiteralByteString
  extends ByteString
{
  protected final byte[] bytes;
  
  LiteralByteString(byte[] bytes)
  {
    this.bytes = bytes;
  }
  
  public byte byteAt(int index)
  {
    return bytes[index];
  }
  
  public int size()
  {
    return bytes.length;
  }
  
  public ByteString substring(int beginIndex, int endIndex)
  {
    if (beginIndex < 0) {
      throw new IndexOutOfBoundsException("Beginning index: " + beginIndex + " < 0");
    }
    if (endIndex > size()) {
      throw new IndexOutOfBoundsException("End index: " + endIndex + " > " + size());
    }
    int substringLength = endIndex - beginIndex;
    if (substringLength < 0) {
      throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + beginIndex + ", " + endIndex);
    }
    ByteString result;
    ByteString result;
    if (substringLength == 0) {
      result = ByteString.EMPTY;
    } else {
      result = new BoundedByteString(bytes, getOffsetIntoBytes() + beginIndex, substringLength);
    }
    return result;
  }
  
  protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy)
  {
    System.arraycopy(bytes, sourceOffset, target, targetOffset, numberToCopy);
  }
  
  public void copyTo(ByteBuffer target)
  {
    target.put(bytes, getOffsetIntoBytes(), size());
  }
  
  public ByteBuffer asReadOnlyByteBuffer()
  {
    ByteBuffer byteBuffer = ByteBuffer.wrap(bytes, getOffsetIntoBytes(), size());
    
    return byteBuffer.asReadOnlyBuffer();
  }
  
  public List<ByteBuffer> asReadOnlyByteBufferList()
  {
    List<ByteBuffer> result = new ArrayList(1);
    result.add(asReadOnlyByteBuffer());
    return result;
  }
  
  public void writeTo(OutputStream outputStream)
    throws IOException
  {
    outputStream.write(toByteArray());
  }
  
  public String toString(String charsetName)
    throws UnsupportedEncodingException
  {
    return new String(bytes, getOffsetIntoBytes(), size(), charsetName);
  }
  
  public boolean isValidUtf8()
  {
    int offset = getOffsetIntoBytes();
    return Utf8.isValidUtf8(bytes, offset, offset + size());
  }
  
  protected int partialIsValidUtf8(int state, int offset, int length)
  {
    int index = getOffsetIntoBytes() + offset;
    return Utf8.partialIsValidUtf8(state, bytes, index, index + length);
  }
  
  public boolean equals(Object other)
  {
    if (other == this) {
      return true;
    }
    if (!(other instanceof ByteString)) {
      return false;
    }
    if (size() != ((ByteString)other).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((other instanceof LiteralByteString)) {
      return equalsRange((LiteralByteString)other, 0, size());
    }
    if ((other instanceof RopeByteString)) {
      return other.equals(this);
    }
    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + other.getClass());
  }
  
  boolean equalsRange(LiteralByteString other, int offset, int length)
  {
    if (length > other.size()) {
      throw new IllegalArgumentException("Length too large: " + length + size());
    }
    if (offset + length > other.size()) {
      throw new IllegalArgumentException("Ran off end of other: " + offset + ", " + length + ", " + other.size());
    }
    byte[] thisBytes = bytes;
    byte[] otherBytes = bytes;
    int thisLimit = getOffsetIntoBytes() + length;
    int thisIndex = getOffsetIntoBytes();
    for (int otherIndex = other.getOffsetIntoBytes() + offset; thisIndex < thisLimit; otherIndex++)
    {
      if (thisBytes[thisIndex] != otherBytes[otherIndex]) {
        return false;
      }
      thisIndex++;
    }
    return true;
  }
  
  private int hash = 0;
  
  public int hashCode()
  {
    int h = hash;
    if (h == 0)
    {
      int size = size();
      h = partialHash(size, 0, size);
      if (h == 0) {
        h = 1;
      }
      hash = h;
    }
    return h;
  }
  
  protected int peekCachedHashCode()
  {
    return hash;
  }
  
  protected int partialHash(int h, int offset, int length)
  {
    byte[] thisBytes = bytes;
    int i = getOffsetIntoBytes() + offset;
    for (int limit = i + length; i < limit; i++) {
      h = h * 31 + thisBytes[i];
    }
    return h;
  }
  
  public InputStream newInput()
  {
    return new ByteArrayInputStream(bytes, getOffsetIntoBytes(), size());
  }
  
  public CodedInputStream newCodedInput()
  {
    return CodedInputStream.newInstance(bytes, getOffsetIntoBytes(), size());
  }
  
  public ByteString.ByteIterator iterator()
  {
    return new LiteralByteIterator(null);
  }
  
  private class LiteralByteIterator
    implements ByteString.ByteIterator
  {
    private int position;
    private final int limit;
    
    private LiteralByteIterator()
    {
      position = 0;
      limit = size();
    }
    
    public boolean hasNext()
    {
      return position < limit;
    }
    
    public Byte next()
    {
      return Byte.valueOf(nextByte());
    }
    
    public byte nextByte()
    {
      try
      {
        return bytes[(position++)];
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
        throw new NoSuchElementException(e.getMessage());
      }
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  protected int getTreeDepth()
  {
    return 0;
  }
  
  protected boolean isBalanced()
  {
    return true;
  }
  
  protected int getOffsetIntoBytes()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.LiteralByteString
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */