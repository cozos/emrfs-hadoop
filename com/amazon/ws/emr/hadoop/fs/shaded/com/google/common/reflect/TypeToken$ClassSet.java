package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FluentIterable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.util.Set;

final class TypeToken$ClassSet
  extends TypeToken<T>.TypeSet
{
  private transient ImmutableSet<TypeToken<? super T>> classes;
  private static final long serialVersionUID = 0L;
  
  private TypeToken$ClassSet(TypeToken paramTypeToken)
  {
    super(paramTypeToken);
  }
  
  protected Set<TypeToken<? super T>> delegate()
  {
    ImmutableSet<TypeToken<? super T>> result = classes;
    if (result == null)
    {
      ImmutableList<TypeToken<? super T>> collectedTypes = TypeToken.TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(this$0);
      
      return classes = FluentIterable.from(collectedTypes).filter(TypeToken.TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
    }
    return result;
  }
  
  public TypeToken<T>.TypeSet classes()
  {
    return this;
  }
  
  public Set<Class<? super T>> rawTypes()
  {
    ImmutableList<Class<? super T>> collectedTypes = TypeToken.TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes(TypeToken.access$200(this$0));
    
    return ImmutableSet.copyOf(collectedTypes);
  }
  
  public TypeToken<T>.TypeSet interfaces()
  {
    throw new UnsupportedOperationException("classes().interfaces() not supported.");
  }
  
  private Object readResolve()
  {
    return this$0.getTypes().classes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.ClassSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */