package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.List;

class Lists$Partition<T>
  extends AbstractList<List<T>>
{
  final List<T> list;
  final int size;
  
  Lists$Partition(List<T> list, int size)
  {
    this.list = list;
    this.size = size;
  }
  
  public List<T> get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    int start = index * size;
    int end = Math.min(start + size, list.size());
    return list.subList(start, end);
  }
  
  public int size()
  {
    return IntMath.divide(list.size(), size, RoundingMode.CEILING);
  }
  
  public boolean isEmpty()
  {
    return list.isEmpty();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.Partition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */