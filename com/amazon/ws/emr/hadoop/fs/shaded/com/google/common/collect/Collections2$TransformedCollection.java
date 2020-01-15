package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

class Collections2$TransformedCollection<F, T>
  extends AbstractCollection<T>
{
  final Collection<F> fromCollection;
  final Function<? super F, ? extends T> function;
  
  Collections2$TransformedCollection(Collection<F> fromCollection, Function<? super F, ? extends T> function)
  {
    this.fromCollection = ((Collection)Preconditions.checkNotNull(fromCollection));
    this.function = ((Function)Preconditions.checkNotNull(function));
  }
  
  public void clear()
  {
    fromCollection.clear();
  }
  
  public boolean isEmpty()
  {
    return fromCollection.isEmpty();
  }
  
  public Iterator<T> iterator()
  {
    return Iterators.transform(fromCollection.iterator(), function);
  }
  
  public int size()
  {
    return fromCollection.size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Collections2.TransformedCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */