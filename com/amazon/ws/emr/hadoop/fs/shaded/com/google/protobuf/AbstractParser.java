package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractParser<MessageType extends MessageLite>
  implements Parser<MessageType>
{
  private UninitializedMessageException newUninitializedMessageException(MessageType message)
  {
    if ((message instanceof AbstractMessageLite)) {
      return ((AbstractMessageLite)message).newUninitializedMessageException();
    }
    return new UninitializedMessageException(message);
  }
  
  private MessageType checkMessageInitialized(MessageType message)
    throws InvalidProtocolBufferException
  {
    if ((message != null) && (!message.isInitialized())) {
      throw newUninitializedMessageException(message).asInvalidProtocolBufferException().setUnfinishedMessage(message);
    }
    return message;
  }
  
  private static final ExtensionRegistryLite EMPTY_REGISTRY = ;
  
  public MessageType parsePartialFrom(CodedInputStream input)
    throws InvalidProtocolBufferException
  {
    return (MessageLite)parsePartialFrom(input, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized((MessageLite)parsePartialFrom(input, extensionRegistry));
  }
  
  public MessageType parseFrom(CodedInputStream input)
    throws InvalidProtocolBufferException
  {
    return parseFrom(input, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = data.newCodedInput();
      MessageType message = (MessageLite)parsePartialFrom(input, extensionRegistry);
      try
      {
        input.checkLastTagWas(0);
      }
      catch (InvalidProtocolBufferException e)
      {
        throw e.setUnfinishedMessage(message);
      }
      return message;
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
    }
  }
  
  public MessageType parsePartialFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(data, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized(parsePartialFrom(data, extensionRegistry));
  }
  
  public MessageType parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return parseFrom(data, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = CodedInputStream.newInstance(data, off, len);
      MessageType message = (MessageLite)parsePartialFrom(input, extensionRegistry);
      try
      {
        input.checkLastTagWas(0);
      }
      catch (InvalidProtocolBufferException e)
      {
        throw e.setUnfinishedMessage(message);
      }
      return message;
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e;
    }
    catch (IOException e)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
    }
  }
  
  public MessageType parsePartialFrom(byte[] data, int off, int len)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(data, off, len, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(data, 0, data.length, extensionRegistry);
  }
  
  public MessageType parsePartialFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(data, 0, data.length, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized(parsePartialFrom(data, off, len, extensionRegistry));
  }
  
  public MessageType parseFrom(byte[] data, int off, int len)
    throws InvalidProtocolBufferException
  {
    return parseFrom(data, off, len, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return parseFrom(data, 0, data.length, extensionRegistry);
  }
  
  public MessageType parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return parseFrom(data, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    CodedInputStream codedInput = CodedInputStream.newInstance(input);
    MessageType message = (MessageLite)parsePartialFrom(codedInput, extensionRegistry);
    try
    {
      codedInput.checkLastTagWas(0);
    }
    catch (InvalidProtocolBufferException e)
    {
      throw e.setUnfinishedMessage(message);
    }
    return message;
  }
  
  public MessageType parsePartialFrom(InputStream input)
    throws InvalidProtocolBufferException
  {
    return parsePartialFrom(input, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized(parsePartialFrom(input, extensionRegistry));
  }
  
  public MessageType parseFrom(InputStream input)
    throws InvalidProtocolBufferException
  {
    return parseFrom(input, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    int size;
    try
    {
      int firstByte = input.read();
      if (firstByte == -1) {
        return null;
      }
      size = CodedInputStream.readRawVarint32(firstByte, input);
    }
    catch (IOException e)
    {
      throw new InvalidProtocolBufferException(e.getMessage());
    }
    InputStream limitedInput = new AbstractMessageLite.Builder.LimitedInputStream(input, size);
    return parsePartialFrom(limitedInput, extensionRegistry);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream input)
    throws InvalidProtocolBufferException
  {
    return parsePartialDelimitedFrom(input, EMPTY_REGISTRY);
  }
  
  public MessageType parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return checkMessageInitialized(parsePartialDelimitedFrom(input, extensionRegistry));
  }
  
  public MessageType parseDelimitedFrom(InputStream input)
    throws InvalidProtocolBufferException
  {
    return parseDelimitedFrom(input, EMPTY_REGISTRY);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.AbstractParser
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */