package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

final class TypeResolver$WildcardCapturer
{
  private final AtomicInteger id = new AtomicInteger();
  
  Type capture(Type type)
  {
    Preconditions.checkNotNull(type);
    if ((type instanceof Class)) {
      return type;
    }
    if ((type instanceof TypeVariable)) {
      return type;
    }
    if ((type instanceof GenericArrayType))
    {
      GenericArrayType arrayType = (GenericArrayType)type;
      return Types.newArrayType(capture(arrayType.getGenericComponentType()));
    }
    if ((type instanceof ParameterizedType))
    {
      ParameterizedType parameterizedType = (ParameterizedType)type;
      return Types.newParameterizedTypeWithOwner(captureNullable(parameterizedType.getOwnerType()), (Class)parameterizedType.getRawType(), capture(parameterizedType.getActualTypeArguments()));
    }
    if ((type instanceof WildcardType))
    {
      WildcardType wildcardType = (WildcardType)type;
      Type[] lowerBounds = wildcardType.getLowerBounds();
      if (lowerBounds.length == 0)
      {
        Type[] upperBounds = wildcardType.getUpperBounds();
        int i = id.incrementAndGet();String str1 = String.valueOf(String.valueOf(Joiner.on('&').join(upperBounds)));String name = 33 + str1.length() + "capture#" + i + "-of ? extends " + str1;
        
        return Types.newArtificialTypeVariable(WildcardCapturer.class, name, wildcardType.getUpperBounds());
      }
      return type;
    }
    throw new AssertionError("must have been one of the known types");
  }
  
  private Type captureNullable(@Nullable Type type)
  {
    if (type == null) {
      return null;
    }
    return capture(type);
  }
  
  private Type[] capture(Type[] types)
  {
    Type[] result = new Type[types.length];
    for (int i = 0; i < types.length; i++) {
      result[i] = capture(types[i]);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeResolver.WildcardCapturer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */