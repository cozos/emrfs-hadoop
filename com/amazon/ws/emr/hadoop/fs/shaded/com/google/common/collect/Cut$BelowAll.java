package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.NoSuchElementException;

final class Cut$BelowAll
  extends Cut<Comparable<?>>
{
  private static final BelowAll INSTANCE = new BelowAll();
  private static final long serialVersionUID = 0L;
  
  private Cut$BelowAll()
  {
    super(null);
  }
  
  Comparable<?> endpoint()
  {
    throw new IllegalStateException("range unbounded on this side");
  }
  
  boolean isLessThan(Comparable<?> value)
  {
    return true;
  }
  
  BoundType typeAsLowerBound()
  {
    throw new IllegalStateException();
  }
  
  BoundType typeAsUpperBound()
  {
    throw new AssertionError("this statement should be unreachable");
  }
  
  Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain)
  {
    throw new IllegalStateException();
  }
  
  Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain)
  {
    throw new AssertionError("this statement should be unreachable");
  }
  
  void describeAsLowerBound(StringBuilder sb)
  {
    sb.append("(-∞");
  }
  
  void describeAsUpperBound(StringBuilder sb)
  {
    throw new AssertionError();
  }
  
  Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> domain)
  {
    return domain.minValue();
  }
  
  Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> domain)
  {
    throw new AssertionError();
  }
  
  Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> domain)
  {
    try
    {
      return Cut.belowValue(domain.minValue());
    }
    catch (NoSuchElementException e) {}
    return this;
  }
  
  public int compareTo(Cut<Comparable<?>> o)
  {
    return o == this ? 0 : -1;
  }
  
  public String toString()
  {
    return "-∞";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Cut.BelowAll
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */