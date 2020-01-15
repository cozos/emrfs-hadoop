package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MoreTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Types;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

public class TypeLiteral<T>
{
  final Class<? super T> rawType;
  final Type type;
  final int hashCode;
  
  protected TypeLiteral()
  {
    type = getSuperclassTypeParameter(getClass());
    rawType = MoreTypes.getRawType(type);
    hashCode = type.hashCode();
  }
  
  TypeLiteral(Type type)
  {
    this.type = MoreTypes.canonicalize((Type).Preconditions.checkNotNull(type, "type"));
    rawType = MoreTypes.getRawType(this.type);
    hashCode = this.type.hashCode();
  }
  
  static Type getSuperclassTypeParameter(Class<?> subclass)
  {
    Type superclass = subclass.getGenericSuperclass();
    if ((superclass instanceof Class)) {
      throw new RuntimeException("Missing type parameter.");
    }
    ParameterizedType parameterized = (ParameterizedType)superclass;
    return MoreTypes.canonicalize(parameterized.getActualTypeArguments()[0]);
  }
  
  static TypeLiteral<?> fromSuperclassTypeParameter(Class<?> subclass)
  {
    return new TypeLiteral(getSuperclassTypeParameter(subclass));
  }
  
  public final Class<? super T> getRawType()
  {
    return rawType;
  }
  
  public final Type getType()
  {
    return type;
  }
  
  final TypeLiteral<Provider<T>> providerType()
  {
    return get(Types.providerOf(getType()));
  }
  
  public final int hashCode()
  {
    return hashCode;
  }
  
  public final boolean equals(Object o)
  {
    return ((o instanceof TypeLiteral)) && (MoreTypes.equals(type, type));
  }
  
  public final String toString()
  {
    return MoreTypes.typeToString(type);
  }
  
  public static TypeLiteral<?> get(Type type)
  {
    return new TypeLiteral(type);
  }
  
  public static <T> TypeLiteral<T> get(Class<T> type)
  {
    return new TypeLiteral(type);
  }
  
  private List<TypeLiteral<?>> resolveAll(Type[] types)
  {
    TypeLiteral<?>[] result = new TypeLiteral[types.length];
    for (int t = 0; t < types.length; t++) {
      result[t] = resolve(types[t]);
    }
    return .ImmutableList.of(result);
  }
  
  TypeLiteral<?> resolve(Type toResolve)
  {
    return get(resolveType(toResolve));
  }
  
  Type resolveType(Type toResolve)
  {
    while ((toResolve instanceof TypeVariable))
    {
      TypeVariable original = (TypeVariable)toResolve;
      toResolve = MoreTypes.resolveTypeVariable(type, rawType, original);
      if (toResolve == original) {
        return toResolve;
      }
    }
    if ((toResolve instanceof GenericArrayType))
    {
      GenericArrayType original = (GenericArrayType)toResolve;
      Type componentType = original.getGenericComponentType();
      Type newComponentType = resolveType(componentType);
      return componentType == newComponentType ? original : Types.arrayOf(newComponentType);
    }
    if ((toResolve instanceof ParameterizedType))
    {
      ParameterizedType original = (ParameterizedType)toResolve;
      Type ownerType = original.getOwnerType();
      Type newOwnerType = resolveType(ownerType);
      boolean changed = newOwnerType != ownerType;
      
      Type[] args = original.getActualTypeArguments();
      int t = 0;
      for (int length = args.length; t < length; t++)
      {
        Type resolvedTypeArgument = resolveType(args[t]);
        if (resolvedTypeArgument != args[t])
        {
          if (!changed)
          {
            args = (Type[])args.clone();
            changed = true;
          }
          args[t] = resolvedTypeArgument;
        }
      }
      return changed ? Types.newParameterizedTypeWithOwner(newOwnerType, original.getRawType(), args) : original;
    }
    if ((toResolve instanceof WildcardType))
    {
      WildcardType original = (WildcardType)toResolve;
      Type[] originalLowerBound = original.getLowerBounds();
      Type[] originalUpperBound = original.getUpperBounds();
      if (originalLowerBound.length == 1)
      {
        Type lowerBound = resolveType(originalLowerBound[0]);
        if (lowerBound != originalLowerBound[0]) {
          return Types.supertypeOf(lowerBound);
        }
      }
      else if (originalUpperBound.length == 1)
      {
        Type upperBound = resolveType(originalUpperBound[0]);
        if (upperBound != originalUpperBound[0]) {
          return Types.subtypeOf(upperBound);
        }
      }
      return original;
    }
    return toResolve;
  }
  
  public TypeLiteral<?> getSupertype(Class<?> supertype)
  {
    .Preconditions.checkArgument(supertype.isAssignableFrom(rawType), "%s is not a supertype of %s", new Object[] { supertype, type });
    
    return resolve(MoreTypes.getGenericSupertype(type, rawType, supertype));
  }
  
  public TypeLiteral<?> getFieldType(Field field)
  {
    .Preconditions.checkArgument(field.getDeclaringClass().isAssignableFrom(rawType), "%s is not defined by a supertype of %s", new Object[] { field, type });
    
    return resolve(field.getGenericType());
  }
  
  public List<TypeLiteral<?>> getParameterTypes(Member methodOrConstructor)
  {
    Type[] genericParameterTypes;
    if ((methodOrConstructor instanceof Method))
    {
      Method method = (Method)methodOrConstructor;
      .Preconditions.checkArgument(method.getDeclaringClass().isAssignableFrom(rawType), "%s is not defined by a supertype of %s", new Object[] { method, type });
      
      genericParameterTypes = method.getGenericParameterTypes();
    }
    else
    {
      Type[] genericParameterTypes;
      if ((methodOrConstructor instanceof Constructor))
      {
        Constructor<?> constructor = (Constructor)methodOrConstructor;
        .Preconditions.checkArgument(constructor.getDeclaringClass().isAssignableFrom(rawType), "%s does not construct a supertype of %s", new Object[] { constructor, type });
        
        genericParameterTypes = constructor.getGenericParameterTypes();
      }
      else
      {
        throw new IllegalArgumentException("Not a method or a constructor: " + methodOrConstructor);
      }
    }
    Type[] genericParameterTypes;
    return resolveAll(genericParameterTypes);
  }
  
  public List<TypeLiteral<?>> getExceptionTypes(Member methodOrConstructor)
  {
    Type[] genericExceptionTypes;
    if ((methodOrConstructor instanceof Method))
    {
      Method method = (Method)methodOrConstructor;
      .Preconditions.checkArgument(method.getDeclaringClass().isAssignableFrom(rawType), "%s is not defined by a supertype of %s", new Object[] { method, type });
      
      genericExceptionTypes = method.getGenericExceptionTypes();
    }
    else
    {
      Type[] genericExceptionTypes;
      if ((methodOrConstructor instanceof Constructor))
      {
        Constructor<?> constructor = (Constructor)methodOrConstructor;
        .Preconditions.checkArgument(constructor.getDeclaringClass().isAssignableFrom(rawType), "%s does not construct a supertype of %s", new Object[] { constructor, type });
        
        genericExceptionTypes = constructor.getGenericExceptionTypes();
      }
      else
      {
        throw new IllegalArgumentException("Not a method or a constructor: " + methodOrConstructor);
      }
    }
    Type[] genericExceptionTypes;
    return resolveAll(genericExceptionTypes);
  }
  
  public TypeLiteral<?> getReturnType(Method method)
  {
    .Preconditions.checkArgument(method.getDeclaringClass().isAssignableFrom(rawType), "%s is not defined by a supertype of %s", new Object[] { method, type });
    
    return resolve(method.getGenericReturnType());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */