package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

final class $Hashing
{
  private static final int MAX_TABLE_SIZE = 1073741824;
  private static final int CUTOFF = 536870912;
  
  static int smear(int hashCode)
  {
    hashCode ^= hashCode >>> 20 ^ hashCode >>> 12;
    return hashCode ^ hashCode >>> 7 ^ hashCode >>> 4;
  }
  
  static int chooseTableSize(int setSize)
  {
    if (setSize < 536870912) {
      return Integer.highestOneBit(setSize) << 2;
    }
    .Preconditions.checkArgument(setSize < 1073741824, "collection too large");
    return 1073741824;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Hashing
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */