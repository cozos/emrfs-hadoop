package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import java.util.Comparator;

 enum UnsignedLongs$LexicographicalComparator
  implements Comparator<long[]>
{
  INSTANCE;
  
  private UnsignedLongs$LexicographicalComparator() {}
  
  public int compare(long[] left, long[] right)
  {
    int minLength = Math.min(left.length, right.length);
    for (int i = 0; i < minLength; i++) {
      if (left[i] != right[i]) {
        return UnsignedLongs.compare(left[i], right[i]);
      }
    }
    return left.length - right.length;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.UnsignedLongs.LexicographicalComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */