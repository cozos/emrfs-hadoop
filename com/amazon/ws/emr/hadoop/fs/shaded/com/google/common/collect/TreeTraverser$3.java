package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class TreeTraverser$3
  extends FluentIterable<T>
{
  TreeTraverser$3(TreeTraverser paramTreeTraverser, Object paramObject) {}
  
  public UnmodifiableIterator<T> iterator()
  {
    return new TreeTraverser.BreadthFirstIterator(this$0, val$root);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeTraverser.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */