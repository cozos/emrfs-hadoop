package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;

class NTLMEngineImpl$Type2Message
  extends NTLMEngineImpl.NTLMMessage
{
  protected final byte[] challenge;
  protected String target;
  protected byte[] targetInfo;
  protected final int flags;
  
  NTLMEngineImpl$Type2Message(String messageBody)
    throws NTLMEngineException
  {
    this(Base64.decodeBase64(messageBody.getBytes(NTLMEngineImpl.access$1700())));
  }
  
  NTLMEngineImpl$Type2Message(byte[] message)
    throws NTLMEngineException
  {
    super(message, 2);
    
    challenge = new byte[8];
    readBytes(challenge, 24);
    
    flags = readULong(20);
    
    target = null;
    if (getMessageLength() >= 20)
    {
      byte[] bytes = readSecurityBuffer(12);
      if (bytes.length != 0) {
        target = new String(bytes, NTLMEngineImpl.access$2500(flags));
      }
    }
    targetInfo = null;
    if (getMessageLength() >= 48)
    {
      byte[] bytes = readSecurityBuffer(40);
      if (bytes.length != 0) {
        targetInfo = bytes;
      }
    }
  }
  
  byte[] getChallenge()
  {
    return challenge;
  }
  
  String getTarget()
  {
    return target;
  }
  
  byte[] getTargetInfo()
  {
    return targetInfo;
  }
  
  int getFlags()
  {
    return flags;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl.Type2Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */