package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

class AbstractBindingProcessor$Processor$1
  implements Runnable
{
  AbstractBindingProcessor$Processor$1(AbstractBindingProcessor.Processor paramProcessor, BindingImpl paramBindingImpl) {}
  
  public void run()
  {
    try
    {
      val$binding.getInjector().initializeBinding(val$binding, this$1.this$0.errors.withSource(this$1.source));
    }
    catch (ErrorsException e)
    {
      this$1.this$0.errors.merge(e.getErrors());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.AbstractBindingProcessor.Processor.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */