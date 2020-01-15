package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;

public abstract interface TypeListener
{
  public abstract <I> void hear(TypeLiteral<I> paramTypeLiteral, TypeEncounter<I> paramTypeEncounter);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListener
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */