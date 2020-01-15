package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..ClassReader;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class $AbstractClassGenerator
  implements .ClassGenerator
{
  private static final Object NAME_KEY = new Object();
  private static final ThreadLocal CURRENT = new ThreadLocal();
  private .GeneratorStrategy strategy = .DefaultGeneratorStrategy.INSTANCE;
  private .NamingPolicy namingPolicy = .DefaultNamingPolicy.INSTANCE;
  private Source source;
  private ClassLoader classLoader;
  private String namePrefix;
  private Object key;
  private boolean useCache = true;
  private String className;
  private boolean attemptLoad;
  
  protected static class Source
  {
    String name;
    Map cache = new WeakHashMap();
    
    public Source(String name)
    {
      this.name = name;
    }
  }
  
  protected $AbstractClassGenerator(Source source)
  {
    this.source = source;
  }
  
  protected void setNamePrefix(String namePrefix)
  {
    this.namePrefix = namePrefix;
  }
  
  protected final String getClassName()
  {
    if (className == null) {
      className = getClassName(getClassLoader());
    }
    return className;
  }
  
  private String getClassName(ClassLoader loader)
  {
    Set nameCache = getClassNameCache(loader);
    namingPolicy.getClassName(namePrefix, source.name, key, new .Predicate()
    {
      private final Set val$nameCache;
      
      public boolean evaluate(Object arg)
      {
        return val$nameCache.contains(arg);
      }
    });
  }
  
  private Set getClassNameCache(ClassLoader loader)
  {
    return (Set)((Map)source.cache.get(loader)).get(NAME_KEY);
  }
  
  public void setClassLoader(ClassLoader classLoader)
  {
    this.classLoader = classLoader;
  }
  
  public void setNamingPolicy(.NamingPolicy namingPolicy)
  {
    if (namingPolicy == null) {
      namingPolicy = .DefaultNamingPolicy.INSTANCE;
    }
    this.namingPolicy = namingPolicy;
  }
  
  public .NamingPolicy getNamingPolicy()
  {
    return namingPolicy;
  }
  
  public void setUseCache(boolean useCache)
  {
    this.useCache = useCache;
  }
  
  public boolean getUseCache()
  {
    return useCache;
  }
  
  public void setAttemptLoad(boolean attemptLoad)
  {
    this.attemptLoad = attemptLoad;
  }
  
  public boolean getAttemptLoad()
  {
    return attemptLoad;
  }
  
  public void setStrategy(.GeneratorStrategy strategy)
  {
    if (strategy == null) {
      strategy = .DefaultGeneratorStrategy.INSTANCE;
    }
    this.strategy = strategy;
  }
  
  public .GeneratorStrategy getStrategy()
  {
    return strategy;
  }
  
  public static AbstractClassGenerator getCurrent()
  {
    return (AbstractClassGenerator)CURRENT.get();
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader t = classLoader;
    if (t == null) {
      t = getDefaultClassLoader();
    }
    if (t == null) {
      t = getClass().getClassLoader();
    }
    if (t == null) {
      t = Thread.currentThread().getContextClassLoader();
    }
    if (t == null) {
      throw new IllegalStateException("Cannot determine classloader");
    }
    return t;
  }
  
  protected abstract ClassLoader getDefaultClassLoader();
  
  protected Object create(Object key)
  {
    try
    {
      Class gen = null;
      synchronized (source)
      {
        ClassLoader loader = getClassLoader();
        Map cache2 = null;
        cache2 = (Map)source.cache.get(loader);
        if (cache2 == null)
        {
          cache2 = new HashMap();
          cache2.put(NAME_KEY, new HashSet());
          source.cache.put(loader, cache2);
        }
        else if (useCache)
        {
          Reference ref = (Reference)cache2.get(key);
          gen = (Class)(ref == null ? null : ref.get());
        }
        if (gen == null)
        {
          Object save = CURRENT.get();
          CURRENT.set(this);
          try
          {
            this.key = key;
            if (attemptLoad) {
              try
              {
                gen = loader.loadClass(getClassName());
              }
              catch (ClassNotFoundException e) {}
            }
            if (gen == null)
            {
              b = strategy.generate(this);
              String className = .ClassNameReader.getClassName(new .ClassReader(b));
              getClassNameCache(loader).add(className);
              gen = .ReflectUtils.defineClass(className, b, loader);
            }
            if (useCache) {
              cache2.put(key, new WeakReference(gen));
            }
            byte[] b = firstInstance(gen);
            
            CURRENT.set(save);return b;
          }
          finally
          {
            CURRENT.set(save);
          }
        }
      }
      return firstInstance(gen);
    }
    catch (RuntimeException e)
    {
      throw e;
    }
    catch (Error e)
    {
      throw e;
    }
    catch (Exception e)
    {
      throw new .CodeGenerationException(e);
    }
  }
  
  protected abstract Object firstInstance(Class paramClass)
    throws Exception;
  
  protected abstract Object nextInstance(Object paramObject)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..AbstractClassGenerator
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */