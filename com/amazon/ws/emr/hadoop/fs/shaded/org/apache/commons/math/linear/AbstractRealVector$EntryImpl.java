package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear;

public class AbstractRealVector$EntryImpl
  extends RealVector.Entry
{
  public AbstractRealVector$EntryImpl(AbstractRealVector paramAbstractRealVector)
  {
    setIndex(0);
  }
  
  public double getValue()
  {
    return this$0.getEntry(getIndex());
  }
  
  public void setValue(double newValue)
  {
    this$0.setEntry(getIndex(), newValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.AbstractRealVector.EntryImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */