package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.util.Set;

public final class InjectionRequest<T>
  implements Element
{
  private final Object source;
  private final TypeLiteral<T> type;
  private final T instance;
  
  public InjectionRequest(Object source, TypeLiteral<T> type, T instance)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
    this.type = ((TypeLiteral).Preconditions.checkNotNull(type, "type"));
    this.instance = .Preconditions.checkNotNull(instance, "instance");
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public T getInstance()
  {
    return (T)instance;
  }
  
  public TypeLiteral<T> getType()
  {
    return type;
  }
  
  public Set<InjectionPoint> getInjectionPoints()
    throws ConfigurationException
  {
    return InjectionPoint.forInstanceMethodsAndFields(instance.getClass());
  }
  
  public <R> R acceptVisitor(ElementVisitor<R> visitor)
  {
    return (R)visitor.visit(this);
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).requestInjection(type, instance);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionRequest
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */