package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Classes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ConstructorBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.aopalliance.intercept.MethodInterceptor;

final class ConstructorBindingImpl<T>
  extends BindingImpl<T>
  implements ConstructorBinding<T>
{
  private final Factory<T> factory;
  private final InjectionPoint constructorInjectionPoint;
  
  private ConstructorBindingImpl(InjectorImpl injector, Key<T> key, Object source, InternalFactory<? extends T> scopedFactory, Scoping scoping, Factory<T> factory, InjectionPoint constructorInjectionPoint)
  {
    super(injector, key, source, scopedFactory, scoping);
    this.factory = factory;
    this.constructorInjectionPoint = constructorInjectionPoint;
  }
  
  public ConstructorBindingImpl(Key<T> key, Object source, Scoping scoping, InjectionPoint constructorInjectionPoint, Set<InjectionPoint> injectionPoints)
  {
    super(source, key, scoping);
    factory = new Factory(false, key);
    ConstructionProxy<T> constructionProxy = new DefaultConstructionProxyFactory(constructorInjectionPoint).create();
    
    this.constructorInjectionPoint = constructorInjectionPoint;
    factory.constructorInjector = new ConstructorInjector(injectionPoints, constructionProxy, null, null);
  }
  
  static <T> ConstructorBindingImpl<T> create(InjectorImpl injector, Key<T> key, InjectionPoint constructorInjector, Object source, Scoping scoping, Errors errors, boolean failIfNotLinked)
    throws ErrorsException
  {
    int numErrors = errors.size();
    
    Class<? super T> rawType = constructorInjector == null ? key.getTypeLiteral().getRawType() : constructorInjector.getDeclaringType().getRawType();
    if (Modifier.isAbstract(rawType.getModifiers())) {
      errors.missingImplementation(key);
    }
    if (.Classes.isInnerClass(rawType)) {
      errors.cannotInjectInnerClass(rawType);
    }
    errors.throwIfNewErrors(numErrors);
    if (constructorInjector == null) {
      try
      {
        constructorInjector = InjectionPoint.forConstructorOf(key.getTypeLiteral());
      }
      catch (ConfigurationException e)
      {
        throw errors.merge(e.getErrorMessages()).toException();
      }
    }
    if (!scoping.isExplicitlyScoped())
    {
      Class<?> annotatedType = constructorInjector.getMember().getDeclaringClass();
      Class<? extends Annotation> scopeAnnotation = Annotations.findScopeAnnotation(errors, annotatedType);
      if (scopeAnnotation != null) {
        scoping = Scoping.makeInjectable(Scoping.forAnnotation(scopeAnnotation), injector, errors.withSource(rawType));
      }
    }
    errors.throwIfNewErrors(numErrors);
    
    Factory<T> factoryFactory = new Factory(failIfNotLinked, key);
    InternalFactory<? extends T> scopedFactory = Scoping.scope(key, injector, factoryFactory, source, scoping);
    
    return new ConstructorBindingImpl(injector, key, source, scopedFactory, scoping, factoryFactory, constructorInjector);
  }
  
  public void initialize(InjectorImpl injector, Errors errors)
    throws ErrorsException
  {
    factory.allowCircularProxy = (!options.disableCircularProxies);
    factory.constructorInjector = constructors.get(constructorInjectionPoint, errors);
  }
  
  boolean isInitialized()
  {
    return factory.constructorInjector != null;
  }
  
  InjectionPoint getInternalConstructor()
  {
    if (factory.constructorInjector != null) {
      return factory.constructorInjector.getConstructionProxy().getInjectionPoint();
    }
    return constructorInjectionPoint;
  }
  
  Set<Dependency<?>> getInternalDependencies()
  {
    .ImmutableSet.Builder<InjectionPoint> builder = .ImmutableSet.builder();
    if (factory.constructorInjector == null)
    {
      builder.add(constructorInjectionPoint);
      try
      {
        builder.addAll(InjectionPoint.forInstanceMethodsAndFields(constructorInjectionPoint.getDeclaringType()));
      }
      catch (ConfigurationException ignored) {}
    }
    else
    {
      builder.add(getConstructor()).addAll(getInjectableMembers());
    }
    return Dependency.forInjectionPoints(builder.build());
  }
  
  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
  {
    .Preconditions.checkState(factory.constructorInjector != null, "not initialized");
    return (V)visitor.visit(this);
  }
  
  public InjectionPoint getConstructor()
  {
    .Preconditions.checkState(factory.constructorInjector != null, "Binding is not ready");
    return factory.constructorInjector.getConstructionProxy().getInjectionPoint();
  }
  
  public Set<InjectionPoint> getInjectableMembers()
  {
    .Preconditions.checkState(factory.constructorInjector != null, "Binding is not ready");
    return factory.constructorInjector.getInjectableMembers();
  }
  
  public Map<Method, List<MethodInterceptor>> getMethodInterceptors()
  {
    .Preconditions.checkState(factory.constructorInjector != null, "Binding is not ready");
    return factory.constructorInjector.getConstructionProxy().getMethodInterceptors();
  }
  
  public Set<Dependency<?>> getDependencies()
  {
    return Dependency.forInjectionPoints(new .ImmutableSet.Builder().add(getConstructor()).addAll(getInjectableMembers()).build());
  }
  
  protected BindingImpl<T> withScoping(Scoping scoping)
  {
    return new ConstructorBindingImpl(null, getKey(), getSource(), factory, scoping, factory, constructorInjectionPoint);
  }
  
  protected BindingImpl<T> withKey(Key<T> key)
  {
    return new ConstructorBindingImpl(null, key, getSource(), factory, getScoping(), factory, constructorInjectionPoint);
  }
  
  public void applyTo(Binder binder)
  {
    InjectionPoint constructor = getConstructor();
    getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).toConstructor((Constructor)getConstructor().getMember(), constructor.getDeclaringType()));
  }
  
  public String toString()
  {
    return new .ToStringBuilder(ConstructorBinding.class).add("key", getKey()).add("source", getSource()).add("scope", getScoping()).toString();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof ConstructorBindingImpl))
    {
      ConstructorBindingImpl<?> o = (ConstructorBindingImpl)obj;
      return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(constructorInjectionPoint, constructorInjectionPoint));
    }
    return false;
  }
  
  public int hashCode()
  {
    return .Objects.hashCode(new Object[] { getKey(), getScoping(), constructorInjectionPoint });
  }
  
  private static class Factory<T>
    implements InternalFactory<T>
  {
    private final boolean failIfNotLinked;
    private final Key<?> key;
    private boolean allowCircularProxy;
    private ConstructorInjector<T> constructorInjector;
    
    Factory(boolean failIfNotLinked, Key<?> key)
    {
      this.failIfNotLinked = failIfNotLinked;
      this.key = key;
    }
    
    public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
      throws ErrorsException
    {
      .Preconditions.checkState(constructorInjector != null, "Constructor not ready");
      if ((failIfNotLinked) && (!linked)) {
        throw errors.jitDisabled(key).toException();
      }
      return (T)constructorInjector.construct(errors, context, dependency.getKey().getTypeLiteral().getRawType(), allowCircularProxy);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstructorBindingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */