package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.Map;

public final class DynamicMessage$Builder
  extends AbstractMessage.Builder<Builder>
{
  private final Descriptors.Descriptor type;
  private FieldSet<Descriptors.FieldDescriptor> fields;
  private UnknownFieldSet unknownFields;
  
  private DynamicMessage$Builder(Descriptors.Descriptor type)
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
      if (DynamicMessage.access$200(otherDynamicMessage) != type) {
        throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      }
      ensureIsMutable();
      fields.mergeFrom(DynamicMessage.access$300(otherDynamicMessage));
      mergeUnknownFields(DynamicMessage.access$400(otherDynamicMessage));
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
    return DynamicMessage.access$600(type, fields);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.DynamicMessage.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */