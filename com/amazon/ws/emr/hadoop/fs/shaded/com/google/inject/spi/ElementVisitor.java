package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;

public abstract interface ElementVisitor<V>
{
  public abstract <T> V visit(Binding<T> paramBinding);
  
  public abstract V visit(InterceptorBinding paramInterceptorBinding);
  
  public abstract V visit(ScopeBinding paramScopeBinding);
  
  public abstract V visit(TypeConverterBinding paramTypeConverterBinding);
  
  public abstract V visit(InjectionRequest<?> paramInjectionRequest);
  
  public abstract V visit(StaticInjectionRequest paramStaticInjectionRequest);
  
  public abstract <T> V visit(ProviderLookup<T> paramProviderLookup);
  
  public abstract <T> V visit(MembersInjectorLookup<T> paramMembersInjectorLookup);
  
  public abstract V visit(Message paramMessage);
  
  public abstract V visit(PrivateElements paramPrivateElements);
  
  public abstract V visit(TypeListenerBinding paramTypeListenerBinding);
  
  public abstract V visit(RequireExplicitBindingsOption paramRequireExplicitBindingsOption);
  
  public abstract V visit(DisableCircularProxiesOption paramDisableCircularProxiesOption);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ElementVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */