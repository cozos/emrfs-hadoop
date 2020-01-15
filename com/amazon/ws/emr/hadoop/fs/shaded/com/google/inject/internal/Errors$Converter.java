package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

abstract class Errors$Converter<T>
{
  final Class<T> type;
  
  Errors$Converter(Class<T> type)
  {
    this.type = type;
  }
  
  boolean appliesTo(Object o)
  {
    return (o != null) && (type.isAssignableFrom(o.getClass()));
  }
  
  String convert(Object o)
  {
    return toString(type.cast(o));
  }
  
  abstract String toString(T paramT);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors.Converter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */