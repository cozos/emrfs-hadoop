package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Suppliers$SupplierOfInstance<T>
  implements Supplier<T>, Serializable
{
  final T instance;
  private static final long serialVersionUID = 0L;
  
  Suppliers$SupplierOfInstance(@Nullable T instance)
  {
    this.instance = instance;
  }
  
  public T get()
  {
    return (T)instance;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof SupplierOfInstance))
    {
      SupplierOfInstance<?> that = (SupplierOfInstance)obj;
      return Objects.equal(instance, instance);
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { instance });
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(instance));return 22 + str.length() + "Suppliers.ofInstance(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Suppliers.SupplierOfInstance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */