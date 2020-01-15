package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class TypeBindings
{
  private static final JavaType[] NO_TYPES = new JavaType[0];
  public static final JavaType UNBOUND = new SimpleType(Object.class);
  protected final TypeFactory _typeFactory;
  protected final JavaType _contextType;
  protected final Class<?> _contextClass;
  protected Map<String, JavaType> _bindings;
  protected HashSet<String> _placeholders;
  private final TypeBindings _parentBindings;
  
  public TypeBindings(TypeFactory typeFactory, Class<?> cc)
  {
    this(typeFactory, null, cc, null);
  }
  
  public TypeBindings(TypeFactory typeFactory, JavaType type)
  {
    this(typeFactory, null, type.getRawClass(), type);
  }
  
  public TypeBindings childInstance()
  {
    return new TypeBindings(_typeFactory, this, _contextClass, _contextType);
  }
  
  private TypeBindings(TypeFactory tf, TypeBindings parent, Class<?> cc, JavaType type)
  {
    _typeFactory = tf;
    _parentBindings = parent;
    _contextClass = cc;
    _contextType = type;
  }
  
  public JavaType resolveType(Class<?> cls)
  {
    return _typeFactory._constructType(cls, this);
  }
  
  public JavaType resolveType(Type type)
  {
    return _typeFactory._constructType(type, this);
  }
  
  public int getBindingCount()
  {
    if (_bindings == null) {
      _resolve();
    }
    return _bindings.size();
  }
  
  @Deprecated
  public JavaType findType(String name)
  {
    return findType(name, true);
  }
  
  public JavaType findType(String name, boolean mustFind)
  {
    if (_bindings == null) {
      _resolve();
    }
    JavaType t = (JavaType)_bindings.get(name);
    if (t != null) {
      return t;
    }
    if ((_placeholders != null) && (_placeholders.contains(name))) {
      return UNBOUND;
    }
    if (_parentBindings != null) {
      return _parentBindings.findType(name);
    }
    if (_contextClass != null)
    {
      Class<?> enclosing = _contextClass.getEnclosingClass();
      if (enclosing != null) {
        if (!Modifier.isStatic(_contextClass.getModifiers())) {
          return UNBOUND;
        }
      }
    }
    if (!mustFind) {
      return null;
    }
    String className;
    String className;
    if (_contextClass != null)
    {
      className = _contextClass.getName();
    }
    else
    {
      String className;
      if (_contextType != null) {
        className = _contextType.toString();
      } else {
        className = "UNKNOWN";
      }
    }
    throw new IllegalArgumentException("Type variable '" + name + "' can not be resolved (with context of class " + className + ")");
  }
  
  public void addBinding(String name, JavaType type)
  {
    if ((_bindings == null) || (_bindings.size() == 0)) {
      _bindings = new LinkedHashMap();
    }
    _bindings.put(name, type);
  }
  
  public JavaType[] typesAsArray()
  {
    if (_bindings == null) {
      _resolve();
    }
    if (_bindings.size() == 0) {
      return NO_TYPES;
    }
    return (JavaType[])_bindings.values().toArray(new JavaType[_bindings.size()]);
  }
  
  protected void _resolve()
  {
    _resolveBindings(_contextClass);
    if (_contextType != null)
    {
      int count = _contextType.containedTypeCount();
      if (count > 0) {
        for (int i = 0; i < count; i++)
        {
          String name = _contextType.containedTypeName(i);
          JavaType type = _contextType.containedType(i);
          addBinding(name, type);
        }
      }
    }
    if (_bindings == null) {
      _bindings = Collections.emptyMap();
    }
  }
  
  public void _addPlaceholder(String name)
  {
    if (_placeholders == null) {
      _placeholders = new HashSet();
    }
    _placeholders.add(name);
  }
  
  protected void _resolveBindings(Type t)
  {
    if (t == null) {
      return;
    }
    Class<?> raw;
    if ((t instanceof ParameterizedType))
    {
      ParameterizedType pt = (ParameterizedType)t;
      Type[] args = pt.getActualTypeArguments();
      if ((args != null) && (args.length > 0))
      {
        Class<?> rawType = (Class)pt.getRawType();
        TypeVariable<?>[] vars = rawType.getTypeParameters();
        if (vars.length != args.length) {
          throw new IllegalArgumentException("Strange parametrized type (in class " + rawType.getName() + "): number of type arguments != number of type parameters (" + args.length + " vs " + vars.length + ")");
        }
        int i = 0;
        for (int len = args.length; i < len; i++)
        {
          TypeVariable<?> var = vars[i];
          String name = var.getName();
          if (_bindings == null) {
            _bindings = new LinkedHashMap();
          } else {
            if (_bindings.containsKey(name)) {
              continue;
            }
          }
          _addPlaceholder(name);
          
          _bindings.put(name, _typeFactory._constructType(args[i], this));
        }
      }
      raw = (Class)pt.getRawType();
    }
    else if ((t instanceof Class))
    {
      Class<?> raw = (Class)t;
      
      Class<?> decl = raw.getDeclaringClass();
      if ((decl != null) && (!decl.isAssignableFrom(raw))) {
        _resolveBindings(raw.getDeclaringClass());
      }
      TypeVariable<?>[] vars = raw.getTypeParameters();
      if ((vars != null) && (vars.length > 0))
      {
        JavaType[] typeParams = null;
        if ((_contextType != null) && (raw.isAssignableFrom(_contextType.getRawClass()))) {
          typeParams = _typeFactory.findTypeParameters(_contextType, raw);
        }
        for (int i = 0; i < vars.length; i++)
        {
          TypeVariable<?> var = vars[i];
          
          String name = var.getName();
          Type varType = var.getBounds()[0];
          if (varType != null)
          {
            if (_bindings == null) {
              _bindings = new LinkedHashMap();
            } else {
              if (_bindings.containsKey(name)) {
                continue;
              }
            }
            _addPlaceholder(name);
            if ((typeParams != null) && (typeParams.length > i)) {
              _bindings.put(name, typeParams[i]);
            } else {
              _bindings.put(name, _typeFactory._constructType(varType, this));
            }
          }
        }
      }
    }
    else
    {
      return;
    }
    Class<?> raw;
    _resolveBindings(raw.getGenericSuperclass());
    for (Type intType : raw.getGenericInterfaces()) {
      _resolveBindings(intType);
    }
  }
  
  public String toString()
  {
    if (_bindings == null) {
      _resolve();
    }
    StringBuilder sb = new StringBuilder("[TypeBindings for ");
    if (_contextType != null) {
      sb.append(_contextType.toString());
    } else {
      sb.append(_contextClass.getName());
    }
    sb.append(": ").append(_bindings).append("]");
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBindings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */