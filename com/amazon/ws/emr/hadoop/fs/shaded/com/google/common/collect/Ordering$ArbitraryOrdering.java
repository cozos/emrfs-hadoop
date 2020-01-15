package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@VisibleForTesting
class Ordering$ArbitraryOrdering
  extends Ordering<Object>
{
  private Map<Object, Integer> uids = Platform.tryWeakKeys(new MapMaker()).makeComputingMap(new Function()
  {
    final AtomicInteger counter = new AtomicInteger(0);
    
    public Integer apply(Object from)
    {
      return Integer.valueOf(counter.getAndIncrement());
    }
  });
  
  public int compare(Object left, Object right)
  {
    if (left == right) {
      return 0;
    }
    if (left == null) {
      return -1;
    }
    if (right == null) {
      return 1;
    }
    int leftCode = identityHashCode(left);
    int rightCode = identityHashCode(right);
    if (leftCode != rightCode) {
      return leftCode < rightCode ? -1 : 1;
    }
    int result = ((Integer)uids.get(left)).compareTo((Integer)uids.get(right));
    if (result == 0) {
      throw new AssertionError();
    }
    return result;
  }
  
  public String toString()
  {
    return "Ordering.arbitrary()";
  }
  
  int identityHashCode(Object object)
  {
    return System.identityHashCode(object);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Ordering.ArbitraryOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */