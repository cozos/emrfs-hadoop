package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListenerBinding;

final class TypeListenerBindingProcessor
  extends AbstractProcessor
{
  TypeListenerBindingProcessor(Errors errors)
  {
    super(errors);
  }
  
  public Boolean visit(TypeListenerBinding binding)
  {
    injector.state.addTypeListener(binding);
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.TypeListenerBindingProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */