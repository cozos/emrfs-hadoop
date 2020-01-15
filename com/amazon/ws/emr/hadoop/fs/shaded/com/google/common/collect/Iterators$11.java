package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class Iterators$11
  extends AbstractIndexedListIterator<T>
{
  Iterators$11(int x0, int x1, Object[] paramArrayOfObject, int paramInt1)
  {
    super(x0, x1);
  }
  
  protected T get(int index)
  {
    return (T)val$array[(val$offset + index)];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */