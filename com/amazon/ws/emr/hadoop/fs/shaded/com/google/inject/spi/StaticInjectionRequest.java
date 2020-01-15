package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.util.Set;

public final class StaticInjectionRequest
  implements Element
{
  private final Object source;
  private final Class<?> type;
  
  StaticInjectionRequest(Object source, Class<?> type)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
    this.type = ((Class).Preconditions.checkNotNull(type, "type"));
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public Class<?> getType()
  {
    return type;
  }
  
  public Set<InjectionPoint> getInjectionPoints()
    throws ConfigurationException
  {
    return InjectionPoint.forStaticMethodsAndFields(type);
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).requestStaticInjection(new Class[] { type });
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.StaticInjectionRequest
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */