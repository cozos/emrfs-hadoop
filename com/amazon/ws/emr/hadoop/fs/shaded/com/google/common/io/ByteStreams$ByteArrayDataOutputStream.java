package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

class ByteStreams$ByteArrayDataOutputStream
  implements ByteArrayDataOutput
{
  final DataOutput output;
  final ByteArrayOutputStream byteArrayOutputSteam;
  
  ByteStreams$ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputSteam)
  {
    this.byteArrayOutputSteam = byteArrayOutputSteam;
    output = new DataOutputStream(byteArrayOutputSteam);
  }
  
  public void write(int b)
  {
    try
    {
      output.write(b);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void write(byte[] b)
  {
    try
    {
      output.write(b);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void write(byte[] b, int off, int len)
  {
    try
    {
      output.write(b, off, len);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeBoolean(boolean v)
  {
    try
    {
      output.writeBoolean(v);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeByte(int v)
  {
    try
    {
      output.writeByte(v);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeBytes(String s)
  {
    try
    {
      output.writeBytes(s);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeChar(int v)
  {
    try
    {
      output.writeChar(v);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeChars(String s)
  {
    try
    {
      output.writeChars(s);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeDouble(double v)
  {
    try
    {
      output.writeDouble(v);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeFloat(float v)
  {
    try
    {
      output.writeFloat(v);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeInt(int v)
  {
    try
    {
      output.writeInt(v);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeLong(long v)
  {
    try
    {
      output.writeLong(v);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeShort(int v)
  {
    try
    {
      output.writeShort(v);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public void writeUTF(String s)
  {
    try
    {
      output.writeUTF(s);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public byte[] toByteArray()
  {
    return byteArrayOutputSteam.toByteArray();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteStreams.ByteArrayDataOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */