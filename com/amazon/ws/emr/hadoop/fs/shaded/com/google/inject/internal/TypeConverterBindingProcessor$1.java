package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;

class TypeConverterBindingProcessor$1
  implements TypeConverter
{
  TypeConverterBindingProcessor$1(TypeConverterBindingProcessor paramTypeConverterBindingProcessor) {}
  
  public Object convert(String value, TypeLiteral<?> toType)
  {
    value = value.trim();
    if (value.length() != 1) {
      throw new RuntimeException("Length != 1.");
    }
    return Character.valueOf(value.charAt(0));
  }
  
  public String toString()
  {
    return "TypeConverter<Character>";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.TypeConverterBindingProcessor.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */