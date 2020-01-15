package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.NoSuchElementException;

class BoundedByteString$BoundedByteIterator
  implements ByteString.ByteIterator
{
  private int position;
  private final int limit;
  
  private BoundedByteString$BoundedByteIterator(BoundedByteString paramBoundedByteString)
  {
    position = paramBoundedByteString.getOffsetIntoBytes();
    limit = (position + paramBoundedByteString.size());
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
    return this$0.bytes[(position++)];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.BoundedByteString.BoundedByteIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */