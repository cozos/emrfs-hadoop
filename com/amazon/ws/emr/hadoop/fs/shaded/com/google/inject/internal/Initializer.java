package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

final class Initializer
{
  private final Thread creatingThread;
  private final CountDownLatch ready;
  private final Map<Object, InjectableReference<?>> pendingInjection;
  
  Initializer()
  {
    creatingThread = Thread.currentThread();
    
    ready = new CountDownLatch(1);
    
    pendingInjection = .Maps.newIdentityHashMap();
  }
  
  <T> Initializable<T> requestInjection(InjectorImpl injector, T instance, Object source, Set<InjectionPoint> injectionPoints)
  {
    .Preconditions.checkNotNull(source);
    if ((instance == null) || ((injectionPoints.isEmpty()) && (!membersInjectorStore.hasTypeListeners()))) {
      return Initializables.of(instance);
    }
    InjectableReference<T> initializable = new InjectableReference(injector, instance, source);
    pendingInjection.put(instance, initializable);
    return initializable;
  }
  
  void validateOustandingInjections(Errors errors)
  {
    for (InjectableReference<?> reference : pendingInjection.values()) {
      try
      {
        reference.validate(errors);
      }
      catch (ErrorsException e)
      {
        errors.merge(e.getErrors());
      }
    }
  }
  
  void injectAll(Errors errors)
  {
    for (InjectableReference<?> reference : .Lists.newArrayList(pendingInjection.values())) {
      try
      {
        reference.get(errors);
      }
      catch (ErrorsException e)
      {
        errors.merge(e.getErrors());
      }
    }
    if (!pendingInjection.isEmpty()) {
      throw new AssertionError("Failed to satisfy " + pendingInjection);
    }
    ready.countDown();
  }
  
  private class InjectableReference<T>
    implements Initializable<T>
  {
    private final InjectorImpl injector;
    private final T instance;
    private final Object source;
    private MembersInjectorImpl<T> membersInjector;
    
    public InjectableReference(T injector, Object instance)
    {
      this.injector = injector;
      this.instance = .Preconditions.checkNotNull(instance, "instance");
      this.source = .Preconditions.checkNotNull(source, "source");
    }
    
    public void validate(Errors errors)
      throws ErrorsException
    {
      TypeLiteral<T> type = TypeLiteral.get(instance.getClass());
      membersInjector = injector.membersInjectorStore.get(type, errors.withSource(source));
    }
    
    public T get(Errors errors)
      throws ErrorsException
    {
      if (ready.getCount() == 0L) {
        return (T)instance;
      }
      if (Thread.currentThread() != creatingThread) {
        try
        {
          ready.await();
          return (T)instance;
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }
      if (pendingInjection.remove(instance) != null) {
        membersInjector.injectAndNotify(instance, errors.withSource(source), injector.options.stage == Stage.TOOL);
      }
      return (T)instance;
    }
    
    public String toString()
    {
      return instance.toString();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Initializer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */