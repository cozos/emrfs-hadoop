package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

final class MethodAspect
{
  private final Matcher<? super Class<?>> classMatcher;
  private final Matcher<? super Method> methodMatcher;
  private final List<MethodInterceptor> interceptors;
  
  MethodAspect(Matcher<? super Class<?>> classMatcher, Matcher<? super Method> methodMatcher, List<MethodInterceptor> interceptors)
  {
    this.classMatcher = ((Matcher).Preconditions.checkNotNull(classMatcher, "class matcher"));
    this.methodMatcher = ((Matcher).Preconditions.checkNotNull(methodMatcher, "method matcher"));
    this.interceptors = ((List).Preconditions.checkNotNull(interceptors, "interceptors"));
  }
  
  MethodAspect(Matcher<? super Class<?>> classMatcher, Matcher<? super Method> methodMatcher, MethodInterceptor... interceptors)
  {
    this(classMatcher, methodMatcher, Arrays.asList(interceptors));
  }
  
  boolean matches(Class<?> clazz)
  {
    return classMatcher.matches(clazz);
  }
  
  boolean matches(Method method)
  {
    return methodMatcher.matches(method);
  }
  
  List<MethodInterceptor> interceptors()
  {
    return interceptors;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MethodAspect
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */