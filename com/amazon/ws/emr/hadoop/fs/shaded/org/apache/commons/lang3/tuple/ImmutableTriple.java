package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple;

public final class ImmutableTriple<L, M, R>
  extends Triple<L, M, R>
{
  private static final long serialVersionUID = 1L;
  public final L left;
  public final M middle;
  public final R right;
  
  public static <L, M, R> ImmutableTriple<L, M, R> of(L left, M middle, R right)
  {
    return new ImmutableTriple(left, middle, right);
  }
  
  public ImmutableTriple(L left, M middle, R right)
  {
    this.left = left;
    this.middle = middle;
    this.right = right;
  }
  
  public L getLeft()
  {
    return (L)left;
  }
  
  public M getMiddle()
  {
    return (M)middle;
  }
  
  public R getRight()
  {
    return (R)right;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.ImmutableTriple
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */