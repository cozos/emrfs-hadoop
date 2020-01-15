package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

final class ClassUtils$2
  implements Iterable<Class<?>>
{
  ClassUtils$2(Iterable paramIterable) {}
  
  public Iterator<Class<?>> iterator()
  {
    final Set<Class<?>> seenInterfaces = new HashSet();
    final Iterator<Class<?>> wrapped = val$classes.iterator();
    
    new Iterator()
    {
      Iterator<Class<?>> interfaces = Collections.emptySet().iterator();
      
      public boolean hasNext()
      {
        return (interfaces.hasNext()) || (wrapped.hasNext());
      }
      
      public Class<?> next()
      {
        if (interfaces.hasNext())
        {
          Class<?> nextInterface = (Class)interfaces.next();
          seenInterfaces.add(nextInterface);
          return nextInterface;
        }
        Class<?> nextSuperclass = (Class)wrapped.next();
        Set<Class<?>> currentInterfaces = new LinkedHashSet();
        walkInterfaces(currentInterfaces, nextSuperclass);
        interfaces = currentInterfaces.iterator();
        return nextSuperclass;
      }
      
      private void walkInterfaces(Set<Class<?>> addTo, Class<?> c)
      {
        for (Class<?> iface : c.getInterfaces())
        {
          if (!seenInterfaces.contains(iface)) {
            addTo.add(iface);
          }
          walkInterfaces(addTo, iface);
        }
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ClassUtils.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */