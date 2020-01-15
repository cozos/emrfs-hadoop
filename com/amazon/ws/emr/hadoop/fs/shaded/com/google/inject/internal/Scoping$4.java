package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scopes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ScopedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;

final class Scoping$4
  extends Scoping
{
  Scoping$4()
  {
    super(null);
  }
  
  public <V> V acceptVisitor(BindingScopingVisitor<V> visitor)
  {
    return (V)visitor.visitEagerSingleton();
  }
  
  public Scope getScopeInstance()
  {
    return Scopes.SINGLETON;
  }
  
  public String toString()
  {
    return "eager singleton";
  }
  
  public void applyTo(ScopedBindingBuilder scopedBindingBuilder)
  {
    scopedBindingBuilder.asEagerSingleton();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Scoping.4
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */