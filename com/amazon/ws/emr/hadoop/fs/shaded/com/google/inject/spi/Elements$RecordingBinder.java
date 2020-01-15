package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.AbstractModule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.PrivateBinder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.PrivateModule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedElementBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.AbstractBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ConstantBindingBuilderImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ExposureBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.PrivateElementsImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProviderMethodsModule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Sets;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..SourceProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matcher;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.aopalliance.intercept.MethodInterceptor;

class Elements$RecordingBinder
  implements Binder, PrivateBinder
{
  private final Stage stage;
  private final Set<Module> modules;
  private final List<Element> elements;
  private final Object source;
  private final .SourceProvider sourceProvider;
  private final RecordingBinder parent;
  private final PrivateElementsImpl privateElements;
  
  private Elements$RecordingBinder(Stage stage)
  {
    this.stage = stage;
    modules = .Sets.newHashSet();
    elements = .Lists.newArrayList();
    source = null;
    sourceProvider = .SourceProvider.DEFAULT_INSTANCE.plusSkippedClasses(new Class[] { Elements.class, RecordingBinder.class, AbstractModule.class, ConstantBindingBuilderImpl.class, AbstractBindingBuilder.class, BindingBuilder.class });
    
    parent = null;
    privateElements = null;
  }
  
  private Elements$RecordingBinder(RecordingBinder prototype, Object source, .SourceProvider sourceProvider)
  {
    .Preconditions.checkArgument((source == null ? 1 : 0) ^ (sourceProvider == null ? 1 : 0));
    
    stage = stage;
    modules = modules;
    elements = elements;
    this.source = source;
    this.sourceProvider = sourceProvider;
    parent = parent;
    privateElements = privateElements;
  }
  
  private Elements$RecordingBinder(RecordingBinder parent, PrivateElementsImpl privateElements)
  {
    stage = stage;
    modules = .Sets.newHashSet();
    elements = privateElements.getElementsMutable();
    source = source;
    sourceProvider = sourceProvider;
    this.parent = parent;
    this.privateElements = privateElements;
  }
  
  public void bindInterceptor(Matcher<? super Class<?>> classMatcher, Matcher<? super Method> methodMatcher, MethodInterceptor... interceptors)
  {
    elements.add(new InterceptorBinding(getSource(), classMatcher, methodMatcher, interceptors));
  }
  
  public void bindScope(Class<? extends Annotation> annotationType, Scope scope)
  {
    elements.add(new ScopeBinding(getSource(), annotationType, scope));
  }
  
  public void requestInjection(Object instance)
  {
    requestInjection(TypeLiteral.get(instance.getClass()), instance);
  }
  
  public <T> void requestInjection(TypeLiteral<T> type, T instance)
  {
    elements.add(new InjectionRequest(getSource(), type, instance));
  }
  
  public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral)
  {
    MembersInjectorLookup<T> element = new MembersInjectorLookup(getSource(), typeLiteral);
    
    elements.add(element);
    return element.getMembersInjector();
  }
  
  public <T> MembersInjector<T> getMembersInjector(Class<T> type)
  {
    return getMembersInjector(TypeLiteral.get(type));
  }
  
  public void bindListener(Matcher<? super TypeLiteral<?>> typeMatcher, TypeListener listener)
  {
    elements.add(new TypeListenerBinding(getSource(), listener, typeMatcher));
  }
  
  public void requestStaticInjection(Class<?>... types)
  {
    for (Class<?> type : types) {
      elements.add(new StaticInjectionRequest(getSource(), type));
    }
  }
  
  public void install(Module module)
  {
    if (modules.add(module))
    {
      Binder binder = this;
      if ((module instanceof PrivateModule)) {
        binder = binder.newPrivateBinder();
      }
      try
      {
        module.configure(binder);
      }
      catch (RuntimeException e)
      {
        Collection<Message> messages = Errors.getMessagesFromThrowable(e);
        if (!messages.isEmpty()) {
          elements.addAll(messages);
        } else {
          addError(e);
        }
      }
      binder.install(ProviderMethodsModule.forModule(module));
    }
  }
  
  public Stage currentStage()
  {
    return stage;
  }
  
  public void addError(String message, Object... arguments)
  {
    elements.add(new Message(getSource(), Errors.format(message, arguments)));
  }
  
  public void addError(Throwable t)
  {
    String message = "An exception was caught and reported. Message: " + t.getMessage();
    elements.add(new Message(.ImmutableList.of(getSource()), message, t));
  }
  
  public void addError(Message message)
  {
    elements.add(message);
  }
  
  public <T> AnnotatedBindingBuilder<T> bind(Key<T> key)
  {
    return new BindingBuilder(this, elements, getSource(), key);
  }
  
  public <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral)
  {
    return bind(Key.get(typeLiteral));
  }
  
  public <T> AnnotatedBindingBuilder<T> bind(Class<T> type)
  {
    return bind(Key.get(type));
  }
  
  public AnnotatedConstantBindingBuilder bindConstant()
  {
    return new ConstantBindingBuilderImpl(this, elements, getSource());
  }
  
  public <T> Provider<T> getProvider(Key<T> key)
  {
    ProviderLookup<T> element = new ProviderLookup(getSource(), key);
    elements.add(element);
    return element.getProvider();
  }
  
  public <T> Provider<T> getProvider(Class<T> type)
  {
    return getProvider(Key.get(type));
  }
  
  public void convertToTypes(Matcher<? super TypeLiteral<?>> typeMatcher, TypeConverter converter)
  {
    elements.add(new TypeConverterBinding(getSource(), typeMatcher, converter));
  }
  
  public RecordingBinder withSource(Object source)
  {
    return new RecordingBinder(this, source, null);
  }
  
  public RecordingBinder skipSources(Class... classesToSkip)
  {
    if (source != null) {
      return this;
    }
    .SourceProvider newSourceProvider = sourceProvider.plusSkippedClasses(classesToSkip);
    return new RecordingBinder(this, null, newSourceProvider);
  }
  
  public PrivateBinder newPrivateBinder()
  {
    PrivateElementsImpl privateElements = new PrivateElementsImpl(getSource());
    elements.add(privateElements);
    return new RecordingBinder(this, privateElements);
  }
  
  public void disableCircularProxies()
  {
    elements.add(new DisableCircularProxiesOption(getSource()));
  }
  
  public void requireExplicitBindings()
  {
    elements.add(new RequireExplicitBindingsOption(getSource()));
  }
  
  public void expose(Key<?> key)
  {
    exposeInternal(key);
  }
  
  public AnnotatedElementBuilder expose(Class<?> type)
  {
    return exposeInternal(Key.get(type));
  }
  
  public AnnotatedElementBuilder expose(TypeLiteral<?> type)
  {
    return exposeInternal(Key.get(type));
  }
  
  private <T> AnnotatedElementBuilder exposeInternal(Key<T> key)
  {
    if (privateElements == null)
    {
      addError("Cannot expose %s on a standard binder. Exposed bindings are only applicable to private binders.", new Object[] { key });
      
      new AnnotatedElementBuilder()
      {
        public void annotatedWith(Class<? extends Annotation> annotationType) {}
        
        public void annotatedWith(Annotation annotation) {}
      };
    }
    ExposureBuilder<T> builder = new ExposureBuilder(this, getSource(), key);
    privateElements.addExposureBuilder(builder);
    return builder;
  }
  
  protected Object getSource()
  {
    return sourceProvider != null ? sourceProvider.get() : source;
  }
  
  public String toString()
  {
    return "Binder";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Elements.RecordingBinder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */