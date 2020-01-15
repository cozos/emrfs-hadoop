package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

final class ServiceManager$NoOpService
  extends AbstractService
{
  protected void doStart()
  {
    notifyStarted();
  }
  
  protected void doStop()
  {
    notifyStopped();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ServiceManager.NoOpService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */