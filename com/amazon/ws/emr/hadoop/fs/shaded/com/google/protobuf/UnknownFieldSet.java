package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class UnknownFieldSet
  implements MessageLite
{
  private UnknownFieldSet() {}
  
  public static Builder newBuilder()
  {
    return Builder.access$000();
  }
  
  public static Builder newBuilder(UnknownFieldSet copyFrom)
  {
    return newBuilder().mergeFrom(copyFrom);
  }
  
  public static UnknownFieldSet getDefaultInstance()
  {
    return defaultInstance;
  }
  
  public UnknownFieldSet getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  private static final UnknownFieldSet defaultInstance = new UnknownFieldSet(Collections.emptyMap());
  private Map<Integer, Field> fields;
  
  private UnknownFieldSet(Map<Integer, Field> fields)
  {
    this.fields = fields;
  }
  
  public boolean equals(Object other)
  {
    if (this == other) {
      return true;
    }
    return ((other instanceof UnknownFieldSet)) && (fields.equals(fields));
  }
  
  public int hashCode()
  {
    return fields.hashCode();
  }
  
  public Map<Integer, Field> asMap()
  {
    return fields;
  }
  
  public boolean hasField(int number)
  {
    return fields.containsKey(Integer.valueOf(number));
  }
  
  public Field getField(int number)
  {
    Field result = (Field)fields.get(Integer.valueOf(number));
    return result == null ? Field.getDefaultInstance() : result;
  }
  
  public void writeTo(CodedOutputStream output)
    throws IOException
  {
    for (Map.Entry<Integer, Field> entry : fields.entrySet()) {
      ((Field)entry.getValue()).writeTo(((Integer)entry.getKey()).intValue(), output);
    }
  }
  
  public String toString()
  {
    return TextFormat.printToString(this);
  }
  
  public ByteString toByteString()
  {
    try
    {
      ByteString.CodedBuilder out = ByteString.newCodedBuilder(getSerializedSize());
      
      writeTo(out.getCodedOutput());
      return out.build();
    }
    catch (IOException e)
    {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
    }
  }
  
  public byte[] toByteArray()
  {
    try
    {
      byte[] result = new byte[getSerializedSize()];
      CodedOutputStream output = CodedOutputStream.newInstance(result);
      writeTo(output);
      output.checkNoSpaceLeft();
      return result;
    }
    catch (IOException e)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
    }
  }
  
  public void writeTo(OutputStream output)
    throws IOException
  {
    CodedOutputStream codedOutput = CodedOutputStream.newInstance(output);
    writeTo(codedOutput);
    codedOutput.flush();
  }
  
  public void writeDelimitedTo(OutputStream output)
    throws IOException
  {
    CodedOutputStream codedOutput = CodedOutputStream.newInstance(output);
    codedOutput.writeRawVarint32(getSerializedSize());
    writeTo(codedOutput);
    codedOutput.flush();
  }
  
  public int getSerializedSize()
  {
    int result = 0;
    for (Map.Entry<Integer, Field> entry : fields.entrySet()) {
      result += ((Field)entry.getValue()).getSerializedSize(((Integer)entry.getKey()).intValue());
    }
    return result;
  }
  
  public void writeAsMessageSetTo(CodedOutputStream output)
    throws IOException
  {
    for (Map.Entry<Integer, Field> entry : fields.entrySet()) {
      ((Field)entry.getValue()).writeAsMessageSetExtensionTo(((Integer)entry.getKey()).intValue(), output);
    }
  }
  
  public int getSerializedSizeAsMessageSet()
  {
    int result = 0;
    for (Map.Entry<Integer, Field> entry : fields.entrySet()) {
      result += ((Field)entry.getValue()).getSerializedSizeAsMessageSetExtension(((Integer)entry.getKey()).intValue());
    }
    return result;
  }
  
  public boolean isInitialized()
  {
    return true;
  }
  
  public static UnknownFieldSet parseFrom(CodedInputStream input)
    throws IOException
  {
    return newBuilder().mergeFrom(input).build();
  }
  
  public static UnknownFieldSet parseFrom(ByteString data)
    throws InvalidProtocolBufferException
  {
    return newBuilder().mergeFrom(data).build();
  }
  
  public static UnknownFieldSet parseFrom(byte[] data)
    throws InvalidProtocolBufferException
  {
    return newBuilder().mergeFrom(data).build();
  }
  
  public static UnknownFieldSet parseFrom(InputStream input)
    throws IOException
  {
    return newBuilder().mergeFrom(input).build();
  }
  
  public Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public Builder toBuilder()
  {
    return newBuilder().mergeFrom(this);
  }
  
  public static final class Builder
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
        for (Map.Entry<Integer, UnknownFieldSet.Field> entry : fields.entrySet()) {
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
  
  public static final class Field
  {
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(Field copyFrom)
    {
      return newBuilder().mergeFrom(copyFrom);
    }
    
    public static Field getDefaultInstance()
    {
      return fieldDefaultInstance;
    }
    
    private static final Field fieldDefaultInstance = newBuilder().build();
    private List<Long> varint;
    private List<Integer> fixed32;
    private List<Long> fixed64;
    private List<ByteString> lengthDelimited;
    private List<UnknownFieldSet> group;
    
    public List<Long> getVarintList()
    {
      return varint;
    }
    
    public List<Integer> getFixed32List()
    {
      return fixed32;
    }
    
    public List<Long> getFixed64List()
    {
      return fixed64;
    }
    
    public List<ByteString> getLengthDelimitedList()
    {
      return lengthDelimited;
    }
    
    public List<UnknownFieldSet> getGroupList()
    {
      return group;
    }
    
    public boolean equals(Object other)
    {
      if (this == other) {
        return true;
      }
      if (!(other instanceof Field)) {
        return false;
      }
      return Arrays.equals(getIdentityArray(), ((Field)other).getIdentityArray());
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(getIdentityArray());
    }
    
    private Object[] getIdentityArray()
    {
      return new Object[] { varint, fixed32, fixed64, lengthDelimited, group };
    }
    
    public void writeTo(int fieldNumber, CodedOutputStream output)
      throws IOException
    {
      for (Iterator i$ = varint.iterator(); i$.hasNext();)
      {
        long value = ((Long)i$.next()).longValue();
        output.writeUInt64(fieldNumber, value);
      }
      for (Iterator i$ = fixed32.iterator(); i$.hasNext();)
      {
        int value = ((Integer)i$.next()).intValue();
        output.writeFixed32(fieldNumber, value);
      }
      for (Iterator i$ = fixed64.iterator(); i$.hasNext();)
      {
        long value = ((Long)i$.next()).longValue();
        output.writeFixed64(fieldNumber, value);
      }
      for (ByteString value : lengthDelimited) {
        output.writeBytes(fieldNumber, value);
      }
      for (UnknownFieldSet value : group) {
        output.writeGroup(fieldNumber, value);
      }
    }
    
    public int getSerializedSize(int fieldNumber)
    {
      int result = 0;
      for (Iterator i$ = varint.iterator(); i$.hasNext();)
      {
        long value = ((Long)i$.next()).longValue();
        result += CodedOutputStream.computeUInt64Size(fieldNumber, value);
      }
      for (Iterator i$ = fixed32.iterator(); i$.hasNext();)
      {
        int value = ((Integer)i$.next()).intValue();
        result += CodedOutputStream.computeFixed32Size(fieldNumber, value);
      }
      for (Iterator i$ = fixed64.iterator(); i$.hasNext();)
      {
        long value = ((Long)i$.next()).longValue();
        result += CodedOutputStream.computeFixed64Size(fieldNumber, value);
      }
      for (ByteString value : lengthDelimited) {
        result += CodedOutputStream.computeBytesSize(fieldNumber, value);
      }
      for (UnknownFieldSet value : group) {
        result += CodedOutputStream.computeGroupSize(fieldNumber, value);
      }
      return result;
    }
    
    public void writeAsMessageSetExtensionTo(int fieldNumber, CodedOutputStream output)
      throws IOException
    {
      for (ByteString value : lengthDelimited) {
        output.writeRawMessageSetExtension(fieldNumber, value);
      }
    }
    
    public int getSerializedSizeAsMessageSetExtension(int fieldNumber)
    {
      int result = 0;
      for (ByteString value : lengthDelimited) {
        result += CodedOutputStream.computeRawMessageSetExtensionSize(fieldNumber, value);
      }
      return result;
    }
    
    public static final class Builder
    {
      private UnknownFieldSet.Field result;
      
      private static Builder create()
      {
        Builder builder = new Builder();
        result = new UnknownFieldSet.Field(null);
        return builder;
      }
      
      public UnknownFieldSet.Field build()
      {
        if (result.varint == null) {
          result.varint = Collections.emptyList();
        } else {
          result.varint = Collections.unmodifiableList(result.varint);
        }
        if (result.fixed32 == null) {
          result.fixed32 = Collections.emptyList();
        } else {
          result.fixed32 = Collections.unmodifiableList(result.fixed32);
        }
        if (result.fixed64 == null) {
          result.fixed64 = Collections.emptyList();
        } else {
          result.fixed64 = Collections.unmodifiableList(result.fixed64);
        }
        if (result.lengthDelimited == null) {
          result.lengthDelimited = Collections.emptyList();
        } else {
          result.lengthDelimited = Collections.unmodifiableList(result.lengthDelimited);
        }
        if (result.group == null) {
          result.group = Collections.emptyList();
        } else {
          result.group = Collections.unmodifiableList(result.group);
        }
        UnknownFieldSet.Field returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder clear()
      {
        result = new UnknownFieldSet.Field(null);
        return this;
      }
      
      public Builder mergeFrom(UnknownFieldSet.Field other)
      {
        if (!varint.isEmpty())
        {
          if (result.varint == null) {
            result.varint = new ArrayList();
          }
          result.varint.addAll(varint);
        }
        if (!fixed32.isEmpty())
        {
          if (result.fixed32 == null) {
            result.fixed32 = new ArrayList();
          }
          result.fixed32.addAll(fixed32);
        }
        if (!fixed64.isEmpty())
        {
          if (result.fixed64 == null) {
            result.fixed64 = new ArrayList();
          }
          result.fixed64.addAll(fixed64);
        }
        if (!lengthDelimited.isEmpty())
        {
          if (result.lengthDelimited == null) {
            result.lengthDelimited = new ArrayList();
          }
          result.lengthDelimited.addAll(lengthDelimited);
        }
        if (!group.isEmpty())
        {
          if (result.group == null) {
            result.group = new ArrayList();
          }
          result.group.addAll(group);
        }
        return this;
      }
      
      public Builder addVarint(long value)
      {
        if (result.varint == null) {
          result.varint = new ArrayList();
        }
        result.varint.add(Long.valueOf(value));
        return this;
      }
      
      public Builder addFixed32(int value)
      {
        if (result.fixed32 == null) {
          result.fixed32 = new ArrayList();
        }
        result.fixed32.add(Integer.valueOf(value));
        return this;
      }
      
      public Builder addFixed64(long value)
      {
        if (result.fixed64 == null) {
          result.fixed64 = new ArrayList();
        }
        result.fixed64.add(Long.valueOf(value));
        return this;
      }
      
      public Builder addLengthDelimited(ByteString value)
      {
        if (result.lengthDelimited == null) {
          result.lengthDelimited = new ArrayList();
        }
        result.lengthDelimited.add(value);
        return this;
      }
      
      public Builder addGroup(UnknownFieldSet value)
      {
        if (result.group == null) {
          result.group = new ArrayList();
        }
        result.group.add(value);
        return this;
      }
    }
  }
  
  public static final class Parser
    extends AbstractParser<UnknownFieldSet>
  {
    public UnknownFieldSet parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
      throws InvalidProtocolBufferException
    {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      try
      {
        builder.mergeFrom(input);
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
  }
  
  private static final Parser PARSER = new Parser();
  
  public final Parser getParserForType()
  {
    return PARSER;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnknownFieldSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */