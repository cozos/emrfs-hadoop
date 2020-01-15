package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

final class GeneratedMessageLite$ExtensionDescriptor
  implements FieldSet.FieldDescriptorLite<ExtensionDescriptor>
{
  private final Internal.EnumLiteMap<?> enumTypeMap;
  private final int number;
  private final WireFormat.FieldType type;
  private final boolean isRepeated;
  private final boolean isPacked;
  
  private GeneratedMessageLite$ExtensionDescriptor(Internal.EnumLiteMap<?> enumTypeMap, int number, WireFormat.FieldType type, boolean isRepeated, boolean isPacked)
  {
    this.enumTypeMap = enumTypeMap;
    this.number = number;
    this.type = type;
    this.isRepeated = isRepeated;
    this.isPacked = isPacked;
  }
  
  public int getNumber()
  {
    return number;
  }
  
  public WireFormat.FieldType getLiteType()
  {
    return type;
  }
  
  public WireFormat.JavaType getLiteJavaType()
  {
    return type.getJavaType();
  }
  
  public boolean isRepeated()
  {
    return isRepeated;
  }
  
  public boolean isPacked()
  {
    return isPacked;
  }
  
  public Internal.EnumLiteMap<?> getEnumType()
  {
    return enumTypeMap;
  }
  
  public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from)
  {
    return ((GeneratedMessageLite.Builder)to).mergeFrom((GeneratedMessageLite)from);
  }
  
  public int compareTo(ExtensionDescriptor other)
  {
    return number - number;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */