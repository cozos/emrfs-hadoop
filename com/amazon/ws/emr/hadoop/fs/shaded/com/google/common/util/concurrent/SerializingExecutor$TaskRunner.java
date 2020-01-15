package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

class SerializingExecutor$TaskRunner
  implements Runnable
{
  private SerializingExecutor$TaskRunner(SerializingExecutor paramSerializingExecutor) {}
  
  public void run()
  {
    boolean stillRunning = true;
    try
    {
      for (;;)
      {
        Preconditions.checkState(SerializingExecutor.access$100(this$0));
        Runnable nextToRun;
        synchronized (SerializingExecutor.access$200(this$0))
        {
          nextToRun = (Runnable)SerializingExecutor.access$300(this$0).poll();
          if (nextToRun == null)
          {
            SerializingExecutor.access$102(this$0, false);
            stillRunning = false;
            break;
          }
        }
        try
        {
          nextToRun.run();
        }
        catch (RuntimeException e)
        {
          String str = String.valueOf(String.valueOf(nextToRun));SerializingExecutor.access$400().log(Level.SEVERE, 35 + str.length() + "Exception while executing runnable " + str, e);
        }
      }
    }
    finally
    {
      if (stillRunning) {
        synchronized (SerializingExecutor.access$200(this$0))
        {
          SerializingExecutor.access$102(this$0, false);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.SerializingExecutor.TaskRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */