package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface Multiset<E>
  extends Collection<E>
{
  public abstract int count(@Nullable Object paramObject);
  
  public abstract int add(@Nullable E paramE, int paramInt);
  
  public abstract int remove(@Nullable Object paramObject, int paramInt);
  
  public abstract int setCount(E paramE, int paramInt);
  
  public abstract boolean setCount(E paramE, int paramInt1, int paramInt2);
  
  public abstract Set<E> elementSet();
  
  public abstract Set<Entry<E>> entrySet();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract String toString();
  
  public abstract Iterator<E> iterator();
  
  public abstract boolean contains(@Nullable Object paramObject);
  
  public abstract boolean containsAll(Collection<?> paramCollection);
  
  public abstract boolean add(E paramE);
  
  public abstract boolean remove(@Nullable Object paramObject);
  
  public abstract boolean removeAll(Collection<?> paramCollection);
  
  public abstract boolean retainAll(Collection<?> paramCollection);
  
  public static abstract interface Entry<E>
  {
    public abstract E getElement();
    
    public abstract int getCount();
    
    public abstract boolean equals(Object paramObject);
    
    public abstract int hashCode();
    
    public abstract String toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */