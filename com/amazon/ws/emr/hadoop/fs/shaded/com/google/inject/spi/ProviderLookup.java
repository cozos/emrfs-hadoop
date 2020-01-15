package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;

public final class ProviderLookup<T>
  implements Element
{
  private final Object source;
  private final Key<T> key;
  private Provider<T> delegate;
  
  public ProviderLookup(Object source, Key<T> key)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
    this.key = ((Key).Preconditions.checkNotNull(key, "key"));
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public Key<T> getKey()
  {
    return key;
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
  
  public void initializeDelegate(Provider<T> delegate)
  {
    .Preconditions.checkState(this.delegate == null, "delegate already initialized");
    this.delegate = ((Provider).Preconditions.checkNotNull(delegate, "delegate"));
  }
  
  public void applyTo(Binder binder)
  {
    initializeDelegate(binder.withSource(getSource()).getProvider(key));
  }
  
  public Provider<T> getDelegate()
  {
    return delegate;
  }
  
  public Provider<T> getProvider()
  {
    new Provider()
    {
      public T get()
      {
        .Preconditions.checkState(delegate != null, "This Provider cannot be used until the Injector has been created.");
        
        return (T)delegate.get();
      }
      
      public String toString()
      {
        return "Provider<" + key.getTypeLiteral() + ">";
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderLookup
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */