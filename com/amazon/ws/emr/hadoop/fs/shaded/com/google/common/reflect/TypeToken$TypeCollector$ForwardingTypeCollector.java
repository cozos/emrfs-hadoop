package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

class TypeToken$TypeCollector$ForwardingTypeCollector<K>
  extends TypeToken.TypeCollector<K>
{
  private final TypeToken.TypeCollector<K> delegate;
  
  TypeToken$TypeCollector$ForwardingTypeCollector(TypeToken.TypeCollector<K> delegate)
  {
    super(null);
    this.delegate = delegate;
  }
  
  Class<?> getRawType(K type)
  {
    return delegate.getRawType(type);
  }
  
  Iterable<? extends K> getInterfaces(K type)
  {
    return delegate.getInterfaces(type);
  }
  
  K getSuperclass(K type)
  {
    return (K)delegate.getSuperclass(type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeCollector.ForwardingTypeCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */