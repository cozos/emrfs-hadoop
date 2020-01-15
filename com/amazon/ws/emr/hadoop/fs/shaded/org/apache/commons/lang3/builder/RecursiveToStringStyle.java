package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ClassUtils;
import java.util.Collection;

public class RecursiveToStringStyle
  extends ToStringStyle
{
  private static final long serialVersionUID = 1L;
  
  public void appendDetail(StringBuffer buffer, String fieldName, Object value)
  {
    if ((!ClassUtils.isPrimitiveWrapper(value.getClass())) && (!String.class.equals(value.getClass())) && (accept(value.getClass()))) {
      buffer.append(ReflectionToStringBuilder.toString(value, this));
    } else {
      super.appendDetail(buffer, fieldName, value);
    }
  }
  
  protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> coll)
  {
    appendClassName(buffer, coll);
    appendIdentityHashCode(buffer, coll);
    appendDetail(buffer, fieldName, coll.toArray());
  }
  
  protected boolean accept(Class<?> clazz)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.RecursiveToStringStyle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */