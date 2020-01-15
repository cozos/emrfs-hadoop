package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.PrivateBinder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Sets;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ScopeBinding;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Modules$RealOverriddenModuleBuilder$1$2
  extends Modules.ModuleWriter
{
  Modules$RealOverriddenModuleBuilder$1$2(Modules.RealOverriddenModuleBuilder.1 param1, Binder x0, Set paramSet, Map paramMap, List paramList)
  {
    super(x0);
  }
  
  public <T> Void visit(Binding<T> binding)
  {
    if (!val$overriddenKeys.remove(binding.getKey()))
    {
      super.visit(binding);
      
      Scope scope = Modules.RealOverriddenModuleBuilder.1.access$200(this$1, binding);
      if (scope != null) {
        val$scopeInstancesInUse.put(scope, binding.getSource());
      }
    }
    return null;
  }
  
  void rewrite(Binder binder, PrivateElements privateElements, Set<Key<?>> keysToSkip)
  {
    PrivateBinder privateBinder = binder.withSource(privateElements.getSource()).newPrivateBinder();
    
    Set<Key<?>> skippedExposes = .Sets.newHashSet();
    for (Key<?> key : privateElements.getExposedKeys()) {
      if (keysToSkip.remove(key)) {
        skippedExposes.add(key);
      } else {
        privateBinder.withSource(privateElements.getExposedSource(key)).expose(key);
      }
    }
    for (Element element : privateElements.getElements()) {
      if ((!(element instanceof Binding)) || (!skippedExposes.remove(((Binding)element).getKey()))) {
        if ((element instanceof PrivateElements)) {
          rewrite(privateBinder, (PrivateElements)element, skippedExposes);
        } else {
          element.applyTo(privateBinder);
        }
      }
    }
  }
  
  public Void visit(PrivateElements privateElements)
  {
    rewrite(binder, privateElements, val$overriddenKeys);
    return null;
  }
  
  public Void visit(ScopeBinding scopeBinding)
  {
    val$scopeBindings.add(scopeBinding);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Modules.RealOverriddenModuleBuilder.1.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */