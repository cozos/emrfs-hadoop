package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

final class NTLMEngineImpl
  implements NTLMEngine
{
  private static final Charset UNICODE_LITTLE_UNMARKED = Charset.forName("UnicodeLittleUnmarked");
  private static final Charset DEFAULT_CHARSET = Consts.ASCII;
  static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
  static final int FLAG_REQUEST_OEM_ENCODING = 2;
  static final int FLAG_REQUEST_TARGET = 4;
  static final int FLAG_REQUEST_SIGN = 16;
  static final int FLAG_REQUEST_SEAL = 32;
  static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
  static final int FLAG_REQUEST_NTLMv1 = 512;
  static final int FLAG_DOMAIN_PRESENT = 4096;
  static final int FLAG_WORKSTATION_PRESENT = 8192;
  static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
  static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
  static final int FLAG_REQUEST_VERSION = 33554432;
  static final int FLAG_TARGETINFO_PRESENT = 8388608;
  static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
  static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
  static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
  static final int MSV_AV_EOL = 0;
  static final int MSV_AV_NB_COMPUTER_NAME = 1;
  static final int MSV_AV_NB_DOMAIN_NAME = 2;
  static final int MSV_AV_DNS_COMPUTER_NAME = 3;
  static final int MSV_AV_DNS_DOMAIN_NAME = 4;
  static final int MSV_AV_DNS_TREE_NAME = 5;
  static final int MSV_AV_FLAGS = 6;
  static final int MSV_AV_TIMESTAMP = 7;
  static final int MSV_AV_SINGLE_HOST = 8;
  static final int MSV_AV_TARGET_NAME = 9;
  static final int MSV_AV_CHANNEL_BINDINGS = 10;
  static final int MSV_AV_FLAGS_ACCOUNT_AUTH_CONSTAINED = 1;
  static final int MSV_AV_FLAGS_MIC = 2;
  static final int MSV_AV_FLAGS_UNTRUSTED_TARGET_SPN = 4;
  private static final SecureRandom RND_GEN;
  
  static
  {
    SecureRandom rnd = null;
    try
    {
      rnd = SecureRandom.getInstance("SHA1PRNG");
    }
    catch (Exception ignore) {}
    RND_GEN = rnd;
  }
  
  private static final byte[] SIGNATURE = getNullTerminatedAsciiString("NTLMSSP");
  private static final byte[] SIGN_MAGIC_SERVER = getNullTerminatedAsciiString("session key to server-to-client signing key magic constant");
  private static final byte[] SIGN_MAGIC_CLIENT = getNullTerminatedAsciiString("session key to client-to-server signing key magic constant");
  private static final byte[] SEAL_MAGIC_SERVER = getNullTerminatedAsciiString("session key to server-to-client sealing key magic constant");
  private static final byte[] SEAL_MAGIC_CLIENT = getNullTerminatedAsciiString("session key to client-to-server sealing key magic constant");
  private static final byte[] MAGIC_TLS_SERVER_ENDPOINT = "tls-server-end-point:".getBytes(Consts.ASCII);
  
  private static byte[] getNullTerminatedAsciiString(String source)
  {
    byte[] bytesWithoutNull = source.getBytes(Consts.ASCII);
    byte[] target = new byte[bytesWithoutNull.length + 1];
    System.arraycopy(bytesWithoutNull, 0, target, 0, bytesWithoutNull.length);
    target[bytesWithoutNull.length] = 0;
    return target;
  }
  
  private static final String TYPE_1_MESSAGE = new Type1Message().getResponse();
  
  static String getType1Message(String host, String domain)
  {
    return TYPE_1_MESSAGE;
  }
  
  static String getType3Message(String user, String password, String host, String domain, byte[] nonce, int type2Flags, String target, byte[] targetInformation)
    throws NTLMEngineException
  {
    return new Type3Message(domain, host, user, password, nonce, type2Flags, target, targetInformation).getResponse();
  }
  
  static String getType3Message(String user, String password, String host, String domain, byte[] nonce, int type2Flags, String target, byte[] targetInformation, Certificate peerServerCertificate, byte[] type1Message, byte[] type2Message)
    throws NTLMEngineException
  {
    return new Type3Message(domain, host, user, password, nonce, type2Flags, target, targetInformation, peerServerCertificate, type1Message, type2Message).getResponse();
  }
  
  private static int readULong(byte[] src, int index)
    throws NTLMEngineException
  {
    if (src.length < index + 4) {
      return 0;
    }
    return src[index] & 0xFF | (src[(index + 1)] & 0xFF) << 8 | (src[(index + 2)] & 0xFF) << 16 | (src[(index + 3)] & 0xFF) << 24;
  }
  
  private static int readUShort(byte[] src, int index)
    throws NTLMEngineException
  {
    if (src.length < index + 2) {
      return 0;
    }
    return src[index] & 0xFF | (src[(index + 1)] & 0xFF) << 8;
  }
  
  private static byte[] readSecurityBuffer(byte[] src, int index)
    throws NTLMEngineException
  {
    int length = readUShort(src, index);
    int offset = readULong(src, index + 4);
    if (src.length < offset + length) {
      return new byte[length];
    }
    byte[] buffer = new byte[length];
    System.arraycopy(src, offset, buffer, 0, length);
    return buffer;
  }
  
  private static byte[] makeRandomChallenge(Random random)
    throws NTLMEngineException
  {
    byte[] rval = new byte[8];
    synchronized (random)
    {
      random.nextBytes(rval);
    }
    return rval;
  }
  
  private static byte[] makeSecondaryKey(Random random)
    throws NTLMEngineException
  {
    byte[] rval = new byte[16];
    synchronized (random)
    {
      random.nextBytes(rval);
    }
    return rval;
  }
  
  protected static class CipherGen
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
    public CipherGen(String domain, String user, String password, byte[] challenge, String target, byte[] targetInformation, byte[] clientChallenge, byte[] clientChallenge2, byte[] secondaryKey, byte[] timestamp)
    {
      this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), domain, user, password, challenge, target, targetInformation, clientChallenge, clientChallenge2, secondaryKey, timestamp);
    }
    
    public CipherGen(Random random, long currentTime, String domain, String user, String password, byte[] challenge, String target, byte[] targetInformation, byte[] clientChallenge, byte[] clientChallenge2, byte[] secondaryKey, byte[] timestamp)
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
    public CipherGen(String domain, String user, String password, byte[] challenge, String target, byte[] targetInformation)
    {
      this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), domain, user, password, challenge, target, targetInformation);
    }
    
    public CipherGen(Random random, long currentTime, String domain, String user, String password, byte[] challenge, String target, byte[] targetInformation)
    {
      this(random, currentTime, domain, user, password, challenge, target, targetInformation, null, null, null, null);
    }
    
    public byte[] getClientChallenge()
      throws NTLMEngineException
    {
      if (clientChallenge == null) {
        clientChallenge = NTLMEngineImpl.makeRandomChallenge(random);
      }
      return clientChallenge;
    }
    
    public byte[] getClientChallenge2()
      throws NTLMEngineException
    {
      if (clientChallenge2 == null) {
        clientChallenge2 = NTLMEngineImpl.makeRandomChallenge(random);
      }
      return clientChallenge2;
    }
    
    public byte[] getSecondaryKey()
      throws NTLMEngineException
    {
      if (secondaryKey == null) {
        secondaryKey = NTLMEngineImpl.makeSecondaryKey(random);
      }
      return secondaryKey;
    }
    
    public byte[] getLMHash()
      throws NTLMEngineException
    {
      if (lmHash == null) {
        lmHash = NTLMEngineImpl.lmHash(password);
      }
      return lmHash;
    }
    
    public byte[] getLMResponse()
      throws NTLMEngineException
    {
      if (lmResponse == null) {
        lmResponse = NTLMEngineImpl.lmResponse(getLMHash(), challenge);
      }
      return lmResponse;
    }
    
    public byte[] getNTLMHash()
      throws NTLMEngineException
    {
      if (ntlmHash == null) {
        ntlmHash = NTLMEngineImpl.ntlmHash(password);
      }
      return ntlmHash;
    }
    
    public byte[] getNTLMResponse()
      throws NTLMEngineException
    {
      if (ntlmResponse == null) {
        ntlmResponse = NTLMEngineImpl.lmResponse(getNTLMHash(), challenge);
      }
      return ntlmResponse;
    }
    
    public byte[] getLMv2Hash()
      throws NTLMEngineException
    {
      if (lmv2Hash == null) {
        lmv2Hash = NTLMEngineImpl.lmv2Hash(domain, user, getNTLMHash());
      }
      return lmv2Hash;
    }
    
    public byte[] getNTLMv2Hash()
      throws NTLMEngineException
    {
      if (ntlmv2Hash == null) {
        ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(domain, user, getNTLMHash());
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
        ntlmv2Blob = NTLMEngineImpl.createBlob(getClientChallenge2(), targetInformation, getTimestamp());
      }
      return ntlmv2Blob;
    }
    
    public byte[] getNTLMv2Response()
      throws NTLMEngineException
    {
      if (ntlmv2Response == null) {
        ntlmv2Response = NTLMEngineImpl.lmv2Response(getNTLMv2Hash(), challenge, getNTLMv2Blob());
      }
      return ntlmv2Response;
    }
    
    public byte[] getLMv2Response()
      throws NTLMEngineException
    {
      if (lmv2Response == null) {
        lmv2Response = NTLMEngineImpl.lmv2Response(getLMv2Hash(), challenge, getClientChallenge());
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
          Key lowKey = NTLMEngineImpl.createDESKey(keyBytes, 0);
          Key highKey = NTLMEngineImpl.createDESKey(keyBytes, 7);
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
  
  static byte[] hmacMD5(byte[] value, byte[] key)
    throws NTLMEngineException
  {
    HMACMD5 hmacMD5 = new HMACMD5(key);
    hmacMD5.update(value);
    return hmacMD5.getOutput();
  }
  
  static byte[] RC4(byte[] value, byte[] key)
    throws NTLMEngineException
  {
    try
    {
      Cipher rc4 = Cipher.getInstance("RC4");
      rc4.init(1, new SecretKeySpec(key, "RC4"));
      return rc4.doFinal(value);
    }
    catch (Exception e)
    {
      throw new NTLMEngineException(e.getMessage(), e);
    }
  }
  
  static byte[] ntlm2SessionResponse(byte[] ntlmHash, byte[] challenge, byte[] clientChallenge)
    throws NTLMEngineException
  {
    try
    {
      MessageDigest md5 = getMD5();
      md5.update(challenge);
      md5.update(clientChallenge);
      byte[] digest = md5.digest();
      
      byte[] sessionHash = new byte[8];
      System.arraycopy(digest, 0, sessionHash, 0, 8);
      return lmResponse(ntlmHash, sessionHash);
    }
    catch (Exception e)
    {
      if ((e instanceof NTLMEngineException)) {
        throw ((NTLMEngineException)e);
      }
      throw new NTLMEngineException(e.getMessage(), e);
    }
  }
  
  private static byte[] lmHash(String password)
    throws NTLMEngineException
  {
    try
    {
      byte[] oemPassword = password.toUpperCase(Locale.ROOT).getBytes(Consts.ASCII);
      int length = Math.min(oemPassword.length, 14);
      byte[] keyBytes = new byte[14];
      System.arraycopy(oemPassword, 0, keyBytes, 0, length);
      Key lowKey = createDESKey(keyBytes, 0);
      Key highKey = createDESKey(keyBytes, 7);
      byte[] magicConstant = "KGS!@#$%".getBytes(Consts.ASCII);
      Cipher des = Cipher.getInstance("DES/ECB/NoPadding");
      des.init(1, lowKey);
      byte[] lowHash = des.doFinal(magicConstant);
      des.init(1, highKey);
      byte[] highHash = des.doFinal(magicConstant);
      byte[] lmHash = new byte[16];
      System.arraycopy(lowHash, 0, lmHash, 0, 8);
      System.arraycopy(highHash, 0, lmHash, 8, 8);
      return lmHash;
    }
    catch (Exception e)
    {
      throw new NTLMEngineException(e.getMessage(), e);
    }
  }
  
  private static byte[] ntlmHash(String password)
    throws NTLMEngineException
  {
    if (UNICODE_LITTLE_UNMARKED == null) {
      throw new NTLMEngineException("Unicode not supported");
    }
    byte[] unicodePassword = password.getBytes(UNICODE_LITTLE_UNMARKED);
    MD4 md4 = new MD4();
    md4.update(unicodePassword);
    return md4.getOutput();
  }
  
  private static byte[] lmv2Hash(String domain, String user, byte[] ntlmHash)
    throws NTLMEngineException
  {
    if (UNICODE_LITTLE_UNMARKED == null) {
      throw new NTLMEngineException("Unicode not supported");
    }
    HMACMD5 hmacMD5 = new HMACMD5(ntlmHash);
    
    hmacMD5.update(user.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
    if (domain != null) {
      hmacMD5.update(domain.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
    }
    return hmacMD5.getOutput();
  }
  
  private static byte[] ntlmv2Hash(String domain, String user, byte[] ntlmHash)
    throws NTLMEngineException
  {
    if (UNICODE_LITTLE_UNMARKED == null) {
      throw new NTLMEngineException("Unicode not supported");
    }
    HMACMD5 hmacMD5 = new HMACMD5(ntlmHash);
    
    hmacMD5.update(user.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
    if (domain != null) {
      hmacMD5.update(domain.getBytes(UNICODE_LITTLE_UNMARKED));
    }
    return hmacMD5.getOutput();
  }
  
  private static byte[] lmResponse(byte[] hash, byte[] challenge)
    throws NTLMEngineException
  {
    try
    {
      byte[] keyBytes = new byte[21];
      System.arraycopy(hash, 0, keyBytes, 0, 16);
      Key lowKey = createDESKey(keyBytes, 0);
      Key middleKey = createDESKey(keyBytes, 7);
      Key highKey = createDESKey(keyBytes, 14);
      Cipher des = Cipher.getInstance("DES/ECB/NoPadding");
      des.init(1, lowKey);
      byte[] lowResponse = des.doFinal(challenge);
      des.init(1, middleKey);
      byte[] middleResponse = des.doFinal(challenge);
      des.init(1, highKey);
      byte[] highResponse = des.doFinal(challenge);
      byte[] lmResponse = new byte[24];
      System.arraycopy(lowResponse, 0, lmResponse, 0, 8);
      System.arraycopy(middleResponse, 0, lmResponse, 8, 8);
      System.arraycopy(highResponse, 0, lmResponse, 16, 8);
      return lmResponse;
    }
    catch (Exception e)
    {
      throw new NTLMEngineException(e.getMessage(), e);
    }
  }
  
  private static byte[] lmv2Response(byte[] hash, byte[] challenge, byte[] clientData)
    throws NTLMEngineException
  {
    HMACMD5 hmacMD5 = new HMACMD5(hash);
    hmacMD5.update(challenge);
    hmacMD5.update(clientData);
    byte[] mac = hmacMD5.getOutput();
    byte[] lmv2Response = new byte[mac.length + clientData.length];
    System.arraycopy(mac, 0, lmv2Response, 0, mac.length);
    System.arraycopy(clientData, 0, lmv2Response, mac.length, clientData.length);
    return lmv2Response;
  }
  
  static enum Mode
  {
    CLIENT,  SERVER;
    
    private Mode() {}
  }
  
  static class Handle
  {
    private final byte[] exportedSessionKey;
    private byte[] signingKey;
    private byte[] sealingKey;
    private final Cipher rc4;
    final NTLMEngineImpl.Mode mode;
    private final boolean isConnection;
    int sequenceNumber = 0;
    
    Handle(byte[] exportedSessionKey, NTLMEngineImpl.Mode mode, boolean isConnection)
      throws NTLMEngineException
    {
      this.exportedSessionKey = exportedSessionKey;
      this.isConnection = isConnection;
      this.mode = mode;
      try
      {
        MessageDigest signMd5 = NTLMEngineImpl.getMD5();
        MessageDigest sealMd5 = NTLMEngineImpl.getMD5();
        signMd5.update(exportedSessionKey);
        sealMd5.update(exportedSessionKey);
        if (mode == NTLMEngineImpl.Mode.CLIENT)
        {
          signMd5.update(NTLMEngineImpl.SIGN_MAGIC_CLIENT);
          sealMd5.update(NTLMEngineImpl.SEAL_MAGIC_CLIENT);
        }
        else
        {
          signMd5.update(NTLMEngineImpl.SIGN_MAGIC_SERVER);
          sealMd5.update(NTLMEngineImpl.SEAL_MAGIC_SERVER);
        }
        signingKey = signMd5.digest();
        sealingKey = sealMd5.digest();
      }
      catch (Exception e)
      {
        throw new NTLMEngineException(e.getMessage(), e);
      }
      rc4 = initCipher();
    }
    
    public byte[] getSigningKey()
    {
      return signingKey;
    }
    
    public byte[] getSealingKey()
    {
      return sealingKey;
    }
    
    private Cipher initCipher()
      throws NTLMEngineException
    {
      Cipher cipher;
      try
      {
        cipher = Cipher.getInstance("RC4");
        if (mode == NTLMEngineImpl.Mode.CLIENT) {
          cipher.init(1, new SecretKeySpec(sealingKey, "RC4"));
        } else {
          cipher.init(2, new SecretKeySpec(sealingKey, "RC4"));
        }
      }
      catch (Exception e)
      {
        throw new NTLMEngineException(e.getMessage(), e);
      }
      return cipher;
    }
    
    private void advanceMessageSequence()
      throws NTLMEngineException
    {
      if (!isConnection)
      {
        MessageDigest sealMd5 = NTLMEngineImpl.getMD5();
        sealMd5.update(sealingKey);
        byte[] seqNumBytes = new byte[4];
        NTLMEngineImpl.writeULong(seqNumBytes, sequenceNumber, 0);
        sealMd5.update(seqNumBytes);
        sealingKey = sealMd5.digest();
        initCipher();
      }
      sequenceNumber += 1;
    }
    
    private byte[] encrypt(byte[] data)
      throws NTLMEngineException
    {
      return rc4.update(data);
    }
    
    private byte[] decrypt(byte[] data)
      throws NTLMEngineException
    {
      return rc4.update(data);
    }
    
    private byte[] computeSignature(byte[] message)
      throws NTLMEngineException
    {
      byte[] sig = new byte[16];
      
      sig[0] = 1;
      sig[1] = 0;
      sig[2] = 0;
      sig[3] = 0;
      
      NTLMEngineImpl.HMACMD5 hmacMD5 = new NTLMEngineImpl.HMACMD5(signingKey);
      hmacMD5.update(NTLMEngineImpl.encodeLong(sequenceNumber));
      hmacMD5.update(message);
      byte[] hmac = hmacMD5.getOutput();
      byte[] trimmedHmac = new byte[8];
      System.arraycopy(hmac, 0, trimmedHmac, 0, 8);
      byte[] encryptedHmac = encrypt(trimmedHmac);
      System.arraycopy(encryptedHmac, 0, sig, 4, 8);
      
      NTLMEngineImpl.encodeLong(sig, 12, sequenceNumber);
      
      return sig;
    }
    
    private boolean validateSignature(byte[] signature, byte[] message)
      throws NTLMEngineException
    {
      byte[] computedSignature = computeSignature(message);
      
      return Arrays.equals(signature, computedSignature);
    }
    
    public byte[] signAndEncryptMessage(byte[] cleartextMessage)
      throws NTLMEngineException
    {
      byte[] encryptedMessage = encrypt(cleartextMessage);
      byte[] signature = computeSignature(cleartextMessage);
      byte[] outMessage = new byte[signature.length + encryptedMessage.length];
      System.arraycopy(signature, 0, outMessage, 0, signature.length);
      System.arraycopy(encryptedMessage, 0, outMessage, signature.length, encryptedMessage.length);
      advanceMessageSequence();
      return outMessage;
    }
    
    public byte[] decryptAndVerifySignedMessage(byte[] inMessage)
      throws NTLMEngineException
    {
      byte[] signature = new byte[16];
      System.arraycopy(inMessage, 0, signature, 0, signature.length);
      byte[] encryptedMessage = new byte[inMessage.length - 16];
      System.arraycopy(inMessage, 16, encryptedMessage, 0, encryptedMessage.length);
      byte[] cleartextMessage = decrypt(encryptedMessage);
      if (!validateSignature(signature, cleartextMessage)) {
        throw new NTLMEngineException("Wrong signature");
      }
      advanceMessageSequence();
      return cleartextMessage;
    }
  }
  
  private static byte[] encodeLong(int value)
  {
    byte[] enc = new byte[4];
    encodeLong(enc, 0, value);
    return enc;
  }
  
  private static void encodeLong(byte[] buf, int offset, int value)
  {
    buf[(offset + 0)] = ((byte)(value & 0xFF));
    buf[(offset + 1)] = ((byte)(value >> 8 & 0xFF));
    buf[(offset + 2)] = ((byte)(value >> 16 & 0xFF));
    buf[(offset + 3)] = ((byte)(value >> 24 & 0xFF));
  }
  
  private static byte[] createBlob(byte[] clientChallenge, byte[] targetInformation, byte[] timestamp)
  {
    byte[] blobSignature = { 1, 1, 0, 0 };
    byte[] reserved = { 0, 0, 0, 0 };
    byte[] unknown1 = { 0, 0, 0, 0 };
    byte[] unknown2 = { 0, 0, 0, 0 };
    byte[] blob = new byte[blobSignature.length + reserved.length + timestamp.length + 8 + unknown1.length + targetInformation.length + unknown2.length];
    
    int offset = 0;
    System.arraycopy(blobSignature, 0, blob, offset, blobSignature.length);
    offset += blobSignature.length;
    System.arraycopy(reserved, 0, blob, offset, reserved.length);
    offset += reserved.length;
    System.arraycopy(timestamp, 0, blob, offset, timestamp.length);
    offset += timestamp.length;
    System.arraycopy(clientChallenge, 0, blob, offset, 8);
    offset += 8;
    System.arraycopy(unknown1, 0, blob, offset, unknown1.length);
    offset += unknown1.length;
    System.arraycopy(targetInformation, 0, blob, offset, targetInformation.length);
    offset += targetInformation.length;
    System.arraycopy(unknown2, 0, blob, offset, unknown2.length);
    offset += unknown2.length;
    return blob;
  }
  
  private static Key createDESKey(byte[] bytes, int offset)
  {
    byte[] keyBytes = new byte[7];
    System.arraycopy(bytes, offset, keyBytes, 0, 7);
    byte[] material = new byte[8];
    material[0] = keyBytes[0];
    material[1] = ((byte)(keyBytes[0] << 7 | (keyBytes[1] & 0xFF) >>> 1));
    material[2] = ((byte)(keyBytes[1] << 6 | (keyBytes[2] & 0xFF) >>> 2));
    material[3] = ((byte)(keyBytes[2] << 5 | (keyBytes[3] & 0xFF) >>> 3));
    material[4] = ((byte)(keyBytes[3] << 4 | (keyBytes[4] & 0xFF) >>> 4));
    material[5] = ((byte)(keyBytes[4] << 3 | (keyBytes[5] & 0xFF) >>> 5));
    material[6] = ((byte)(keyBytes[5] << 2 | (keyBytes[6] & 0xFF) >>> 6));
    material[7] = ((byte)(keyBytes[6] << 1));
    oddParity(material);
    return new SecretKeySpec(material, "DES");
  }
  
  private static void oddParity(byte[] bytes)
  {
    for (int i = 0; i < bytes.length; i++)
    {
      byte b = bytes[i];
      boolean needsParity = ((b >>> 7 ^ b >>> 6 ^ b >>> 5 ^ b >>> 4 ^ b >>> 3 ^ b >>> 2 ^ b >>> 1) & 0x1) == 0;
      if (needsParity)
      {
        int tmp58_57 = i;bytes[tmp58_57] = ((byte)(bytes[tmp58_57] | 0x1));
      }
      else
      {
        int tmp69_68 = i;bytes[tmp69_68] = ((byte)(bytes[tmp69_68] & 0xFFFFFFFE));
      }
    }
  }
  
  private static Charset getCharset(int flags)
    throws NTLMEngineException
  {
    if ((flags & 0x1) == 0) {
      return DEFAULT_CHARSET;
    }
    if (UNICODE_LITTLE_UNMARKED == null) {
      throw new NTLMEngineException("Unicode not supported");
    }
    return UNICODE_LITTLE_UNMARKED;
  }
  
  private static String stripDotSuffix(String value)
  {
    if (value == null) {
      return null;
    }
    int index = value.indexOf('.');
    if (index != -1) {
      return value.substring(0, index);
    }
    return value;
  }
  
  private static String convertHost(String host)
  {
    return stripDotSuffix(host);
  }
  
  private static String convertDomain(String domain)
  {
    return stripDotSuffix(domain);
  }
  
  static class NTLMMessage
  {
    protected byte[] messageContents = null;
    protected int currentOutputPosition = 0;
    
    NTLMMessage() {}
    
    NTLMMessage(String messageBody, int expectedType)
      throws NTLMEngineException
    {
      this(Base64.decodeBase64(messageBody.getBytes(NTLMEngineImpl.DEFAULT_CHARSET)), expectedType);
    }
    
    NTLMMessage(byte[] message, int expectedType)
      throws NTLMEngineException
    {
      messageContents = message;
      if (messageContents.length < NTLMEngineImpl.SIGNATURE.length) {
        throw new NTLMEngineException("NTLM message decoding error - packet too short");
      }
      int i = 0;
      while (i < NTLMEngineImpl.SIGNATURE.length)
      {
        if (messageContents[i] != NTLMEngineImpl.SIGNATURE[i]) {
          throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
        }
        i++;
      }
      int type = readULong(NTLMEngineImpl.SIGNATURE.length);
      if (type != expectedType) {
        throw new NTLMEngineException("NTLM type " + Integer.toString(expectedType) + " message expected - instead got type " + Integer.toString(type));
      }
      currentOutputPosition = messageContents.length;
    }
    
    protected int getPreambleLength()
    {
      return NTLMEngineImpl.SIGNATURE.length + 4;
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
      return NTLMEngineImpl.readUShort(messageContents, position);
    }
    
    protected int readULong(int position)
      throws NTLMEngineException
    {
      return NTLMEngineImpl.readULong(messageContents, position);
    }
    
    protected byte[] readSecurityBuffer(int position)
      throws NTLMEngineException
    {
      return NTLMEngineImpl.readSecurityBuffer(messageContents, position);
    }
    
    protected void prepareResponse(int maxlength, int messageType)
    {
      messageContents = new byte[maxlength];
      currentOutputPosition = 0;
      addBytes(NTLMEngineImpl.SIGNATURE);
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
  
  static class Type1Message
    extends NTLMEngineImpl.NTLMMessage
  {
    private final byte[] hostBytes;
    private final byte[] domainBytes;
    private final int flags;
    
    Type1Message(String domain, String host)
      throws NTLMEngineException
    {
      this(domain, host, null);
    }
    
    Type1Message(String domain, String host, Integer flags)
      throws NTLMEngineException
    {
      this.flags = (flags == null ? getDefaultFlags() : flags.intValue());
      
      String unqualifiedHost = NTLMEngineImpl.convertHost(host);
      
      String unqualifiedDomain = NTLMEngineImpl.convertDomain(domain);
      
      hostBytes = (unqualifiedHost != null ? unqualifiedHost.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null);
      
      domainBytes = (unqualifiedDomain != null ? unqualifiedDomain.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null);
    }
    
    Type1Message()
    {
      hostBytes = null;
      domainBytes = null;
      flags = getDefaultFlags();
    }
    
    private int getDefaultFlags()
    {
      return -1576500735;
    }
    
    protected void buildMessage()
    {
      int domainBytesLength = 0;
      if (domainBytes != null) {
        domainBytesLength = domainBytes.length;
      }
      int hostBytesLength = 0;
      if (hostBytes != null) {
        hostBytesLength = hostBytes.length;
      }
      int finalLength = 40 + hostBytesLength + domainBytesLength;
      
      prepareResponse(finalLength, 1);
      
      addULong(flags);
      
      addUShort(domainBytesLength);
      addUShort(domainBytesLength);
      
      addULong(hostBytesLength + 32 + 8);
      
      addUShort(hostBytesLength);
      addUShort(hostBytesLength);
      
      addULong(40);
      
      addUShort(261);
      
      addULong(2600);
      
      addUShort(3840);
      if (hostBytes != null) {
        addBytes(hostBytes);
      }
      if (domainBytes != null) {
        addBytes(domainBytes);
      }
    }
  }
  
  static class Type2Message
    extends NTLMEngineImpl.NTLMMessage
  {
    protected final byte[] challenge;
    protected String target;
    protected byte[] targetInfo;
    protected final int flags;
    
    Type2Message(String messageBody)
      throws NTLMEngineException
    {
      this(Base64.decodeBase64(messageBody.getBytes(NTLMEngineImpl.DEFAULT_CHARSET)));
    }
    
    Type2Message(byte[] message)
      throws NTLMEngineException
    {
      super(2);
      
      challenge = new byte[8];
      readBytes(challenge, 24);
      
      flags = readULong(20);
      
      target = null;
      if (getMessageLength() >= 20)
      {
        byte[] bytes = readSecurityBuffer(12);
        if (bytes.length != 0) {
          target = new String(bytes, NTLMEngineImpl.getCharset(flags));
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
  
  static class Type3Message
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
    
    Type3Message(String domain, String host, String user, String password, byte[] nonce, int type2Flags, String target, byte[] targetInformation)
      throws NTLMEngineException
    {
      this(domain, host, user, password, nonce, type2Flags, target, targetInformation, null, null, null);
    }
    
    Type3Message(Random random, long currentTime, String domain, String host, String user, String password, byte[] nonce, int type2Flags, String target, byte[] targetInformation)
      throws NTLMEngineException
    {
      this(random, currentTime, domain, host, user, password, nonce, type2Flags, target, targetInformation, null, null, null);
    }
    
    Type3Message(String domain, String host, String user, String password, byte[] nonce, int type2Flags, String target, byte[] targetInformation, Certificate peerServerCertificate, byte[] type1Message, byte[] type2Message)
      throws NTLMEngineException
    {
      this(NTLMEngineImpl.RND_GEN, System.currentTimeMillis(), domain, host, user, password, nonce, type2Flags, target, targetInformation, peerServerCertificate, type1Message, type2Message);
    }
    
    Type3Message(Random random, long currentTime, String domain, String host, String user, String password, byte[] nonce, int type2Flags, String target, byte[] targetInformation, Certificate peerServerCertificate, byte[] type1Message, byte[] type2Message)
      throws NTLMEngineException
    {
      if (random == null) {
        throw new NTLMEngineException("Random generator not available");
      }
      this.type2Flags = type2Flags;
      this.type1Message = type1Message;
      this.type2Message = type2Message;
      
      String unqualifiedHost = NTLMEngineImpl.convertHost(host);
      
      String unqualifiedDomain = NTLMEngineImpl.convertDomain(domain);
      
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
      Charset charset = NTLMEngineImpl.getCharset(type2Flags);
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
        byte[] channelBindingStruct = new byte[20 + NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length + certHashBytes.length];
        
        NTLMEngineImpl.writeULong(channelBindingStruct, 53, 16);
        System.arraycopy(NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT, 0, channelBindingStruct, 20, NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length);
        
        System.arraycopy(certHashBytes, 0, channelBindingStruct, 20 + NTLMEngineImpl.MAGIC_TLS_SERVER_ENDPOINT.length, certHashBytes.length);
        
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
  
  static void writeUShort(byte[] buffer, int value, int offset)
  {
    buffer[offset] = ((byte)(value & 0xFF));
    buffer[(offset + 1)] = ((byte)(value >> 8 & 0xFF));
  }
  
  static void writeULong(byte[] buffer, int value, int offset)
  {
    buffer[offset] = ((byte)(value & 0xFF));
    buffer[(offset + 1)] = ((byte)(value >> 8 & 0xFF));
    buffer[(offset + 2)] = ((byte)(value >> 16 & 0xFF));
    buffer[(offset + 3)] = ((byte)(value >> 24 & 0xFF));
  }
  
  static int F(int x, int y, int z)
  {
    return x & y | (x ^ 0xFFFFFFFF) & z;
  }
  
  static int G(int x, int y, int z)
  {
    return x & y | x & z | y & z;
  }
  
  static int H(int x, int y, int z)
  {
    return x ^ y ^ z;
  }
  
  static int rotintlft(int val, int numbits)
  {
    return val << numbits | val >>> 32 - numbits;
  }
  
  static MessageDigest getMD5()
  {
    try
    {
      return MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException ex)
    {
      throw new RuntimeException("MD5 message digest doesn't seem to exist - fatal error: " + ex.getMessage(), ex);
    }
  }
  
  static class MD4
  {
    protected int A = 1732584193;
    protected int B = -271733879;
    protected int C = -1732584194;
    protected int D = 271733878;
    protected long count = 0L;
    protected final byte[] dataBuffer = new byte[64];
    
    void update(byte[] input)
    {
      int curBufferPos = (int)(count & 0x3F);
      int inputIndex = 0;
      while (input.length - inputIndex + curBufferPos >= dataBuffer.length)
      {
        int transferAmt = dataBuffer.length - curBufferPos;
        System.arraycopy(input, inputIndex, dataBuffer, curBufferPos, transferAmt);
        count += transferAmt;
        curBufferPos = 0;
        inputIndex += transferAmt;
        processBuffer();
      }
      if (inputIndex < input.length)
      {
        int transferAmt = input.length - inputIndex;
        System.arraycopy(input, inputIndex, dataBuffer, curBufferPos, transferAmt);
        count += transferAmt;
        curBufferPos += transferAmt;
      }
    }
    
    byte[] getOutput()
    {
      int bufferIndex = (int)(count & 0x3F);
      int padLen = bufferIndex < 56 ? 56 - bufferIndex : 120 - bufferIndex;
      byte[] postBytes = new byte[padLen + 8];
      
      postBytes[0] = Byte.MIN_VALUE;
      for (int i = 0; i < 8; i++) {
        postBytes[(padLen + i)] = ((byte)(int)(count * 8L >>> 8 * i));
      }
      update(postBytes);
      
      byte[] result = new byte[16];
      NTLMEngineImpl.writeULong(result, A, 0);
      NTLMEngineImpl.writeULong(result, B, 4);
      NTLMEngineImpl.writeULong(result, C, 8);
      NTLMEngineImpl.writeULong(result, D, 12);
      return result;
    }
    
    protected void processBuffer()
    {
      int[] d = new int[16];
      for (int i = 0; i < 16; i++) {
        d[i] = ((dataBuffer[(i * 4)] & 0xFF) + ((dataBuffer[(i * 4 + 1)] & 0xFF) << 8) + ((dataBuffer[(i * 4 + 2)] & 0xFF) << 16) + ((dataBuffer[(i * 4 + 3)] & 0xFF) << 24));
      }
      int AA = A;
      int BB = B;
      int CC = C;
      int DD = D;
      round1(d);
      round2(d);
      round3(d);
      A += AA;
      B += BB;
      C += CC;
      D += DD;
    }
    
    protected void round1(int[] d)
    {
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + d[0], 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + d[1], 7);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + d[2], 11);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + d[3], 19);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + d[4], 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + d[5], 7);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + d[6], 11);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + d[7], 19);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + d[8], 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + d[9], 7);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + d[10], 11);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + d[11], 19);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.F(B, C, D) + d[12], 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.F(A, B, C) + d[13], 7);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.F(D, A, B) + d[14], 11);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.F(C, D, A) + d[15], 19);
    }
    
    protected void round2(int[] d)
    {
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + d[0] + 1518500249, 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + d[4] + 1518500249, 5);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + d[8] + 1518500249, 9);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + d[12] + 1518500249, 13);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + d[1] + 1518500249, 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + d[5] + 1518500249, 5);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + d[9] + 1518500249, 9);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + d[13] + 1518500249, 13);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + d[2] + 1518500249, 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + d[6] + 1518500249, 5);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + d[10] + 1518500249, 9);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + d[14] + 1518500249, 13);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.G(B, C, D) + d[3] + 1518500249, 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.G(A, B, C) + d[7] + 1518500249, 5);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.G(D, A, B) + d[11] + 1518500249, 9);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.G(C, D, A) + d[15] + 1518500249, 13);
    }
    
    protected void round3(int[] d)
    {
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + d[0] + 1859775393, 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + d[8] + 1859775393, 9);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + d[4] + 1859775393, 11);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + d[12] + 1859775393, 15);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + d[2] + 1859775393, 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + d[10] + 1859775393, 9);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + d[6] + 1859775393, 11);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + d[14] + 1859775393, 15);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + d[1] + 1859775393, 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + d[9] + 1859775393, 9);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + d[5] + 1859775393, 11);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + d[13] + 1859775393, 15);
      
      A = NTLMEngineImpl.rotintlft(A + NTLMEngineImpl.H(B, C, D) + d[3] + 1859775393, 3);
      D = NTLMEngineImpl.rotintlft(D + NTLMEngineImpl.H(A, B, C) + d[11] + 1859775393, 9);
      C = NTLMEngineImpl.rotintlft(C + NTLMEngineImpl.H(D, A, B) + d[7] + 1859775393, 11);
      B = NTLMEngineImpl.rotintlft(B + NTLMEngineImpl.H(C, D, A) + d[15] + 1859775393, 15);
    }
  }
  
  static class HMACMD5
  {
    protected final byte[] ipad;
    protected final byte[] opad;
    protected final MessageDigest md5;
    
    HMACMD5(byte[] input)
    {
      byte[] key = input;
      md5 = NTLMEngineImpl.getMD5();
      
      ipad = new byte[64];
      opad = new byte[64];
      
      int keyLength = key.length;
      if (keyLength > 64)
      {
        md5.update(key);
        key = md5.digest();
        keyLength = key.length;
      }
      int i = 0;
      while (i < keyLength)
      {
        ipad[i] = ((byte)(key[i] ^ 0x36));
        opad[i] = ((byte)(key[i] ^ 0x5C));
        i++;
      }
      while (i < 64)
      {
        ipad[i] = 54;
        opad[i] = 92;
        i++;
      }
      md5.reset();
      md5.update(ipad);
    }
    
    byte[] getOutput()
    {
      byte[] digest = md5.digest();
      md5.update(opad);
      return md5.digest(digest);
    }
    
    void update(byte[] input)
    {
      md5.update(input);
    }
    
    void update(byte[] input, int offset, int length)
    {
      md5.update(input, offset, length);
    }
  }
  
  public String generateType1Msg(String domain, String workstation)
    throws NTLMEngineException
  {
    return getType1Message(workstation, domain);
  }
  
  public String generateType3Msg(String username, String password, String domain, String workstation, String challenge)
    throws NTLMEngineException
  {
    Type2Message t2m = new Type2Message(challenge);
    return getType3Message(username, password, workstation, domain, t2m.getChallenge(), t2m.getFlags(), t2m.getTarget(), t2m.getTargetInfo());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */