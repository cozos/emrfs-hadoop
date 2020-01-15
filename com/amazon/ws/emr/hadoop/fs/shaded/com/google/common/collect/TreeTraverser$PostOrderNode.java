package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;

final class TreeTraverser$PostOrderNode<T>
{
  final T root;
  final Iterator<T> childIterator;
  
  TreeTraverser$PostOrderNode(T root, Iterator<T> childIterator)
  {
    this.root = Preconditions.checkNotNull(root);
    this.childIterator = ((Iterator)Preconditions.checkNotNull(childIterator));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeTraverser.PostOrderNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */