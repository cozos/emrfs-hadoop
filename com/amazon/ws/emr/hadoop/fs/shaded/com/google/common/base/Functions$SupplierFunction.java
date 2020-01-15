package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$SupplierFunction<T>
  implements Function<Object, T>, Serializable
{
  private final Supplier<T> supplier;
  private static final long serialVersionUID = 0L;
  
  private Functions$SupplierFunction(Supplier<T> supplier)
  {
    this.supplier = ((Supplier)Preconditions.checkNotNull(supplier));
  }
  
  public T apply(@Nullable Object input)
  {
    return (T)supplier.get();
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof SupplierFunction))
    {
      SupplierFunction<?> that = (SupplierFunction)obj;
      return supplier.equals(supplier);
    }
    return false;
  }
  
  public int hashCode()
  {
    return supplier.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(supplier));return 13 + str.length() + "forSupplier(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Functions.SupplierFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */