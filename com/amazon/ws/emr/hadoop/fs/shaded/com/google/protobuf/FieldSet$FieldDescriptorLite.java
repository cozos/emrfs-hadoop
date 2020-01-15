package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public abstract interface FieldSet$FieldDescriptorLite<T extends FieldDescriptorLite<T>>
  extends Comparable<T>
{
  public abstract int getNumber();
  
  public abstract WireFormat.FieldType getLiteType();
  
  public abstract WireFormat.JavaType getLiteJavaType();
  
  public abstract boolean isRepeated();
  
  public abstract boolean isPacked();
  
  public abstract Internal.EnumLiteMap<?> getEnumType();
  
  public abstract MessageLite.Builder internalMergeFrom(MessageLite.Builder paramBuilder, MessageLite paramMessageLite);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.FieldSet.FieldDescriptorLite
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */