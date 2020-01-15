package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.NoSuchElementException;

class BoundedByteString
  extends LiteralByteString
{
  private final int bytesOffset;
  private final int bytesLength;
  
  BoundedByteString(byte[] bytes, int offset, int length)
  {
    super(bytes);
    if (offset < 0) {
      throw new IllegalArgumentException("Offset too small: " + offset);
    }
    if (length < 0) {
      throw new IllegalArgumentException("Length too small: " + offset);
    }
    if (offset + length > bytes.length) {
      throw new IllegalArgumentException("Offset+Length too large: " + offset + "+" + length);
    }
    bytesOffset = offset;
    bytesLength = length;
  }
  
  public byte byteAt(int index)
  {
    if (index < 0) {
      throw new ArrayIndexOutOfBoundsException("Index too small: " + index);
    }
    if (index >= size()) {
      throw new ArrayIndexOutOfBoundsException("Index too large: " + index + ", " + size());
    }
    return bytes[(bytesOffset + index)];
  }
  
  public int size()
  {
    return bytesLength;
  }
  
  protected int getOffsetIntoBytes()
  {
    return bytesOffset;
  }
  
  protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy)
  {
    System.arraycopy(bytes, getOffsetIntoBytes() + sourceOffset, target, targetOffset, numberToCopy);
  }
  
  public ByteString.ByteIterator iterator()
  {
    return new BoundedByteIterator(null);
  }
  
  private class BoundedByteIterator
    implements ByteString.ByteIterator
  {
    private int position;
    private final int limit;
    
    private BoundedByteIterator()
    {
      position = getOffsetIntoBytes();
      limit = (position + size());
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
      if (position >= limit) {
        throw new NoSuchElementException();
      }
      return bytes[(position++)];
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.BoundedByteString
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */