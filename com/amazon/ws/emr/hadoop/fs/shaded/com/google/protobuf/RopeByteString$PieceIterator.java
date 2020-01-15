package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class RopeByteString$PieceIterator
  implements Iterator<LiteralByteString>
{
  private final Stack<RopeByteString> breadCrumbs = new Stack();
  private LiteralByteString next;
  
  private RopeByteString$PieceIterator(ByteString root)
  {
    next = getLeafByLeft(root);
  }
  
  private LiteralByteString getLeafByLeft(ByteString root)
  {
    ByteString pos = root;
    while ((pos instanceof RopeByteString))
    {
      RopeByteString rbs = (RopeByteString)pos;
      breadCrumbs.push(rbs);
      pos = RopeByteString.access$400(rbs);
    }
    return (LiteralByteString)pos;
  }
  
  private LiteralByteString getNextNonEmptyLeaf()
  {
    for (;;)
    {
      if (breadCrumbs.isEmpty()) {
        return null;
      }
      LiteralByteString result = getLeafByLeft(RopeByteString.access$500((RopeByteString)breadCrumbs.pop()));
      if (!result.isEmpty()) {
        return result;
      }
    }
  }
  
  public boolean hasNext()
  {
    return next != null;
  }
  
  public LiteralByteString next()
  {
    if (next == null) {
      throw new NoSuchElementException();
    }
    LiteralByteString result = next;
    next = getNextNonEmptyLeaf();
    return result;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RopeByteString.PieceIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */