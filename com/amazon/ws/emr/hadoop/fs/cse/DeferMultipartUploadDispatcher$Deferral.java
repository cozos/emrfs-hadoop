package com.amazon.ws.emr.hadoop.fs.cse;

import com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.CompleteMultipartUploadEvent;

final class DeferMultipartUploadDispatcher$Deferral
{
  private final State state;
  private final CompleteMultipartUploadEvent event;
  
  public DeferMultipartUploadDispatcher$Deferral(State state, CompleteMultipartUploadEvent event)
  {
    this.state = state;this.event = event;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Deferral)) {
      return false;
    }
    Deferral other = (Deferral)o;Object this$state = getState();Object other$state = other.getState();
    if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
      return false;
    }
    Object this$event = getEvent();Object other$event = other.getEvent();return this$event == null ? other$event == null : this$event.equals(other$event);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $state = getState();result = result * 59 + ($state == null ? 43 : $state.hashCode());Object $event = getEvent();result = result * 59 + ($event == null ? 43 : $event.hashCode());return result;
  }
  
  public String toString()
  {
    return "DeferMultipartUploadDispatcher.Deferral(state=" + getState() + ", event=" + getEvent() + ")";
  }
  
  private static enum State
  {
    INITIALIZED,  PENDING,  RESUMING,  RESUME_FAILED,  RESUMED,  CANCELLED;
    
    private State() {}
  }
  
  public State getState()
  {
    return state;
  }
  
  public CompleteMultipartUploadEvent getEvent()
  {
    return event;
  }
  
  private boolean isInitialized()
  {
    return state == State.INITIALIZED;
  }
  
  private boolean isPending()
  {
    return state == State.PENDING;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.DeferMultipartUploadDispatcher.Deferral
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */