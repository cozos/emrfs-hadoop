package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public abstract interface MessageLite$Builder
  extends MessageLiteOrBuilder, Cloneable
{
  public abstract Builder clear();
  
  public abstract MessageLite build();
  
  public abstract MessageLite buildPartial();
  
  public abstract Builder clone();
  
  public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream)
    throws IOException;
  
  public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
    throws IOException;
  
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.MessageLite.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */