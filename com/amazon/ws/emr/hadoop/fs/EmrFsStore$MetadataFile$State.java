package com.amazon.ws.emr.hadoop.fs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.Descriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.EnumDescriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Internal.EnumLiteMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum EmrFsStore$MetadataFile$State
  implements ProtocolMessageEnum
{
  DISCOVERED(0, 0),  PUT(1, 1),  DELETED(2, 2);
  
  public static final int DISCOVERED_VALUE = 0;
  public static final int PUT_VALUE = 1;
  public static final int DELETED_VALUE = 2;
  
  public final int getNumber()
  {
    return value;
  }
  
  public static State valueOf(int value)
  {
    switch (value)
    {
    case 0: 
      return DISCOVERED;
    case 1: 
      return PUT;
    case 2: 
      return DELETED;
    }
    return null;
  }
  
  public static Internal.EnumLiteMap<State> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  private static Internal.EnumLiteMap<State> internalValueMap = new Internal.EnumLiteMap()
  {
    public EmrFsStore.MetadataFile.State findValueByNumber(int number)
    {
      return EmrFsStore.MetadataFile.State.valueOf(number);
    }
  };
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(index);
  }
  
  public final Descriptors.EnumDescriptor getDescriptorForType()
  {
    return getDescriptor();
  }
  
  public static final Descriptors.EnumDescriptor getDescriptor()
  {
    return (Descriptors.EnumDescriptor)EmrFsStore.MetadataFile.getDescriptor().getEnumTypes().get(0);
  }
  
  private static final State[] VALUES = values();
  private final int index;
  private final int value;
  
  public static State valueOf(Descriptors.EnumValueDescriptor desc)
  {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }
  
  private EmrFsStore$MetadataFile$State(int index, int value)
  {
    this.index = index;
    this.value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFsStore.MetadataFile.State
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */