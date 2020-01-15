package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;

public abstract interface ProviderWithExtensionVisitor<T>
  extends Provider<T>
{
  public abstract <B, V> V acceptExtensionVisitor(BindingTargetVisitor<B, V> paramBindingTargetVisitor, ProviderInstanceBinding<? extends B> paramProviderInstanceBinding);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderWithExtensionVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */