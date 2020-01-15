package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple;

public class MutableTriple<L, M, R>
  extends Triple<L, M, R>
{
  private static final long serialVersionUID = 1L;
  public L left;
  public M middle;
  public R right;
  
  public static <L, M, R> MutableTriple<L, M, R> of(L left, M middle, R right)
  {
    return new MutableTriple(left, middle, right);
  }
  
  public MutableTriple() {}
  
  public MutableTriple(L left, M middle, R right)
  {
    this.left = left;
    this.middle = middle;
    this.right = right;
  }
  
  public L getLeft()
  {
    return (L)left;
  }
  
  public void setLeft(L left)
  {
    this.left = left;
  }
  
  public M getMiddle()
  {
    return (M)middle;
  }
  
  public void setMiddle(M middle)
  {
    this.middle = middle;
  }
  
  public R getRight()
  {
    return (R)right;
  }
  
  public void setRight(R right)
  {
    this.right = right;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.MutableTriple
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */