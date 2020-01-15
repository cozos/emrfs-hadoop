package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class DynamicMessage
  extends AbstractMessage
{
  private final Descriptors.Descriptor type;
  private final FieldSet<Descriptors.FieldDescriptor> fields;
  private final UnknownFieldSet unknownFields;
  private int memoizedSize = -1;
  
  private DynamicMessage(Descriptors.Descriptor type, FieldSet<Descriptors.FieldDescriptor> fields, UnknownFieldSet unknownFields)
  {
    this.type = type;
    this.fields = fields;
    this.unknownFields = unknownFields;
  }
  
  public static DynamicMessage getDefaultInstance(Descriptors.Descriptor type)
  {
    return new DynamicMessage(type, FieldSet.emptySet(), UnknownFieldSet.getDefaultInstance());
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor type, CodedInputStream input)
    throws IOException
  {
    return ((Builder)newBuilder(type).mergeFrom(input)).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor type, CodedInputStream input, ExtensionRegistry extensionRegistry)
    throws IOException
  {
    return ((Builder)newBuilder(type).mergeFrom(input, extensionRegistry)).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor type, ByteString data)
    throws InvalidProtocolBufferException
  {
    return ((Builder)newBuilder(type).mergeFrom(data)).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor type, ByteString data, ExtensionRegistry extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return ((Builder)newBuilder(type).mergeFrom(data, extensionRegistry)).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor type, byte[] data)
    throws InvalidProtocolBufferException
  {
    return ((Builder)newBuilder(type).mergeFrom(data)).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor type, byte[] data, ExtensionRegistry extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return ((Builder)newBuilder(type).mergeFrom(data, extensionRegistry)).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor type, InputStream input)
    throws IOException
  {
    return ((Builder)newBuilder(type).mergeFrom(input)).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor type, InputStream input, ExtensionRegistry extensionRegistry)
    throws IOException
  {
    return ((Builder)newBuilder(type).mergeFrom(input, extensionRegistry)).buildParsed();
  }
  
  public static Builder newBuilder(Descriptors.Descriptor type)
  {
    return new Builder(type, null);
  }
  
  public static Builder newBuilder(Message prototype)
  {
    return new Builder(prototype.getDescriptorForType(), null).mergeFrom(prototype);
  }
  
  public Descriptors.Descriptor getDescriptorForType()
  {
    return type;
  }
  
  public DynamicMessage getDefaultInstanceForType()
  {
    return getDefaultInstance(type);
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields()
  {
    return fields.getAllFields();
  }
  
  public boolean hasField(Descriptors.FieldDescriptor field)
  {
    verifyContainingType(field);
    return fields.hasField(field);
  }
  
  public Object getField(Descriptors.FieldDescriptor field)
  {
    verifyContainingType(field);
    Object result = fields.getField(field);
    if (result == null) {
      if (field.isRepeated()) {
        result = Collections.emptyList();
      } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        result = getDefaultInstance(field.getMessageType());
      } else {
        result = field.getDefaultValue();
      }
    }
    return result;
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor field)
  {
    verifyContainingType(field);
    return fields.getRepeatedFieldCount(field);
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor field, int index)
  {
    verifyContainingType(field);
    return fields.getRepeatedField(field, index);
  }
  
  public UnknownFieldSet getUnknownFields()
  {
    return unknownFields;
  }
  
  private static boolean isInitialized(Descriptors.Descriptor type, FieldSet<Descriptors.FieldDescriptor> fields)
  {
    for (Descriptors.FieldDescriptor field : type.getFields()) {
      if ((field.isRequired()) && 
        (!fields.hasField(field))) {
        return false;
      }
    }
    return fields.isInitialized();
  }
  
  public boolean isInitialized()
  {
    return isInitialized(type, fields);
  }
  
  public void writeTo(CodedOutputStream output)
    throws IOException
  {
    if (type.getOptions().getMessageSetWireFormat())
    {
      fields.writeMessageSetTo(output);
      unknownFields.writeAsMessageSetTo(output);
    }
    else
    {
      fields.writeTo(output);
      unknownFields.writeTo(output);
    }
  }
  
  public int getSerializedSize()
  {
    int size = memoizedSize;
    if (size != -1) {
      return size;
    }
    if (type.getOptions().getMessageSetWireFormat())
    {
      size = fields.getMessageSetSerializedSize();
      size += unknownFields.getSerializedSizeAsMessageSet();
    }
    else
    {
      size = fields.getSerializedSize();
      size += unknownFields.getSerializedSize();
    }
    memoizedSize = size;
    return size;
  }
  
  public Builder newBuilderForType()
  {
    return new Builder(type, null);
  }
  
  public Builder toBuilder()
  {
    return newBuilderForType().mergeFrom(this);
  }
  
  public Parser<DynamicMessage> getParserForType()
  {
    new AbstractParser()
    {
      public DynamicMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
        throws InvalidProtocolBufferException
      {
        DynamicMessage.Builder builder = DynamicMessage.newBuilder(type);
        try
        {
          builder.mergeFrom(input, extensionRegistry);
        }
        catch (InvalidProtocolBufferException e)
        {
          throw e.setUnfinishedMessage(builder.buildPartial());
        }
        catch (IOException e)
        {
          throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };
  }
  
  private void verifyContainingType(Descriptors.FieldDescriptor field)
  {
    if (field.getContainingType() != type) {
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
  }
  
  public static final class Builder
    extends AbstractMessage.Builder<Builder>
  {
    private final Descriptors.Descriptor type;
    private FieldSet<Descriptors.FieldDescriptor> fields;
    private UnknownFieldSet unknownFields;
    
    private Builder(Descriptors.Descriptor type)
    {
      this.type = type;
      fields = FieldSet.newFieldSet();
      unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    public Builder clear()
    {
      if (fields.isImmutable()) {
        fields = FieldSet.newFieldSet();
      } else {
        fields.clear();
      }
      unknownFields = UnknownFieldSet.getDefaultInstance();
      return this;
    }
    
    public Builder mergeFrom(Message other)
    {
      if ((other instanceof DynamicMessage))
      {
        DynamicMessage otherDynamicMessage = (DynamicMessage)other;
        if (type != type) {
          throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        ensureIsMutable();
        fields.mergeFrom(fields);
        mergeUnknownFields(unknownFields);
        return this;
      }
      return (Builder)super.mergeFrom(other);
    }
    
    public DynamicMessage build()
    {
      if (!isInitialized()) {
        throw newUninitializedMessageException(new DynamicMessage(type, fields, unknownFields, null));
      }
      return buildPartial();
    }
    
    private DynamicMessage buildParsed()
      throws InvalidProtocolBufferException
    {
      if (!isInitialized()) {
        throw newUninitializedMessageException(new DynamicMessage(type, fields, unknownFields, null)).asInvalidProtocolBufferException();
      }
      return buildPartial();
    }
    
    public DynamicMessage buildPartial()
    {
      fields.makeImmutable();
      DynamicMessage result = new DynamicMessage(type, fields, unknownFields, null);
      
      return result;
    }
    
    public Builder clone()
    {
      Builder result = new Builder(type);
      fields.mergeFrom(fields);
      result.mergeUnknownFields(unknownFields);
      return result;
    }
    
    public boolean isInitialized()
    {
      return DynamicMessage.isInitialized(type, fields);
    }
    
    public Descriptors.Descriptor getDescriptorForType()
    {
      return type;
    }
    
    public DynamicMessage getDefaultInstanceForType()
    {
      return DynamicMessage.getDefaultInstance(type);
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields()
    {
      return fields.getAllFields();
    }
    
    public Builder newBuilderForField(Descriptors.FieldDescriptor field)
    {
      verifyContainingType(field);
      if (field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
      }
      return new Builder(field.getMessageType());
    }
    
    public boolean hasField(Descriptors.FieldDescriptor field)
    {
      verifyContainingType(field);
      return fields.hasField(field);
    }
    
    public Object getField(Descriptors.FieldDescriptor field)
    {
      verifyContainingType(field);
      Object result = fields.getField(field);
      if (result == null) {
        if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          result = DynamicMessage.getDefaultInstance(field.getMessageType());
        } else {
          result = field.getDefaultValue();
        }
      }
      return result;
    }
    
    public Builder setField(Descriptors.FieldDescriptor field, Object value)
    {
      verifyContainingType(field);
      ensureIsMutable();
      fields.setField(field, value);
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor field)
    {
      verifyContainingType(field);
      ensureIsMutable();
      fields.clearField(field);
      return this;
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor field)
    {
      verifyContainingType(field);
      return fields.getRepeatedFieldCount(field);
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor field, int index)
    {
      verifyContainingType(field);
      return fields.getRepeatedField(field, index);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value)
    {
      verifyContainingType(field);
      ensureIsMutable();
      fields.setRepeatedField(field, index, value);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value)
    {
      verifyContainingType(field);
      ensureIsMutable();
      fields.addRepeatedField(field, value);
      return this;
    }
    
    public UnknownFieldSet getUnknownFields()
    {
      return unknownFields;
    }
    
    public Builder setUnknownFields(UnknownFieldSet unknownFields)
    {
      this.unknownFields = unknownFields;
      return this;
    }
    
    public Builder mergeUnknownFields(UnknownFieldSet unknownFields)
    {
      this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFields).build();
      
      return this;
    }
    
    private void verifyContainingType(Descriptors.FieldDescriptor field)
    {
      if (field.getContainingType() != type) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    private void ensureIsMutable()
    {
      if (fields.isImmutable()) {
        fields = fields.clone();
      }
    }
    
    public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor field)
    {
      throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DynamicMessage
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */