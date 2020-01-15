package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ConfigurationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.util.Types;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.inject.Provider;

public class MoreTypes
{
  public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
  private static final Map<TypeLiteral<?>, TypeLiteral<?>> PRIMITIVE_TO_WRAPPER = new .ImmutableMap.Builder().put(TypeLiteral.get(Boolean.TYPE), TypeLiteral.get(Boolean.class)).put(TypeLiteral.get(Byte.TYPE), TypeLiteral.get(Byte.class)).put(TypeLiteral.get(Short.TYPE), TypeLiteral.get(Short.class)).put(TypeLiteral.get(Integer.TYPE), TypeLiteral.get(Integer.class)).put(TypeLiteral.get(Long.TYPE), TypeLiteral.get(Long.class)).put(TypeLiteral.get(Float.TYPE), TypeLiteral.get(Float.class)).put(TypeLiteral.get(Double.TYPE), TypeLiteral.get(Double.class)).put(TypeLiteral.get(Character.TYPE), TypeLiteral.get(Character.class)).put(TypeLiteral.get(Void.TYPE), TypeLiteral.get(Void.class)).build();
  
  public static <T> TypeLiteral<T> canonicalizeForKey(TypeLiteral<T> typeLiteral)
  {
    Type type = typeLiteral.getType();
    if (!isFullySpecified(type))
    {
      Errors errors = new Errors().keyNotFullySpecified(typeLiteral);
      throw new ConfigurationException(errors.getMessages());
    }
    if (typeLiteral.getRawType() == Provider.class)
    {
      ParameterizedType parameterizedType = (ParameterizedType)type;
      
      TypeLiteral<T> guiceProviderType = TypeLiteral.get(Types.providerOf(parameterizedType.getActualTypeArguments()[0]));
      
      return guiceProviderType;
    }
    TypeLiteral<T> wrappedPrimitives = (TypeLiteral)PRIMITIVE_TO_WRAPPER.get(typeLiteral);
    return wrappedPrimitives != null ? wrappedPrimitives : typeLiteral;
  }
  
  private static boolean isFullySpecified(Type type)
  {
    if ((type instanceof Class)) {
      return true;
    }
    if ((type instanceof CompositeType)) {
      return ((CompositeType)type).isFullySpecified();
    }
    if ((type instanceof TypeVariable)) {
      return false;
    }
    return ((CompositeType)canonicalize(type)).isFullySpecified();
  }
  
  public static Type canonicalize(Type type)
  {
    if ((type instanceof Class))
    {
      Class<?> c = (Class)type;
      return c.isArray() ? new GenericArrayTypeImpl(canonicalize(c.getComponentType())) : c;
    }
    if ((type instanceof CompositeType)) {
      return type;
    }
    if ((type instanceof ParameterizedType))
    {
      ParameterizedType p = (ParameterizedType)type;
      return new ParameterizedTypeImpl(p.getOwnerType(), p.getRawType(), p.getActualTypeArguments());
    }
    if ((type instanceof GenericArrayType))
    {
      GenericArrayType g = (GenericArrayType)type;
      return new GenericArrayTypeImpl(g.getGenericComponentType());
    }
    if ((type instanceof WildcardType))
    {
      WildcardType w = (WildcardType)type;
      return new WildcardTypeImpl(w.getUpperBounds(), w.getLowerBounds());
    }
    return type;
  }
  
  public static Class<?> getRawType(Type type)
  {
    if ((type instanceof Class)) {
      return (Class)type;
    }
    if ((type instanceof ParameterizedType))
    {
      ParameterizedType parameterizedType = (ParameterizedType)type;
      
      Type rawType = parameterizedType.getRawType();
      .Preconditions.checkArgument(rawType instanceof Class, "Expected a Class, but <%s> is of type %s", new Object[] { type, type.getClass().getName() });
      
      return (Class)rawType;
    }
    if ((type instanceof GenericArrayType))
    {
      Type componentType = ((GenericArrayType)type).getGenericComponentType();
      return Array.newInstance(getRawType(componentType), 0).getClass();
    }
    if ((type instanceof TypeVariable)) {
      return Object.class;
    }
    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
  }
  
  public static boolean equals(Type a, Type b)
  {
    if (a == b) {
      return true;
    }
    if ((a instanceof Class)) {
      return a.equals(b);
    }
    if ((a instanceof ParameterizedType))
    {
      if (!(b instanceof ParameterizedType)) {
        return false;
      }
      ParameterizedType pa = (ParameterizedType)a;
      ParameterizedType pb = (ParameterizedType)b;
      return (.Objects.equal(pa.getOwnerType(), pb.getOwnerType())) && (pa.getRawType().equals(pb.getRawType())) && (Arrays.equals(pa.getActualTypeArguments(), pb.getActualTypeArguments()));
    }
    if ((a instanceof GenericArrayType))
    {
      if (!(b instanceof GenericArrayType)) {
        return false;
      }
      GenericArrayType ga = (GenericArrayType)a;
      GenericArrayType gb = (GenericArrayType)b;
      return equals(ga.getGenericComponentType(), gb.getGenericComponentType());
    }
    if ((a instanceof WildcardType))
    {
      if (!(b instanceof WildcardType)) {
        return false;
      }
      WildcardType wa = (WildcardType)a;
      WildcardType wb = (WildcardType)b;
      return (Arrays.equals(wa.getUpperBounds(), wb.getUpperBounds())) && (Arrays.equals(wa.getLowerBounds(), wb.getLowerBounds()));
    }
    if ((a instanceof TypeVariable))
    {
      if (!(b instanceof TypeVariable)) {
        return false;
      }
      TypeVariable<?> va = (TypeVariable)a;
      TypeVariable<?> vb = (TypeVariable)b;
      return (va.getGenericDeclaration() == vb.getGenericDeclaration()) && (va.getName().equals(vb.getName()));
    }
    return false;
  }
  
  private static int hashCodeOrZero(Object o)
  {
    return o != null ? o.hashCode() : 0;
  }
  
  public static String typeToString(Type type)
  {
    return (type instanceof Class) ? ((Class)type).getName() : type.toString();
  }
  
  public static Type getGenericSupertype(Type type, Class<?> rawType, Class<?> toResolve)
  {
    if (toResolve == rawType) {
      return type;
    }
    if (toResolve.isInterface())
    {
      Class[] interfaces = rawType.getInterfaces();
      int i = 0;
      for (int length = interfaces.length; i < length; i++)
      {
        if (interfaces[i] == toResolve) {
          return rawType.getGenericInterfaces()[i];
        }
        if (toResolve.isAssignableFrom(interfaces[i])) {
          return getGenericSupertype(rawType.getGenericInterfaces()[i], interfaces[i], toResolve);
        }
      }
    }
    if (!rawType.isInterface()) {
      while (rawType != Object.class)
      {
        Class<?> rawSupertype = rawType.getSuperclass();
        if (rawSupertype == toResolve) {
          return rawType.getGenericSuperclass();
        }
        if (toResolve.isAssignableFrom(rawSupertype)) {
          return getGenericSupertype(rawType.getGenericSuperclass(), rawSupertype, toResolve);
        }
        rawType = rawSupertype;
      }
    }
    return toResolve;
  }
  
  public static Type resolveTypeVariable(Type type, Class<?> rawType, TypeVariable unknown)
  {
    Class<?> declaredByRaw = declaringClassOf(unknown);
    if (declaredByRaw == null) {
      return unknown;
    }
    Type declaredBy = getGenericSupertype(type, rawType, declaredByRaw);
    if ((declaredBy instanceof ParameterizedType))
    {
      int index = indexOf(declaredByRaw.getTypeParameters(), unknown);
      return ((ParameterizedType)declaredBy).getActualTypeArguments()[index];
    }
    return unknown;
  }
  
  private static int indexOf(Object[] array, Object toFind)
  {
    for (int i = 0; i < array.length; i++) {
      if (toFind.equals(array[i])) {
        return i;
      }
    }
    throw new NoSuchElementException();
  }
  
  private static Class<?> declaringClassOf(TypeVariable typeVariable)
  {
    GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
    return (genericDeclaration instanceof Class) ? (Class)genericDeclaration : null;
  }
  
  public static class ParameterizedTypeImpl
    implements ParameterizedType, Serializable, MoreTypes.CompositeType
  {
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;
    private static final long serialVersionUID = 0L;
    
    public ParameterizedTypeImpl(Type ownerType, Type rawType, Type... typeArguments)
    {
      if ((rawType instanceof Class))
      {
        Class rawTypeAsClass = (Class)rawType;
        .Preconditions.checkArgument((ownerType != null) || (rawTypeAsClass.getEnclosingClass() == null), "No owner type for enclosed %s", new Object[] { rawType });
        
        .Preconditions.checkArgument((ownerType == null) || (rawTypeAsClass.getEnclosingClass() != null), "Owner type for unenclosed %s", new Object[] { rawType });
      }
      this.ownerType = (ownerType == null ? null : MoreTypes.canonicalize(ownerType));
      this.rawType = MoreTypes.canonicalize(rawType);
      this.typeArguments = ((Type[])typeArguments.clone());
      for (int t = 0; t < this.typeArguments.length; t++)
      {
        .Preconditions.checkNotNull(this.typeArguments[t], "type parameter");
        MoreTypes.checkNotPrimitive(this.typeArguments[t], "type parameters");
        this.typeArguments[t] = MoreTypes.canonicalize(this.typeArguments[t]);
      }
    }
    
    public Type[] getActualTypeArguments()
    {
      return (Type[])typeArguments.clone();
    }
    
    public Type getRawType()
    {
      return rawType;
    }
    
    public Type getOwnerType()
    {
      return ownerType;
    }
    
    public boolean isFullySpecified()
    {
      if ((ownerType != null) && (!MoreTypes.isFullySpecified(ownerType))) {
        return false;
      }
      if (!MoreTypes.isFullySpecified(rawType)) {
        return false;
      }
      for (Type type : typeArguments) {
        if (!MoreTypes.isFullySpecified(type)) {
          return false;
        }
      }
      return true;
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof ParameterizedType)) && (MoreTypes.equals(this, (ParameterizedType)other));
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(typeArguments) ^ rawType.hashCode() ^ MoreTypes.hashCodeOrZero(ownerType);
    }
    
    public String toString()
    {
      StringBuilder stringBuilder = new StringBuilder(30 * (typeArguments.length + 1));
      stringBuilder.append(MoreTypes.typeToString(rawType));
      if (typeArguments.length == 0) {
        return stringBuilder.toString();
      }
      stringBuilder.append("<").append(MoreTypes.typeToString(typeArguments[0]));
      for (int i = 1; i < typeArguments.length; i++) {
        stringBuilder.append(", ").append(MoreTypes.typeToString(typeArguments[i]));
      }
      return ">";
    }
  }
  
  public static class GenericArrayTypeImpl
    implements GenericArrayType, Serializable, MoreTypes.CompositeType
  {
    private final Type componentType;
    private static final long serialVersionUID = 0L;
    
    public GenericArrayTypeImpl(Type componentType)
    {
      this.componentType = MoreTypes.canonicalize(componentType);
    }
    
    public Type getGenericComponentType()
    {
      return componentType;
    }
    
    public boolean isFullySpecified()
    {
      return MoreTypes.isFullySpecified(componentType);
    }
    
    public boolean equals(Object o)
    {
      return ((o instanceof GenericArrayType)) && (MoreTypes.equals(this, (GenericArrayType)o));
    }
    
    public int hashCode()
    {
      return componentType.hashCode();
    }
    
    public String toString()
    {
      return MoreTypes.typeToString(componentType) + "[]";
    }
  }
  
  public static class WildcardTypeImpl
    implements WildcardType, Serializable, MoreTypes.CompositeType
  {
    private final Type upperBound;
    private final Type lowerBound;
    private static final long serialVersionUID = 0L;
    
    public WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds)
    {
      .Preconditions.checkArgument(lowerBounds.length <= 1, "Must have at most one lower bound.");
      .Preconditions.checkArgument(upperBounds.length == 1, "Must have exactly one upper bound.");
      if (lowerBounds.length == 1)
      {
        .Preconditions.checkNotNull(lowerBounds[0], "lowerBound");
        MoreTypes.checkNotPrimitive(lowerBounds[0], "wildcard bounds");
        .Preconditions.checkArgument(upperBounds[0] == Object.class, "bounded both ways");
        lowerBound = MoreTypes.canonicalize(lowerBounds[0]);
        upperBound = Object.class;
      }
      else
      {
        .Preconditions.checkNotNull(upperBounds[0], "upperBound");
        MoreTypes.checkNotPrimitive(upperBounds[0], "wildcard bounds");
        lowerBound = null;
        upperBound = MoreTypes.canonicalize(upperBounds[0]);
      }
    }
    
    public Type[] getUpperBounds()
    {
      return new Type[] { upperBound };
    }
    
    public Type[] getLowerBounds()
    {
      return lowerBound != null ? new Type[] { lowerBound } : MoreTypes.EMPTY_TYPE_ARRAY;
    }
    
    public boolean isFullySpecified()
    {
      return (MoreTypes.isFullySpecified(upperBound)) && ((lowerBound == null) || (MoreTypes.isFullySpecified(lowerBound)));
    }
    
    public boolean equals(Object other)
    {
      return ((other instanceof WildcardType)) && (MoreTypes.equals(this, (WildcardType)other));
    }
    
    public int hashCode()
    {
      return (lowerBound != null ? 31 + lowerBound.hashCode() : 1) ^ 31 + upperBound.hashCode();
    }
    
    public String toString()
    {
      if (lowerBound != null) {
        return "? super " + MoreTypes.typeToString(lowerBound);
      }
      if (upperBound == Object.class) {
        return "?";
      }
      return "? extends " + MoreTypes.typeToString(upperBound);
    }
  }
  
  private static void checkNotPrimitive(Type type, String use)
  {
    .Preconditions.checkArgument((!(type instanceof Class)) || (!((Class)type).isPrimitive()), "Primitive types are not allowed in %s: %s", new Object[] { use, type });
  }
  
  private static abstract interface CompositeType
  {
    public abstract boolean isFullySpecified();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MoreTypes
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */