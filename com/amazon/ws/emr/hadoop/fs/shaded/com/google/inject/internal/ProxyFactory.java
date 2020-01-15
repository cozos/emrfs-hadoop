package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Callback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..CallbackFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Enhancer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..MethodInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..NoOp;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aopalliance.intercept.MethodInterceptor;

final class ProxyFactory<T>
  implements ConstructionProxyFactory<T>
{
  private static final Logger logger = Logger.getLogger(ProxyFactory.class.getName());
  private final InjectionPoint injectionPoint;
  private final .ImmutableMap<Method, List<MethodInterceptor>> interceptors;
  private final Class<T> declaringClass;
  private final List<Method> methods;
  private final .Callback[] callbacks;
  private BytecodeGen.Visibility visibility = BytecodeGen.Visibility.PUBLIC;
  
  ProxyFactory(InjectionPoint injectionPoint, Iterable<MethodAspect> methodAspects)
  {
    this.injectionPoint = injectionPoint;
    
    Constructor<T> constructor = (Constructor)injectionPoint.getMember();
    declaringClass = constructor.getDeclaringClass();
    
    List<MethodAspect> applicableAspects = .Lists.newArrayList();
    for (MethodAspect methodAspect : methodAspects) {
      if (methodAspect.matches(declaringClass)) {
        applicableAspects.add(methodAspect);
      }
    }
    if (applicableAspects.isEmpty())
    {
      interceptors = .ImmutableMap.of();
      methods = .ImmutableList.of();
      callbacks = null;
      return;
    }
    methods = .Lists.newArrayList();
    .Enhancer.getMethods(declaringClass, null, methods);
    
    List<MethodInterceptorsPair> methodInterceptorsPairs = .Lists.newArrayList();
    for (Method method : methods) {
      methodInterceptorsPairs.add(new MethodInterceptorsPair(method));
    }
    boolean anyMatched = false;
    for (Iterator i$ = applicableAspects.iterator(); i$.hasNext();)
    {
      methodAspect = (MethodAspect)i$.next();
      for (MethodInterceptorsPair pair : methodInterceptorsPairs) {
        if (methodAspect.matches(method))
        {
          if (method.isSynthetic()) {
            logger.log(Level.WARNING, "Method [{0}] is synthetic and is being intercepted by {1}. This could indicate a bug.  The method may be intercepted twice, or may not be intercepted at all.", new Object[] { method, methodAspect.interceptors() });
          }
          visibility = visibility.and(BytecodeGen.Visibility.forMember(method));
          pair.addAll(methodAspect.interceptors());
          anyMatched = true;
        }
      }
    }
    MethodAspect methodAspect;
    if (!anyMatched)
    {
      interceptors = .ImmutableMap.of();
      callbacks = null;
      return;
    }
    .ImmutableMap.Builder<Method, List<MethodInterceptor>> interceptorsMapBuilder = null;
    
    callbacks = new .Callback[methods.size()];
    for (int i = 0; i < methods.size(); i++)
    {
      MethodInterceptorsPair pair = (MethodInterceptorsPair)methodInterceptorsPairs.get(i);
      if (!pair.hasInterceptors())
      {
        callbacks[i] = .NoOp.INSTANCE;
      }
      else
      {
        if (interceptorsMapBuilder == null) {
          interceptorsMapBuilder = .ImmutableMap.builder();
        }
        interceptorsMapBuilder.put(method, .ImmutableList.copyOf(interceptors));
        callbacks[i] = new InterceptorStackCallback(method, interceptors);
      }
    }
    interceptors = (interceptorsMapBuilder != null ? interceptorsMapBuilder.build() : .ImmutableMap.of());
  }
  
  public .ImmutableMap<Method, List<MethodInterceptor>> getInterceptors()
  {
    return interceptors;
  }
  
  public ConstructionProxy<T> create()
    throws ErrorsException
  {
    if (interceptors.isEmpty()) {
      return new DefaultConstructionProxyFactory(injectionPoint).create();
    }
    Class<? extends .Callback>[] callbackTypes = new Class[callbacks.length];
    for (int i = 0; i < callbacks.length; i++) {
      if (callbacks[i] == .NoOp.INSTANCE) {
        callbackTypes[i] = .NoOp.class;
      } else {
        callbackTypes[i] = .MethodInterceptor.class;
      }
    }
    try
    {
      .Enhancer enhancer = BytecodeGen.newEnhancer(declaringClass, visibility);
      enhancer.setCallbackFilter(new IndicesCallbackFilter(declaringClass, methods));
      enhancer.setCallbackTypes(callbackTypes);
      return new ProxyConstructor(enhancer, injectionPoint, callbacks, interceptors);
    }
    catch (Throwable e)
    {
      throw new Errors().errorEnhancingClass(declaringClass, e).toException();
    }
  }
  
  private static class MethodInterceptorsPair
  {
    final Method method;
    List<MethodInterceptor> interceptors;
    
    MethodInterceptorsPair(Method method)
    {
      this.method = method;
    }
    
    void addAll(List<MethodInterceptor> interceptors)
    {
      if (this.interceptors == null) {
        this.interceptors = .Lists.newArrayList();
      }
      this.interceptors.addAll(interceptors);
    }
    
    boolean hasInterceptors()
    {
      return interceptors != null;
    }
  }
  
  private static class IndicesCallbackFilter
    implements .CallbackFilter
  {
    final Class<?> declaringClass;
    final Map<Method, Integer> indices;
    
    IndicesCallbackFilter(Class<?> declaringClass, List<Method> methods)
    {
      this.declaringClass = declaringClass;
      Map<Method, Integer> indices = .Maps.newHashMap();
      for (int i = 0; i < methods.size(); i++)
      {
        Method method = (Method)methods.get(i);
        indices.put(method, Integer.valueOf(i));
      }
      this.indices = indices;
    }
    
    public int accept(Method method)
    {
      return ((Integer)indices.get(method)).intValue();
    }
    
    public boolean equals(Object o)
    {
      return ((o instanceof IndicesCallbackFilter)) && (declaringClass == declaringClass);
    }
    
    public int hashCode()
    {
      return declaringClass.hashCode();
    }
  }
  
  private static class ProxyConstructor<T>
    implements ConstructionProxy<T>
  {
    final Class<?> enhanced;
    final InjectionPoint injectionPoint;
    final Constructor<T> constructor;
    final .Callback[] callbacks;
    final .FastConstructor fastConstructor;
    final .ImmutableMap<Method, List<MethodInterceptor>> methodInterceptors;
    
    ProxyConstructor(.Enhancer enhancer, InjectionPoint injectionPoint, .Callback[] callbacks, .ImmutableMap<Method, List<MethodInterceptor>> methodInterceptors)
    {
      enhanced = enhancer.createClass();
      this.injectionPoint = injectionPoint;
      constructor = ((Constructor)injectionPoint.getMember());
      this.callbacks = callbacks;
      this.methodInterceptors = methodInterceptors;
      
      .FastClass fastClass = BytecodeGen.newFastClass(enhanced, BytecodeGen.Visibility.forMember(constructor));
      fastConstructor = fastClass.getConstructor(constructor.getParameterTypes());
    }
    
    public T newInstance(Object... arguments)
      throws InvocationTargetException
    {
      .Enhancer.registerCallbacks(enhanced, callbacks);
      try
      {
        return (T)fastConstructor.newInstance(arguments);
      }
      finally
      {
        .Enhancer.registerCallbacks(enhanced, null);
      }
    }
    
    public InjectionPoint getInjectionPoint()
    {
      return injectionPoint;
    }
    
    public Constructor<T> getConstructor()
    {
      return constructor;
    }
    
    public .ImmutableMap<Method, List<MethodInterceptor>> getMethodInterceptors()
    {
      return methodInterceptors;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProxyFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */