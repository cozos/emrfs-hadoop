package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import java.security.Key;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.Cipher;

public class NTLMEngineImpl$CipherGen
{
  protected final Random random;
  protected final long currentTime;
  protected final String domain;
  protected final String user;
  protected final String password;
  protected final byte[] challenge;
  protected final String target;
  protected final byte[] targetInformation;
  protected byte[] clientChallenge;
  protected byte[] clientChallenge2;
  protected byte[] secondaryKey;
  protected byte[] timestamp;
  protected byte[] lmHash = null;
  protected byte[] lmResponse = null;
  protected byte[] ntlmHash = null;
  protected byte[] ntlmResponse = null;
  protected byte[] ntlmv2Hash = null;
  protected byte[] lmv2Hash = null;
  protected byte[] lmv2Response = null;
  protected byte[] ntlmv2Blob = null;
  protected byte[] ntlmv2Response = null;
  protected byte[] ntlm2SessionResponse = null;
  protected byte[] lm2SessionResponse = null;
  protected byte[] lmUserSessionKey = null;
  protected byte[] ntlmUserSessionKey = null;
  protected byte[] ntlmv2UserSessionKey = null;
  protected byte[] ntlm2SessionResponseUserSessionKey = null;
  protected byte[] lanManagerSessionKey = null;
  
  @Deprecated
  public NTLMEngineImpl$CipherGen(String domain, String user, String password, byte[] challenge, String target, byte[] targetInformation, byte[] clientChallenge, byte[] clientChallenge2, byte[] secondaryKey, byte[] timestamp)
  {
    this(NTLMEngineImpl.access$000(), System.currentTimeMillis(), domain, user, password, challenge, target, targetInformation, clientChallenge, clientChallenge2, secondaryKey, timestamp);
  }
  
  public NTLMEngineImpl$CipherGen(Random random, long currentTime, String domain, String user, String password, byte[] challenge, String target, byte[] targetInformation, byte[] clientChallenge, byte[] clientChallenge2, byte[] secondaryKey, byte[] timestamp)
  {
    this.random = random;
    this.currentTime = currentTime;
    
    this.domain = domain;
    this.target = target;
    this.user = user;
    this.password = password;
    this.challenge = challenge;
    this.targetInformation = targetInformation;
    this.clientChallenge = clientChallenge;
    this.clientChallenge2 = clientChallenge2;
    this.secondaryKey = secondaryKey;
    this.timestamp = timestamp;
  }
  
  @Deprecated
  public NTLMEngineImpl$CipherGen(String domain, String user, String password, byte[] challenge, String target, byte[] targetInformation)
  {
    this(NTLMEngineImpl.access$000(), System.currentTimeMillis(), domain, user, password, challenge, target, targetInformation);
  }
  
  public NTLMEngineImpl$CipherGen(Random random, long currentTime, String domain, String user, String password, byte[] challenge, String target, byte[] targetInformation)
  {
    this(random, currentTime, domain, user, password, challenge, target, targetInformation, null, null, null, null);
  }
  
  public byte[] getClientChallenge()
    throws NTLMEngineException
  {
    if (clientChallenge == null) {
      clientChallenge = NTLMEngineImpl.access$100(random);
    }
    return clientChallenge;
  }
  
  public byte[] getClientChallenge2()
    throws NTLMEngineException
  {
    if (clientChallenge2 == null) {
      clientChallenge2 = NTLMEngineImpl.access$100(random);
    }
    return clientChallenge2;
  }
  
  public byte[] getSecondaryKey()
    throws NTLMEngineException
  {
    if (secondaryKey == null) {
      secondaryKey = NTLMEngineImpl.access$200(random);
    }
    return secondaryKey;
  }
  
  public byte[] getLMHash()
    throws NTLMEngineException
  {
    if (lmHash == null) {
      lmHash = NTLMEngineImpl.access$300(password);
    }
    return lmHash;
  }
  
  public byte[] getLMResponse()
    throws NTLMEngineException
  {
    if (lmResponse == null) {
      lmResponse = NTLMEngineImpl.access$400(getLMHash(), challenge);
    }
    return lmResponse;
  }
  
  public byte[] getNTLMHash()
    throws NTLMEngineException
  {
    if (ntlmHash == null) {
      ntlmHash = NTLMEngineImpl.access$500(password);
    }
    return ntlmHash;
  }
  
  public byte[] getNTLMResponse()
    throws NTLMEngineException
  {
    if (ntlmResponse == null) {
      ntlmResponse = NTLMEngineImpl.access$400(getNTLMHash(), challenge);
    }
    return ntlmResponse;
  }
  
  public byte[] getLMv2Hash()
    throws NTLMEngineException
  {
    if (lmv2Hash == null) {
      lmv2Hash = NTLMEngineImpl.access$600(domain, user, getNTLMHash());
    }
    return lmv2Hash;
  }
  
  public byte[] getNTLMv2Hash()
    throws NTLMEngineException
  {
    if (ntlmv2Hash == null) {
      ntlmv2Hash = NTLMEngineImpl.access$700(domain, user, getNTLMHash());
    }
    return ntlmv2Hash;
  }
  
  public byte[] getTimestamp()
  {
    if (timestamp == null)
    {
      long time = currentTime;
      time += 11644473600000L;
      time *= 10000L;
      
      timestamp = new byte[8];
      for (int i = 0; i < 8; i++)
      {
        timestamp[i] = ((byte)(int)time);
        time >>>= 8;
      }
    }
    return timestamp;
  }
  
  public byte[] getNTLMv2Blob()
    throws NTLMEngineException
  {
    if (ntlmv2Blob == null) {
      ntlmv2Blob = NTLMEngineImpl.access$800(getClientChallenge2(), targetInformation, getTimestamp());
    }
    return ntlmv2Blob;
  }
  
  public byte[] getNTLMv2Response()
    throws NTLMEngineException
  {
    if (ntlmv2Response == null) {
      ntlmv2Response = NTLMEngineImpl.access$900(getNTLMv2Hash(), challenge, getNTLMv2Blob());
    }
    return ntlmv2Response;
  }
  
  public byte[] getLMv2Response()
    throws NTLMEngineException
  {
    if (lmv2Response == null) {
      lmv2Response = NTLMEngineImpl.access$900(getLMv2Hash(), challenge, getClientChallenge());
    }
    return lmv2Response;
  }
  
  public byte[] getNTLM2SessionResponse()
    throws NTLMEngineException
  {
    if (ntlm2SessionResponse == null) {
      ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), challenge, getClientChallenge());
    }
    return ntlm2SessionResponse;
  }
  
  public byte[] getLM2SessionResponse()
    throws NTLMEngineException
  {
    if (lm2SessionResponse == null)
    {
      byte[] clntChallenge = getClientChallenge();
      lm2SessionResponse = new byte[24];
      System.arraycopy(clntChallenge, 0, lm2SessionResponse, 0, clntChallenge.length);
      Arrays.fill(lm2SessionResponse, clntChallenge.length, lm2SessionResponse.length, (byte)0);
    }
    return lm2SessionResponse;
  }
  
  public byte[] getLMUserSessionKey()
    throws NTLMEngineException
  {
    if (lmUserSessionKey == null)
    {
      lmUserSessionKey = new byte[16];
      System.arraycopy(getLMHash(), 0, lmUserSessionKey, 0, 8);
      Arrays.fill(lmUserSessionKey, 8, 16, (byte)0);
    }
    return lmUserSessionKey;
  }
  
  public byte[] getNTLMUserSessionKey()
    throws NTLMEngineException
  {
    if (ntlmUserSessionKey == null)
    {
      NTLMEngineImpl.MD4 md4 = new NTLMEngineImpl.MD4();
      md4.update(getNTLMHash());
      ntlmUserSessionKey = md4.getOutput();
    }
    return ntlmUserSessionKey;
  }
  
  public byte[] getNTLMv2UserSessionKey()
    throws NTLMEngineException
  {
    if (ntlmv2UserSessionKey == null)
    {
      byte[] ntlmv2hash = getNTLMv2Hash();
      byte[] truncatedResponse = new byte[16];
      System.arraycopy(getNTLMv2Response(), 0, truncatedResponse, 0, 16);
      ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(truncatedResponse, ntlmv2hash);
    }
    return ntlmv2UserSessionKey;
  }
  
  public byte[] getNTLM2SessionResponseUserSessionKey()
    throws NTLMEngineException
  {
    if (ntlm2SessionResponseUserSessionKey == null)
    {
      byte[] ntlm2SessionResponseNonce = getLM2SessionResponse();
      byte[] sessionNonce = new byte[challenge.length + ntlm2SessionResponseNonce.length];
      System.arraycopy(challenge, 0, sessionNonce, 0, challenge.length);
      System.arraycopy(ntlm2SessionResponseNonce, 0, sessionNonce, challenge.length, ntlm2SessionResponseNonce.length);
      ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(sessionNonce, getNTLMUserSessionKey());
    }
    return ntlm2SessionResponseUserSessionKey;
  }
  
  public byte[] getLanManagerSessionKey()
    throws NTLMEngineException
  {
    if (lanManagerSessionKey == null) {
      try
      {
        byte[] keyBytes = new byte[14];
        System.arraycopy(getLMHash(), 0, keyBytes, 0, 8);
        Arrays.fill(keyBytes, 8, keyBytes.length, (byte)-67);
        Key lowKey = NTLMEngineImpl.access$1000(keyBytes, 0);
        Key highKey = NTLMEngineImpl.access$1000(keyBytes, 7);
        byte[] truncatedResponse = new byte[8];
        System.arraycopy(getLMResponse(), 0, truncatedResponse, 0, truncatedResponse.length);
        Cipher des = Cipher.getInstance("DES/ECB/NoPadding");
        des.init(1, lowKey);
        byte[] lowPart = des.doFinal(truncatedResponse);
        des = Cipher.getInstance("DES/ECB/NoPadding");
        des.init(1, highKey);
        byte[] highPart = des.doFinal(truncatedResponse);
        lanManagerSessionKey = new byte[16];
        System.arraycopy(lowPart, 0, lanManagerSessionKey, 0, lowPart.length);
        System.arraycopy(highPart, 0, lanManagerSessionKey, lowPart.length, highPart.length);
      }
      catch (Exception e)
      {
        throw new NTLMEngineException(e.getMessage(), e);
      }
    }
    return lanManagerSessionKey;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl.CipherGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */