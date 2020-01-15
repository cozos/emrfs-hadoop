package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.FailingDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ViewMatcher;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;

public abstract class SettableBeanProperty
  implements BeanProperty, Serializable
{
  protected static final JsonDeserializer<Object> MISSING_VALUE_DESERIALIZER = new FailingDeserializer("No _valueDeserializer assigned");
  protected final PropertyName _propName;
  protected final JavaType _type;
  protected final PropertyName _wrapperName;
  protected final transient Annotations _contextAnnotations;
  protected final JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  protected final PropertyMetadata _metadata;
  protected String _managedReferenceName;
  protected ObjectIdInfo _objectIdInfo;
  protected ViewMatcher _viewMatcher;
  protected int _propertyIndex = -1;
  
  protected SettableBeanProperty(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations)
  {
    this(propDef.getFullName(), type, propDef.getWrapperName(), typeDeser, contextAnnotations, propDef.getMetadata());
  }
  
  @Deprecated
  protected SettableBeanProperty(String propName, JavaType type, PropertyName wrapper, TypeDeserializer typeDeser, Annotations contextAnnotations, boolean isRequired)
  {
    this(new PropertyName(propName), type, wrapper, typeDeser, contextAnnotations, PropertyMetadata.construct(isRequired, null, null, null));
  }
  
  protected SettableBeanProperty(PropertyName propName, JavaType type, PropertyName wrapper, TypeDeserializer typeDeser, Annotations contextAnnotations, PropertyMetadata metadata)
  {
    if (propName == null) {
      _propName = PropertyName.NO_NAME;
    } else {
      _propName = propName.internSimpleName();
    }
    _type = type;
    _wrapperName = wrapper;
    _metadata = metadata;
    _contextAnnotations = contextAnnotations;
    _viewMatcher = null;
    if (typeDeser != null) {
      typeDeser = typeDeser.forProperty(this);
    }
    _valueTypeDeserializer = typeDeser;
    _valueDeserializer = MISSING_VALUE_DESERIALIZER;
  }
  
  protected SettableBeanProperty(PropertyName propName, JavaType type, PropertyMetadata metadata, JsonDeserializer<Object> valueDeser)
  {
    if (propName == null) {
      _propName = PropertyName.NO_NAME;
    } else {
      _propName = propName.internSimpleName();
    }
    _type = type;
    _wrapperName = null;
    _metadata = metadata;
    _contextAnnotations = null;
    _viewMatcher = null;
    _valueTypeDeserializer = null;
    _valueDeserializer = valueDeser;
  }
  
  protected SettableBeanProperty(SettableBeanProperty src)
  {
    _propName = _propName;
    _type = _type;
    _wrapperName = _wrapperName;
    _metadata = _metadata;
    _contextAnnotations = _contextAnnotations;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
    _managedReferenceName = _managedReferenceName;
    _propertyIndex = _propertyIndex;
    _viewMatcher = _viewMatcher;
  }
  
  protected SettableBeanProperty(SettableBeanProperty src, JsonDeserializer<?> deser)
  {
    _propName = _propName;
    _type = _type;
    _wrapperName = _wrapperName;
    _metadata = _metadata;
    _contextAnnotations = _contextAnnotations;
    _valueTypeDeserializer = _valueTypeDeserializer;
    _managedReferenceName = _managedReferenceName;
    _propertyIndex = _propertyIndex;
    if (deser == null) {
      _valueDeserializer = MISSING_VALUE_DESERIALIZER;
    } else {
      _valueDeserializer = deser;
    }
    _viewMatcher = _viewMatcher;
  }
  
  @Deprecated
  protected SettableBeanProperty(SettableBeanProperty src, String newName)
  {
    this(src, new PropertyName(newName));
  }
  
  protected SettableBeanProperty(SettableBeanProperty src, PropertyName newName)
  {
    _propName = newName;
    _type = _type;
    _wrapperName = _wrapperName;
    _metadata = _metadata;
    _contextAnnotations = _contextAnnotations;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
    _managedReferenceName = _managedReferenceName;
    _propertyIndex = _propertyIndex;
    _viewMatcher = _viewMatcher;
  }
  
  public abstract SettableBeanProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer);
  
  public abstract SettableBeanProperty withName(PropertyName paramPropertyName);
  
  public SettableBeanProperty withSimpleName(String simpleName)
  {
    PropertyName n = _propName == null ? new PropertyName(simpleName) : _propName.withSimpleName(simpleName);
    
    return n == _propName ? this : withName(n);
  }
  
  @Deprecated
  public SettableBeanProperty withName(String simpleName)
  {
    return withName(new PropertyName(simpleName));
  }
  
  public void setManagedReferenceName(String n)
  {
    _managedReferenceName = n;
  }
  
  public void setObjectIdInfo(ObjectIdInfo objectIdInfo)
  {
    _objectIdInfo = objectIdInfo;
  }
  
  public void setViews(Class<?>[] views)
  {
    if (views == null) {
      _viewMatcher = null;
    } else {
      _viewMatcher = ViewMatcher.construct(views);
    }
  }
  
  public void assignIndex(int index)
  {
    if (_propertyIndex != -1) {
      throw new IllegalStateException("Property '" + getName() + "' already had index (" + _propertyIndex + "), trying to assign " + index);
    }
    _propertyIndex = index;
  }
  
  public final String getName()
  {
    return _propName.getSimpleName();
  }
  
  public PropertyName getFullName()
  {
    return _propName;
  }
  
  public boolean isRequired()
  {
    return _metadata.isRequired();
  }
  
  public PropertyMetadata getMetadata()
  {
    return _metadata;
  }
  
  public JavaType getType()
  {
    return _type;
  }
  
  public PropertyName getWrapperName()
  {
    return _wrapperName;
  }
  
  public abstract AnnotatedMember getMember();
  
  public abstract <A extends Annotation> A getAnnotation(Class<A> paramClass);
  
  public <A extends Annotation> A getContextAnnotation(Class<A> acls)
  {
    return _contextAnnotations.get(acls);
  }
  
  public JsonFormat.Value findFormatOverrides(AnnotationIntrospector intr)
  {
    if (intr != null)
    {
      AnnotatedMember m = getMember();
      if (m != null) {
        return intr.findFormat(m);
      }
    }
    return null;
  }
  
  public void depositSchemaProperty(JsonObjectFormatVisitor objectVisitor)
    throws JsonMappingException
  {
    if (isRequired()) {
      objectVisitor.property(this);
    } else {
      objectVisitor.optionalProperty(this);
    }
  }
  
  protected final Class<?> getDeclaringClass()
  {
    return getMember().getDeclaringClass();
  }
  
  public String getManagedReferenceName()
  {
    return _managedReferenceName;
  }
  
  public ObjectIdInfo getObjectIdInfo()
  {
    return _objectIdInfo;
  }
  
  public boolean hasValueDeserializer()
  {
    return (_valueDeserializer != null) && (_valueDeserializer != MISSING_VALUE_DESERIALIZER);
  }
  
  public boolean hasValueTypeDeserializer()
  {
    return _valueTypeDeserializer != null;
  }
  
  public JsonDeserializer<Object> getValueDeserializer()
  {
    JsonDeserializer<Object> deser = _valueDeserializer;
    if (deser == MISSING_VALUE_DESERIALIZER) {
      return null;
    }
    return deser;
  }
  
  public TypeDeserializer getValueTypeDeserializer()
  {
    return _valueTypeDeserializer;
  }
  
  public boolean visibleInView(Class<?> activeView)
  {
    return (_viewMatcher == null) || (_viewMatcher.isVisibleForView(activeView));
  }
  
  public boolean hasViews()
  {
    return _viewMatcher != null;
  }
  
  public int getPropertyIndex()
  {
    return _propertyIndex;
  }
  
  public int getCreatorIndex()
  {
    return -1;
  }
  
  public Object getInjectableValueId()
  {
    return null;
  }
  
  public abstract void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException;
  
  public abstract Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException;
  
  public abstract void set(Object paramObject1, Object paramObject2)
    throws IOException;
  
  public abstract Object setAndReturn(Object paramObject1, Object paramObject2)
    throws IOException;
  
  public final Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    JsonToken t = p.getCurrentToken();
    if (t == JsonToken.VALUE_NULL) {
      return _valueDeserializer.getNullValue(ctxt);
    }
    if (_valueTypeDeserializer != null) {
      return _valueDeserializer.deserializeWithType(p, ctxt, _valueTypeDeserializer);
    }
    return _valueDeserializer.deserialize(p, ctxt);
  }
  
  protected void _throwAsIOE(Exception e, Object value)
    throws IOException
  {
    if ((e instanceof IllegalArgumentException))
    {
      String actType = value == null ? "[NULL]" : value.getClass().getName();
      StringBuilder msg = new StringBuilder("Problem deserializing property '").append(getName());
      msg.append("' (expected type: ").append(getType());
      msg.append("; actual type: ").append(actType).append(")");
      String origMsg = e.getMessage();
      if (origMsg != null) {
        msg.append(", problem: ").append(origMsg);
      } else {
        msg.append(" (no error message provided)");
      }
      throw new JsonMappingException(msg.toString(), null, e);
    }
    _throwAsIOE(e);
  }
  
  protected IOException _throwAsIOE(Exception e)
    throws IOException
  {
    if ((e instanceof IOException)) {
      throw ((IOException)e);
    }
    if ((e instanceof RuntimeException)) {
      throw ((RuntimeException)e);
    }
    Throwable th = e;
    while (th.getCause() != null) {
      th = th.getCause();
    }
    throw new JsonMappingException(th.getMessage(), null, th);
  }
  
  public String toString()
  {
    return "[property '" + getName() + "']";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */