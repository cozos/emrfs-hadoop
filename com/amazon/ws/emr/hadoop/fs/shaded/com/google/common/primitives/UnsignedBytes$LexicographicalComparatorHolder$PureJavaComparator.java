package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import java.util.Comparator;

 enum UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator
  implements Comparator<byte[]>
{
  INSTANCE;
  
  private UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator() {}
  
  public int compare(byte[] left, byte[] right)
  {
    int minLength = Math.min(left.length, right.length);
    for (int i = 0; i < minLength; i++)
    {
      int result = UnsignedBytes.compare(left[i], right[i]);
      if (result != 0) {
        return result;
      }
    }
    return left.length - right.length;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.PureJavaComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */