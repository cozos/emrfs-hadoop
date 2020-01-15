package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

class ByteStreams$ByteArrayDataInputStream
  implements ByteArrayDataInput
{
  final DataInput input;
  
  ByteStreams$ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream)
  {
    input = new DataInputStream(byteArrayInputStream);
  }
  
  public void readFully(byte[] b)
  {
    try
    {
      input.readFully(b);
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public void readFully(byte[] b, int off, int len)
  {
    try
    {
      input.readFully(b, off, len);
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public int skipBytes(int n)
  {
    try
    {
      return input.skipBytes(n);
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public boolean readBoolean()
  {
    try
    {
      return input.readBoolean();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public byte readByte()
  {
    try
    {
      return input.readByte();
    }
    catch (EOFException e)
    {
      throw new IllegalStateException(e);
    }
    catch (IOException impossible)
    {
      throw new AssertionError(impossible);
    }
  }
  
  public int readUnsignedByte()
  {
    try
    {
      return input.readUnsignedByte();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public short readShort()
  {
    try
    {
      return input.readShort();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public int readUnsignedShort()
  {
    try
    {
      return input.readUnsignedShort();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public char readChar()
  {
    try
    {
      return input.readChar();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public int readInt()
  {
    try
    {
      return input.readInt();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public long readLong()
  {
    try
    {
      return input.readLong();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public float readFloat()
  {
    try
    {
      return input.readFloat();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public double readDouble()
  {
    try
    {
      return input.readDouble();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public String readLine()
  {
    try
    {
      return input.readLine();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public String readUTF()
  {
    try
    {
      return input.readUTF();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteStreams.ByteArrayDataInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */