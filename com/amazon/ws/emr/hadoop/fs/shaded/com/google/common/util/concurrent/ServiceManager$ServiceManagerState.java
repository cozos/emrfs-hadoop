package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Stopwatch;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultimap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSetMultimap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSetMultimap.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multiset;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Ordering;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SetMultimap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

final class ServiceManager$ServiceManagerState
{
  final Monitor monitor = new Monitor();
  @GuardedBy("monitor")
  final SetMultimap<Service.State, Service> servicesByState = Multimaps.newSetMultimap(new EnumMap(Service.State.class), new Supplier()
  {
    public Set<Service> get()
    {
      return Sets.newLinkedHashSet();
    }
  });
  @GuardedBy("monitor")
  final Multiset<Service.State> states = servicesByState.keys();
  @GuardedBy("monitor")
  final Map<Service, Stopwatch> startupTimers = Maps.newIdentityHashMap();
  @GuardedBy("monitor")
  boolean ready;
  @GuardedBy("monitor")
  boolean transitioned;
  final int numberOfServices;
  final Monitor.Guard awaitHealthGuard = new Monitor.Guard(monitor)
  {
    public boolean isSatisfied()
    {
      return (states.count(Service.State.RUNNING) == numberOfServices) || (states.contains(Service.State.STOPPING)) || (states.contains(Service.State.TERMINATED)) || (states.contains(Service.State.FAILED));
    }
  };
  final Monitor.Guard stoppedGuard = new Monitor.Guard(monitor)
  {
    public boolean isSatisfied()
    {
      return states.count(Service.State.TERMINATED) + states.count(Service.State.FAILED) == numberOfServices;
    }
  };
  @GuardedBy("monitor")
  final List<ListenerCallQueue<ServiceManager.Listener>> listeners = Collections.synchronizedList(new ArrayList());
  
  ServiceManager$ServiceManagerState(ImmutableCollection<Service> services)
  {
    numberOfServices = services.size();
    servicesByState.putAll(Service.State.NEW, services);
  }
  
  void tryStartTiming(Service service)
  {
    monitor.enter();
    try
    {
      Stopwatch stopwatch = (Stopwatch)startupTimers.get(service);
      if (stopwatch == null) {
        startupTimers.put(service, Stopwatch.createStarted());
      }
    }
    finally
    {
      monitor.leave();
    }
  }
  
  void markReady()
  {
    monitor.enter();
    try
    {
      if (!transitioned)
      {
        ready = true;
      }
      else
      {
        List<Service> servicesInBadStates = Lists.newArrayList();
        for (Iterator i$ = servicesByState().values().iterator(); i$.hasNext();)
        {
          service = (Service)i$.next();
          if (service.state() != Service.State.NEW) {
            servicesInBadStates.add(service);
          }
        }
        i$ = String.valueOf(String.valueOf("Services started transitioning asynchronously before the ServiceManager was constructed: "));Service service = String.valueOf(String.valueOf(servicesInBadStates));throw new IllegalArgumentException(0 + i$.length() + service.length() + i$ + service);
      }
    }
    finally
    {
      monitor.leave();
    }
  }
  
  void addListener(ServiceManager.Listener listener, Executor executor)
  {
    Preconditions.checkNotNull(listener, "listener");
    Preconditions.checkNotNull(executor, "executor");
    monitor.enter();
    try
    {
      if (!stoppedGuard.isSatisfied()) {
        listeners.add(new ListenerCallQueue(listener, executor));
      }
    }
    finally
    {
      monitor.leave();
    }
  }
  
  void awaitHealthy()
  {
    monitor.enterWhenUninterruptibly(awaitHealthGuard);
    try
    {
      checkHealthy();
    }
    finally
    {
      monitor.leave();
    }
  }
  
  void awaitHealthy(long timeout, TimeUnit unit)
    throws TimeoutException
  {
    monitor.enter();
    try
    {
      if (!monitor.waitForUninterruptibly(awaitHealthGuard, timeout, unit))
      {
        String str1 = String.valueOf(String.valueOf("Timeout waiting for the services to become healthy. The following services have not started: "));String str2 = String.valueOf(String.valueOf(Multimaps.filterKeys(servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING)))));throw new TimeoutException(0 + str1.length() + str2.length() + str1 + str2);
      }
      checkHealthy();
    }
    finally
    {
      monitor.leave();
    }
  }
  
  void awaitStopped()
  {
    monitor.enterWhenUninterruptibly(stoppedGuard);
    monitor.leave();
  }
  
  void awaitStopped(long timeout, TimeUnit unit)
    throws TimeoutException
  {
    monitor.enter();
    try
    {
      if (!monitor.waitForUninterruptibly(stoppedGuard, timeout, unit))
      {
        String str1 = String.valueOf(String.valueOf("Timeout waiting for the services to stop. The following services have not stopped: "));String str2 = String.valueOf(String.valueOf(Multimaps.filterKeys(servicesByState, Predicates.not(Predicates.in(ImmutableSet.of(Service.State.TERMINATED, Service.State.FAILED))))));throw new TimeoutException(0 + str1.length() + str2.length() + str1 + str2);
      }
    }
    finally
    {
      monitor.leave();
    }
  }
  
  ImmutableMultimap<Service.State, Service> servicesByState()
  {
    ImmutableSetMultimap.Builder<Service.State, Service> builder = ImmutableSetMultimap.builder();
    monitor.enter();
    try
    {
      for (Map.Entry<Service.State, Service> entry : servicesByState.entries()) {
        if (!(entry.getValue() instanceof ServiceManager.NoOpService)) {
          builder.put(entry.getKey(), entry.getValue());
        }
      }
    }
    finally
    {
      monitor.leave();
    }
    return builder.build();
  }
  
  ImmutableMap<Service, Long> startupTimes()
  {
    monitor.enter();
    List<Map.Entry<Service, Long>> loadTimes;
    try
    {
      loadTimes = Lists.newArrayListWithCapacity(startupTimers.size());
      for (Map.Entry<Service, Stopwatch> entry : startupTimers.entrySet())
      {
        Service service = (Service)entry.getKey();
        Stopwatch stopWatch = (Stopwatch)entry.getValue();
        if ((!stopWatch.isRunning()) && (!(service instanceof ServiceManager.NoOpService))) {
          loadTimes.add(Maps.immutableEntry(service, Long.valueOf(stopWatch.elapsed(TimeUnit.MILLISECONDS))));
        }
      }
    }
    finally
    {
      monitor.leave();
    }
    Collections.sort(loadTimes, Ordering.natural().onResultOf(new Function()
    {
      public Long apply(Map.Entry<Service, Long> input)
      {
        return (Long)input.getValue();
      }
    }));
    ImmutableMap.Builder<Service, Long> builder = ImmutableMap.builder();
    for (Map.Entry<Service, Long> entry : loadTimes) {
      builder.put(entry);
    }
    return builder.build();
  }
  
  void transitionService(Service service, Service.State from, Service.State to)
  {
    Preconditions.checkNotNull(service);
    Preconditions.checkArgument(from != to);
    monitor.enter();
    try
    {
      transitioned = true;
      if (!ready) {
        return;
      }
      Preconditions.checkState(servicesByState.remove(from, service), "Service %s not at the expected location in the state map %s", new Object[] { service, from });
      
      Preconditions.checkState(servicesByState.put(to, service), "Service %s in the state map unexpectedly at %s", new Object[] { service, to });
      
      Stopwatch stopwatch = (Stopwatch)startupTimers.get(service);
      if (stopwatch == null)
      {
        stopwatch = Stopwatch.createStarted();
        startupTimers.put(service, stopwatch);
      }
      if ((to.compareTo(Service.State.RUNNING) >= 0) && (stopwatch.isRunning()))
      {
        stopwatch.stop();
        if (!(service instanceof ServiceManager.NoOpService)) {
          ServiceManager.access$200().log(Level.FINE, "Started {0} in {1}.", new Object[] { service, stopwatch });
        }
      }
      if (to == Service.State.FAILED) {
        fireFailedListeners(service);
      }
      if (states.count(Service.State.RUNNING) == numberOfServices) {
        fireHealthyListeners();
      } else if (states.count(Service.State.TERMINATED) + states.count(Service.State.FAILED) == numberOfServices) {
        fireStoppedListeners();
      }
    }
    finally
    {
      monitor.leave();
      
      executeListeners();
    }
  }
  
  @GuardedBy("monitor")
  void fireStoppedListeners()
  {
    ServiceManager.access$300().enqueueOn(listeners);
  }
  
  @GuardedBy("monitor")
  void fireHealthyListeners()
  {
    ServiceManager.access$400().enqueueOn(listeners);
  }
  
  @GuardedBy("monitor")
  void fireFailedListeners(final Service service)
  {
    String str = String.valueOf(String.valueOf(service));new ListenerCallQueue.Callback(18 + str.length() + "failed({service=" + str + "})")
    {
      void call(ServiceManager.Listener listener)
      {
        listener.failure(service);
      }
    }.enqueueOn(listeners);
  }
  
  void executeListeners()
  {
    Preconditions.checkState(!monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
    for (int i = 0; i < listeners.size(); i++) {
      ((ListenerCallQueue)listeners.get(i)).execute();
    }
  }
  
  @GuardedBy("monitor")
  void checkHealthy()
  {
    if (states.count(Service.State.RUNNING) != numberOfServices)
    {
      String str = String.valueOf(String.valueOf(Multimaps.filterKeys(servicesByState, Predicates.not(Predicates.equalTo(Service.State.RUNNING)))));IllegalStateException exception = new IllegalStateException(79 + str.length() + "Expected to be healthy after starting. The following services are not running: " + str);
      
      throw exception;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ServiceManager.ServiceManagerState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */