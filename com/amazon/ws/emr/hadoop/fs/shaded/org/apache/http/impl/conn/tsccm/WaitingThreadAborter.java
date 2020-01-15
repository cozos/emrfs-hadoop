package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm;

@Deprecated
public class WaitingThreadAborter
{
  private WaitingThread waitingThread;
  private boolean aborted;
  
  public void abort()
  {
    aborted = true;
    if (waitingThread != null) {
      waitingThread.interrupt();
    }
  }
  
  public void setWaitingThread(WaitingThread waitingThread)
  {
    this.waitingThread = waitingThread;
    if (aborted) {
      waitingThread.interrupt();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.tsccm.WaitingThreadAborter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */