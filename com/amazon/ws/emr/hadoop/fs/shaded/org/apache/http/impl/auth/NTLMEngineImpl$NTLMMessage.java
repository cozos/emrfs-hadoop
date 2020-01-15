package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;

class NTLMEngineImpl$NTLMMessage
{
  protected byte[] messageContents = null;
  protected int currentOutputPosition = 0;
  
  NTLMEngineImpl$NTLMMessage() {}
  
  NTLMEngineImpl$NTLMMessage(String messageBody, int expectedType)
    throws NTLMEngineException
  {
    this(Base64.decodeBase64(messageBody.getBytes(NTLMEngineImpl.access$1700())), expectedType);
  }
  
  NTLMEngineImpl$NTLMMessage(byte[] message, int expectedType)
    throws NTLMEngineException
  {
    messageContents = message;
    if (messageContents.length < NTLMEngineImpl.access$1800().length) {
      throw new NTLMEngineException("NTLM message decoding error - packet too short");
    }
    int i = 0;
    while (i < NTLMEngineImpl.access$1800().length)
    {
      if (messageContents[i] != NTLMEngineImpl.access$1800()[i]) {
        throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
      }
      i++;
    }
    int type = readULong(NTLMEngineImpl.access$1800().length);
    if (type != expectedType) {
      throw new NTLMEngineException("NTLM type " + Integer.toString(expectedType) + " message expected - instead got type " + Integer.toString(type));
    }
    currentOutputPosition = messageContents.length;
  }
  
  protected int getPreambleLength()
  {
    return NTLMEngineImpl.access$1800().length + 4;
  }
  
  protected int getMessageLength()
  {
    return currentOutputPosition;
  }
  
  protected byte readByte(int position)
    throws NTLMEngineException
  {
    if (messageContents.length < position + 1) {
      throw new NTLMEngineException("NTLM: Message too short");
    }
    return messageContents[position];
  }
  
  protected void readBytes(byte[] buffer, int position)
    throws NTLMEngineException
  {
    if (messageContents.length < position + buffer.length) {
      throw new NTLMEngineException("NTLM: Message too short");
    }
    System.arraycopy(messageContents, position, buffer, 0, buffer.length);
  }
  
  protected int readUShort(int position)
    throws NTLMEngineException
  {
    return NTLMEngineImpl.access$1900(messageContents, position);
  }
  
  protected int readULong(int position)
    throws NTLMEngineException
  {
    return NTLMEngineImpl.access$2000(messageContents, position);
  }
  
  protected byte[] readSecurityBuffer(int position)
    throws NTLMEngineException
  {
    return NTLMEngineImpl.access$2100(messageContents, position);
  }
  
  protected void prepareResponse(int maxlength, int messageType)
  {
    messageContents = new byte[maxlength];
    currentOutputPosition = 0;
    addBytes(NTLMEngineImpl.access$1800());
    addULong(messageType);
  }
  
  protected void addByte(byte b)
  {
    messageContents[currentOutputPosition] = b;
    currentOutputPosition += 1;
  }
  
  protected void addBytes(byte[] bytes)
  {
    if (bytes == null) {
      return;
    }
    for (byte b : bytes)
    {
      messageContents[currentOutputPosition] = b;
      currentOutputPosition += 1;
    }
  }
  
  protected void addUShort(int value)
  {
    addByte((byte)(value & 0xFF));
    addByte((byte)(value >> 8 & 0xFF));
  }
  
  protected void addULong(int value)
  {
    addByte((byte)(value & 0xFF));
    addByte((byte)(value >> 8 & 0xFF));
    addByte((byte)(value >> 16 & 0xFF));
    addByte((byte)(value >> 24 & 0xFF));
  }
  
  public String getResponse()
  {
    return new String(Base64.encodeBase64(getBytes()), Consts.ASCII);
  }
  
  public byte[] getBytes()
  {
    if (messageContents == null) {
      buildMessage();
    }
    if (messageContents.length > currentOutputPosition)
    {
      byte[] tmp = new byte[currentOutputPosition];
      System.arraycopy(messageContents, 0, tmp, 0, currentOutputPosition);
      messageContents = tmp;
    }
    return messageContents;
  }
  
  protected void buildMessage()
  {
    throw new RuntimeException("Message builder not implemented for " + getClass().getName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl.NTLMMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */