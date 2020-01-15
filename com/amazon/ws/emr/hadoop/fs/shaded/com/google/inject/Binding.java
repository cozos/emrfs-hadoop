package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;

public abstract interface Binding<T>
  extends Element
{
  public abstract Key<T> getKey();
  
  public abstract Provider<T> getProvider();
  
  public abstract <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> paramBindingTargetVisitor);
  
  public abstract <V> V acceptScopingVisitor(BindingScopingVisitor<V> paramBindingScopingVisitor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */