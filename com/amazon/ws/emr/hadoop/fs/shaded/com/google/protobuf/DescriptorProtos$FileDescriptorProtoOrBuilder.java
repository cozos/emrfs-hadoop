package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;

public abstract interface DescriptorProtos$FileDescriptorProtoOrBuilder
  extends MessageOrBuilder
{
  public abstract boolean hasName();
  
  public abstract String getName();
  
  public abstract ByteString getNameBytes();
  
  public abstract boolean hasPackage();
  
  public abstract String getPackage();
  
  public abstract ByteString getPackageBytes();
  
  public abstract List<String> getDependencyList();
  
  public abstract int getDependencyCount();
  
  public abstract String getDependency(int paramInt);
  
  public abstract ByteString getDependencyBytes(int paramInt);
  
  public abstract List<Integer> getPublicDependencyList();
  
  public abstract int getPublicDependencyCount();
  
  public abstract int getPublicDependency(int paramInt);
  
  public abstract List<Integer> getWeakDependencyList();
  
  public abstract int getWeakDependencyCount();
  
  public abstract int getWeakDependency(int paramInt);
  
  public abstract List<DescriptorProtos.DescriptorProto> getMessageTypeList();
  
  public abstract DescriptorProtos.DescriptorProto getMessageType(int paramInt);
  
  public abstract int getMessageTypeCount();
  
  public abstract List<? extends DescriptorProtos.DescriptorProtoOrBuilder> getMessageTypeOrBuilderList();
  
  public abstract DescriptorProtos.DescriptorProtoOrBuilder getMessageTypeOrBuilder(int paramInt);
  
  public abstract List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList();
  
  public abstract DescriptorProtos.EnumDescriptorProto getEnumType(int paramInt);
  
  public abstract int getEnumTypeCount();
  
  public abstract List<? extends DescriptorProtos.EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList();
  
  public abstract DescriptorProtos.EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int paramInt);
  
  public abstract List<DescriptorProtos.ServiceDescriptorProto> getServiceList();
  
  public abstract DescriptorProtos.ServiceDescriptorProto getService(int paramInt);
  
  public abstract int getServiceCount();
  
  public abstract List<? extends DescriptorProtos.ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList();
  
  public abstract DescriptorProtos.ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int paramInt);
  
  public abstract List<DescriptorProtos.FieldDescriptorProto> getExtensionList();
  
  public abstract DescriptorProtos.FieldDescriptorProto getExtension(int paramInt);
  
  public abstract int getExtensionCount();
  
  public abstract List<? extends DescriptorProtos.FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList();
  
  public abstract DescriptorProtos.FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int paramInt);
  
  public abstract boolean hasOptions();
  
  public abstract DescriptorProtos.FileOptions getOptions();
  
  public abstract DescriptorProtos.FileOptionsOrBuilder getOptionsOrBuilder();
  
  public abstract boolean hasSourceCodeInfo();
  
  public abstract DescriptorProtos.SourceCodeInfo getSourceCodeInfo();
  
  public abstract DescriptorProtos.SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */