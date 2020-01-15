package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..MethodProxy;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

class InterceptorStackCallback$InterceptedMethodInvocation
  implements MethodInvocation
{
  final Object proxy;
  final Object[] arguments;
  final .MethodProxy methodProxy;
  int index = -1;
  
  public InterceptorStackCallback$InterceptedMethodInvocation(InterceptorStackCallback paramInterceptorStackCallback, Object proxy, .MethodProxy methodProxy, Object[] arguments)
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
      return index == this$0.interceptors.length ? methodProxy.invokeSuper(proxy, arguments) : this$0.interceptors[index].invoke(this);
    }
    catch (Throwable t)
    {
      InterceptorStackCallback.access$000(this$0, t);
      throw t;
    }
    finally
    {
      index -= 1;
    }
  }
  
  public Method getMethod()
  {
    return this$0.method;
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InterceptorStackCallback.InterceptedMethodInvocation
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */