package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Annotations;
import java.lang.annotation.Annotation;

public class BeanProperty$Std
  implements BeanProperty
{
  protected final PropertyName _name;
  protected final JavaType _type;
  protected final PropertyName _wrapperName;
  protected final PropertyMetadata _metadata;
  protected final AnnotatedMember _member;
  protected final Annotations _contextAnnotations;
  
  public BeanProperty$Std(PropertyName name, JavaType type, PropertyName wrapperName, Annotations contextAnnotations, AnnotatedMember member, PropertyMetadata metadata)
  {
    _name = name;
    _type = type;
    _wrapperName = wrapperName;
    _metadata = metadata;
    _member = member;
    _contextAnnotations = contextAnnotations;
  }
  
  public BeanProperty$Std(Std base, JavaType newType)
  {
    this(_name, newType, _wrapperName, _contextAnnotations, _member, _metadata);
  }
  
  @Deprecated
  public BeanProperty$Std(String name, JavaType type, PropertyName wrapperName, Annotations contextAnnotations, AnnotatedMember member, boolean isRequired)
  {
    this(new PropertyName(name), type, wrapperName, contextAnnotations, member, isRequired ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL);
  }
  
  public Std withType(JavaType type)
  {
    return new Std(this, type);
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _member == null ? null : _member.getAnnotation(acls);
  }
  
  public <A extends Annotation> A getContextAnnotation(Class<A> acls)
  {
    return _contextAnnotations == null ? null : _contextAnnotations.get(acls);
  }
  
  public JsonFormat.Value findFormatOverrides(AnnotationIntrospector intr)
  {
    return null;
  }
  
  public String getName()
  {
    return _name.getSimpleName();
  }
  
  public PropertyName getFullName()
  {
    return _name;
  }
  
  public JavaType getType()
  {
    return _type;
  }
  
  public PropertyName getWrapperName()
  {
    return _wrapperName;
  }
  
  public boolean isRequired()
  {
    return _metadata.isRequired();
  }
  
  public PropertyMetadata getMetadata()
  {
    return _metadata;
  }
  
  public AnnotatedMember getMember()
  {
    return _member;
  }
  
  public boolean isVirtual()
  {
    return false;
  }
  
  public void depositSchemaProperty(JsonObjectFormatVisitor objectVisitor)
  {
    throw new UnsupportedOperationException("Instances of " + getClass().getName() + " should not get visited");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty.Std
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */