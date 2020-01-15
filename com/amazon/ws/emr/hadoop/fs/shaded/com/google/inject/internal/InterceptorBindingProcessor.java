package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InterceptorBinding;

final class InterceptorBindingProcessor
  extends AbstractProcessor
{
  InterceptorBindingProcessor(Errors errors)
  {
    super(errors);
  }
  
  public Boolean visit(InterceptorBinding command)
  {
    injector.state.addMethodAspect(new MethodAspect(command.getClassMatcher(), command.getMethodMatcher(), command.getInterceptors()));
    
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InterceptorBindingProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */