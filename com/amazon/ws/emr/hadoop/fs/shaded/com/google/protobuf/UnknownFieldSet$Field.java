package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class UnknownFieldSet$Field
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnknownFieldSet.Field
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */