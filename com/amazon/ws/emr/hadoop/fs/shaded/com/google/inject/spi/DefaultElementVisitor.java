package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;

public abstract class DefaultElementVisitor<V>
  implements ElementVisitor<V>
{
  protected V visitOther(Element element)
  {
    return null;
  }
  
  public V visit(Message message)
  {
    return (V)visitOther(message);
  }
  
  public <T> V visit(Binding<T> binding)
  {
    return (V)visitOther(binding);
  }
  
  public V visit(InterceptorBinding interceptorBinding)
  {
    return (V)visitOther(interceptorBinding);
  }
  
  public V visit(ScopeBinding scopeBinding)
  {
    return (V)visitOther(scopeBinding);
  }
  
  public V visit(TypeConverterBinding typeConverterBinding)
  {
    return (V)visitOther(typeConverterBinding);
  }
  
  public <T> V visit(ProviderLookup<T> providerLookup)
  {
    return (V)visitOther(providerLookup);
  }
  
  public V visit(InjectionRequest<?> injectionRequest)
  {
    return (V)visitOther(injectionRequest);
  }
  
  public V visit(StaticInjectionRequest staticInjectionRequest)
  {
    return (V)visitOther(staticInjectionRequest);
  }
  
  public V visit(PrivateElements privateElements)
  {
    return (V)visitOther(privateElements);
  }
  
  public <T> V visit(MembersInjectorLookup<T> lookup)
  {
    return (V)visitOther(lookup);
  }
  
  public V visit(TypeListenerBinding binding)
  {
    return (V)visitOther(binding);
  }
  
  public V visit(DisableCircularProxiesOption option)
  {
    return (V)visitOther(option);
  }
  
  public V visit(RequireExplicitBindingsOption option)
  {
    return (V)visitOther(option);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DefaultElementVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */