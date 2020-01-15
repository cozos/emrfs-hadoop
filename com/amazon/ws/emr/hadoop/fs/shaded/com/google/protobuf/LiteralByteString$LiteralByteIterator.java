package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.NoSuchElementException;

class LiteralByteString$LiteralByteIterator
  implements ByteString.ByteIterator
{
  private int position;
  private final int limit;
  
  private LiteralByteString$LiteralByteIterator(LiteralByteString paramLiteralByteString)
  {
    position = 0;
    limit = paramLiteralByteString.size();
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
      return this$0.bytes[(position++)];
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.LiteralByteString.LiteralByteIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */