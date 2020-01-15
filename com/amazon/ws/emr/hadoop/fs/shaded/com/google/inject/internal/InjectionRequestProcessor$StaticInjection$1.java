package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;

class InjectionRequestProcessor$StaticInjection$1
  implements ContextualCallable<Void>
{
  InjectionRequestProcessor$StaticInjection$1(InjectionRequestProcessor.StaticInjection paramStaticInjection) {}
  
  public Void call(InternalContext context)
  {
    for (SingleMemberInjector memberInjector : this$1.memberInjectors) {
      if ((this$1.injector.options.stage != Stage.TOOL) || (memberInjector.getInjectionPoint().isToolable())) {
        memberInjector.inject(this$1.this$0.errors, context, null);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectionRequestProcessor.StaticInjection.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */