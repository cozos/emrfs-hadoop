package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class TreeMultiset$1
  extends Multisets.AbstractEntry<E>
{
  TreeMultiset$1(TreeMultiset paramTreeMultiset, TreeMultiset.AvlNode paramAvlNode) {}
  
  public E getElement()
  {
    return (E)val$baseEntry.getElement();
  }
  
  public int getCount()
  {
    int result = val$baseEntry.getCount();
    if (result == 0) {
      return this$0.count(getElement());
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeMultiset.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */