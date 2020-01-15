package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Stopwatch;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Element;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Elements;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListenerBinding;
import java.util.List;

class InjectorShell$Builder
{
  private final List<Element> elements = .Lists.newArrayList();
  private final List<Module> modules = .Lists.newArrayList();
  private State state;
  private InjectorImpl parent;
  private InjectorImpl.InjectorOptions options;
  private Stage stage;
  private PrivateElementsImpl privateElements;
  
  Builder stage(Stage stage)
  {
    this.stage = stage;
    return this;
  }
  
  Builder parent(InjectorImpl parent)
  {
    this.parent = parent;
    state = new InheritingState(state);
    options = options;
    stage = options.stage;
    return this;
  }
  
  Builder privateElements(PrivateElements privateElements)
  {
    this.privateElements = ((PrivateElementsImpl)privateElements);
    elements.addAll(privateElements.getElements());
    return this;
  }
  
  void addModules(Iterable<? extends Module> modules)
  {
    for (Module module : modules) {
      this.modules.add(module);
    }
  }
  
  Stage getStage()
  {
    return options.stage;
  }
  
  Object lock()
  {
    return getState().lock();
  }
  
  List<InjectorShell> build(Initializer initializer, ProcessedBindingData bindingData, .Stopwatch stopwatch, Errors errors)
  {
    .Preconditions.checkState(stage != null, "Stage not initialized");
    .Preconditions.checkState((privateElements == null) || (parent != null), "PrivateElements with no parent");
    .Preconditions.checkState(state != null, "no state. Did you remember to lock() ?");
    if (parent == null) {
      modules.add(0, new InjectorShell.RootModule(stage, null));
    }
    elements.addAll(Elements.getElements(stage, modules));
    
    InjectorOptionsProcessor optionsProcessor = new InjectorOptionsProcessor(errors);
    optionsProcessor.process(null, elements);
    options = optionsProcessor.getOptions(stage, options);
    
    InjectorImpl injector = new InjectorImpl(parent, state, options);
    if (privateElements != null) {
      privateElements.initInjector(injector);
    }
    if (parent == null) {
      new TypeConverterBindingProcessor(errors).prepareBuiltInConverters(injector);
    }
    stopwatch.resetAndLog("Module execution");
    
    new MessageProcessor(errors).process(injector, elements);
    
    InterceptorBindingProcessor interceptors = new InterceptorBindingProcessor(errors);
    interceptors.process(injector, elements);
    stopwatch.resetAndLog("Interceptors creation");
    
    new TypeListenerBindingProcessor(errors).process(injector, elements);
    List<TypeListenerBinding> listenerBindings = state.getTypeListenerBindings();
    membersInjectorStore = new MembersInjectorStore(injector, listenerBindings);
    stopwatch.resetAndLog("TypeListeners creation");
    
    new ScopeBindingProcessor(errors).process(injector, elements);
    stopwatch.resetAndLog("Scopes creation");
    
    new TypeConverterBindingProcessor(errors).process(injector, elements);
    stopwatch.resetAndLog("Converters creation");
    
    InjectorShell.access$100(injector);
    InjectorShell.access$200(injector);
    
    new BindingProcessor(errors, initializer, bindingData).process(injector, elements);
    new UntargettedBindingProcessor(errors, bindingData).process(injector, elements);
    stopwatch.resetAndLog("Binding creation");
    
    List<InjectorShell> injectorShells = .Lists.newArrayList();
    injectorShells.add(new InjectorShell(this, elements, injector, null));
    
    PrivateElementProcessor processor = new PrivateElementProcessor(errors);
    processor.process(injector, elements);
    for (Builder builder : processor.getInjectorShellBuilders()) {
      injectorShells.addAll(builder.build(initializer, bindingData, stopwatch, errors));
    }
    stopwatch.resetAndLog("Private environment creation");
    
    return injectorShells;
  }
  
  private State getState()
  {
    if (state == null) {
      state = new InheritingState(State.NONE);
    }
    return state;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorShell.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */