package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

 enum TreeMultiset$Aggregate$2
{
  TreeMultiset$Aggregate$2()
  {
    super(paramString, paramInt, null);
  }
  
  int nodeAggregate(TreeMultiset.AvlNode<?> node)
  {
    return 1;
  }
  
  long treeAggregate(@Nullable TreeMultiset.AvlNode<?> root)
  {
    return root == null ? 0L : TreeMultiset.AvlNode.access$400(root);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeMultiset.Aggregate.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */