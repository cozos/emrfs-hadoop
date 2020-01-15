package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.List;
import java.util.Map;

public abstract interface MessageOrBuilder
  extends MessageLiteOrBuilder
{
  public abstract Message getDefaultInstanceForType();
  
  public abstract List<String> findInitializationErrors();
  
  public abstract String getInitializationErrorString();
  
  public abstract Descriptors.Descriptor getDescriptorForType();
  
  public abstract Map<Descriptors.FieldDescriptor, Object> getAllFields();
  
  public abstract boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract Object getField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt);
  
  public abstract UnknownFieldSet getUnknownFields();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.MessageOrBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */