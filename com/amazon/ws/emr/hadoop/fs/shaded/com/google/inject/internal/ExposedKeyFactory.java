package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;

final class ExposedKeyFactory<T>
  implements InternalFactory<T>, CreationListener
{
  private final Key<T> key;
  private final PrivateElements privateElements;
  private BindingImpl<T> delegate;
  
  ExposedKeyFactory(Key<T> key, PrivateElements privateElements)
  {
    this.key = key;
    this.privateElements = privateElements;
  }
  
  public void notify(Errors errors)
  {
    InjectorImpl privateInjector = (InjectorImpl)privateElements.getInjector();
    BindingImpl<T> explicitBinding = state.getExplicitBinding(key);
    if (explicitBinding.getInternalFactory() == this)
    {
      errors.withSource(explicitBinding.getSource()).exposedButNotBound(key);
      return;
    }
    delegate = explicitBinding;
  }
  
  public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
    throws ErrorsException
  {
    return (T)delegate.getInternalFactory().get(errors, context, dependency, linked);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ExposedKeyFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */