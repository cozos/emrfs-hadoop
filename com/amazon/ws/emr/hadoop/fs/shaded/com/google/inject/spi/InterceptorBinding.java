package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import java.lang.reflect.Method;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

public final class InterceptorBinding
  implements Element
{
  private final Object source;
  private final Matcher<? super Class<?>> classMatcher;
  private final Matcher<? super Method> methodMatcher;
  private final .ImmutableList<MethodInterceptor> interceptors;
  
  InterceptorBinding(Object source, Matcher<? super Class<?>> classMatcher, Matcher<? super Method> methodMatcher, MethodInterceptor[] interceptors)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
    this.classMatcher = ((Matcher).Preconditions.checkNotNull(classMatcher, "classMatcher"));
    this.methodMatcher = ((Matcher).Preconditions.checkNotNull(methodMatcher, "methodMatcher"));
    this.interceptors = .ImmutableList.of(interceptors);
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public Matcher<? super Class<?>> getClassMatcher()
  {
    return classMatcher;
  }
  
  public Matcher<? super Method> getMethodMatcher()
  {
    return methodMatcher;
  }
  
  public List<MethodInterceptor> getInterceptors()
  {
    return interceptors;
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).bindInterceptor(classMatcher, methodMatcher, (MethodInterceptor[])interceptors.toArray(new MethodInterceptor[interceptors.size()]));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InterceptorBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */