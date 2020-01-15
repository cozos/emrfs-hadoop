package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.Builder;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

class TypeResolver$TypeTable
{
  private final ImmutableMap<TypeResolver.TypeVariableKey, Type> map;
  
  TypeResolver$TypeTable()
  {
    map = ImmutableMap.of();
  }
  
  private TypeResolver$TypeTable(ImmutableMap<TypeResolver.TypeVariableKey, Type> map)
  {
    this.map = map;
  }
  
  final TypeTable where(Map<TypeResolver.TypeVariableKey, ? extends Type> mappings)
  {
    ImmutableMap.Builder<TypeResolver.TypeVariableKey, Type> builder = ImmutableMap.builder();
    builder.putAll(map);
    for (Map.Entry<TypeResolver.TypeVariableKey, ? extends Type> mapping : mappings.entrySet())
    {
      TypeResolver.TypeVariableKey variable = (TypeResolver.TypeVariableKey)mapping.getKey();
      Type type = (Type)mapping.getValue();
      Preconditions.checkArgument(!variable.equalsType(type), "Type variable %s bound to itself", new Object[] { variable });
      builder.put(variable, type);
    }
    return new TypeTable(builder.build());
  }
  
  final Type resolve(final TypeVariable<?> var)
  {
    final TypeTable unguarded = this;
    TypeTable guarded = new TypeTable()
    {
      public Type resolveInternal(TypeVariable<?> intermediateVar, TypeResolver.TypeTable forDependent)
      {
        if (intermediateVar.getGenericDeclaration().equals(var.getGenericDeclaration())) {
          return intermediateVar;
        }
        return unguarded.resolveInternal(intermediateVar, forDependent);
      }
    };
    return resolveInternal(var, guarded);
  }
  
  Type resolveInternal(TypeVariable<?> var, TypeTable forDependants)
  {
    Type type = (Type)map.get(new TypeResolver.TypeVariableKey(var));
    if (type == null)
    {
      Type[] bounds = var.getBounds();
      if (bounds.length == 0) {
        return var;
      }
      Type[] resolvedBounds = TypeResolver.access$300(new TypeResolver(forDependants, null), bounds);
      if ((Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY) && (Arrays.equals(bounds, resolvedBounds))) {
        return var;
      }
      return Types.newArtificialTypeVariable(var.getGenericDeclaration(), var.getName(), resolvedBounds);
    }
    return new TypeResolver(forDependants, null).resolveType(type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeResolver.TypeTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */