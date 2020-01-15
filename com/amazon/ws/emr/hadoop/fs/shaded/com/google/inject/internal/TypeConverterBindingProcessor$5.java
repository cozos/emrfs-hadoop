package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TypeConverterBindingProcessor$5
  implements TypeConverter
{
  TypeConverterBindingProcessor$5(TypeConverterBindingProcessor paramTypeConverterBindingProcessor, Method paramMethod, Class paramClass) {}
  
  public Object convert(String value, TypeLiteral<?> toType)
  {
    try
    {
      return val$parser.invoke(null, new Object[] { value });
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
    catch (InvocationTargetException e)
    {
      throw new RuntimeException(e.getTargetException().getMessage());
    }
  }
  
  public String toString()
  {
    return "TypeConverter<" + val$wrapperType.getSimpleName() + ">";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.TypeConverterBindingProcessor.5
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */