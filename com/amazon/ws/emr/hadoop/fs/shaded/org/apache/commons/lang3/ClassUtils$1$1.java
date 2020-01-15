package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.mutable.MutableObject;
import java.util.Iterator;

class ClassUtils$1$1
  implements Iterator<Class<?>>
{
  ClassUtils$1$1(ClassUtils.1 param1, MutableObject paramMutableObject) {}
  
  public boolean hasNext()
  {
    return val$next.getValue() != null;
  }
  
  public Class<?> next()
  {
    Class<?> result = (Class)val$next.getValue();
    val$next.setValue(result.getSuperclass());
    return result;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ClassUtils.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */