package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

class AbstractService$5
  extends Monitor.Guard
{
  AbstractService$5(AbstractService paramAbstractService, Monitor x0)
  {
    super(x0);
  }
  
  public boolean isSatisfied()
  {
    return this$0.state() == Service.State.NEW;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */