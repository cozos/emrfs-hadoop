package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public abstract interface DescriptorProtos$ServiceDescriptorProtoOrBuilder
  extends MessageOrBuilder
{
  public abstract boolean hasName();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract List<DescriptorProtos.MethodDescriptorProto> getMethodList();
  
  public abstract DescriptorProtos.MethodDescriptorProto getMethod(int paramInt);
  
  public abstract int getMethodCount();
  
  public abstract List<? extends DescriptorProtos.MethodDescriptorProtoOrBuilder> getMethodOrBuilderList();
  
  public abstract DescriptorProtos.MethodDescriptorProtoOrBuilder getMethodOrBuilder(int paramInt);
  
  public abstract boolean hasOptions();
  
  public abstract DescriptorProtos.ServiceOptions getOptions();
  
  public abstract DescriptorProtos.ServiceOptionsOrBuilder getOptionsOrBuilder();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */