package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ScopedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Set;

public class BindingBuilder<T>
  extends AbstractBindingBuilder<T>
  implements AnnotatedBindingBuilder<T>
{
  public BindingBuilder(Binder binder, List<Element> elements, Object source, Key<T> key)
  {
    super(binder, elements, source, key);
  }
  
  public BindingBuilder<T> annotatedWith(Class<? extends Annotation> annotationType)
  {
    annotatedWithInternal(annotationType);
    return this;
  }
  
  public BindingBuilder<T> annotatedWith(Annotation annotation)
  {
    annotatedWithInternal(annotation);
    return this;
  }
  
  public BindingBuilder<T> to(Class<? extends T> implementation)
  {
    return to(Key.get(implementation));
  }
  
  public BindingBuilder<T> to(TypeLiteral<? extends T> implementation)
  {
    return to(Key.get(implementation));
  }
  
  public BindingBuilder<T> to(Key<? extends T> linkedKey)
  {
    .Preconditions.checkNotNull(linkedKey, "linkedKey");
    checkNotTargetted();
    BindingImpl<T> base = getBinding();
    setBinding(new LinkedBindingImpl(base.getSource(), base.getKey(), base.getScoping(), linkedKey));
    
    return this;
  }
  
  public void toInstance(T instance)
  {
    checkNotTargetted();
    Set<InjectionPoint> injectionPoints;
    if (instance != null)
    {
      try
      {
        injectionPoints = InjectionPoint.forInstanceMethodsAndFields(instance.getClass());
      }
      catch (ConfigurationException e)
      {
        copyErrorsToBinder(e);
        Set<InjectionPoint> injectionPoints = (Set)e.getPartialValue();
      }
    }
    else
    {
      binder.addError("Binding to null instances is not allowed. Use toProvider(Providers.of(null)) if this is your intended behaviour.", new Object[0]);
      injectionPoints = .ImmutableSet.of();
    }
    BindingImpl<T> base = getBinding();
    setBinding(new InstanceBindingImpl(base.getSource(), base.getKey(), Scoping.EAGER_SINGLETON, injectionPoints, instance));
  }
  
  public BindingBuilder<T> toProvider(com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider<? extends T> provider)
  {
    .Preconditions.checkNotNull(provider, "provider");
    checkNotTargetted();
    Set<InjectionPoint> injectionPoints;
    try
    {
      injectionPoints = InjectionPoint.forInstanceMethodsAndFields(provider.getClass());
    }
    catch (ConfigurationException e)
    {
      copyErrorsToBinder(e);
      injectionPoints = (Set)e.getPartialValue();
    }
    BindingImpl<T> base = getBinding();
    setBinding(new ProviderInstanceBindingImpl(base.getSource(), base.getKey(), base.getScoping(), injectionPoints, provider));
    
    return this;
  }
  
  public BindingBuilder<T> toProvider(Class<? extends javax.inject.Provider<? extends T>> providerType)
  {
    return toProvider(Key.get(providerType));
  }
  
  public BindingBuilder<T> toProvider(TypeLiteral<? extends javax.inject.Provider<? extends T>> providerType)
  {
    return toProvider(Key.get(providerType));
  }
  
  public BindingBuilder<T> toProvider(Key<? extends javax.inject.Provider<? extends T>> providerKey)
  {
    .Preconditions.checkNotNull(providerKey, "providerKey");
    checkNotTargetted();
    
    BindingImpl<T> base = getBinding();
    setBinding(new LinkedProviderBindingImpl(base.getSource(), base.getKey(), base.getScoping(), providerKey));
    
    return this;
  }
  
  public <S extends T> ScopedBindingBuilder toConstructor(Constructor<S> constructor)
  {
    return toConstructor(constructor, TypeLiteral.get(constructor.getDeclaringClass()));
  }
  
  public <S extends T> ScopedBindingBuilder toConstructor(Constructor<S> constructor, TypeLiteral<? extends S> type)
  {
    .Preconditions.checkNotNull(constructor, "constructor");
    .Preconditions.checkNotNull(type, "type");
    checkNotTargetted();
    
    BindingImpl<T> base = getBinding();
    Set<InjectionPoint> injectionPoints;
    try
    {
      injectionPoints = InjectionPoint.forInstanceMethodsAndFields(type);
    }
    catch (ConfigurationException e)
    {
      copyErrorsToBinder(e);
      injectionPoints = (Set)e.getPartialValue();
    }
    try
    {
      InjectionPoint constructorPoint = InjectionPoint.forConstructor(constructor, type);
      setBinding(new ConstructorBindingImpl(base.getKey(), base.getSource(), base.getScoping(), constructorPoint, injectionPoints));
    }
    catch (ConfigurationException e)
    {
      copyErrorsToBinder(e);
    }
    return this;
  }
  
  public String toString()
  {
    return "BindingBuilder<" + getBinding().getKey().getTypeLiteral() + ">";
  }
  
  private void copyErrorsToBinder(ConfigurationException e)
  {
    for (Message message : e.getErrorMessages()) {
      binder.addError(message);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BindingBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */