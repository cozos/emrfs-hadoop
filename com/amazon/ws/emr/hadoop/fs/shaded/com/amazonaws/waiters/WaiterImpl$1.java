package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import java.util.concurrent.Callable;

class WaiterImpl$1
  implements Callable<Void>
{
  WaiterImpl$1(WaiterImpl this$0, WaiterParameters paramWaiterParameters, WaiterHandler paramWaiterHandler) {}
  
  public Void call()
    throws Exception
  {
    try
    {
      this$0.run(val$waiterParameters);
      val$callback.onWaitSuccess(val$waiterParameters.getRequest());
    }
    catch (Exception ex)
    {
      val$callback.onWaitFailure(ex);
      
      throw ex;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterImpl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */