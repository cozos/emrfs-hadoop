package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.net.InetAddress;

public class InetAddressSerializer
  extends StdScalarSerializer<InetAddress>
{
  public InetAddressSerializer()
  {
    super(InetAddress.class);
  }
  
  public void serialize(InetAddress value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    String str = value.toString().trim();
    int ix = str.indexOf('/');
    if (ix >= 0) {
      if (ix == 0) {
        str = str.substring(1);
      } else {
        str = str.substring(0, ix);
      }
    }
    jgen.writeString(str);
  }
  
  public void serializeWithType(InetAddress value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException, JsonGenerationException
  {
    typeSer.writeTypePrefixForScalar(value, jgen, InetAddress.class);
    serialize(value, jgen, provider);
    typeSer.writeTypeSuffixForScalar(value, jgen);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.InetAddressSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */