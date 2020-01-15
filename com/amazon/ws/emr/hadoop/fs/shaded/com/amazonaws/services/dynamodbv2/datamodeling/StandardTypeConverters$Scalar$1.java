package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

 enum StandardTypeConverters$Scalar$1
{
  StandardTypeConverters$Scalar$1(ScalarAttributeType scalarAttributeType, StandardTypeConverters.ConverterMap map)
  {
    super(paramString, paramInt, scalarAttributeType, map, null);
  }
  
  <S, T> StandardTypeConverters.Converter<S, T> getConverter(Class<S> sourceType, Class<T> targetType)
  {
    if ((sourceType.isEnum()) && (StandardTypeConverters.ConverterMap.access$4600(StandardTypeConverters.Scalar.access$4500(STRING), targetType))) {
      return new StandardTypeConverters.ToEnum.FromString(sourceType, null);
    }
    return super.getConverter(sourceType, targetType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Scalar.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */