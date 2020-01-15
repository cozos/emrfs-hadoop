package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

import java.util.Iterator;

class AbstractRealVector$1
  implements Iterator<RealVector.Entry>
{
  private int i = 0;
  private AbstractRealVector.EntryImpl e = new AbstractRealVector.EntryImpl(this$0);
  
  AbstractRealVector$1(AbstractRealVector paramAbstractRealVector, int paramInt) {}
  
  public boolean hasNext()
  {
    return i < val$dim;
  }
  
  public RealVector.Entry next()
  {
    e.setIndex(i++);
    return e;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Not supported");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractRealVector.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */