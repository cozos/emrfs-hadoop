package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class ClassUtils$2$1
  implements Iterator<Class<?>>
{
  Iterator<Class<?>> interfaces = Collections.emptySet().iterator();
  
  ClassUtils$2$1(ClassUtils.2 param2, Iterator paramIterator, Set paramSet) {}
  
  public boolean hasNext()
  {
    return (interfaces.hasNext()) || (val$wrapped.hasNext());
  }
  
  public Class<?> next()
  {
    if (interfaces.hasNext())
    {
      Class<?> nextInterface = (Class)interfaces.next();
      val$seenInterfaces.add(nextInterface);
      return nextInterface;
    }
    Class<?> nextSuperclass = (Class)val$wrapped.next();
    Set<Class<?>> currentInterfaces = new LinkedHashSet();
    walkInterfaces(currentInterfaces, nextSuperclass);
    interfaces = currentInterfaces.iterator();
    return nextSuperclass;
  }
  
  private void walkInterfaces(Set<Class<?>> addTo, Class<?> c)
  {
    for (Class<?> iface : c.getInterfaces())
    {
      if (!val$seenInterfaces.contains(iface)) {
        addTo.add(iface);
      }
      walkInterfaces(addTo, iface);
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ClassUtils.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */