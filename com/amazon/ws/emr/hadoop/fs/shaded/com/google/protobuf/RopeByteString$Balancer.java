package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Arrays;
import java.util.Stack;

class RopeByteString$Balancer
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
      doBalance(RopeByteString.access$400(rbs));
      doBalance(RopeByteString.access$500(rbs));
    }
    else
    {
      throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + root.getClass());
    }
  }
  
  private void insert(ByteString byteString)
  {
    int depthBin = getDepthBinForLength(byteString.size());
    int binEnd = RopeByteString.access$600()[(depthBin + 1)];
    if ((prefixesStack.isEmpty()) || (((ByteString)prefixesStack.peek()).size() >= binEnd))
    {
      prefixesStack.push(byteString);
    }
    else
    {
      int binStart = RopeByteString.access$600()[depthBin];
      
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
        binEnd = RopeByteString.access$600()[(depthBin + 1)];
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
    int depth = Arrays.binarySearch(RopeByteString.access$600(), length);
    if (depth < 0)
    {
      int insertionPoint = -(depth + 1);
      depth = insertionPoint - 1;
    }
    return depth;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RopeByteString.Balancer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */