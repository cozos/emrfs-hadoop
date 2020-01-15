package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;

final class MembersInjectorImpl<T>
  implements MembersInjector<T>
{
  private final TypeLiteral<T> typeLiteral;
  private final InjectorImpl injector;
  private final .ImmutableList<SingleMemberInjector> memberInjectors;
  private final .ImmutableList<MembersInjector<? super T>> userMembersInjectors;
  private final .ImmutableList<InjectionListener<? super T>> injectionListeners;
  private final .ImmutableList<MethodAspect> addedAspects;
  
  MembersInjectorImpl(InjectorImpl injector, TypeLiteral<T> typeLiteral, EncounterImpl<T> encounter, .ImmutableList<SingleMemberInjector> memberInjectors)
  {
    this.injector = injector;
    this.typeLiteral = typeLiteral;
    this.memberInjectors = memberInjectors;
    userMembersInjectors = encounter.getMembersInjectors();
    injectionListeners = encounter.getInjectionListeners();
    
    addedAspects = encounter.getAspects();
  }
  
  public .ImmutableList<SingleMemberInjector> getMemberInjectors()
  {
    return memberInjectors;
  }
  
  public void injectMembers(T instance)
  {
    Errors errors = new Errors(typeLiteral);
    try
    {
      injectAndNotify(instance, errors, false);
    }
    catch (ErrorsException e)
    {
      errors.merge(e.getErrors());
    }
    errors.throwProvisionExceptionIfErrorsExist();
  }
  
  void injectAndNotify(final T instance, final Errors errors, final boolean toolableOnly)
    throws ErrorsException
  {
    if (instance == null) {
      return;
    }
    injector.callInContext(new ContextualCallable()
    {
      public Void call(InternalContext context)
        throws ErrorsException
      {
        injectMembers(instance, errors, context, toolableOnly);
        return null;
      }
    });
    if (!toolableOnly) {
      notifyListeners(instance, errors);
    }
  }
  
  void notifyListeners(T instance, Errors errors)
    throws ErrorsException
  {
    int numErrorsBefore = errors.size();
    for (InjectionListener<? super T> injectionListener : injectionListeners) {
      try
      {
        injectionListener.afterInjection(instance);
      }
      catch (RuntimeException e)
      {
        errors.errorNotifyingInjectionListener(injectionListener, typeLiteral, e);
      }
    }
    errors.throwIfNewErrors(numErrorsBefore);
  }
  
  void injectMembers(T t, Errors errors, InternalContext context, boolean toolableOnly)
  {
    int i = 0;
    for (int size = memberInjectors.size(); i < size; i++)
    {
      SingleMemberInjector injector = (SingleMemberInjector)memberInjectors.get(i);
      if ((!toolableOnly) || (injector.getInjectionPoint().isToolable())) {
        injector.inject(errors, context, t);
      }
    }
    if (!toolableOnly)
    {
      int i = 0;
      for (int size = userMembersInjectors.size(); i < size; i++)
      {
        MembersInjector<? super T> userMembersInjector = (MembersInjector)userMembersInjectors.get(i);
        try
        {
          userMembersInjector.injectMembers(t);
        }
        catch (RuntimeException e)
        {
          errors.errorInUserInjector(userMembersInjector, typeLiteral, e);
        }
      }
    }
  }
  
  public String toString()
  {
    return "MembersInjector<" + typeLiteral + ">";
  }
  
  public .ImmutableSet<InjectionPoint> getInjectionPoints()
  {
    .ImmutableSet.Builder<InjectionPoint> builder = .ImmutableSet.builder();
    for (SingleMemberInjector memberInjector : memberInjectors) {
      builder.add(memberInjector.getInjectionPoint());
    }
    return builder.build();
  }
  
  public .ImmutableList<MethodAspect> getAddedAspects()
  {
    return addedAspects;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MembersInjectorImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */