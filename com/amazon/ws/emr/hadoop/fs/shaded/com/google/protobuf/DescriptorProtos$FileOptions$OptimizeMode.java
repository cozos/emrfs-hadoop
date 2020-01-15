package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$FileOptions$OptimizeMode
  implements ProtocolMessageEnum
{
  SPEED(0, 1),  CODE_SIZE(1, 2),  LITE_RUNTIME(2, 3);
  
  public static final int SPEED_VALUE = 1;
  public static final int CODE_SIZE_VALUE = 2;
  public static final int LITE_RUNTIME_VALUE = 3;
  
  public final int getNumber()
  {
    return value;
  }
  
  public static OptimizeMode valueOf(int value)
  {
    switch (value)
    {
    case 1: 
      return SPEED;
    case 2: 
      return CODE_SIZE;
    case 3: 
      return LITE_RUNTIME;
    }
    return null;
  }
  
  public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  private static Internal.EnumLiteMap<OptimizeMode> internalValueMap = new Internal.EnumLiteMap()
  {
    public DescriptorProtos.FileOptions.OptimizeMode findValueByNumber(int number)
    {
      return DescriptorProtos.FileOptions.OptimizeMode.valueOf(number);
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
    return (Descriptors.EnumDescriptor)DescriptorProtos.FileOptions.getDescriptor().getEnumTypes().get(0);
  }
  
  private static final OptimizeMode[] VALUES = values();
  private final int index;
  private final int value;
  
  public static OptimizeMode valueOf(Descriptors.EnumValueDescriptor desc)
  {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }
  
  private DescriptorProtos$FileOptions$OptimizeMode(int index, int value)
  {
    this.index = index;
    this.value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FileOptions.OptimizeMode
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */