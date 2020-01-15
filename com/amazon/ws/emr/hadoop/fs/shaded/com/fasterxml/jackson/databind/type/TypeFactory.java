package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.TypeReference;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.LRUMap;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public final class TypeFactory
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static final JavaType[] NO_TYPES = new JavaType[0];
  protected static final TypeFactory instance = new TypeFactory();
  protected static final SimpleType CORE_TYPE_STRING = new SimpleType(String.class);
  protected static final SimpleType CORE_TYPE_BOOL = new SimpleType(Boolean.TYPE);
  protected static final SimpleType CORE_TYPE_INT = new SimpleType(Integer.TYPE);
  protected static final SimpleType CORE_TYPE_LONG = new SimpleType(Long.TYPE);
  protected final LRUMap<ClassKey, JavaType> _typeCache = new LRUMap(16, 100);
  protected transient HierarchicType _cachedHashMapType;
  protected transient HierarchicType _cachedArrayListType;
  protected final TypeModifier[] _modifiers;
  protected final TypeParser _parser;
  protected final ClassLoader _classLoader;
  
  private TypeFactory()
  {
    _parser = new TypeParser(this);
    _modifiers = null;
    _classLoader = null;
  }
  
  protected TypeFactory(TypeParser p, TypeModifier[] mods)
  {
    this(p, mods, null);
  }
  
  protected TypeFactory(TypeParser p, TypeModifier[] mods, ClassLoader classLoader)
  {
    _parser = p.withFactory(this);
    _modifiers = mods;
    _classLoader = classLoader;
  }
  
  public TypeFactory withModifier(TypeModifier mod)
  {
    if (mod == null) {
      return new TypeFactory(_parser, _modifiers, _classLoader);
    }
    if (_modifiers == null) {
      return new TypeFactory(_parser, new TypeModifier[] { mod }, _classLoader);
    }
    return new TypeFactory(_parser, (TypeModifier[])ArrayBuilders.insertInListNoDup(_modifiers, mod), _classLoader);
  }
  
  public TypeFactory withClassLoader(ClassLoader classLoader)
  {
    return new TypeFactory(_parser, _modifiers, classLoader);
  }
  
  public static TypeFactory defaultInstance()
  {
    return instance;
  }
  
  public void clearCache()
  {
    _typeCache.clear();
  }
  
  public ClassLoader getClassLoader()
  {
    return _classLoader;
  }
  
  public static JavaType unknownType()
  {
    return defaultInstance()._unknownType();
  }
  
  public static Class<?> rawClass(Type t)
  {
    if ((t instanceof Class)) {
      return (Class)t;
    }
    return defaultInstance().constructType(t).getRawClass();
  }
  
  public Class<?> findClass(String className)
    throws ClassNotFoundException
  {
    if (className.indexOf('.') < 0)
    {
      Class<?> prim = _findPrimitive(className);
      if (prim != null) {
        return prim;
      }
    }
    Throwable prob = null;
    ClassLoader loader = getClassLoader();
    if (loader == null) {
      loader = Thread.currentThread().getContextClassLoader();
    }
    if (loader != null) {
      try
      {
        return classForName(className, true, loader);
      }
      catch (Exception e)
      {
        prob = ClassUtil.getRootCause(e);
      }
    }
    try
    {
      return classForName(className);
    }
    catch (Exception e)
    {
      if (prob == null) {
        prob = ClassUtil.getRootCause(e);
      }
      if ((prob instanceof RuntimeException)) {
        throw ((RuntimeException)prob);
      }
      throw new ClassNotFoundException(prob.getMessage(), prob);
    }
  }
  
  protected Class<?> classForName(String name, boolean initialize, ClassLoader loader)
    throws ClassNotFoundException
  {
    return Class.forName(name, true, loader);
  }
  
  protected Class<?> classForName(String name)
    throws ClassNotFoundException
  {
    return Class.forName(name);
  }
  
  protected Class<?> _findPrimitive(String className)
  {
    if ("int".equals(className)) {
      return Integer.TYPE;
    }
    if ("long".equals(className)) {
      return Long.TYPE;
    }
    if ("float".equals(className)) {
      return Float.TYPE;
    }
    if ("double".equals(className)) {
      return Double.TYPE;
    }
    if ("boolean".equals(className)) {
      return Boolean.TYPE;
    }
    if ("byte".equals(className)) {
      return Byte.TYPE;
    }
    if ("char".equals(className)) {
      return Character.TYPE;
    }
    if ("short".equals(className)) {
      return Short.TYPE;
    }
    if ("void".equals(className)) {
      return Void.TYPE;
    }
    return null;
  }
  
  public JavaType constructSpecializedType(JavaType baseType, Class<?> subclass)
  {
    if (baseType.getRawClass() == subclass) {
      return baseType;
    }
    if ((baseType instanceof SimpleType)) {
      if ((subclass.isArray()) || (Map.class.isAssignableFrom(subclass)) || (Collection.class.isAssignableFrom(subclass)))
      {
        if (!baseType.getRawClass().isAssignableFrom(subclass)) {
          throw new IllegalArgumentException("Class " + subclass.getClass().getName() + " not subtype of " + baseType);
        }
        JavaType subtype = _fromClass(subclass, new TypeBindings(this, baseType.getRawClass()));
        
        Object h = baseType.getValueHandler();
        if (h != null) {
          subtype = subtype.withValueHandler(h);
        }
        h = baseType.getTypeHandler();
        if (h != null) {
          subtype = subtype.withTypeHandler(h);
        }
        return subtype;
      }
    }
    return baseType.narrowBy(subclass);
  }
  
  public JavaType constructFromCanonical(String canonical)
    throws IllegalArgumentException
  {
    return _parser.parse(canonical);
  }
  
  public JavaType[] findTypeParameters(JavaType type, Class<?> expType)
  {
    if (expType == type.getParameterSource())
    {
      int count = type.containedTypeCount();
      if (count == 0) {
        return null;
      }
      JavaType[] result = new JavaType[count];
      for (int i = 0; i < count; i++) {
        result[i] = type.containedType(i);
      }
      return result;
    }
    Class<?> raw = type.getRawClass();
    return findTypeParameters(raw, expType, new TypeBindings(this, type));
  }
  
  public JavaType[] findTypeParameters(JavaType type, Class<?> expType, TypeBindings bindings)
  {
    if (expType == type.getParameterSource())
    {
      int count = type.containedTypeCount();
      if (count == 0) {
        return null;
      }
      JavaType[] result = new JavaType[count];
      for (int i = 0; i < count; i++) {
        result[i] = type.containedType(i);
      }
      return result;
    }
    Class<?> raw = type.getRawClass();
    return findTypeParameters(raw, expType, bindings);
  }
  
  public JavaType[] findTypeParameters(Class<?> clz, Class<?> expType)
  {
    return findTypeParameters(clz, expType, new TypeBindings(this, clz));
  }
  
  public JavaType[] findTypeParameters(Class<?> clz, Class<?> expType, TypeBindings bindings)
  {
    HierarchicType subType = _findSuperTypeChain(clz, expType);
    if (subType == null) {
      throw new IllegalArgumentException("Class " + clz.getName() + " is not a subtype of " + expType.getName());
    }
    HierarchicType superType = subType;
    while (superType.getSuperType() != null)
    {
      superType = superType.getSuperType();
      Class<?> raw = superType.getRawClass();
      TypeBindings newBindings = new TypeBindings(this, raw);
      if (superType.isGeneric())
      {
        ParameterizedType pt = superType.asGeneric();
        Type[] actualTypes = pt.getActualTypeArguments();
        TypeVariable<?>[] vars = raw.getTypeParameters();
        int len = actualTypes.length;
        for (int i = 0; i < len; i++)
        {
          String name = vars[i].getName();
          JavaType type = _constructType(actualTypes[i], bindings);
          newBindings.addBinding(name, type);
        }
      }
      bindings = newBindings;
    }
    if (!superType.isGeneric()) {
      return null;
    }
    return bindings.typesAsArray();
  }
  
  public JavaType moreSpecificType(JavaType type1, JavaType type2)
  {
    if (type1 == null) {
      return type2;
    }
    if (type2 == null) {
      return type1;
    }
    Class<?> raw1 = type1.getRawClass();
    Class<?> raw2 = type2.getRawClass();
    if (raw1 == raw2) {
      return type1;
    }
    if (raw1.isAssignableFrom(raw2)) {
      return type2;
    }
    return type1;
  }
  
  public JavaType constructType(Type type)
  {
    return _constructType(type, null);
  }
  
  public JavaType constructType(Type type, TypeBindings bindings)
  {
    return _constructType(type, bindings);
  }
  
  public JavaType constructType(TypeReference<?> typeRef)
  {
    return _constructType(typeRef.getType(), null);
  }
  
  public JavaType constructType(Type type, Class<?> context)
  {
    TypeBindings b = context == null ? null : new TypeBindings(this, context);
    return _constructType(type, b);
  }
  
  public JavaType constructType(Type type, JavaType context)
  {
    TypeBindings b = context == null ? null : new TypeBindings(this, context);
    return _constructType(type, b);
  }
  
  protected JavaType _constructType(Type type, TypeBindings context)
  {
    JavaType resultType;
    if ((type instanceof Class))
    {
      resultType = _fromClass((Class)type, context);
    }
    else
    {
      JavaType resultType;
      if ((type instanceof ParameterizedType))
      {
        resultType = _fromParamType((ParameterizedType)type, context);
      }
      else
      {
        if ((type instanceof JavaType)) {
          return (JavaType)type;
        }
        JavaType resultType;
        if ((type instanceof GenericArrayType))
        {
          resultType = _fromArrayType((GenericArrayType)type, context);
        }
        else
        {
          JavaType resultType;
          if ((type instanceof TypeVariable))
          {
            resultType = _fromVariable((TypeVariable)type, context);
          }
          else
          {
            JavaType resultType;
            if ((type instanceof WildcardType)) {
              resultType = _fromWildcard((WildcardType)type, context);
            } else {
              throw new IllegalArgumentException("Unrecognized Type: " + (type == null ? "[null]" : type.toString()));
            }
          }
        }
      }
    }
    JavaType resultType;
    if ((_modifiers != null) && (!resultType.isContainerType())) {
      for (TypeModifier mod : _modifiers) {
        resultType = mod.modifyType(resultType, type, context, this);
      }
    }
    return resultType;
  }
  
  public ArrayType constructArrayType(Class<?> elementType)
  {
    return ArrayType.construct(_constructType(elementType, null), null, null);
  }
  
  public ArrayType constructArrayType(JavaType elementType)
  {
    return ArrayType.construct(elementType, null, null);
  }
  
  public CollectionType constructCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass)
  {
    return CollectionType.construct(collectionClass, constructType(elementClass));
  }
  
  public CollectionType constructCollectionType(Class<? extends Collection> collectionClass, JavaType elementType)
  {
    return CollectionType.construct(collectionClass, elementType);
  }
  
  public CollectionLikeType constructCollectionLikeType(Class<?> collectionClass, Class<?> elementClass)
  {
    return CollectionLikeType.construct(collectionClass, constructType(elementClass));
  }
  
  public CollectionLikeType constructCollectionLikeType(Class<?> collectionClass, JavaType elementType)
  {
    return CollectionLikeType.construct(collectionClass, elementType);
  }
  
  public MapType constructMapType(Class<? extends Map> mapClass, JavaType keyType, JavaType valueType)
  {
    return MapType.construct(mapClass, keyType, valueType);
  }
  
  public MapType constructMapType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass)
  {
    return MapType.construct(mapClass, constructType(keyClass), constructType(valueClass));
  }
  
  public MapLikeType constructMapLikeType(Class<?> mapClass, JavaType keyType, JavaType valueType)
  {
    return MapLikeType.construct(mapClass, keyType, valueType);
  }
  
  public MapLikeType constructMapLikeType(Class<?> mapClass, Class<?> keyClass, Class<?> valueClass)
  {
    return MapType.construct(mapClass, constructType(keyClass), constructType(valueClass));
  }
  
  @Deprecated
  public JavaType constructSimpleType(Class<?> rawType, JavaType[] parameterTypes)
  {
    return constructSimpleType(rawType, rawType, parameterTypes);
  }
  
  public JavaType constructSimpleType(Class<?> rawType, Class<?> parameterTarget, JavaType[] parameterTypes)
  {
    TypeVariable<?>[] typeVars = parameterTarget.getTypeParameters();
    if (typeVars.length != parameterTypes.length) {
      throw new IllegalArgumentException("Parameter type mismatch for " + rawType.getName() + " (and target " + parameterTarget.getName() + "): expected " + typeVars.length + " parameters, was given " + parameterTypes.length);
    }
    String[] names = new String[typeVars.length];
    int i = 0;
    for (int len = typeVars.length; i < len; i++) {
      names[i] = typeVars[i].getName();
    }
    return new SimpleType(rawType, names, parameterTypes, null, null, false, parameterTarget);
  }
  
  public JavaType constructReferenceType(Class<?> rawType, JavaType refType)
  {
    return new ReferenceType(rawType, refType, null, null, false);
  }
  
  public JavaType uncheckedSimpleType(Class<?> cls)
  {
    return new SimpleType(cls);
  }
  
  public JavaType constructParametrizedType(Class<?> parametrized, Class<?> parametersFor, Class<?>... parameterClasses)
  {
    int len = parameterClasses.length;
    JavaType[] pt = new JavaType[len];
    for (int i = 0; i < len; i++) {
      pt[i] = _fromClass(parameterClasses[i], null);
    }
    return constructParametrizedType(parametrized, parametersFor, pt);
  }
  
  @Deprecated
  public JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses)
  {
    return constructParametrizedType(parametrized, parametrized, parameterClasses);
  }
  
  public JavaType constructParametrizedType(Class<?> parametrized, Class<?> parametersFor, JavaType... parameterTypes)
  {
    JavaType resultType;
    JavaType resultType;
    if (parametrized.isArray())
    {
      if (parameterTypes.length != 1) {
        throw new IllegalArgumentException("Need exactly 1 parameter type for arrays (" + parametrized.getName() + ")");
      }
      resultType = constructArrayType(parameterTypes[0]);
    }
    else
    {
      JavaType resultType;
      if (Map.class.isAssignableFrom(parametrized))
      {
        if (parameterTypes.length != 2) {
          throw new IllegalArgumentException("Need exactly 2 parameter types for Map types (" + parametrized.getName() + ")");
        }
        resultType = constructMapType(parametrized, parameterTypes[0], parameterTypes[1]);
      }
      else
      {
        JavaType resultType;
        if (Collection.class.isAssignableFrom(parametrized))
        {
          if (parameterTypes.length != 1) {
            throw new IllegalArgumentException("Need exactly 1 parameter type for Collection types (" + parametrized.getName() + ")");
          }
          resultType = constructCollectionType(parametrized, parameterTypes[0]);
        }
        else
        {
          resultType = constructSimpleType(parametrized, parametersFor, parameterTypes);
        }
      }
    }
    return resultType;
  }
  
  @Deprecated
  public JavaType constructParametricType(Class<?> parametrized, JavaType... parameterTypes)
  {
    return constructParametrizedType(parametrized, parametrized, parameterTypes);
  }
  
  public CollectionType constructRawCollectionType(Class<? extends Collection> collectionClass)
  {
    return CollectionType.construct(collectionClass, unknownType());
  }
  
  public CollectionLikeType constructRawCollectionLikeType(Class<?> collectionClass)
  {
    return CollectionLikeType.construct(collectionClass, unknownType());
  }
  
  public MapType constructRawMapType(Class<? extends Map> mapClass)
  {
    return MapType.construct(mapClass, unknownType(), unknownType());
  }
  
  public MapLikeType constructRawMapLikeType(Class<?> mapClass)
  {
    return MapLikeType.construct(mapClass, unknownType(), unknownType());
  }
  
  protected JavaType _fromClass(Class<?> clz, TypeBindings context)
  {
    if (clz == String.class) {
      return CORE_TYPE_STRING;
    }
    if (clz == Boolean.TYPE) {
      return CORE_TYPE_BOOL;
    }
    if (clz == Integer.TYPE) {
      return CORE_TYPE_INT;
    }
    if (clz == Long.TYPE) {
      return CORE_TYPE_LONG;
    }
    ClassKey key = new ClassKey(clz);
    JavaType result = (JavaType)_typeCache.get(key);
    if (result != null) {
      return result;
    }
    if (clz.isArray())
    {
      result = ArrayType.construct(_constructType(clz.getComponentType(), null), null, null);
    }
    else if (clz.isEnum())
    {
      result = new SimpleType(clz);
    }
    else if (Map.class.isAssignableFrom(clz))
    {
      result = _mapType(clz);
    }
    else if (Collection.class.isAssignableFrom(clz))
    {
      result = _collectionType(clz);
    }
    else if (AtomicReference.class.isAssignableFrom(clz))
    {
      JavaType[] pts = findTypeParameters(clz, AtomicReference.class);
      JavaType rt = (pts == null) || (pts.length != 1) ? unknownType() : pts[0];
      result = constructReferenceType(clz, rt);
    }
    else if (Map.Entry.class.isAssignableFrom(clz))
    {
      JavaType[] pts = findTypeParameters(clz, Map.Entry.class);
      JavaType kt;
      JavaType kt;
      JavaType vt;
      if ((pts == null) || (pts.length != 2))
      {
        JavaType vt;
        kt = vt = unknownType();
      }
      else
      {
        kt = pts[0];
        vt = pts[1];
      }
      result = constructSimpleType(clz, Map.Entry.class, new JavaType[] { kt, vt });
    }
    else
    {
      result = new SimpleType(clz);
    }
    _typeCache.put(key, result);
    return result;
  }
  
  protected JavaType _fromParameterizedClass(Class<?> clz, List<JavaType> paramTypes)
  {
    if (clz.isArray()) {
      return ArrayType.construct(_constructType(clz.getComponentType(), null), null, null);
    }
    if (clz.isEnum()) {
      return new SimpleType(clz);
    }
    if (Map.class.isAssignableFrom(clz))
    {
      if (paramTypes.size() > 0)
      {
        JavaType keyType = (JavaType)paramTypes.get(0);
        JavaType contentType = paramTypes.size() >= 2 ? (JavaType)paramTypes.get(1) : _unknownType();
        
        return MapType.construct(clz, keyType, contentType);
      }
      return _mapType(clz);
    }
    if (Collection.class.isAssignableFrom(clz))
    {
      if (paramTypes.size() >= 1) {
        return CollectionType.construct(clz, (JavaType)paramTypes.get(0));
      }
      return _collectionType(clz);
    }
    if (paramTypes.size() == 0) {
      return new SimpleType(clz);
    }
    JavaType[] pt = (JavaType[])paramTypes.toArray(new JavaType[paramTypes.size()]);
    return constructSimpleType(clz, clz, pt);
  }
  
  protected JavaType _fromParamType(ParameterizedType type, TypeBindings context)
  {
    Class<?> rawType = (Class)type.getRawType();
    Type[] args = type.getActualTypeArguments();
    int paramCount = args == null ? 0 : args.length;
    JavaType[] pt;
    JavaType[] pt;
    if (paramCount == 0)
    {
      pt = NO_TYPES;
    }
    else
    {
      pt = new JavaType[paramCount];
      for (int i = 0; i < paramCount; i++) {
        pt[i] = _constructType(args[i], context);
      }
    }
    if (Map.class.isAssignableFrom(rawType))
    {
      JavaType subtype = constructSimpleType(rawType, rawType, pt);
      
      JavaType[] mapParams = findTypeParameters(subtype, Map.class);
      if (mapParams.length != 2) {
        throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + rawType.getName() + " (found " + mapParams.length + ")");
      }
      return MapType.construct(rawType, mapParams[0], mapParams[1]);
    }
    if (Collection.class.isAssignableFrom(rawType))
    {
      JavaType subtype = constructSimpleType(rawType, rawType, pt);
      JavaType[] collectionParams = findTypeParameters(subtype, Collection.class);
      if (collectionParams.length != 1) {
        throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + rawType.getName() + " (found " + collectionParams.length + ")");
      }
      return CollectionType.construct(rawType, collectionParams[0]);
    }
    if (AtomicReference.class.isAssignableFrom(rawType))
    {
      JavaType rt = null;
      if (rawType == AtomicReference.class)
      {
        if (paramCount == 1) {
          rt = pt[0];
        }
      }
      else
      {
        JavaType subtype = constructSimpleType(rawType, rawType, pt);
        JavaType[] pts = findTypeParameters(subtype, AtomicReference.class, context);
        if ((pts != null) && (pts.length == 1)) {
          rt = pts[0];
        }
      }
      return constructReferenceType(rawType, rt == null ? unknownType() : rt);
    }
    if (Map.Entry.class.isAssignableFrom(rawType))
    {
      JavaType kt = null;JavaType vt = null;
      if (rawType == Map.Entry.class)
      {
        if (paramCount == 2)
        {
          kt = pt[0];
          vt = pt[1];
        }
      }
      else
      {
        JavaType subtype = constructSimpleType(rawType, rawType, pt);
        JavaType[] pts = findTypeParameters(subtype, Map.Entry.class, context);
        if ((pts != null) && (pts.length == 2))
        {
          kt = pts[0];
          vt = pts[1];
        }
      }
      return constructSimpleType(rawType, Map.Entry.class, new JavaType[] { kt == null ? unknownType() : kt, vt == null ? unknownType() : vt });
    }
    if (paramCount == 0) {
      return new SimpleType(rawType);
    }
    return constructSimpleType(rawType, pt);
  }
  
  protected JavaType _fromArrayType(GenericArrayType type, TypeBindings context)
  {
    JavaType compType = _constructType(type.getGenericComponentType(), context);
    return ArrayType.construct(compType, null, null);
  }
  
  protected JavaType _fromVariable(TypeVariable<?> type, TypeBindings context)
  {
    String name = type.getName();
    if (context == null)
    {
      context = new TypeBindings(this, (Class)null);
    }
    else
    {
      JavaType actualType = context.findType(name, false);
      if (actualType != null) {
        return actualType;
      }
    }
    Type[] bounds = type.getBounds();
    
    context._addPlaceholder(name);
    return _constructType(bounds[0], context);
  }
  
  protected JavaType _fromWildcard(WildcardType type, TypeBindings context)
  {
    return _constructType(type.getUpperBounds()[0], context);
  }
  
  private JavaType _mapType(Class<?> rawClass)
  {
    if (rawClass == Properties.class) {
      return MapType.construct(rawClass, CORE_TYPE_STRING, CORE_TYPE_STRING);
    }
    JavaType[] typeParams = findTypeParameters(rawClass, Map.class);
    if (typeParams == null) {
      return MapType.construct(rawClass, _unknownType(), _unknownType());
    }
    if (typeParams.length != 2) {
      throw new IllegalArgumentException("Strange Map type " + rawClass.getName() + ": can not determine type parameters");
    }
    return MapType.construct(rawClass, typeParams[0], typeParams[1]);
  }
  
  private JavaType _collectionType(Class<?> rawClass)
  {
    JavaType[] typeParams = findTypeParameters(rawClass, Collection.class);
    if (typeParams == null) {
      return CollectionType.construct(rawClass, _unknownType());
    }
    if (typeParams.length != 1) {
      throw new IllegalArgumentException("Strange Collection type " + rawClass.getName() + ": can not determine type parameters");
    }
    return CollectionType.construct(rawClass, typeParams[0]);
  }
  
  protected JavaType _resolveVariableViaSubTypes(HierarchicType leafType, String variableName, TypeBindings bindings)
  {
    if ((leafType != null) && (leafType.isGeneric()))
    {
      TypeVariable<?>[] typeVariables = leafType.getRawClass().getTypeParameters();
      int i = 0;
      for (int len = typeVariables.length; i < len; i++)
      {
        TypeVariable<?> tv = typeVariables[i];
        if (variableName.equals(tv.getName()))
        {
          Type type = leafType.asGeneric().getActualTypeArguments()[i];
          if ((type instanceof TypeVariable)) {
            return _resolveVariableViaSubTypes(leafType.getSubType(), ((TypeVariable)type).getName(), bindings);
          }
          return _constructType(type, bindings);
        }
      }
    }
    return _unknownType();
  }
  
  protected JavaType _unknownType()
  {
    return new SimpleType(Object.class);
  }
  
  protected HierarchicType _findSuperTypeChain(Class<?> subtype, Class<?> supertype)
  {
    if (supertype.isInterface()) {
      return _findSuperInterfaceChain(subtype, supertype);
    }
    return _findSuperClassChain(subtype, supertype);
  }
  
  protected HierarchicType _findSuperClassChain(Type currentType, Class<?> target)
  {
    HierarchicType current = new HierarchicType(currentType);
    Class<?> raw = current.getRawClass();
    if (raw == target) {
      return current;
    }
    Type parent = raw.getGenericSuperclass();
    if (parent != null)
    {
      HierarchicType sup = _findSuperClassChain(parent, target);
      if (sup != null)
      {
        sup.setSubType(current);
        current.setSuperType(sup);
        return current;
      }
    }
    return null;
  }
  
  protected HierarchicType _findSuperInterfaceChain(Type currentType, Class<?> target)
  {
    HierarchicType current = new HierarchicType(currentType);
    Class<?> raw = current.getRawClass();
    if (raw == target) {
      return new HierarchicType(currentType);
    }
    if ((raw == HashMap.class) && 
      (target == Map.class)) {
      return _hashMapSuperInterfaceChain(current);
    }
    if ((raw == ArrayList.class) && 
      (target == List.class)) {
      return _arrayListSuperInterfaceChain(current);
    }
    return _doFindSuperInterfaceChain(current, target);
  }
  
  protected HierarchicType _doFindSuperInterfaceChain(HierarchicType current, Class<?> target)
  {
    Class<?> raw = current.getRawClass();
    Type[] parents = raw.getGenericInterfaces();
    if (parents != null) {
      for (Type parent : parents)
      {
        HierarchicType sup = _findSuperInterfaceChain(parent, target);
        if (sup != null)
        {
          sup.setSubType(current);
          current.setSuperType(sup);
          return current;
        }
      }
    }
    Type parent = raw.getGenericSuperclass();
    if (parent != null)
    {
      HierarchicType sup = _findSuperInterfaceChain(parent, target);
      if (sup != null)
      {
        sup.setSubType(current);
        current.setSuperType(sup);
        return current;
      }
    }
    return null;
  }
  
  protected synchronized HierarchicType _hashMapSuperInterfaceChain(HierarchicType current)
  {
    if (_cachedHashMapType == null)
    {
      HierarchicType base = current.deepCloneWithoutSubtype();
      _doFindSuperInterfaceChain(base, Map.class);
      _cachedHashMapType = base.getSuperType();
    }
    HierarchicType t = _cachedHashMapType.deepCloneWithoutSubtype();
    current.setSuperType(t);
    t.setSubType(current);
    return current;
  }
  
  protected synchronized HierarchicType _arrayListSuperInterfaceChain(HierarchicType current)
  {
    if (_cachedArrayListType == null)
    {
      HierarchicType base = current.deepCloneWithoutSubtype();
      _doFindSuperInterfaceChain(base, List.class);
      _cachedArrayListType = base.getSuperType();
    }
    HierarchicType t = _cachedArrayListType.deepCloneWithoutSubtype();
    current.setSuperType(t);
    t.setSubType(current);
    return current;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */