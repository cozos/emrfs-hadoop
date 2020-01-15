package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.reflect.ParameterizedType;
import javax.annotation.Nullable;

 enum Types$ClassOwnership
{
  OWNED_BY_ENCLOSING_CLASS,  LOCAL_CLASS_HAS_NO_OWNER;
  
  static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();
  
  private Types$ClassOwnership() {}
  
  @Nullable
  abstract Class<?> getOwnerType(Class<?> paramClass);
  
  private static ClassOwnership detectJvmBehavior()
  {
    Class<?> subclass = new 1LocalClass() {}.getClass();
    ParameterizedType parameterizedType = (ParameterizedType)subclass.getGenericSuperclass();
    for (ClassOwnership behavior : values()) {
      if (behavior.getOwnerType(1LocalClass.class) == parameterizedType.getOwnerType()) {
        return behavior;
      }
    }
    throw new AssertionError();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.ClassOwnership
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */