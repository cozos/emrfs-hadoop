package com.amazon.ws.emr.hadoop.fs.concurrent;

public abstract class Consumer<T>
{
  public abstract void beforeConsumption();
  
  public abstract void consume(T paramT);
  
  public abstract void afterConsumption();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.concurrent.Consumer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */