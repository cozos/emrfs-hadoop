package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;

public abstract class AbstractModule
  implements Module
{
  Binder binder;
  
  public final synchronized void configure(Binder builder)
  {
    .Preconditions.checkState(binder == null, "Re-entry is not allowed.");
    
    binder = ((Binder).Preconditions.checkNotNull(builder, "builder"));
    try
    {
      configure();
    }
    finally
    {
      binder = null;
    }
  }
  
  protected abstract void configure();
  
  protected Binder binder()
  {
    return binder;
  }
  
  protected void bindScope(Class<? extends Annotation> scopeAnnotation, Scope scope)
  {
    binder.bindScope(scopeAnnotation, scope);
  }
  
  protected <T> LinkedBindingBuilder<T> bind(Key<T> key)
  {
    return binder.bind(key);
  }
  
  protected <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral)
  {
    return binder.bind(typeLiteral);
  }
  
  protected <T> AnnotatedBindingBuilder<T> bind(Class<T> clazz)
  {
    return binder.bind(clazz);
  }
  
  protected AnnotatedConstantBindingBuilder bindConstant()
  {
    return binder.bindConstant();
  }
  
  protected void install(Module module)
  {
    binder.install(module);
  }
  
  protected void addError(String message, Object... arguments)
  {
    binder.addError(message, arguments);
  }
  
  protected void addError(Throwable t)
  {
    binder.addError(t);
  }
  
  protected void addError(Message message)
  {
    binder.addError(message);
  }
  
  protected void requestInjection(Object instance)
  {
    binder.requestInjection(instance);
  }
  
  protected void requestStaticInjection(Class<?>... types)
  {
    binder.requestStaticInjection(types);
  }
  
  protected void bindInterceptor(Matcher<? super Class<?>> classMatcher, Matcher<? super Method> methodMatcher, MethodInterceptor... interceptors)
  {
    binder.bindInterceptor(classMatcher, methodMatcher, interceptors);
  }
  
  protected void requireBinding(Key<?> key)
  {
    binder.getProvider(key);
  }
  
  protected void requireBinding(Class<?> type)
  {
    binder.getProvider(type);
  }
  
  protected <T> Provider<T> getProvider(Key<T> key)
  {
    return binder.getProvider(key);
  }
  
  protected <T> Provider<T> getProvider(Class<T> type)
  {
    return binder.getProvider(type);
  }
  
  protected void convertToTypes(Matcher<? super TypeLiteral<?>> typeMatcher, TypeConverter converter)
  {
    binder.convertToTypes(typeMatcher, converter);
  }
  
  protected Stage currentStage()
  {
    return binder.currentStage();
  }
  
  protected <T> MembersInjector<T> getMembersInjector(Class<T> type)
  {
    return binder.getMembersInjector(type);
  }
  
  protected <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> type)
  {
    return binder.getMembersInjector(type);
  }
  
  protected void bindListener(Matcher<? super TypeLiteral<?>> typeMatcher, TypeListener listener)
  {
    binder.bindListener(typeMatcher, listener);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.AbstractModule
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */