package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.AbstractMatcher;

class TypeConverterBindingProcessor$3
  extends AbstractMatcher<TypeLiteral<?>>
{
  TypeConverterBindingProcessor$3(TypeConverterBindingProcessor paramTypeConverterBindingProcessor) {}
  
  public boolean matches(TypeLiteral<?> typeLiteral)
  {
    return typeLiteral.getRawType() == Class.class;
  }
  
  public String toString()
  {
    return "Class<?>";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.TypeConverterBindingProcessor.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */