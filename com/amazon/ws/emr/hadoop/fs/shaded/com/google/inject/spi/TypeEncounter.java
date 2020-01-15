package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;

public abstract interface TypeEncounter<I>
{
  public abstract void addError(String paramString, Object... paramVarArgs);
  
  public abstract void addError(Throwable paramThrowable);
  
  public abstract void addError(Message paramMessage);
  
  public abstract <T> Provider<T> getProvider(Key<T> paramKey);
  
  public abstract <T> Provider<T> getProvider(Class<T> paramClass);
  
  public abstract <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> paramTypeLiteral);
  
  public abstract <T> MembersInjector<T> getMembersInjector(Class<T> paramClass);
  
  public abstract void register(MembersInjector<? super I> paramMembersInjector);
  
  public abstract void register(InjectionListener<? super I> paramInjectionListener);
  
  public abstract void bindInterceptor(Matcher<? super Method> paramMatcher, MethodInterceptor... paramVarArgs);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeEncounter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */