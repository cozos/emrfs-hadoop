package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Descriptors$Descriptor
  implements Descriptors.GenericDescriptor
{
  private final int index;
  private DescriptorProtos.DescriptorProto proto;
  private final String fullName;
  private final Descriptors.FileDescriptor file;
  private final Descriptor containingType;
  private final Descriptor[] nestedTypes;
  private final Descriptors.EnumDescriptor[] enumTypes;
  private final Descriptors.FieldDescriptor[] fields;
  private final Descriptors.FieldDescriptor[] extensions;
  
  public int getIndex()
  {
    return index;
  }
  
  public DescriptorProtos.DescriptorProto toProto()
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
  
  public Descriptor getContainingType()
  {
    return containingType;
  }
  
  public DescriptorProtos.MessageOptions getOptions()
  {
    return proto.getOptions();
  }
  
  public List<Descriptors.FieldDescriptor> getFields()
  {
    return Collections.unmodifiableList(Arrays.asList(fields));
  }
  
  public List<Descriptors.FieldDescriptor> getExtensions()
  {
    return Collections.unmodifiableList(Arrays.asList(extensions));
  }
  
  public List<Descriptor> getNestedTypes()
  {
    return Collections.unmodifiableList(Arrays.asList(nestedTypes));
  }
  
  public List<Descriptors.EnumDescriptor> getEnumTypes()
  {
    return Collections.unmodifiableList(Arrays.asList(enumTypes));
  }
  
  public boolean isExtensionNumber(int number)
  {
    for (DescriptorProtos.DescriptorProto.ExtensionRange range : proto.getExtensionRangeList()) {
      if ((range.getStart() <= number) && (number < range.getEnd())) {
        return true;
      }
    }
    return false;
  }
  
  public Descriptors.FieldDescriptor findFieldByName(String name)
  {
    Descriptors.GenericDescriptor result = Descriptors.FileDescriptor.access$1200(file).findSymbol(fullName + '.' + name);
    if ((result != null) && ((result instanceof Descriptors.FieldDescriptor))) {
      return (Descriptors.FieldDescriptor)result;
    }
    return null;
  }
  
  public Descriptors.FieldDescriptor findFieldByNumber(int number)
  {
    return (Descriptors.FieldDescriptor)Descriptors.DescriptorPool.access$1300(Descriptors.FileDescriptor.access$1200(file)).get(new Descriptors.DescriptorPool.DescriptorIntPair(this, number));
  }
  
  public Descriptor findNestedTypeByName(String name)
  {
    Descriptors.GenericDescriptor result = Descriptors.FileDescriptor.access$1200(file).findSymbol(fullName + '.' + name);
    if ((result != null) && ((result instanceof Descriptor))) {
      return (Descriptor)result;
    }
    return null;
  }
  
  public Descriptors.EnumDescriptor findEnumTypeByName(String name)
  {
    Descriptors.GenericDescriptor result = Descriptors.FileDescriptor.access$1200(file).findSymbol(fullName + '.' + name);
    if ((result != null) && ((result instanceof Descriptors.EnumDescriptor))) {
      return (Descriptors.EnumDescriptor)result;
    }
    return null;
  }
  
  private Descriptors$Descriptor(DescriptorProtos.DescriptorProto proto, Descriptors.FileDescriptor file, Descriptor parent, int index)
    throws Descriptors.DescriptorValidationException
  {
    this.index = index;
    this.proto = proto;
    fullName = Descriptors.access$1400(file, parent, proto.getName());
    this.file = file;
    containingType = parent;
    
    nestedTypes = new Descriptor[proto.getNestedTypeCount()];
    for (int i = 0; i < proto.getNestedTypeCount(); i++) {
      nestedTypes[i] = new Descriptor(proto.getNestedType(i), file, this, i);
    }
    enumTypes = new Descriptors.EnumDescriptor[proto.getEnumTypeCount()];
    for (int i = 0; i < proto.getEnumTypeCount(); i++) {
      enumTypes[i] = new Descriptors.EnumDescriptor(proto.getEnumType(i), file, this, i, null);
    }
    fields = new Descriptors.FieldDescriptor[proto.getFieldCount()];
    for (int i = 0; i < proto.getFieldCount(); i++) {
      fields[i] = new Descriptors.FieldDescriptor(proto.getField(i), file, this, i, false, null);
    }
    extensions = new Descriptors.FieldDescriptor[proto.getExtensionCount()];
    for (int i = 0; i < proto.getExtensionCount(); i++) {
      extensions[i] = new Descriptors.FieldDescriptor(proto.getExtension(i), file, this, i, true, null);
    }
    Descriptors.FileDescriptor.access$1200(file).addSymbol(this);
  }
  
  private void crossLink()
    throws Descriptors.DescriptorValidationException
  {
    for (Descriptor nestedType : nestedTypes) {
      nestedType.crossLink();
    }
    for (Descriptors.FieldDescriptor field : fields) {
      Descriptors.FieldDescriptor.access$700(field);
    }
    for (Descriptors.FieldDescriptor extension : extensions) {
      Descriptors.FieldDescriptor.access$700(extension);
    }
  }
  
  private void setProto(DescriptorProtos.DescriptorProto proto)
  {
    this.proto = proto;
    for (int i = 0; i < nestedTypes.length; i++) {
      nestedTypes[i].setProto(proto.getNestedType(i));
    }
    for (int i = 0; i < enumTypes.length; i++) {
      Descriptors.EnumDescriptor.access$900(enumTypes[i], proto.getEnumType(i));
    }
    for (int i = 0; i < fields.length; i++) {
      Descriptors.FieldDescriptor.access$1100(fields[i], proto.getField(i));
    }
    for (int i = 0; i < extensions.length; i++) {
      Descriptors.FieldDescriptor.access$1100(extensions[i], proto.getExtension(i));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.Descriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */