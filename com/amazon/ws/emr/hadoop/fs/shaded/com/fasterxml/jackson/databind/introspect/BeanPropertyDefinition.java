package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.EmptyIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Named;
import java.util.Iterator;

public abstract class BeanPropertyDefinition
  implements Named
{
  public abstract BeanPropertyDefinition withName(PropertyName paramPropertyName);
  
  public abstract BeanPropertyDefinition withSimpleName(String paramString);
  
  public abstract String getName();
  
  public abstract PropertyName getFullName();
  
  public boolean hasName(PropertyName name)
  {
    return getFullName().equals(name);
  }
  
  public abstract String getInternalName();
  
  public abstract PropertyName getWrapperName();
  
  public abstract PropertyMetadata getMetadata();
  
  public abstract boolean isExplicitlyIncluded();
  
  public boolean isExplicitlyNamed()
  {
    return isExplicitlyIncluded();
  }
  
  public boolean couldDeserialize()
  {
    return getMutator() != null;
  }
  
  public boolean couldSerialize()
  {
    return getAccessor() != null;
  }
  
  public abstract boolean hasGetter();
  
  public abstract boolean hasSetter();
  
  public abstract boolean hasField();
  
  public abstract boolean hasConstructorParameter();
  
  public abstract AnnotatedMethod getGetter();
  
  public abstract AnnotatedMethod getSetter();
  
  public abstract AnnotatedField getField();
  
  public abstract AnnotatedParameter getConstructorParameter();
  
  public Iterator<AnnotatedParameter> getConstructorParameters()
  {
    return EmptyIterator.instance();
  }
  
  public abstract AnnotatedMember getAccessor();
  
  public abstract AnnotatedMember getMutator();
  
  public abstract AnnotatedMember getNonConstructorMutator();
  
  public abstract AnnotatedMember getPrimaryMember();
  
  public Class<?>[] findViews()
  {
    return null;
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType()
  {
    return null;
  }
  
  public boolean isTypeId()
  {
    return false;
  }
  
  public ObjectIdInfo findObjectIdInfo()
  {
    return null;
  }
  
  public boolean isRequired()
  {
    PropertyMetadata md = getMetadata();
    return (md != null) && (md.isRequired());
  }
  
  public JsonInclude.Include findInclusion()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */