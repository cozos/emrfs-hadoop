package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

public enum PauseStatus
{
  SUCCESS,  NOT_STARTED,  CANCELLED_BEFORE_START,  NO_EFFECT,  CANCELLED;
  
  private PauseStatus() {}
  
  public boolean isPaused()
  {
    return this == SUCCESS;
  }
  
  public boolean isCancelled()
  {
    return (this == CANCELLED) || (this == CANCELLED_BEFORE_START);
  }
  
  public boolean unchanged()
  {
    return (this == NOT_STARTED) || (this == NO_EFFECT);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PauseStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */