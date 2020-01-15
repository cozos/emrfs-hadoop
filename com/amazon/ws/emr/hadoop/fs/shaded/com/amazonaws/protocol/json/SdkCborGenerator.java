package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import java.io.IOException;
import java.util.Date;

@SdkInternalApi
class SdkCborGenerator
  extends SdkJsonGenerator
{
  private static final int CBOR_TAG_TIMESTAP = 1;
  
  public SdkCborGenerator(JsonFactory factory, String contentType)
  {
    super(factory, contentType);
  }
  
  public StructuredJsonGenerator writeValue(Date date, TimestampFormat timestampFormat)
  {
    if (!(getGenerator() instanceof CBORGenerator)) {
      throw new IllegalStateException("SdkCborGenerator is not created with a CBORGenerator.");
    }
    CBORGenerator generator = (CBORGenerator)getGenerator();
    try
    {
      generator.writeTag(1);
      generator.writeNumber(date.getTime());
    }
    catch (IOException e)
    {
      throw new SdkJsonGenerator.JsonGenerationException(e);
    }
    return this;
  }
  
  public byte[] getBytes()
  {
    try
    {
      return super.getBytes();
    }
    catch (NoSuchMethodError e)
    {
      throw new RuntimeException("Jackson jackson-core/jackson-dataformat-cbor incompatible library version detected.\nYou have two possible resolutions:\n\t\t1) Ensure the com.fasterxml.jackson.core:jackson-core & com.fasterxml.jackson.dataformat:jackson-dataformat-cbor libraries on your classpath have the same version number\n\t\t2) Disable CBOR wire-protocol by passing the -Dcom.amazonaws.sdk.disableCbor property or setting the AWS_CBOR_DISABLE environment variable (warning this may affect performance)", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkCborGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */