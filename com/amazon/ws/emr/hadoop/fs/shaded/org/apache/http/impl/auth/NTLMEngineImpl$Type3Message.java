package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Locale;
import java.util.Random;

class NTLMEngineImpl$Type3Message
  extends NTLMEngineImpl.NTLMMessage
{
  protected final byte[] type1Message;
  protected final byte[] type2Message;
  protected final int type2Flags;
  protected final byte[] domainBytes;
  protected final byte[] hostBytes;
  protected final byte[] userBytes;
  protected byte[] lmResp;
  protected byte[] ntResp;
  protected final byte[] sessionKey;
  protected final byte[] exportedSessionKey;
  protected final boolean computeMic;
  
  NTLMEngineImpl$Type3Message(String domain, String host, String user, String password, byte[] nonce, int type2Flags, String target, byte[] targetInformation)
    throws NTLMEngineException
  {
    this(domain, host, user, password, nonce, type2Flags, target, targetInformation, null, null, null);
  }
  
  NTLMEngineImpl$Type3Message(Random random, long currentTime, String domain, String host, String user, String password, byte[] nonce, int type2Flags, String target, byte[] targetInformation)
    throws NTLMEngineException
  {
    this(random, currentTime, domain, host, user, password, nonce, type2Flags, target, targetInformation, null, null, null);
  }
  
  NTLMEngineImpl$Type3Message(String domain, String host, String user, String password, byte[] nonce, int type2Flags, String target, byte[] targetInformation, Certificate peerServerCertificate, byte[] type1Message, byte[] type2Message)
    throws NTLMEngineException
  {
    this(NTLMEngineImpl.access$000(), System.currentTimeMillis(), domain, host, user, password, nonce, type2Flags, target, targetInformation, peerServerCertificate, type1Message, type2Message);
  }
  
  NTLMEngineImpl$Type3Message(Random random, long currentTime, String domain, String host, String user, String password, byte[] nonce, int type2Flags, String target, byte[] targetInformation, Certificate peerServerCertificate, byte[] type1Message, byte[] type2Message)
    throws NTLMEngineException
  {
    if (random == null) {
      throw new NTLMEngineException("Random generator not available");
    }
    this.type2Flags = type2Flags;
    this.type1Message = type1Message;
    this.type2Message = type2Message;
    
    String unqualifiedHost = NTLMEngineImpl.access$2200(host);
    
    String unqualifiedDomain = NTLMEngineImpl.access$2300(domain);
    
    byte[] responseTargetInformation = targetInformation;
    if (peerServerCertificate != null)
    {
      responseTargetInformation = addGssMicAvsToTargetInfo(targetInformation, peerServerCertificate);
      computeMic = true;
    }
    else
    {
      computeMic = false;
    }
    NTLMEngineImpl.CipherGen gen = new NTLMEngineImpl.CipherGen(random, currentTime, unqualifiedDomain, user, password, nonce, target, responseTargetInformation);
    byte[] userSessionKey;
    try
    {
      byte[] userSessionKey;
      if (((type2Flags & 0x800000) != 0) && (targetInformation != null) && (target != null))
      {
        ntResp = gen.getNTLMv2Response();
        lmResp = gen.getLMv2Response();
        byte[] userSessionKey;
        if ((type2Flags & 0x80) != 0) {
          userSessionKey = gen.getLanManagerSessionKey();
        } else {
          userSessionKey = gen.getNTLMv2UserSessionKey();
        }
      }
      else
      {
        byte[] userSessionKey;
        if ((type2Flags & 0x80000) != 0)
        {
          ntResp = gen.getNTLM2SessionResponse();
          lmResp = gen.getLM2SessionResponse();
          byte[] userSessionKey;
          if ((type2Flags & 0x80) != 0) {
            userSessionKey = gen.getLanManagerSessionKey();
          } else {
            userSessionKey = gen.getNTLM2SessionResponseUserSessionKey();
          }
        }
        else
        {
          ntResp = gen.getNTLMResponse();
          lmResp = gen.getLMResponse();
          byte[] userSessionKey;
          if ((type2Flags & 0x80) != 0) {
            userSessionKey = gen.getLanManagerSessionKey();
          } else {
            userSessionKey = gen.getNTLMUserSessionKey();
          }
        }
      }
    }
    catch (NTLMEngineException e)
    {
      byte[] userSessionKey;
      ntResp = new byte[0];
      lmResp = gen.getLMResponse();
      if ((type2Flags & 0x80) != 0) {
        userSessionKey = gen.getLanManagerSessionKey();
      } else {
        userSessionKey = gen.getLMUserSessionKey();
      }
    }
    if ((type2Flags & 0x10) != 0)
    {
      if ((type2Flags & 0x40000000) != 0)
      {
        exportedSessionKey = gen.getSecondaryKey();
        sessionKey = NTLMEngineImpl.RC4(exportedSessionKey, userSessionKey);
      }
      else
      {
        sessionKey = userSessionKey;
        exportedSessionKey = sessionKey;
      }
    }
    else
    {
      if (computeMic) {
        throw new NTLMEngineException("Cannot sign/seal: no exported session key");
      }
      sessionKey = null;
      exportedSessionKey = null;
    }
    Charset charset = NTLMEngineImpl.access$2500(type2Flags);
    hostBytes = (unqualifiedHost != null ? unqualifiedHost.getBytes(charset) : null);
    domainBytes = (unqualifiedDomain != null ? unqualifiedDomain.toUpperCase(Locale.ROOT).getBytes(charset) : null);
    
    userBytes = user.getBytes(charset);
  }
  
  public byte[] getEncryptedRandomSessionKey()
  {
    return sessionKey;
  }
  
  public byte[] getExportedSessionKey()
  {
    return exportedSessionKey;
  }
  
  protected void buildMessage()
  {
    int ntRespLen = ntResp.length;
    int lmRespLen = lmResp.length;
    
    int domainLen = domainBytes != null ? domainBytes.length : 0;
    int hostLen = hostBytes != null ? hostBytes.length : 0;
    int userLen = userBytes.length;
    int sessionKeyLen;
    int sessionKeyLen;
    if (sessionKey != null) {
      sessionKeyLen = sessionKey.length;
    } else {
      sessionKeyLen = 0;
    }
    int lmRespOffset = 72 + (computeMic ? 16 : 0);
    
    int ntRespOffset = lmRespOffset + lmRespLen;
    int domainOffset = ntRespOffset + ntRespLen;
    int userOffset = domainOffset + domainLen;
    int hostOffset = userOffset + userLen;
    int sessionKeyOffset = hostOffset + hostLen;
    int finalLength = sessionKeyOffset + sessionKeyLen;
    
    prepareResponse(finalLength, 3);
    
    addUShort(lmRespLen);
    addUShort(lmRespLen);
    
    addULong(lmRespOffset);
    
    addUShort(ntRespLen);
    addUShort(ntRespLen);
    
    addULong(ntRespOffset);
    
    addUShort(domainLen);
    addUShort(domainLen);
    
    addULong(domainOffset);
    
    addUShort(userLen);
    addUShort(userLen);
    
    addULong(userOffset);
    
    addUShort(hostLen);
    addUShort(hostLen);
    
    addULong(hostOffset);
    
    addUShort(sessionKeyLen);
    addUShort(sessionKeyLen);
    
    addULong(sessionKeyOffset);
    
    addULong(type2Flags);
    
    addUShort(261);
    
    addULong(2600);
    
    addUShort(3840);
    
    int micPosition = -1;
    if (computeMic)
    {
      micPosition = currentOutputPosition;
      currentOutputPosition += 16;
    }
    addBytes(lmResp);
    addBytes(ntResp);
    addBytes(domainBytes);
    addBytes(userBytes);
    addBytes(hostBytes);
    if (sessionKey != null) {
      addBytes(sessionKey);
    }
    if (computeMic)
    {
      NTLMEngineImpl.HMACMD5 hmacMD5 = new NTLMEngineImpl.HMACMD5(exportedSessionKey);
      hmacMD5.update(type1Message);
      hmacMD5.update(type2Message);
      hmacMD5.update(messageContents);
      byte[] mic = hmacMD5.getOutput();
      System.arraycopy(mic, 0, messageContents, micPosition, mic.length);
    }
  }
  
  private byte[] addGssMicAvsToTargetInfo(byte[] originalTargetInfo, Certificate peerServerCertificate)
    throws NTLMEngineException
  {
    byte[] newTargetInfo = new byte[originalTargetInfo.length + 8 + 20];
    int appendLength = originalTargetInfo.length - 4;
    System.arraycopy(originalTargetInfo, 0, newTargetInfo, 0, appendLength);
    NTLMEngineImpl.writeUShort(newTargetInfo, 6, appendLength);
    NTLMEngineImpl.writeUShort(newTargetInfo, 4, appendLength + 2);
    NTLMEngineImpl.writeULong(newTargetInfo, 2, appendLength + 4);
    NTLMEngineImpl.writeUShort(newTargetInfo, 10, appendLength + 8);
    NTLMEngineImpl.writeUShort(newTargetInfo, 16, appendLength + 10);
    byte[] channelBindingsHash;
    try
    {
      byte[] certBytes = peerServerCertificate.getEncoded();
      MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
      byte[] certHashBytes = sha256.digest(certBytes);
      byte[] channelBindingStruct = new byte[20 + NTLMEngineImpl.access$2600().length + certHashBytes.length];
      
      NTLMEngineImpl.writeULong(channelBindingStruct, 53, 16);
      System.arraycopy(NTLMEngineImpl.access$2600(), 0, channelBindingStruct, 20, NTLMEngineImpl.access$2600().length);
      
      System.arraycopy(certHashBytes, 0, channelBindingStruct, 20 + NTLMEngineImpl.access$2600().length, certHashBytes.length);
      
      MessageDigest md5 = NTLMEngineImpl.getMD5();
      channelBindingsHash = md5.digest(channelBindingStruct);
    }
    catch (CertificateEncodingException e)
    {
      throw new NTLMEngineException(e.getMessage(), e);
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new NTLMEngineException(e.getMessage(), e);
    }
    System.arraycopy(channelBindingsHash, 0, newTargetInfo, appendLength + 12, 16);
    return newTargetInfo;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl.Type3Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */