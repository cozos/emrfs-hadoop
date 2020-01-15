package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.UntargettedBinding;

class UntargettedBindingProcessor$1
  extends AbstractBindingProcessor.Processor<T, Boolean>
{
  UntargettedBindingProcessor$1(UntargettedBindingProcessor paramUntargettedBindingProcessor, BindingImpl x0)
  {
    super(paramUntargettedBindingProcessor, x0);
  }
  
  public Boolean visit(UntargettedBinding<? extends T> untargetted)
  {
    prepareBinding();
    if (key.getAnnotationType() != null)
    {
      this$0.errors.missingImplementation(key);
      this$0.putBinding(this$0.invalidBinding(this$0.injector, key, source));
      return Boolean.valueOf(true);
    }
    try
    {
      BindingImpl<T> binding = this$0.injector.createUninitializedBinding(key, scoping, source, this$0.errors, false);
      
      scheduleInitialization(binding);
      this$0.putBinding(binding);
    }
    catch (ErrorsException e)
    {
      this$0.errors.merge(e.getErrors());
      this$0.putBinding(this$0.invalidBinding(this$0.injector, key, source));
    }
    return Boolean.valueOf(true);
  }
  
  protected Boolean visitOther(Binding<? extends T> binding)
  {
    return Boolean.valueOf(false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.UntargettedBindingProcessor.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */