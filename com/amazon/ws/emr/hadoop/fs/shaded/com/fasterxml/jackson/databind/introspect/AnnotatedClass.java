package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class AnnotatedClass
  extends Annotated
{
  private static final AnnotationMap[] NO_ANNOTATION_MAPS = new AnnotationMap[0];
  protected final Class<?> _class;
  protected final List<Class<?>> _superTypes;
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final ClassIntrospector.MixInResolver _mixInResolver;
  protected final Class<?> _primaryMixIn;
  protected AnnotationMap _classAnnotations;
  protected boolean _creatorsResolved = false;
  protected AnnotatedConstructor _defaultConstructor;
  protected List<AnnotatedConstructor> _constructors;
  protected List<AnnotatedMethod> _creatorMethods;
  protected AnnotatedMethodMap _memberMethods;
  protected List<AnnotatedField> _fields;
  
  private AnnotatedClass(Class<?> cls, List<Class<?>> superTypes, AnnotationIntrospector aintr, ClassIntrospector.MixInResolver mir, AnnotationMap classAnnotations)
  {
    _class = cls;
    _superTypes = superTypes;
    _annotationIntrospector = aintr;
    _mixInResolver = mir;
    _primaryMixIn = (_mixInResolver == null ? null : _mixInResolver.findMixInClassFor(_class));
    
    _classAnnotations = classAnnotations;
  }
  
  public AnnotatedClass withAnnotations(AnnotationMap ann)
  {
    return new AnnotatedClass(_class, _superTypes, _annotationIntrospector, _mixInResolver, ann);
  }
  
  public static AnnotatedClass construct(Class<?> cls, AnnotationIntrospector aintr, ClassIntrospector.MixInResolver mir)
  {
    return new AnnotatedClass(cls, ClassUtil.findSuperTypes(cls, null), aintr, mir, null);
  }
  
  public static AnnotatedClass constructWithoutSuperTypes(Class<?> cls, AnnotationIntrospector aintr, ClassIntrospector.MixInResolver mir)
  {
    return new AnnotatedClass(cls, Collections.emptyList(), aintr, mir, null);
  }
  
  public Class<?> getAnnotated()
  {
    return _class;
  }
  
  public int getModifiers()
  {
    return _class.getModifiers();
  }
  
  public String getName()
  {
    return _class.getName();
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations.get(acls);
  }
  
  public Type getGenericType()
  {
    return _class;
  }
  
  public Class<?> getRawType()
  {
    return _class;
  }
  
  public Iterable<Annotation> annotations()
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations.annotations();
  }
  
  protected AnnotationMap getAllAnnotations()
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations;
  }
  
  public Annotations getAnnotations()
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations;
  }
  
  public boolean hasAnnotations()
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations.size() > 0;
  }
  
  public AnnotatedConstructor getDefaultConstructor()
  {
    if (!_creatorsResolved) {
      resolveCreators();
    }
    return _defaultConstructor;
  }
  
  public List<AnnotatedConstructor> getConstructors()
  {
    if (!_creatorsResolved) {
      resolveCreators();
    }
    return _constructors;
  }
  
  public List<AnnotatedMethod> getStaticMethods()
  {
    if (!_creatorsResolved) {
      resolveCreators();
    }
    return _creatorMethods;
  }
  
  public Iterable<AnnotatedMethod> memberMethods()
  {
    if (_memberMethods == null) {
      resolveMemberMethods();
    }
    return _memberMethods;
  }
  
  public int getMemberMethodCount()
  {
    if (_memberMethods == null) {
      resolveMemberMethods();
    }
    return _memberMethods.size();
  }
  
  public AnnotatedMethod findMethod(String name, Class<?>[] paramTypes)
  {
    if (_memberMethods == null) {
      resolveMemberMethods();
    }
    return _memberMethods.find(name, paramTypes);
  }
  
  public int getFieldCount()
  {
    if (_fields == null) {
      resolveFields();
    }
    return _fields.size();
  }
  
  public Iterable<AnnotatedField> fields()
  {
    if (_fields == null) {
      resolveFields();
    }
    return _fields;
  }
  
  private void resolveClassAnnotations()
  {
    AnnotationMap ca = new AnnotationMap();
    if (_annotationIntrospector != null)
    {
      if (_primaryMixIn != null) {
        _addClassMixIns(ca, _class, _primaryMixIn);
      }
      _addAnnotationsIfNotPresent(ca, _class.getDeclaredAnnotations());
      for (Class<?> cls : _superTypes)
      {
        _addClassMixIns(ca, cls);
        _addAnnotationsIfNotPresent(ca, cls.getDeclaredAnnotations());
      }
      _addClassMixIns(ca, Object.class);
    }
    _classAnnotations = ca;
  }
  
  private void resolveCreators()
  {
    List<AnnotatedConstructor> constructors = null;
    Constructor<?>[] declaredCtors = _class.getDeclaredConstructors();
    for (Constructor<?> ctor : declaredCtors) {
      if (_isIncludableConstructor(ctor)) {
        if (ctor.getParameterTypes().length == 0)
        {
          _defaultConstructor = _constructConstructor(ctor, true);
        }
        else
        {
          if (constructors == null) {
            constructors = new ArrayList(Math.max(10, declaredCtors.length));
          }
          constructors.add(_constructConstructor(ctor, false));
        }
      }
    }
    if (constructors == null) {
      _constructors = Collections.emptyList();
    } else {
      _constructors = constructors;
    }
    if ((_primaryMixIn != null) && (
      (_defaultConstructor != null) || (!_constructors.isEmpty()))) {
      _addConstructorMixIns(_primaryMixIn);
    }
    if (_annotationIntrospector != null)
    {
      if ((_defaultConstructor != null) && 
        (_annotationIntrospector.hasIgnoreMarker(_defaultConstructor))) {
        _defaultConstructor = null;
      }
      if (_constructors != null)
      {
        int i = _constructors.size();
        for (;;)
        {
          i--;
          if (i < 0) {
            break;
          }
          if (_annotationIntrospector.hasIgnoreMarker((AnnotatedMember)_constructors.get(i))) {
            _constructors.remove(i);
          }
        }
      }
    }
    List<AnnotatedMethod> creatorMethods = null;
    for (Method m : _findClassMethods(_class)) {
      if (Modifier.isStatic(m.getModifiers()))
      {
        if (creatorMethods == null) {
          creatorMethods = new ArrayList(8);
        }
        creatorMethods.add(_constructCreatorMethod(m));
      }
    }
    if (creatorMethods == null)
    {
      _creatorMethods = Collections.emptyList();
    }
    else
    {
      _creatorMethods = creatorMethods;
      if (_primaryMixIn != null) {
        _addFactoryMixIns(_primaryMixIn);
      }
      if (_annotationIntrospector != null)
      {
        int i = _creatorMethods.size();
        for (;;)
        {
          i--;
          if (i < 0) {
            break;
          }
          if (_annotationIntrospector.hasIgnoreMarker((AnnotatedMember)_creatorMethods.get(i))) {
            _creatorMethods.remove(i);
          }
        }
      }
    }
    _creatorsResolved = true;
  }
  
  private void resolveMemberMethods()
  {
    _memberMethods = new AnnotatedMethodMap();
    AnnotatedMethodMap mixins = new AnnotatedMethodMap();
    
    _addMemberMethods(_class, _memberMethods, _primaryMixIn, mixins);
    for (Class<?> cls : _superTypes)
    {
      Class<?> mixin = _mixInResolver == null ? null : _mixInResolver.findMixInClassFor(cls);
      _addMemberMethods(cls, _memberMethods, mixin, mixins);
    }
    if (_mixInResolver != null)
    {
      Class<?> mixin = _mixInResolver.findMixInClassFor(Object.class);
      if (mixin != null) {
        _addMethodMixIns(_class, _memberMethods, mixin, mixins);
      }
    }
    if ((_annotationIntrospector != null) && 
      (!mixins.isEmpty()))
    {
      Iterator<AnnotatedMethod> it = mixins.iterator();
      while (it.hasNext())
      {
        AnnotatedMethod mixIn = (AnnotatedMethod)it.next();
        try
        {
          Method m = Object.class.getDeclaredMethod(mixIn.getName(), mixIn.getRawParameterTypes());
          if (m != null)
          {
            AnnotatedMethod am = _constructMethod(m);
            _addMixOvers(mixIn.getAnnotated(), am, false);
            _memberMethods.add(am);
          }
        }
        catch (Exception e) {}
      }
    }
  }
  
  private void resolveFields()
  {
    Map<String, AnnotatedField> foundFields = _findFields(_class, null);
    if ((foundFields == null) || (foundFields.size() == 0))
    {
      _fields = Collections.emptyList();
    }
    else
    {
      _fields = new ArrayList(foundFields.size());
      _fields.addAll(foundFields.values());
    }
  }
  
  protected void _addClassMixIns(AnnotationMap annotations, Class<?> toMask)
  {
    if (_mixInResolver != null) {
      _addClassMixIns(annotations, toMask, _mixInResolver.findMixInClassFor(toMask));
    }
  }
  
  protected void _addClassMixIns(AnnotationMap annotations, Class<?> toMask, Class<?> mixin)
  {
    if (mixin == null) {
      return;
    }
    _addAnnotationsIfNotPresent(annotations, mixin.getDeclaredAnnotations());
    for (Class<?> parent : ClassUtil.findSuperTypes(mixin, toMask)) {
      _addAnnotationsIfNotPresent(annotations, parent.getDeclaredAnnotations());
    }
  }
  
  protected void _addConstructorMixIns(Class<?> mixin)
  {
    MemberKey[] ctorKeys = null;
    int ctorCount = _constructors == null ? 0 : _constructors.size();
    for (Constructor<?> ctor : mixin.getDeclaredConstructors()) {
      if (ctor.getParameterTypes().length == 0)
      {
        if (_defaultConstructor != null) {
          _addMixOvers(ctor, _defaultConstructor, false);
        }
      }
      else
      {
        if (ctorKeys == null)
        {
          ctorKeys = new MemberKey[ctorCount];
          for (int i = 0; i < ctorCount; i++) {
            ctorKeys[i] = new MemberKey(((AnnotatedConstructor)_constructors.get(i)).getAnnotated());
          }
        }
        MemberKey key = new MemberKey(ctor);
        for (int i = 0; i < ctorCount; i++) {
          if (key.equals(ctorKeys[i]))
          {
            _addMixOvers(ctor, (AnnotatedConstructor)_constructors.get(i), true);
            break;
          }
        }
      }
    }
  }
  
  protected void _addFactoryMixIns(Class<?> mixin)
  {
    MemberKey[] methodKeys = null;
    int methodCount = _creatorMethods.size();
    for (Method m : mixin.getDeclaredMethods()) {
      if (Modifier.isStatic(m.getModifiers())) {
        if (m.getParameterTypes().length != 0)
        {
          if (methodKeys == null)
          {
            methodKeys = new MemberKey[methodCount];
            for (int i = 0; i < methodCount; i++) {
              methodKeys[i] = new MemberKey(((AnnotatedMethod)_creatorMethods.get(i)).getAnnotated());
            }
          }
          MemberKey key = new MemberKey(m);
          for (int i = 0; i < methodCount; i++) {
            if (key.equals(methodKeys[i]))
            {
              _addMixOvers(m, (AnnotatedMethod)_creatorMethods.get(i), true);
              break;
            }
          }
        }
      }
    }
  }
  
  protected void _addMemberMethods(Class<?> cls, AnnotatedMethodMap methods, Class<?> mixInCls, AnnotatedMethodMap mixIns)
  {
    if (mixInCls != null) {
      _addMethodMixIns(cls, methods, mixInCls, mixIns);
    }
    if (cls == null) {
      return;
    }
    for (Method m : _findClassMethods(cls)) {
      if (_isIncludableMemberMethod(m))
      {
        AnnotatedMethod old = methods.find(m);
        if (old == null)
        {
          AnnotatedMethod newM = _constructMethod(m);
          methods.add(newM);
          
          old = mixIns.remove(m);
          if (old != null) {
            _addMixOvers(old.getAnnotated(), newM, false);
          }
        }
        else
        {
          _addMixUnders(m, old);
          if ((old.getDeclaringClass().isInterface()) && (!m.getDeclaringClass().isInterface())) {
            methods.add(old.withMethod(m));
          }
        }
      }
    }
  }
  
  protected void _addMethodMixIns(Class<?> targetClass, AnnotatedMethodMap methods, Class<?> mixInCls, AnnotatedMethodMap mixIns)
  {
    List<Class<?>> parents = new ArrayList();
    parents.add(mixInCls);
    ClassUtil.findSuperTypes(mixInCls, targetClass, parents);
    for (Class<?> mixin : parents) {
      for (Method m : mixin.getDeclaredMethods()) {
        if (_isIncludableMemberMethod(m))
        {
          AnnotatedMethod am = methods.find(m);
          if (am != null)
          {
            _addMixUnders(m, am);
          }
          else
          {
            am = mixIns.find(m);
            if (am != null) {
              _addMixUnders(m, am);
            } else {
              mixIns.add(_constructMethod(m));
            }
          }
        }
      }
    }
  }
  
  protected Map<String, AnnotatedField> _findFields(Class<?> c, Map<String, AnnotatedField> fields)
  {
    Class<?> parent = c.getSuperclass();
    if (parent != null)
    {
      fields = _findFields(parent, fields);
      for (Field f : c.getDeclaredFields()) {
        if (_isIncludableField(f))
        {
          if (fields == null) {
            fields = new LinkedHashMap();
          }
          fields.put(f.getName(), _constructField(f));
        }
      }
      if (_mixInResolver != null)
      {
        Class<?> mixin = _mixInResolver.findMixInClassFor(c);
        if (mixin != null) {
          _addFieldMixIns(parent, mixin, fields);
        }
      }
    }
    return fields;
  }
  
  protected void _addFieldMixIns(Class<?> targetClass, Class<?> mixInCls, Map<String, AnnotatedField> fields)
  {
    List<Class<?>> parents = new ArrayList();
    parents.add(mixInCls);
    ClassUtil.findSuperTypes(mixInCls, targetClass, parents);
    for (Class<?> mixin : parents) {
      for (Field mixinField : mixin.getDeclaredFields()) {
        if (_isIncludableField(mixinField))
        {
          String name = mixinField.getName();
          
          AnnotatedField maskedField = (AnnotatedField)fields.get(name);
          if (maskedField != null) {
            _addOrOverrideAnnotations(maskedField, mixinField.getDeclaredAnnotations());
          }
        }
      }
    }
  }
  
  protected AnnotatedMethod _constructMethod(Method m)
  {
    if (_annotationIntrospector == null) {
      return new AnnotatedMethod(this, m, _emptyAnnotationMap(), null);
    }
    return new AnnotatedMethod(this, m, _collectRelevantAnnotations(m.getDeclaredAnnotations()), null);
  }
  
  protected AnnotatedConstructor _constructConstructor(Constructor<?> ctor, boolean defaultCtor)
  {
    if (_annotationIntrospector == null) {
      return new AnnotatedConstructor(this, ctor, _emptyAnnotationMap(), _emptyAnnotationMaps(ctor.getParameterTypes().length));
    }
    if (defaultCtor) {
      return new AnnotatedConstructor(this, ctor, _collectRelevantAnnotations(ctor.getDeclaredAnnotations()), null);
    }
    Annotation[][] paramAnns = ctor.getParameterAnnotations();
    int paramCount = ctor.getParameterTypes().length;
    
    AnnotationMap[] resolvedAnnotations = null;
    if (paramCount != paramAnns.length)
    {
      Class<?> dc = ctor.getDeclaringClass();
      if ((dc.isEnum()) && (paramCount == paramAnns.length + 2))
      {
        Annotation[][] old = paramAnns;
        paramAnns = new Annotation[old.length + 2][];
        System.arraycopy(old, 0, paramAnns, 2, old.length);
        resolvedAnnotations = _collectRelevantAnnotations(paramAnns);
      }
      else if (dc.isMemberClass())
      {
        if (paramCount == paramAnns.length + 1)
        {
          Annotation[][] old = paramAnns;
          paramAnns = new Annotation[old.length + 1][];
          System.arraycopy(old, 0, paramAnns, 1, old.length);
          resolvedAnnotations = _collectRelevantAnnotations(paramAnns);
        }
      }
      if (resolvedAnnotations == null) {
        throw new IllegalStateException("Internal error: constructor for " + ctor.getDeclaringClass().getName() + " has mismatch: " + paramCount + " parameters; " + paramAnns.length + " sets of annotations");
      }
    }
    else
    {
      resolvedAnnotations = _collectRelevantAnnotations(paramAnns);
    }
    return new AnnotatedConstructor(this, ctor, _collectRelevantAnnotations(ctor.getDeclaredAnnotations()), resolvedAnnotations);
  }
  
  protected AnnotatedMethod _constructCreatorMethod(Method m)
  {
    if (_annotationIntrospector == null) {
      return new AnnotatedMethod(this, m, _emptyAnnotationMap(), _emptyAnnotationMaps(m.getParameterTypes().length));
    }
    return new AnnotatedMethod(this, m, _collectRelevantAnnotations(m.getDeclaredAnnotations()), _collectRelevantAnnotations(m.getParameterAnnotations()));
  }
  
  protected AnnotatedField _constructField(Field f)
  {
    if (_annotationIntrospector == null) {
      return new AnnotatedField(this, f, _emptyAnnotationMap());
    }
    return new AnnotatedField(this, f, _collectRelevantAnnotations(f.getDeclaredAnnotations()));
  }
  
  private AnnotationMap _emptyAnnotationMap()
  {
    return new AnnotationMap();
  }
  
  private AnnotationMap[] _emptyAnnotationMaps(int count)
  {
    if (count == 0) {
      return NO_ANNOTATION_MAPS;
    }
    AnnotationMap[] maps = new AnnotationMap[count];
    for (int i = 0; i < count; i++) {
      maps[i] = _emptyAnnotationMap();
    }
    return maps;
  }
  
  protected boolean _isIncludableMemberMethod(Method m)
  {
    if (Modifier.isStatic(m.getModifiers())) {
      return false;
    }
    if ((m.isSynthetic()) || (m.isBridge())) {
      return false;
    }
    int pcount = m.getParameterTypes().length;
    return pcount <= 2;
  }
  
  private boolean _isIncludableField(Field f)
  {
    if (f.isSynthetic()) {
      return false;
    }
    int mods = f.getModifiers();
    if (Modifier.isStatic(mods)) {
      return false;
    }
    return true;
  }
  
  private boolean _isIncludableConstructor(Constructor<?> c)
  {
    return !c.isSynthetic();
  }
  
  protected AnnotationMap[] _collectRelevantAnnotations(Annotation[][] anns)
  {
    int len = anns.length;
    AnnotationMap[] result = new AnnotationMap[len];
    for (int i = 0; i < len; i++) {
      result[i] = _collectRelevantAnnotations(anns[i]);
    }
    return result;
  }
  
  protected AnnotationMap _collectRelevantAnnotations(Annotation[] anns)
  {
    return _addAnnotationsIfNotPresent(new AnnotationMap(), anns);
  }
  
  private AnnotationMap _addAnnotationsIfNotPresent(AnnotationMap result, Annotation[] anns)
  {
    if (anns != null)
    {
      List<Annotation> fromBundles = null;
      for (Annotation ann : anns)
      {
        boolean wasNotPresent = result.addIfNotPresent(ann);
        if ((wasNotPresent) && (_isAnnotationBundle(ann))) {
          fromBundles = _addFromBundle(ann, fromBundles);
        }
      }
      if (fromBundles != null) {
        _addAnnotationsIfNotPresent(result, (Annotation[])fromBundles.toArray(new Annotation[fromBundles.size()]));
      }
    }
    return result;
  }
  
  private List<Annotation> _addFromBundle(Annotation bundle, List<Annotation> result)
  {
    for (Annotation a : bundle.annotationType().getDeclaredAnnotations()) {
      if ((!(a instanceof Target)) && (!(a instanceof Retention)))
      {
        if (result == null) {
          result = new ArrayList();
        }
        result.add(a);
      }
    }
    return result;
  }
  
  private void _addAnnotationsIfNotPresent(AnnotatedMember target, Annotation[] anns)
  {
    if (anns != null)
    {
      List<Annotation> fromBundles = null;
      for (Annotation ann : anns)
      {
        boolean wasNotPresent = target.addIfNotPresent(ann);
        if ((wasNotPresent) && (_isAnnotationBundle(ann))) {
          fromBundles = _addFromBundle(ann, fromBundles);
        }
      }
      if (fromBundles != null) {
        _addAnnotationsIfNotPresent(target, (Annotation[])fromBundles.toArray(new Annotation[fromBundles.size()]));
      }
    }
  }
  
  private void _addOrOverrideAnnotations(AnnotatedMember target, Annotation[] anns)
  {
    if (anns != null)
    {
      List<Annotation> fromBundles = null;
      for (Annotation ann : anns)
      {
        boolean wasModified = target.addOrOverride(ann);
        if ((wasModified) && (_isAnnotationBundle(ann))) {
          fromBundles = _addFromBundle(ann, fromBundles);
        }
      }
      if (fromBundles != null) {
        _addOrOverrideAnnotations(target, (Annotation[])fromBundles.toArray(new Annotation[fromBundles.size()]));
      }
    }
  }
  
  protected void _addMixOvers(Constructor<?> mixin, AnnotatedConstructor target, boolean addParamAnnotations)
  {
    _addOrOverrideAnnotations(target, mixin.getDeclaredAnnotations());
    if (addParamAnnotations)
    {
      Annotation[][] pa = mixin.getParameterAnnotations();
      int i = 0;
      for (int len = pa.length; i < len; i++) {
        for (Annotation a : pa[i]) {
          target.addOrOverrideParam(i, a);
        }
      }
    }
  }
  
  protected void _addMixOvers(Method mixin, AnnotatedMethod target, boolean addParamAnnotations)
  {
    _addOrOverrideAnnotations(target, mixin.getDeclaredAnnotations());
    if (addParamAnnotations)
    {
      Annotation[][] pa = mixin.getParameterAnnotations();
      int i = 0;
      for (int len = pa.length; i < len; i++) {
        for (Annotation a : pa[i]) {
          target.addOrOverrideParam(i, a);
        }
      }
    }
  }
  
  protected void _addMixUnders(Method src, AnnotatedMethod target)
  {
    _addAnnotationsIfNotPresent(target, src.getDeclaredAnnotations());
  }
  
  private final boolean _isAnnotationBundle(Annotation ann)
  {
    return (_annotationIntrospector != null) && (_annotationIntrospector.isAnnotationBundle(ann));
  }
  
  protected Method[] _findClassMethods(Class<?> cls)
  {
    try
    {
      return cls.getDeclaredMethods();
    }
    catch (NoClassDefFoundError ex)
    {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      if (loader == null) {
        throw ex;
      }
      Class<?> contextClass;
      try
      {
        contextClass = loader.loadClass(cls.getName());
      }
      catch (ClassNotFoundException e)
      {
        throw ex;
      }
      return contextClass.getDeclaredMethods();
    }
  }
  
  public String toString()
  {
    return "[AnnotedClass " + _class.getName() + "]";
  }
  
  public int hashCode()
  {
    return _class.getName().hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if ((o == null) || (o.getClass() != getClass())) {
      return false;
    }
    return _class == _class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */