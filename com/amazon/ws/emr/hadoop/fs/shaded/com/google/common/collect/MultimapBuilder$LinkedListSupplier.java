package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.LinkedList;
import java.util.List;

 enum MultimapBuilder$LinkedListSupplier
  implements Supplier<List<Object>>
{
  INSTANCE;
  
  private MultimapBuilder$LinkedListSupplier() {}
  
  public static <V> Supplier<List<V>> instance()
  {
    Supplier<List<V>> result = INSTANCE;
    return result;
  }
  
  public List<Object> get()
  {
    return new LinkedList();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.LinkedListSupplier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */