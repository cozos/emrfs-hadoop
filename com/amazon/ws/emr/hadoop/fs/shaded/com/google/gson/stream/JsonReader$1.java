package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.JsonReaderInternalAccess;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.JsonTreeReader;
import java.io.IOException;

final class JsonReader$1
  extends JsonReaderInternalAccess
{
  public void promoteNameToValue(JsonReader reader)
    throws IOException
  {
    if ((reader instanceof JsonTreeReader))
    {
      ((JsonTreeReader)reader).promoteNameToValue();
      return;
    }
    int p = JsonReader.access$000(reader);
    if (p == 0) {
      p = JsonReader.access$100(reader);
    }
    if (p == 13) {
      JsonReader.access$002(reader, 9);
    } else if (p == 12) {
      JsonReader.access$002(reader, 8);
    } else if (p == 14) {
      JsonReader.access$002(reader, 10);
    } else {
      throw new IllegalStateException("Expected a name but was " + reader.peek() + " " + " at line " + JsonReader.access$200(reader) + " column " + JsonReader.access$300(reader));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */