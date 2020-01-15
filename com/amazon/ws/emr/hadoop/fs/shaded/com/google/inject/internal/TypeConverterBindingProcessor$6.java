package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.AbstractMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import java.lang.reflect.Type;

class TypeConverterBindingProcessor$6
  extends AbstractMatcher<TypeLiteral<?>>
{
  TypeConverterBindingProcessor$6(TypeConverterBindingProcessor paramTypeConverterBindingProcessor, Matcher paramMatcher) {}
  
  public boolean matches(TypeLiteral<?> typeLiteral)
  {
    Type type = typeLiteral.getType();
    if (!(type instanceof Class)) {
      return false;
    }
    Class<?> clazz = (Class)type;
    return val$typeMatcher.matches(clazz);
  }
  
  public String toString()
  {
    return val$typeMatcher.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.TypeConverterBindingProcessor.6
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */