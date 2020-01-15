package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

class RopeByteString$RopeInputStream
  extends InputStream
{
  private RopeByteString.PieceIterator pieceIterator;
  private LiteralByteString currentPiece;
  private int currentPieceSize;
  private int currentPieceIndex;
  private int currentPieceOffsetInRope;
  private int mark;
  
  public RopeByteString$RopeInputStream(RopeByteString paramRopeByteString)
  {
    initialize();
  }
  
  public int read(byte[] b, int offset, int length)
  {
    if (b == null) {
      throw new NullPointerException();
    }
    if ((offset < 0) || (length < 0) || (length > b.length - offset)) {
      throw new IndexOutOfBoundsException();
    }
    return readSkipInternal(b, offset, length);
  }
  
  public long skip(long length)
  {
    if (length < 0L) {
      throw new IndexOutOfBoundsException();
    }
    if (length > 2147483647L) {
      length = 2147483647L;
    }
    return readSkipInternal(null, 0, (int)length);
  }
  
  private int readSkipInternal(byte[] b, int offset, int length)
  {
    int bytesRemaining = length;
    while (bytesRemaining > 0)
    {
      advanceIfCurrentPieceFullyRead();
      if (currentPiece == null)
      {
        if (bytesRemaining != length) {
          break;
        }
        return -1;
      }
      int currentPieceRemaining = currentPieceSize - currentPieceIndex;
      int count = Math.min(currentPieceRemaining, bytesRemaining);
      if (b != null)
      {
        currentPiece.copyTo(b, currentPieceIndex, offset, count);
        offset += count;
      }
      currentPieceIndex += count;
      bytesRemaining -= count;
    }
    return length - bytesRemaining;
  }
  
  public int read()
    throws IOException
  {
    advanceIfCurrentPieceFullyRead();
    if (currentPiece == null) {
      return -1;
    }
    return currentPiece.byteAt(currentPieceIndex++) & 0xFF;
  }
  
  public int available()
    throws IOException
  {
    int bytesRead = currentPieceOffsetInRope + currentPieceIndex;
    return this$0.size() - bytesRead;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public void mark(int readAheadLimit)
  {
    mark = (currentPieceOffsetInRope + currentPieceIndex);
  }
  
  public synchronized void reset()
  {
    initialize();
    readSkipInternal(null, 0, mark);
  }
  
  private void initialize()
  {
    pieceIterator = new RopeByteString.PieceIterator(this$0, null);
    currentPiece = pieceIterator.next();
    currentPieceSize = currentPiece.size();
    currentPieceIndex = 0;
    currentPieceOffsetInRope = 0;
  }
  
  private void advanceIfCurrentPieceFullyRead()
  {
    if ((currentPiece != null) && (currentPieceIndex == currentPieceSize))
    {
      currentPieceOffsetInRope += currentPieceSize;
      currentPieceIndex = 0;
      if (pieceIterator.hasNext())
      {
        currentPiece = pieceIterator.next();
        currentPieceSize = currentPiece.size();
      }
      else
      {
        currentPiece = null;
        currentPieceSize = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RopeByteString.RopeInputStream
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */