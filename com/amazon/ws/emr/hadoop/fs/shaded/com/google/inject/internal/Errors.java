package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.CreationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.MembersInjector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ProvisionException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Classes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..SourceProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..StackTraceElements;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeConverterBinding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.TypeListenerBinding;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Set;

public final class Errors
  implements Serializable
{
  private final Errors root;
  private final Errors parent;
  private final Object source;
  private List<Message> errors;
  private static final String CONSTRUCTOR_RULES = "Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.";
  
  public Errors()
  {
    root = this;
    parent = null;
    source = .SourceProvider.UNKNOWN_SOURCE;
  }
  
  public Errors(Object source)
  {
    root = this;
    parent = null;
    this.source = source;
  }
  
  private Errors(Errors parent, Object source)
  {
    root = root;
    this.parent = parent;
    this.source = source;
  }
  
  public Errors withSource(Object source)
  {
    return source == .SourceProvider.UNKNOWN_SOURCE ? this : new Errors(this, source);
  }
  
  public Errors missingImplementation(Key key)
  {
    return addMessage("No implementation for %s was bound.", new Object[] { key });
  }
  
  public Errors jitDisabled(Key key)
  {
    return addMessage("Explicit bindings are required and %s is not explicitly bound.", new Object[] { key });
  }
  
  public Errors converterReturnedNull(String stringValue, Object source, TypeLiteral<?> type, TypeConverterBinding typeConverterBinding)
  {
    return addMessage("Received null converting '%s' (bound at %s) to %s%n using %s.", new Object[] { stringValue, convert(source), type, typeConverterBinding });
  }
  
  public Errors conversionTypeError(String stringValue, Object source, TypeLiteral<?> type, TypeConverterBinding typeConverterBinding, Object converted)
  {
    return addMessage("Type mismatch converting '%s' (bound at %s) to %s%n using %s.%n Converter returned %s.", new Object[] { stringValue, convert(source), type, typeConverterBinding, converted });
  }
  
  public Errors conversionError(String stringValue, Object source, TypeLiteral<?> type, TypeConverterBinding typeConverterBinding, RuntimeException cause)
  {
    return errorInUserCode(cause, "Error converting '%s' (bound at %s) to %s%n using %s.%n Reason: %s", new Object[] { stringValue, convert(source), type, typeConverterBinding, cause });
  }
  
  public Errors ambiguousTypeConversion(String stringValue, Object source, TypeLiteral<?> type, TypeConverterBinding a, TypeConverterBinding b)
  {
    return addMessage("Multiple converters can convert '%s' (bound at %s) to %s:%n %s and%n %s.%n Please adjust your type converter configuration to avoid overlapping matches.", new Object[] { stringValue, convert(source), type, a, b });
  }
  
  public Errors bindingToProvider()
  {
    return addMessage("Binding to Provider is not allowed.", new Object[0]);
  }
  
  public Errors subtypeNotProvided(Class<? extends Provider<?>> providerType, Class<?> type)
  {
    return addMessage("%s doesn't provide instances of %s.", new Object[] { providerType, type });
  }
  
  public Errors notASubtype(Class<?> implementationType, Class<?> type)
  {
    return addMessage("%s doesn't extend %s.", new Object[] { implementationType, type });
  }
  
  public Errors recursiveImplementationType()
  {
    return addMessage("@ImplementedBy points to the same class it annotates.", new Object[0]);
  }
  
  public Errors recursiveProviderType()
  {
    return addMessage("@ProvidedBy points to the same class it annotates.", new Object[0]);
  }
  
  public Errors missingRuntimeRetention(Object source)
  {
    return addMessage("Please annotate with @Retention(RUNTIME).%n Bound at %s.", new Object[] { convert(source) });
  }
  
  public Errors missingScopeAnnotation()
  {
    return addMessage("Please annotate with @ScopeAnnotation.", new Object[0]);
  }
  
  public Errors optionalConstructor(Constructor constructor)
  {
    return addMessage("%s is annotated @Inject(optional=true), but constructors cannot be optional.", new Object[] { constructor });
  }
  
  public Errors cannotBindToGuiceType(String simpleName)
  {
    return addMessage("Binding to core guice framework type is not allowed: %s.", new Object[] { simpleName });
  }
  
  public Errors scopeNotFound(Class<? extends Annotation> scopeAnnotation)
  {
    return addMessage("No scope is bound to %s.", new Object[] { scopeAnnotation });
  }
  
  public Errors scopeAnnotationOnAbstractType(Class<? extends Annotation> scopeAnnotation, Class<?> type, Object source)
  {
    return addMessage("%s is annotated with %s, but scope annotations are not supported for abstract types.%n Bound at %s.", new Object[] { type, scopeAnnotation, convert(source) });
  }
  
  public Errors misplacedBindingAnnotation(Member member, Annotation bindingAnnotation)
  {
    return addMessage("%s is annotated with %s, but binding annotations should be applied to its parameters instead.", new Object[] { member, bindingAnnotation });
  }
  
  public Errors missingConstructor(Class<?> implementation)
  {
    return addMessage("Could not find a suitable constructor in %s. Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.", new Object[] { implementation });
  }
  
  public Errors tooManyConstructors(Class<?> implementation)
  {
    return addMessage("%s has more than one constructor annotated with @Inject. Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.", new Object[] { implementation });
  }
  
  public Errors constructorNotDefinedByType(Constructor<?> constructor, TypeLiteral<?> type)
  {
    return addMessage("%s does not define %s", new Object[] { type, constructor });
  }
  
  public Errors duplicateScopes(Scope existing, Class<? extends Annotation> annotationType, Scope scope)
  {
    return addMessage("Scope %s is already bound to %s. Cannot bind %s.", new Object[] { existing, annotationType, scope });
  }
  
  public Errors voidProviderMethod()
  {
    return addMessage("Provider methods must return a value. Do not return void.", new Object[0]);
  }
  
  public Errors missingConstantValues()
  {
    return addMessage("Missing constant value. Please call to(...).", new Object[0]);
  }
  
  public Errors cannotInjectInnerClass(Class<?> type)
  {
    return addMessage("Injecting into inner classes is not supported.  Please use a 'static' class (top-level or nested) instead of %s.", new Object[] { type });
  }
  
  public Errors duplicateBindingAnnotations(Member member, Class<? extends Annotation> a, Class<? extends Annotation> b)
  {
    return addMessage("%s has more than one annotation annotated with @BindingAnnotation: %s and %s", new Object[] { member, a, b });
  }
  
  public Errors cannotInjectFinalField(Field field)
  {
    return addMessage("Injected field %s cannot be final.", new Object[] { field });
  }
  
  public Errors cannotInjectAbstractMethod(Method method)
  {
    return addMessage("Injected method %s cannot be abstract.", new Object[] { method });
  }
  
  public Errors cannotInjectNonVoidMethod(Method method)
  {
    return addMessage("Injected method %s must return void.", new Object[] { method });
  }
  
  public Errors cannotInjectMethodWithTypeParameters(Method method)
  {
    return addMessage("Injected method %s cannot declare type parameters of its own.", new Object[] { method });
  }
  
  public Errors duplicateScopeAnnotations(Class<? extends Annotation> a, Class<? extends Annotation> b)
  {
    return addMessage("More than one scope annotation was found: %s and %s.", new Object[] { a, b });
  }
  
  public Errors recursiveBinding()
  {
    return addMessage("Binding points to itself.", new Object[0]);
  }
  
  public Errors bindingAlreadySet(Key<?> key, Object source)
  {
    return addMessage("A binding to %s was already configured at %s.", new Object[] { key, convert(source) });
  }
  
  public Errors jitBindingAlreadySet(Key<?> key)
  {
    return addMessage("A just-in-time binding to %s was already configured on a parent injector.", new Object[] { key });
  }
  
  public Errors childBindingAlreadySet(Key<?> key, Set<Object> sources)
  {
    Formatter allSources = new Formatter();
    for (Object source : sources) {
      if (source == null) {
        allSources.format("%n    (bound by a just-in-time binding)", new Object[0]);
      } else {
        allSources.format("%n    bound at %s", new Object[] { source });
      }
    }
    Errors errors = addMessage("Unable to create binding for %s. It was already configured on one or more child injectors or private modules%s%n  If it was in a PrivateModule, did you forget to expose the binding?", new Object[] { key, allSources.out() });
    
    return errors;
  }
  
  public Errors errorCheckingDuplicateBinding(Key<?> key, Object source, Throwable t)
  {
    return addMessage("A binding to %s was already configured at %s and an error was thrown while checking duplicate bindings.  Error: %s", new Object[] { key, convert(source), t });
  }
  
  public Errors errorInjectingMethod(Throwable cause)
  {
    return errorInUserCode(cause, "Error injecting method, %s", new Object[] { cause });
  }
  
  public Errors errorNotifyingTypeListener(TypeListenerBinding listener, TypeLiteral<?> type, Throwable cause)
  {
    return errorInUserCode(cause, "Error notifying TypeListener %s (bound at %s) of %s.%n Reason: %s", new Object[] { listener.getListener(), convert(listener.getSource()), type, cause });
  }
  
  public Errors errorInjectingConstructor(Throwable cause)
  {
    return errorInUserCode(cause, "Error injecting constructor, %s", new Object[] { cause });
  }
  
  public Errors errorInProvider(RuntimeException runtimeException)
  {
    Throwable unwrapped = unwrap(runtimeException);
    return errorInUserCode(unwrapped, "Error in custom provider, %s", new Object[] { unwrapped });
  }
  
  public Errors errorInUserInjector(MembersInjector<?> listener, TypeLiteral<?> type, RuntimeException cause)
  {
    return errorInUserCode(cause, "Error injecting %s using %s.%n Reason: %s", new Object[] { type, listener, cause });
  }
  
  public Errors errorNotifyingInjectionListener(InjectionListener<?> listener, TypeLiteral<?> type, RuntimeException cause)
  {
    return errorInUserCode(cause, "Error notifying InjectionListener %s of %s.%n Reason: %s", new Object[] { listener, type, cause });
  }
  
  public Errors exposedButNotBound(Key<?> key)
  {
    return addMessage("Could not expose() %s, it must be explicitly bound.", new Object[] { key });
  }
  
  public Errors keyNotFullySpecified(TypeLiteral<?> typeLiteral)
  {
    return addMessage("%s cannot be used as a key; It is not fully specified.", new Object[] { typeLiteral });
  }
  
  public Errors errorEnhancingClass(Class<?> clazz, Throwable cause)
  {
    return errorInUserCode(cause, "Unable to method intercept: %s", new Object[] { clazz });
  }
  
  public static Collection<Message> getMessagesFromThrowable(Throwable throwable)
  {
    if ((throwable instanceof ProvisionException)) {
      return ((ProvisionException)throwable).getErrorMessages();
    }
    if ((throwable instanceof ConfigurationException)) {
      return ((ConfigurationException)throwable).getErrorMessages();
    }
    if ((throwable instanceof CreationException)) {
      return ((CreationException)throwable).getErrorMessages();
    }
    return .ImmutableSet.of();
  }
  
  public Errors errorInUserCode(Throwable cause, String messageFormat, Object... arguments)
  {
    Collection<Message> messages = getMessagesFromThrowable(cause);
    if (!messages.isEmpty()) {
      return merge(messages);
    }
    return addMessage(cause, messageFormat, arguments);
  }
  
  private Throwable unwrap(RuntimeException runtimeException)
  {
    if ((runtimeException instanceof Exceptions.UnhandledCheckedUserException)) {
      return runtimeException.getCause();
    }
    return runtimeException;
  }
  
  public Errors cannotInjectRawProvider()
  {
    return addMessage("Cannot inject a Provider that has no type parameter", new Object[0]);
  }
  
  public Errors cannotInjectRawMembersInjector()
  {
    return addMessage("Cannot inject a MembersInjector that has no type parameter", new Object[0]);
  }
  
  public Errors cannotInjectTypeLiteralOf(Type unsupportedType)
  {
    return addMessage("Cannot inject a TypeLiteral of %s", new Object[] { unsupportedType });
  }
  
  public Errors cannotInjectRawTypeLiteral()
  {
    return addMessage("Cannot inject a TypeLiteral that has no type parameter", new Object[0]);
  }
  
  public Errors cannotSatisfyCircularDependency(Class<?> expectedType)
  {
    return addMessage("Tried proxying %s to support a circular dependency, but it is not an interface.", new Object[] { expectedType });
  }
  
  public Errors circularProxiesDisabled(Class<?> expectedType)
  {
    return addMessage("Tried proxying %s to support a circular dependency, but circular proxies are disabled.", new Object[] { expectedType });
  }
  
  public void throwCreationExceptionIfErrorsExist()
  {
    if (!hasErrors()) {
      return;
    }
    throw new CreationException(getMessages());
  }
  
  public void throwConfigurationExceptionIfErrorsExist()
  {
    if (!hasErrors()) {
      return;
    }
    throw new ConfigurationException(getMessages());
  }
  
  public void throwProvisionExceptionIfErrorsExist()
  {
    if (!hasErrors()) {
      return;
    }
    throw new ProvisionException(getMessages());
  }
  
  private Message merge(Message message)
  {
    List<Object> sources = .Lists.newArrayList();
    sources.addAll(getSources());
    sources.addAll(message.getSources());
    return new Message(sources, message.getMessage(), message.getCause());
  }
  
  public Errors merge(Collection<Message> messages)
  {
    for (Message message : messages) {
      addMessage(merge(message));
    }
    return this;
  }
  
  public Errors merge(Errors moreErrors)
  {
    if ((root == root) || (root.errors == null)) {
      return this;
    }
    merge(root.errors);
    return this;
  }
  
  public List<Object> getSources()
  {
    List<Object> sources = .Lists.newArrayList();
    for (Errors e = this; e != null; e = parent) {
      if (source != .SourceProvider.UNKNOWN_SOURCE) {
        sources.add(0, source);
      }
    }
    return sources;
  }
  
  public void throwIfNewErrors(int expectedSize)
    throws ErrorsException
  {
    if (size() == expectedSize) {
      return;
    }
    throw toException();
  }
  
  public ErrorsException toException()
  {
    return new ErrorsException(this);
  }
  
  public boolean hasErrors()
  {
    return root.errors != null;
  }
  
  public Errors addMessage(String messageFormat, Object... arguments)
  {
    return addMessage(null, messageFormat, arguments);
  }
  
  private Errors addMessage(Throwable cause, String messageFormat, Object... arguments)
  {
    String message = format(messageFormat, arguments);
    addMessage(new Message(getSources(), message, cause));
    return this;
  }
  
  public Errors addMessage(Message message)
  {
    if (root.errors == null) {
      root.errors = .Lists.newArrayList();
    }
    root.errors.add(message);
    return this;
  }
  
  public static String format(String messageFormat, Object... arguments)
  {
    for (int i = 0; i < arguments.length; i++) {
      arguments[i] = convert(arguments[i]);
    }
    return String.format(messageFormat, arguments);
  }
  
  public List<Message> getMessages()
  {
    if (root.errors == null) {
      return .ImmutableList.of();
    }
    List<Message> result = .Lists.newArrayList(root.errors);
    Collections.sort(result, new Comparator()
    {
      public int compare(Message a, Message b)
      {
        return a.getSource().compareTo(b.getSource());
      }
    });
    return result;
  }
  
  public static String format(String heading, Collection<Message> errorMessages)
  {
    Formatter fmt = new Formatter().format(heading, new Object[0]).format(":%n%n", new Object[0]);
    int index = 1;
    boolean displayCauses = getOnlyCause(errorMessages) == null;
    for (Message errorMessage : errorMessages)
    {
      fmt.format("%s) %s%n", new Object[] { Integer.valueOf(index++), errorMessage.getMessage() });
      
      List<Object> dependencies = errorMessage.getSources();
      for (int i = dependencies.size() - 1; i >= 0; i--)
      {
        Object source = dependencies.get(i);
        formatSource(fmt, source);
      }
      Throwable cause = errorMessage.getCause();
      if ((displayCauses) && (cause != null))
      {
        StringWriter writer = new StringWriter();
        cause.printStackTrace(new PrintWriter(writer));
        fmt.format("Caused by: %s", new Object[] { writer.getBuffer() });
      }
      fmt.format("%n", new Object[0]);
    }
    if (errorMessages.size() == 1) {
      fmt.format("1 error", new Object[0]);
    } else {
      fmt.format("%s errors", new Object[] { Integer.valueOf(errorMessages.size()) });
    }
    return fmt.toString();
  }
  
  public <T> T checkForNull(T value, Object source, Dependency<?> dependency)
    throws ErrorsException
  {
    if ((value != null) || (dependency.isNullable())) {
      return value;
    }
    int parameterIndex = dependency.getParameterIndex();
    String parameterName = parameterIndex != -1 ? "parameter " + parameterIndex + " of " : "";
    
    addMessage("null returned by binding at %s%n but %s%s is not @Nullable", new Object[] { source, parameterName, dependency.getInjectionPoint().getMember() });
    
    throw toException();
  }
  
  public static Throwable getOnlyCause(Collection<Message> messages)
  {
    Throwable onlyCause = null;
    for (Message message : messages)
    {
      Throwable messageCause = message.getCause();
      if (messageCause != null)
      {
        if (onlyCause != null) {
          return null;
        }
        onlyCause = messageCause;
      }
    }
    return onlyCause;
  }
  
  public int size()
  {
    return root.errors == null ? 0 : root.errors.size();
  }
  
  private static abstract class Converter<T>
  {
    final Class<T> type;
    
    Converter(Class<T> type)
    {
      this.type = type;
    }
    
    boolean appliesTo(Object o)
    {
      return (o != null) && (type.isAssignableFrom(o.getClass()));
    }
    
    String convert(Object o)
    {
      return toString(type.cast(o));
    }
    
    abstract String toString(T paramT);
  }
  
  private static final Collection<Converter<?>> converters = .ImmutableList.of(new Converter(Class.class)new Converter
  {
    public String toString(Class c)
    {
      return c.getName();
    }
  }, new Converter(Member.class)new Converter
  {
    public String toString(Member member)
    {
      return .Classes.toString(member);
    }
  }, new Converter(Key.class)
  {
    public String toString(Key key)
    {
      if (key.getAnnotationType() != null) {
        return key.getTypeLiteral() + " annotated with " + (key.getAnnotation() != null ? key.getAnnotation() : key.getAnnotationType());
      }
      return key.getTypeLiteral().toString();
    }
  });
  
  public static Object convert(Object o)
  {
    for (Converter<?> converter : converters) {
      if (converter.appliesTo(o)) {
        return converter.convert(o);
      }
    }
    return o;
  }
  
  public static void formatSource(Formatter formatter, Object source)
  {
    if ((source instanceof Dependency))
    {
      Dependency<?> dependency = (Dependency)source;
      InjectionPoint injectionPoint = dependency.getInjectionPoint();
      if (injectionPoint != null) {
        formatInjectionPoint(formatter, dependency, injectionPoint);
      } else {
        formatSource(formatter, dependency.getKey());
      }
    }
    else if ((source instanceof InjectionPoint))
    {
      formatInjectionPoint(formatter, null, (InjectionPoint)source);
    }
    else if ((source instanceof Class))
    {
      formatter.format("  at %s%n", new Object[] { .StackTraceElements.forType((Class)source) });
    }
    else if ((source instanceof Member))
    {
      formatter.format("  at %s%n", new Object[] { .StackTraceElements.forMember((Member)source) });
    }
    else if ((source instanceof TypeLiteral))
    {
      formatter.format("  while locating %s%n", new Object[] { source });
    }
    else if ((source instanceof Key))
    {
      Key<?> key = (Key)source;
      formatter.format("  while locating %s%n", new Object[] { convert(key) });
    }
    else
    {
      formatter.format("  at %s%n", new Object[] { source });
    }
  }
  
  public static void formatInjectionPoint(Formatter formatter, Dependency<?> dependency, InjectionPoint injectionPoint)
  {
    Member member = injectionPoint.getMember();
    Class<? extends Member> memberType = .Classes.memberType(member);
    if (memberType == Field.class)
    {
      dependency = (Dependency)injectionPoint.getDependencies().get(0);
      formatter.format("  while locating %s%n", new Object[] { convert(dependency.getKey()) });
      formatter.format("    for field at %s%n", new Object[] { .StackTraceElements.forMember(member) });
    }
    else if (dependency != null)
    {
      formatter.format("  while locating %s%n", new Object[] { convert(dependency.getKey()) });
      formatter.format("    for parameter %s at %s%n", new Object[] { Integer.valueOf(dependency.getParameterIndex()), .StackTraceElements.forMember(member) });
    }
    else
    {
      formatSource(formatter, injectionPoint.getMember());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */