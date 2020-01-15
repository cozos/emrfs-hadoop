package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec;

class ShutdownHookProcessDestroyer$ProcessDestroyerImpl
  extends Thread
{
  private boolean shouldDestroy;
  private final ShutdownHookProcessDestroyer this$0;
  
  public ShutdownHookProcessDestroyer$ProcessDestroyerImpl(ShutdownHookProcessDestroyer paramShutdownHookProcessDestroyer)
  {
    super("ProcessDestroyer Shutdown Hook");this$0 = paramShutdownHookProcessDestroyer;shouldDestroy = true;
  }
  
  public void run()
  {
    if (shouldDestroy) {
      this$0.run();
    }
  }
  
  public void setShouldDestroy(boolean shouldDestroy)
  {
    this.shouldDestroy = shouldDestroy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.ShutdownHookProcessDestroyer.ProcessDestroyerImpl
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */