package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractMessage
  extends AbstractMessageLite
  implements Message
{
  private int memoizedSize;
  
  public boolean isInitialized()
  {
    for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields()) {
      if ((field.isRequired()) && 
        (!hasField(field))) {
        return false;
      }
    }
    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet())
    {
      Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)entry.getKey();
      if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        if (field.isRepeated()) {
          for (Message element : (List)entry.getValue()) {
            if (!element.isInitialized()) {
              return false;
            }
          }
        } else if (!((Message)entry.getValue()).isInitialized()) {
          return false;
        }
      }
    }
    return true;
  }
  
  public List<String> findInitializationErrors()
  {
    return Builder.findMissingFields(this);
  }
  
  public String getInitializationErrorString()
  {
    return delimitWithCommas(findInitializationErrors());
  }
  
  private static String delimitWithCommas(List<String> parts)
  {
    StringBuilder result = new StringBuilder();
    for (String part : parts)
    {
      if (result.length() > 0) {
        result.append(", ");
      }
      result.append(part);
    }
    return result.toString();
  }
  
  public final String toString()
  {
    return TextFormat.printToString(this);
  }
  
  public void writeTo(CodedOutputStream output)
    throws IOException
  {
    boolean isMessageSet = getDescriptorForType().getOptions().getMessageSetWireFormat();
    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet())
    {
      Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)entry.getKey();
      Object value = entry.getValue();
      if ((isMessageSet) && (field.isExtension()) && (field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) && (!field.isRepeated())) {
        output.writeMessageSetExtension(field.getNumber(), (Message)value);
      } else {
        FieldSet.writeField(field, value, output);
      }
    }
    UnknownFieldSet unknownFields = getUnknownFields();
    if (isMessageSet) {
      unknownFields.writeAsMessageSetTo(output);
    } else {
      unknownFields.writeTo(output);
    }
  }
  
  public AbstractMessage()
  {
    memoizedSize = -1;
  }
  
  public int getSerializedSize()
  {
    int size = memoizedSize;
    if (size != -1) {
      return size;
    }
    size = 0;
    boolean isMessageSet = getDescriptorForType().getOptions().getMessageSetWireFormat();
    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet())
    {
      Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)entry.getKey();
      Object value = entry.getValue();
      if ((isMessageSet) && (field.isExtension()) && (field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) && (!field.isRepeated())) {
        size += CodedOutputStream.computeMessageSetExtensionSize(field.getNumber(), (Message)value);
      } else {
        size += FieldSet.computeFieldSize(field, value);
      }
    }
    UnknownFieldSet unknownFields = getUnknownFields();
    if (isMessageSet) {
      size += unknownFields.getSerializedSizeAsMessageSet();
    } else {
      size += unknownFields.getSerializedSize();
    }
    memoizedSize = size;
    return size;
  }
  
  public boolean equals(Object other)
  {
    if (other == this) {
      return true;
    }
    if (!(other instanceof Message)) {
      return false;
    }
    Message otherMessage = (Message)other;
    if (getDescriptorForType() != otherMessage.getDescriptorForType()) {
      return false;
    }
    return (getAllFields().equals(otherMessage.getAllFields())) && (getUnknownFields().equals(otherMessage.getUnknownFields()));
  }
  
  public int hashCode()
  {
    int hash = 41;
    hash = 19 * hash + getDescriptorForType().hashCode();
    hash = hashFields(hash, getAllFields());
    hash = 29 * hash + getUnknownFields().hashCode();
    return hash;
  }
  
  protected int hashFields(int hash, Map<Descriptors.FieldDescriptor, Object> map)
  {
    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet())
    {
      Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)entry.getKey();
      Object value = entry.getValue();
      hash = 37 * hash + field.getNumber();
      if (field.getType() != Descriptors.FieldDescriptor.Type.ENUM)
      {
        hash = 53 * hash + value.hashCode();
      }
      else if (field.isRepeated())
      {
        List<? extends Internal.EnumLite> list = (List)value;
        hash = 53 * hash + hashEnumList(list);
      }
      else
      {
        hash = 53 * hash + hashEnum((Internal.EnumLite)value);
      }
    }
    return hash;
  }
  
  protected static int hashLong(long n)
  {
    return (int)(n ^ n >>> 32);
  }
  
  protected static int hashBoolean(boolean b)
  {
    return b ? 1231 : 1237;
  }
  
  UninitializedMessageException newUninitializedMessageException()
  {
    return Builder.newUninitializedMessageException(this);
  }
  
  protected static int hashEnum(Internal.EnumLite e)
  {
    return e.getNumber();
  }
  
  protected static int hashEnumList(List<? extends Internal.EnumLite> list)
  {
    int hash = 1;
    for (Internal.EnumLite e : list) {
      hash = 31 * hash + hashEnum(e);
    }
    return hash;
  }
  
  public static abstract class Builder<BuilderType extends Builder>
    extends AbstractMessageLite.Builder<BuilderType>
    implements Message.Builder
  {
    public abstract BuilderType clone();
    
    public BuilderType clear()
    {
      for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet()) {
        clearField((Descriptors.FieldDescriptor)entry.getKey());
      }
      return this;
    }
    
    public List<String> findInitializationErrors()
    {
      return findMissingFields(this);
    }
    
    public String getInitializationErrorString()
    {
      return AbstractMessage.delimitWithCommas(findInitializationErrors());
    }
    
    public BuilderType mergeFrom(Message other)
    {
      if (other.getDescriptorForType() != getDescriptorForType()) {
        throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      }
      for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : other.getAllFields().entrySet())
      {
        Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)entry.getKey();
        if (field.isRepeated())
        {
          for (Object element : (List)entry.getValue()) {
            addRepeatedField(field, element);
          }
        }
        else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          Message existingValue = (Message)getField(field);
          if (existingValue == existingValue.getDefaultInstanceForType()) {
            setField(field, entry.getValue());
          } else {
            setField(field, existingValue.newBuilderForType().mergeFrom(existingValue).mergeFrom((Message)entry.getValue()).build());
          }
        }
        else
        {
          setField(field, entry.getValue());
        }
      }
      mergeUnknownFields(other.getUnknownFields());
      
      return this;
    }
    
    public BuilderType mergeFrom(CodedInputStream input)
      throws IOException
    {
      return mergeFrom(input, ExtensionRegistry.getEmptyRegistry());
    }
    
    public BuilderType mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
      for (;;)
      {
        int tag = input.readTag();
        if (tag == 0) {
          break;
        }
        if (!mergeFieldFrom(input, unknownFields, extensionRegistry, getDescriptorForType(), this, null, tag)) {
          break;
        }
      }
      setUnknownFields(unknownFields.build());
      return this;
    }
    
    private static void addRepeatedField(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions, Descriptors.FieldDescriptor field, Object value)
    {
      if (builder != null) {
        builder.addRepeatedField(field, value);
      } else {
        extensions.addRepeatedField(field, value);
      }
    }
    
    private static void setField(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions, Descriptors.FieldDescriptor field, Object value)
    {
      if (builder != null) {
        builder.setField(field, value);
      } else {
        extensions.setField(field, value);
      }
    }
    
    private static boolean hasOriginalMessage(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions, Descriptors.FieldDescriptor field)
    {
      if (builder != null) {
        return builder.hasField(field);
      }
      return extensions.hasField(field);
    }
    
    private static Message getOriginalMessage(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions, Descriptors.FieldDescriptor field)
    {
      if (builder != null) {
        return (Message)builder.getField(field);
      }
      return (Message)extensions.getField(field);
    }
    
    private static void mergeOriginalMessage(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions, Descriptors.FieldDescriptor field, Message.Builder subBuilder)
    {
      Message originalMessage = getOriginalMessage(builder, extensions, field);
      if (originalMessage != null) {
        subBuilder.mergeFrom(originalMessage);
      }
    }
    
    static boolean mergeFieldFrom(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions, int tag)
      throws IOException
    {
      if ((type.getOptions().getMessageSetWireFormat()) && (tag == WireFormat.MESSAGE_SET_ITEM_TAG))
      {
        mergeMessageSetExtensionFromCodedStream(input, unknownFields, extensionRegistry, type, builder, extensions);
        
        return true;
      }
      int wireType = WireFormat.getTagWireType(tag);
      int fieldNumber = WireFormat.getTagFieldNumber(tag);
      
      Message defaultInstance = null;
      Descriptors.FieldDescriptor field;
      Descriptors.FieldDescriptor field;
      if (type.isExtensionNumber(fieldNumber))
      {
        if ((extensionRegistry instanceof ExtensionRegistry))
        {
          ExtensionRegistry.ExtensionInfo extension = ((ExtensionRegistry)extensionRegistry).findExtensionByNumber(type, fieldNumber);
          Descriptors.FieldDescriptor field;
          if (extension == null)
          {
            field = null;
          }
          else
          {
            Descriptors.FieldDescriptor field = descriptor;
            defaultInstance = defaultInstance;
            if ((defaultInstance == null) && (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)) {
              throw new IllegalStateException("Message-typed extension lacked default instance: " + field.getFullName());
            }
          }
        }
        else
        {
          field = null;
        }
      }
      else
      {
        Descriptors.FieldDescriptor field;
        if (builder != null) {
          field = type.findFieldByNumber(fieldNumber);
        } else {
          field = null;
        }
      }
      boolean unknown = false;
      boolean packed = false;
      if (field == null) {
        unknown = true;
      } else if (wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), false)) {
        packed = false;
      } else if ((field.isPackable()) && (wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), true))) {
        packed = true;
      } else {
        unknown = true;
      }
      if (unknown) {
        return unknownFields.mergeFieldFrom(tag, input);
      }
      if (packed)
      {
        int length = input.readRawVarint32();
        int limit = input.pushLimit(length);
        if (field.getLiteType() == WireFormat.FieldType.ENUM) {
          while (input.getBytesUntilLimit() > 0)
          {
            int rawValue = input.readEnum();
            Object value = field.getEnumType().findValueByNumber(rawValue);
            if (value == null) {
              return true;
            }
            addRepeatedField(builder, extensions, field, value);
          }
        }
        while (input.getBytesUntilLimit() > 0)
        {
          Object value = FieldSet.readPrimitiveField(input, field.getLiteType());
          
          addRepeatedField(builder, extensions, field, value);
        }
        input.popLimit(limit);
      }
      else
      {
        Object value;
        switch (AbstractMessage.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[field.getType().ordinal()])
        {
        case 1: 
          Message.Builder subBuilder;
          Message.Builder subBuilder;
          if (defaultInstance != null) {
            subBuilder = defaultInstance.newBuilderForType();
          } else {
            subBuilder = builder.newBuilderForField(field);
          }
          if (!field.isRepeated()) {
            mergeOriginalMessage(builder, extensions, field, subBuilder);
          }
          input.readGroup(field.getNumber(), subBuilder, extensionRegistry);
          value = subBuilder.buildPartial();
          break;
        case 2: 
          Message.Builder subBuilder;
          Message.Builder subBuilder;
          if (defaultInstance != null) {
            subBuilder = defaultInstance.newBuilderForType();
          } else {
            subBuilder = builder.newBuilderForField(field);
          }
          if (!field.isRepeated()) {
            mergeOriginalMessage(builder, extensions, field, subBuilder);
          }
          input.readMessage(subBuilder, extensionRegistry);
          value = subBuilder.buildPartial();
          break;
        case 3: 
          int rawValue = input.readEnum();
          value = field.getEnumType().findValueByNumber(rawValue);
          if (value == null)
          {
            unknownFields.mergeVarintField(fieldNumber, rawValue);
            return true;
          }
          break;
        default: 
          value = FieldSet.readPrimitiveField(input, field.getLiteType());
        }
        if (field.isRepeated()) {
          addRepeatedField(builder, extensions, field, value);
        } else {
          setField(builder, extensions, field, value);
        }
      }
      return true;
    }
    
    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions)
      throws IOException
    {
      int typeId = 0;
      ByteString rawBytes = null;
      ExtensionRegistry.ExtensionInfo extension = null;
      for (;;)
      {
        int tag = input.readTag();
        if (tag == 0) {
          break;
        }
        if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG)
        {
          typeId = input.readUInt32();
          if (typeId != 0) {
            if ((extensionRegistry instanceof ExtensionRegistry)) {
              extension = ((ExtensionRegistry)extensionRegistry).findExtensionByNumber(type, typeId);
            }
          }
        }
        else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG)
        {
          if ((typeId != 0) && 
            (extension != null) && (ExtensionRegistryLite.isEagerlyParseMessageSets()))
          {
            eagerlyMergeMessageSetExtension(input, extension, extensionRegistry, builder, extensions);
            
            rawBytes = null;
          }
          else
          {
            rawBytes = input.readBytes();
          }
        }
        else
        {
          if (!input.skipField(tag)) {
            break;
          }
        }
      }
      input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
      if ((rawBytes != null) && (typeId != 0)) {
        if (extension != null) {
          mergeMessageSetExtensionFromBytes(rawBytes, extension, extensionRegistry, builder, extensions);
        } else if (rawBytes != null) {
          unknownFields.mergeField(typeId, UnknownFieldSet.Field.newBuilder().addLengthDelimited(rawBytes).build());
        }
      }
    }
    
    private static void eagerlyMergeMessageSetExtension(CodedInputStream input, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions)
      throws IOException
    {
      Descriptors.FieldDescriptor field = descriptor;
      Message value = null;
      if (hasOriginalMessage(builder, extensions, field))
      {
        Message originalMessage = getOriginalMessage(builder, extensions, field);
        
        Message.Builder subBuilder = originalMessage.toBuilder();
        input.readMessage(subBuilder, extensionRegistry);
        value = subBuilder.buildPartial();
      }
      else
      {
        value = (Message)input.readMessage(defaultInstance.getParserForType(), extensionRegistry);
      }
      if (builder != null) {
        builder.setField(field, value);
      } else {
        extensions.setField(field, value);
      }
    }
    
    private static void mergeMessageSetExtensionFromBytes(ByteString rawBytes, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> extensions)
      throws IOException
    {
      Descriptors.FieldDescriptor field = descriptor;
      boolean hasOriginalValue = hasOriginalMessage(builder, extensions, field);
      if ((hasOriginalValue) || (ExtensionRegistryLite.isEagerlyParseMessageSets()))
      {
        Message value = null;
        if (hasOriginalValue)
        {
          Message originalMessage = getOriginalMessage(builder, extensions, field);
          
          Message.Builder subBuilder = originalMessage.toBuilder();
          subBuilder.mergeFrom(rawBytes, extensionRegistry);
          value = subBuilder.buildPartial();
        }
        else
        {
          value = (Message)defaultInstance.getParserForType().parsePartialFrom(rawBytes, extensionRegistry);
        }
        setField(builder, extensions, field, value);
      }
      else
      {
        LazyField lazyField = new LazyField(defaultInstance, extensionRegistry, rawBytes);
        if (builder != null)
        {
          if ((builder instanceof GeneratedMessage.ExtendableBuilder)) {
            builder.setField(field, lazyField);
          } else {
            builder.setField(field, lazyField.getValue());
          }
        }
        else {
          extensions.setField(field, lazyField);
        }
      }
    }
    
    public BuilderType mergeUnknownFields(UnknownFieldSet unknownFields)
    {
      setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(unknownFields).build());
      
      return this;
    }
    
    public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor field)
    {
      throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }
    
    protected static UninitializedMessageException newUninitializedMessageException(Message message)
    {
      return new UninitializedMessageException(findMissingFields(message));
    }
    
    private static List<String> findMissingFields(MessageOrBuilder message)
    {
      List<String> results = new ArrayList();
      findMissingFields(message, "", results);
      return results;
    }
    
    private static void findMissingFields(MessageOrBuilder message, String prefix, List<String> results)
    {
      for (Descriptors.FieldDescriptor field : message.getDescriptorForType().getFields()) {
        if ((field.isRequired()) && (!message.hasField(field))) {
          results.add(prefix + field.getName());
        }
      }
      for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet())
      {
        Descriptors.FieldDescriptor field = (Descriptors.FieldDescriptor)entry.getKey();
        Object value = entry.getValue();
        if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        {
          int i;
          if (field.isRepeated())
          {
            i = 0;
            for (Object element : (List)value) {
              findMissingFields((MessageOrBuilder)element, subMessagePrefix(prefix, field, i++), results);
            }
          }
          else if (message.hasField(field))
          {
            findMissingFields((MessageOrBuilder)value, subMessagePrefix(prefix, field, -1), results);
          }
        }
      }
    }
    
    private static String subMessagePrefix(String prefix, Descriptors.FieldDescriptor field, int index)
    {
      StringBuilder result = new StringBuilder(prefix);
      if (field.isExtension()) {
        result.append('(').append(field.getFullName()).append(')');
      } else {
        result.append(field.getName());
      }
      if (index != -1) {
        result.append('[').append(index).append(']');
      }
      result.append('.');
      return result.toString();
    }
    
    public BuilderType mergeFrom(ByteString data)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(data);
    }
    
    public BuilderType mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(data, extensionRegistry);
    }
    
    public BuilderType mergeFrom(byte[] data)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(data);
    }
    
    public BuilderType mergeFrom(byte[] data, int off, int len)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(data, off, len);
    }
    
    public BuilderType mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(data, extensionRegistry);
    }
    
    public BuilderType mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      return (Builder)super.mergeFrom(data, off, len, extensionRegistry);
    }
    
    public BuilderType mergeFrom(InputStream input)
      throws IOException
    {
      return (Builder)super.mergeFrom(input);
    }
    
    public BuilderType mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return (Builder)super.mergeFrom(input, extensionRegistry);
    }
    
    public boolean mergeDelimitedFrom(InputStream input)
      throws IOException
    {
      return super.mergeDelimitedFrom(input);
    }
    
    public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
      throws IOException
    {
      return super.mergeDelimitedFrom(input, extensionRegistry);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.AbstractMessage
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */