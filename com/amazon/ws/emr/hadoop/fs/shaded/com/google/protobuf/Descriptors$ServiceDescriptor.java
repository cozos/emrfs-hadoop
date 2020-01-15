package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Descriptors$ServiceDescriptor
  implements Descriptors.GenericDescriptor
{
  private final int index;
  private DescriptorProtos.ServiceDescriptorProto proto;
  private final String fullName;
  private final Descriptors.FileDescriptor file;
  private Descriptors.MethodDescriptor[] methods;
  
  public int getIndex()
  {
    return index;
  }
  
  public DescriptorProtos.ServiceDescriptorProto toProto()
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
  
  public DescriptorProtos.ServiceOptions getOptions()
  {
    return proto.getOptions();
  }
  
  public List<Descriptors.MethodDescriptor> getMethods()
  {
    return Collections.unmodifiableList(Arrays.asList(methods));
  }
  
  public Descriptors.MethodDescriptor findMethodByName(String name)
  {
    Descriptors.GenericDescriptor result = Descriptors.FileDescriptor.access$1200(file).findSymbol(fullName + '.' + name);
    if ((result != null) && ((result instanceof Descriptors.MethodDescriptor))) {
      return (Descriptors.MethodDescriptor)result;
    }
    return null;
  }
  
  private Descriptors$ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto proto, Descriptors.FileDescriptor file, int index)
    throws Descriptors.DescriptorValidationException
  {
    this.index = index;
    this.proto = proto;
    fullName = Descriptors.access$1400(file, null, proto.getName());
    this.file = file;
    
    methods = new Descriptors.MethodDescriptor[proto.getMethodCount()];
    for (int i = 0; i < proto.getMethodCount(); i++) {
      methods[i] = new Descriptors.MethodDescriptor(proto.getMethod(i), file, this, i, null);
    }
    Descriptors.FileDescriptor.access$1200(file).addSymbol(this);
  }
  
  private void crossLink()
    throws Descriptors.DescriptorValidationException
  {
    for (Descriptors.MethodDescriptor method : methods) {
      Descriptors.MethodDescriptor.access$2200(method);
    }
  }
  
  private void setProto(DescriptorProtos.ServiceDescriptorProto proto)
  {
    this.proto = proto;
    for (int i = 0; i < methods.length; i++) {
      Descriptors.MethodDescriptor.access$2300(methods[i], proto.getMethod(i));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.ServiceDescriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */