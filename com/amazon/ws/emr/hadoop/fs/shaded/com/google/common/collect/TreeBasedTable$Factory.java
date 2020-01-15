package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeMap;

class TreeBasedTable$Factory<C, V>
  implements Supplier<TreeMap<C, V>>, Serializable
{
  final Comparator<? super C> comparator;
  private static final long serialVersionUID = 0L;
  
  TreeBasedTable$Factory(Comparator<? super C> comparator)
  {
    this.comparator = comparator;
  }
  
  public TreeMap<C, V> get()
  {
    return new TreeMap(comparator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeBasedTable.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */