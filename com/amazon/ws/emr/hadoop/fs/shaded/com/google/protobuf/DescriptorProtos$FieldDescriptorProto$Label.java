package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$FieldDescriptorProto$Label
  implements ProtocolMessageEnum
{
  LABEL_OPTIONAL(0, 1),  LABEL_REQUIRED(1, 2),  LABEL_REPEATED(2, 3);
  
  public static final int LABEL_OPTIONAL_VALUE = 1;
  public static final int LABEL_REQUIRED_VALUE = 2;
  public static final int LABEL_REPEATED_VALUE = 3;
  
  public final int getNumber()
  {
    return value;
  }
  
  public static Label valueOf(int value)
  {
    switch (value)
    {
    case 1: 
      return LABEL_OPTIONAL;
    case 2: 
      return LABEL_REQUIRED;
    case 3: 
      return LABEL_REPEATED;
    }
    return null;
  }
  
  public static Internal.EnumLiteMap<Label> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  private static Internal.EnumLiteMap<Label> internalValueMap = new Internal.EnumLiteMap()
  {
    public DescriptorProtos.FieldDescriptorProto.Label findValueByNumber(int number)
    {
      return DescriptorProtos.FieldDescriptorProto.Label.valueOf(number);
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
    return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
  }
  
  private static final Label[] VALUES = values();
  private final int index;
  private final int value;
  
  public static Label valueOf(Descriptors.EnumValueDescriptor desc)
  {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }
  
  private DescriptorProtos$FieldDescriptorProto$Label(int index, int value)
  {
    this.index = index;
    this.value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */