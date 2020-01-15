package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Immutable
final class ArrayIndexElement
  extends PathElement
{
  private final int index;
  
  public ArrayIndexElement(int index)
  {
    if (index < 0) {
      throw new IllegalArgumentException("Invalid array index: " + index);
    }
    this.index = index;
  }
  
  public String toString()
  {
    return "[" + index + "]";
  }
  
  public int hashCode()
  {
    return index;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof ArrayIndexElement)) {
      return false;
    }
    return index == index;
  }
  
  String asNestedPath()
  {
    return "[" + index + "]";
  }
  
  String asToken(SubstitutionContext context)
  {
    throw new IllegalStateException();
  }
  
  String asNestedToken(SubstitutionContext context)
  {
    return asNestedPath();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.ArrayIndexElement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */