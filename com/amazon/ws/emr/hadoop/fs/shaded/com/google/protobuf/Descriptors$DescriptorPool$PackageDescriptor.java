package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

final class Descriptors$DescriptorPool$PackageDescriptor
  implements Descriptors.GenericDescriptor
{
  private final String name;
  private final String fullName;
  private final Descriptors.FileDescriptor file;
  
  public Message toProto()
  {
    return file.toProto();
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getFullName()
  {
    return fullName;
  }
  
  public Descriptors.FileDescriptor getFile()
  {
    return file;
  }
  
  Descriptors$DescriptorPool$PackageDescriptor(String name, String fullName, Descriptors.FileDescriptor file)
  {
    this.file = file;
    this.fullName = fullName;
    this.name = name;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.DescriptorPool.PackageDescriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */