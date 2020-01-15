package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class MultiBackgroundInitializer$MultiBackgroundInitializerResults
{
  private final Map<String, BackgroundInitializer<?>> initializers;
  private final Map<String, Object> resultObjects;
  private final Map<String, ConcurrentException> exceptions;
  
  private MultiBackgroundInitializer$MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> inits, Map<String, Object> results, Map<String, ConcurrentException> excepts)
  {
    initializers = inits;
    resultObjects = results;
    exceptions = excepts;
  }
  
  public BackgroundInitializer<?> getInitializer(String name)
  {
    return checkName(name);
  }
  
  public Object getResultObject(String name)
  {
    checkName(name);
    return resultObjects.get(name);
  }
  
  public boolean isException(String name)
  {
    checkName(name);
    return exceptions.containsKey(name);
  }
  
  public ConcurrentException getException(String name)
  {
    checkName(name);
    return (ConcurrentException)exceptions.get(name);
  }
  
  public Set<String> initializerNames()
  {
    return Collections.unmodifiableSet(initializers.keySet());
  }
  
  public boolean isSuccessful()
  {
    return exceptions.isEmpty();
  }
  
  private BackgroundInitializer<?> checkName(String name)
  {
    BackgroundInitializer<?> init = (BackgroundInitializer)initializers.get(name);
    if (init == null) {
      throw new NoSuchElementException("No child initializer with name " + name);
    }
    return init;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */