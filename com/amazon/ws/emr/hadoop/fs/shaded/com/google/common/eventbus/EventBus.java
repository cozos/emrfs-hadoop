package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LoadingCache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashMultimap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SetMultimap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class EventBus
{
  private static final LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader()
  {
    public Set<Class<?>> load(Class<?> concreteClass)
    {
      return TypeToken.of(concreteClass).getTypes().rawTypes();
    }
  });
  private final SetMultimap<Class<?>, EventSubscriber> subscribersByType = HashMultimap.create();
  private final ReadWriteLock subscribersByTypeLock = new ReentrantReadWriteLock();
  private final SubscriberFindingStrategy finder = new AnnotatedSubscriberFinder();
  private final ThreadLocal<Queue<EventWithSubscriber>> eventsToDispatch = new ThreadLocal()
  {
    protected Queue<EventBus.EventWithSubscriber> initialValue()
    {
      return new LinkedList();
    }
  };
  private final ThreadLocal<Boolean> isDispatching = new ThreadLocal()
  {
    protected Boolean initialValue()
    {
      return Boolean.valueOf(false);
    }
  };
  private SubscriberExceptionHandler subscriberExceptionHandler;
  
  public EventBus()
  {
    this("default");
  }
  
  public EventBus(String identifier)
  {
    this(new LoggingSubscriberExceptionHandler(identifier));
  }
  
  public EventBus(SubscriberExceptionHandler subscriberExceptionHandler)
  {
    this.subscriberExceptionHandler = ((SubscriberExceptionHandler)Preconditions.checkNotNull(subscriberExceptionHandler));
  }
  
  public void register(Object object)
  {
    Multimap<Class<?>, EventSubscriber> methodsInListener = finder.findAllSubscribers(object);
    
    subscribersByTypeLock.writeLock().lock();
    try
    {
      subscribersByType.putAll(methodsInListener);
    }
    finally
    {
      subscribersByTypeLock.writeLock().unlock();
    }
  }
  
  public void unregister(Object object)
  {
    Multimap<Class<?>, EventSubscriber> methodsInListener = finder.findAllSubscribers(object);
    for (Map.Entry<Class<?>, Collection<EventSubscriber>> entry : methodsInListener.asMap().entrySet())
    {
      Class<?> eventType = (Class)entry.getKey();
      Collection<EventSubscriber> eventMethodsInListener = (Collection)entry.getValue();
      
      subscribersByTypeLock.writeLock().lock();
      try
      {
        Set<EventSubscriber> currentSubscribers = subscribersByType.get(eventType);
        if (!currentSubscribers.containsAll(eventMethodsInListener))
        {
          String str = String.valueOf(String.valueOf(object));throw new IllegalArgumentException(65 + str.length() + "missing event subscriber for an annotated method. Is " + str + " registered?");
        }
        currentSubscribers.removeAll(eventMethodsInListener);
      }
      finally
      {
        subscribersByTypeLock.writeLock().unlock();
      }
    }
  }
  
  public void post(Object event)
  {
    Set<Class<?>> dispatchTypes = flattenHierarchy(event.getClass());
    
    boolean dispatched = false;
    for (Class<?> eventType : dispatchTypes)
    {
      subscribersByTypeLock.readLock().lock();
      try
      {
        Set<EventSubscriber> wrappers = subscribersByType.get(eventType);
        if (!wrappers.isEmpty())
        {
          dispatched = true;
          for (EventSubscriber wrapper : wrappers) {
            enqueueEvent(event, wrapper);
          }
        }
      }
      finally
      {
        subscribersByTypeLock.readLock().unlock();
      }
    }
    if ((!dispatched) && (!(event instanceof DeadEvent))) {
      post(new DeadEvent(this, event));
    }
    dispatchQueuedEvents();
  }
  
  void enqueueEvent(Object event, EventSubscriber subscriber)
  {
    ((Queue)eventsToDispatch.get()).offer(new EventWithSubscriber(event, subscriber));
  }
  
  void dispatchQueuedEvents()
  {
    if (((Boolean)isDispatching.get()).booleanValue()) {
      return;
    }
    isDispatching.set(Boolean.valueOf(true));
    try
    {
      Queue<EventWithSubscriber> events = (Queue)eventsToDispatch.get();
      EventWithSubscriber eventWithSubscriber;
      while ((eventWithSubscriber = (EventWithSubscriber)events.poll()) != null) {
        dispatch(event, subscriber);
      }
    }
    finally
    {
      isDispatching.remove();
      eventsToDispatch.remove();
    }
  }
  
  void dispatch(Object event, EventSubscriber wrapper)
  {
    try
    {
      wrapper.handleEvent(event);
    }
    catch (InvocationTargetException e)
    {
      try
      {
        subscriberExceptionHandler.handleException(e.getCause(), new SubscriberExceptionContext(this, event, wrapper.getSubscriber(), wrapper.getMethod()));
      }
      catch (Throwable t)
      {
        Logger.getLogger(EventBus.class.getName()).log(Level.SEVERE, String.format("Exception %s thrown while handling exception: %s", new Object[] { t, e.getCause() }), t);
      }
    }
  }
  
  @VisibleForTesting
  Set<Class<?>> flattenHierarchy(Class<?> concreteClass)
  {
    try
    {
      return (Set)flattenHierarchyCache.getUnchecked(concreteClass);
    }
    catch (UncheckedExecutionException e)
    {
      throw Throwables.propagate(e.getCause());
    }
  }
  
  private static final class LoggingSubscriberExceptionHandler
    implements SubscriberExceptionHandler
  {
    private final Logger logger;
    
    public LoggingSubscriberExceptionHandler(String identifier)
    {
      String str1 = String.valueOf(String.valueOf(EventBus.class.getName()));String str2 = String.valueOf(String.valueOf((String)Preconditions.checkNotNull(identifier)));logger = Logger.getLogger(1 + str1.length() + str2.length() + str1 + "." + str2);
    }
    
    public void handleException(Throwable exception, SubscriberExceptionContext context)
    {
      String str1 = String.valueOf(String.valueOf(context.getSubscriber()));String str2 = String.valueOf(String.valueOf(context.getSubscriberMethod()));logger.log(Level.SEVERE, 30 + str1.length() + str2.length() + "Could not dispatch event: " + str1 + " to " + str2, exception.getCause());
    }
  }
  
  static class EventWithSubscriber
  {
    final Object event;
    final EventSubscriber subscriber;
    
    public EventWithSubscriber(Object event, EventSubscriber subscriber)
    {
      this.event = Preconditions.checkNotNull(event);
      this.subscriber = ((EventSubscriber)Preconditions.checkNotNull(subscriber));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.EventBus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */