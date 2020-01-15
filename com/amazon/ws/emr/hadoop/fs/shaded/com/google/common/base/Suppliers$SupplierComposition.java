package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

class Suppliers$SupplierComposition<F, T>
  implements Supplier<T>, Serializable
{
  final Function<? super F, T> function;
  final Supplier<F> supplier;
  private static final long serialVersionUID = 0L;
  
  Suppliers$SupplierComposition(Function<? super F, T> function, Supplier<F> supplier)
  {
    this.function = function;
    this.supplier = supplier;
  }
  
  public T get()
  {
    return (T)function.apply(supplier.get());
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof SupplierComposition))
    {
      SupplierComposition<?, ?> that = (SupplierComposition)obj;
      return (function.equals(function)) && (supplier.equals(supplier));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { function, supplier });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(function));String str2 = String.valueOf(String.valueOf(supplier));return 21 + str1.length() + str2.length() + "Suppliers.compose(" + str1 + ", " + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Suppliers.SupplierComposition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */