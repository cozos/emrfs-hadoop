package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Module;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Provides;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.LinkedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Dependency;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Modules;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

public final class ProviderMethodsModule
  implements Module
{
  private final Object delegate;
  private final TypeLiteral<?> typeLiteral;
  
  private ProviderMethodsModule(Object delegate)
  {
    this.delegate = .Preconditions.checkNotNull(delegate, "delegate");
    typeLiteral = TypeLiteral.get(this.delegate.getClass());
  }
  
  public static Module forModule(Module module)
  {
    return forObject(module);
  }
  
  public static Module forObject(Object object)
  {
    if ((object instanceof ProviderMethodsModule)) {
      return Modules.EMPTY_MODULE;
    }
    return new ProviderMethodsModule(object);
  }
  
  public synchronized void configure(Binder binder)
  {
    for (ProviderMethod<?> providerMethod : getProviderMethods(binder)) {
      providerMethod.configure(binder);
    }
  }
  
  public List<ProviderMethod<?>> getProviderMethods(Binder binder)
  {
    List<ProviderMethod<?>> result = .Lists.newArrayList();
    for (Class<?> c = delegate.getClass(); c != Object.class; c = c.getSuperclass()) {
      for (Method method : c.getDeclaredMethods()) {
        if (method.isAnnotationPresent(Provides.class)) {
          result.add(createProviderMethod(binder, method));
        }
      }
    }
    return result;
  }
  
  <T> ProviderMethod<T> createProviderMethod(Binder binder, Method method)
  {
    binder = binder.withSource(method);
    Errors errors = new Errors(method);
    
    List<Dependency<?>> dependencies = .Lists.newArrayList();
    List<Provider<?>> parameterProviders = .Lists.newArrayList();
    List<TypeLiteral<?>> parameterTypes = typeLiteral.getParameterTypes(method);
    Annotation[][] parameterAnnotations = method.getParameterAnnotations();
    for (int i = 0; i < parameterTypes.size(); i++)
    {
      Key<?> key = getKey(errors, (TypeLiteral)parameterTypes.get(i), method, parameterAnnotations[i]);
      if (key.equals(Key.get(Logger.class)))
      {
        Key<Logger> loggerKey = Key.get(Logger.class, UniqueAnnotations.create());
        binder.bind(loggerKey).toProvider(new LogProvider(method));
        key = loggerKey;
      }
      dependencies.add(Dependency.get(key));
      parameterProviders.add(binder.getProvider(key));
    }
    TypeLiteral<T> returnType = typeLiteral.getReturnType(method);
    
    Key<T> key = getKey(errors, returnType, method, method.getAnnotations());
    Class<? extends Annotation> scopeAnnotation = Annotations.findScopeAnnotation(errors, method.getAnnotations());
    for (Message message : errors.getMessages()) {
      binder.addError(message);
    }
    return new ProviderMethod(key, method, delegate, .ImmutableSet.copyOf(dependencies), parameterProviders, scopeAnnotation);
  }
  
  <T> Key<T> getKey(Errors errors, TypeLiteral<T> type, Member member, Annotation[] annotations)
  {
    Annotation bindingAnnotation = Annotations.findBindingAnnotation(errors, member, annotations);
    return bindingAnnotation == null ? Key.get(type) : Key.get(type, bindingAnnotation);
  }
  
  public boolean equals(Object o)
  {
    return ((o instanceof ProviderMethodsModule)) && (delegate == delegate);
  }
  
  public int hashCode()
  {
    return delegate.hashCode();
  }
  
  private static final class LogProvider
    implements Provider<Logger>
  {
    private final String name;
    
    public LogProvider(Method method)
    {
      name = (method.getDeclaringClass().getName() + "." + method.getName());
    }
    
    public Logger get()
    {
      return Logger.getLogger(name);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProviderMethodsModule
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */