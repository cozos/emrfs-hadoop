package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UnknownFieldSet$Field$Builder
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
    if (UnknownFieldSet.Field.access$500(result) == null) {
      UnknownFieldSet.Field.access$502(result, Collections.emptyList());
    } else {
      UnknownFieldSet.Field.access$502(result, Collections.unmodifiableList(UnknownFieldSet.Field.access$500(result)));
    }
    if (UnknownFieldSet.Field.access$600(result) == null) {
      UnknownFieldSet.Field.access$602(result, Collections.emptyList());
    } else {
      UnknownFieldSet.Field.access$602(result, Collections.unmodifiableList(UnknownFieldSet.Field.access$600(result)));
    }
    if (UnknownFieldSet.Field.access$700(result) == null) {
      UnknownFieldSet.Field.access$702(result, Collections.emptyList());
    } else {
      UnknownFieldSet.Field.access$702(result, Collections.unmodifiableList(UnknownFieldSet.Field.access$700(result)));
    }
    if (UnknownFieldSet.Field.access$800(result) == null) {
      UnknownFieldSet.Field.access$802(result, Collections.emptyList());
    } else {
      UnknownFieldSet.Field.access$802(result, Collections.unmodifiableList(UnknownFieldSet.Field.access$800(result)));
    }
    if (UnknownFieldSet.Field.access$900(result) == null) {
      UnknownFieldSet.Field.access$902(result, Collections.emptyList());
    } else {
      UnknownFieldSet.Field.access$902(result, Collections.unmodifiableList(UnknownFieldSet.Field.access$900(result)));
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
    if (!UnknownFieldSet.Field.access$500(other).isEmpty())
    {
      if (UnknownFieldSet.Field.access$500(result) == null) {
        UnknownFieldSet.Field.access$502(result, new ArrayList());
      }
      UnknownFieldSet.Field.access$500(result).addAll(UnknownFieldSet.Field.access$500(other));
    }
    if (!UnknownFieldSet.Field.access$600(other).isEmpty())
    {
      if (UnknownFieldSet.Field.access$600(result) == null) {
        UnknownFieldSet.Field.access$602(result, new ArrayList());
      }
      UnknownFieldSet.Field.access$600(result).addAll(UnknownFieldSet.Field.access$600(other));
    }
    if (!UnknownFieldSet.Field.access$700(other).isEmpty())
    {
      if (UnknownFieldSet.Field.access$700(result) == null) {
        UnknownFieldSet.Field.access$702(result, new ArrayList());
      }
      UnknownFieldSet.Field.access$700(result).addAll(UnknownFieldSet.Field.access$700(other));
    }
    if (!UnknownFieldSet.Field.access$800(other).isEmpty())
    {
      if (UnknownFieldSet.Field.access$800(result) == null) {
        UnknownFieldSet.Field.access$802(result, new ArrayList());
      }
      UnknownFieldSet.Field.access$800(result).addAll(UnknownFieldSet.Field.access$800(other));
    }
    if (!UnknownFieldSet.Field.access$900(other).isEmpty())
    {
      if (UnknownFieldSet.Field.access$900(result) == null) {
        UnknownFieldSet.Field.access$902(result, new ArrayList());
      }
      UnknownFieldSet.Field.access$900(result).addAll(UnknownFieldSet.Field.access$900(other));
    }
    return this;
  }
  
  public Builder addVarint(long value)
  {
    if (UnknownFieldSet.Field.access$500(result) == null) {
      UnknownFieldSet.Field.access$502(result, new ArrayList());
    }
    UnknownFieldSet.Field.access$500(result).add(Long.valueOf(value));
    return this;
  }
  
  public Builder addFixed32(int value)
  {
    if (UnknownFieldSet.Field.access$600(result) == null) {
      UnknownFieldSet.Field.access$602(result, new ArrayList());
    }
    UnknownFieldSet.Field.access$600(result).add(Integer.valueOf(value));
    return this;
  }
  
  public Builder addFixed64(long value)
  {
    if (UnknownFieldSet.Field.access$700(result) == null) {
      UnknownFieldSet.Field.access$702(result, new ArrayList());
    }
    UnknownFieldSet.Field.access$700(result).add(Long.valueOf(value));
    return this;
  }
  
  public Builder addLengthDelimited(ByteString value)
  {
    if (UnknownFieldSet.Field.access$800(result) == null) {
      UnknownFieldSet.Field.access$802(result, new ArrayList());
    }
    UnknownFieldSet.Field.access$800(result).add(value);
    return this;
  }
  
  public Builder addGroup(UnknownFieldSet value)
  {
    if (UnknownFieldSet.Field.access$900(result) == null) {
      UnknownFieldSet.Field.access$902(result, new ArrayList());
    }
    UnknownFieldSet.Field.access$900(result).add(value);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnknownFieldSet.Field.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */