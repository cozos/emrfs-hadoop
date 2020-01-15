package com.amazon.ws.emr.hadoop.fs.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators;

public abstract class Producer<T>
{
  protected abstract boolean canProduce();
  
  protected abstract T produce();
  
  public static <T> Producer<T> of(T... elements)
  {
    return new IteratorProducer(Iterators.forArray(elements));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.concurrent.Producer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */