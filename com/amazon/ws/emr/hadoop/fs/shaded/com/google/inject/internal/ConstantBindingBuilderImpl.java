package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ConstantBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import java.lang.annotation.Annotation;
import java.util.List;

public final class ConstantBindingBuilderImpl<T>
  extends AbstractBindingBuilder<T>
  implements AnnotatedConstantBindingBuilder, ConstantBindingBuilder
{
  public ConstantBindingBuilderImpl(Binder binder, List<Element> elements, Object source)
  {
    super(binder, elements, source, NULL_KEY);
  }
  
  public ConstantBindingBuilder annotatedWith(Class<? extends Annotation> annotationType)
  {
    annotatedWithInternal(annotationType);
    return this;
  }
  
  public ConstantBindingBuilder annotatedWith(Annotation annotation)
  {
    annotatedWithInternal(annotation);
    return this;
  }
  
  public void to(String value)
  {
    toConstant(String.class, value);
  }
  
  public void to(int value)
  {
    toConstant(Integer.class, Integer.valueOf(value));
  }
  
  public void to(long value)
  {
    toConstant(Long.class, Long.valueOf(value));
  }
  
  public void to(boolean value)
  {
    toConstant(Boolean.class, Boolean.valueOf(value));
  }
  
  public void to(double value)
  {
    toConstant(Double.class, Double.valueOf(value));
  }
  
  public void to(float value)
  {
    toConstant(Float.class, Float.valueOf(value));
  }
  
  public void to(short value)
  {
    toConstant(Short.class, Short.valueOf(value));
  }
  
  public void to(char value)
  {
    toConstant(Character.class, Character.valueOf(value));
  }
  
  public void to(byte value)
  {
    toConstant(Byte.class, Byte.valueOf(value));
  }
  
  public void to(Class<?> value)
  {
    toConstant(Class.class, value);
  }
  
  public <E extends Enum<E>> void to(E value)
  {
    toConstant(value.getDeclaringClass(), value);
  }
  
  private void toConstant(Class<?> type, Object instance)
  {
    Class<T> typeAsClassT = type;
    
    T instanceAsT = (T)instance;
    if (keyTypeIsSet())
    {
      binder.addError("Constant value is set more than once.", new Object[0]);
      return;
    }
    BindingImpl<T> base = getBinding();
    Key<T> key;
    Key<T> key;
    if (base.getKey().getAnnotation() != null)
    {
      key = Key.get(typeAsClassT, base.getKey().getAnnotation());
    }
    else
    {
      Key<T> key;
      if (base.getKey().getAnnotationType() != null) {
        key = Key.get(typeAsClassT, base.getKey().getAnnotationType());
      } else {
        key = Key.get(typeAsClassT);
      }
    }
    if (instanceAsT == null) {
      binder.addError("Binding to null instances is not allowed. Use toProvider(Providers.of(null)) if this is your intended behaviour.", new Object[0]);
    }
    setBinding(new InstanceBindingImpl(base.getSource(), key, base.getScoping(), .ImmutableSet.of(), instanceAsT));
  }
  
  public String toString()
  {
    return "ConstantBindingBuilder";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstantBindingBuilderImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */