package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DisableCircularProxiesOption;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.RequireExplicitBindingsOption;

class InjectorOptionsProcessor
  extends AbstractProcessor
{
  private boolean disableCircularProxies = false;
  private boolean jitDisabled = false;
  
  InjectorOptionsProcessor(Errors errors)
  {
    super(errors);
  }
  
  public Boolean visit(DisableCircularProxiesOption option)
  {
    disableCircularProxies = true;
    return Boolean.valueOf(true);
  }
  
  public Boolean visit(RequireExplicitBindingsOption option)
  {
    jitDisabled = true;
    return Boolean.valueOf(true);
  }
  
  InjectorImpl.InjectorOptions getOptions(Stage stage, InjectorImpl.InjectorOptions parentOptions)
  {
    .Preconditions.checkNotNull(stage, "stage must be set");
    if (parentOptions == null) {
      return new InjectorImpl.InjectorOptions(stage, jitDisabled, disableCircularProxies);
    }
    .Preconditions.checkState(stage == stage, "child & parent stage don't match");
    return new InjectorImpl.InjectorOptions(stage, (jitDisabled) || (jitDisabled), (disableCircularProxies) || (disableCircularProxies));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorOptionsProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */