package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import java.util.Comparator;

 enum Doubles$LexicographicalComparator
  implements Comparator<double[]>
{
  INSTANCE;
  
  private Doubles$LexicographicalComparator() {}
  
  public int compare(double[] left, double[] right)
  {
    int minLength = Math.min(left.length, right.length);
    for (int i = 0; i < minLength; i++)
    {
      int result = Double.compare(left[i], right[i]);
      if (result != 0) {
        return result;
      }
    }
    return left.length - right.length;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Doubles.LexicographicalComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */