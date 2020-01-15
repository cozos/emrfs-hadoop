package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ConstructorBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ConvertedConstantBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ExposedBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InstanceBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.LinkedKeyBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderInstanceBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderKeyBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.UntargettedBinding;
import java.util.Set;

class BindingProcessor$1
  extends AbstractBindingProcessor.Processor<T, Boolean>
{
  BindingProcessor$1(BindingProcessor paramBindingProcessor, BindingImpl x0)
  {
    super(paramBindingProcessor, x0);
  }
  
  public Boolean visit(ConstructorBinding<? extends T> binding)
  {
    prepareBinding();
    try
    {
      ConstructorBindingImpl<T> onInjector = ConstructorBindingImpl.create(this$0.injector, key, binding.getConstructor(), source, scoping, this$0.errors, false);
      
      scheduleInitialization(onInjector);
      this$0.putBinding(onInjector);
    }
    catch (ErrorsException e)
    {
      this$0.errors.merge(e.getErrors());
      this$0.putBinding(this$0.invalidBinding(this$0.injector, key, source));
    }
    return Boolean.valueOf(true);
  }
  
  public Boolean visit(InstanceBinding<? extends T> binding)
  {
    prepareBinding();
    Set<InjectionPoint> injectionPoints = binding.getInjectionPoints();
    T instance = binding.getInstance();
    Initializable<T> ref = BindingProcessor.access$000(this$0).requestInjection(this$0.injector, instance, source, injectionPoints);
    
    ConstantFactory<? extends T> factory = new ConstantFactory(ref);
    InternalFactory<? extends T> scopedFactory = Scoping.scope(key, this$0.injector, factory, source, scoping);
    
    this$0.putBinding(new InstanceBindingImpl(this$0.injector, key, source, scopedFactory, injectionPoints, instance));
    
    return Boolean.valueOf(true);
  }
  
  public Boolean visit(ProviderInstanceBinding<? extends T> binding)
  {
    prepareBinding();
    com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider<? extends T> provider = binding.getProviderInstance();
    Set<InjectionPoint> injectionPoints = binding.getInjectionPoints();
    Initializable<com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider<? extends T>> initializable = BindingProcessor.access$000(this$0).requestInjection(this$0.injector, provider, source, injectionPoints);
    
    InternalFactory<T> factory = new InternalFactoryToProviderAdapter(initializable, source);
    InternalFactory<? extends T> scopedFactory = Scoping.scope(key, this$0.injector, factory, source, scoping);
    
    this$0.putBinding(new ProviderInstanceBindingImpl(this$0.injector, key, source, scopedFactory, scoping, provider, injectionPoints));
    
    return Boolean.valueOf(true);
  }
  
  public Boolean visit(ProviderKeyBinding<? extends T> binding)
  {
    prepareBinding();
    Key<? extends javax.inject.Provider<? extends T>> providerKey = binding.getProviderKey();
    BoundProviderFactory<T> boundProviderFactory = new BoundProviderFactory(this$0.injector, providerKey, source);
    
    this$0.bindingData.addCreationListener(boundProviderFactory);
    InternalFactory<? extends T> scopedFactory = Scoping.scope(key, this$0.injector, boundProviderFactory, source, scoping);
    
    this$0.putBinding(new LinkedProviderBindingImpl(this$0.injector, key, source, scopedFactory, scoping, providerKey));
    
    return Boolean.valueOf(true);
  }
  
  public Boolean visit(LinkedKeyBinding<? extends T> binding)
  {
    prepareBinding();
    Key<? extends T> linkedKey = binding.getLinkedKey();
    if (key.equals(linkedKey)) {
      this$0.errors.recursiveBinding();
    }
    FactoryProxy<T> factory = new FactoryProxy(this$0.injector, key, linkedKey, source);
    this$0.bindingData.addCreationListener(factory);
    InternalFactory<? extends T> scopedFactory = Scoping.scope(key, this$0.injector, factory, source, scoping);
    
    this$0.putBinding(new LinkedBindingImpl(this$0.injector, key, source, scopedFactory, scoping, linkedKey));
    
    return Boolean.valueOf(true);
  }
  
  public Boolean visit(UntargettedBinding<? extends T> untargetted)
  {
    return Boolean.valueOf(false);
  }
  
  public Boolean visit(ExposedBinding<? extends T> binding)
  {
    throw new IllegalArgumentException("Cannot apply a non-module element");
  }
  
  public Boolean visit(ConvertedConstantBinding<? extends T> binding)
  {
    throw new IllegalArgumentException("Cannot apply a non-module element");
  }
  
  public Boolean visit(ProviderBinding<? extends T> binding)
  {
    throw new IllegalArgumentException("Cannot apply a non-module element");
  }
  
  protected Boolean visitOther(Binding<? extends T> binding)
  {
    throw new IllegalStateException("BindingProcessor should override all visitations");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BindingProcessor.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */