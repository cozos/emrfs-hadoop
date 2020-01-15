package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

class Futures$1$1
  implements Runnable
{
  Futures$1$1(Futures.1 param1, AtomicBoolean paramAtomicBoolean) {}
  
  public void run()
  {
    val$thrownFromDelegate.set(false);
    this$0.val$delegateTask.run();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */