package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

class Lists$TransformingSequentialList<F, T>
  extends AbstractSequentialList<T>
  implements Serializable
{
  final List<F> fromList;
  final Function<? super F, ? extends T> function;
  private static final long serialVersionUID = 0L;
  
  Lists$TransformingSequentialList(List<F> fromList, Function<? super F, ? extends T> function)
  {
    this.fromList = ((List)Preconditions.checkNotNull(fromList));
    this.function = ((Function)Preconditions.checkNotNull(function));
  }
  
  public void clear()
  {
    fromList.clear();
  }
  
  public int size()
  {
    return fromList.size();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.TransformingSequentialList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */