package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;

public final class TypeConverterBinding
  implements Element
{
  private final Object source;
  private final Matcher<? super TypeLiteral<?>> typeMatcher;
  private final TypeConverter typeConverter;
  
  public TypeConverterBinding(Object source, Matcher<? super TypeLiteral<?>> typeMatcher, TypeConverter typeConverter)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
    this.typeMatcher = ((Matcher).Preconditions.checkNotNull(typeMatcher, "typeMatcher"));
    this.typeConverter = ((TypeConverter).Preconditions.checkNotNull(typeConverter, "typeConverter"));
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public Matcher<? super TypeLiteral<?>> getTypeMatcher()
  {
    return typeMatcher;
  }
  
  public TypeConverter getTypeConverter()
  {
    return typeConverter;
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).convertToTypes(typeMatcher, typeConverter);
  }
  
  public String toString()
  {
    return typeConverter + " which matches " + typeMatcher + " (bound at " + source + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */