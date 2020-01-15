package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class MoreTypes$ParameterizedTypeImpl
  implements ParameterizedType, Serializable, MoreTypes.CompositeType
{
  private final Type ownerType;
  private final Type rawType;
  private final Type[] typeArguments;
  private static final long serialVersionUID = 0L;
  
  public MoreTypes$ParameterizedTypeImpl(Type ownerType, Type rawType, Type... typeArguments)
  {
    if ((rawType instanceof Class))
    {
      Class rawTypeAsClass = (Class)rawType;
      .Preconditions.checkArgument((ownerType != null) || (rawTypeAsClass.getEnclosingClass() == null), "No owner type for enclosed %s", new Object[] { rawType });
      
      .Preconditions.checkArgument((ownerType == null) || (rawTypeAsClass.getEnclosingClass() != null), "Owner type for unenclosed %s", new Object[] { rawType });
    }
    this.ownerType = (ownerType == null ? null : MoreTypes.canonicalize(ownerType));
    this.rawType = MoreTypes.canonicalize(rawType);
    this.typeArguments = ((Type[])typeArguments.clone());
    for (int t = 0; t < this.typeArguments.length; t++)
    {
      .Preconditions.checkNotNull(this.typeArguments[t], "type parameter");
      MoreTypes.access$000(this.typeArguments[t], "type parameters");
      this.typeArguments[t] = MoreTypes.canonicalize(this.typeArguments[t]);
    }
  }
  
  public Type[] getActualTypeArguments()
  {
    return (Type[])typeArguments.clone();
  }
  
  public Type getRawType()
  {
    return rawType;
  }
  
  public Type getOwnerType()
  {
    return ownerType;
  }
  
  public boolean isFullySpecified()
  {
    if ((ownerType != null) && (!MoreTypes.access$100(ownerType))) {
      return false;
    }
    if (!MoreTypes.access$100(rawType)) {
      return false;
    }
    for (Type type : typeArguments) {
      if (!MoreTypes.access$100(type)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof ParameterizedType)) && (MoreTypes.equals(this, (ParameterizedType)other));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(typeArguments) ^ rawType.hashCode() ^ MoreTypes.access$200(ownerType);
  }
  
  public String toString()
  {
    StringBuilder stringBuilder = new StringBuilder(30 * (typeArguments.length + 1));
    stringBuilder.append(MoreTypes.typeToString(rawType));
    if (typeArguments.length == 0) {
      return stringBuilder.toString();
    }
    stringBuilder.append("<").append(MoreTypes.typeToString(typeArguments[0]));
    for (int i = 1; i < typeArguments.length; i++) {
      stringBuilder.append(", ").append(MoreTypes.typeToString(typeArguments[i]));
    }
    return ">";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MoreTypes.ParameterizedTypeImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */