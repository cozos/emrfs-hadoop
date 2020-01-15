package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

 enum TreeMultiset$Aggregate$1
{
  TreeMultiset$Aggregate$1()
  {
    super(paramString, paramInt, null);
  }
  
  int nodeAggregate(TreeMultiset.AvlNode<?> node)
  {
    return TreeMultiset.AvlNode.access$200(node);
  }
  
  long treeAggregate(@Nullable TreeMultiset.AvlNode<?> root)
  {
    return root == null ? 0L : TreeMultiset.AvlNode.access$300(root);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeMultiset.Aggregate.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */