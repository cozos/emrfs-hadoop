package com.amazon.ws.emr.hadoop.fs.concurrent;

public class IteratableProducer<T>
  extends IteratorProducer<T>
{
  public IteratableProducer(Iterable<T> iterable)
  {
    super(iterable.iterator());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.concurrent.IteratableProducer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */