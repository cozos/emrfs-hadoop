package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey;

public abstract interface HandlerContextAware
{
  public abstract <X> void addHandlerContext(HandlerContextKey<X> paramHandlerContextKey, X paramX);
  
  public abstract <X> X getHandlerContext(HandlerContextKey<X> paramHandlerContextKey);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.HandlerContextAware
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */