package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class UnknownFieldSet$Builder
  implements MessageLite.Builder
{
  private Map<Integer, UnknownFieldSet.Field> fields;
  private int lastFieldNumber;
  private UnknownFieldSet.Field.Builder lastField;
  
  private static Builder create()
  {
    Builder builder = new Builder();
    builder.reinitialize();
    return builder;
  }
  
  private UnknownFieldSet.Field.Builder getFieldBuilder(int number)
  {
    if (lastField != null)
    {
      if (number == lastFieldNumber) {
        return lastField;
      }
      addField(lastFieldNumber, lastField.build());
    }
    if (number == 0) {
      return null;
    }
    UnknownFieldSet.Field existing = (UnknownFieldSet.Field)fields.get(Integer.valueOf(number));
    lastFieldNumber = number;
    lastField = UnknownFieldSet.Field.newBuilder();
    if (existing != null) {
      lastField.mergeFrom(existing);
    }
    return lastField;
  }
  
  public UnknownFieldSet build()
  {
    getFieldBuilder(0);
    UnknownFieldSet result;
    UnknownFieldSet result;
    if (fields.isEmpty()) {
      result = UnknownFieldSet.getDefaultInstance();
    } else {
      result = new UnknownFieldSet(Collections.unmodifiableMap(fields), null);
    }
    fields = null;
    return result;
  }
  
  public UnknownFieldSet buildPartial()
  {
    return build();
  }
  
  public Builder clone()
  {
    getFieldBuilder(0);
    return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(fields, null));
  }
  
  public UnknownFieldSet getDefaultInstanceForType()
  {
    return UnknownFieldSet.getDefaultInstance();
  }
  
  private void reinitialize()
  {
    fields = Collections.emptyMap();
    lastFieldNumber = 0;
    lastField = null;
  }
  
  public Builder clear()
  {
    reinitialize();
    return this;
  }
  
  public Builder mergeFrom(UnknownFieldSet other)
  {
    if (other != UnknownFieldSet.getDefaultInstance()) {
      for (Map.Entry<Integer, UnknownFieldSet.Field> entry : UnknownFieldSet.access$200(other).entrySet()) {
        mergeField(((Integer)entry.getKey()).intValue(), (UnknownFieldSet.Field)entry.getValue());
      }
    }
    return this;
  }
  
  public Builder mergeField(int number, UnknownFieldSet.Field field)
  {
    if (number == 0) {
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    if (hasField(number)) {
      getFieldBuilder(number).mergeFrom(field);
    } else {
      addField(number, field);
    }
    return this;
  }
  
  public Builder mergeVarintField(int number, int value)
  {
    if (number == 0) {
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    getFieldBuilder(number).addVarint(value);
    return this;
  }
  
  public boolean hasField(int number)
  {
    if (number == 0) {
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    return (number == lastFieldNumber) || (fields.containsKey(Integer.valueOf(number)));
  }
  
  public Builder addField(int number, UnknownFieldSet.Field field)
  {
    if (number == 0) {
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    if ((lastField != null) && (lastFieldNumber == number))
    {
      lastField = null;
      lastFieldNumber = 0;
    }
    if (fields.isEmpty()) {
      fields = new TreeMap();
    }
    fields.put(Integer.valueOf(number), field);
    return this;
  }
  
  public Map<Integer, UnknownFieldSet.Field> asMap()
  {
    getFieldBuilder(0);
    return Collections.unmodifiableMap(fields);
  }
  
  public Builder mergeFrom(CodedInputStream input)
    throws IOException
  {
    for (;;)
    {
      int tag = input.readTag();
      if ((tag == 0) || (!mergeFieldFrom(tag, input))) {
        break;
      }
    }
    return this;
  }
  
  public boolean mergeFieldFrom(int tag, CodedInputStream input)
    throws IOException
  {
    int number = WireFormat.getTagFieldNumber(tag);
    switch (WireFormat.getTagWireType(tag))
    {
    case 0: 
      getFieldBuilder(number).addVarint(input.readInt64());
      return true;
    case 1: 
      getFieldBuilder(number).addFixed64(input.readFixed64());
      return true;
    case 2: 
      getFieldBuilder(number).addLengthDelimited(input.readBytes());
      return true;
    case 3: 
      Builder subBuilder = UnknownFieldSet.newBuilder();
      input.readGroup(number, subBuilder, ExtensionRegistry.getEmptyRegistry());
      
      getFieldBuilder(number).addGroup(subBuilder.build());
      return true;
    case 4: 
      return false;
    case 5: 
      getFieldBuilder(number).addFixed32(input.readFixed32());
      return true;
    }
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  public Builder mergeFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = data.newCodedInput();
      mergeFrom(input);
      input.checkLastTagWas(0);
      return this;
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
  
  public Builder mergeFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = CodedInputStream.newInstance(data);
      mergeFrom(input);
      input.checkLastTagWas(0);
      return this;
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
  
  public Builder mergeFrom(InputStream input)
    throws IOException
  {
    CodedInputStream codedInput = CodedInputStream.newInstance(input);
    mergeFrom(codedInput);
    codedInput.checkLastTagWas(0);
    return this;
  }
  
  public boolean mergeDelimitedFrom(InputStream input)
    throws IOException
  {
    int firstByte = input.read();
    if (firstByte == -1) {
      return false;
    }
    int size = CodedInputStream.readRawVarint32(firstByte, input);
    InputStream limitedInput = new AbstractMessageLite.Builder.LimitedInputStream(input, size);
    mergeFrom(limitedInput);
    return true;
  }
  
  public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return mergeDelimitedFrom(input);
  }
  
  public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return mergeFrom(input);
  }
  
  public Builder mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return mergeFrom(data);
  }
  
  public Builder mergeFrom(byte[] data, int off, int len)
    throws InvalidProtocolBufferException
  {
    try
    {
      CodedInputStream input = CodedInputStream.newInstance(data, off, len);
      
      mergeFrom(input);
      input.checkLastTagWas(0);
      return this;
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
  
  public Builder mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return mergeFrom(data);
  }
  
  public Builder mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry)
    throws InvalidProtocolBufferException
  {
    return mergeFrom(data, off, len);
  }
  
  public Builder mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    return mergeFrom(input);
  }
  
  public boolean isInitialized()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnknownFieldSet.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */