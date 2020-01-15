package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scopes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ScopedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;

final class Scoping$1
  extends Scoping
{
  Scoping$1()
  {
    super(null);
  }
  
  public <V> V acceptVisitor(BindingScopingVisitor<V> visitor)
  {
    return (V)visitor.visitNoScoping();
  }
  
  public Scope getScopeInstance()
  {
    return Scopes.NO_SCOPE;
  }
  
  public String toString()
  {
    return Scopes.NO_SCOPE.toString();
  }
  
  public void applyTo(ScopedBindingBuilder scopedBindingBuilder) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Scoping.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */