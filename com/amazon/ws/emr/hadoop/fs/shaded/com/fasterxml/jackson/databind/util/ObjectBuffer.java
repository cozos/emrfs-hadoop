package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;
import java.util.List;

public final class ObjectBuffer
{
  private static final int SMALL_CHUNK = 16384;
  private static final int MAX_CHUNK = 262144;
  private LinkedNode<Object[]> _head;
  private LinkedNode<Object[]> _tail;
  private int _size;
  private Object[] _freeBuffer;
  
  public Object[] resetAndStart()
  {
    _reset();
    if (_freeBuffer == null) {
      return new Object[12];
    }
    return _freeBuffer;
  }
  
  public Object[] appendCompletedChunk(Object[] fullChunk)
  {
    LinkedNode<Object[]> next = new LinkedNode(fullChunk, null);
    if (_head == null)
    {
      _head = (_tail = next);
    }
    else
    {
      _tail.linkNext(next);
      _tail = next;
    }
    int len = fullChunk.length;
    _size += len;
    if (len < 16384) {
      len += len;
    } else if (len < 262144) {
      len += (len >> 2);
    }
    return new Object[len];
  }
  
  public Object[] completeAndClearBuffer(Object[] lastChunk, int lastChunkEntries)
  {
    int totalSize = lastChunkEntries + _size;
    Object[] result = new Object[totalSize];
    _copyTo(result, totalSize, lastChunk, lastChunkEntries);
    return result;
  }
  
  public <T> T[] completeAndClearBuffer(Object[] lastChunk, int lastChunkEntries, Class<T> componentType)
  {
    int totalSize = lastChunkEntries + _size;
    
    T[] result = (Object[])Array.newInstance(componentType, totalSize);
    _copyTo(result, totalSize, lastChunk, lastChunkEntries);
    _reset();
    return result;
  }
  
  public void completeAndClearBuffer(Object[] lastChunk, int lastChunkEntries, List<Object> resultList)
  {
    for (LinkedNode<Object[]> n = _head; n != null; n = n.next())
    {
      Object[] curr = (Object[])n.value();
      int i = 0;
      for (int len = curr.length; i < len; i++) {
        resultList.add(curr[i]);
      }
    }
    for (int i = 0; i < lastChunkEntries; i++) {
      resultList.add(lastChunk[i]);
    }
  }
  
  public int initialCapacity()
  {
    return _freeBuffer == null ? 0 : _freeBuffer.length;
  }
  
  public int bufferedSize()
  {
    return _size;
  }
  
  protected void _reset()
  {
    if (_tail != null) {
      _freeBuffer = ((Object[])_tail.value());
    }
    _head = (_tail = null);
    _size = 0;
  }
  
  protected final void _copyTo(Object resultArray, int totalSize, Object[] lastChunk, int lastChunkEntries)
  {
    int ptr = 0;
    for (LinkedNode<Object[]> n = _head; n != null; n = n.next())
    {
      Object[] curr = (Object[])n.value();
      int len = curr.length;
      System.arraycopy(curr, 0, resultArray, ptr, len);
      ptr += len;
    }
    System.arraycopy(lastChunk, 0, resultArray, ptr, lastChunkEntries);
    ptr += lastChunkEntries;
    if (ptr != totalSize) {
      throw new IllegalStateException("Should have gotten " + totalSize + " entries, got " + ptr);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ObjectBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */