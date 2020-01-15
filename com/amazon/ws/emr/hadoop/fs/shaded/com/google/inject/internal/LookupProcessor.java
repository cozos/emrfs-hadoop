package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.MembersInjectorLookup;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderLookup;

final class LookupProcessor
  extends AbstractProcessor
{
  LookupProcessor(Errors errors)
  {
    super(errors);
  }
  
  public <T> Boolean visit(MembersInjectorLookup<T> lookup)
  {
    try
    {
      MembersInjector<T> membersInjector = injector.membersInjectorStore.get(lookup.getType(), errors);
      
      lookup.initializeDelegate(membersInjector);
    }
    catch (ErrorsException e)
    {
      errors.merge(e.getErrors());
    }
    return Boolean.valueOf(true);
  }
  
  public <T> Boolean visit(ProviderLookup<T> lookup)
  {
    try
    {
      Provider<T> provider = injector.getProviderOrThrow(lookup.getKey(), errors);
      lookup.initializeDelegate(provider);
    }
    catch (ErrorsException e)
    {
      errors.merge(e.getErrors());
    }
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.LookupProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */