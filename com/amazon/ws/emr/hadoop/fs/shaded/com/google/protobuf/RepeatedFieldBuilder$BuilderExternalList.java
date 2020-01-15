package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
  extends AbstractList<BType>
  implements List<BType>
{
  RepeatedFieldBuilder<MType, BType, IType> builder;
  
  RepeatedFieldBuilder$BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> builder)
  {
    this.builder = builder;
  }
  
  public int size()
  {
    return builder.getCount();
  }
  
  public BType get(int index)
  {
    return builder.getBuilder(index);
  }
  
  void incrementModCount()
  {
    modCount += 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RepeatedFieldBuilder.BuilderExternalList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */