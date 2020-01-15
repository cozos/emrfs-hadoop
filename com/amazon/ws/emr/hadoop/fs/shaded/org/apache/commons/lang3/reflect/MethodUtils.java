package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ArrayUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ClassUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ClassUtils.Interfaces;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.Validate;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MethodUtils
{
  public static Object invokeMethod(Object object, String methodName, Object... args)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    args = ArrayUtils.nullToEmpty(args);
    Class<?>[] parameterTypes = ClassUtils.toClass(args);
    return invokeMethod(object, methodName, args, parameterTypes);
  }
  
  public static Object invokeMethod(Object object, String methodName, Object[] args, Class<?>[] parameterTypes)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    parameterTypes = ArrayUtils.nullToEmpty(parameterTypes);
    args = ArrayUtils.nullToEmpty(args);
    Method method = getMatchingAccessibleMethod(object.getClass(), methodName, parameterTypes);
    if (method == null) {
      throw new NoSuchMethodException("No such accessible method: " + methodName + "() on object: " + object.getClass().getName());
    }
    return method.invoke(object, args);
  }
  
  public static Object invokeExactMethod(Object object, String methodName, Object... args)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    args = ArrayUtils.nullToEmpty(args);
    Class<?>[] parameterTypes = ClassUtils.toClass(args);
    return invokeExactMethod(object, methodName, args, parameterTypes);
  }
  
  public static Object invokeExactMethod(Object object, String methodName, Object[] args, Class<?>[] parameterTypes)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    args = ArrayUtils.nullToEmpty(args);
    parameterTypes = ArrayUtils.nullToEmpty(parameterTypes);
    Method method = getAccessibleMethod(object.getClass(), methodName, parameterTypes);
    if (method == null) {
      throw new NoSuchMethodException("No such accessible method: " + methodName + "() on object: " + object.getClass().getName());
    }
    return method.invoke(object, args);
  }
  
  public static Object invokeExactStaticMethod(Class<?> cls, String methodName, Object[] args, Class<?>[] parameterTypes)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    args = ArrayUtils.nullToEmpty(args);
    parameterTypes = ArrayUtils.nullToEmpty(parameterTypes);
    Method method = getAccessibleMethod(cls, methodName, parameterTypes);
    if (method == null) {
      throw new NoSuchMethodException("No such accessible method: " + methodName + "() on class: " + cls.getName());
    }
    return method.invoke(null, args);
  }
  
  public static Object invokeStaticMethod(Class<?> cls, String methodName, Object... args)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    args = ArrayUtils.nullToEmpty(args);
    Class<?>[] parameterTypes = ClassUtils.toClass(args);
    return invokeStaticMethod(cls, methodName, args, parameterTypes);
  }
  
  public static Object invokeStaticMethod(Class<?> cls, String methodName, Object[] args, Class<?>[] parameterTypes)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    args = ArrayUtils.nullToEmpty(args);
    parameterTypes = ArrayUtils.nullToEmpty(parameterTypes);
    Method method = getMatchingAccessibleMethod(cls, methodName, parameterTypes);
    if (method == null) {
      throw new NoSuchMethodException("No such accessible method: " + methodName + "() on class: " + cls.getName());
    }
    return method.invoke(null, args);
  }
  
  public static Object invokeExactStaticMethod(Class<?> cls, String methodName, Object... args)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    args = ArrayUtils.nullToEmpty(args);
    Class<?>[] parameterTypes = ClassUtils.toClass(args);
    return invokeExactStaticMethod(cls, methodName, args, parameterTypes);
  }
  
  public static Method getAccessibleMethod(Class<?> cls, String methodName, Class<?>... parameterTypes)
  {
    try
    {
      return getAccessibleMethod(cls.getMethod(methodName, parameterTypes));
    }
    catch (NoSuchMethodException e) {}
    return null;
  }
  
  public static Method getAccessibleMethod(Method method)
  {
    if (!MemberUtils.isAccessible(method)) {
      return null;
    }
    Class<?> cls = method.getDeclaringClass();
    if (Modifier.isPublic(cls.getModifiers())) {
      return method;
    }
    String methodName = method.getName();
    Class<?>[] parameterTypes = method.getParameterTypes();
    
    method = getAccessibleMethodFromInterfaceNest(cls, methodName, parameterTypes);
    if (method == null) {
      method = getAccessibleMethodFromSuperclass(cls, methodName, parameterTypes);
    }
    return method;
  }
  
  private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String methodName, Class<?>... parameterTypes)
  {
    Class<?> parentClass = cls.getSuperclass();
    while (parentClass != null)
    {
      if (Modifier.isPublic(parentClass.getModifiers())) {
        try
        {
          return parentClass.getMethod(methodName, parameterTypes);
        }
        catch (NoSuchMethodException e)
        {
          return null;
        }
      }
      parentClass = parentClass.getSuperclass();
    }
    return null;
  }
  
  private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String methodName, Class<?>... parameterTypes)
  {
    for (; cls != null; cls = cls.getSuperclass())
    {
      Class<?>[] interfaces = cls.getInterfaces();
      for (int i = 0; i < interfaces.length; i++) {
        if (Modifier.isPublic(interfaces[i].getModifiers())) {
          try
          {
            return interfaces[i].getDeclaredMethod(methodName, parameterTypes);
          }
          catch (NoSuchMethodException e)
          {
            Method method = getAccessibleMethodFromInterfaceNest(interfaces[i], methodName, parameterTypes);
            if (method != null) {
              return method;
            }
          }
        }
      }
    }
    return null;
  }
  
  public static Method getMatchingAccessibleMethod(Class<?> cls, String methodName, Class<?>... parameterTypes)
  {
    try
    {
      Method method = cls.getMethod(methodName, parameterTypes);
      MemberUtils.setAccessibleWorkaround(method);
      return method;
    }
    catch (NoSuchMethodException e)
    {
      Method bestMatch = null;
      Method[] methods = cls.getMethods();
      for (Method method : methods) {
        if ((method.getName().equals(methodName)) && (ClassUtils.isAssignable(parameterTypes, method.getParameterTypes(), true)))
        {
          Method accessibleMethod = getAccessibleMethod(method);
          if ((accessibleMethod != null) && ((bestMatch == null) || (MemberUtils.compareParameterTypes(accessibleMethod.getParameterTypes(), bestMatch.getParameterTypes(), parameterTypes) < 0))) {
            bestMatch = accessibleMethod;
          }
        }
      }
      if (bestMatch != null) {
        MemberUtils.setAccessibleWorkaround(bestMatch);
      }
      return bestMatch;
    }
  }
  
  public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfacesBehavior)
  {
    Validate.notNull(method);
    Set<Method> result = new LinkedHashSet();
    result.add(method);
    
    Class<?>[] parameterTypes = method.getParameterTypes();
    
    Class<?> declaringClass = method.getDeclaringClass();
    
    Iterator<Class<?>> hierarchy = ClassUtils.hierarchy(declaringClass, interfacesBehavior).iterator();
    
    hierarchy.next();
    while (hierarchy.hasNext())
    {
      Class<?> c = (Class)hierarchy.next();
      Method m = getMatchingAccessibleMethod(c, method.getName(), parameterTypes);
      if (m != null) {
        if (Arrays.equals(m.getParameterTypes(), parameterTypes))
        {
          result.add(m);
        }
        else
        {
          Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, m.getDeclaringClass());
          for (int i = 0;; i++)
          {
            if (i >= parameterTypes.length) {
              break label189;
            }
            Type childType = TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i]);
            Type parentType = TypeUtils.unrollVariables(typeArguments, m.getGenericParameterTypes()[i]);
            if (!TypeUtils.equals(childType, parentType)) {
              break;
            }
          }
          label189:
          result.add(m);
        }
      }
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.MethodUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */