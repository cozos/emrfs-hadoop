package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

final class TypeToken$TypeCollector$4
  extends Ordering<K>
{
  TypeToken$TypeCollector$4(Comparator paramComparator, Map paramMap) {}
  
  public int compare(K left, K right)
  {
    return val$valueComparator.compare(val$map.get(left), val$map.get(right));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeCollector.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */