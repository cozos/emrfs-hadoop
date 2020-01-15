package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Stopwatch;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class InternalInjectorCreator
{
  private final .Stopwatch stopwatch = new .Stopwatch();
  private final Errors errors = new Errors();
  private final Initializer initializer = new Initializer();
  private final ProcessedBindingData bindingData;
  private final InjectionRequestProcessor injectionRequestProcessor;
  private final InjectorShell.Builder shellBuilder = new InjectorShell.Builder();
  private List<InjectorShell> shells;
  
  public InternalInjectorCreator()
  {
    injectionRequestProcessor = new InjectionRequestProcessor(errors, initializer);
    bindingData = new ProcessedBindingData();
  }
  
  public InternalInjectorCreator stage(Stage stage)
  {
    shellBuilder.stage(stage);
    return this;
  }
  
  public InternalInjectorCreator parentInjector(InjectorImpl parent)
  {
    shellBuilder.parent(parent);
    return this;
  }
  
  public InternalInjectorCreator addModules(Iterable<? extends Module> modules)
  {
    shellBuilder.addModules(modules);
    return this;
  }
  
  public Injector build()
  {
    if (shellBuilder == null) {
      throw new AssertionError("Already built, builders are not reusable.");
    }
    synchronized (shellBuilder.lock())
    {
      shells = shellBuilder.build(initializer, bindingData, stopwatch, errors);
      stopwatch.resetAndLog("Injector construction");
      
      initializeStatically();
    }
    injectDynamically();
    if (shellBuilder.getStage() == Stage.TOOL) {
      return new ToolStageInjector(primaryInjector());
    }
    return primaryInjector();
  }
  
  private void initializeStatically()
  {
    bindingData.initializeBindings();
    stopwatch.resetAndLog("Binding initialization");
    for (InjectorShell shell : shells) {
      shell.getInjector().index();
    }
    stopwatch.resetAndLog("Binding indexing");
    
    injectionRequestProcessor.process(shells);
    stopwatch.resetAndLog("Collecting injection requests");
    
    bindingData.runCreationListeners(errors);
    stopwatch.resetAndLog("Binding validation");
    
    injectionRequestProcessor.validate();
    stopwatch.resetAndLog("Static validation");
    
    initializer.validateOustandingInjections(errors);
    stopwatch.resetAndLog("Instance member validation");
    
    new LookupProcessor(errors).process(shells);
    for (InjectorShell shell : shells) {
      ((DeferredLookups)getInjectorlookups).initialize(errors);
    }
    stopwatch.resetAndLog("Provider verification");
    for (InjectorShell shell : shells) {
      if (!shell.getElements().isEmpty()) {
        throw new AssertionError("Failed to execute " + shell.getElements());
      }
    }
    errors.throwCreationExceptionIfErrorsExist();
  }
  
  private Injector primaryInjector()
  {
    return ((InjectorShell)shells.get(0)).getInjector();
  }
  
  private void injectDynamically()
  {
    injectionRequestProcessor.injectMembers();
    stopwatch.resetAndLog("Static member injection");
    
    initializer.injectAll(errors);
    stopwatch.resetAndLog("Instance injection");
    errors.throwCreationExceptionIfErrorsExist();
    if (shellBuilder.getStage() != Stage.TOOL)
    {
      for (InjectorShell shell : shells) {
        loadEagerSingletons(shell.getInjector(), shellBuilder.getStage(), errors);
      }
      stopwatch.resetAndLog("Preloading singletons");
    }
    errors.throwCreationExceptionIfErrorsExist();
  }
  
  void loadEagerSingletons(InjectorImpl injector, Stage stage, final Errors errors)
  {
    Iterable<BindingImpl<?>> candidateBindings = .ImmutableList.copyOf(.Iterables.concat(state.getExplicitBindingsThisLevel().values(), jitBindings.values()));
    for (final BindingImpl<?> binding : candidateBindings) {
      if (isEagerSingleton(injector, binding, stage)) {
        try
        {
          injector.callInContext(new ContextualCallable()
          {
            Dependency<?> dependency = Dependency.get(binding.getKey());
            
            public Void call(InternalContext context)
            {
              Dependency previous = context.setDependency(dependency);
              Errors errorsForBinding = errors.withSource(dependency);
              try
              {
                binding.getInternalFactory().get(errorsForBinding, context, dependency, false);
              }
              catch (ErrorsException e)
              {
                errorsForBinding.merge(e.getErrors());
              }
              finally
              {
                context.setDependency(previous);
              }
              return null;
            }
          });
        }
        catch (ErrorsException e)
        {
          throw new AssertionError();
        }
      }
    }
  }
  
  private boolean isEagerSingleton(InjectorImpl injector, BindingImpl<?> binding, Stage stage)
  {
    if (binding.getScoping().isEagerSingleton(stage)) {
      return true;
    }
    if ((binding instanceof LinkedBindingImpl))
    {
      Key<?> linkedBinding = ((LinkedBindingImpl)binding).getLinkedKey();
      return isEagerSingleton(injector, injector.getBinding(linkedBinding), stage);
    }
    return false;
  }
  
  static class ToolStageInjector
    implements Injector
  {
    private final Injector delegateInjector;
    
    ToolStageInjector(Injector delegateInjector)
    {
      this.delegateInjector = delegateInjector;
    }
    
    public void injectMembers(Object o)
    {
      throw new UnsupportedOperationException("Injector.injectMembers(Object) is not supported in Stage.TOOL");
    }
    
    public Map<Key<?>, Binding<?>> getBindings()
    {
      return delegateInjector.getBindings();
    }
    
    public Map<Key<?>, Binding<?>> getAllBindings()
    {
      return delegateInjector.getAllBindings();
    }
    
    public <T> Binding<T> getBinding(Key<T> key)
    {
      return delegateInjector.getBinding(key);
    }
    
    public <T> Binding<T> getBinding(Class<T> type)
    {
      return delegateInjector.getBinding(type);
    }
    
    public <T> Binding<T> getExistingBinding(Key<T> key)
    {
      return delegateInjector.getExistingBinding(key);
    }
    
    public <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> type)
    {
      return delegateInjector.findBindingsByType(type);
    }
    
    public Injector getParent()
    {
      return delegateInjector.getParent();
    }
    
    public Injector createChildInjector(Iterable<? extends Module> modules)
    {
      return delegateInjector.createChildInjector(modules);
    }
    
    public Injector createChildInjector(Module... modules)
    {
      return delegateInjector.createChildInjector(modules);
    }
    
    public Map<Class<? extends Annotation>, Scope> getScopeBindings()
    {
      return delegateInjector.getScopeBindings();
    }
    
    public Set<TypeConverterBinding> getTypeConverterBindings()
    {
      return delegateInjector.getTypeConverterBindings();
    }
    
    public <T> Provider<T> getProvider(Key<T> key)
    {
      throw new UnsupportedOperationException("Injector.getProvider(Key<T>) is not supported in Stage.TOOL");
    }
    
    public <T> Provider<T> getProvider(Class<T> type)
    {
      throw new UnsupportedOperationException("Injector.getProvider(Class<T>) is not supported in Stage.TOOL");
    }
    
    public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral)
    {
      throw new UnsupportedOperationException("Injector.getMembersInjector(TypeLiteral<T>) is not supported in Stage.TOOL");
    }
    
    public <T> MembersInjector<T> getMembersInjector(Class<T> type)
    {
      throw new UnsupportedOperationException("Injector.getMembersInjector(Class<T>) is not supported in Stage.TOOL");
    }
    
    public <T> T getInstance(Key<T> key)
    {
      throw new UnsupportedOperationException("Injector.getInstance(Key<T>) is not supported in Stage.TOOL");
    }
    
    public <T> T getInstance(Class<T> type)
    {
      throw new UnsupportedOperationException("Injector.getInstance(Class<T>) is not supported in Stage.TOOL");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InternalInjectorCreator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */