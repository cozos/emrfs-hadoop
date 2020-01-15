package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;

public abstract class DefaultBindingTargetVisitor<T, V>
  implements BindingTargetVisitor<T, V>
{
  protected V visitOther(Binding<? extends T> binding)
  {
    return null;
  }
  
  public V visit(InstanceBinding<? extends T> instanceBinding)
  {
    return (V)visitOther(instanceBinding);
  }
  
  public V visit(ProviderInstanceBinding<? extends T> providerInstanceBinding)
  {
    return (V)visitOther(providerInstanceBinding);
  }
  
  public V visit(ProviderKeyBinding<? extends T> providerKeyBinding)
  {
    return (V)visitOther(providerKeyBinding);
  }
  
  public V visit(LinkedKeyBinding<? extends T> linkedKeyBinding)
  {
    return (V)visitOther(linkedKeyBinding);
  }
  
  public V visit(ExposedBinding<? extends T> exposedBinding)
  {
    return (V)visitOther(exposedBinding);
  }
  
  public V visit(UntargettedBinding<? extends T> untargettedBinding)
  {
    return (V)visitOther(untargettedBinding);
  }
  
  public V visit(ConstructorBinding<? extends T> constructorBinding)
  {
    return (V)visitOther(constructorBinding);
  }
  
  public V visit(ConvertedConstantBinding<? extends T> convertedConstantBinding)
  {
    return (V)visitOther(convertedConstantBinding);
  }
  
  public V visit(ProviderBinding<? extends T> providerBinding)
  {
    return (V)visitOther(providerBinding);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DefaultBindingTargetVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */