package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;

class ProviderLookup$1
  implements Provider<T>
{
  ProviderLookup$1(ProviderLookup paramProviderLookup) {}
  
  public T get()
  {
    .Preconditions.checkState(ProviderLookup.access$000(this$0) != null, "This Provider cannot be used until the Injector has been created.");
    
    return (T)ProviderLookup.access$000(this$0).get();
  }
  
  public String toString()
  {
    return "Provider<" + ProviderLookup.access$100(this$0).getTypeLiteral() + ">";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderLookup.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */