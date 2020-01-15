package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SdkInternalApi
final class ConvertibleType<T>
{
  private final DynamoDBTypeConverter<?, T> typeConverter;
  private final DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType;
  private final ConvertibleType<T>[] params;
  private final Class<T> targetType;
  @Deprecated
  private final Method getter;
  @Deprecated
  private final Method setter;
  
  private ConvertibleType(Type genericType, StandardAnnotationMaps.TypedMap<T> annotations, Method getter)
  {
    typeConverter = annotations.typeConverter();
    attributeType = annotations.attributeType();
    if (typeConverter != null)
    {
      ConvertibleType<T> target = of(typeConverter);
      targetType = targetType;
      params = params;
    }
    else if ((genericType instanceof ParameterizedType))
    {
      Type[] paramTypes = ((ParameterizedType)genericType).getActualTypeArguments();
      targetType = annotations.targetType();
      params = new ConvertibleType[paramTypes.length];
      for (int i = 0; i < paramTypes.length; i++) {
        params[i] = of(paramTypes[i]);
      }
    }
    else
    {
      targetType = annotations.targetType();
      params = new ConvertibleType[0];
    }
    setter = (getter == null ? null : StandardBeanProperties.MethodReflect.setterOf(getter));
    this.getter = getter;
  }
  
  final <S> DynamoDBTypeConverter<S, T> typeConverter()
  {
    return typeConverter;
  }
  
  final DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType()
  {
    return attributeType;
  }
  
  @Deprecated
  final Method getter()
  {
    return getter;
  }
  
  @Deprecated
  final Method setter()
  {
    return setter;
  }
  
  final <t> ConvertibleType<t> param(int index)
  {
    return params.length > index ? params[index] : null;
  }
  
  final boolean is(ScalarAttributeType scalarAttributeType, StandardTypeConverters.Vector vector)
  {
    return (param(0) != null) && (param(0).is(scalarAttributeType)) && (is(vector));
  }
  
  final boolean is(ScalarAttributeType scalarAttributeType)
  {
    return StandardTypeConverters.Scalar.of(targetType()).is(scalarAttributeType);
  }
  
  final boolean is(StandardTypeConverters.Scalar scalar)
  {
    return scalar.is(targetType());
  }
  
  final boolean is(StandardTypeConverters.Vector vector)
  {
    return vector.is(targetType());
  }
  
  final boolean is(Class<?> type)
  {
    return type.isAssignableFrom(targetType());
  }
  
  final Class<T> targetType()
  {
    return targetType;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder(targetType().getSimpleName());
    if (params.length > 0)
    {
      builder.append("<");
      for (int i = 0; i < params.length; i++) {
        builder.append(i == 0 ? "" : ",").append(params[i]);
      }
      builder.append(">");
    }
    return builder.toString();
  }
  
  static <T> ConvertibleType<T> of(Method getter, StandardAnnotationMaps.TypedMap<T> annotations)
  {
    return new ConvertibleType(getter.getGenericReturnType(), annotations, getter);
  }
  
  private static <T> ConvertibleType<T> of(DynamoDBTypeConverter<?, T> converter)
  {
    Class<?> clazz = converter.getClass();
    if (!clazz.isInterface())
    {
      for (Class<?> c = clazz; Object.class != c; c = c.getSuperclass()) {
        for (Type genericType : c.getGenericInterfaces())
        {
          ConvertibleType<T> type = of(genericType);
          if ((type.is(DynamoDBTypeConverter.class)) && 
            (params.length == 2) && (type.param(0).targetType() != Object.class)) {
            return type.param(0);
          }
        }
      }
      ConvertibleType<T> type = of(clazz.getGenericSuperclass());
      if ((type.is(DynamoDBTypeConverter.class)) && 
        (params.length > 0) && (type.param(0).targetType() != Object.class)) {
        return type.param(0);
      }
    }
    throw new DynamoDBMappingException("could not resolve type of " + clazz);
  }
  
  private static <T> ConvertibleType<T> of(Type genericType)
  {
    Class<T> targetType;
    Class<T> targetType;
    if ((genericType instanceof Class))
    {
      targetType = (Class)genericType;
    }
    else
    {
      Class<T> targetType;
      if ((genericType instanceof ParameterizedType))
      {
        targetType = (Class)((ParameterizedType)genericType).getRawType();
      }
      else
      {
        Class<T> targetType;
        if (genericType.toString().equals("byte[]")) {
          targetType = byte[].class;
        } else {
          targetType = Object.class;
        }
      }
    }
    StandardAnnotationMaps.TypedMap<T> annotations = StandardAnnotationMaps.of(targetType);
    return new ConvertibleType(genericType, annotations, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConvertibleType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */