package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeEncounter;
import java.lang.reflect.Method;
import java.util.List;
import org.aopalliance.intercept.MethodInterceptor;

final class EncounterImpl<T>
  implements TypeEncounter<T>
{
  private final Errors errors;
  private final Lookups lookups;
  private List<MembersInjector<? super T>> membersInjectors;
  private List<InjectionListener<? super T>> injectionListeners;
  private List<MethodAspect> aspects;
  private boolean valid = true;
  
  EncounterImpl(Errors errors, Lookups lookups)
  {
    this.errors = errors;
    this.lookups = lookups;
  }
  
  void invalidate()
  {
    valid = false;
  }
  
  .ImmutableList<MethodAspect> getAspects()
  {
    return aspects == null ? .ImmutableList.of() : .ImmutableList.copyOf(aspects);
  }
  
  public void bindInterceptor(Matcher<? super Method> methodMatcher, MethodInterceptor... interceptors)
  {
    .Preconditions.checkState(valid, "Encounters may not be used after hear() returns.");
    if (aspects == null) {
      aspects = .Lists.newArrayList();
    }
    aspects.add(new MethodAspect(Matchers.any(), methodMatcher, interceptors));
  }
  
  .ImmutableList<MembersInjector<? super T>> getMembersInjectors()
  {
    return membersInjectors == null ? .ImmutableList.of() : .ImmutableList.copyOf(membersInjectors);
  }
  
  .ImmutableList<InjectionListener<? super T>> getInjectionListeners()
  {
    return injectionListeners == null ? .ImmutableList.of() : .ImmutableList.copyOf(injectionListeners);
  }
  
  public void register(MembersInjector<? super T> membersInjector)
  {
    .Preconditions.checkState(valid, "Encounters may not be used after hear() returns.");
    if (membersInjectors == null) {
      membersInjectors = .Lists.newArrayList();
    }
    membersInjectors.add(membersInjector);
  }
  
  public void register(InjectionListener<? super T> injectionListener)
  {
    .Preconditions.checkState(valid, "Encounters may not be used after hear() returns.");
    if (injectionListeners == null) {
      injectionListeners = .Lists.newArrayList();
    }
    injectionListeners.add(injectionListener);
  }
  
  public void addError(String message, Object... arguments)
  {
    .Preconditions.checkState(valid, "Encounters may not be used after hear() returns.");
    errors.addMessage(message, arguments);
  }
  
  public void addError(Throwable t)
  {
    .Preconditions.checkState(valid, "Encounters may not be used after hear() returns.");
    errors.errorInUserCode(t, "An exception was caught and reported. Message: %s", new Object[] { t.getMessage() });
  }
  
  public void addError(Message message)
  {
    .Preconditions.checkState(valid, "Encounters may not be used after hear() returns.");
    errors.addMessage(message);
  }
  
  public <T> Provider<T> getProvider(Key<T> key)
  {
    .Preconditions.checkState(valid, "Encounters may not be used after hear() returns.");
    return lookups.getProvider(key);
  }
  
  public <T> Provider<T> getProvider(Class<T> type)
  {
    return getProvider(Key.get(type));
  }
  
  public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral)
  {
    .Preconditions.checkState(valid, "Encounters may not be used after hear() returns.");
    return lookups.getMembersInjector(typeLiteral);
  }
  
  public <T> MembersInjector<T> getMembersInjector(Class<T> type)
  {
    return getMembersInjector(TypeLiteral.get(type));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.EncounterImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */