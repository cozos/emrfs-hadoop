package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;

class TypeConverterBindingProcessor$2
  implements TypeConverter
{
  TypeConverterBindingProcessor$2(TypeConverterBindingProcessor paramTypeConverterBindingProcessor) {}
  
  public Object convert(String value, TypeLiteral<?> toType)
  {
    return Enum.valueOf(toType.getRawType(), value);
  }
  
  public String toString()
  {
    return "TypeConverter<E extends Enum<E>>";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.TypeConverterBindingProcessor.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */