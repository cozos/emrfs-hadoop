package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.ToStringStyle;
import java.lang.annotation.Annotation;

final class AnnotationUtils$1
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  AnnotationUtils$1()
  {
    setDefaultFullDetail(true);
    setArrayContentDetail(true);
    setUseClassName(true);
    setUseShortClassName(true);
    setUseIdentityHashCode(false);
    setContentStart("(");
    setContentEnd(")");
    setFieldSeparator(", ");
    setArrayStart("[");
    setArrayEnd("]");
  }
  
  protected String getShortClassName(Class<?> cls)
  {
    Class<? extends Annotation> annotationType = null;
    for (Class<?> iface : ClassUtils.getAllInterfaces(cls)) {
      if (Annotation.class.isAssignableFrom(iface))
      {
        Class<? extends Annotation> found = iface;
        annotationType = found;
        break;
      }
    }
    return new StringBuilder(annotationType == null ? "" : annotationType.getName()).insert(0, '@').toString();
  }
  
  protected void appendDetail(StringBuffer buffer, String fieldName, Object value)
  {
    if ((value instanceof Annotation)) {
      value = AnnotationUtils.toString((Annotation)value);
    }
    super.appendDetail(buffer, fieldName, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.AnnotationUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */