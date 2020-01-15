package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

class Lists$TransformingRandomAccessList<F, T>
  extends AbstractList<T>
  implements RandomAccess, Serializable
{
  final List<F> fromList;
  final Function<? super F, ? extends T> function;
  private static final long serialVersionUID = 0L;
  
  Lists$TransformingRandomAccessList(List<F> fromList, Function<? super F, ? extends T> function)
  {
    this.fromList = ((List)Preconditions.checkNotNull(fromList));
    this.function = ((Function)Preconditions.checkNotNull(function));
  }
  
  public void clear()
  {
    fromList.clear();
  }
  
  public T get(int index)
  {
    return (T)function.apply(fromList.get(index));
  }
  
  public Iterator<T> iterator()
  {
    return listIterator();
  }
  
  public ListIterator<T> listIterator(int index)
  {
    new TransformedListIterator(fromList.listIterator(index))
    {
      T transform(F from)
      {
        return (T)function.apply(from);
      }
    };
  }
  
  public boolean isEmpty()
  {
    return fromList.isEmpty();
  }
  
  public T remove(int index)
  {
    return (T)function.apply(fromList.remove(index));
  }
  
  public int size()
  {
    return fromList.size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.TransformingRandomAccessList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */