package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;

final class InternalFactoryToProviderAdapter<T>
  implements InternalFactory<T>
{
  private final Initializable<Provider<? extends T>> initializable;
  private final Object source;
  
  public InternalFactoryToProviderAdapter(Initializable<Provider<? extends T>> initializable, Object source)
  {
    this.initializable = ((Initializable).Preconditions.checkNotNull(initializable, "provider"));
    this.source = .Preconditions.checkNotNull(source, "source");
  }
  
  public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
    throws ErrorsException
  {
    try
    {
      return (T)errors.checkForNull(((Provider)initializable.get(errors)).get(), source, dependency);
    }
    catch (RuntimeException userException)
    {
      throw errors.withSource(source).errorInProvider(userException).toException();
    }
  }
  
  public String toString()
  {
    return initializable.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalFactoryToProviderAdapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */