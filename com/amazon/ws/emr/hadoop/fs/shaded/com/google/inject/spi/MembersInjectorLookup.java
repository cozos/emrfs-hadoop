package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;

public final class MembersInjectorLookup<T>
  implements Element
{
  private final Object source;
  private final TypeLiteral<T> type;
  private MembersInjector<T> delegate;
  
  public MembersInjectorLookup(Object source, TypeLiteral<T> type)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
    this.type = ((TypeLiteral).Preconditions.checkNotNull(type, "type"));
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public TypeLiteral<T> getType()
  {
    return type;
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
  
  public void initializeDelegate(MembersInjector<T> delegate)
  {
    .Preconditions.checkState(this.delegate == null, "delegate already initialized");
    this.delegate = ((MembersInjector).Preconditions.checkNotNull(delegate, "delegate"));
  }
  
  public void applyTo(Binder binder)
  {
    initializeDelegate(binder.withSource(getSource()).getMembersInjector(type));
  }
  
  public MembersInjector<T> getDelegate()
  {
    return delegate;
  }
  
  public MembersInjector<T> getMembersInjector()
  {
    new MembersInjector()
    {
      public void injectMembers(T instance)
      {
        .Preconditions.checkState(delegate != null, "This MembersInjector cannot be used until the Injector has been created.");
        
        delegate.injectMembers(instance);
      }
      
      public String toString()
      {
        return "MembersInjector<" + type + ">";
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.MembersInjectorLookup
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */