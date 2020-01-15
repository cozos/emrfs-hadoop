package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import java.util.Iterator;

public class AbstractRealVector$SparseEntryIterator
  implements Iterator<RealVector.Entry>
{
  private final int dim;
  private AbstractRealVector.EntryImpl tmp = new AbstractRealVector.EntryImpl(this$0);
  private AbstractRealVector.EntryImpl current;
  private AbstractRealVector.EntryImpl next;
  
  protected AbstractRealVector$SparseEntryIterator(AbstractRealVector paramAbstractRealVector)
  {
    dim = paramAbstractRealVector.getDimension();
    current = new AbstractRealVector.EntryImpl(paramAbstractRealVector);
    if (current.getValue() == 0.0D) {
      advance(current);
    }
    if (current.getIndex() >= 0)
    {
      next = new AbstractRealVector.EntryImpl(paramAbstractRealVector);
      next.setIndex(current.getIndex());
      advance(next);
    }
    else
    {
      current = null;
    }
  }
  
  protected void advance(AbstractRealVector.EntryImpl e)
  {
    if (e == null) {
      return;
    }
    do
    {
      e.setIndex(e.getIndex() + 1);
    } while ((e.getIndex() < dim) && (e.getValue() == 0.0D));
    if (e.getIndex() >= dim) {
      e.setIndex(-1);
    }
  }
  
  public boolean hasNext()
  {
    return current != null;
  }
  
  public RealVector.Entry next()
  {
    tmp.setIndex(current.getIndex());
    if (next != null)
    {
      current.setIndex(next.getIndex());
      advance(next);
      if (next.getIndex() < 0) {
        next = null;
      }
    }
    else
    {
      current = null;
    }
    return tmp;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Not supported");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractRealVector.SparseEntryIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */