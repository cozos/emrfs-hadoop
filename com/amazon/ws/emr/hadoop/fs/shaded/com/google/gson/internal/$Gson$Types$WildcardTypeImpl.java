package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class $Gson$Types$WildcardTypeImpl
  implements WildcardType, Serializable
{
  private final Type upperBound;
  private final Type lowerBound;
  private static final long serialVersionUID = 0L;
  
  public $Gson$Types$WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds)
  {
    .Gson.Preconditions.checkArgument(lowerBounds.length <= 1);
    .Gson.Preconditions.checkArgument(upperBounds.length == 1);
    if (lowerBounds.length == 1)
    {
      .Gson.Preconditions.checkNotNull(lowerBounds[0]);
      .Gson.Types.access$000(lowerBounds[0]);
      .Gson.Preconditions.checkArgument(upperBounds[0] == Object.class);
      lowerBound = .Gson.Types.canonicalize(lowerBounds[0]);
      upperBound = Object.class;
    }
    else
    {
      .Gson.Preconditions.checkNotNull(upperBounds[0]);
      .Gson.Types.access$000(upperBounds[0]);
      lowerBound = null;
      upperBound = .Gson.Types.canonicalize(upperBounds[0]);
    }
  }
  
  public Type[] getUpperBounds()
  {
    return new Type[] { upperBound };
  }
  
  public Type[] getLowerBounds()
  {
    return lowerBound != null ? new Type[] { lowerBound } : .Gson.Types.EMPTY_TYPE_ARRAY;
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof WildcardType)) && (.Gson.Types.equals(this, (WildcardType)other));
  }
  
  public int hashCode()
  {
    return (lowerBound != null ? 31 + lowerBound.hashCode() : 1) ^ 31 + upperBound.hashCode();
  }
  
  public String toString()
  {
    if (lowerBound != null) {
      return "? super " + .Gson.Types.typeToString(lowerBound);
    }
    if (upperBound == Object.class) {
      return "?";
    }
    return "? extends " + .Gson.Types.typeToString(upperBound);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal..Gson.Types.WildcardTypeImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */