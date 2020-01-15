package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EmptyIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class POJOPropertyBuilder
  extends BeanPropertyDefinition
  implements Comparable<POJOPropertyBuilder>
{
  protected final boolean _forSerialization;
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final PropertyName _name;
  protected final PropertyName _internalName;
  protected Linked<AnnotatedField> _fields;
  protected Linked<AnnotatedParameter> _ctorParameters;
  protected Linked<AnnotatedMethod> _getters;
  protected Linked<AnnotatedMethod> _setters;
  
  public POJOPropertyBuilder(PropertyName internalName, AnnotationIntrospector ai, boolean forSerialization)
  {
    this(internalName, internalName, ai, forSerialization);
  }
  
  protected POJOPropertyBuilder(PropertyName internalName, PropertyName name, AnnotationIntrospector annotationIntrospector, boolean forSerialization)
  {
    _internalName = internalName;
    _name = name;
    _annotationIntrospector = annotationIntrospector;
    _forSerialization = forSerialization;
  }
  
  public POJOPropertyBuilder(POJOPropertyBuilder src, PropertyName newName)
  {
    _internalName = _internalName;
    _name = newName;
    _annotationIntrospector = _annotationIntrospector;
    _fields = _fields;
    _ctorParameters = _ctorParameters;
    _getters = _getters;
    _setters = _setters;
    _forSerialization = _forSerialization;
  }
  
  public POJOPropertyBuilder withName(PropertyName newName)
  {
    return new POJOPropertyBuilder(this, newName);
  }
  
  public POJOPropertyBuilder withSimpleName(String newSimpleName)
  {
    PropertyName newName = _name.withSimpleName(newSimpleName);
    return newName == _name ? this : new POJOPropertyBuilder(this, newName);
  }
  
  public int compareTo(POJOPropertyBuilder other)
  {
    if (_ctorParameters != null)
    {
      if (_ctorParameters == null) {
        return -1;
      }
    }
    else if (_ctorParameters != null) {
      return 1;
    }
    return getName().compareTo(other.getName());
  }
  
  public String getName()
  {
    return _name == null ? null : _name.getSimpleName();
  }
  
  public PropertyName getFullName()
  {
    return _name;
  }
  
  public boolean hasName(PropertyName name)
  {
    return _name.equals(name);
  }
  
  public String getInternalName()
  {
    return _internalName.getSimpleName();
  }
  
  public PropertyName getWrapperName()
  {
    AnnotatedMember member = getPrimaryMember();
    return (member == null) || (_annotationIntrospector == null) ? null : _annotationIntrospector.findWrapperName(member);
  }
  
  public boolean isExplicitlyIncluded()
  {
    return (_anyExplicits(_fields)) || (_anyExplicits(_getters)) || (_anyExplicits(_setters)) || (_anyExplicits(_ctorParameters));
  }
  
  public boolean isExplicitlyNamed()
  {
    return (_anyExplicitNames(_fields)) || (_anyExplicitNames(_getters)) || (_anyExplicitNames(_setters)) || (_anyExplicitNames(_ctorParameters));
  }
  
  public boolean hasGetter()
  {
    return _getters != null;
  }
  
  public boolean hasSetter()
  {
    return _setters != null;
  }
  
  public boolean hasField()
  {
    return _fields != null;
  }
  
  public boolean hasConstructorParameter()
  {
    return _ctorParameters != null;
  }
  
  public boolean couldDeserialize()
  {
    return (_ctorParameters != null) || (_setters != null) || (_fields != null);
  }
  
  public boolean couldSerialize()
  {
    return (_getters != null) || (_fields != null);
  }
  
  public AnnotatedMethod getGetter()
  {
    Linked<AnnotatedMethod> curr = _getters;
    if (curr == null) {
      return null;
    }
    Linked<AnnotatedMethod> next = next;
    if (next == null) {
      return (AnnotatedMethod)value;
    }
    for (; next != null; next = next)
    {
      Class<?> currClass = ((AnnotatedMethod)value).getDeclaringClass();
      Class<?> nextClass = ((AnnotatedMethod)value).getDeclaringClass();
      if (currClass != nextClass)
      {
        if (currClass.isAssignableFrom(nextClass)) {
          curr = next;
        } else if (nextClass.isAssignableFrom(currClass)) {}
      }
      else
      {
        int priNext = _getterPriority((AnnotatedMethod)value);
        int priCurr = _getterPriority((AnnotatedMethod)value);
        if (priNext != priCurr)
        {
          if (priNext < priCurr) {
            curr = next;
          }
        }
        else {
          throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod)value).getFullName() + " vs " + ((AnnotatedMethod)value).getFullName());
        }
      }
    }
    _getters = curr.withoutNext();
    return (AnnotatedMethod)value;
  }
  
  public AnnotatedMethod getSetter()
  {
    Linked<AnnotatedMethod> curr = _setters;
    if (curr == null) {
      return null;
    }
    Linked<AnnotatedMethod> next = next;
    if (next == null) {
      return (AnnotatedMethod)value;
    }
    for (; next != null; next = next)
    {
      Class<?> currClass = ((AnnotatedMethod)value).getDeclaringClass();
      Class<?> nextClass = ((AnnotatedMethod)value).getDeclaringClass();
      if (currClass != nextClass)
      {
        if (currClass.isAssignableFrom(nextClass)) {
          curr = next;
        } else if (nextClass.isAssignableFrom(currClass)) {}
      }
      else
      {
        int priNext = _setterPriority((AnnotatedMethod)value);
        int priCurr = _setterPriority((AnnotatedMethod)value);
        if (priNext != priCurr)
        {
          if (priNext < priCurr) {
            curr = next;
          }
        }
        else {
          throw new IllegalArgumentException("Conflicting setter definitions for property \"" + getName() + "\": " + ((AnnotatedMethod)value).getFullName() + " vs " + ((AnnotatedMethod)value).getFullName());
        }
      }
    }
    _setters = curr.withoutNext();
    return (AnnotatedMethod)value;
  }
  
  public AnnotatedField getField()
  {
    if (_fields == null) {
      return null;
    }
    AnnotatedField field = (AnnotatedField)_fields.value;
    for (Linked<AnnotatedField> next = _fields.next; next != null; next = next)
    {
      AnnotatedField nextField = (AnnotatedField)value;
      Class<?> fieldClass = field.getDeclaringClass();
      Class<?> nextClass = nextField.getDeclaringClass();
      if (fieldClass != nextClass)
      {
        if (fieldClass.isAssignableFrom(nextClass)) {
          field = nextField;
        } else if (nextClass.isAssignableFrom(fieldClass)) {}
      }
      else {
        throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + field.getFullName() + " vs " + nextField.getFullName());
      }
    }
    return field;
  }
  
  public AnnotatedParameter getConstructorParameter()
  {
    if (_ctorParameters == null) {
      return null;
    }
    Linked<AnnotatedParameter> curr = _ctorParameters;
    do
    {
      if ((((AnnotatedParameter)value).getOwner() instanceof AnnotatedConstructor)) {
        return (AnnotatedParameter)value;
      }
      curr = next;
    } while (curr != null);
    return (AnnotatedParameter)_ctorParameters.value;
  }
  
  public Iterator<AnnotatedParameter> getConstructorParameters()
  {
    if (_ctorParameters == null) {
      return EmptyIterator.instance();
    }
    return new MemberIterator(_ctorParameters);
  }
  
  public AnnotatedMember getAccessor()
  {
    AnnotatedMember m = getGetter();
    if (m == null) {
      m = getField();
    }
    return m;
  }
  
  public AnnotatedMember getMutator()
  {
    AnnotatedMember m = getConstructorParameter();
    if (m == null)
    {
      m = getSetter();
      if (m == null) {
        m = getField();
      }
    }
    return m;
  }
  
  public AnnotatedMember getNonConstructorMutator()
  {
    AnnotatedMember m = getSetter();
    if (m == null) {
      m = getField();
    }
    return m;
  }
  
  public AnnotatedMember getPrimaryMember()
  {
    if (_forSerialization) {
      return getAccessor();
    }
    return getMutator();
  }
  
  protected int _getterPriority(AnnotatedMethod m)
  {
    String name = m.getName();
    if ((name.startsWith("get")) && (name.length() > 3)) {
      return 1;
    }
    if ((name.startsWith("is")) && (name.length() > 2)) {
      return 2;
    }
    return 3;
  }
  
  protected int _setterPriority(AnnotatedMethod m)
  {
    String name = m.getName();
    if ((name.startsWith("set")) && (name.length() > 3)) {
      return 1;
    }
    return 2;
  }
  
  public Class<?>[] findViews()
  {
    (Class[])fromMemberAnnotations(new WithMember()
    {
      public Class<?>[] withMember(AnnotatedMember member)
      {
        return _annotationIntrospector.findViews(member);
      }
    });
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType()
  {
    (AnnotationIntrospector.ReferenceProperty)fromMemberAnnotations(new WithMember()
    {
      public AnnotationIntrospector.ReferenceProperty withMember(AnnotatedMember member)
      {
        return _annotationIntrospector.findReferenceType(member);
      }
    });
  }
  
  public boolean isTypeId()
  {
    Boolean b = (Boolean)fromMemberAnnotations(new WithMember()
    {
      public Boolean withMember(AnnotatedMember member)
      {
        return _annotationIntrospector.isTypeId(member);
      }
    });
    return (b != null) && (b.booleanValue());
  }
  
  public PropertyMetadata getMetadata()
  {
    Boolean b = _findRequired();
    String desc = _findDescription();
    Integer idx = _findIndex();
    String def = _findDefaultValue();
    if ((b == null) && (idx == null) && (def == null)) {
      return desc == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : PropertyMetadata.STD_REQUIRED_OR_OPTIONAL.withDescription(desc);
    }
    return PropertyMetadata.construct(b.booleanValue(), desc, idx, def);
  }
  
  protected Boolean _findRequired()
  {
    Boolean b = (Boolean)fromMemberAnnotations(new WithMember()
    {
      public Boolean withMember(AnnotatedMember member)
      {
        return _annotationIntrospector.hasRequiredMarker(member);
      }
    });
    return b;
  }
  
  protected String _findDescription()
  {
    (String)fromMemberAnnotations(new WithMember()
    {
      public String withMember(AnnotatedMember member)
      {
        return _annotationIntrospector.findPropertyDescription(member);
      }
    });
  }
  
  protected Integer _findIndex()
  {
    (Integer)fromMemberAnnotations(new WithMember()
    {
      public Integer withMember(AnnotatedMember member)
      {
        return _annotationIntrospector.findPropertyIndex(member);
      }
    });
  }
  
  protected String _findDefaultValue()
  {
    (String)fromMemberAnnotations(new WithMember()
    {
      public String withMember(AnnotatedMember member)
      {
        return _annotationIntrospector.findPropertyDefaultValue(member);
      }
    });
  }
  
  public ObjectIdInfo findObjectIdInfo()
  {
    (ObjectIdInfo)fromMemberAnnotations(new WithMember()
    {
      public ObjectIdInfo withMember(AnnotatedMember member)
      {
        ObjectIdInfo info = _annotationIntrospector.findObjectIdInfo(member);
        if (info != null) {
          info = _annotationIntrospector.findObjectReferenceInfo(member, info);
        }
        return info;
      }
    });
  }
  
  public JsonInclude.Include findInclusion()
  {
    if (_annotationIntrospector == null) {
      return null;
    }
    AnnotatedMember am = getAccessor();
    return _annotationIntrospector.findSerializationInclusion(am, null);
  }
  
  public JsonProperty.Access findAccess()
  {
    (JsonProperty.Access)fromMemberAnnotationsExcept(new WithMember()
    {
      public JsonProperty.Access withMember(AnnotatedMember member)
      {
        return _annotationIntrospector.findPropertyAccess(member);
      }
    }, JsonProperty.Access.AUTO);
  }
  
  public void addField(AnnotatedField a, PropertyName name, boolean explName, boolean visible, boolean ignored)
  {
    _fields = new Linked(a, _fields, name, explName, visible, ignored);
  }
  
  public void addCtor(AnnotatedParameter a, PropertyName name, boolean explName, boolean visible, boolean ignored)
  {
    _ctorParameters = new Linked(a, _ctorParameters, name, explName, visible, ignored);
  }
  
  public void addGetter(AnnotatedMethod a, PropertyName name, boolean explName, boolean visible, boolean ignored)
  {
    _getters = new Linked(a, _getters, name, explName, visible, ignored);
  }
  
  public void addSetter(AnnotatedMethod a, PropertyName name, boolean explName, boolean visible, boolean ignored)
  {
    _setters = new Linked(a, _setters, name, explName, visible, ignored);
  }
  
  public void addAll(POJOPropertyBuilder src)
  {
    _fields = merge(_fields, _fields);
    _ctorParameters = merge(_ctorParameters, _ctorParameters);
    _getters = merge(_getters, _getters);
    _setters = merge(_setters, _setters);
  }
  
  private static <T> Linked<T> merge(Linked<T> chain1, Linked<T> chain2)
  {
    if (chain1 == null) {
      return chain2;
    }
    if (chain2 == null) {
      return chain1;
    }
    return chain1.append(chain2);
  }
  
  public void removeIgnored()
  {
    _fields = _removeIgnored(_fields);
    _getters = _removeIgnored(_getters);
    _setters = _removeIgnored(_setters);
    _ctorParameters = _removeIgnored(_ctorParameters);
  }
  
  public void removeNonVisible(boolean inferMutators)
  {
    JsonProperty.Access acc = findAccess();
    if (acc == null) {
      acc = JsonProperty.Access.AUTO;
    }
    switch (acc)
    {
    case READ_ONLY: 
      _setters = null;
      _ctorParameters = null;
      if (!_forSerialization) {
        _fields = null;
      }
      break;
    case READ_WRITE: 
      break;
    case WRITE_ONLY: 
      _getters = null;
      if (_forSerialization) {
        _fields = null;
      }
      break;
    case AUTO: 
    default: 
      _getters = _removeNonVisible(_getters);
      _ctorParameters = _removeNonVisible(_ctorParameters);
      if ((!inferMutators) || (_getters == null))
      {
        _fields = _removeNonVisible(_fields);
        _setters = _removeNonVisible(_setters);
      }
      break;
    }
  }
  
  public void removeConstructors()
  {
    _ctorParameters = null;
  }
  
  public void trimByVisibility()
  {
    _fields = _trimByVisibility(_fields);
    _getters = _trimByVisibility(_getters);
    _setters = _trimByVisibility(_setters);
    _ctorParameters = _trimByVisibility(_ctorParameters);
  }
  
  public void mergeAnnotations(boolean forSerialization)
  {
    if (forSerialization)
    {
      if (_getters != null)
      {
        AnnotationMap ann = _mergeAnnotations(0, new Linked[] { _getters, _fields, _ctorParameters, _setters });
        _getters = _applyAnnotations(_getters, ann);
      }
      else if (_fields != null)
      {
        AnnotationMap ann = _mergeAnnotations(0, new Linked[] { _fields, _ctorParameters, _setters });
        _fields = _applyAnnotations(_fields, ann);
      }
    }
    else if (_ctorParameters != null)
    {
      AnnotationMap ann = _mergeAnnotations(0, new Linked[] { _ctorParameters, _setters, _fields, _getters });
      _ctorParameters = _applyAnnotations(_ctorParameters, ann);
    }
    else if (_setters != null)
    {
      AnnotationMap ann = _mergeAnnotations(0, new Linked[] { _setters, _fields, _getters });
      _setters = _applyAnnotations(_setters, ann);
    }
    else if (_fields != null)
    {
      AnnotationMap ann = _mergeAnnotations(0, new Linked[] { _fields, _getters });
      _fields = _applyAnnotations(_fields, ann);
    }
  }
  
  private AnnotationMap _mergeAnnotations(int index, Linked<? extends AnnotatedMember>... nodes)
  {
    AnnotationMap ann = _getAllAnnotations(nodes[index]);
    index++;
    for (; index < nodes.length; index++) {
      if (nodes[index] != null) {
        return AnnotationMap.merge(ann, _mergeAnnotations(index, nodes));
      }
    }
    return ann;
  }
  
  private <T extends AnnotatedMember> AnnotationMap _getAllAnnotations(Linked<T> node)
  {
    AnnotationMap ann = ((AnnotatedMember)value).getAllAnnotations();
    if (next != null) {
      ann = AnnotationMap.merge(ann, _getAllAnnotations(next));
    }
    return ann;
  }
  
  private <T extends AnnotatedMember> Linked<T> _applyAnnotations(Linked<T> node, AnnotationMap ann)
  {
    T value = (AnnotatedMember)((AnnotatedMember)value).withAnnotations(ann);
    if (next != null) {
      node = node.withNext(_applyAnnotations(next, ann));
    }
    return node.withValue(value);
  }
  
  private <T> Linked<T> _removeIgnored(Linked<T> node)
  {
    if (node == null) {
      return node;
    }
    return node.withoutIgnored();
  }
  
  private <T> Linked<T> _removeNonVisible(Linked<T> node)
  {
    if (node == null) {
      return node;
    }
    return node.withoutNonVisible();
  }
  
  private <T> Linked<T> _trimByVisibility(Linked<T> node)
  {
    if (node == null) {
      return node;
    }
    return node.trimByVisibility();
  }
  
  private <T> boolean _anyExplicits(Linked<T> n)
  {
    for (; n != null; n = next) {
      if ((name != null) && (name.hasSimpleName())) {
        return true;
      }
    }
    return false;
  }
  
  private <T> boolean _anyExplicitNames(Linked<T> n)
  {
    for (; n != null; n = next) {
      if ((name != null) && (isNameExplicit)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean anyVisible()
  {
    return (_anyVisible(_fields)) || (_anyVisible(_getters)) || (_anyVisible(_setters)) || (_anyVisible(_ctorParameters));
  }
  
  private <T> boolean _anyVisible(Linked<T> n)
  {
    for (; n != null; n = next) {
      if (isVisible) {
        return true;
      }
    }
    return false;
  }
  
  public boolean anyIgnorals()
  {
    return (_anyIgnorals(_fields)) || (_anyIgnorals(_getters)) || (_anyIgnorals(_setters)) || (_anyIgnorals(_ctorParameters));
  }
  
  private <T> boolean _anyIgnorals(Linked<T> n)
  {
    for (; n != null; n = next) {
      if (isMarkedIgnored) {
        return true;
      }
    }
    return false;
  }
  
  public Set<PropertyName> findExplicitNames()
  {
    Set<PropertyName> renamed = null;
    renamed = _findExplicitNames(_fields, renamed);
    renamed = _findExplicitNames(_getters, renamed);
    renamed = _findExplicitNames(_setters, renamed);
    renamed = _findExplicitNames(_ctorParameters, renamed);
    if (renamed == null) {
      return Collections.emptySet();
    }
    return renamed;
  }
  
  public Collection<POJOPropertyBuilder> explode(Collection<PropertyName> newNames)
  {
    HashMap<PropertyName, POJOPropertyBuilder> props = new HashMap();
    _explode(newNames, props, _fields);
    _explode(newNames, props, _getters);
    _explode(newNames, props, _setters);
    _explode(newNames, props, _ctorParameters);
    return props.values();
  }
  
  private void _explode(Collection<PropertyName> newNames, Map<PropertyName, POJOPropertyBuilder> props, Linked<?> accessors)
  {
    Linked<?> firstAcc = accessors;
    for (Linked<?> node = accessors; node != null; node = next)
    {
      PropertyName name = name;
      if ((!isNameExplicit) || (name == null))
      {
        if (isVisible) {
          throw new IllegalStateException("Conflicting/ambiguous property name definitions (implicit name '" + _name + "'): found multiple explicit names: " + newNames + ", but also implicit accessor: " + node);
        }
      }
      else
      {
        POJOPropertyBuilder prop = (POJOPropertyBuilder)props.get(name);
        if (prop == null)
        {
          prop = new POJOPropertyBuilder(_internalName, name, _annotationIntrospector, _forSerialization);
          props.put(name, prop);
        }
        if (firstAcc == _fields)
        {
          Linked<AnnotatedField> n2 = node;
          _fields = n2.withNext(_fields);
        }
        else if (firstAcc == _getters)
        {
          Linked<AnnotatedMethod> n2 = node;
          _getters = n2.withNext(_getters);
        }
        else if (firstAcc == _setters)
        {
          Linked<AnnotatedMethod> n2 = node;
          _setters = n2.withNext(_setters);
        }
        else if (firstAcc == _ctorParameters)
        {
          Linked<AnnotatedParameter> n2 = node;
          _ctorParameters = n2.withNext(_ctorParameters);
        }
        else
        {
          throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
        }
      }
    }
  }
  
  private Set<PropertyName> _findExplicitNames(Linked<? extends AnnotatedMember> node, Set<PropertyName> renamed)
  {
    for (; node != null; node = next) {
      if ((isNameExplicit) && (name != null))
      {
        if (renamed == null) {
          renamed = new HashSet();
        }
        renamed.add(name);
      }
    }
    return renamed;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("[Property '").append(_name).append("'; ctors: ").append(_ctorParameters).append(", field(s): ").append(_fields).append(", getter(s): ").append(_getters).append(", setter(s): ").append(_setters);
    
    sb.append("]");
    return sb.toString();
  }
  
  protected <T> T fromMemberAnnotations(WithMember<T> func)
  {
    T result = null;
    if (_annotationIntrospector != null)
    {
      if (_forSerialization)
      {
        if (_getters != null) {
          result = func.withMember((AnnotatedMember)_getters.value);
        }
      }
      else
      {
        if (_ctorParameters != null) {
          result = func.withMember((AnnotatedMember)_ctorParameters.value);
        }
        if ((result == null) && (_setters != null)) {
          result = func.withMember((AnnotatedMember)_setters.value);
        }
      }
      if ((result == null) && (_fields != null)) {
        result = func.withMember((AnnotatedMember)_fields.value);
      }
    }
    return result;
  }
  
  protected <T> T fromMemberAnnotationsExcept(WithMember<T> func, T defaultValue)
  {
    if (_annotationIntrospector == null) {
      return null;
    }
    if (_forSerialization)
    {
      if (_getters != null)
      {
        T result = func.withMember((AnnotatedMember)_getters.value);
        if ((result != null) && (result != defaultValue)) {
          return result;
        }
      }
      if (_fields != null)
      {
        T result = func.withMember((AnnotatedMember)_fields.value);
        if ((result != null) && (result != defaultValue)) {
          return result;
        }
      }
      if (_ctorParameters != null)
      {
        T result = func.withMember((AnnotatedMember)_ctorParameters.value);
        if ((result != null) && (result != defaultValue)) {
          return result;
        }
      }
      if (_setters != null)
      {
        T result = func.withMember((AnnotatedMember)_setters.value);
        if ((result != null) && (result != defaultValue)) {
          return result;
        }
      }
      return null;
    }
    if (_ctorParameters != null)
    {
      T result = func.withMember((AnnotatedMember)_ctorParameters.value);
      if ((result != null) && (result != defaultValue)) {
        return result;
      }
    }
    if (_setters != null)
    {
      T result = func.withMember((AnnotatedMember)_setters.value);
      if ((result != null) && (result != defaultValue)) {
        return result;
      }
    }
    if (_fields != null)
    {
      T result = func.withMember((AnnotatedMember)_fields.value);
      if ((result != null) && (result != defaultValue)) {
        return result;
      }
    }
    if (_getters != null)
    {
      T result = func.withMember((AnnotatedMember)_getters.value);
      if ((result != null) && (result != defaultValue)) {
        return result;
      }
    }
    return null;
  }
  
  private static abstract interface WithMember<T>
  {
    public abstract T withMember(AnnotatedMember paramAnnotatedMember);
  }
  
  protected static class MemberIterator<T extends AnnotatedMember>
    implements Iterator<T>
  {
    private POJOPropertyBuilder.Linked<T> next;
    
    public MemberIterator(POJOPropertyBuilder.Linked<T> first)
    {
      next = first;
    }
    
    public boolean hasNext()
    {
      return next != null;
    }
    
    public T next()
    {
      if (next == null) {
        throw new NoSuchElementException();
      }
      T result = (AnnotatedMember)next.value;
      next = next.next;
      return result;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  protected static final class Linked<T>
  {
    public final T value;
    public final Linked<T> next;
    public final PropertyName name;
    public final boolean isNameExplicit;
    public final boolean isVisible;
    public final boolean isMarkedIgnored;
    
    public Linked(T v, Linked<T> n, PropertyName name, boolean explName, boolean visible, boolean ignored)
    {
      value = v;
      next = n;
      
      this.name = ((name == null) || (name.isEmpty()) ? null : name);
      if (explName)
      {
        if (this.name == null) {
          throw new IllegalArgumentException("Can not pass true for 'explName' if name is null/empty");
        }
        if (!name.hasSimpleName()) {
          explName = false;
        }
      }
      isNameExplicit = explName;
      isVisible = visible;
      isMarkedIgnored = ignored;
    }
    
    public Linked<T> withoutNext()
    {
      if (next == null) {
        return this;
      }
      return new Linked(value, null, name, isNameExplicit, isVisible, isMarkedIgnored);
    }
    
    public Linked<T> withValue(T newValue)
    {
      if (newValue == value) {
        return this;
      }
      return new Linked(newValue, next, name, isNameExplicit, isVisible, isMarkedIgnored);
    }
    
    public Linked<T> withNext(Linked<T> newNext)
    {
      if (newNext == next) {
        return this;
      }
      return new Linked(value, newNext, name, isNameExplicit, isVisible, isMarkedIgnored);
    }
    
    public Linked<T> withoutIgnored()
    {
      if (isMarkedIgnored) {
        return next == null ? null : next.withoutIgnored();
      }
      if (next != null)
      {
        Linked<T> newNext = next.withoutIgnored();
        if (newNext != next) {
          return withNext(newNext);
        }
      }
      return this;
    }
    
    public Linked<T> withoutNonVisible()
    {
      Linked<T> newNext = next == null ? null : next.withoutNonVisible();
      return isVisible ? withNext(newNext) : newNext;
    }
    
    protected Linked<T> append(Linked<T> appendable)
    {
      if (next == null) {
        return withNext(appendable);
      }
      return withNext(next.append(appendable));
    }
    
    public Linked<T> trimByVisibility()
    {
      if (next == null) {
        return this;
      }
      Linked<T> newNext = next.trimByVisibility();
      if (name != null)
      {
        if (name == null) {
          return withNext(null);
        }
        return withNext(newNext);
      }
      if (name != null) {
        return newNext;
      }
      if (isVisible == isVisible) {
        return withNext(newNext);
      }
      return isVisible ? withNext(null) : newNext;
    }
    
    public String toString()
    {
      String msg = value.toString() + "[visible=" + isVisible + ",ignore=" + isMarkedIgnored + ",explicitName=" + isNameExplicit + "]";
      if (next != null) {
        msg = msg + ", " + next.toString();
      }
      return msg;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */