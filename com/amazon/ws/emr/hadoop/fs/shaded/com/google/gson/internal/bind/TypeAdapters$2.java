package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSyntaxException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.BitSet;

final class TypeAdapters$2
  extends TypeAdapter<BitSet>
{
  public BitSet read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    BitSet bitset = new BitSet();
    in.beginArray();
    int i = 0;
    JsonToken tokenType = in.peek();
    while (tokenType != JsonToken.END_ARRAY)
    {
      boolean set;
      switch (TypeAdapters.32.$SwitchMap$com$google$gson$stream$JsonToken[tokenType.ordinal()])
      {
      case 1: 
        set = in.nextInt() != 0;
        break;
      case 2: 
        set = in.nextBoolean();
        break;
      case 3: 
        String stringValue = in.nextString();
        try
        {
          set = Integer.parseInt(stringValue) != 0;
        }
        catch (NumberFormatException e)
        {
          throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + stringValue);
        }
      default: 
        throw new JsonSyntaxException("Invalid bitset value type: " + tokenType);
      }
      if (set) {
        bitset.set(i);
      }
      i++;
      tokenType = in.peek();
    }
    in.endArray();
    return bitset;
  }
  
  public void write(JsonWriter out, BitSet src)
    throws IOException
  {
    if (src == null)
    {
      out.nullValue();
      return;
    }
    out.beginArray();
    for (int i = 0; i < src.length(); i++)
    {
      int value = src.get(i) ? 1 : 0;
      out.value(value);
    }
    out.endArray();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */