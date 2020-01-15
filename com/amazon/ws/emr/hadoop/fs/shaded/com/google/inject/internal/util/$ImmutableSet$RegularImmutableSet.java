package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

final class $ImmutableSet$RegularImmutableSet<E>
  extends .ImmutableSet.ArrayImmutableSet<E>
{
  final Object[] table;
  final int mask;
  final int hashCode;
  
  $ImmutableSet$RegularImmutableSet(Object[] elements, int hashCode, Object[] table, int mask)
  {
    super(elements);
    this.table = table;
    this.mask = mask;
    this.hashCode = hashCode;
  }
  
  public boolean contains(Object target)
  {
    if (target == null) {
      return false;
    }
    for (int i = .Hashing.smear(target.hashCode());; i++)
    {
      Object candidate = table[(i & mask)];
      if (candidate == null) {
        return false;
      }
      if (candidate.equals(target)) {
        return true;
      }
    }
  }
  
  public int hashCode()
  {
    return hashCode;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.RegularImmutableSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */