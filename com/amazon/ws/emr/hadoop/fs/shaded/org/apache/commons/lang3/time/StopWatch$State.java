package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

 enum StopWatch$State
{
  UNSTARTED,  RUNNING,  STOPPED,  SUSPENDED;
  
  private StopWatch$State() {}
  
  abstract boolean isStarted();
  
  abstract boolean isStopped();
  
  abstract boolean isSuspended();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.StopWatch.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */