package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple;

public final class ImmutablePair<L, R>
  extends Pair<L, R>
{
  private static final long serialVersionUID = 4954918890077093841L;
  public final L left;
  public final R right;
  
  public static <L, R> ImmutablePair<L, R> of(L left, R right)
  {
    return new ImmutablePair(left, right);
  }
  
  public ImmutablePair(L left, R right)
  {
    this.left = left;
    this.right = right;
  }
  
  public L getLeft()
  {
    return (L)left;
  }
  
  public R getRight()
  {
    return (R)right;
  }
  
  public R setValue(R value)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.ImmutablePair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */