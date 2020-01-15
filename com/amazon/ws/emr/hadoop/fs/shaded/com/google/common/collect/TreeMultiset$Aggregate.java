package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

 enum TreeMultiset$Aggregate
{
  SIZE,  DISTINCT;
  
  private TreeMultiset$Aggregate() {}
  
  abstract int nodeAggregate(TreeMultiset.AvlNode<?> paramAvlNode);
  
  abstract long treeAggregate(@Nullable TreeMultiset.AvlNode<?> paramAvlNode);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeMultiset.Aggregate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */