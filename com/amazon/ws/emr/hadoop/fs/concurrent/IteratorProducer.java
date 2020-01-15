package com.amazon.ws.emr.hadoop.fs.concurrent;

import java.util.Iterator;

public class IteratorProducer<T>
  extends Producer<T>
{
  private final Iterator<T> iterator;
  
  public IteratorProducer(Iterator<T> iterator)
  {
    this.iterator = iterator;
  }
  
  protected boolean canProduce()
  {
    return iterator.hasNext();
  }
  
  protected T produce()
  {
    return (T)iterator.next();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.concurrent.IteratorProducer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */