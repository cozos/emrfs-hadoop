package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;

class TypeConverterBindingProcessor$4
  implements TypeConverter
{
  TypeConverterBindingProcessor$4(TypeConverterBindingProcessor paramTypeConverterBindingProcessor) {}
  
  public Object convert(String value, TypeLiteral<?> toType)
  {
    try
    {
      return Class.forName(value);
    }
    catch (ClassNotFoundException e)
    {
      throw new RuntimeException(e.getMessage());
    }
  }
  
  public String toString()
  {
    return "TypeConverter<Class<?>>";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.TypeConverterBindingProcessor.4
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */