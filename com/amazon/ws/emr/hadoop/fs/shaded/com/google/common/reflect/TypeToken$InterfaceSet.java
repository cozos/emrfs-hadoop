package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FluentIterable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.util.Set;

final class TypeToken$InterfaceSet
  extends TypeToken<T>.TypeSet
{
  private final transient TypeToken<T>.TypeSet allTypes;
  private transient ImmutableSet<TypeToken<? super T>> interfaces;
  private static final long serialVersionUID = 0L;
  
  TypeToken$InterfaceSet(TypeToken<T>.TypeSet arg1)
  {
    super(???);
    this.allTypes = allTypes;
  }
  
  protected Set<TypeToken<? super T>> delegate()
  {
    ImmutableSet<TypeToken<? super T>> result = interfaces;
    if (result == null) {
      return interfaces = FluentIterable.from(allTypes).filter(TypeToken.TypeFilter.INTERFACE_ONLY).toSet();
    }
    return result;
  }
  
  public TypeToken<T>.TypeSet interfaces()
  {
    return this;
  }
  
  public Set<Class<? super T>> rawTypes()
  {
    ImmutableList<Class<? super T>> collectedTypes = TypeToken.TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.access$200(this$0));
    
    FluentIterable.from(collectedTypes).filter(new Predicate()
    {
      public boolean apply(Class<?> type)
      {
        return type.isInterface();
      }
    }).toSet();
  }
  
  public TypeToken<T>.TypeSet classes()
  {
    throw new UnsupportedOperationException("interfaces().classes() not supported.");
  }
  
  private Object readResolve()
  {
    return this$0.getTypes().interfaces();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.InterfaceSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */