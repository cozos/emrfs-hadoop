package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import software.amazon.ion.IonWriter;

class SdkIonGenerator$ByteArraySdkIonGenerator
  extends SdkIonGenerator
{
  private final ByteArrayOutputStream bytes;
  
  public SdkIonGenerator$ByteArraySdkIonGenerator(ByteArrayOutputStream bytes, IonWriter writer, String contentType)
  {
    super(writer, contentType, null);
    this.bytes = bytes;
  }
  
  public byte[] getBytes()
  {
    try
    {
      writer.finish();
    }
    catch (IOException e)
    {
      throw new SdkClientException(e);
    }
    return bytes.toByteArray();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkIonGenerator.ByteArraySdkIonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */