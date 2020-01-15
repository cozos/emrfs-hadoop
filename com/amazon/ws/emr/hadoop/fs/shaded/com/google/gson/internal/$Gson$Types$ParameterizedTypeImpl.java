package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class $Gson$Types$ParameterizedTypeImpl
  implements ParameterizedType, Serializable
{
  private final Type ownerType;
  private final Type rawType;
  private final Type[] typeArguments;
  private static final long serialVersionUID = 0L;
  
  public $Gson$Types$ParameterizedTypeImpl(Type ownerType, Type rawType, Type... typeArguments)
  {
    if ((rawType instanceof Class))
    {
      Class<?> rawTypeAsClass = (Class)rawType;
      .Gson.Preconditions.checkArgument((ownerType != null) || (rawTypeAsClass.getEnclosingClass() == null));
      .Gson.Preconditions.checkArgument((ownerType == null) || (rawTypeAsClass.getEnclosingClass() != null));
    }
    this.ownerType = (ownerType == null ? null : .Gson.Types.canonicalize(ownerType));
    this.rawType = .Gson.Types.canonicalize(rawType);
    this.typeArguments = ((Type[])typeArguments.clone());
    for (int t = 0; t < this.typeArguments.length; t++)
    {
      .Gson.Preconditions.checkNotNull(this.typeArguments[t]);
      .Gson.Types.access$000(this.typeArguments[t]);
      this.typeArguments[t] = .Gson.Types.canonicalize(this.typeArguments[t]);
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
  
  public boolean equals(Object other)
  {
    return ((other instanceof ParameterizedType)) && (.Gson.Types.equals(this, (ParameterizedType)other));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(typeArguments) ^ rawType.hashCode() ^ .Gson.Types.access$100(ownerType);
  }
  
  public String toString()
  {
    StringBuilder stringBuilder = new StringBuilder(30 * (typeArguments.length + 1));
    stringBuilder.append(.Gson.Types.typeToString(rawType));
    if (typeArguments.length == 0) {
      return stringBuilder.toString();
    }
    stringBuilder.append("<").append(.Gson.Types.typeToString(typeArguments[0]));
    for (int i = 1; i < typeArguments.length; i++) {
      stringBuilder.append(", ").append(.Gson.Types.typeToString(typeArguments[i]));
    }
    return ">";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal..Gson.Types.ParameterizedTypeImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */