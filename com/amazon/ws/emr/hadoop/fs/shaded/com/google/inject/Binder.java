package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;

public abstract interface Binder
{
  public abstract void bindInterceptor(Matcher<? super Class<?>> paramMatcher, Matcher<? super Method> paramMatcher1, MethodInterceptor... paramVarArgs);
  
  public abstract void bindScope(Class<? extends Annotation> paramClass, Scope paramScope);
  
  public abstract <T> LinkedBindingBuilder<T> bind(Key<T> paramKey);
  
  public abstract <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> paramTypeLiteral);
  
  public abstract <T> AnnotatedBindingBuilder<T> bind(Class<T> paramClass);
  
  public abstract AnnotatedConstantBindingBuilder bindConstant();
  
  public abstract <T> void requestInjection(TypeLiteral<T> paramTypeLiteral, T paramT);
  
  public abstract void requestInjection(Object paramObject);
  
  public abstract void requestStaticInjection(Class<?>... paramVarArgs);
  
  public abstract void install(Module paramModule);
  
  public abstract Stage currentStage();
  
  public abstract void addError(String paramString, Object... paramVarArgs);
  
  public abstract void addError(Throwable paramThrowable);
  
  public abstract void addError(Message paramMessage);
  
  public abstract <T> Provider<T> getProvider(Key<T> paramKey);
  
  public abstract <T> Provider<T> getProvider(Class<T> paramClass);
  
  public abstract <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> paramTypeLiteral);
  
  public abstract <T> MembersInjector<T> getMembersInjector(Class<T> paramClass);
  
  public abstract void convertToTypes(Matcher<? super TypeLiteral<?>> paramMatcher, TypeConverter paramTypeConverter);
  
  public abstract void bindListener(Matcher<? super TypeLiteral<?>> paramMatcher, TypeListener paramTypeListener);
  
  public abstract Binder withSource(Object paramObject);
  
  public abstract Binder skipSources(Class... paramVarArgs);
  
  public abstract PrivateBinder newPrivateBinder();
  
  public abstract void requireExplicitBindings();
  
  public abstract void disableCircularProxies();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */