package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class NTLMEngineImpl$Handle
{
  private final byte[] exportedSessionKey;
  private byte[] signingKey;
  private byte[] sealingKey;
  private final Cipher rc4;
  final NTLMEngineImpl.Mode mode;
  private final boolean isConnection;
  int sequenceNumber = 0;
  
  NTLMEngineImpl$Handle(byte[] exportedSessionKey, NTLMEngineImpl.Mode mode, boolean isConnection)
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
        signMd5.update(NTLMEngineImpl.access$1100());
        sealMd5.update(NTLMEngineImpl.access$1200());
      }
      else
      {
        signMd5.update(NTLMEngineImpl.access$1300());
        sealMd5.update(NTLMEngineImpl.access$1400());
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
    hmacMD5.update(NTLMEngineImpl.access$1500(sequenceNumber));
    hmacMD5.update(message);
    byte[] hmac = hmacMD5.getOutput();
    byte[] trimmedHmac = new byte[8];
    System.arraycopy(hmac, 0, trimmedHmac, 0, 8);
    byte[] encryptedHmac = encrypt(trimmedHmac);
    System.arraycopy(encryptedHmac, 0, sig, 4, 8);
    
    NTLMEngineImpl.access$1600(sig, 12, sequenceNumber);
    
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl.Handle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */