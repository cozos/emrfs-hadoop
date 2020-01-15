package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Collections;
import java.util.List;

public final class Descriptors$FieldDescriptor
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
  
  private Descriptors$FieldDescriptor(DescriptorProtos.FieldDescriptorProto proto, Descriptors.FileDescriptor file, Descriptors.Descriptor parent, int index, boolean isExtension)
    throws Descriptors.DescriptorValidationException
  {
    this.index = index;
    this.proto = proto;
    fullName = Descriptors.access$1400(file, parent, proto.getName());
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Descriptors.FieldDescriptor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */