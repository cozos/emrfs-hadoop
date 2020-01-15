package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

final class PrimitiveArrayBuilder$Node<T>
{
  final T _data;
  final int _dataLength;
  Node<T> _next;
  
  public PrimitiveArrayBuilder$Node(T data, int dataLen)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder.Node
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */