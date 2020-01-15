package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;

public final class TypeListenerBinding
  implements Element
{
  private final Object source;
  private final Matcher<? super TypeLiteral<?>> typeMatcher;
  private final TypeListener listener;
  
  TypeListenerBinding(Object source, TypeListener listener, Matcher<? super TypeLiteral<?>> typeMatcher)
  {
    this.source = source;
    this.listener = listener;
    this.typeMatcher = typeMatcher;
  }
  
  public TypeListener getListener()
  {
    return listener;
  }
  
  public Matcher<? super TypeLiteral<?>> getTypeMatcher()
  {
    return typeMatcher;
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).bindListener(typeMatcher, listener);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListenerBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */