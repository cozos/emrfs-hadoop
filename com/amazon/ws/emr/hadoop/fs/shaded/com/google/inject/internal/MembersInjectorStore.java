package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListenerBinding;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

final class MembersInjectorStore
{
  private final InjectorImpl injector;
  private final .ImmutableList<TypeListenerBinding> typeListenerBindings;
  private final FailableCache<TypeLiteral<?>, MembersInjectorImpl<?>> cache = new FailableCache()
  {
    protected MembersInjectorImpl<?> create(TypeLiteral<?> type, Errors errors)
      throws ErrorsException
    {
      return MembersInjectorStore.this.createWithListeners(type, errors);
    }
  };
  
  MembersInjectorStore(InjectorImpl injector, List<TypeListenerBinding> typeListenerBindings)
  {
    this.injector = injector;
    this.typeListenerBindings = .ImmutableList.copyOf(typeListenerBindings);
  }
  
  public boolean hasTypeListeners()
  {
    return !typeListenerBindings.isEmpty();
  }
  
  public <T> MembersInjectorImpl<T> get(TypeLiteral<T> key, Errors errors)
    throws ErrorsException
  {
    return (MembersInjectorImpl)cache.get(key, errors);
  }
  
  boolean remove(TypeLiteral<?> type)
  {
    return cache.remove(type);
  }
  
  private <T> MembersInjectorImpl<T> createWithListeners(TypeLiteral<T> type, Errors errors)
    throws ErrorsException
  {
    int numErrorsBefore = errors.size();
    Set<InjectionPoint> injectionPoints;
    try
    {
      injectionPoints = InjectionPoint.forInstanceMethodsAndFields(type);
    }
    catch (ConfigurationException e)
    {
      errors.merge(e.getErrorMessages());
      injectionPoints = (Set)e.getPartialValue();
    }
    .ImmutableList<SingleMemberInjector> injectors = getInjectors(injectionPoints, errors);
    errors.throwIfNewErrors(numErrorsBefore);
    
    EncounterImpl<T> encounter = new EncounterImpl(errors, injector.lookups);
    for (TypeListenerBinding typeListener : typeListenerBindings) {
      if (typeListener.getTypeMatcher().matches(type)) {
        try
        {
          typeListener.getListener().hear(type, encounter);
        }
        catch (RuntimeException e)
        {
          errors.errorNotifyingTypeListener(typeListener, type, e);
        }
      }
    }
    encounter.invalidate();
    errors.throwIfNewErrors(numErrorsBefore);
    
    return new MembersInjectorImpl(injector, type, encounter, injectors);
  }
  
  .ImmutableList<SingleMemberInjector> getInjectors(Set<InjectionPoint> injectionPoints, Errors errors)
  {
    List<SingleMemberInjector> injectors = .Lists.newArrayList();
    for (InjectionPoint injectionPoint : injectionPoints) {
      try
      {
        Errors errorsForMember = injectionPoint.isOptional() ? new Errors(injectionPoint) : errors.withSource(injectionPoint);
        
        SingleMemberInjector injector = (injectionPoint.getMember() instanceof Field) ? new SingleFieldInjector(this.injector, injectionPoint, errorsForMember) : new SingleMethodInjector(this.injector, injectionPoint, errorsForMember);
        
        injectors.add(injector);
      }
      catch (ErrorsException ignoredForNow) {}
    }
    return .ImmutableList.copyOf(injectors);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MembersInjectorStore
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */