package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ClassUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

abstract class MemberUtils
{
  private static final int ACCESS_TEST = 7;
  private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = { Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE };
  
  static boolean setAccessibleWorkaround(AccessibleObject o)
  {
    if ((o == null) || (o.isAccessible())) {
      return false;
    }
    Member m = (Member)o;
    if ((!o.isAccessible()) && (Modifier.isPublic(m.getModifiers())) && (isPackageAccess(m.getDeclaringClass().getModifiers()))) {
      try
      {
        o.setAccessible(true);
        return true;
      }
      catch (SecurityException e) {}
    }
    return false;
  }
  
  static boolean isPackageAccess(int modifiers)
  {
    return (modifiers & 0x7) == 0;
  }
  
  static boolean isAccessible(Member m)
  {
    return (m != null) && (Modifier.isPublic(m.getModifiers())) && (!m.isSynthetic());
  }
  
  static int compareParameterTypes(Class<?>[] left, Class<?>[] right, Class<?>[] actual)
  {
    float leftCost = getTotalTransformationCost(actual, left);
    float rightCost = getTotalTransformationCost(actual, right);
    return rightCost < leftCost ? 1 : leftCost < rightCost ? -1 : 0;
  }
  
  private static float getTotalTransformationCost(Class<?>[] srcArgs, Class<?>[] destArgs)
  {
    float totalCost = 0.0F;
    for (int i = 0; i < srcArgs.length; i++)
    {
      Class<?> srcClass = srcArgs[i];
      Class<?> destClass = destArgs[i];
      totalCost += getObjectTransformationCost(srcClass, destClass);
    }
    return totalCost;
  }
  
  private static float getObjectTransformationCost(Class<?> srcClass, Class<?> destClass)
  {
    if (destClass.isPrimitive()) {
      return getPrimitivePromotionCost(srcClass, destClass);
    }
    float cost = 0.0F;
    while ((srcClass != null) && (!destClass.equals(srcClass)))
    {
      if ((destClass.isInterface()) && (ClassUtils.isAssignable(srcClass, destClass)))
      {
        cost += 0.25F;
        break;
      }
      cost += 1.0F;
      srcClass = srcClass.getSuperclass();
    }
    if (srcClass == null) {
      cost += 1.5F;
    }
    return cost;
  }
  
  private static float getPrimitivePromotionCost(Class<?> srcClass, Class<?> destClass)
  {
    float cost = 0.0F;
    Class<?> cls = srcClass;
    if (!cls.isPrimitive())
    {
      cost += 0.1F;
      cls = ClassUtils.wrapperToPrimitive(cls);
    }
    for (int i = 0; (cls != destClass) && (i < ORDERED_PRIMITIVE_TYPES.length); i++) {
      if (cls == ORDERED_PRIMITIVE_TYPES[i])
      {
        cost += 0.1F;
        if (i < ORDERED_PRIMITIVE_TYPES.length - 1) {
          cls = ORDERED_PRIMITIVE_TYPES[(i + 1)];
        }
      }
    }
    return cost;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.MemberUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */