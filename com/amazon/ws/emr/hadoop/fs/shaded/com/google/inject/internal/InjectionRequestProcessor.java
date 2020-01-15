package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.StaticInjectionRequest;
import java.util.List;
import java.util.Set;

final class InjectionRequestProcessor
  extends AbstractProcessor
{
  private final List<StaticInjection> staticInjections = .Lists.newArrayList();
  private final Initializer initializer;
  
  InjectionRequestProcessor(Errors errors, Initializer initializer)
  {
    super(errors);
    this.initializer = initializer;
  }
  
  public Boolean visit(StaticInjectionRequest request)
  {
    staticInjections.add(new StaticInjection(injector, request));
    return Boolean.valueOf(true);
  }
  
  public Boolean visit(InjectionRequest<?> request)
  {
    Set<InjectionPoint> injectionPoints;
    try
    {
      injectionPoints = request.getInjectionPoints();
    }
    catch (ConfigurationException e)
    {
      errors.merge(e.getErrorMessages());
      injectionPoints = (Set)e.getPartialValue();
    }
    initializer.requestInjection(injector, request.getInstance(), request.getSource(), injectionPoints);
    
    return Boolean.valueOf(true);
  }
  
  void validate()
  {
    for (StaticInjection staticInjection : staticInjections) {
      staticInjection.validate();
    }
  }
  
  void injectMembers()
  {
    for (StaticInjection staticInjection : staticInjections) {
      staticInjection.injectMembers();
    }
  }
  
  private class StaticInjection
  {
    final InjectorImpl injector;
    final Object source;
    final StaticInjectionRequest request;
    .ImmutableList<SingleMemberInjector> memberInjectors;
    
    public StaticInjection(InjectorImpl injector, StaticInjectionRequest request)
    {
      this.injector = injector;
      source = request.getSource();
      this.request = request;
    }
    
    void validate()
    {
      Errors errorsForMember = errors.withSource(source);
      Set<InjectionPoint> injectionPoints;
      try
      {
        injectionPoints = request.getInjectionPoints();
      }
      catch (ConfigurationException e)
      {
        errors.merge(e.getErrorMessages());
        injectionPoints = (Set)e.getPartialValue();
      }
      memberInjectors = injector.membersInjectorStore.getInjectors(injectionPoints, errorsForMember);
    }
    
    void injectMembers()
    {
      try
      {
        injector.callInContext(new ContextualCallable()
        {
          public Void call(InternalContext context)
          {
            for (SingleMemberInjector memberInjector : memberInjectors) {
              if ((injector.options.stage != Stage.TOOL) || (memberInjector.getInjectionPoint().isToolable())) {
                memberInjector.inject(errors, context, null);
              }
            }
            return null;
          }
        });
      }
      catch (ErrorsException e)
      {
        throw new AssertionError();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectionRequestProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */