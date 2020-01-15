package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

final class Types
{
  private static final Function<Type, String> TYPE_NAME = new Function()
  {
    public String apply(Type from)
    {
      return Types.JavaVersion.CURRENT.typeName(from);
    }
  };
  private static final Joiner COMMA_JOINER = Joiner.on(", ").useForNull("null");
  
  static Type newArrayType(Type componentType)
  {
    if ((componentType instanceof WildcardType))
    {
      WildcardType wildcard = (WildcardType)componentType;
      Type[] lowerBounds = wildcard.getLowerBounds();
      Preconditions.checkArgument(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
      if (lowerBounds.length == 1) {
        return supertypeOf(newArrayType(lowerBounds[0]));
      }
      Type[] upperBounds = wildcard.getUpperBounds();
      Preconditions.checkArgument(upperBounds.length == 1, "Wildcard should have only one upper bound.");
      return subtypeOf(newArrayType(upperBounds[0]));
    }
    return JavaVersion.CURRENT.newArrayType(componentType);
  }
  
  static ParameterizedType newParameterizedTypeWithOwner(@Nullable Type ownerType, Class<?> rawType, Type... arguments)
  {
    if (ownerType == null) {
      return newParameterizedType(rawType, arguments);
    }
    Preconditions.checkNotNull(arguments);
    Preconditions.checkArgument(rawType.getEnclosingClass() != null, "Owner type for unenclosed %s", new Object[] { rawType });
    return new ParameterizedTypeImpl(ownerType, rawType, arguments);
  }
  
  static ParameterizedType newParameterizedType(Class<?> rawType, Type... arguments)
  {
    return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(rawType), rawType, arguments);
  }
  
  private static abstract enum ClassOwnership
  {
    OWNED_BY_ENCLOSING_CLASS,  LOCAL_CLASS_HAS_NO_OWNER;
    
    static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();
    
    private ClassOwnership() {}
    
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
  
  static <D extends GenericDeclaration> TypeVariable<D> newArtificialTypeVariable(D declaration, String name, Type... bounds)
  {
    return new TypeVariableImpl(declaration, name, bounds.length == 0 ? new Type[] { Object.class } : bounds);
  }
  
  @VisibleForTesting
  static WildcardType subtypeOf(Type upperBound)
  {
    return new WildcardTypeImpl(new Type[0], new Type[] { upperBound });
  }
  
  @VisibleForTesting
  static WildcardType supertypeOf(Type lowerBound)
  {
    return new WildcardTypeImpl(new Type[] { lowerBound }, new Type[] { Object.class });
  }
  
  static String toString(Type type)
  {
    return (type instanceof Class) ? ((Class)type).getName() : type.toString();
  }
  
  @Nullable
  static Type getComponentType(Type type)
  {
    Preconditions.checkNotNull(type);
    AtomicReference<Type> result = new AtomicReference();
    new TypeVisitor()
    {
      void visitTypeVariable(TypeVariable<?> t)
      {
        val$result.set(Types.subtypeOfComponentType(t.getBounds()));
      }
      
      void visitWildcardType(WildcardType t)
      {
        val$result.set(Types.subtypeOfComponentType(t.getUpperBounds()));
      }
      
      void visitGenericArrayType(GenericArrayType t)
      {
        val$result.set(t.getGenericComponentType());
      }
      
      void visitClass(Class<?> t)
      {
        val$result.set(t.getComponentType());
      }
    }.visit(new Type[] { type });
    
    return (Type)result.get();
  }
  
  @Nullable
  private static Type subtypeOfComponentType(Type[] bounds)
  {
    for (Type bound : bounds)
    {
      Type componentType = getComponentType(bound);
      if (componentType != null)
      {
        if ((componentType instanceof Class))
        {
          Class<?> componentClass = (Class)componentType;
          if (componentClass.isPrimitive()) {
            return componentClass;
          }
        }
        return subtypeOf(componentType);
      }
    }
    return null;
  }
  
  private static final class GenericArrayTypeImpl
    implements GenericArrayType, Serializable
  {
    private final Type componentType;
    private static final long serialVersionUID = 0L;
    
    GenericArrayTypeImpl(Type componentType)
    {
      this.componentType = Types.JavaVersion.CURRENT.usedInGenericType(componentType);
    }
    
    public Type getGenericComponentType()
    {
      return componentType;
    }
    
    public String toString()
    {
      return String.valueOf(Types.toString(componentType)).concat("[]");
    }
    
    public int hashCode()
    {
      return componentType.hashCode();
    }
    
    public boolean equals(Object obj)
    {
      if ((obj instanceof GenericArrayType))
      {
        GenericArrayType that = (GenericArrayType)obj;
        return Objects.equal(getGenericComponentType(), that.getGenericComponentType());
      }
      return false;
    }
  }
  
  private static final class ParameterizedTypeImpl
    implements ParameterizedType, Serializable
  {
    private final Type ownerType;
    private final ImmutableList<Type> argumentsList;
    private final Class<?> rawType;
    private static final long serialVersionUID = 0L;
    
    ParameterizedTypeImpl(@Nullable Type ownerType, Class<?> rawType, Type[] typeArguments)
    {
      Preconditions.checkNotNull(rawType);
      Preconditions.checkArgument(typeArguments.length == rawType.getTypeParameters().length);
      Types.disallowPrimitiveType(typeArguments, "type parameter");
      this.ownerType = ownerType;
      this.rawType = rawType;
      argumentsList = Types.JavaVersion.CURRENT.usedInGenericType(typeArguments);
    }
    
    public Type[] getActualTypeArguments()
    {
      return Types.toArray(argumentsList);
    }
    
    public Type getRawType()
    {
      return rawType;
    }
    
    public Type getOwnerType()
    {
      return ownerType;
    }
    
    public String toString()
    {
      StringBuilder builder = new StringBuilder();
      if (ownerType != null) {
        builder.append(Types.JavaVersion.CURRENT.typeName(ownerType)).append('.');
      }
      builder.append(rawType.getName()).append('<').append(Types.COMMA_JOINER.join(Iterables.transform(argumentsList, Types.TYPE_NAME))).append('>');
      
      return builder.toString();
    }
    
    public int hashCode()
    {
      return (ownerType == null ? 0 : ownerType.hashCode()) ^ argumentsList.hashCode() ^ rawType.hashCode();
    }
    
    public boolean equals(Object other)
    {
      if (!(other instanceof ParameterizedType)) {
        return false;
      }
      ParameterizedType that = (ParameterizedType)other;
      return (getRawType().equals(that.getRawType())) && (Objects.equal(getOwnerType(), that.getOwnerType())) && (Arrays.equals(getActualTypeArguments(), that.getActualTypeArguments()));
    }
  }
  
  private static final class TypeVariableImpl<D extends GenericDeclaration>
    implements TypeVariable<D>
  {
    private final D genericDeclaration;
    private final String name;
    private final ImmutableList<Type> bounds;
    
    TypeVariableImpl(D genericDeclaration, String name, Type[] bounds)
    {
      Types.disallowPrimitiveType(bounds, "bound for type variable");
      this.genericDeclaration = ((GenericDeclaration)Preconditions.checkNotNull(genericDeclaration));
      this.name = ((String)Preconditions.checkNotNull(name));
      this.bounds = ImmutableList.copyOf(bounds);
    }
    
    public Type[] getBounds()
    {
      return Types.toArray(bounds);
    }
    
    public D getGenericDeclaration()
    {
      return genericDeclaration;
    }
    
    public String getName()
    {
      return name;
    }
    
    public String toString()
    {
      return name;
    }
    
    public int hashCode()
    {
      return genericDeclaration.hashCode() ^ name.hashCode();
    }
    
    public boolean equals(Object obj)
    {
      if (Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY)
      {
        if ((obj instanceof TypeVariableImpl))
        {
          TypeVariableImpl<?> that = (TypeVariableImpl)obj;
          return (name.equals(that.getName())) && (genericDeclaration.equals(that.getGenericDeclaration())) && (bounds.equals(bounds));
        }
        return false;
      }
      if ((obj instanceof TypeVariable))
      {
        TypeVariable<?> that = (TypeVariable)obj;
        return (name.equals(that.getName())) && (genericDeclaration.equals(that.getGenericDeclaration()));
      }
      return false;
    }
  }
  
  static final class WildcardTypeImpl
    implements WildcardType, Serializable
  {
    private final ImmutableList<Type> lowerBounds;
    private final ImmutableList<Type> upperBounds;
    private static final long serialVersionUID = 0L;
    
    WildcardTypeImpl(Type[] lowerBounds, Type[] upperBounds)
    {
      Types.disallowPrimitiveType(lowerBounds, "lower bound for wildcard");
      Types.disallowPrimitiveType(upperBounds, "upper bound for wildcard");
      this.lowerBounds = Types.JavaVersion.CURRENT.usedInGenericType(lowerBounds);
      this.upperBounds = Types.JavaVersion.CURRENT.usedInGenericType(upperBounds);
    }
    
    public Type[] getLowerBounds()
    {
      return Types.toArray(lowerBounds);
    }
    
    public Type[] getUpperBounds()
    {
      return Types.toArray(upperBounds);
    }
    
    public boolean equals(Object obj)
    {
      if ((obj instanceof WildcardType))
      {
        WildcardType that = (WildcardType)obj;
        return (lowerBounds.equals(Arrays.asList(that.getLowerBounds()))) && (upperBounds.equals(Arrays.asList(that.getUpperBounds())));
      }
      return false;
    }
    
    public int hashCode()
    {
      return lowerBounds.hashCode() ^ upperBounds.hashCode();
    }
    
    public String toString()
    {
      StringBuilder builder = new StringBuilder("?");
      for (Type lowerBound : lowerBounds) {
        builder.append(" super ").append(Types.JavaVersion.CURRENT.typeName(lowerBound));
      }
      for (Type upperBound : Types.filterUpperBounds(upperBounds)) {
        builder.append(" extends ").append(Types.JavaVersion.CURRENT.typeName(upperBound));
      }
      return builder.toString();
    }
  }
  
  private static Type[] toArray(Collection<Type> types)
  {
    return (Type[])types.toArray(new Type[types.size()]);
  }
  
  private static Iterable<Type> filterUpperBounds(Iterable<Type> bounds)
  {
    return Iterables.filter(bounds, Predicates.not(Predicates.equalTo(Object.class)));
  }
  
  private static void disallowPrimitiveType(Type[] types, String usedAs)
  {
    for (Type type : types) {
      if ((type instanceof Class))
      {
        Class<?> cls = (Class)type;
        Preconditions.checkArgument(!cls.isPrimitive(), "Primitive type '%s' used as %s", new Object[] { cls, usedAs });
      }
    }
  }
  
  static Class<?> getArrayClass(Class<?> componentType)
  {
    return Array.newInstance(componentType, 0).getClass();
  }
  
  static abstract enum JavaVersion
  {
    JAVA6,  JAVA7,  JAVA8;
    
    static final JavaVersion CURRENT;
    
    static
    {
      if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
        CURRENT = JAVA8;
      } else if ((new TypeCapture() {}.capture() instanceof Class)) {
        CURRENT = JAVA7;
      } else {
        CURRENT = JAVA6;
      }
    }
    
    String typeName(Type type)
    {
      return Types.toString(type);
    }
    
    final ImmutableList<Type> usedInGenericType(Type[] types)
    {
      ImmutableList.Builder<Type> builder = ImmutableList.builder();
      for (Type type : types) {
        builder.add(usedInGenericType(type));
      }
      return builder.build();
    }
    
    private JavaVersion() {}
    
    abstract Type newArrayType(Type paramType);
    
    abstract Type usedInGenericType(Type paramType);
  }
  
  static final class NativeTypeVariableEquals<X>
  {
    static final boolean NATIVE_TYPE_VARIABLE_ONLY = !NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.newArtificialTypeVariable(NativeTypeVariableEquals.class, "X", new Type[0]));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */