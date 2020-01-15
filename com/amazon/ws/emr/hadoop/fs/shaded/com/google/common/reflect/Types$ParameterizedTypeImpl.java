package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import javax.annotation.Nullable;

final class Types$ParameterizedTypeImpl
  implements ParameterizedType, Serializable
{
  private final Type ownerType;
  private final ImmutableList<Type> argumentsList;
  private final Class<?> rawType;
  private static final long serialVersionUID = 0L;
  
  Types$ParameterizedTypeImpl(@Nullable Type ownerType, Class<?> rawType, Type[] typeArguments)
  {
    Preconditions.checkNotNull(rawType);
    Preconditions.checkArgument(typeArguments.length == rawType.getTypeParameters().length);
    Types.access$200(typeArguments, "type parameter");
    this.ownerType = ownerType;
    this.rawType = rawType;
    argumentsList = Types.JavaVersion.CURRENT.usedInGenericType(typeArguments);
  }
  
  public Type[] getActualTypeArguments()
  {
    return Types.access$300(argumentsList);
  }
  
  public Type getRawType()
  {
    return rawType;
  }
  
  public Type getOwnerType()
  {
    return ownerType;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    if (ownerType != null) {
      builder.append(Types.JavaVersion.CURRENT.typeName(ownerType)).append('.');
    }
    builder.append(rawType.getName()).append('<').append(Types.access$500().join(Iterables.transform(argumentsList, Types.access$400()))).append('>');
    
    return builder.toString();
  }
  
  public int hashCode()
  {
    return (ownerType == null ? 0 : ownerType.hashCode()) ^ argumentsList.hashCode() ^ rawType.hashCode();
  }
  
  public boolean equals(Object other)
  {
    if (!(other instanceof ParameterizedType)) {
      return false;
    }
    ParameterizedType that = (ParameterizedType)other;
    return (getRawType().equals(that.getRawType())) && (Objects.equal(getOwnerType(), that.getOwnerType())) && (Arrays.equals(getActualTypeArguments(), that.getActualTypeArguments()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.ParameterizedTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */