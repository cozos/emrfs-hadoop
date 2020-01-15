package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
  extends AbstractList<MType>
  implements List<MType>
{
  RepeatedFieldBuilder<MType, BType, IType> builder;
  
  RepeatedFieldBuilder$MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> builder)
  {
    this.builder = builder;
  }
  
  public int size()
  {
    return builder.getCount();
  }
  
  public MType get(int index)
  {
    return builder.getMessage(index);
  }
  
  void incrementModCount()
  {
    modCount += 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RepeatedFieldBuilder.MessageExternalList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */