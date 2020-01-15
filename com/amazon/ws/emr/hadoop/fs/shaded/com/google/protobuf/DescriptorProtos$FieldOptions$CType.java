package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public enum DescriptorProtos$FieldOptions$CType
  implements ProtocolMessageEnum
{
  STRING(0, 0),  CORD(1, 1),  STRING_PIECE(2, 2);
  
  public static final int STRING_VALUE = 0;
  public static final int CORD_VALUE = 1;
  public static final int STRING_PIECE_VALUE = 2;
  
  public final int getNumber()
  {
    return value;
  }
  
  public static CType valueOf(int value)
  {
    switch (value)
    {
    case 0: 
      return STRING;
    case 1: 
      return CORD;
    case 2: 
      return STRING_PIECE;
    }
    return null;
  }
  
  public static Internal.EnumLiteMap<CType> internalGetValueMap()
  {
    return internalValueMap;
  }
  
  private static Internal.EnumLiteMap<CType> internalValueMap = new Internal.EnumLiteMap()
  {
    public DescriptorProtos.FieldOptions.CType findValueByNumber(int number)
    {
      return DescriptorProtos.FieldOptions.CType.valueOf(number);
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
    return (Descriptors.EnumDescriptor)DescriptorProtos.FieldOptions.getDescriptor().getEnumTypes().get(0);
  }
  
  private static final CType[] VALUES = values();
  private final int index;
  private final int value;
  
  public static CType valueOf(Descriptors.EnumValueDescriptor desc)
  {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }
  
  private DescriptorProtos$FieldOptions$CType(int index, int value)
  {
    this.index = index;
    this.value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FieldOptions.CType
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */