package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Descriptors
{
  public static final class FileDescriptor
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
    
    private FileDescriptor(DescriptorProtos.FileDescriptorProto proto, FileDescriptor[] dependencies, Descriptors.DescriptorPool pool)
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
        messageType.crossLink();
      }
      for (Descriptors.ServiceDescriptor service : services) {
        service.crossLink();
      }
      for (Descriptors.FieldDescriptor extension : extensions) {
        extension.crossLink();
      }
    }
    
    private void setProto(DescriptorProtos.FileDescriptorProto proto)
    {
      this.proto = proto;
      for (int i = 0; i < messageTypes.length; i++) {
        messageTypes[i].setProto(proto.getMessageType(i));
      }
      for (int i = 0; i < enumTypes.length; i++) {
        enumTypes[i].setProto(proto.getEnumType(i));
      }
      for (int i = 0; i < services.length; i++) {
        services[i].setProto(proto.getService(i));
      }
      for (int i = 0; i < extensions.length; i++) {
        extensions[i].setProto(proto.getExtension(i));
      }
    }
    
    public static abstract interface InternalDescriptorAssigner
    {
      public abstract ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramFileDescriptor);
    }
  }
  
  public static final class Descriptor
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
      return (Descriptors.FieldDescriptor)access$1200file).fieldsByNumber.get(new Descriptors.DescriptorPool.DescriptorIntPair(this, number));
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
    
    private Descriptor(DescriptorProtos.DescriptorProto proto, Descriptors.FileDescriptor file, Descriptor parent, int index)
      throws Descriptors.DescriptorValidationException
    {
      this.index = index;
      this.proto = proto;
      fullName = Descriptors.computeFullName(file, parent, proto.getName());
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
        field.crossLink();
      }
      for (Descriptors.FieldDescriptor extension : extensions) {
        extension.crossLink();
      }
    }
    
    private void setProto(DescriptorProtos.DescriptorProto proto)
    {
      this.proto = proto;
      for (int i = 0; i < nestedTypes.length; i++) {
        nestedTypes[i].setProto(proto.getNestedType(i));
      }
      for (int i = 0; i < enumTypes.length; i++) {
        enumTypes[i].setProto(proto.getEnumType(i));
      }
      for (int i = 0; i < fields.length; i++) {
        fields[i].setProto(proto.getField(i));
      }
      for (int i = 0; i < extensions.length; i++) {
        extensions[i].setProto(proto.getExtension(i));
      }
    }
  }
  
  public static final class FieldDescriptor
    implements Descriptors.GenericDescriptor, Comparable<FieldDescriptor>, FieldSet.FieldDescriptorLite<FieldDescriptor>
  {
    public int getIndex()
    {
      return index;
    }
    
    public DescriptorProtos.FieldDescriptorProto toProto()
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
    
    public JavaType getJavaType()
    {
      return type.getJavaType();
    }
    
    public WireFormat.JavaType getLiteJavaType()
    {
      return getLiteType().getJavaType();
    }
    
    public Descriptors.FileDescriptor getFile()
    {
      return file;
    }
    
    public Type getType()
    {
      return type;
    }
    
    public WireFormat.FieldType getLiteType()
    {
      return table[type.ordinal()];
    }
    
    private static final WireFormat.FieldType[] table = ;
    private final int index;
    private DescriptorProtos.FieldDescriptorProto proto;
    private final String fullName;
    private final Descriptors.FileDescriptor file;
    private final Descriptors.Descriptor extensionScope;
    private Type type;
    private Descriptors.Descriptor containingType;
    private Descriptors.Descriptor messageType;
    private Descriptors.EnumDescriptor enumType;
    private Object defaultValue;
    
    public boolean isRequired()
    {
      return proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED;
    }
    
    public boolean isOptional()
    {
      return proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
    }
    
    public boolean isRepeated()
    {
      return proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
    }
    
    public boolean isPacked()
    {
      return getOptions().getPacked();
    }
    
    public boolean isPackable()
    {
      return (isRepeated()) && (getLiteType().isPackable());
    }
    
    public boolean hasDefaultValue()
    {
      return proto.hasDefaultValue();
    }
    
    public Object getDefaultValue()
    {
      if (getJavaType() == JavaType.MESSAGE) {
        throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
      }
      return defaultValue;
    }
    
    public DescriptorProtos.FieldOptions getOptions()
    {
      return proto.getOptions();
    }
    
    public boolean isExtension()
    {
      return proto.hasExtendee();
    }
    
    public Descriptors.Descriptor getContainingType()
    {
      return containingType;
    }
    
    public Descriptors.Descriptor getExtensionScope()
    {
      if (!isExtension()) {
        throw new UnsupportedOperationException("This field is not an extension.");
      }
      return extensionScope;
    }
    
    public Descriptors.Descriptor getMessageType()
    {
      if (getJavaType() != JavaType.MESSAGE) {
        throw new UnsupportedOperationException("This field is not of message type.");
      }
      return messageType;
    }
    
    public Descriptors.EnumDescriptor getEnumType()
    {
      if (getJavaType() != JavaType.ENUM) {
        throw new UnsupportedOperationException("This field is not of enum type.");
      }
      return enumType;
    }
    
    public int compareTo(FieldDescriptor other)
    {
      if (containingType != containingType) {
        throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
      }
      return getNumber() - other.getNumber();
    }
    
    public static enum Type
    {
      DOUBLE(Descriptors.FieldDescriptor.JavaType.DOUBLE),  FLOAT(Descriptors.FieldDescriptor.JavaType.FLOAT),  INT64(Descriptors.FieldDescriptor.JavaType.LONG),  UINT64(Descriptors.FieldDescriptor.JavaType.LONG),  INT32(Descriptors.FieldDescriptor.JavaType.INT),  FIXED64(Descriptors.FieldDescriptor.JavaType.LONG),  FIXED32(Descriptors.FieldDescriptor.JavaType.INT),  BOOL(Descriptors.FieldDescriptor.JavaType.BOOLEAN),  STRING(Descriptors.FieldDescriptor.JavaType.STRING),  GROUP(Descriptors.FieldDescriptor.JavaType.MESSAGE),  MESSAGE(Descriptors.FieldDescriptor.JavaType.MESSAGE),  BYTES(Descriptors.FieldDescriptor.JavaType.BYTE_STRING),  UINT32(Descriptors.FieldDescriptor.JavaType.INT),  ENUM(Descriptors.FieldDescriptor.JavaType.ENUM),  SFIXED32(Descriptors.FieldDescriptor.JavaType.INT),  SFIXED64(Descriptors.FieldDescriptor.JavaType.LONG),  SINT32(Descriptors.FieldDescriptor.JavaType.INT),  SINT64(Descriptors.FieldDescriptor.JavaType.LONG);
      
      private Descriptors.FieldDescriptor.JavaType javaType;
      
      private Type(Descriptors.FieldDescriptor.JavaType javaType)
      {
        this.javaType = javaType;
      }
      
      public DescriptorProtos.FieldDescriptorProto.Type toProto()
      {
        return DescriptorProtos.FieldDescriptorProto.Type.valueOf(ordinal() + 1);
      }
      
      public Descriptors.FieldDescriptor.JavaType getJavaType()
      {
        return javaType;
      }
      
      public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type type)
      {
        return values()[(type.getNumber() - 1)];
      }
    }
    
    static
    {
      if (Type.values().length != DescriptorProtos.FieldDescriptorProto.Type.values().length) {
        throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
      }
    }
    
    public static enum JavaType
    {
      INT(Integer.valueOf(0)),  LONG(Long.valueOf(0L)),  FLOAT(Float.valueOf(0.0F)),  DOUBLE(Double.valueOf(0.0D)),  BOOLEAN(Boolean.valueOf(false)),  STRING(""),  BYTE_STRING(ByteString.EMPTY),  ENUM(null),  MESSAGE(null);
      
      private final Object defaultDefault;
      
      private JavaType(Object defaultDefault)
      {
        this.defaultDefault = defaultDefault;
      }
    }
    
    private FieldDescriptor(DescriptorProtos.FieldDescriptorProto proto, Descriptors.FileDescriptor file, Descriptors.Descriptor parent, int index, boolean isExtension)
      throws Descriptors.DescriptorValidationException
    {
      this.index = index;
      this.proto = proto;
      fullName = Descriptors.computeFullName(file, parent, proto.getName());
      this.file = file;
      if (proto.hasType()) {
        type = Type.valueOf(proto.getType());
      }
      if (getNumber() <= 0) {
        throw new Descriptors.DescriptorValidationException(this, "Field numbers must be positive integers.", null);
      }
      if ((proto.getOptions().getPacked()) && (!isPackable())) {
        throw new Descriptors.DescriptorValidationException(this, "[packed = true] can only be specified for repeated primitive fields.", null);
      }
      if (isExtension)
      {
        if (!proto.hasExtendee()) {
          throw new Descriptors.DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", null);
        }
        containingType = null;
        if (parent != null) {
          extensionScope = parent;
        } else {
          extensionScope = null;
        }
      }
      else
      {
        if (proto.hasExtendee()) {
          throw new Descriptors.DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", null);
        }
        containingType = parent;
        extensionScope = null;
      }
      Descriptors.FileDescriptor.access$1200(file).addSymbol(this);
    }
    
    private void crossLink()
      throws Descriptors.DescriptorValidationException
    {
      if (proto.hasExtendee())
      {
        Descriptors.GenericDescriptor extendee = Descriptors.FileDescriptor.access$1200(file).lookupSymbol(proto.getExtendee(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
        if (!(extendee instanceof Descriptors.Descriptor)) {
          throw new Descriptors.DescriptorValidationException(this, '"' + proto.getExtendee() + "\" is not a message type.", null);
        }
        containingType = ((Descriptors.Descriptor)extendee);
        if (!getContainingType().isExtensionNumber(getNumber())) {
          throw new Descriptors.DescriptorValidationException(this, '"' + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", null);
        }
      }
      if (proto.hasTypeName())
      {
        Descriptors.GenericDescriptor typeDescriptor = Descriptors.FileDescriptor.access$1200(file).lookupSymbol(proto.getTypeName(), this, Descriptors.DescriptorPool.SearchFilter.TYPES_ONLY);
        if (!proto.hasType()) {
          if ((typeDescriptor instanceof Descriptors.Descriptor)) {
            type = Type.MESSAGE;
          } else if ((typeDescriptor instanceof Descriptors.EnumDescriptor)) {
            type = Type.ENUM;
          } else {
            throw new Descriptors.DescriptorValidationException(this, '"' + proto.getTypeName() + "\" is not a type.", null);
          }
        }
        if (getJavaType() == JavaType.MESSAGE)
        {
          if (!(typeDescriptor instanceof Descriptors.Descriptor)) {
            throw new Descriptors.DescriptorValidationException(this, '"' + proto.getTypeName() + "\" is not a message type.", null);
          }
          messageType = ((Descriptors.Descriptor)typeDescriptor);
          if (proto.hasDefaultValue()) {
            throw new Descriptors.DescriptorValidationException(this, "Messages can't have default values.", null);
          }
        }
        else if (getJavaType() == JavaType.ENUM)
        {
          if (!(typeDescriptor instanceof Descriptors.EnumDescriptor)) {
            throw new Descriptors.DescriptorValidationException(this, '"' + proto.getTypeName() + "\" is not an enum type.", null);
          }
          enumType = ((Descriptors.EnumDescriptor)typeDescriptor);
        }
        else
        {
          throw new Descriptors.DescriptorValidationException(this, "Field with primitive type has type_name.", null);
        }
      }
      else if ((getJavaType() == JavaType.MESSAGE) || (getJavaType() == JavaType.ENUM))
      {
        throw new Descriptors.DescriptorValidationException(this, "Field with message or enum type missing type_name.", null);
      }
      if (proto.hasDefaultValue())
      {
        if (isRepeated()) {
          throw new Descriptors.DescriptorValidationException(this, "Repeated fields cannot have default values.", null);
        }
        try
        {
          switch (Descriptors.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[getType().ordinal()])
          {
          case 1: 
          case 2: 
          case 3: 
            defaultValue = Integer.valueOf(TextFormat.parseInt32(proto.getDefaultValue()));
            break;
          case 4: 
          case 5: 
            defaultValue = Integer.valueOf(TextFormat.parseUInt32(proto.getDefaultValue()));
            break;
          case 6: 
          case 7: 
          case 8: 
            defaultValue = Long.valueOf(TextFormat.parseInt64(proto.getDefaultValue()));
            break;
          case 9: 
          case 10: 
            defaultValue = Long.valueOf(TextFormat.parseUInt64(proto.getDefaultValue()));
            break;
          case 11: 
            if (proto.getDefaultValue().equals("inf")) {
              defaultValue = Float.valueOf(Float.POSITIVE_INFINITY);
            } else if (proto.getDefaultValue().equals("-inf")) {
              defaultValue = Float.valueOf(Float.NEGATIVE_INFINITY);
            } else if (proto.getDefaultValue().equals("nan")) {
              defaultValue = Float.valueOf(NaN.0F);
            } else {
              defaultValue = Float.valueOf(proto.getDefaultValue());
            }
            break;
          case 12: 
            if (proto.getDefaultValue().equals("inf")) {
              defaultValue = Double.valueOf(Double.POSITIVE_INFINITY);
            } else if (proto.getDefaultValue().equals("-inf")) {
              defaultValue = Double.valueOf(Double.NEGATIVE_INFINITY);
            } else if (proto.getDefaultValue().equals("nan")) {
              defaultValue = Double.valueOf(NaN.0D);
            } else {
              defaultValue = Double.valueOf(proto.getDefaultValue());
            }
            break;
          case 13: 
            defaultValue = Boolean.valueOf(proto.getDefaultValue());
            break;
          case 14: 
            defaultValue = proto.getDefaultValue();
            break;
          case 15: 
            try
            {
              defaultValue = TextFormat.unescapeBytes(proto.getDefaultValue());
            }
            catch (TextFormat.InvalidEscapeSequenceException e)
            {
              throw new Descriptors.DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, null);
            }
          case 16: 
            defaultValue = enumType.findValueByName(proto.getDefaultValue());
            if (defaultValue == null) {
              throw new Descriptors.DescriptorValidationException(this, "Unknown enum default value: \"" + proto.getDefaultValue() + '"', null);
            }
            break;
          case 17: 
          case 18: 
            throw new Descriptors.DescriptorValidationException(this, "Message type had default value.", null);
          }
        }
        catch (NumberFormatException e)
        {
          throw new Descriptors.DescriptorValidationException(this, "Could not parse default value: \"" + proto.getDefaultValue() + '"', e, null);
        }
      }
      else if (isRepeated())
      {
        defaultValue = Collections.emptyList();
      }
      else
      {
        switch (Descriptors.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[getJavaType().ordinal()])
        {
        case 1: 
          defaultValue = enumType.getValues().get(0);
          break;
        case 2: 
          defaultValue = null;
          break;
        default: 
          defaultValue = getJavaTypedefaultDefault;
        }
      }
      if (!isExtension()) {
        Descriptors.FileDescriptor.access$1200(file).addFieldByNumber(this);
      }
      if ((containingType != null) && (containingType.getOptions().getMessageSetWireFormat())) {
        if (isExtension())
        {
          if ((!isOptional()) || (getType() != Type.MESSAGE)) {
            throw new Descriptors.DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.", null);
          }
        }
        else {
          throw new Descriptors.DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.", null);
        }
      }
    }
    
    private void setProto(DescriptorProtos.FieldDescriptorProto proto)
    {
      this.proto = proto;
    }
    
    public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from)
    {
      return ((Message.Builder)to).mergeFrom((Message)from);
    }
  }
  
  public static final class EnumDescriptor
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
      return (Descriptors.EnumValueDescriptor)access$1200file).enumValuesByNumber.get(new Descriptors.DescriptorPool.DescriptorIntPair(this, number));
    }
    
    private EnumDescriptor(DescriptorProtos.EnumDescriptorProto proto, Descriptors.FileDescriptor file, Descriptors.Descriptor parent, int index)
      throws Descriptors.DescriptorValidationException
    {
      this.index = index;
      this.proto = proto;
      fullName = Descriptors.computeFullName(file, parent, proto.getName());
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
        values[i].setProto(proto.getValue(i));
      }
    }
  }
  
  public static final class EnumValueDescriptor
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
    
    private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto proto, Descriptors.FileDescriptor file, Descriptors.EnumDescriptor parent, int index)
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
  
  public static final class ServiceDescriptor
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
    
    private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto proto, Descriptors.FileDescriptor file, int index)
      throws Descriptors.DescriptorValidationException
    {
      this.index = index;
      this.proto = proto;
      fullName = Descriptors.computeFullName(file, null, proto.getName());
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
        method.crossLink();
      }
    }
    
    private void setProto(DescriptorProtos.ServiceDescriptorProto proto)
    {
      this.proto = proto;
      for (int i = 0; i < methods.length; i++) {
        methods[i].setProto(proto.getMethod(i));
      }
    }
  }
  
  public static final class MethodDescriptor
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
    
    private MethodDescriptor(DescriptorProtos.MethodDescriptorProto proto, Descriptors.FileDescriptor file, Descriptors.ServiceDescriptor parent, int index)
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
  
  private static String computeFullName(FileDescriptor file, Descriptor parent, String name)
  {
    if (parent != null) {
      return parent.getFullName() + '.' + name;
    }
    if (file.getPackage().length() > 0) {
      return file.getPackage() + '.' + name;
    }
    return name;
  }
  
  private static abstract interface GenericDescriptor
  {
    public abstract Message toProto();
    
    public abstract String getName();
    
    public abstract String getFullName();
    
    public abstract Descriptors.FileDescriptor getFile();
  }
  
  public static class DescriptorValidationException
    extends Exception
  {
    private static final long serialVersionUID = 5750205775490483148L;
    private final String name;
    private final Message proto;
    private final String description;
    
    public String getProblemSymbolName()
    {
      return name;
    }
    
    public Message getProblemProto()
    {
      return proto;
    }
    
    public String getDescription()
    {
      return description;
    }
    
    private DescriptorValidationException(Descriptors.GenericDescriptor problemDescriptor, String description)
    {
      super();
      
      name = problemDescriptor.getFullName();
      proto = problemDescriptor.toProto();
      this.description = description;
    }
    
    private DescriptorValidationException(Descriptors.GenericDescriptor problemDescriptor, String description, Throwable cause)
    {
      this(problemDescriptor, description);
      initCause(cause);
    }
    
    private DescriptorValidationException(Descriptors.FileDescriptor problemDescriptor, String description)
    {
      super();
      
      name = problemDescriptor.getName();
      proto = problemDescriptor.toProto();
      this.description = description;
    }
  }
  
  private static final class DescriptorPool
  {
    private final Set<Descriptors.FileDescriptor> dependencies;
    
    static enum SearchFilter
    {
      TYPES_ONLY,  AGGREGATES_ONLY,  ALL_SYMBOLS;
      
      private SearchFilter() {}
    }
    
    DescriptorPool(Descriptors.FileDescriptor[] dependencies)
    {
      this.dependencies = new HashSet();
      for (int i = 0; i < dependencies.length; i++)
      {
        this.dependencies.add(dependencies[i]);
        importPublicDependencies(dependencies[i]);
      }
      for (Descriptors.FileDescriptor dependency : this.dependencies) {
        try
        {
          addPackage(dependency.getPackage(), dependency);
        }
        catch (Descriptors.DescriptorValidationException e)
        {
          if (!$assertionsDisabled) {
            throw new AssertionError();
          }
        }
      }
    }
    
    private void importPublicDependencies(Descriptors.FileDescriptor file)
    {
      for (Descriptors.FileDescriptor dependency : file.getPublicDependencies()) {
        if (dependencies.add(dependency)) {
          importPublicDependencies(dependency);
        }
      }
    }
    
    private final Map<String, Descriptors.GenericDescriptor> descriptorsByName = new HashMap();
    private final Map<DescriptorIntPair, Descriptors.FieldDescriptor> fieldsByNumber = new HashMap();
    private final Map<DescriptorIntPair, Descriptors.EnumValueDescriptor> enumValuesByNumber = new HashMap();
    
    Descriptors.GenericDescriptor findSymbol(String fullName)
    {
      return findSymbol(fullName, SearchFilter.ALL_SYMBOLS);
    }
    
    Descriptors.GenericDescriptor findSymbol(String fullName, SearchFilter filter)
    {
      Descriptors.GenericDescriptor result = (Descriptors.GenericDescriptor)descriptorsByName.get(fullName);
      if ((result != null) && (
        (filter == SearchFilter.ALL_SYMBOLS) || ((filter == SearchFilter.TYPES_ONLY) && (isType(result))) || ((filter == SearchFilter.AGGREGATES_ONLY) && (isAggregate(result))))) {
        return result;
      }
      for (Descriptors.FileDescriptor dependency : dependencies)
      {
        result = (Descriptors.GenericDescriptor)access$1200descriptorsByName.get(fullName);
        if ((result != null) && (
          (filter == SearchFilter.ALL_SYMBOLS) || ((filter == SearchFilter.TYPES_ONLY) && (isType(result))) || ((filter == SearchFilter.AGGREGATES_ONLY) && (isAggregate(result))))) {
          return result;
        }
      }
      return null;
    }
    
    boolean isType(Descriptors.GenericDescriptor descriptor)
    {
      return ((descriptor instanceof Descriptors.Descriptor)) || ((descriptor instanceof Descriptors.EnumDescriptor));
    }
    
    boolean isAggregate(Descriptors.GenericDescriptor descriptor)
    {
      return ((descriptor instanceof Descriptors.Descriptor)) || ((descriptor instanceof Descriptors.EnumDescriptor)) || ((descriptor instanceof PackageDescriptor)) || ((descriptor instanceof Descriptors.ServiceDescriptor));
    }
    
    Descriptors.GenericDescriptor lookupSymbol(String name, Descriptors.GenericDescriptor relativeTo, SearchFilter filter)
      throws Descriptors.DescriptorValidationException
    {
      Descriptors.GenericDescriptor result;
      Descriptors.GenericDescriptor result;
      if (name.startsWith("."))
      {
        result = findSymbol(name.substring(1), filter);
      }
      else
      {
        int firstPartLength = name.indexOf('.');
        String firstPart;
        String firstPart;
        if (firstPartLength == -1) {
          firstPart = name;
        } else {
          firstPart = name.substring(0, firstPartLength);
        }
        StringBuilder scopeToTry = new StringBuilder(relativeTo.getFullName());
        for (;;)
        {
          int dotpos = scopeToTry.lastIndexOf(".");
          if (dotpos == -1)
          {
            Descriptors.GenericDescriptor result = findSymbol(name, filter);
            break;
          }
          scopeToTry.setLength(dotpos + 1);
          
          scopeToTry.append(firstPart);
          result = findSymbol(scopeToTry.toString(), SearchFilter.AGGREGATES_ONLY);
          if (result != null)
          {
            if (firstPartLength == -1) {
              break;
            }
            scopeToTry.setLength(dotpos + 1);
            scopeToTry.append(name);
            result = findSymbol(scopeToTry.toString(), filter); break;
          }
          scopeToTry.setLength(dotpos);
        }
      }
      if (result == null) {
        throw new Descriptors.DescriptorValidationException(relativeTo, '"' + name + "\" is not defined.", null);
      }
      return result;
    }
    
    void addSymbol(Descriptors.GenericDescriptor descriptor)
      throws Descriptors.DescriptorValidationException
    {
      validateSymbolName(descriptor);
      
      String fullName = descriptor.getFullName();
      int dotpos = fullName.lastIndexOf('.');
      
      Descriptors.GenericDescriptor old = (Descriptors.GenericDescriptor)descriptorsByName.put(fullName, descriptor);
      if (old != null)
      {
        descriptorsByName.put(fullName, old);
        if (descriptor.getFile() == old.getFile())
        {
          if (dotpos == -1) {
            throw new Descriptors.DescriptorValidationException(descriptor, '"' + fullName + "\" is already defined.", null);
          }
          throw new Descriptors.DescriptorValidationException(descriptor, '"' + fullName.substring(dotpos + 1) + "\" is already defined in \"" + fullName.substring(0, dotpos) + "\".", null);
        }
        throw new Descriptors.DescriptorValidationException(descriptor, '"' + fullName + "\" is already defined in file \"" + old.getFile().getName() + "\".", null);
      }
    }
    
    private static final class PackageDescriptor
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
      
      PackageDescriptor(String name, String fullName, Descriptors.FileDescriptor file)
      {
        this.file = file;
        this.fullName = fullName;
        this.name = name;
      }
    }
    
    void addPackage(String fullName, Descriptors.FileDescriptor file)
      throws Descriptors.DescriptorValidationException
    {
      int dotpos = fullName.lastIndexOf('.');
      String name;
      String name;
      if (dotpos == -1)
      {
        name = fullName;
      }
      else
      {
        addPackage(fullName.substring(0, dotpos), file);
        name = fullName.substring(dotpos + 1);
      }
      Descriptors.GenericDescriptor old = (Descriptors.GenericDescriptor)descriptorsByName.put(fullName, new PackageDescriptor(name, fullName, file));
      if (old != null)
      {
        descriptorsByName.put(fullName, old);
        if (!(old instanceof PackageDescriptor)) {
          throw new Descriptors.DescriptorValidationException(file, '"' + name + "\" is already defined (as something other than a " + "package) in file \"" + old.getFile().getName() + "\".", null);
        }
      }
    }
    
    private static final class DescriptorIntPair
    {
      private final Descriptors.GenericDescriptor descriptor;
      private final int number;
      
      DescriptorIntPair(Descriptors.GenericDescriptor descriptor, int number)
      {
        this.descriptor = descriptor;
        this.number = number;
      }
      
      public int hashCode()
      {
        return descriptor.hashCode() * 65535 + number;
      }
      
      public boolean equals(Object obj)
      {
        if (!(obj instanceof DescriptorIntPair)) {
          return false;
        }
        DescriptorIntPair other = (DescriptorIntPair)obj;
        return (descriptor == descriptor) && (number == number);
      }
    }
    
    void addFieldByNumber(Descriptors.FieldDescriptor field)
      throws Descriptors.DescriptorValidationException
    {
      DescriptorIntPair key = new DescriptorIntPair(field.getContainingType(), field.getNumber());
      
      Descriptors.FieldDescriptor old = (Descriptors.FieldDescriptor)fieldsByNumber.put(key, field);
      if (old != null)
      {
        fieldsByNumber.put(key, old);
        throw new Descriptors.DescriptorValidationException(field, "Field number " + field.getNumber() + "has already been used in \"" + field.getContainingType().getFullName() + "\" by field \"" + old.getName() + "\".", null);
      }
    }
    
    void addEnumValueByNumber(Descriptors.EnumValueDescriptor value)
    {
      DescriptorIntPair key = new DescriptorIntPair(value.getType(), value.getNumber());
      
      Descriptors.EnumValueDescriptor old = (Descriptors.EnumValueDescriptor)enumValuesByNumber.put(key, value);
      if (old != null) {
        enumValuesByNumber.put(key, old);
      }
    }
    
    static void validateSymbolName(Descriptors.GenericDescriptor descriptor)
      throws Descriptors.DescriptorValidationException
    {
      String name = descriptor.getName();
      if (name.length() == 0) {
        throw new Descriptors.DescriptorValidationException(descriptor, "Missing name.", null);
      }
      boolean valid = true;
      for (int i = 0; i < name.length(); i++)
      {
        char c = name.charAt(i);
        if (c >= '') {
          valid = false;
        }
        if ((!Character.isLetter(c)) && (c != '_') && ((!Character.isDigit(c)) || (i <= 0))) {
          valid = false;
        }
      }
      if (!valid) {
        throw new Descriptors.DescriptorValidationException(descriptor, '"' + name + "\" is not a valid identifier.", null);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */