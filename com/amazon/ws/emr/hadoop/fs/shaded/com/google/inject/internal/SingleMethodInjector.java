package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

final class SingleMethodInjector
  implements SingleMemberInjector
{
  private final InjectorImpl.MethodInvoker methodInvoker;
  private final SingleParameterInjector<?>[] parameterInjectors;
  private final InjectionPoint injectionPoint;
  
  SingleMethodInjector(InjectorImpl injector, InjectionPoint injectionPoint, Errors errors)
    throws ErrorsException
  {
    this.injectionPoint = injectionPoint;
    Method method = (Method)injectionPoint.getMember();
    methodInvoker = createMethodInvoker(method);
    parameterInjectors = injector.getParametersInjectors(injectionPoint.getDependencies(), errors);
  }
  
  private InjectorImpl.MethodInvoker createMethodInvoker(final Method method)
  {
    int modifiers = method.getModifiers();
    if ((!Modifier.isPrivate(modifiers)) && (!Modifier.isProtected(modifiers))) {
      try
      {
        final .FastMethod fastMethod = BytecodeGen.newFastClass(method.getDeclaringClass(), BytecodeGen.Visibility.forMember(method)).getMethod(method);
        
        new InjectorImpl.MethodInvoker()
        {
          public Object invoke(Object target, Object... parameters)
            throws IllegalAccessException, InvocationTargetException
          {
            return fastMethod.invoke(target, parameters);
          }
        };
      }
      catch (.CodeGenerationException e) {}
    }
    if ((!Modifier.isPublic(modifiers)) || (!Modifier.isPublic(method.getDeclaringClass().getModifiers()))) {
      method.setAccessible(true);
    }
    new InjectorImpl.MethodInvoker()
    {
      public Object invoke(Object target, Object... parameters)
        throws IllegalAccessException, InvocationTargetException
      {
        return method.invoke(target, parameters);
      }
    };
  }
  
  public InjectionPoint getInjectionPoint()
  {
    return injectionPoint;
  }
  
  public void inject(Errors errors, InternalContext context, Object o)
  {
    Object[] parameters;
    try
    {
      parameters = SingleParameterInjector.getAll(errors, context, parameterInjectors);
    }
    catch (ErrorsException e)
    {
      errors.merge(e.getErrors());
      return;
    }
    try
    {
      methodInvoker.invoke(o, parameters);
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
    catch (InvocationTargetException userException)
    {
      Throwable cause = userException.getCause() != null ? userException.getCause() : userException;
      
      errors.withSource(injectionPoint).errorInjectingMethod(cause);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.SingleMethodInjector
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */