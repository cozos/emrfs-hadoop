package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public class MoreTypes$WildcardTypeImpl
  implements WildcardType, Serializable, MoreTypes.CompositeType
{
  private final Type upperBound;
  private final Type lowerBound;
  private static final long serialVersionUID = 0L;
  
  public MoreTypes$WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds)
  {
    .Preconditions.checkArgument(lowerBounds.length <= 1, "Must have at most one lower bound.");
    .Preconditions.checkArgument(upperBounds.length == 1, "Must have exactly one upper bound.");
    if (lowerBounds.length == 1)
    {
      .Preconditions.checkNotNull(lowerBounds[0], "lowerBound");
      MoreTypes.access$000(lowerBounds[0], "wildcard bounds");
      .Preconditions.checkArgument(upperBounds[0] == Object.class, "bounded both ways");
      lowerBound = MoreTypes.canonicalize(lowerBounds[0]);
      upperBound = Object.class;
    }
    else
    {
      .Preconditions.checkNotNull(upperBounds[0], "upperBound");
      MoreTypes.access$000(upperBounds[0], "wildcard bounds");
      lowerBound = null;
      upperBound = MoreTypes.canonicalize(upperBounds[0]);
    }
  }
  
  public Type[] getUpperBounds()
  {
    return new Type[] { upperBound };
  }
  
  public Type[] getLowerBounds()
  {
    return lowerBound != null ? new Type[] { lowerBound } : MoreTypes.EMPTY_TYPE_ARRAY;
  }
  
  public boolean isFullySpecified()
  {
    return (MoreTypes.access$100(upperBound)) && ((lowerBound == null) || (MoreTypes.access$100(lowerBound)));
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof WildcardType)) && (MoreTypes.equals(this, (WildcardType)other));
  }
  
  public int hashCode()
  {
    return (lowerBound != null ? 31 + lowerBound.hashCode() : 1) ^ 31 + upperBound.hashCode();
  }
  
  public String toString()
  {
    if (lowerBound != null) {
      return "? super " + MoreTypes.typeToString(lowerBound);
    }
    if (upperBound == Object.class) {
      return "?";
    }
    return "? extends " + MoreTypes.typeToString(upperBound);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MoreTypes.WildcardTypeImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */