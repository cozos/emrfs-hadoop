package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import java.util.Comparator;

 enum UnsignedInts$LexicographicalComparator
  implements Comparator<int[]>
{
  INSTANCE;
  
  private UnsignedInts$LexicographicalComparator() {}
  
  public int compare(int[] left, int[] right)
  {
    int minLength = Math.min(left.length, right.length);
    for (int i = 0; i < minLength; i++) {
      if (left[i] != right[i]) {
        return UnsignedInts.compare(left[i], right[i]);
      }
    }
    return left.length - right.length;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.UnsignedInts.LexicographicalComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */