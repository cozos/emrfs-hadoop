package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

class AbstractService$7
  extends Monitor.Guard
{
  AbstractService$7(AbstractService paramAbstractService, Monitor x0)
  {
    super(x0);
  }
  
  public boolean isSatisfied()
  {
    return this$0.state().compareTo(Service.State.RUNNING) >= 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */