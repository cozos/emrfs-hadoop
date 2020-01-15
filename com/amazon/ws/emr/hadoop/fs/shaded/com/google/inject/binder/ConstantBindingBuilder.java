package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder;

public abstract interface ConstantBindingBuilder
{
  public abstract void to(String paramString);
  
  public abstract void to(int paramInt);
  
  public abstract void to(long paramLong);
  
  public abstract void to(boolean paramBoolean);
  
  public abstract void to(double paramDouble);
  
  public abstract void to(float paramFloat);
  
  public abstract void to(short paramShort);
  
  public abstract void to(char paramChar);
  
  public abstract void to(byte paramByte);
  
  public abstract void to(Class<?> paramClass);
  
  public abstract <E extends Enum<E>> void to(E paramE);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ConstantBindingBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */