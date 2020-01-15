package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ObjectUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class TypeUtils$ParameterizedTypeImpl
  implements ParameterizedType
{
  private final Class<?> raw;
  private final Type useOwner;
  private final Type[] typeArguments;
  
  private TypeUtils$ParameterizedTypeImpl(Class<?> raw, Type useOwner, Type[] typeArguments)
  {
    this.raw = raw;
    this.useOwner = useOwner;
    this.typeArguments = typeArguments;
  }
  
  public Type getRawType()
  {
    return raw;
  }
  
  public Type getOwnerType()
  {
    return useOwner;
  }
  
  public Type[] getActualTypeArguments()
  {
    return (Type[])typeArguments.clone();
  }
  
  public String toString()
  {
    return TypeUtils.toString(this);
  }
  
  public boolean equals(Object obj)
  {
    return (obj == this) || (((obj instanceof ParameterizedType)) && (TypeUtils.access$200(this, (ParameterizedType)obj)));
  }
  
  public int hashCode()
  {
    int result = 1136;
    result |= raw.hashCode();
    result <<= 4;
    result |= ObjectUtils.hashCode(useOwner);
    result <<= 8;
    result |= Arrays.hashCode(typeArguments);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.TypeUtils.ParameterizedTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */