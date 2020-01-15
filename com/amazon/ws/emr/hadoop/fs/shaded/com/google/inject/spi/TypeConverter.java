package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;

public abstract interface TypeConverter
{
  public abstract Object convert(String paramString, TypeLiteral<?> paramTypeLiteral);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */