package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..DefaultNamingPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..NamingPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Enhancer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClass.Generator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;
import java.util.logging.Logger;

public final class BytecodeGen
{
  static final Logger logger = Logger.getLogger(BytecodeGen.class.getName());
  static final ClassLoader GUICE_CLASS_LOADER = canonicalize(BytecodeGen.class.getClassLoader());
  
  private static class SystemBridgeHolder
  {
    static final BytecodeGen.BridgeClassLoader SYSTEM_BRIDGE = new BytecodeGen.BridgeClassLoader();
  }
  
  static final String GUICE_INTERNAL_PACKAGE = BytecodeGen.class.getName().replaceFirst("\\.internal\\..*$", ".internal");
  static final String CGLIB_PACKAGE = .Enhancer.class.getName().replaceFirst("\\.cglib\\..*$", ".cglib");
  static final .NamingPolicy FASTCLASS_NAMING_POLICY = new .DefaultNamingPolicy()
  {
    protected String getTag()
    {
      return "ByGuice";
    }
    
    public String getClassName(String prefix, String source, Object key, .Predicate names)
    {
      return super.getClassName(prefix, "FastClass", key, names);
    }
  };
  static final .NamingPolicy ENHANCER_NAMING_POLICY = new .DefaultNamingPolicy()
  {
    protected String getTag()
    {
      return "ByGuice";
    }
    
    public String getClassName(String prefix, String source, Object key, .Predicate names)
    {
      return super.getClassName(prefix, "Enhancer", key, names);
    }
  };
  private static final boolean CUSTOM_LOADER_ENABLED = Boolean.parseBoolean(System.getProperty("guice.custom.loader", "true"));
  private static final Map<ClassLoader, ClassLoader> CLASS_LOADER_CACHE;
  
  static
  {
    if (CUSTOM_LOADER_ENABLED) {
      CLASS_LOADER_CACHE = new .MapMaker().weakKeys().weakValues().makeComputingMap(new .Function()
      {
        public ClassLoader apply(@.Nullable final ClassLoader typeClassLoader)
        {
          BytecodeGen.logger.fine("Creating a bridge ClassLoader for " + typeClassLoader);
          (ClassLoader)AccessController.doPrivileged(new PrivilegedAction()
          {
            public ClassLoader run()
            {
              return new BytecodeGen.BridgeClassLoader(typeClassLoader);
            }
          });
        }
      });
    } else {
      CLASS_LOADER_CACHE = .ImmutableMap.of();
    }
  }
  
  private static ClassLoader canonicalize(ClassLoader classLoader)
  {
    return classLoader != null ? classLoader : SystemBridgeHolder.SYSTEM_BRIDGE.getParent();
  }
  
  public static ClassLoader getClassLoader(Class<?> type)
  {
    return getClassLoader(type, type.getClassLoader());
  }
  
  private static ClassLoader getClassLoader(Class<?> type, ClassLoader delegate)
  {
    if (!CUSTOM_LOADER_ENABLED) {
      return delegate;
    }
    if (type.getName().startsWith("java.")) {
      return GUICE_CLASS_LOADER;
    }
    delegate = canonicalize(delegate);
    if ((delegate == GUICE_CLASS_LOADER) || ((delegate instanceof BridgeClassLoader))) {
      return delegate;
    }
    if (Visibility.forType(type) == Visibility.PUBLIC)
    {
      if (delegate != SystemBridgeHolder.SYSTEM_BRIDGE.getParent()) {
        return (ClassLoader)CLASS_LOADER_CACHE.get(delegate);
      }
      return SystemBridgeHolder.SYSTEM_BRIDGE;
    }
    return delegate;
  }
  
  public static .FastClass newFastClass(Class<?> type, Visibility visibility)
  {
    .FastClass.Generator generator = new .FastClass.Generator();
    
    generator.setType(type);
    if (visibility == Visibility.PUBLIC) {
      generator.setClassLoader(getClassLoader(type));
    }
    generator.setNamingPolicy(FASTCLASS_NAMING_POLICY);
    logger.fine("Loading " + type + " FastClass with " + generator.getClassLoader());
    return generator.create();
  }
  
  public static .Enhancer newEnhancer(Class<?> type, Visibility visibility)
  {
    .Enhancer enhancer = new .Enhancer();
    enhancer.setSuperclass(type);
    enhancer.setUseFactory(false);
    if (visibility == Visibility.PUBLIC) {
      enhancer.setClassLoader(getClassLoader(type));
    }
    enhancer.setNamingPolicy(ENHANCER_NAMING_POLICY);
    logger.fine("Loading " + type + " Enhancer with " + enhancer.getClassLoader());
    return enhancer;
  }
  
  public static abstract enum Visibility
  {
    PUBLIC,  SAME_PACKAGE;
    
    private Visibility() {}
    
    public static Visibility forMember(Member member)
    {
      if ((member.getModifiers() & 0x5) == 0) {
        return SAME_PACKAGE;
      }
      Class[] parameterTypes;
      Class[] parameterTypes;
      if ((member instanceof Constructor))
      {
        parameterTypes = ((Constructor)member).getParameterTypes();
      }
      else
      {
        Method method = (Method)member;
        if (forType(method.getReturnType()) == SAME_PACKAGE) {
          return SAME_PACKAGE;
        }
        parameterTypes = method.getParameterTypes();
      }
      for (Class<?> type : parameterTypes) {
        if (forType(type) == SAME_PACKAGE) {
          return SAME_PACKAGE;
        }
      }
      return PUBLIC;
    }
    
    public static Visibility forType(Class<?> type)
    {
      return (type.getModifiers() & 0x5) != 0 ? PUBLIC : SAME_PACKAGE;
    }
    
    public abstract Visibility and(Visibility paramVisibility);
  }
  
  private static class BridgeClassLoader
    extends ClassLoader
  {
    BridgeClassLoader() {}
    
    BridgeClassLoader(ClassLoader usersClassLoader)
    {
      super();
    }
    
    protected Class<?> loadClass(String name, boolean resolve)
      throws ClassNotFoundException
    {
      if (name.startsWith("sun.reflect")) {
        return BytecodeGen.SystemBridgeHolder.SYSTEM_BRIDGE.classicLoadClass(name, resolve);
      }
      if ((name.startsWith(BytecodeGen.GUICE_INTERNAL_PACKAGE)) || (name.startsWith(BytecodeGen.CGLIB_PACKAGE)))
      {
        if (null == BytecodeGen.GUICE_CLASS_LOADER) {
          return BytecodeGen.SystemBridgeHolder.SYSTEM_BRIDGE.classicLoadClass(name, resolve);
        }
        try
        {
          Class<?> clazz = BytecodeGen.GUICE_CLASS_LOADER.loadClass(name);
          if (resolve) {
            resolveClass(clazz);
          }
          return clazz;
        }
        catch (Throwable e) {}
      }
      return classicLoadClass(name, resolve);
    }
    
    Class<?> classicLoadClass(String name, boolean resolve)
      throws ClassNotFoundException
    {
      return super.loadClass(name, resolve);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BytecodeGen
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */