package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ImplementedBy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Injector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ProvidedBy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ProvisionException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Stage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Nullable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..SourceProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ToStringBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingTargetVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ConvertedConstantBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.HasDependencies;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ProviderBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Providers;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class InjectorImpl
  implements Injector, Lookups
{
  public static final TypeLiteral<String> STRING_TYPE = TypeLiteral.get(String.class);
  final State state;
  final InjectorImpl parent;
  
  static class InjectorOptions
  {
    final Stage stage;
    final boolean jitDisabled;
    final boolean disableCircularProxies;
    
    InjectorOptions(Stage stage, boolean jitDisabled, boolean disableCircularProxies)
    {
      this.stage = stage;
      this.jitDisabled = jitDisabled;
      this.disableCircularProxies = disableCircularProxies;
    }
    
    public String toString()
    {
      return new .ToStringBuilder(getClass()).add("stage", stage).add("jitDisabled", Boolean.valueOf(jitDisabled)).add("disableCircularProxies", Boolean.valueOf(disableCircularProxies)).toString();
    }
  }
  
  static enum JitLimitation
  {
    NO_JIT,  EXISTING_JIT,  NEW_OR_EXISTING_JIT;
    
    private JitLimitation() {}
  }
  
  final BindingsMultimap bindingsMultimap = new BindingsMultimap(null);
  final InjectorOptions options;
  final Map<Key<?>, BindingImpl<?>> jitBindings = .Maps.newHashMap();
  Lookups lookups = new DeferredLookups(this);
  
  InjectorImpl(@.Nullable InjectorImpl parent, State state, InjectorOptions injectorOptions)
  {
    this.parent = parent;
    this.state = state;
    options = injectorOptions;
    if (parent != null) {
      localContext = localContext;
    } else {
      localContext = new ThreadLocal()
      {
        protected Object[] initialValue()
        {
          return new Object[1];
        }
      };
    }
  }
  
  void index()
  {
    for (Binding<?> binding : state.getExplicitBindingsThisLevel().values()) {
      index(binding);
    }
  }
  
  <T> void index(Binding<T> binding)
  {
    bindingsMultimap.put(binding.getKey().getTypeLiteral(), binding);
  }
  
  public <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> type)
  {
    return bindingsMultimap.getAll(type);
  }
  
  public <T> BindingImpl<T> getBinding(Key<T> key)
  {
    Errors errors = new Errors(key);
    try
    {
      BindingImpl<T> result = getBindingOrThrow(key, errors, JitLimitation.EXISTING_JIT);
      errors.throwConfigurationExceptionIfErrorsExist();
      return result;
    }
    catch (ErrorsException e)
    {
      throw new ConfigurationException(errors.merge(e.getErrors()).getMessages());
    }
  }
  
  public <T> BindingImpl<T> getExistingBinding(Key<T> key)
  {
    BindingImpl<T> explicitBinding = state.getExplicitBinding(key);
    if (explicitBinding != null) {
      return explicitBinding;
    }
    synchronized (state.lock())
    {
      for (InjectorImpl injector = this; injector != null; injector = parent)
      {
        BindingImpl<T> jitBinding = (BindingImpl)jitBindings.get(key);
        if (jitBinding != null) {
          return jitBinding;
        }
      }
    }
    if (isProvider(key)) {
      try
      {
        Key<?> providedKey = getProvidedKey(key, new Errors());
        if (getExistingBinding(providedKey) != null) {
          return getBinding(key);
        }
      }
      catch (ErrorsException e)
      {
        throw new ConfigurationException(e.getErrors().getMessages());
      }
    }
    return null;
  }
  
  <T> BindingImpl<T> getBindingOrThrow(Key<T> key, Errors errors, JitLimitation jitType)
    throws ErrorsException
  {
    BindingImpl<T> binding = state.getExplicitBinding(key);
    if (binding != null) {
      return binding;
    }
    return getJustInTimeBinding(key, errors, jitType);
  }
  
  public <T> Binding<T> getBinding(Class<T> type)
  {
    return getBinding(Key.get(type));
  }
  
  public Injector getParent()
  {
    return parent;
  }
  
  public Injector createChildInjector(Iterable<? extends Module> modules)
  {
    return new InternalInjectorCreator().parentInjector(this).addModules(modules).build();
  }
  
  public Injector createChildInjector(Module... modules)
  {
    return createChildInjector(.ImmutableList.of(modules));
  }
  
  private <T> BindingImpl<T> getJustInTimeBinding(Key<T> key, Errors errors, JitLimitation jitType)
    throws ErrorsException
  {
    boolean jitOverride = (isProvider(key)) || (isTypeLiteral(key)) || (isMembersInjector(key));
    synchronized (state.lock())
    {
      for (InjectorImpl injector = this; injector != null; injector = parent)
      {
        BindingImpl<T> binding = (BindingImpl)jitBindings.get(key);
        if (binding != null)
        {
          if ((options.jitDisabled) && (jitType == JitLimitation.NO_JIT) && (!jitOverride) && (!(binding instanceof ConvertedConstantBindingImpl))) {
            throw errors.jitDisabled(key).toException();
          }
          return binding;
        }
      }
      return createJustInTimeBindingRecursive(key, errors, options.jitDisabled, jitType);
    }
  }
  
  private static boolean isProvider(Key<?> key)
  {
    return key.getTypeLiteral().getRawType().equals(Provider.class);
  }
  
  private static boolean isTypeLiteral(Key<?> key)
  {
    return key.getTypeLiteral().getRawType().equals(TypeLiteral.class);
  }
  
  private static <T> Key<T> getProvidedKey(Key<Provider<T>> key, Errors errors)
    throws ErrorsException
  {
    Type providerType = key.getTypeLiteral().getType();
    if (!(providerType instanceof ParameterizedType)) {
      throw errors.cannotInjectRawProvider().toException();
    }
    Type entryType = ((ParameterizedType)providerType).getActualTypeArguments()[0];
    
    Key<T> providedKey = key.ofType(entryType);
    return providedKey;
  }
  
  private static boolean isMembersInjector(Key<?> key)
  {
    return (key.getTypeLiteral().getRawType().equals(MembersInjector.class)) && (key.getAnnotationType() == null);
  }
  
  private <T> BindingImpl<MembersInjector<T>> createMembersInjectorBinding(Key<MembersInjector<T>> key, Errors errors)
    throws ErrorsException
  {
    Type membersInjectorType = key.getTypeLiteral().getType();
    if (!(membersInjectorType instanceof ParameterizedType)) {
      throw errors.cannotInjectRawMembersInjector().toException();
    }
    TypeLiteral<T> instanceType = TypeLiteral.get(((ParameterizedType)membersInjectorType).getActualTypeArguments()[0]);
    
    MembersInjector<T> membersInjector = membersInjectorStore.get(instanceType, errors);
    
    InternalFactory<MembersInjector<T>> factory = new ConstantFactory(Initializables.of(membersInjector));
    
    return new InstanceBindingImpl(this, key, .SourceProvider.UNKNOWN_SOURCE, factory, .ImmutableSet.of(), membersInjector);
  }
  
  private <T> BindingImpl<Provider<T>> createProviderBinding(Key<Provider<T>> key, Errors errors)
    throws ErrorsException
  {
    Key<T> providedKey = getProvidedKey(key, errors);
    BindingImpl<T> delegate = getBindingOrThrow(providedKey, errors, JitLimitation.NO_JIT);
    return new ProviderBindingImpl(this, key, delegate);
  }
  
  private static class ProviderBindingImpl<T>
    extends BindingImpl<Provider<T>>
    implements ProviderBinding<Provider<T>>, HasDependencies
  {
    final BindingImpl<T> providedBinding;
    
    ProviderBindingImpl(InjectorImpl injector, Key<Provider<T>> key, Binding<T> providedBinding)
    {
      super(key, providedBinding.getSource(), createInternalFactory(providedBinding), Scoping.UNSCOPED);
      
      this.providedBinding = ((BindingImpl)providedBinding);
    }
    
    static <T> InternalFactory<Provider<T>> createInternalFactory(Binding<T> providedBinding)
    {
      Provider<T> provider = providedBinding.getProvider();
      new InternalFactory()
      {
        public Provider<T> get(Errors errors, InternalContext context, Dependency dependency, boolean linked)
        {
          return val$provider;
        }
      };
    }
    
    public Key<? extends T> getProvidedKey()
    {
      return providedBinding.getKey();
    }
    
    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super Provider<T>, V> visitor)
    {
      return (V)visitor.visit(this);
    }
    
    public void applyTo(Binder binder)
    {
      throw new UnsupportedOperationException("This element represents a synthetic binding.");
    }
    
    public String toString()
    {
      return new .ToStringBuilder(ProviderBinding.class).add("key", getKey()).add("providedKey", getProvidedKey()).toString();
    }
    
    public Set<Dependency<?>> getDependencies()
    {
      return .ImmutableSet.of(Dependency.get(getProvidedKey()));
    }
    
    public boolean equals(Object obj)
    {
      if ((obj instanceof ProviderBindingImpl))
      {
        ProviderBindingImpl<?> o = (ProviderBindingImpl)obj;
        return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(providedBinding, providedBinding));
      }
      return false;
    }
    
    public int hashCode()
    {
      return .Objects.hashCode(new Object[] { getKey(), getScoping(), providedBinding });
    }
  }
  
  private <T> BindingImpl<T> convertConstantStringBinding(Key<T> key, Errors errors)
    throws ErrorsException
  {
    Key<String> stringKey = key.ofType(STRING_TYPE);
    BindingImpl<String> stringBinding = state.getExplicitBinding(stringKey);
    if ((stringBinding == null) || (!stringBinding.isConstant())) {
      return null;
    }
    String stringValue = (String)stringBinding.getProvider().get();
    Object source = stringBinding.getSource();
    
    TypeLiteral<T> type = key.getTypeLiteral();
    TypeConverterBinding typeConverterBinding = state.getConverter(stringValue, type, errors, source);
    if (typeConverterBinding == null) {
      return null;
    }
    try
    {
      T converted = typeConverterBinding.getTypeConverter().convert(stringValue, type);
      if (converted == null) {
        throw errors.converterReturnedNull(stringValue, source, type, typeConverterBinding).toException();
      }
      if (!type.getRawType().isInstance(converted)) {
        throw errors.conversionTypeError(stringValue, source, type, typeConverterBinding, converted).toException();
      }
      return new ConvertedConstantBindingImpl(this, key, converted, stringBinding, typeConverterBinding);
    }
    catch (ErrorsException e)
    {
      throw e;
    }
    catch (RuntimeException e)
    {
      throw errors.conversionError(stringValue, source, type, typeConverterBinding, e).toException();
    }
  }
  
  private static class ConvertedConstantBindingImpl<T>
    extends BindingImpl<T>
    implements ConvertedConstantBinding<T>
  {
    final T value;
    final Provider<T> provider;
    final Binding<String> originalBinding;
    final TypeConverterBinding typeConverterBinding;
    
    ConvertedConstantBindingImpl(InjectorImpl injector, Key<T> key, T value, Binding<String> originalBinding, TypeConverterBinding typeConverterBinding)
    {
      super(key, originalBinding.getSource(), new ConstantFactory(Initializables.of(value)), Scoping.UNSCOPED);
      
      this.value = value;
      provider = Providers.of(value);
      this.originalBinding = originalBinding;
      this.typeConverterBinding = typeConverterBinding;
    }
    
    public Provider<T> getProvider()
    {
      return provider;
    }
    
    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor)
    {
      return (V)visitor.visit(this);
    }
    
    public T getValue()
    {
      return (T)value;
    }
    
    public TypeConverterBinding getTypeConverterBinding()
    {
      return typeConverterBinding;
    }
    
    public Key<String> getSourceKey()
    {
      return originalBinding.getKey();
    }
    
    public Set<Dependency<?>> getDependencies()
    {
      return .ImmutableSet.of(Dependency.get(getSourceKey()));
    }
    
    public void applyTo(Binder binder)
    {
      throw new UnsupportedOperationException("This element represents a synthetic binding.");
    }
    
    public String toString()
    {
      return new .ToStringBuilder(ConvertedConstantBinding.class).add("key", getKey()).add("sourceKey", getSourceKey()).add("value", value).toString();
    }
    
    public boolean equals(Object obj)
    {
      if ((obj instanceof ConvertedConstantBindingImpl))
      {
        ConvertedConstantBindingImpl<?> o = (ConvertedConstantBindingImpl)obj;
        return (getKey().equals(o.getKey())) && (getScoping().equals(o.getScoping())) && (.Objects.equal(value, value));
      }
      return false;
    }
    
    public int hashCode()
    {
      return .Objects.hashCode(new Object[] { getKey(), getScoping(), value });
    }
  }
  
  <T> void initializeBinding(BindingImpl<T> binding, Errors errors)
    throws ErrorsException
  {
    if ((binding instanceof ConstructorBindingImpl)) {
      ((ConstructorBindingImpl)binding).initialize(this, errors);
    }
  }
  
  <T> void initializeJitBinding(BindingImpl<T> binding, Errors errors)
    throws ErrorsException
  {
    if ((binding instanceof ConstructorBindingImpl))
    {
      Key<T> key = binding.getKey();
      jitBindings.put(key, binding);
      boolean successful = false;
      ConstructorBindingImpl cb = (ConstructorBindingImpl)binding;
      try
      {
        cb.initialize(this, errors);
        successful = true;
      }
      finally
      {
        if (!successful)
        {
          removeFailedJitBinding(key, null);
          cleanup(binding, new HashSet());
        }
      }
    }
  }
  
  private boolean cleanup(BindingImpl<?> binding, Set<Key> encountered)
  {
    boolean bindingFailed = false;
    Set<Dependency<?>> deps = getInternalDependencies(binding);
    for (Dependency dep : deps)
    {
      Key<?> depKey = dep.getKey();
      InjectionPoint ip = dep.getInjectionPoint();
      if (encountered.add(depKey))
      {
        BindingImpl depBinding = (BindingImpl)jitBindings.get(depKey);
        if (depBinding != null)
        {
          boolean failed = cleanup(depBinding, encountered);
          if ((depBinding instanceof ConstructorBindingImpl))
          {
            ConstructorBindingImpl ctorBinding = (ConstructorBindingImpl)depBinding;
            ip = ctorBinding.getInternalConstructor();
            if (!ctorBinding.isInitialized()) {
              failed = true;
            }
          }
          if (failed)
          {
            removeFailedJitBinding(depKey, ip);
            bindingFailed = true;
          }
        }
        else if (state.getExplicitBinding(depKey) == null)
        {
          bindingFailed = true;
        }
      }
    }
    return bindingFailed;
  }
  
  private void removeFailedJitBinding(Key<?> key, InjectionPoint ip)
  {
    jitBindings.remove(key);
    membersInjectorStore.remove(key.getTypeLiteral());
    if (ip != null) {
      constructors.remove(ip);
    }
  }
  
  private Set<Dependency<?>> getInternalDependencies(BindingImpl<?> binding)
  {
    if ((binding instanceof ConstructorBindingImpl)) {
      return ((ConstructorBindingImpl)binding).getInternalDependencies();
    }
    if ((binding instanceof HasDependencies)) {
      return ((HasDependencies)binding).getDependencies();
    }
    return .ImmutableSet.of();
  }
  
  <T> BindingImpl<T> createUninitializedBinding(Key<T> key, Scoping scoping, Object source, Errors errors, boolean jitBinding)
    throws ErrorsException
  {
    Class<?> rawType = key.getTypeLiteral().getRawType();
    if ((rawType.isArray()) || (rawType.isEnum())) {
      throw errors.missingImplementation(key).toException();
    }
    if (rawType == TypeLiteral.class)
    {
      BindingImpl<T> binding = createTypeLiteralBinding(key, errors);
      
      return binding;
    }
    ImplementedBy implementedBy = (ImplementedBy)rawType.getAnnotation(ImplementedBy.class);
    if (implementedBy != null)
    {
      Annotations.checkForMisplacedScopeAnnotations(rawType, source, errors);
      return createImplementedByBinding(key, scoping, implementedBy, errors);
    }
    ProvidedBy providedBy = (ProvidedBy)rawType.getAnnotation(ProvidedBy.class);
    if (providedBy != null)
    {
      Annotations.checkForMisplacedScopeAnnotations(rawType, source, errors);
      return createProvidedByBinding(key, scoping, providedBy, errors);
    }
    return ConstructorBindingImpl.create(this, key, null, source, scoping, errors, (jitBinding) && (options.jitDisabled));
  }
  
  private <T> BindingImpl<TypeLiteral<T>> createTypeLiteralBinding(Key<TypeLiteral<T>> key, Errors errors)
    throws ErrorsException
  {
    Type typeLiteralType = key.getTypeLiteral().getType();
    if (!(typeLiteralType instanceof ParameterizedType)) {
      throw errors.cannotInjectRawTypeLiteral().toException();
    }
    ParameterizedType parameterizedType = (ParameterizedType)typeLiteralType;
    Type innerType = parameterizedType.getActualTypeArguments()[0];
    if ((!(innerType instanceof Class)) && (!(innerType instanceof GenericArrayType)) && (!(innerType instanceof ParameterizedType))) {
      throw errors.cannotInjectTypeLiteralOf(innerType).toException();
    }
    TypeLiteral<T> value = TypeLiteral.get(innerType);
    InternalFactory<TypeLiteral<T>> factory = new ConstantFactory(Initializables.of(value));
    
    return new InstanceBindingImpl(this, key, .SourceProvider.UNKNOWN_SOURCE, factory, .ImmutableSet.of(), value);
  }
  
  <T> BindingImpl<T> createProvidedByBinding(Key<T> key, Scoping scoping, ProvidedBy providedBy, Errors errors)
    throws ErrorsException
  {
    final Class<?> rawType = key.getTypeLiteral().getRawType();
    final Class<? extends Provider<?>> providerType = providedBy.value();
    if (providerType == rawType) {
      throw errors.recursiveProviderType().toException();
    }
    final Key<? extends Provider<T>> providerKey = Key.get(providerType);
    
    final BindingImpl<? extends Provider<?>> providerBinding = getBindingOrThrow(providerKey, errors, JitLimitation.NEW_OR_EXISTING_JIT);
    
    InternalFactory<T> internalFactory = new InternalFactory()
    {
      public T get(Errors errors, InternalContext context, Dependency dependency, boolean linked)
        throws ErrorsException
      {
        errors = errors.withSource(providerKey);
        Provider<?> provider = (Provider)providerBinding.getInternalFactory().get(errors, context, dependency, true);
        try
        {
          Object o = provider.get();
          if ((o != null) && (!rawType.isInstance(o))) {
            throw errors.subtypeNotProvided(providerType, rawType).toException();
          }
          return (T)o;
        }
        catch (RuntimeException e)
        {
          throw errors.errorInProvider(e).toException();
        }
      }
    };
    Object source = rawType;
    return new LinkedProviderBindingImpl(this, key, source, Scoping.scope(key, this, internalFactory, source, scoping), scoping, providerKey);
  }
  
  private <T> BindingImpl<T> createImplementedByBinding(Key<T> key, Scoping scoping, ImplementedBy implementedBy, Errors errors)
    throws ErrorsException
  {
    Class<?> rawType = key.getTypeLiteral().getRawType();
    Class<?> implementationType = implementedBy.value();
    if (implementationType == rawType) {
      throw errors.recursiveImplementationType().toException();
    }
    if (!rawType.isAssignableFrom(implementationType)) {
      throw errors.notASubtype(implementationType, rawType).toException();
    }
    Class<? extends T> subclass = implementationType;
    
    final Key<? extends T> targetKey = Key.get(subclass);
    final BindingImpl<? extends T> targetBinding = getBindingOrThrow(targetKey, errors, JitLimitation.NEW_OR_EXISTING_JIT);
    
    InternalFactory<T> internalFactory = new InternalFactory()
    {
      public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
        throws ErrorsException
      {
        return (T)targetBinding.getInternalFactory().get(errors.withSource(targetKey), context, dependency, true);
      }
    };
    Object source = rawType;
    return new LinkedBindingImpl(this, key, source, Scoping.scope(key, this, internalFactory, source, scoping), scoping, targetKey);
  }
  
  private <T> BindingImpl<T> createJustInTimeBindingRecursive(Key<T> key, Errors errors, boolean jitDisabled, JitLimitation jitType)
    throws ErrorsException
  {
    if (parent != null) {
      try
      {
        return parent.createJustInTimeBindingRecursive(key, new Errors(), jitDisabled, parent.options.jitDisabled ? JitLimitation.NO_JIT : jitType);
      }
      catch (ErrorsException ignored) {}
    }
    if (state.isBlacklisted(key))
    {
      Set<Object> sources = state.getSourcesForBlacklistedKey(key);
      throw errors.childBindingAlreadySet(key, sources).toException();
    }
    BindingImpl<T> binding = createJustInTimeBinding(key, errors, jitDisabled, jitType);
    state.parent().blacklist(key, binding.getSource());
    jitBindings.put(key, binding);
    return binding;
  }
  
  private <T> BindingImpl<T> createJustInTimeBinding(Key<T> key, Errors errors, boolean jitDisabled, JitLimitation jitType)
    throws ErrorsException
  {
    int numErrorsBefore = errors.size();
    if (state.isBlacklisted(key))
    {
      Set<Object> sources = state.getSourcesForBlacklistedKey(key);
      throw errors.childBindingAlreadySet(key, sources).toException();
    }
    if (isProvider(key))
    {
      BindingImpl<T> binding = createProviderBinding(key, errors);
      return binding;
    }
    if (isMembersInjector(key))
    {
      BindingImpl<T> binding = createMembersInjectorBinding(key, errors);
      return binding;
    }
    BindingImpl<T> convertedBinding = convertConstantStringBinding(key, errors);
    if (convertedBinding != null) {
      return convertedBinding;
    }
    if ((!isTypeLiteral(key)) && (jitDisabled) && (jitType != JitLimitation.NEW_OR_EXISTING_JIT)) {
      throw errors.jitDisabled(key).toException();
    }
    if (key.getAnnotationType() != null)
    {
      if (key.hasAttributes()) {
        try
        {
          Errors ignored = new Errors();
          return getBindingOrThrow(key.withoutAttributes(), ignored, JitLimitation.NO_JIT);
        }
        catch (ErrorsException ignored) {}
      }
      throw errors.missingImplementation(key).toException();
    }
    Object source = key.getTypeLiteral().getRawType();
    BindingImpl<T> binding = createUninitializedBinding(key, Scoping.UNSCOPED, source, errors, true);
    errors.throwIfNewErrors(numErrorsBefore);
    initializeJitBinding(binding, errors);
    return binding;
  }
  
  <T> InternalFactory<? extends T> getInternalFactory(Key<T> key, Errors errors, JitLimitation jitType)
    throws ErrorsException
  {
    return getBindingOrThrow(key, errors, jitType).getInternalFactory();
  }
  
  public Map<Key<?>, Binding<?>> getBindings()
  {
    return state.getExplicitBindingsThisLevel();
  }
  
  /* Error */
  public Map<Key<?>, Binding<?>> getAllBindings()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/InjectorImpl:state	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/State;
    //   4: invokeinterface 220 1 0
    //   9: dup
    //   10: astore_1
    //   11: monitorenter
    //   12: new 35	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/util/$ImmutableMap$Builder
    //   15: dup
    //   16: invokespecial 735	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/util/$ImmutableMap$Builder:<init>	()V
    //   19: aload_0
    //   20: getfield 98	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/InjectorImpl:state	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/State;
    //   23: invokeinterface 112 1 0
    //   28: invokevirtual 739	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/util/$ImmutableMap$Builder:putAll	(Ljava/util/Map;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/util/$ImmutableMap$Builder;
    //   31: aload_0
    //   32: getfield 82	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/InjectorImpl:jitBindings	Ljava/util/Map;
    //   35: invokevirtual 739	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/util/$ImmutableMap$Builder:putAll	(Ljava/util/Map;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/util/$ImmutableMap$Builder;
    //   38: invokevirtual 742	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/util/$ImmutableMap$Builder:build	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/util/$ImmutableMap;
    //   41: aload_1
    //   42: monitorexit
    //   43: areturn
    //   44: astore_2
    //   45: aload_1
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Line number table:
    //   Java source line #861	-> byte code offset #0
    //   Java source line #862	-> byte code offset #12
    //   Java source line #866	-> byte code offset #44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	InjectorImpl
    //   10	36	1	Ljava/lang/Object;	Object
    //   44	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   12	43	44	finally
    //   44	47	44	finally
  }
  
  public Map<Class<? extends Annotation>, Scope> getScopeBindings()
  {
    return .ImmutableMap.copyOf(state.getScopes());
  }
  
  public Set<TypeConverterBinding> getTypeConverterBindings()
  {
    return .ImmutableSet.copyOf(state.getConvertersThisLevel());
  }
  
  private static class BindingsMultimap
  {
    final Map<TypeLiteral<?>, List<Binding<?>>> multimap = .Maps.newHashMap();
    
    <T> void put(TypeLiteral<T> type, Binding<T> binding)
    {
      List<Binding<?>> bindingsForType = (List)multimap.get(type);
      if (bindingsForType == null)
      {
        bindingsForType = .Lists.newArrayList();
        multimap.put(type, bindingsForType);
      }
      bindingsForType.add(binding);
    }
    
    <T> List<Binding<T>> getAll(TypeLiteral<T> type)
    {
      List<Binding<?>> bindings = (List)multimap.get(type);
      return bindings != null ? Collections.unmodifiableList((List)multimap.get(type)) : .ImmutableList.of();
    }
  }
  
  SingleParameterInjector<?>[] getParametersInjectors(List<Dependency<?>> parameters, Errors errors)
    throws ErrorsException
  {
    if (parameters.isEmpty()) {
      return null;
    }
    int numErrorsBefore = errors.size();
    SingleParameterInjector<?>[] result = new SingleParameterInjector[parameters.size()];
    int i = 0;
    for (Dependency<?> parameter : parameters) {
      try
      {
        result[(i++)] = createParameterInjector(parameter, errors.withSource(parameter));
      }
      catch (ErrorsException rethrownBelow) {}
    }
    errors.throwIfNewErrors(numErrorsBefore);
    return result;
  }
  
  <T> SingleParameterInjector<T> createParameterInjector(Dependency<T> dependency, Errors errors)
    throws ErrorsException
  {
    InternalFactory<? extends T> factory = getInternalFactory(dependency.getKey(), errors, JitLimitation.NO_JIT);
    return new SingleParameterInjector(dependency, factory);
  }
  
  final ConstructorInjectorStore constructors = new ConstructorInjectorStore(this);
  MembersInjectorStore membersInjectorStore;
  final ThreadLocal<Object[]> localContext;
  
  public void injectMembers(Object instance)
  {
    MembersInjector membersInjector = getMembersInjector(instance.getClass());
    membersInjector.injectMembers(instance);
  }
  
  public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral)
  {
    Errors errors = new Errors(typeLiteral);
    try
    {
      return membersInjectorStore.get(typeLiteral, errors);
    }
    catch (ErrorsException e)
    {
      throw new ConfigurationException(errors.merge(e.getErrors()).getMessages());
    }
  }
  
  public <T> MembersInjector<T> getMembersInjector(Class<T> type)
  {
    return getMembersInjector(TypeLiteral.get(type));
  }
  
  public <T> Provider<T> getProvider(Class<T> type)
  {
    return getProvider(Key.get(type));
  }
  
  <T> Provider<T> getProviderOrThrow(Key<T> key, Errors errors)
    throws ErrorsException
  {
    final InternalFactory<? extends T> factory = getInternalFactory(key, errors, JitLimitation.NO_JIT);
    final Dependency<T> dependency = Dependency.get(key);
    
    new Provider()
    {
      public T get()
      {
        final Errors errors = new Errors(dependency);
        try
        {
          T t = callInContext(new ContextualCallable()
          {
            public T call(InternalContext context)
              throws ErrorsException
            {
              Dependency previous = context.setDependency(val$dependency);
              try
              {
                return (T)val$factory.get(errors, context, val$dependency, false);
              }
              finally
              {
                context.setDependency(previous);
              }
            }
          });
          errors.throwIfNewErrors(0);
          return t;
        }
        catch (ErrorsException e)
        {
          throw new ProvisionException(errors.merge(e.getErrors()).getMessages());
        }
      }
      
      public String toString()
      {
        return factory.toString();
      }
    };
  }
  
  public <T> Provider<T> getProvider(Key<T> key)
  {
    Errors errors = new Errors(key);
    try
    {
      Provider<T> result = getProviderOrThrow(key, errors);
      errors.throwIfNewErrors(0);
      return result;
    }
    catch (ErrorsException e)
    {
      throw new ConfigurationException(errors.merge(e.getErrors()).getMessages());
    }
  }
  
  public <T> T getInstance(Key<T> key)
  {
    return (T)getProvider(key).get();
  }
  
  public <T> T getInstance(Class<T> type)
  {
    return (T)getProvider(type).get();
  }
  
  /* Error */
  <T> T callInContext(ContextualCallable<T> callable)
    throws ErrorsException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/InjectorImpl:localContext	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 838	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 840	[Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_2
    //   12: iconst_0
    //   13: aaload
    //   14: ifnonnull +41 -> 55
    //   17: aload_2
    //   18: iconst_0
    //   19: new 842	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/InternalContext
    //   22: dup
    //   23: invokespecial 843	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/InternalContext:<init>	()V
    //   26: aastore
    //   27: aload_1
    //   28: aload_2
    //   29: iconst_0
    //   30: aaload
    //   31: checkcast 842	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/InternalContext
    //   34: invokeinterface 849 2 0
    //   39: astore_3
    //   40: aload_2
    //   41: iconst_0
    //   42: aconst_null
    //   43: aastore
    //   44: aload_3
    //   45: areturn
    //   46: astore 4
    //   48: aload_2
    //   49: iconst_0
    //   50: aconst_null
    //   51: aastore
    //   52: aload 4
    //   54: athrow
    //   55: aload_1
    //   56: aload_2
    //   57: iconst_0
    //   58: aaload
    //   59: checkcast 842	com/amazon/ws/emr/hadoop/fs/shaded/com/google/inject/internal/InternalContext
    //   62: invokeinterface 849 2 0
    //   67: areturn
    // Line number table:
    //   Java source line #1020	-> byte code offset #0
    //   Java source line #1021	-> byte code offset #11
    //   Java source line #1022	-> byte code offset #17
    //   Java source line #1024	-> byte code offset #27
    //   Java source line #1027	-> byte code offset #40
    //   Java source line #1031	-> byte code offset #55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	InjectorImpl
    //   0	68	1	callable	ContextualCallable<T>
    //   10	47	2	reference	Object[]
    //   39	6	3	localObject1	Object
    //   46	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	40	46	finally
    //   46	48	46	finally
  }
  
  public String toString()
  {
    return new .ToStringBuilder(Injector.class).add("bindings", state.getExplicitBindingsThisLevel().values()).toString();
  }
  
  static abstract interface MethodInvoker
  {
    public abstract Object invoke(Object paramObject, Object... paramVarArgs)
      throws IllegalAccessException, InvocationTargetException;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */