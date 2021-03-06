package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple;

public class MutablePair<L, R>
  extends Pair<L, R>
{
  private static final long serialVersionUID = 4954918890077093841L;
  public L left;
  public R right;
  
  public static <L, R> MutablePair<L, R> of(L left, R right)
  {
    return new MutablePair(left, right);
  }
  
  public MutablePair() {}
  
  public MutablePair(L left, R right)
  {
    this.left = left;
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
  
  public R getRight()
  {
    return (R)right;
  }
  
  public void setRight(R right)
  {
    this.right = right;
  }
  
  public R setValue(R value)
  {
    R result = getRight();
    setRight(value);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.MutablePair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */