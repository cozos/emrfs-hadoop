package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ScopedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;

final class Scoping$6
  extends Scoping
{
  Scoping$6(Scope paramScope)
  {
    super(null);
  }
  
  public <V> V acceptVisitor(BindingScopingVisitor<V> visitor)
  {
    return (V)visitor.visitScope(val$scope);
  }
  
  public Scope getScopeInstance()
  {
    return val$scope;
  }
  
  public String toString()
  {
    return val$scope.toString();
  }
  
  public void applyTo(ScopedBindingBuilder scopedBindingBuilder)
  {
    scopedBindingBuilder.in(val$scope);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Scoping.6
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */