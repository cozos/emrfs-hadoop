package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedElementBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;

public abstract class PrivateModule
  implements Module
{
  private PrivateBinder binder;
  
  public final synchronized void configure(Binder binder)
  {
    .Preconditions.checkState(this.binder == null, "Re-entry is not allowed.");
    
    this.binder = ((PrivateBinder)binder.skipSources(new Class[] { PrivateModule.class }));
    try
    {
      configure();
    }
    finally
    {
      this.binder = null;
    }
  }
  
  protected abstract void configure();
  
  protected final <T> void expose(Key<T> key)
  {
    binder.expose(key);
  }
  
  protected final AnnotatedElementBuilder expose(Class<?> type)
  {
    return binder.expose(type);
  }
  
  protected final AnnotatedElementBuilder expose(TypeLiteral<?> type)
  {
    return binder.expose(type);
  }
  
  protected final PrivateBinder binder()
  {
    return binder;
  }
  
  protected final void bindScope(Class<? extends Annotation> scopeAnnotation, Scope scope)
  {
    binder.bindScope(scopeAnnotation, scope);
  }
  
  protected final <T> LinkedBindingBuilder<T> bind(Key<T> key)
  {
    return binder.bind(key);
  }
  
  protected final <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral)
  {
    return binder.bind(typeLiteral);
  }
  
  protected final <T> AnnotatedBindingBuilder<T> bind(Class<T> clazz)
  {
    return binder.bind(clazz);
  }
  
  protected final AnnotatedConstantBindingBuilder bindConstant()
  {
    return binder.bindConstant();
  }
  
  protected final void install(Module module)
  {
    binder.install(module);
  }
  
  protected final void addError(String message, Object... arguments)
  {
    binder.addError(message, arguments);
  }
  
  protected final void addError(Throwable t)
  {
    binder.addError(t);
  }
  
  protected final void addError(Message message)
  {
    binder.addError(message);
  }
  
  protected final void requestInjection(Object instance)
  {
    binder.requestInjection(instance);
  }
  
  protected final void requestStaticInjection(Class<?>... types)
  {
    binder.requestStaticInjection(types);
  }
  
  protected final void bindInterceptor(Matcher<? super Class<?>> classMatcher, Matcher<? super Method> methodMatcher, MethodInterceptor... interceptors)
  {
    binder.bindInterceptor(classMatcher, methodMatcher, interceptors);
  }
  
  protected final void requireBinding(Key<?> key)
  {
    binder.getProvider(key);
  }
  
  protected final void requireBinding(Class<?> type)
  {
    binder.getProvider(type);
  }
  
  protected final <T> Provider<T> getProvider(Key<T> key)
  {
    return binder.getProvider(key);
  }
  
  protected final <T> Provider<T> getProvider(Class<T> type)
  {
    return binder.getProvider(type);
  }
  
  protected final void convertToTypes(Matcher<? super TypeLiteral<?>> typeMatcher, TypeConverter converter)
  {
    binder.convertToTypes(typeMatcher, converter);
  }
  
  protected final Stage currentStage()
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.PrivateModule
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */