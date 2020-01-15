package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class InjectionPoint$OverrideIndex
{
  final InjectionPoint.InjectableMembers injectableMembers;
  Map<InjectionPoint.Signature, List<InjectionPoint.InjectableMethod>> bySignature;
  InjectionPoint.Position position = InjectionPoint.Position.TOP;
  Method lastMethod;
  InjectionPoint.Signature lastSignature;
  
  InjectionPoint$OverrideIndex(InjectionPoint.InjectableMembers injectableMembers)
  {
    this.injectableMembers = injectableMembers;
  }
  
  boolean removeIfOverriddenBy(Method method, boolean alwaysRemove, InjectionPoint.InjectableMethod injectableMethod)
  {
    if (position == InjectionPoint.Position.TOP) {
      return false;
    }
    if (bySignature == null)
    {
      bySignature = new HashMap();
      for (InjectionPoint.InjectableMember member = injectableMembers.head; member != null; member = next) {
        if ((member instanceof InjectionPoint.InjectableMethod))
        {
          InjectionPoint.InjectableMethod im = (InjectionPoint.InjectableMethod)member;
          if (!im.isFinal())
          {
            List<InjectionPoint.InjectableMethod> methods = new ArrayList();
            methods.add(im);
            bySignature.put(new InjectionPoint.Signature(method), methods);
          }
        }
      }
    }
    lastMethod = method;
    InjectionPoint.Signature signature = lastSignature = new InjectionPoint.Signature(method);
    List<InjectionPoint.InjectableMethod> methods = (List)bySignature.get(signature);
    boolean removed = false;
    if (methods != null)
    {
      Iterator<InjectionPoint.InjectableMethod> iterator = methods.iterator();
      while (iterator.hasNext())
      {
        InjectionPoint.InjectableMethod possiblyOverridden = (InjectionPoint.InjectableMethod)iterator.next();
        if (InjectionPoint.access$000(method, method))
        {
          boolean wasGuiceInject = (!jsr330) || (overrodeGuiceInject);
          if (injectableMethod != null) {
            overrodeGuiceInject = wasGuiceInject;
          }
          if ((alwaysRemove) || (!wasGuiceInject))
          {
            removed = true;
            iterator.remove();
            injectableMembers.remove(possiblyOverridden);
          }
        }
      }
    }
    return removed;
  }
  
  void add(InjectionPoint.InjectableMethod injectableMethod)
  {
    injectableMembers.add(injectableMethod);
    if ((position == InjectionPoint.Position.BOTTOM) || (injectableMethod.isFinal())) {
      return;
    }
    if (bySignature != null)
    {
      InjectionPoint.Signature signature = method == lastMethod ? lastSignature : new InjectionPoint.Signature(method);
      
      List<InjectionPoint.InjectableMethod> methods = (List)bySignature.get(signature);
      if (methods == null)
      {
        methods = new ArrayList();
        bySignature.put(signature, methods);
      }
      methods.add(injectableMethod);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint.OverrideIndex
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */