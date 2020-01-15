package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

public abstract class PrimitiveArrayBuilder<T>
{
  static final int INITIAL_CHUNK_SIZE = 12;
  static final int SMALL_CHUNK_SIZE = 16384;
  static final int MAX_CHUNK_SIZE = 262144;
  protected T _freeBuffer;
  protected Node<T> _bufferHead;
  protected Node<T> _bufferTail;
  protected int _bufferedEntryCount;
  
  public int bufferedSize()
  {
    return _bufferedEntryCount;
  }
  
  public T resetAndStart()
  {
    _reset();
    return (T)(_freeBuffer == null ? _constructArray(12) : _freeBuffer);
  }
  
  public final T appendCompletedChunk(T fullChunk, int fullChunkLength)
  {
    Node<T> next = new Node(fullChunk, fullChunkLength);
    if (_bufferHead == null)
    {
      _bufferHead = (_bufferTail = next);
    }
    else
    {
      _bufferTail.linkNext(next);
      _bufferTail = next;
    }
    _bufferedEntryCount += fullChunkLength;
    int nextLen = fullChunkLength;
    if (nextLen < 16384) {
      nextLen += nextLen;
    } else {
      nextLen += (nextLen >> 2);
    }
    return (T)_constructArray(nextLen);
  }
  
  public T completeAndClearBuffer(T lastChunk, int lastChunkEntries)
  {
    int totalSize = lastChunkEntries + _bufferedEntryCount;
    T resultArray = _constructArray(totalSize);
    
    int ptr = 0;
    for (Node<T> n = _bufferHead; n != null; n = n.next()) {
      ptr = n.copyData(resultArray, ptr);
    }
    System.arraycopy(lastChunk, 0, resultArray, ptr, lastChunkEntries);
    ptr += lastChunkEntries;
    if (ptr != totalSize) {
      throw new IllegalStateException("Should have gotten " + totalSize + " entries, got " + ptr);
    }
    return resultArray;
  }
  
  protected abstract T _constructArray(int paramInt);
  
  protected void _reset()
  {
    if (_bufferTail != null) {
      _freeBuffer = _bufferTail.getData();
    }
    _bufferHead = (_bufferTail = null);
    _bufferedEntryCount = 0;
  }
  
  static final class Node<T>
  {
    final T _data;
    final int _dataLength;
    Node<T> _next;
    
    public Node(T data, int dataLen)
    {
      _data = data;
      _dataLength = dataLen;
    }
    
    public T getData()
    {
      return (T)_data;
    }
    
    public int copyData(T dst, int ptr)
    {
      System.arraycopy(_data, 0, dst, ptr, _dataLength);
      ptr += _dataLength;
      return ptr;
    }
    
    public Node<T> next()
    {
      return _next;
    }
    
    public void linkNext(Node<T> next)
    {
      if (_next != null) {
        throw new IllegalStateException();
      }
      _next = next;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */