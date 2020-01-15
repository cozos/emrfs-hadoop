package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;

public final class DisableCircularProxiesOption
  implements Element
{
  private final Object source;
  
  DisableCircularProxiesOption(Object source)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).disableCircularProxies();
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DisableCircularProxiesOption
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */