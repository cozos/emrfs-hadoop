package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ScopeBinding;
import java.util.Map;
import java.util.Set;

class Modules$RealOverriddenModuleBuilder$1$3
  extends Modules.ModuleWriter
{
  Modules$RealOverriddenModuleBuilder$1$3(Modules.RealOverriddenModuleBuilder.1 param1, Binder x0, Set paramSet, Map paramMap)
  {
    super(x0);
  }
  
  public Void visit(ScopeBinding scopeBinding)
  {
    if (!val$overridesScopeAnnotations.remove(scopeBinding.getAnnotationType()))
    {
      super.visit(scopeBinding);
    }
    else
    {
      Object source = val$scopeInstancesInUse.get(scopeBinding.getScope());
      if (source != null) {
        binder.withSource(source).addError("The scope for @%s is bound directly and cannot be overridden.", new Object[] { scopeBinding.getAnnotationType().getSimpleName() });
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Modules.RealOverriddenModuleBuilder.1.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */