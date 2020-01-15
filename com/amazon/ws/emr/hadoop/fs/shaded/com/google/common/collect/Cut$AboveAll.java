package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class Cut$AboveAll
  extends Cut<Comparable<?>>
{
  private static final AboveAll INSTANCE = new AboveAll();
  private static final long serialVersionUID = 0L;
  
  private Cut$AboveAll()
  {
    super(null);
  }
  
  Comparable<?> endpoint()
  {
    throw new IllegalStateException("range unbounded on this side");
  }
  
  boolean isLessThan(Comparable<?> value)
  {
    return false;
  }
  
  BoundType typeAsLowerBound()
  {
    throw new AssertionError("this statement should be unreachable");
  }
  
  BoundType typeAsUpperBound()
  {
    throw new IllegalStateException();
  }
  
  Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain)
  {
    throw new AssertionError("this statement should be unreachable");
  }
  
  Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> domain)
  {
    throw new IllegalStateException();
  }
  
  void describeAsLowerBound(StringBuilder sb)
  {
    throw new AssertionError();
  }
  
  void describeAsUpperBound(StringBuilder sb)
  {
    sb.append("+∞)");
  }
  
  Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> domain)
  {
    throw new AssertionError();
  }
  
  Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> domain)
  {
    return domain.maxValue();
  }
  
  public int compareTo(Cut<Comparable<?>> o)
  {
    return o == this ? 0 : 1;
  }
  
  public String toString()
  {
    return "+∞";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Cut.AboveAll
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */