package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

public final class LinkedNode<T>
{
  private final T value;
  private LinkedNode<T> next;
  
  public LinkedNode(T value, LinkedNode<T> next)
  {
    this.value = value;
    this.next = next;
  }
  
  public void linkNext(LinkedNode<T> n)
  {
    if (next != null) {
      throw new IllegalStateException();
    }
    next = n;
  }
  
  public LinkedNode<T> next()
  {
    return next;
  }
  
  public T value()
  {
    return (T)value;
  }
  
  public static <ST> boolean contains(LinkedNode<ST> node, ST value)
  {
    while (node != null)
    {
      if (node.value() == value) {
        return true;
      }
      node = node.next();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.LinkedNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */