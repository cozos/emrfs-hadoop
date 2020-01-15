package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.mutable.MutableObject;
import java.util.Iterator;

final class ClassUtils$1
  implements Iterable<Class<?>>
{
  ClassUtils$1(Class paramClass) {}
  
  public Iterator<Class<?>> iterator()
  {
    final MutableObject<Class<?>> next = new MutableObject(val$type);
    new Iterator()
    {
      public boolean hasNext()
      {
        return next.getValue() != null;
      }
      
      public Class<?> next()
      {
        Class<?> result = (Class)next.getValue();
        next.setValue(result.getSuperclass());
        return result;
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ClassUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */