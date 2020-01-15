package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.AbstractList;
import java.util.List;

class RepeatedFieldBuilder$MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder>
  extends AbstractList<IType>
  implements List<IType>
{
  RepeatedFieldBuilder<MType, BType, IType> builder;
  
  RepeatedFieldBuilder$MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> builder)
  {
    this.builder = builder;
  }
  
  public int size()
  {
    return builder.getCount();
  }
  
  public IType get(int index)
  {
    return builder.getMessageOrBuilder(index);
  }
  
  void incrementModCount()
  {
    modCount += 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RepeatedFieldBuilder.MessageOrBuilderExternalList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */