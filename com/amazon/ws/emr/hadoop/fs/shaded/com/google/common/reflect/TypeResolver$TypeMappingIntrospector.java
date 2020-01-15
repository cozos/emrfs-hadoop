package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;

final class TypeResolver$TypeMappingIntrospector
  extends TypeVisitor
{
  private static final TypeResolver.WildcardCapturer wildcardCapturer = new TypeResolver.WildcardCapturer(null);
  private final Map<TypeResolver.TypeVariableKey, Type> mappings = Maps.newHashMap();
  
  static ImmutableMap<TypeResolver.TypeVariableKey, Type> getTypeMappings(Type contextType)
  {
    TypeMappingIntrospector introspector = new TypeMappingIntrospector();
    introspector.visit(new Type[] { wildcardCapturer.capture(contextType) });
    return ImmutableMap.copyOf(mappings);
  }
  
  void visitClass(Class<?> clazz)
  {
    visit(new Type[] { clazz.getGenericSuperclass() });
    visit(clazz.getGenericInterfaces());
  }
  
  void visitParameterizedType(ParameterizedType parameterizedType)
  {
    Class<?> rawClass = (Class)parameterizedType.getRawType();
    TypeVariable<?>[] vars = rawClass.getTypeParameters();
    Type[] typeArgs = parameterizedType.getActualTypeArguments();
    Preconditions.checkState(vars.length == typeArgs.length);
    for (int i = 0; i < vars.length; i++) {
      map(new TypeResolver.TypeVariableKey(vars[i]), typeArgs[i]);
    }
    visit(new Type[] { rawClass });
    visit(new Type[] { parameterizedType.getOwnerType() });
  }
  
  void visitTypeVariable(TypeVariable<?> t)
  {
    visit(t.getBounds());
  }
  
  void visitWildcardType(WildcardType t)
  {
    visit(t.getUpperBounds());
  }
  
  private void map(TypeResolver.TypeVariableKey var, Type arg)
  {
    if (mappings.containsKey(var)) {
      return;
    }
    for (Type t = arg; t != null; t = (Type)mappings.get(TypeResolver.TypeVariableKey.forLookup(t))) {
      if (var.equalsType(t))
      {
        for (Type x = arg; x != null; x = (Type)mappings.remove(TypeResolver.TypeVariableKey.forLookup(x))) {}
        return;
      }
    }
    mappings.put(var, arg);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeResolver.TypeMappingIntrospector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */