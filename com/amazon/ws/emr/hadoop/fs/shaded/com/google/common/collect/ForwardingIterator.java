package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract class ForwardingIterator<T>
  extends ForwardingObject
  implements Iterator<T>
{
  protected abstract Iterator<T> delegate();
  
  public boolean hasNext()
  {
    return delegate().hasNext();
  }
  
  public T next()
  {
    return (T)delegate().next();
  }
  
  public void remove()
  {
    delegate().remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */