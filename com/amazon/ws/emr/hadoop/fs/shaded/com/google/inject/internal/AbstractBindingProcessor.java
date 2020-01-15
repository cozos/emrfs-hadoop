package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.AbstractModule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DefaultBindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import java.util.Map;
import java.util.Set;

abstract class AbstractBindingProcessor
  extends AbstractProcessor
{
  private static final Set<Class<?>> FORBIDDEN_TYPES = .ImmutableSet.of(new Class[] { AbstractModule.class, Binder.class, Binding.class, Injector.class, Key.class, MembersInjector.class, Module.class, Provider.class, Scope.class, TypeLiteral.class });
  protected final ProcessedBindingData bindingData;
  
  AbstractBindingProcessor(Errors errors, ProcessedBindingData bindingData)
  {
    super(errors);
    this.bindingData = bindingData;
  }
  
  protected <T> UntargettedBindingImpl<T> invalidBinding(InjectorImpl injector, Key<T> key, Object source)
  {
    return new UntargettedBindingImpl(injector, key, source);
  }
  
  protected void putBinding(BindingImpl<?> binding)
  {
    Key<?> key = binding.getKey();
    
    Class<?> rawType = key.getTypeLiteral().getRawType();
    if (FORBIDDEN_TYPES.contains(rawType))
    {
      errors.cannotBindToGuiceType(rawType.getSimpleName());
      return;
    }
    BindingImpl<?> original = injector.getExistingBinding(key);
    if (original != null)
    {
      if (injector.state.getExplicitBinding(key) != null) {
        try
        {
          if (!isOkayDuplicate(original, binding, injector.state))
          {
            errors.bindingAlreadySet(key, original.getSource());
            return;
          }
        }
        catch (Throwable t)
        {
          errors.errorCheckingDuplicateBinding(key, original.getSource(), t);
          return;
        }
      }
      errors.jitBindingAlreadySet(key);
      return;
    }
    injector.state.parent().blacklist(key, binding.getSource());
    injector.state.putBinding(key, binding);
  }
  
  private boolean isOkayDuplicate(BindingImpl<?> original, BindingImpl<?> binding, State state)
  {
    if ((original instanceof ExposedBindingImpl))
    {
      ExposedBindingImpl exposed = (ExposedBindingImpl)original;
      InjectorImpl exposedFrom = (InjectorImpl)exposed.getPrivateElements().getInjector();
      return exposedFrom == binding.getInjector();
    }
    original = (BindingImpl)state.getExplicitBindingsThisLevel().get(binding.getKey());
    if (original == null) {
      return false;
    }
    return original.equals(binding);
  }
  
  private <T> void validateKey(Object source, Key<T> key)
  {
    Annotations.checkForMisplacedScopeAnnotations(key.getTypeLiteral().getRawType(), source, errors);
  }
  
  abstract class Processor<T, V>
    extends DefaultBindingTargetVisitor<T, V>
  {
    final Object source;
    final Key<T> key;
    final Class<? super T> rawType;
    Scoping scoping;
    
    Processor()
    {
      source = binding.getSource();
      key = binding.getKey();
      rawType = key.getTypeLiteral().getRawType();
      scoping = binding.getScoping();
    }
    
    protected void prepareBinding()
    {
      AbstractBindingProcessor.this.validateKey(source, key);
      scoping = Scoping.makeInjectable(scoping, injector, errors);
    }
    
    protected void scheduleInitialization(final BindingImpl<?> binding)
    {
      bindingData.addUninitializedBinding(new Runnable()
      {
        public void run()
        {
          try
          {
            binding.getInjector().initializeBinding(binding, errors.withSource(source));
          }
          catch (ErrorsException e)
          {
            errors.merge(e.getErrors());
          }
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.AbstractBindingProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */