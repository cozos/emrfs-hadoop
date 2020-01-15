package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.InputStream;

public abstract interface Parser<MessageType>
{
  public abstract MessageType parseFrom(CodedInputStream paramCodedInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(CodedInputStream paramCodedInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(ByteString paramByteString)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialDelimitedFrom(InputStream paramInputStream)
    throws InvalidProtocolBufferException;
  
  public abstract MessageType parsePartialDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws InvalidProtocolBufferException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Parser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */