package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.StaticInjectionRequest;
import java.util.Set;

class InjectionRequestProcessor$StaticInjection
{
  final InjectorImpl injector;
  final Object source;
  final StaticInjectionRequest request;
  .ImmutableList<SingleMemberInjector> memberInjectors;
  
  public InjectionRequestProcessor$StaticInjection(InjectionRequestProcessor paramInjectionRequestProcessor, InjectorImpl injector, StaticInjectionRequest request)
  {
    this.injector = injector;
    source = request.getSource();
    this.request = request;
  }
  
  void validate()
  {
    Errors errorsForMember = this$0.errors.withSource(source);
    Set<InjectionPoint> injectionPoints;
    try
    {
      injectionPoints = request.getInjectionPoints();
    }
    catch (ConfigurationException e)
    {
      this$0.errors.merge(e.getErrorMessages());
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
              memberInjector.inject(this$0.errors, context, null);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectionRequestProcessor.StaticInjection
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */