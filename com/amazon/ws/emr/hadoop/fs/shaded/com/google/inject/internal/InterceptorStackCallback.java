package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..MethodInterceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..MethodProxy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

final class InterceptorStackCallback
  implements .MethodInterceptor
{
  private static final Set<String> AOP_INTERNAL_CLASSES = new HashSet(Arrays.asList(new String[] { InterceptorStackCallback.class.getName(), InterceptedMethodInvocation.class.getName(), .MethodProxy.class.getName() }));
  final MethodInterceptor[] interceptors;
  final Method method;
  
  public InterceptorStackCallback(Method method, List<MethodInterceptor> interceptors)
  {
    this.method = method;
    this.interceptors = ((MethodInterceptor[])interceptors.toArray(new MethodInterceptor[interceptors.size()]));
  }
  
  public Object intercept(Object proxy, Method method, Object[] arguments, .MethodProxy methodProxy)
    throws Throwable
  {
    return new InterceptedMethodInvocation(proxy, methodProxy, arguments).proceed();
  }
  
  private class InterceptedMethodInvocation
    implements MethodInvocation
  {
    final Object proxy;
    final Object[] arguments;
    final .MethodProxy methodProxy;
    int index = -1;
    
    public InterceptedMethodInvocation(Object proxy, .MethodProxy methodProxy, Object[] arguments)
    {
      this.proxy = proxy;
      this.methodProxy = methodProxy;
      this.arguments = arguments;
    }
    
    public Object proceed()
      throws Throwable
    {
      try
      {
        index += 1;
        return index == interceptors.length ? methodProxy.invokeSuper(proxy, arguments) : interceptors[index].invoke(this);
      }
      catch (Throwable t)
      {
        InterceptorStackCallback.this.pruneStacktrace(t);
        throw t;
      }
      finally
      {
        index -= 1;
      }
    }
    
    public Method getMethod()
    {
      return method;
    }
    
    public Object[] getArguments()
    {
      return arguments;
    }
    
    public Object getThis()
    {
      return proxy;
    }
    
    public AccessibleObject getStaticPart()
    {
      return getMethod();
    }
  }
  
  private void pruneStacktrace(Throwable throwable)
  {
    for (Throwable t = throwable; t != null; t = t.getCause())
    {
      StackTraceElement[] stackTrace = t.getStackTrace();
      List<StackTraceElement> pruned = .Lists.newArrayList();
      for (StackTraceElement element : stackTrace)
      {
        String className = element.getClassName();
        if ((!AOP_INTERNAL_CLASSES.contains(className)) && (!className.contains("$EnhancerByGuice$"))) {
          pruned.add(element);
        }
      }
      t.setStackTrace((StackTraceElement[])pruned.toArray(new StackTraceElement[pruned.size()]));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InterceptorStackCallback
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */