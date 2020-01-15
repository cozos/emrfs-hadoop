package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AbstractService$StateSnapshot
{
  final Service.State state;
  final boolean shutdownWhenStartupFinishes;
  @Nullable
  final Throwable failure;
  
  AbstractService$StateSnapshot(Service.State internalState)
  {
    this(internalState, false, null);
  }
  
  AbstractService$StateSnapshot(Service.State internalState, boolean shutdownWhenStartupFinishes, @Nullable Throwable failure)
  {
    Preconditions.checkArgument((!shutdownWhenStartupFinishes) || (internalState == Service.State.STARTING), "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", new Object[] { internalState });
    
    Preconditions.checkArgument(((failure != null ? 1 : 0) ^ (internalState == Service.State.FAILED ? 1 : 0)) == 0, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", new Object[] { internalState, failure });
    
    state = internalState;
    this.shutdownWhenStartupFinishes = shutdownWhenStartupFinishes;
    this.failure = failure;
  }
  
  Service.State externalState()
  {
    if ((shutdownWhenStartupFinishes) && (state == Service.State.STARTING)) {
      return Service.State.STOPPING;
    }
    return state;
  }
  
  Throwable failureCause()
  {
    Preconditions.checkState(state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", new Object[] { state });
    
    return failure;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractService.StateSnapshot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */