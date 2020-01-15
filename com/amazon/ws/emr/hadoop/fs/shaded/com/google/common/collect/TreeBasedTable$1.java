package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class TreeBasedTable$1
  implements Function<Map<C, V>, Iterator<C>>
{
  TreeBasedTable$1(TreeBasedTable paramTreeBasedTable) {}
  
  public Iterator<C> apply(Map<C, V> input)
  {
    return input.keySet().iterator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeBasedTable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */