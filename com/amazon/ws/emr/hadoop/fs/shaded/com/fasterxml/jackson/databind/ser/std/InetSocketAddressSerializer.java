package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketAddressSerializer
  extends StdScalarSerializer<InetSocketAddress>
{
  public InetSocketAddressSerializer()
  {
    super(InetSocketAddress.class);
  }
  
  public void serialize(InetSocketAddress value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    InetAddress addr = value.getAddress();
    String str = addr == null ? value.getHostName() : addr.toString().trim();
    int ix = str.indexOf('/');
    if (ix >= 0) {
      if (ix == 0) {
        str = (addr instanceof Inet6Address) ? "[" + str.substring(1) + "]" : str.substring(1);
      } else {
        str = str.substring(0, ix);
      }
    }
    jgen.writeString(str + ":" + value.getPort());
  }
  
  public void serializeWithType(InetSocketAddress value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException, JsonGenerationException
  {
    typeSer.writeTypePrefixForScalar(value, jgen, InetSocketAddress.class);
    serialize(value, jgen, provider);
    typeSer.writeTypeSuffixForScalar(value, jgen);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */