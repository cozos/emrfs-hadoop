package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;

final class TypeResolver$1
  extends TypeVisitor
{
  TypeResolver$1(Map paramMap, Type paramType) {}
  
  void visitTypeVariable(TypeVariable<?> typeVariable)
  {
    val$mappings.put(new TypeResolver.TypeVariableKey(typeVariable), val$to);
  }
  
  void visitWildcardType(WildcardType fromWildcardType)
  {
    WildcardType toWildcardType = (WildcardType)TypeResolver.access$000(WildcardType.class, val$to);
    Type[] fromUpperBounds = fromWildcardType.getUpperBounds();
    Type[] toUpperBounds = toWildcardType.getUpperBounds();
    Type[] fromLowerBounds = fromWildcardType.getLowerBounds();
    Type[] toLowerBounds = toWildcardType.getLowerBounds();
    Preconditions.checkArgument((fromUpperBounds.length == toUpperBounds.length) && (fromLowerBounds.length == toLowerBounds.length), "Incompatible type: %s vs. %s", new Object[] { fromWildcardType, val$to });
    for (int i = 0; i < fromUpperBounds.length; i++) {
      TypeResolver.access$100(val$mappings, fromUpperBounds[i], toUpperBounds[i]);
    }
    for (int i = 0; i < fromLowerBounds.length; i++) {
      TypeResolver.access$100(val$mappings, fromLowerBounds[i], toLowerBounds[i]);
    }
  }
  
  void visitParameterizedType(ParameterizedType fromParameterizedType)
  {
    ParameterizedType toParameterizedType = (ParameterizedType)TypeResolver.access$000(ParameterizedType.class, val$to);
    Preconditions.checkArgument(fromParameterizedType.getRawType().equals(toParameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", new Object[] { fromParameterizedType, val$to });
    
    Type[] fromArgs = fromParameterizedType.getActualTypeArguments();
    Type[] toArgs = toParameterizedType.getActualTypeArguments();
    Preconditions.checkArgument(fromArgs.length == toArgs.length, "%s not compatible with %s", new Object[] { fromParameterizedType, toParameterizedType });
    for (int i = 0; i < fromArgs.length; i++) {
      TypeResolver.access$100(val$mappings, fromArgs[i], toArgs[i]);
    }
  }
  
  void visitGenericArrayType(GenericArrayType fromArrayType)
  {
    Type componentType = Types.getComponentType(val$to);
    Preconditions.checkArgument(componentType != null, "%s is not an array type.", new Object[] { val$to });
    TypeResolver.access$100(val$mappings, fromArrayType.getGenericComponentType(), componentType);
  }
  
  void visitClass(Class<?> fromClass)
  {
    String str = String.valueOf(String.valueOf(fromClass));throw new IllegalArgumentException(21 + str.length() + "No type mapping from " + str);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeResolver.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */