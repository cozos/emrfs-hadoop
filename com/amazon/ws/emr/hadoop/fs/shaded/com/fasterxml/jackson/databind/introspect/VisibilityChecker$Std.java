package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

@JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, isGetterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility=JsonAutoDetect.Visibility.ANY, creatorVisibility=JsonAutoDetect.Visibility.ANY, fieldVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class VisibilityChecker$Std
  implements VisibilityChecker<Std>, Serializable
{
  private static final long serialVersionUID = 1L;
  protected static final Std DEFAULT = new Std((JsonAutoDetect)Std.class.getAnnotation(JsonAutoDetect.class));
  protected final JsonAutoDetect.Visibility _getterMinLevel;
  protected final JsonAutoDetect.Visibility _isGetterMinLevel;
  protected final JsonAutoDetect.Visibility _setterMinLevel;
  protected final JsonAutoDetect.Visibility _creatorMinLevel;
  protected final JsonAutoDetect.Visibility _fieldMinLevel;
  
  public static Std defaultInstance()
  {
    return DEFAULT;
  }
  
  public VisibilityChecker$Std(JsonAutoDetect ann)
  {
    _getterMinLevel = ann.getterVisibility();
    _isGetterMinLevel = ann.isGetterVisibility();
    _setterMinLevel = ann.setterVisibility();
    _creatorMinLevel = ann.creatorVisibility();
    _fieldMinLevel = ann.fieldVisibility();
  }
  
  public VisibilityChecker$Std(JsonAutoDetect.Visibility getter, JsonAutoDetect.Visibility isGetter, JsonAutoDetect.Visibility setter, JsonAutoDetect.Visibility creator, JsonAutoDetect.Visibility field)
  {
    _getterMinLevel = getter;
    _isGetterMinLevel = isGetter;
    _setterMinLevel = setter;
    _creatorMinLevel = creator;
    _fieldMinLevel = field;
  }
  
  public VisibilityChecker$Std(JsonAutoDetect.Visibility v)
  {
    if (v == JsonAutoDetect.Visibility.DEFAULT)
    {
      _getterMinLevel = DEFAULT_getterMinLevel;
      _isGetterMinLevel = DEFAULT_isGetterMinLevel;
      _setterMinLevel = DEFAULT_setterMinLevel;
      _creatorMinLevel = DEFAULT_creatorMinLevel;
      _fieldMinLevel = DEFAULT_fieldMinLevel;
    }
    else
    {
      _getterMinLevel = v;
      _isGetterMinLevel = v;
      _setterMinLevel = v;
      _creatorMinLevel = v;
      _fieldMinLevel = v;
    }
  }
  
  public Std with(JsonAutoDetect ann)
  {
    Std curr = this;
    if (ann != null)
    {
      curr = curr.withGetterVisibility(ann.getterVisibility());
      curr = curr.withIsGetterVisibility(ann.isGetterVisibility());
      curr = curr.withSetterVisibility(ann.setterVisibility());
      curr = curr.withCreatorVisibility(ann.creatorVisibility());
      curr = curr.withFieldVisibility(ann.fieldVisibility());
    }
    return curr;
  }
  
  public Std with(JsonAutoDetect.Visibility v)
  {
    if (v == JsonAutoDetect.Visibility.DEFAULT) {
      return DEFAULT;
    }
    return new Std(v);
  }
  
  public Std withVisibility(PropertyAccessor method, JsonAutoDetect.Visibility v)
  {
    switch (VisibilityChecker.1.$SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[method.ordinal()])
    {
    case 1: 
      return withGetterVisibility(v);
    case 2: 
      return withSetterVisibility(v);
    case 3: 
      return withCreatorVisibility(v);
    case 4: 
      return withFieldVisibility(v);
    case 5: 
      return withIsGetterVisibility(v);
    case 6: 
      return with(v);
    }
    return this;
  }
  
  public Std withGetterVisibility(JsonAutoDetect.Visibility v)
  {
    if (v == JsonAutoDetect.Visibility.DEFAULT) {
      v = DEFAULT_getterMinLevel;
    }
    if (_getterMinLevel == v) {
      return this;
    }
    return new Std(v, _isGetterMinLevel, _setterMinLevel, _creatorMinLevel, _fieldMinLevel);
  }
  
  public Std withIsGetterVisibility(JsonAutoDetect.Visibility v)
  {
    if (v == JsonAutoDetect.Visibility.DEFAULT) {
      v = DEFAULT_isGetterMinLevel;
    }
    if (_isGetterMinLevel == v) {
      return this;
    }
    return new Std(_getterMinLevel, v, _setterMinLevel, _creatorMinLevel, _fieldMinLevel);
  }
  
  public Std withSetterVisibility(JsonAutoDetect.Visibility v)
  {
    if (v == JsonAutoDetect.Visibility.DEFAULT) {
      v = DEFAULT_setterMinLevel;
    }
    if (_setterMinLevel == v) {
      return this;
    }
    return new Std(_getterMinLevel, _isGetterMinLevel, v, _creatorMinLevel, _fieldMinLevel);
  }
  
  public Std withCreatorVisibility(JsonAutoDetect.Visibility v)
  {
    if (v == JsonAutoDetect.Visibility.DEFAULT) {
      v = DEFAULT_creatorMinLevel;
    }
    if (_creatorMinLevel == v) {
      return this;
    }
    return new Std(_getterMinLevel, _isGetterMinLevel, _setterMinLevel, v, _fieldMinLevel);
  }
  
  public Std withFieldVisibility(JsonAutoDetect.Visibility v)
  {
    if (v == JsonAutoDetect.Visibility.DEFAULT) {
      v = DEFAULT_fieldMinLevel;
    }
    if (_fieldMinLevel == v) {
      return this;
    }
    return new Std(_getterMinLevel, _isGetterMinLevel, _setterMinLevel, _creatorMinLevel, v);
  }
  
  public boolean isCreatorVisible(Member m)
  {
    return _creatorMinLevel.isVisible(m);
  }
  
  public boolean isCreatorVisible(AnnotatedMember m)
  {
    return isCreatorVisible(m.getMember());
  }
  
  public boolean isFieldVisible(Field f)
  {
    return _fieldMinLevel.isVisible(f);
  }
  
  public boolean isFieldVisible(AnnotatedField f)
  {
    return isFieldVisible(f.getAnnotated());
  }
  
  public boolean isGetterVisible(Method m)
  {
    return _getterMinLevel.isVisible(m);
  }
  
  public boolean isGetterVisible(AnnotatedMethod m)
  {
    return isGetterVisible(m.getAnnotated());
  }
  
  public boolean isIsGetterVisible(Method m)
  {
    return _isGetterMinLevel.isVisible(m);
  }
  
  public boolean isIsGetterVisible(AnnotatedMethod m)
  {
    return isIsGetterVisible(m.getAnnotated());
  }
  
  public boolean isSetterVisible(Method m)
  {
    return _setterMinLevel.isVisible(m);
  }
  
  public boolean isSetterVisible(AnnotatedMethod m)
  {
    return isSetterVisible(m.getAnnotated());
  }
  
  public String toString()
  {
    return "[Visibility:" + " getter: " + _getterMinLevel + ", isGetter: " + _isGetterMinLevel + ", setter: " + _setterMinLevel + ", creator: " + _creatorMinLevel + ", field: " + _fieldMinLevel + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */