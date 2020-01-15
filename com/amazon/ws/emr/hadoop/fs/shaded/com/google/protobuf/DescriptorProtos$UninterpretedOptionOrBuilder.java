package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public abstract interface DescriptorProtos$UninterpretedOptionOrBuilder
  extends MessageOrBuilder
{
  public abstract List<DescriptorProtos.UninterpretedOption.NamePart> getNameList();
  
  public abstract DescriptorProtos.UninterpretedOption.NamePart getName(int paramInt);
  
  public abstract int getNameCount();
  
  public abstract List<? extends DescriptorProtos.UninterpretedOption.NamePartOrBuilder> getNameOrBuilderList();
  
  public abstract DescriptorProtos.UninterpretedOption.NamePartOrBuilder getNameOrBuilder(int paramInt);
  
  public abstract boolean hasIdentifierValue();
  
  public abstract String getIdentifierValue();
  
  public abstract ByteString getIdentifierValueBytes();
  
  public abstract boolean hasPositiveIntValue();
  
  public abstract long getPositiveIntValue();
  
  public abstract boolean hasNegativeIntValue();
  
  public abstract long getNegativeIntValue();
  
  public abstract boolean hasDoubleValue();
  
  public abstract double getDoubleValue();
  
  public abstract boolean hasStringValue();
  
  public abstract ByteString getStringValue();
  
  public abstract boolean hasAggregateValue();
  
  public abstract String getAggregateValue();
  
  public abstract ByteString getAggregateValueBytes();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */