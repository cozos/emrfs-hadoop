package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

final class Types$WildcardTypeImpl
  implements WildcardType, Serializable
{
  private final ImmutableList<Type> lowerBounds;
  private final ImmutableList<Type> upperBounds;
  private static final long serialVersionUID = 0L;
  
  Types$WildcardTypeImpl(Type[] lowerBounds, Type[] upperBounds)
  {
    Types.access$200(lowerBounds, "lower bound for wildcard");
    Types.access$200(upperBounds, "upper bound for wildcard");
    this.lowerBounds = Types.JavaVersion.CURRENT.usedInGenericType(lowerBounds);
    this.upperBounds = Types.JavaVersion.CURRENT.usedInGenericType(upperBounds);
  }
  
  public Type[] getLowerBounds()
  {
    return Types.access$300(lowerBounds);
  }
  
  public Type[] getUpperBounds()
  {
    return Types.access$300(upperBounds);
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof WildcardType))
    {
      WildcardType that = (WildcardType)obj;
      return (lowerBounds.equals(Arrays.asList(that.getLowerBounds()))) && (upperBounds.equals(Arrays.asList(that.getUpperBounds())));
    }
    return false;
  }
  
  public int hashCode()
  {
    return lowerBounds.hashCode() ^ upperBounds.hashCode();
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder("?");
    for (Type lowerBound : lowerBounds) {
      builder.append(" super ").append(Types.JavaVersion.CURRENT.typeName(lowerBound));
    }
    for (Type upperBound : Types.access$600(upperBounds)) {
      builder.append(" extends ").append(Types.JavaVersion.CURRENT.typeName(upperBound));
    }
    return builder.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.WildcardTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */