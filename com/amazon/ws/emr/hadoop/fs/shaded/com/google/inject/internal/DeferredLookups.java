package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.MembersInjectorLookup;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderLookup;
import java.util.List;

final class DeferredLookups
  implements Lookups
{
  private final InjectorImpl injector;
  private final List<Element> lookups = .Lists.newArrayList();
  
  DeferredLookups(InjectorImpl injector)
  {
    this.injector = injector;
  }
  
  void initialize(Errors errors)
  {
    injector.lookups = injector;
    new LookupProcessor(errors).process(injector, lookups);
  }
  
  public <T> Provider<T> getProvider(Key<T> key)
  {
    ProviderLookup<T> lookup = new ProviderLookup(key, key);
    lookups.add(lookup);
    return lookup.getProvider();
  }
  
  public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> type)
  {
    MembersInjectorLookup<T> lookup = new MembersInjectorLookup(type, type);
    lookups.add(lookup);
    return lookup.getMembersInjector();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.DeferredLookups
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */