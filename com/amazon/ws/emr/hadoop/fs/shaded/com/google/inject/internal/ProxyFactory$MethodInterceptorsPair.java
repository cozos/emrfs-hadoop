package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import java.lang.reflect.Method;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

class ProxyFactory$MethodInterceptorsPair
{
  final Method method;
  List<MethodInterceptor> interceptors;
  
  ProxyFactory$MethodInterceptorsPair(Method method)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProxyFactory.MethodInterceptorsPair
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */