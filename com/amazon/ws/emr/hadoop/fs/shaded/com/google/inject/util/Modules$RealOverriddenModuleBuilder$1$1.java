package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ScopeBinding;
import java.util.Set;

class Modules$RealOverriddenModuleBuilder$1$1
  extends Modules.ModuleWriter
{
  Modules$RealOverriddenModuleBuilder$1$1(Modules.RealOverriddenModuleBuilder.1 param1, Binder x0, Set paramSet1, Set paramSet2)
  {
    super(x0);
  }
  
  public <T> Void visit(Binding<T> binding)
  {
    val$overriddenKeys.add(binding.getKey());
    return (Void)super.visit(binding);
  }
  
  public Void visit(ScopeBinding scopeBinding)
  {
    val$overridesScopeAnnotations.add(scopeBinding.getAnnotationType());
    return (Void)super.visit(scopeBinding);
  }
  
  public Void visit(PrivateElements privateElements)
  {
    val$overriddenKeys.addAll(privateElements.getExposedKeys());
    return (Void)super.visit(privateElements);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Modules.RealOverriddenModuleBuilder.1.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */