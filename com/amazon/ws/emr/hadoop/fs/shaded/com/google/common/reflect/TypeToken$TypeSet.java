package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FluentIterable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.io.Serializable;
import java.util.Set;

public class TypeToken$TypeSet
  extends ForwardingSet<TypeToken<? super T>>
  implements Serializable
{
  private transient ImmutableSet<TypeToken<? super T>> types;
  private static final long serialVersionUID = 0L;
  
  TypeToken$TypeSet(TypeToken paramTypeToken) {}
  
  public TypeToken<T>.TypeSet interfaces()
  {
    return new TypeToken.InterfaceSet(this$0, this);
  }
  
  public TypeToken<T>.TypeSet classes()
  {
    return new TypeToken.ClassSet(this$0, null);
  }
  
  protected Set<TypeToken<? super T>> delegate()
  {
    ImmutableSet<TypeToken<? super T>> filteredTypes = types;
    if (filteredTypes == null)
    {
      ImmutableList<TypeToken<? super T>> collectedTypes = TypeToken.TypeCollector.FOR_GENERIC_TYPE.collectTypes(this$0);
      
      return types = FluentIterable.from(collectedTypes).filter(TypeToken.TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
    }
    return filteredTypes;
  }
  
  public Set<Class<? super T>> rawTypes()
  {
    ImmutableList<Class<? super T>> collectedTypes = TypeToken.TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.access$200(this$0));
    
    return ImmutableSet.copyOf(collectedTypes);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */