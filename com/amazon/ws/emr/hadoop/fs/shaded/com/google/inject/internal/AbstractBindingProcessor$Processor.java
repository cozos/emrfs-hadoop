package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DefaultBindingTargetVisitor;

abstract class AbstractBindingProcessor$Processor<T, V>
  extends DefaultBindingTargetVisitor<T, V>
{
  final Object source;
  final Key<T> key;
  final Class<? super T> rawType;
  Scoping scoping;
  
  AbstractBindingProcessor$Processor(BindingImpl<T> arg1)
  {
    source = binding.getSource();
    key = binding.getKey();
    rawType = key.getTypeLiteral().getRawType();
    scoping = binding.getScoping();
  }
  
  protected void prepareBinding()
  {
    AbstractBindingProcessor.access$000(this$0, source, key);
    scoping = Scoping.makeInjectable(scoping, this$0.injector, this$0.errors);
  }
  
  protected void scheduleInitialization(final BindingImpl<?> binding)
  {
    this$0.bindingData.addUninitializedBinding(new Runnable()
    {
      public void run()
      {
        try
        {
          binding.getInjector().initializeBinding(binding, this$0.errors.withSource(source));
        }
        catch (ErrorsException e)
        {
          this$0.errors.merge(e.getErrors());
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.AbstractBindingProcessor.Processor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */