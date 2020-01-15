package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ObjectUtils;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

final class TypeUtils$WildcardTypeImpl
  implements WildcardType
{
  private static final Type[] EMPTY_BOUNDS = new Type[0];
  private final Type[] upperBounds;
  private final Type[] lowerBounds;
  
  private TypeUtils$WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds)
  {
    this.upperBounds = ((Type[])ObjectUtils.defaultIfNull(upperBounds, EMPTY_BOUNDS));
    this.lowerBounds = ((Type[])ObjectUtils.defaultIfNull(lowerBounds, EMPTY_BOUNDS));
  }
  
  public Type[] getUpperBounds()
  {
    return (Type[])upperBounds.clone();
  }
  
  public Type[] getLowerBounds()
  {
    return (Type[])lowerBounds.clone();
  }
  
  public String toString()
  {
    return TypeUtils.toString(this);
  }
  
  public boolean equals(Object obj)
  {
    return (obj == this) || (((obj instanceof WildcardType)) && (TypeUtils.access$300(this, (WildcardType)obj)));
  }
  
  public int hashCode()
  {
    int result = 18688;
    result |= Arrays.hashCode(upperBounds);
    result <<= 8;
    result |= Arrays.hashCode(lowerBounds);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.TypeUtils.WildcardTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */