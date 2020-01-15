package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.List;

class CartesianList$1
  extends ImmutableList<E>
{
  CartesianList$1(CartesianList paramCartesianList, int paramInt) {}
  
  public int size()
  {
    return CartesianList.access$000(this$0).size();
  }
  
  public E get(int axis)
  {
    Preconditions.checkElementIndex(axis, size());
    int axisIndex = CartesianList.access$100(this$0, val$index, axis);
    return (E)((List)CartesianList.access$000(this$0).get(axis)).get(axisIndex);
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.CartesianList.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */