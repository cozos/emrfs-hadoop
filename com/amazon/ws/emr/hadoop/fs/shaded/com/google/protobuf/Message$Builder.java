package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public abstract interface Message$Builder
  extends MessageLite.Builder, MessageOrBuilder
{
  public abstract Builder clear();
  
  public abstract Builder mergeFrom(Message paramMessage);
  
  public abstract Message build();
  
  public abstract Message buildPartial();
  
  public abstract Builder clone();
  
  public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream)
    throws IOException;
  
  public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException;
  
  public abstract Descriptors.Descriptor getDescriptorForType();
  
  public abstract Builder newBuilderForField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract Builder getFieldBuilder(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract Builder setField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject);
  
  public abstract Builder clearField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract Builder setRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject);
  
  public abstract Builder addRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject);
  
  public abstract Builder setUnknownFields(UnknownFieldSet paramUnknownFieldSet);
  
  public abstract Builder mergeUnknownFields(UnknownFieldSet paramUnknownFieldSet);
  
  public abstract Builder mergeFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException;
  
  public abstract Builder mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract Builder mergeFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException;
  
  public abstract Builder mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferException;
  
  public abstract Builder mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract Builder mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract Builder mergeFrom(InputStream paramInputStream)
    throws IOException;
  
  public abstract Builder mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException;
  
  public abstract boolean mergeDelimitedFrom(InputStream paramInputStream)
    throws IOException;
  
  public abstract boolean mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Message.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */