package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public final class Descriptors$MethodDescriptor
  implements Descriptors.GenericDescriptor
{
  private final int index;
  private DescriptorProtos.MethodDescriptorProto proto;
  private final String fullName;
  private final Descriptors.FileDescriptor file;
  private final Descriptors.ServiceDescriptor service;
  private Descriptors.Descriptor inputType;
  private Descriptors.Descriptor outputType;
  
  public int getIndex()
  {
    return index;
  }
  
  public DescriptorProtos.MethodDescriptorProto toProto()
  {
    return proto;
  }
  
  public String getName()
  {
    return proto.getName();
  }
  
  public String getFullName()
  {
    return fullName;
  }
  
  public Descriptors.FileDescriptor getFile()
  {
    return file;
  }
  
  public Descriptors.ServiceDescriptor getService()
  {
    return service;
  }
  
  public Descriptors.Descriptor getInputType()
  {
    return inputType;
  }
  
  public Descriptors.Descriptor getOutputType()
  {
    return outputType;
  }
  
  public DescriptorProtos.MethodOptions getOptions()
  {
    return proto.getOptions();
  }
  
  private Descriptors$MethodDescriptor(DescriptorProtos.MethodDescriptorProto proto, Descriptors.FileDescriptor file, Descriptors.ServiceDescriptor parent, int index)
    throws Descriptors.DescriptorValidationException
  {
    this.index = index;
    this.proto = proto;
    this.file = file;
    service = parent;
    
    fullName = (parent.getFullName() + '.' + proto.getName());
    
    Descriptors.FileDescriptor.access$1200(file).addSymbol(this);
  }
  
  private void crossLink()
    throws Descriptors.DescriptorValidationException
  {
    Descriptors.GenericDescriptor input = Descriptors.FileDescriptor.access$1200(file).lookupSymbol(proto.getInputType(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
    if (!(input instanceof Descriptors.Descriptor)) {
      throw new Descriptors.DescriptorValidationException(this, '"' + proto.getInputType() + "\" is not a message type.", null);
    }
    inputType = ((Descriptors.Descriptor)input);
    
    Descriptors.GenericDescriptor output = Descriptors.FileDescriptor.access$1200(file).lookupSymbol(proto.getOutputType(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
    if (!(output instanceof Descriptors.Descriptor)) {
      throw new Descriptors.DescriptorValidationException(this, '"' + proto.getOutputType() + "\" is not a message type.", null);
    }
    outputType = ((Descriptors.Descriptor)output);
  }
  
  private void setProto(DescriptorProtos.MethodDescriptorProto proto)
  {
    this.proto = proto;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.MethodDescriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */