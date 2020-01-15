package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Descriptors$FileDescriptor
{
  private DescriptorProtos.FileDescriptorProto proto;
  private final Descriptors.Descriptor[] messageTypes;
  private final Descriptors.EnumDescriptor[] enumTypes;
  private final Descriptors.ServiceDescriptor[] services;
  private final Descriptors.FieldDescriptor[] extensions;
  private final FileDescriptor[] dependencies;
  private final FileDescriptor[] publicDependencies;
  private final Descriptors.DescriptorPool pool;
  
  public DescriptorProtos.FileDescriptorProto toProto()
  {
    return proto;
  }
  
  public String getName()
  {
    return proto.getName();
  }
  
  public String getPackage()
  {
    return proto.getPackage();
  }
  
  public DescriptorProtos.FileOptions getOptions()
  {
    return proto.getOptions();
  }
  
  public List<Descriptors.Descriptor> getMessageTypes()
  {
    return Collections.unmodifiableList(Arrays.asList(messageTypes));
  }
  
  public List<Descriptors.EnumDescriptor> getEnumTypes()
  {
    return Collections.unmodifiableList(Arrays.asList(enumTypes));
  }
  
  public List<Descriptors.ServiceDescriptor> getServices()
  {
    return Collections.unmodifiableList(Arrays.asList(services));
  }
  
  public List<Descriptors.FieldDescriptor> getExtensions()
  {
    return Collections.unmodifiableList(Arrays.asList(extensions));
  }
  
  public List<FileDescriptor> getDependencies()
  {
    return Collections.unmodifiableList(Arrays.asList(dependencies));
  }
  
  public List<FileDescriptor> getPublicDependencies()
  {
    return Collections.unmodifiableList(Arrays.asList(publicDependencies));
  }
  
  public Descriptors.Descriptor findMessageTypeByName(String name)
  {
    if (name.indexOf('.') != -1) {
      return null;
    }
    if (getPackage().length() > 0) {
      name = getPackage() + '.' + name;
    }
    Descriptors.GenericDescriptor result = pool.findSymbol(name);
    if ((result != null) && ((result instanceof Descriptors.Descriptor)) && (result.getFile() == this)) {
      return (Descriptors.Descriptor)result;
    }
    return null;
  }
  
  public Descriptors.EnumDescriptor findEnumTypeByName(String name)
  {
    if (name.indexOf('.') != -1) {
      return null;
    }
    if (getPackage().length() > 0) {
      name = getPackage() + '.' + name;
    }
    Descriptors.GenericDescriptor result = pool.findSymbol(name);
    if ((result != null) && ((result instanceof Descriptors.EnumDescriptor)) && (result.getFile() == this)) {
      return (Descriptors.EnumDescriptor)result;
    }
    return null;
  }
  
  public Descriptors.ServiceDescriptor findServiceByName(String name)
  {
    if (name.indexOf('.') != -1) {
      return null;
    }
    if (getPackage().length() > 0) {
      name = getPackage() + '.' + name;
    }
    Descriptors.GenericDescriptor result = pool.findSymbol(name);
    if ((result != null) && ((result instanceof Descriptors.ServiceDescriptor)) && (result.getFile() == this)) {
      return (Descriptors.ServiceDescriptor)result;
    }
    return null;
  }
  
  public Descriptors.FieldDescriptor findExtensionByName(String name)
  {
    if (name.indexOf('.') != -1) {
      return null;
    }
    if (getPackage().length() > 0) {
      name = getPackage() + '.' + name;
    }
    Descriptors.GenericDescriptor result = pool.findSymbol(name);
    if ((result != null) && ((result instanceof Descriptors.FieldDescriptor)) && (result.getFile() == this)) {
      return (Descriptors.FieldDescriptor)result;
    }
    return null;
  }
  
  public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto proto, FileDescriptor[] dependencies)
    throws Descriptors.DescriptorValidationException
  {
    Descriptors.DescriptorPool pool = new Descriptors.DescriptorPool(dependencies);
    FileDescriptor result = new FileDescriptor(proto, dependencies, pool);
    if (dependencies.length != proto.getDependencyCount()) {
      throw new Descriptors.DescriptorValidationException(result, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", null);
    }
    for (int i = 0; i < proto.getDependencyCount(); i++) {
      if (!dependencies[i].getName().equals(proto.getDependency(i))) {
        throw new Descriptors.DescriptorValidationException(result, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", null);
      }
    }
    result.crossLink();
    return result;
  }
  
  public static void internalBuildGeneratedFileFrom(String[] descriptorDataParts, FileDescriptor[] dependencies, InternalDescriptorAssigner descriptorAssigner)
  {
    StringBuilder descriptorData = new StringBuilder();
    for (String part : descriptorDataParts) {
      descriptorData.append(part);
    }
    byte[] descriptorBytes;
    try
    {
      descriptorBytes = descriptorData.toString().getBytes("ISO-8859-1");
    }
    catch (UnsupportedEncodingException e)
    {
      throw new RuntimeException("Standard encoding ISO-8859-1 not supported by JVM.", e);
    }
    DescriptorProtos.FileDescriptorProto proto;
    try
    {
      proto = DescriptorProtos.FileDescriptorProto.parseFrom(descriptorBytes);
    }
    catch (InvalidProtocolBufferException e)
    {
      throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
    }
    FileDescriptor result;
    try
    {
      result = buildFrom(proto, dependencies);
    }
    catch (Descriptors.DescriptorValidationException e)
    {
      throw new IllegalArgumentException("Invalid embedded descriptor for \"" + proto.getName() + "\".", e);
    }
    ExtensionRegistry registry = descriptorAssigner.assignDescriptors(result);
    if (registry != null)
    {
      try
      {
        proto = DescriptorProtos.FileDescriptorProto.parseFrom(descriptorBytes, registry);
      }
      catch (InvalidProtocolBufferException e)
      {
        throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
      }
      result.setProto(proto);
    }
  }
  
  private Descriptors$FileDescriptor(DescriptorProtos.FileDescriptorProto proto, FileDescriptor[] dependencies, Descriptors.DescriptorPool pool)
    throws Descriptors.DescriptorValidationException
  {
    this.pool = pool;
    this.proto = proto;
    this.dependencies = ((FileDescriptor[])dependencies.clone());
    publicDependencies = new FileDescriptor[proto.getPublicDependencyCount()];
    for (int i = 0; i < proto.getPublicDependencyCount(); i++)
    {
      int index = proto.getPublicDependency(i);
      if ((index < 0) || (index >= this.dependencies.length)) {
        throw new Descriptors.DescriptorValidationException(this, "Invalid public dependency index.", null);
      }
      publicDependencies[i] = this.dependencies[proto.getPublicDependency(i)];
    }
    pool.addPackage(getPackage(), this);
    
    messageTypes = new Descriptors.Descriptor[proto.getMessageTypeCount()];
    for (int i = 0; i < proto.getMessageTypeCount(); i++) {
      messageTypes[i] = new Descriptors.Descriptor(proto.getMessageType(i), this, null, i, null);
    }
    enumTypes = new Descriptors.EnumDescriptor[proto.getEnumTypeCount()];
    for (int i = 0; i < proto.getEnumTypeCount(); i++) {
      enumTypes[i] = new Descriptors.EnumDescriptor(proto.getEnumType(i), this, null, i, null);
    }
    services = new Descriptors.ServiceDescriptor[proto.getServiceCount()];
    for (int i = 0; i < proto.getServiceCount(); i++) {
      services[i] = new Descriptors.ServiceDescriptor(proto.getService(i), this, i, null);
    }
    extensions = new Descriptors.FieldDescriptor[proto.getExtensionCount()];
    for (int i = 0; i < proto.getExtensionCount(); i++) {
      extensions[i] = new Descriptors.FieldDescriptor(proto.getExtension(i), this, null, i, true, null);
    }
  }
  
  private void crossLink()
    throws Descriptors.DescriptorValidationException
  {
    for (Descriptors.Descriptor messageType : messageTypes) {
      Descriptors.Descriptor.access$500(messageType);
    }
    for (Descriptors.ServiceDescriptor service : services) {
      Descriptors.ServiceDescriptor.access$600(service);
    }
    for (Descriptors.FieldDescriptor extension : extensions) {
      Descriptors.FieldDescriptor.access$700(extension);
    }
  }
  
  private void setProto(DescriptorProtos.FileDescriptorProto proto)
  {
    this.proto = proto;
    for (int i = 0; i < messageTypes.length; i++) {
      Descriptors.Descriptor.access$800(messageTypes[i], proto.getMessageType(i));
    }
    for (int i = 0; i < enumTypes.length; i++) {
      Descriptors.EnumDescriptor.access$900(enumTypes[i], proto.getEnumType(i));
    }
    for (int i = 0; i < services.length; i++) {
      Descriptors.ServiceDescriptor.access$1000(services[i], proto.getService(i));
    }
    for (int i = 0; i < extensions.length; i++) {
      Descriptors.FieldDescriptor.access$1100(extensions[i], proto.getExtension(i));
    }
  }
  
  public static abstract interface InternalDescriptorAssigner
  {
    public abstract ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramFileDescriptor);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.FileDescriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */