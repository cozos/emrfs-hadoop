package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

public final class PauseResult<T>
{
  private final PauseStatus pauseStatus;
  private final T infoToResume;
  
  public PauseResult(PauseStatus pauseStatus, T infoToResume)
  {
    if (pauseStatus == null) {
      throw new IllegalArgumentException();
    }
    this.pauseStatus = pauseStatus;
    this.infoToResume = infoToResume;
  }
  
  public PauseResult(PauseStatus pauseStatus)
  {
    this(pauseStatus, null);
  }
  
  public PauseStatus getPauseStatus()
  {
    return pauseStatus;
  }
  
  public T getInfoToResume()
  {
    return (T)infoToResume;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PauseResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */