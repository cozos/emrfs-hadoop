package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

class RopeByteString
  extends ByteString
{
  private static final int[] minLengthByDepth;
  private final int totalLength;
  private final ByteString left;
  private final ByteString right;
  private final int leftLength;
  private final int treeDepth;
  
  static
  {
    List<Integer> numbers = new ArrayList();
    
    int f1 = 1;
    int f2 = 1;
    while (f2 > 0)
    {
      numbers.add(Integer.valueOf(f2));
      int temp = f1 + f2;
      f1 = f2;
      f2 = temp;
    }
    numbers.add(Integer.valueOf(Integer.MAX_VALUE));
    minLengthByDepth = new int[numbers.size()];
    for (int i = 0; i < minLengthByDepth.length; i++) {
      minLengthByDepth[i] = ((Integer)numbers.get(i)).intValue();
    }
  }
  
  private RopeByteString(ByteString left, ByteString right)
  {
    this.left = left;
    this.right = right;
    leftLength = left.size();
    totalLength = (leftLength + right.size());
    treeDepth = (Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1);
  }
  
  static ByteString concatenate(ByteString left, ByteString right)
  {
    RopeByteString leftRope = (left instanceof RopeByteString) ? (RopeByteString)left : null;
    ByteString result;
    ByteString result;
    if (right.size() == 0)
    {
      result = left;
    }
    else
    {
      ByteString result;
      if (left.size() == 0)
      {
        result = right;
      }
      else
      {
        int newLength = left.size() + right.size();
        ByteString result;
        if (newLength < 128)
        {
          result = concatenateBytes(left, right);
        }
        else
        {
          ByteString result;
          if ((leftRope != null) && (right.size() + right.size() < 128))
          {
            ByteString newRight = concatenateBytes(right, right);
            result = new RopeByteString(left, newRight);
          }
          else
          {
            ByteString result;
            if ((leftRope != null) && (left.getTreeDepth() > right.getTreeDepth()) && (leftRope.getTreeDepth() > right.getTreeDepth()))
            {
              ByteString newRight = new RopeByteString(right, right);
              result = new RopeByteString(left, newRight);
            }
            else
            {
              int newDepth = Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1;
              ByteString result;
              if (newLength >= minLengthByDepth[newDepth]) {
                result = new RopeByteString(left, right);
              } else {
                result = new Balancer(null).balance(left, right);
              }
            }
          }
        }
      }
    }
    return result;
  }
  
  private static LiteralByteString concatenateBytes(ByteString left, ByteString right)
  {
    int leftSize = left.size();
    int rightSize = right.size();
    byte[] bytes = new byte[leftSize + rightSize];
    left.copyTo(bytes, 0, 0, leftSize);
    right.copyTo(bytes, 0, leftSize, rightSize);
    return new LiteralByteString(bytes);
  }
  
  static RopeByteString newInstanceForTest(ByteString left, ByteString right)
  {
    return new RopeByteString(left, right);
  }
  
  public byte byteAt(int index)
  {
    if (index < 0) {
      throw new ArrayIndexOutOfBoundsException("Index < 0: " + index);
    }
    if (index > totalLength) {
      throw new ArrayIndexOutOfBoundsException("Index > length: " + index + ", " + totalLength);
    }
    byte result;
    byte result;
    if (index < leftLength) {
      result = left.byteAt(index);
    } else {
      result = right.byteAt(index - leftLength);
    }
    return result;
  }
  
  public int size()
  {
    return totalLength;
  }
  
  protected int getTreeDepth()
  {
    return treeDepth;
  }
  
  protected boolean isBalanced()
  {
    return totalLength >= minLengthByDepth[treeDepth];
  }
  
  public ByteString substring(int beginIndex, int endIndex)
  {
    if (beginIndex < 0) {
      throw new IndexOutOfBoundsException("Beginning index: " + beginIndex + " < 0");
    }
    if (endIndex > totalLength) {
      throw new IndexOutOfBoundsException("End index: " + endIndex + " > " + totalLength);
    }
    int substringLength = endIndex - beginIndex;
    if (substringLength < 0) {
      throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + beginIndex + ", " + endIndex);
    }
    ByteString result;
    ByteString result;
    if (substringLength == 0)
    {
      result = ByteString.EMPTY;
    }
    else
    {
      ByteString result;
      if (substringLength == totalLength)
      {
        result = this;
      }
      else
      {
        ByteString result;
        if (endIndex <= leftLength)
        {
          result = left.substring(beginIndex, endIndex);
        }
        else
        {
          ByteString result;
          if (beginIndex >= leftLength)
          {
            result = right.substring(beginIndex - leftLength, endIndex - leftLength);
          }
          else
          {
            ByteString leftSub = left.substring(beginIndex);
            ByteString rightSub = right.substring(0, endIndex - leftLength);
            
            result = new RopeByteString(leftSub, rightSub);
          }
        }
      }
    }
    return result;
  }
  
  protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy)
  {
    if (sourceOffset + numberToCopy <= this.leftLength)
    {
      left.copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
    }
    else if (sourceOffset >= this.leftLength)
    {
      right.copyToInternal(target, sourceOffset - this.leftLength, targetOffset, numberToCopy);
    }
    else
    {
      int leftLength = this.leftLength - sourceOffset;
      left.copyToInternal(target, sourceOffset, targetOffset, leftLength);
      right.copyToInternal(target, 0, targetOffset + leftLength, numberToCopy - leftLength);
    }
  }
  
  public void copyTo(ByteBuffer target)
  {
    left.copyTo(target);
    right.copyTo(target);
  }
  
  public ByteBuffer asReadOnlyByteBuffer()
  {
    ByteBuffer byteBuffer = ByteBuffer.wrap(toByteArray());
    return byteBuffer.asReadOnlyBuffer();
  }
  
  public List<ByteBuffer> asReadOnlyByteBufferList()
  {
    List<ByteBuffer> result = new ArrayList();
    PieceIterator pieces = new PieceIterator(this, null);
    while (pieces.hasNext())
    {
      LiteralByteString byteString = pieces.next();
      result.add(byteString.asReadOnlyByteBuffer());
    }
    return result;
  }
  
  public void writeTo(OutputStream outputStream)
    throws IOException
  {
    left.writeTo(outputStream);
    right.writeTo(outputStream);
  }
  
  public String toString(String charsetName)
    throws UnsupportedEncodingException
  {
    return new String(toByteArray(), charsetName);
  }
  
  public boolean isValidUtf8()
  {
    int leftPartial = left.partialIsValidUtf8(0, 0, leftLength);
    int state = right.partialIsValidUtf8(leftPartial, 0, right.size());
    return state == 0;
  }
  
  protected int partialIsValidUtf8(int state, int offset, int length)
  {
    int toIndex = offset + length;
    if (toIndex <= this.leftLength) {
      return left.partialIsValidUtf8(state, offset, length);
    }
    if (offset >= this.leftLength) {
      return right.partialIsValidUtf8(state, offset - this.leftLength, length);
    }
    int leftLength = this.leftLength - offset;
    int leftPartial = left.partialIsValidUtf8(state, offset, leftLength);
    return right.partialIsValidUtf8(leftPartial, 0, length - leftLength);
  }
  
  public boolean equals(Object other)
  {
    if (other == this) {
      return true;
    }
    if (!(other instanceof ByteString)) {
      return false;
    }
    ByteString otherByteString = (ByteString)other;
    if (totalLength != otherByteString.size()) {
      return false;
    }
    if (totalLength == 0) {
      return true;
    }
    if (hash != 0)
    {
      int cachedOtherHash = otherByteString.peekCachedHashCode();
      if ((cachedOtherHash != 0) && (hash != cachedOtherHash)) {
        return false;
      }
    }
    return equalsFragments(otherByteString);
  }
  
  private boolean equalsFragments(ByteString other)
  {
    int thisOffset = 0;
    Iterator<LiteralByteString> thisIter = new PieceIterator(this, null);
    LiteralByteString thisString = (LiteralByteString)thisIter.next();
    
    int thatOffset = 0;
    Iterator<LiteralByteString> thatIter = new PieceIterator(other, null);
    LiteralByteString thatString = (LiteralByteString)thatIter.next();
    
    int pos = 0;
    for (;;)
    {
      int thisRemaining = thisString.size() - thisOffset;
      int thatRemaining = thatString.size() - thatOffset;
      int bytesToCompare = Math.min(thisRemaining, thatRemaining);
      
      boolean stillEqual = thisOffset == 0 ? thisString.equalsRange(thatString, thatOffset, bytesToCompare) : thatString.equalsRange(thisString, thisOffset, bytesToCompare);
      if (!stillEqual) {
        return false;
      }
      pos += bytesToCompare;
      if (pos >= totalLength)
      {
        if (pos == totalLength) {
          return true;
        }
        throw new IllegalStateException();
      }
      if (bytesToCompare == thisRemaining)
      {
        thisOffset = 0;
        thisString = (LiteralByteString)thisIter.next();
      }
      else
      {
        thisOffset += bytesToCompare;
      }
      if (bytesToCompare == thatRemaining)
      {
        thatOffset = 0;
        thatString = (LiteralByteString)thatIter.next();
      }
      else
      {
        thatOffset += bytesToCompare;
      }
    }
  }
  
  private int hash = 0;
  
  public int hashCode()
  {
    int h = hash;
    if (h == 0)
    {
      h = totalLength;
      h = partialHash(h, 0, totalLength);
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
    int toIndex = offset + length;
    if (toIndex <= this.leftLength) {
      return left.partialHash(h, offset, length);
    }
    if (offset >= this.leftLength) {
      return right.partialHash(h, offset - this.leftLength, length);
    }
    int leftLength = this.leftLength - offset;
    int leftPartial = left.partialHash(h, offset, leftLength);
    return right.partialHash(leftPartial, 0, length - leftLength);
  }
  
  public CodedInputStream newCodedInput()
  {
    return CodedInputStream.newInstance(new RopeInputStream());
  }
  
  public InputStream newInput()
  {
    return new RopeInputStream();
  }
  
  private static class Balancer
  {
    private final Stack<ByteString> prefixesStack = new Stack();
    
    private ByteString balance(ByteString left, ByteString right)
    {
      doBalance(left);
      doBalance(right);
      
      ByteString partialString = (ByteString)prefixesStack.pop();
      while (!prefixesStack.isEmpty())
      {
        ByteString newLeft = (ByteString)prefixesStack.pop();
        partialString = new RopeByteString(newLeft, partialString, null);
      }
      return partialString;
    }
    
    private void doBalance(ByteString root)
    {
      if (root.isBalanced())
      {
        insert(root);
      }
      else if ((root instanceof RopeByteString))
      {
        RopeByteString rbs = (RopeByteString)root;
        doBalance(left);
        doBalance(right);
      }
      else
      {
        throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + root.getClass());
      }
    }
    
    private void insert(ByteString byteString)
    {
      int depthBin = getDepthBinForLength(byteString.size());
      int binEnd = RopeByteString.minLengthByDepth[(depthBin + 1)];
      if ((prefixesStack.isEmpty()) || (((ByteString)prefixesStack.peek()).size() >= binEnd))
      {
        prefixesStack.push(byteString);
      }
      else
      {
        int binStart = RopeByteString.minLengthByDepth[depthBin];
        
        ByteString newTree = (ByteString)prefixesStack.pop();
        while ((!prefixesStack.isEmpty()) && (((ByteString)prefixesStack.peek()).size() < binStart))
        {
          ByteString left = (ByteString)prefixesStack.pop();
          newTree = new RopeByteString(left, newTree, null);
        }
        newTree = new RopeByteString(newTree, byteString, null);
        while (!prefixesStack.isEmpty())
        {
          depthBin = getDepthBinForLength(newTree.size());
          binEnd = RopeByteString.minLengthByDepth[(depthBin + 1)];
          if (((ByteString)prefixesStack.peek()).size() >= binEnd) {
            break;
          }
          ByteString left = (ByteString)prefixesStack.pop();
          newTree = new RopeByteString(left, newTree, null);
        }
        prefixesStack.push(newTree);
      }
    }
    
    private int getDepthBinForLength(int length)
    {
      int depth = Arrays.binarySearch(RopeByteString.minLengthByDepth, length);
      if (depth < 0)
      {
        int insertionPoint = -(depth + 1);
        depth = insertionPoint - 1;
      }
      return depth;
    }
  }
  
  private static class PieceIterator
    implements Iterator<LiteralByteString>
  {
    private final Stack<RopeByteString> breadCrumbs = new Stack();
    private LiteralByteString next;
    
    private PieceIterator(ByteString root)
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
        pos = left;
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
        LiteralByteString result = getLeafByLeft(breadCrumbs.pop()).right);
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
  
  public ByteString.ByteIterator iterator()
  {
    return new RopeByteIterator(null);
  }
  
  private class RopeByteIterator
    implements ByteString.ByteIterator
  {
    private final RopeByteString.PieceIterator pieces;
    private ByteString.ByteIterator bytes;
    int bytesRemaining;
    
    private RopeByteIterator()
    {
      pieces = new RopeByteString.PieceIterator(RopeByteString.this, null);
      bytes = pieces.next().iterator();
      bytesRemaining = size();
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
  
  private class RopeInputStream
    extends InputStream
  {
    private RopeByteString.PieceIterator pieceIterator;
    private LiteralByteString currentPiece;
    private int currentPieceSize;
    private int currentPieceIndex;
    private int currentPieceOffsetInRope;
    private int mark;
    
    public RopeInputStream()
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
      return size() - bytesRead;
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
      pieceIterator = new RopeByteString.PieceIterator(RopeByteString.this, null);
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RopeByteString
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */