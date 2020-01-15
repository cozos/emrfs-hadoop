package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Annotations;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Errors;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ErrorsException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MoreTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Nullability;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Classes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class InjectionPoint
{
  private static final Logger logger = Logger.getLogger(InjectionPoint.class.getName());
  private final boolean optional;
  private final Member member;
  private final TypeLiteral<?> declaringType;
  private final .ImmutableList<Dependency<?>> dependencies;
  
  InjectionPoint(TypeLiteral<?> declaringType, Method method, boolean optional)
  {
    member = method;
    this.declaringType = declaringType;
    this.optional = optional;
    dependencies = forMember(method, declaringType, method.getParameterAnnotations());
  }
  
  InjectionPoint(TypeLiteral<?> declaringType, Constructor<?> constructor)
  {
    member = constructor;
    this.declaringType = declaringType;
    optional = false;
    dependencies = forMember(constructor, declaringType, constructor.getParameterAnnotations());
  }
  
  InjectionPoint(TypeLiteral<?> declaringType, Field field, boolean optional)
  {
    member = field;
    this.declaringType = declaringType;
    this.optional = optional;
    
    Annotation[] annotations = field.getAnnotations();
    
    Errors errors = new Errors(field);
    Key<?> key = null;
    try
    {
      key = Annotations.getKey(declaringType.getFieldType(field), field, annotations, errors);
    }
    catch (ConfigurationException e)
    {
      errors.merge(e.getErrorMessages());
    }
    catch (ErrorsException e)
    {
      errors.merge(e.getErrors());
    }
    errors.throwConfigurationExceptionIfErrorsExist();
    
    dependencies = .ImmutableList.of(newDependency(key, Nullability.allowsNull(annotations), -1));
  }
  
  private .ImmutableList<Dependency<?>> forMember(Member member, TypeLiteral<?> type, Annotation[][] paramterAnnotations)
  {
    Errors errors = new Errors(member);
    Iterator<Annotation[]> annotationsIterator = Arrays.asList(paramterAnnotations).iterator();
    
    List<Dependency<?>> dependencies = .Lists.newArrayList();
    int index = 0;
    for (TypeLiteral<?> parameterType : type.getParameterTypes(member)) {
      try
      {
        Annotation[] parameterAnnotations = (Annotation[])annotationsIterator.next();
        Key<?> key = Annotations.getKey(parameterType, member, parameterAnnotations, errors);
        dependencies.add(newDependency(key, Nullability.allowsNull(parameterAnnotations), index));
        index++;
      }
      catch (ConfigurationException e)
      {
        errors.merge(e.getErrorMessages());
      }
      catch (ErrorsException e)
      {
        errors.merge(e.getErrors());
      }
    }
    errors.throwConfigurationExceptionIfErrorsExist();
    return .ImmutableList.copyOf(dependencies);
  }
  
  private <T> Dependency<T> newDependency(Key<T> key, boolean allowsNull, int parameterIndex)
  {
    return new Dependency(this, key, allowsNull, parameterIndex);
  }
  
  public Member getMember()
  {
    return member;
  }
  
  public List<Dependency<?>> getDependencies()
  {
    return dependencies;
  }
  
  public boolean isOptional()
  {
    return optional;
  }
  
  public boolean isToolable()
  {
    return ((AnnotatedElement)member).isAnnotationPresent(Toolable.class);
  }
  
  public TypeLiteral<?> getDeclaringType()
  {
    return declaringType;
  }
  
  public boolean equals(Object o)
  {
    return ((o instanceof InjectionPoint)) && (member.equals(member)) && (declaringType.equals(declaringType));
  }
  
  public int hashCode()
  {
    return member.hashCode() ^ declaringType.hashCode();
  }
  
  public String toString()
  {
    return .Classes.toString(member);
  }
  
  public static <T> InjectionPoint forConstructor(Constructor<T> constructor)
  {
    return new InjectionPoint(TypeLiteral.get(constructor.getDeclaringClass()), constructor);
  }
  
  public static <T> InjectionPoint forConstructor(Constructor<T> constructor, TypeLiteral<? extends T> type)
  {
    if (type.getRawType() != constructor.getDeclaringClass()) {
      new Errors(type).constructorNotDefinedByType(constructor, type).throwConfigurationExceptionIfErrorsExist();
    }
    return new InjectionPoint(type, constructor);
  }
  
  public static InjectionPoint forConstructorOf(TypeLiteral<?> type)
  {
    Class<?> rawType = MoreTypes.getRawType(type.getType());
    Errors errors = new Errors(rawType);
    
    Constructor<?> injectableConstructor = null;
    for (Constructor<?> constructor : rawType.getDeclaredConstructors())
    {
      com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject guiceInject = (com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject)constructor.getAnnotation(com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject.class);
      boolean optional;
      boolean optional;
      if (guiceInject == null)
      {
        javax.inject.Inject javaxInject = (javax.inject.Inject)constructor.getAnnotation(javax.inject.Inject.class);
        if (javaxInject == null) {
          continue;
        }
        optional = false;
      }
      else
      {
        optional = guiceInject.optional();
      }
      if (optional) {
        errors.optionalConstructor(constructor);
      }
      if (injectableConstructor != null) {
        errors.tooManyConstructors(rawType);
      }
      injectableConstructor = constructor;
      checkForMisplacedBindingAnnotations(injectableConstructor, errors);
    }
    errors.throwConfigurationExceptionIfErrorsExist();
    if (injectableConstructor != null) {
      return new InjectionPoint(type, injectableConstructor);
    }
    try
    {
      Constructor<?> noArgConstructor = rawType.getDeclaredConstructor(new Class[0]);
      if ((Modifier.isPrivate(noArgConstructor.getModifiers())) && (!Modifier.isPrivate(rawType.getModifiers())))
      {
        errors.missingConstructor(rawType);
        throw new ConfigurationException(errors.getMessages());
      }
      checkForMisplacedBindingAnnotations(noArgConstructor, errors);
      return new InjectionPoint(type, noArgConstructor);
    }
    catch (NoSuchMethodException e)
    {
      errors.missingConstructor(rawType);
      throw new ConfigurationException(errors.getMessages());
    }
  }
  
  public static InjectionPoint forConstructorOf(Class<?> type)
  {
    return forConstructorOf(TypeLiteral.get(type));
  }
  
  public static Set<InjectionPoint> forStaticMethodsAndFields(TypeLiteral<?> type)
  {
    Errors errors = new Errors();
    
    Set<InjectionPoint> result = getInjectionPoints(type, true, errors);
    if (errors.hasErrors()) {
      throw new ConfigurationException(errors.getMessages()).withPartialValue(result);
    }
    return result;
  }
  
  public static Set<InjectionPoint> forStaticMethodsAndFields(Class<?> type)
  {
    return forStaticMethodsAndFields(TypeLiteral.get(type));
  }
  
  public static Set<InjectionPoint> forInstanceMethodsAndFields(TypeLiteral<?> type)
  {
    Errors errors = new Errors();
    Set<InjectionPoint> result = getInjectionPoints(type, false, errors);
    if (errors.hasErrors()) {
      throw new ConfigurationException(errors.getMessages()).withPartialValue(result);
    }
    return result;
  }
  
  public static Set<InjectionPoint> forInstanceMethodsAndFields(Class<?> type)
  {
    return forInstanceMethodsAndFields(TypeLiteral.get(type));
  }
  
  private static boolean checkForMisplacedBindingAnnotations(Member member, Errors errors)
  {
    Annotation misplacedBindingAnnotation = Annotations.findBindingAnnotation(errors, member, ((AnnotatedElement)member).getAnnotations());
    if (misplacedBindingAnnotation == null) {
      return false;
    }
    if ((member instanceof Method)) {
      try
      {
        if (member.getDeclaringClass().getDeclaredField(member.getName()) != null) {
          return false;
        }
      }
      catch (NoSuchFieldException ignore) {}
    }
    errors.misplacedBindingAnnotation(member, misplacedBindingAnnotation);
    return true;
  }
  
  static abstract class InjectableMember
  {
    final TypeLiteral<?> declaringType;
    final boolean optional;
    final boolean jsr330;
    InjectableMember previous;
    InjectableMember next;
    
    InjectableMember(TypeLiteral<?> declaringType, Annotation atInject)
    {
      this.declaringType = declaringType;
      if (atInject.annotationType() == javax.inject.Inject.class)
      {
        optional = false;
        jsr330 = true;
        return;
      }
      jsr330 = false;
      optional = ((com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject)atInject).optional();
    }
    
    abstract InjectionPoint toInjectionPoint();
  }
  
  static class InjectableField
    extends InjectionPoint.InjectableMember
  {
    final Field field;
    
    InjectableField(TypeLiteral<?> declaringType, Field field, Annotation atInject)
    {
      super(atInject);
      this.field = field;
    }
    
    InjectionPoint toInjectionPoint()
    {
      return new InjectionPoint(declaringType, field, optional);
    }
  }
  
  static class InjectableMethod
    extends InjectionPoint.InjectableMember
  {
    final Method method;
    boolean overrodeGuiceInject;
    
    InjectableMethod(TypeLiteral<?> declaringType, Method method, Annotation atInject)
    {
      super(atInject);
      this.method = method;
    }
    
    InjectionPoint toInjectionPoint()
    {
      return new InjectionPoint(declaringType, method, optional);
    }
    
    public boolean isFinal()
    {
      return Modifier.isFinal(method.getModifiers());
    }
  }
  
  static Annotation getAtInject(AnnotatedElement member)
  {
    Annotation a = member.getAnnotation(javax.inject.Inject.class);
    return a == null ? member.getAnnotation(com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject.class) : a;
  }
  
  static class InjectableMembers
  {
    InjectionPoint.InjectableMember head;
    InjectionPoint.InjectableMember tail;
    
    void add(InjectionPoint.InjectableMember member)
    {
      if (head == null)
      {
        head = (tail = member);
      }
      else
      {
        previous = tail;
        tail.next = member;
        tail = member;
      }
    }
    
    void remove(InjectionPoint.InjectableMember member)
    {
      if (previous != null) {
        previous.next = next;
      }
      if (next != null) {
        next.previous = previous;
      }
      if (head == member) {
        head = next;
      }
      if (tail == member) {
        tail = previous;
      }
    }
    
    boolean isEmpty()
    {
      return head == null;
    }
  }
  
  static enum Position
  {
    TOP,  MIDDLE,  BOTTOM;
    
    private Position() {}
  }
  
  static class OverrideIndex
  {
    final InjectionPoint.InjectableMembers injectableMembers;
    Map<InjectionPoint.Signature, List<InjectionPoint.InjectableMethod>> bySignature;
    InjectionPoint.Position position = InjectionPoint.Position.TOP;
    Method lastMethod;
    InjectionPoint.Signature lastSignature;
    
    OverrideIndex(InjectionPoint.InjectableMembers injectableMembers)
    {
      this.injectableMembers = injectableMembers;
    }
    
    boolean removeIfOverriddenBy(Method method, boolean alwaysRemove, InjectionPoint.InjectableMethod injectableMethod)
    {
      if (position == InjectionPoint.Position.TOP) {
        return false;
      }
      if (bySignature == null)
      {
        bySignature = new HashMap();
        for (InjectionPoint.InjectableMember member = injectableMembers.head; member != null; member = next) {
          if ((member instanceof InjectionPoint.InjectableMethod))
          {
            InjectionPoint.InjectableMethod im = (InjectionPoint.InjectableMethod)member;
            if (!im.isFinal())
            {
              List<InjectionPoint.InjectableMethod> methods = new ArrayList();
              methods.add(im);
              bySignature.put(new InjectionPoint.Signature(method), methods);
            }
          }
        }
      }
      lastMethod = method;
      InjectionPoint.Signature signature = lastSignature = new InjectionPoint.Signature(method);
      List<InjectionPoint.InjectableMethod> methods = (List)bySignature.get(signature);
      boolean removed = false;
      if (methods != null)
      {
        Iterator<InjectionPoint.InjectableMethod> iterator = methods.iterator();
        while (iterator.hasNext())
        {
          InjectionPoint.InjectableMethod possiblyOverridden = (InjectionPoint.InjectableMethod)iterator.next();
          if (InjectionPoint.overrides(method, method))
          {
            boolean wasGuiceInject = (!jsr330) || (overrodeGuiceInject);
            if (injectableMethod != null) {
              overrodeGuiceInject = wasGuiceInject;
            }
            if ((alwaysRemove) || (!wasGuiceInject))
            {
              removed = true;
              iterator.remove();
              injectableMembers.remove(possiblyOverridden);
            }
          }
        }
      }
      return removed;
    }
    
    void add(InjectionPoint.InjectableMethod injectableMethod)
    {
      injectableMembers.add(injectableMethod);
      if ((position == InjectionPoint.Position.BOTTOM) || (injectableMethod.isFinal())) {
        return;
      }
      if (bySignature != null)
      {
        InjectionPoint.Signature signature = method == lastMethod ? lastSignature : new InjectionPoint.Signature(method);
        
        List<InjectionPoint.InjectableMethod> methods = (List)bySignature.get(signature);
        if (methods == null)
        {
          methods = new ArrayList();
          bySignature.put(signature, methods);
        }
        methods.add(injectableMethod);
      }
    }
  }
  
  private static Set<InjectionPoint> getInjectionPoints(TypeLiteral<?> type, boolean statics, Errors errors)
  {
    InjectableMembers injectableMembers = new InjectableMembers();
    OverrideIndex overrideIndex = null;
    
    List<TypeLiteral<?>> hierarchy = hierarchyFor(type);
    int topIndex = hierarchy.size() - 1;
    for (int i = topIndex; i >= 0; i--)
    {
      if ((overrideIndex != null) && (i < topIndex)) {
        if (i == 0) {
          position = Position.BOTTOM;
        } else {
          position = Position.MIDDLE;
        }
      }
      TypeLiteral<?> current = (TypeLiteral)hierarchy.get(i);
      for (Field field : current.getRawType().getDeclaredFields()) {
        if (Modifier.isStatic(field.getModifiers()) == statics)
        {
          Annotation atInject = getAtInject(field);
          if (atInject != null)
          {
            InjectableField injectableField = new InjectableField(current, field, atInject);
            if ((jsr330) && (Modifier.isFinal(field.getModifiers()))) {
              errors.cannotInjectFinalField(field);
            }
            injectableMembers.add(injectableField);
          }
        }
      }
      for (Method method : current.getRawType().getDeclaredMethods()) {
        if (Modifier.isStatic(method.getModifiers()) == statics)
        {
          Annotation atInject = getAtInject(method);
          if (atInject != null)
          {
            InjectableMethod injectableMethod = new InjectableMethod(current, method, atInject);
            if ((checkForMisplacedBindingAnnotations(method, errors) | !isValidMethod(injectableMethod, errors)))
            {
              if (overrideIndex != null)
              {
                boolean removed = overrideIndex.removeIfOverriddenBy(method, false, injectableMethod);
                if (removed) {
                  logger.log(Level.WARNING, "Method: {0} is not a valid injectable method (because it either has misplaced binding annotations or specifies type parameters) but is overriding a method that is valid. Because it is not valid, the method will not be injected. To fix this, make the method a valid injectable method.", method);
                }
              }
            }
            else if (statics)
            {
              injectableMembers.add(injectableMethod);
            }
            else
            {
              if (overrideIndex == null) {
                overrideIndex = new OverrideIndex(injectableMembers);
              } else {
                overrideIndex.removeIfOverriddenBy(method, true, injectableMethod);
              }
              overrideIndex.add(injectableMethod);
            }
          }
          else if (overrideIndex != null)
          {
            boolean removed = overrideIndex.removeIfOverriddenBy(method, false, null);
            if (removed) {
              logger.log(Level.WARNING, "Method: {0} is not annotated with @Inject but is overriding a method that is annotated with @javax.inject.Inject.  Because it is not annotated with @Inject, the method will not be injected. To fix this, annotate the method with @Inject.", method);
            }
          }
        }
      }
    }
    if (injectableMembers.isEmpty()) {
      return Collections.emptySet();
    }
    .ImmutableSet.Builder<InjectionPoint> builder = .ImmutableSet.builder();
    for (InjectableMember im = head; im != null; im = next) {
      try
      {
        builder.add(im.toInjectionPoint());
      }
      catch (ConfigurationException ignorable)
      {
        if (!optional) {
          errors.merge(ignorable.getErrorMessages());
        }
      }
    }
    return builder.build();
  }
  
  private static boolean isValidMethod(InjectableMethod injectableMethod, Errors errors)
  {
    boolean result = true;
    if (jsr330)
    {
      Method method = injectableMethod.method;
      if (Modifier.isAbstract(method.getModifiers()))
      {
        errors.cannotInjectAbstractMethod(method);
        result = false;
      }
      if (method.getTypeParameters().length > 0)
      {
        errors.cannotInjectMethodWithTypeParameters(method);
        result = false;
      }
    }
    return result;
  }
  
  private static List<TypeLiteral<?>> hierarchyFor(TypeLiteral<?> type)
  {
    List<TypeLiteral<?>> hierarchy = new ArrayList();
    TypeLiteral<?> current = type;
    while (current.getRawType() != Object.class)
    {
      hierarchy.add(current);
      current = current.getSupertype(current.getRawType().getSuperclass());
    }
    return hierarchy;
  }
  
  private static boolean overrides(Method a, Method b)
  {
    int modifiers = b.getModifiers();
    if ((Modifier.isPublic(modifiers)) || (Modifier.isProtected(modifiers))) {
      return true;
    }
    if (Modifier.isPrivate(modifiers)) {
      return false;
    }
    return a.getDeclaringClass().getPackage().equals(b.getDeclaringClass().getPackage());
  }
  
  static class Signature
  {
    final String name;
    final Class[] parameterTypes;
    final int hash;
    
    Signature(Method method)
    {
      name = method.getName();
      parameterTypes = method.getParameterTypes();
      
      int h = name.hashCode();
      h = h * 31 + parameterTypes.length;
      for (Class parameterType : parameterTypes) {
        h = h * 31 + parameterType.hashCode();
      }
      hash = h;
    }
    
    public int hashCode()
    {
      return hash;
    }
    
    public boolean equals(Object o)
    {
      if (!(o instanceof Signature)) {
        return false;
      }
      Signature other = (Signature)o;
      if (!name.equals(name)) {
        return false;
      }
      if (parameterTypes.length != parameterTypes.length) {
        return false;
      }
      for (int i = 0; i < parameterTypes.length; i++) {
        if (parameterTypes[i] != parameterTypes[i]) {
          return false;
        }
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */