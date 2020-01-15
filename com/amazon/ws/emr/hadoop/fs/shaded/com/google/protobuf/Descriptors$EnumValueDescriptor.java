package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public final class Descriptors$EnumValueDescriptor
  implements Descriptors.GenericDescriptor, Internal.EnumLite
{
  private final int index;
  private DescriptorProtos.EnumValueDescriptorProto proto;
  private final String fullName;
  private final Descriptors.FileDescriptor file;
  private final Descriptors.EnumDescriptor type;
  
  public int getIndex()
  {
    return index;
  }
  
  public DescriptorProtos.EnumValueDescriptorProto toProto()
  {
    return proto;
  }
  
  public String getName()
  {
    return proto.getName();
  }
  
  public int getNumber()
  {
    return proto.getNumber();
  }
  
  public String getFullName()
  {
    return fullName;
  }
  
  public Descriptors.FileDescriptor getFile()
  {
    return file;
  }
  
  public Descriptors.EnumDescriptor getType()
  {
    return type;
  }
  
  public DescriptorProtos.EnumValueOptions getOptions()
  {
    return proto.getOptions();
  }
  
  private Descriptors$EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto proto, Descriptors.FileDescriptor file, Descriptors.EnumDescriptor parent, int index)
    throws Descriptors.DescriptorValidationException
  {
    this.index = index;
    this.proto = proto;
    this.file = file;
    type = parent;
    
    fullName = (parent.getFullName() + '.' + proto.getName());
    
    Descriptors.FileDescriptor.access$1200(file).addSymbol(this);
    Descriptors.FileDescriptor.access$1200(file).addEnumValueByNumber(this);
  }
  
  private void setProto(DescriptorProtos.EnumValueDescriptorProto proto)
  {
    this.proto = proto;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.EnumValueDescriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */