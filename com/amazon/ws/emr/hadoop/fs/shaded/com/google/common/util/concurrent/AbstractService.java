package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;

@Beta
public abstract class AbstractService
  implements Service
{
  private static final ListenerCallQueue.Callback<Service.Listener> STARTING_CALLBACK = new ListenerCallQueue.Callback("starting()")
  {
    void call(Service.Listener listener)
    {
      listener.starting();
    }
  };
  private static final ListenerCallQueue.Callback<Service.Listener> RUNNING_CALLBACK = new ListenerCallQueue.Callback("running()")
  {
    void call(Service.Listener listener)
    {
      listener.running();
    }
  };
  private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_STARTING_CALLBACK = stoppingCallback(Service.State.STARTING);
  private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_RUNNING_CALLBACK = stoppingCallback(Service.State.RUNNING);
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_NEW_CALLBACK = terminatedCallback(Service.State.NEW);
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_RUNNING_CALLBACK = terminatedCallback(Service.State.RUNNING);
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_STOPPING_CALLBACK = terminatedCallback(Service.State.STOPPING);
  
  private static ListenerCallQueue.Callback<Service.Listener> terminatedCallback(final Service.State from)
  {
    String str = String.valueOf(String.valueOf(from));new ListenerCallQueue.Callback(21 + str.length() + "terminated({from = " + str + "})")
    {
      void call(Service.Listener listener)
      {
        listener.terminated(from);
      }
    };
  }
  
  private static ListenerCallQueue.Callback<Service.Listener> stoppingCallback(final Service.State from)
  {
    String str = String.valueOf(String.valueOf(from));new ListenerCallQueue.Callback(19 + str.length() + "stopping({from = " + str + "})")
    {
      void call(Service.Listener listener)
      {
        listener.stopping(from);
      }
    };
  }
  
  private final Monitor monitor = new Monitor();
  private final Monitor.Guard isStartable = new Monitor.Guard(monitor)
  {
    public boolean isSatisfied()
    {
      return state() == Service.State.NEW;
    }
  };
  private final Monitor.Guard isStoppable = new Monitor.Guard(monitor)
  {
    public boolean isSatisfied()
    {
      return state().compareTo(Service.State.RUNNING) <= 0;
    }
  };
  private final Monitor.Guard hasReachedRunning = new Monitor.Guard(monitor)
  {
    public boolean isSatisfied()
    {
      return state().compareTo(Service.State.RUNNING) >= 0;
    }
  };
  private final Monitor.Guard isStopped = new Monitor.Guard(monitor)
  {
    public boolean isSatisfied()
    {
      return state().isTerminal();
    }
  };
  @GuardedBy("monitor")
  private final List<ListenerCallQueue<Service.Listener>> listeners = Collections.synchronizedList(new ArrayList());
  @GuardedBy("monitor")
  private volatile StateSnapshot snapshot = new StateSnapshot(Service.State.NEW);
  
  protected abstract void doStart();
  
  protected abstract void doStop();
  
  public final Service startAsync()
  {
    if (monitor.enterIf(isStartable))
    {
      try
      {
        snapshot = new StateSnapshot(Service.State.STARTING);
        starting();
        doStart();
      }
      catch (Throwable startupFailure)
      {
        notifyFailed(startupFailure);
      }
      finally
      {
        monitor.leave();
        executeListeners();
      }
    }
    else
    {
      startupFailure = String.valueOf(String.valueOf(this));throw new IllegalStateException(33 + startupFailure.length() + "Service " + startupFailure + " has already been started");
    }
    return this;
  }
  
  public final Service stopAsync()
  {
    if (monitor.enterIf(isStoppable)) {
      try
      {
        Service.State previous = state();
        switch (previous)
        {
        case NEW: 
          snapshot = new StateSnapshot(Service.State.TERMINATED);
          terminated(Service.State.NEW);
          break;
        case STARTING: 
          snapshot = new StateSnapshot(Service.State.STARTING, true, null);
          stopping(Service.State.STARTING);
          break;
        case RUNNING: 
          snapshot = new StateSnapshot(Service.State.STOPPING);
          stopping(Service.State.RUNNING);
          doStop();
          break;
        case STOPPING: 
        case TERMINATED: 
        case FAILED: 
          String str1 = String.valueOf(String.valueOf(previous));throw new AssertionError(45 + str1.length() + "isStoppable is incorrectly implemented, saw: " + str1);
        default: 
          String str2 = String.valueOf(String.valueOf(previous));throw new AssertionError(18 + str2.length() + "Unexpected state: " + str2);
        }
      }
      catch (Throwable shutdownFailure)
      {
        notifyFailed(shutdownFailure);
      }
      finally
      {
        monitor.leave();
        executeListeners();
      }
    }
    return this;
  }
  
  public final void awaitRunning()
  {
    monitor.enterWhenUninterruptibly(hasReachedRunning);
    try
    {
      checkCurrentState(Service.State.RUNNING);
    }
    finally
    {
      monitor.leave();
    }
  }
  
  public final void awaitRunning(long timeout, TimeUnit unit)
    throws TimeoutException
  {
    if (monitor.enterWhenUninterruptibly(hasReachedRunning, timeout, unit))
    {
      try
      {
        checkCurrentState(Service.State.RUNNING);
      }
      finally
      {
        monitor.leave();
      }
    }
    else
    {
      String str1 = String.valueOf(String.valueOf(this));String str2 = String.valueOf(String.valueOf(state()));throw new TimeoutException(66 + str1.length() + str2.length() + "Timed out waiting for " + str1 + " to reach the RUNNING state. " + "Current state: " + str2);
    }
  }
  
  public final void awaitTerminated()
  {
    monitor.enterWhenUninterruptibly(isStopped);
    try
    {
      checkCurrentState(Service.State.TERMINATED);
    }
    finally
    {
      monitor.leave();
    }
  }
  
  public final void awaitTerminated(long timeout, TimeUnit unit)
    throws TimeoutException
  {
    if (monitor.enterWhenUninterruptibly(isStopped, timeout, unit))
    {
      try
      {
        checkCurrentState(Service.State.TERMINATED);
      }
      finally
      {
        monitor.leave();
      }
    }
    else
    {
      String str1 = String.valueOf(String.valueOf(this));String str2 = String.valueOf(String.valueOf(state()));throw new TimeoutException(65 + str1.length() + str2.length() + "Timed out waiting for " + str1 + " to reach a terminal state. " + "Current state: " + str2);
    }
  }
  
  @GuardedBy("monitor")
  private void checkCurrentState(Service.State expected)
  {
    Service.State actual = state();
    if (actual != expected)
    {
      if (actual == Service.State.FAILED)
      {
        str1 = String.valueOf(String.valueOf(expected));throw new IllegalStateException(55 + str1.length() + "Expected the service to be " + str1 + ", but the service has FAILED", failureCause());
      }
      String str1 = String.valueOf(String.valueOf(expected));String str2 = String.valueOf(String.valueOf(actual));throw new IllegalStateException(37 + str1.length() + str2.length() + "Expected the service to be " + str1 + ", but was " + str2);
    }
  }
  
  protected final void notifyStarted()
  {
    monitor.enter();
    try
    {
      if (snapshot.state != Service.State.STARTING)
      {
        String str = String.valueOf(String.valueOf(snapshot.state));IllegalStateException failure = new IllegalStateException(43 + str.length() + "Cannot notifyStarted() when the service is " + str);
        
        notifyFailed(failure);
        throw failure;
      }
      if (snapshot.shutdownWhenStartupFinishes)
      {
        snapshot = new StateSnapshot(Service.State.STOPPING);
        
        doStop();
      }
      else
      {
        snapshot = new StateSnapshot(Service.State.RUNNING);
        running();
      }
    }
    finally
    {
      monitor.leave();
      executeListeners();
    }
  }
  
  protected final void notifyStopped()
  {
    monitor.enter();
    try
    {
      Service.State previous = snapshot.state;
      if ((previous != Service.State.STOPPING) && (previous != Service.State.RUNNING))
      {
        String str = String.valueOf(String.valueOf(previous));IllegalStateException failure = new IllegalStateException(43 + str.length() + "Cannot notifyStopped() when the service is " + str);
        
        notifyFailed(failure);
        throw failure;
      }
      snapshot = new StateSnapshot(Service.State.TERMINATED);
      terminated(previous);
    }
    finally
    {
      monitor.leave();
      executeListeners();
    }
  }
  
  protected final void notifyFailed(Throwable cause)
  {
    Preconditions.checkNotNull(cause);
    
    monitor.enter();
    try
    {
      Service.State previous = state();
      switch (previous)
      {
      case NEW: 
      case TERMINATED: 
        String str1 = String.valueOf(String.valueOf(previous));throw new IllegalStateException(22 + str1.length() + "Failed while in state:" + str1, cause);
      case STARTING: 
      case RUNNING: 
      case STOPPING: 
        snapshot = new StateSnapshot(Service.State.FAILED, false, cause);
        failed(previous, cause);
        break;
      case FAILED: 
        break;
      default: 
        String str2 = String.valueOf(String.valueOf(previous));throw new AssertionError(18 + str2.length() + "Unexpected state: " + str2);
      }
    }
    finally
    {
      monitor.leave();
      executeListeners();
    }
  }
  
  public final boolean isRunning()
  {
    return state() == Service.State.RUNNING;
  }
  
  public final Service.State state()
  {
    return snapshot.externalState();
  }
  
  public final Throwable failureCause()
  {
    return snapshot.failureCause();
  }
  
  public final void addListener(Service.Listener listener, Executor executor)
  {
    Preconditions.checkNotNull(listener, "listener");
    Preconditions.checkNotNull(executor, "executor");
    monitor.enter();
    try
    {
      if (!state().isTerminal()) {
        listeners.add(new ListenerCallQueue(listener, executor));
      }
    }
    finally
    {
      monitor.leave();
    }
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(getClass().getSimpleName()));String str2 = String.valueOf(String.valueOf(state()));return 3 + str1.length() + str2.length() + str1 + " [" + str2 + "]";
  }
  
  private void executeListeners()
  {
    if (!monitor.isOccupiedByCurrentThread()) {
      for (int i = 0; i < listeners.size(); i++) {
        ((ListenerCallQueue)listeners.get(i)).execute();
      }
    }
  }
  
  @GuardedBy("monitor")
  private void starting()
  {
    STARTING_CALLBACK.enqueueOn(listeners);
  }
  
  @GuardedBy("monitor")
  private void running()
  {
    RUNNING_CALLBACK.enqueueOn(listeners);
  }
  
  @GuardedBy("monitor")
  private void stopping(Service.State from)
  {
    if (from == Service.State.STARTING) {
      STOPPING_FROM_STARTING_CALLBACK.enqueueOn(listeners);
    } else if (from == Service.State.RUNNING) {
      STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(listeners);
    } else {
      throw new AssertionError();
    }
  }
  
  @GuardedBy("monitor")
  private void terminated(Service.State from)
  {
    switch (from)
    {
    case NEW: 
      TERMINATED_FROM_NEW_CALLBACK.enqueueOn(listeners);
      break;
    case RUNNING: 
      TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(listeners);
      break;
    case STOPPING: 
      TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(listeners);
      break;
    case STARTING: 
    case TERMINATED: 
    case FAILED: 
    default: 
      throw new AssertionError();
    }
  }
  
  @GuardedBy("monitor")
  private void failed(final Service.State from, final Throwable cause)
  {
    String str1 = String.valueOf(String.valueOf(from));String str2 = String.valueOf(String.valueOf(cause));new ListenerCallQueue.Callback(27 + str1.length() + str2.length() + "failed({from = " + str1 + ", cause = " + str2 + "})")
    {
      void call(Service.Listener listener)
      {
        listener.failed(from, cause);
      }
    }.enqueueOn(listeners);
  }
  
  @Immutable
  private static final class StateSnapshot
  {
    final Service.State state;
    final boolean shutdownWhenStartupFinishes;
    @Nullable
    final Throwable failure;
    
    StateSnapshot(Service.State internalState)
    {
      this(internalState, false, null);
    }
    
    StateSnapshot(Service.State internalState, boolean shutdownWhenStartupFinishes, @Nullable Throwable failure)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */