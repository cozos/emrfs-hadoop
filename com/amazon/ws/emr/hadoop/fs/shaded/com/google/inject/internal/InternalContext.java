package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import java.util.Map;

final class InternalContext
{
  private Map<Object, ConstructionContext<?>> constructionContexts = .Maps.newHashMap();
  private Dependency dependency;
  
  public <T> ConstructionContext<T> getConstructionContext(Object key)
  {
    ConstructionContext<T> constructionContext = (ConstructionContext)constructionContexts.get(key);
    if (constructionContext == null)
    {
      constructionContext = new ConstructionContext();
      constructionContexts.put(key, constructionContext);
    }
    return constructionContext;
  }
  
  public Dependency getDependency()
  {
    return dependency;
  }
  
  public Dependency setDependency(Dependency dependency)
  {
    Dependency previous = this.dependency;
    this.dependency = dependency;
    return previous;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalContext
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */