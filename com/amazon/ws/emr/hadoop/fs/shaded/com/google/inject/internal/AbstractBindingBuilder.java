package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InstanceBinding;
import java.lang.annotation.Annotation;
import java.util.List;

public abstract class AbstractBindingBuilder<T>
{
  public static final String IMPLEMENTATION_ALREADY_SET = "Implementation is set more than once.";
  public static final String SINGLE_INSTANCE_AND_SCOPE = "Setting the scope is not permitted when binding to a single instance.";
  public static final String SCOPE_ALREADY_SET = "Scope is set more than once.";
  public static final String BINDING_TO_NULL = "Binding to null instances is not allowed. Use toProvider(Providers.of(null)) if this is your intended behaviour.";
  public static final String CONSTANT_VALUE_ALREADY_SET = "Constant value is set more than once.";
  public static final String ANNOTATION_ALREADY_SPECIFIED = "More than one annotation is specified for this binding.";
  protected static final Key<?> NULL_KEY = Key.get(Void.class);
  protected List<Element> elements;
  protected int position;
  protected final Binder binder;
  private BindingImpl<T> binding;
  
  public AbstractBindingBuilder(Binder binder, List<Element> elements, Object source, Key<T> key)
  {
    this.binder = binder;
    this.elements = elements;
    position = elements.size();
    binding = new UntargettedBindingImpl(source, key, Scoping.UNSCOPED);
    elements.add(position, binding);
  }
  
  protected BindingImpl<T> getBinding()
  {
    return binding;
  }
  
  protected BindingImpl<T> setBinding(BindingImpl<T> binding)
  {
    this.binding = binding;
    elements.set(position, binding);
    return binding;
  }
  
  protected BindingImpl<T> annotatedWithInternal(Class<? extends Annotation> annotationType)
  {
    .Preconditions.checkNotNull(annotationType, "annotationType");
    checkNotAnnotated();
    return setBinding(binding.withKey(Key.get(binding.getKey().getTypeLiteral(), annotationType)));
  }
  
  protected BindingImpl<T> annotatedWithInternal(Annotation annotation)
  {
    .Preconditions.checkNotNull(annotation, "annotation");
    checkNotAnnotated();
    return setBinding(binding.withKey(Key.get(binding.getKey().getTypeLiteral(), annotation)));
  }
  
  public void in(Class<? extends Annotation> scopeAnnotation)
  {
    .Preconditions.checkNotNull(scopeAnnotation, "scopeAnnotation");
    checkNotScoped();
    setBinding(getBinding().withScoping(Scoping.forAnnotation(scopeAnnotation)));
  }
  
  public void in(Scope scope)
  {
    .Preconditions.checkNotNull(scope, "scope");
    checkNotScoped();
    setBinding(getBinding().withScoping(Scoping.forInstance(scope)));
  }
  
  public void asEagerSingleton()
  {
    checkNotScoped();
    setBinding(getBinding().withScoping(Scoping.EAGER_SINGLETON));
  }
  
  protected boolean keyTypeIsSet()
  {
    return !Void.class.equals(binding.getKey().getTypeLiteral().getType());
  }
  
  protected void checkNotTargetted()
  {
    if (!(binding instanceof UntargettedBindingImpl)) {
      binder.addError("Implementation is set more than once.", new Object[0]);
    }
  }
  
  protected void checkNotAnnotated()
  {
    if (binding.getKey().getAnnotationType() != null) {
      binder.addError("More than one annotation is specified for this binding.", new Object[0]);
    }
  }
  
  protected void checkNotScoped()
  {
    if ((binding instanceof InstanceBinding))
    {
      binder.addError("Setting the scope is not permitted when binding to a single instance.", new Object[0]);
      return;
    }
    if (binding.getScoping().isExplicitlyScoped()) {
      binder.addError("Scope is set more than once.", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.AbstractBindingBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */