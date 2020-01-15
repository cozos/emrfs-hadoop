package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

class RopeByteString$RopeByteIterator
  implements ByteString.ByteIterator
{
  private final RopeByteString.PieceIterator pieces;
  private ByteString.ByteIterator bytes;
  int bytesRemaining;
  
  private RopeByteString$RopeByteIterator(RopeByteString paramRopeByteString)
  {
    pieces = new RopeByteString.PieceIterator(paramRopeByteString, null);
    bytes = pieces.next().iterator();
    bytesRemaining = paramRopeByteString.size();
  }
  
  public boolean hasNext()
  {
    return bytesRemaining > 0;
  }
  
  public Byte next()
  {
    return Byte.valueOf(nextByte());
  }
  
  public byte nextByte()
  {
    if (!bytes.hasNext()) {
      bytes = pieces.next().iterator();
    }
    bytesRemaining -= 1;
    return bytes.nextByte();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RopeByteString.RopeByteIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */