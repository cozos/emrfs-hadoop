package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;

class InjectorImpl$InjectorOptions
{
  final Stage stage;
  final boolean jitDisabled;
  final boolean disableCircularProxies;
  
  InjectorImpl$InjectorOptions(Stage stage, boolean jitDisabled, boolean disableCircularProxies)
  {
    this.stage = stage;
    this.jitDisabled = jitDisabled;
    this.disableCircularProxies = disableCircularProxies;
  }
  
  public String toString()
  {
    return new .ToStringBuilder(getClass()).add("stage", stage).add("jitDisabled", Boolean.valueOf(jitDisabled)).add("disableCircularProxies", Boolean.valueOf(disableCircularProxies)).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl.InjectorOptions
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */