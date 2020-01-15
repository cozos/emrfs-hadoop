package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Descriptors$EnumDescriptor
  implements Descriptors.GenericDescriptor, Internal.EnumLiteMap<Descriptors.EnumValueDescriptor>
{
  private final int index;
  private DescriptorProtos.EnumDescriptorProto proto;
  private final String fullName;
  private final Descriptors.FileDescriptor file;
  private final Descriptors.Descriptor containingType;
  private Descriptors.EnumValueDescriptor[] values;
  
  public int getIndex()
  {
    return index;
  }
  
  public DescriptorProtos.EnumDescriptorProto toProto()
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
  
  public Descriptors.Descriptor getContainingType()
  {
    return containingType;
  }
  
  public DescriptorProtos.EnumOptions getOptions()
  {
    return proto.getOptions();
  }
  
  public List<Descriptors.EnumValueDescriptor> getValues()
  {
    return Collections.unmodifiableList(Arrays.asList(values));
  }
  
  public Descriptors.EnumValueDescriptor findValueByName(String name)
  {
    Descriptors.GenericDescriptor result = Descriptors.FileDescriptor.access$1200(file).findSymbol(fullName + '.' + name);
    if ((result != null) && ((result instanceof Descriptors.EnumValueDescriptor))) {
      return (Descriptors.EnumValueDescriptor)result;
    }
    return null;
  }
  
  public Descriptors.EnumValueDescriptor findValueByNumber(int number)
  {
    return (Descriptors.EnumValueDescriptor)Descriptors.DescriptorPool.access$1800(Descriptors.FileDescriptor.access$1200(file)).get(new Descriptors.DescriptorPool.DescriptorIntPair(this, number));
  }
  
  private Descriptors$EnumDescriptor(DescriptorProtos.EnumDescriptorProto proto, Descriptors.FileDescriptor file, Descriptors.Descriptor parent, int index)
    throws Descriptors.DescriptorValidationException
  {
    this.index = index;
    this.proto = proto;
    fullName = Descriptors.access$1400(file, parent, proto.getName());
    this.file = file;
    containingType = parent;
    if (proto.getValueCount() == 0) {
      throw new Descriptors.DescriptorValidationException(this, "Enums must contain at least one value.", null);
    }
    values = new Descriptors.EnumValueDescriptor[proto.getValueCount()];
    for (int i = 0; i < proto.getValueCount(); i++) {
      values[i] = new Descriptors.EnumValueDescriptor(proto.getValue(i), file, this, i, null);
    }
    Descriptors.FileDescriptor.access$1200(file).addSymbol(this);
  }
  
  private void setProto(DescriptorProtos.EnumDescriptorProto proto)
  {
    this.proto = proto;
    for (int i = 0; i < values.length; i++) {
      Descriptors.EnumValueDescriptor.access$2000(values[i], proto.getValue(i));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.EnumDescriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */