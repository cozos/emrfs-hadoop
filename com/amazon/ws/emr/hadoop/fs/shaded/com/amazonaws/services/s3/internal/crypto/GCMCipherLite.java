package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

final class GCMCipherLite
  extends CipherLite
{
  private static final int TAG_LENGTH = ContentCryptoScheme.AES_GCM
    .getTagLengthInBits() / 8;
  private final int tagLen;
  private long outputByteCount;
  private boolean invisiblyProcessed;
  private long currentCount;
  private long markedCount;
  private CipherLite aux;
  private byte[] finalBytes;
  private boolean doneFinal;
  private boolean securityViolated;
  
  GCMCipherLite(Cipher cipher, SecretKey secreteKey, int cipherMode)
  {
    super(cipher, ContentCryptoScheme.AES_GCM, secreteKey, cipherMode);
    tagLen = (cipherMode == 1 ? TAG_LENGTH : 0);
    if ((cipherMode != 1) && (cipherMode != 2)) {
      throw new IllegalArgumentException();
    }
  }
  
  byte[] doFinal()
    throws IllegalBlockSizeException, BadPaddingException
  {
    if (doneFinal)
    {
      if (securityViolated) {
        throw new SecurityException();
      }
      return finalBytes == null ? null : (byte[])finalBytes.clone();
    }
    doneFinal = true;
    finalBytes = super.doFinal();
    if (finalBytes == null) {
      return null;
    }
    outputByteCount += checkMax(finalBytes.length - tagLen);
    return (byte[])finalBytes.clone();
  }
  
  final byte[] doFinal(byte[] input)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return doFinal0(input, 0, input.length);
  }
  
  final byte[] doFinal(byte[] input, int inputOffset, int inputLen)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return doFinal0(input, inputOffset, inputLen);
  }
  
  private final byte[] doFinal0(byte[] input, int inputOffset, int inputLen)
    throws IllegalBlockSizeException, BadPaddingException
  {
    if (doneFinal)
    {
      if (securityViolated) {
        throw new SecurityException();
      }
      if (2 == getCipherMode()) {
        return finalBytes == null ? null : (byte[])finalBytes.clone();
      }
      int finalDataLen = finalBytes.length - tagLen;
      if (inputLen == finalDataLen) {
        return (byte[])finalBytes.clone();
      }
      if ((inputLen < finalDataLen) && 
        (inputLen + currentCount == outputByteCount))
      {
        int from = finalBytes.length - tagLen - inputLen;
        return Arrays.copyOfRange(finalBytes, from, finalBytes.length);
      }
      throw new IllegalStateException("Inconsistent re-rencryption");
    }
    doneFinal = true;
    
    finalBytes = super.doFinal(input, inputOffset, inputLen);
    if (finalBytes == null) {
      return null;
    }
    outputByteCount += checkMax(finalBytes.length - tagLen);
    return (byte[])finalBytes.clone();
  }
  
  byte[] update(byte[] input, int inputOffset, int inputLen)
  {
    byte[] out;
    if (aux == null)
    {
      byte[] out = super.update(input, inputOffset, inputLen);
      if (out == null)
      {
        invisiblyProcessed = (input.length > 0);
        return null;
      }
      outputByteCount += checkMax(out.length);
      
      invisiblyProcessed = ((out.length == 0) && (inputLen > 0));
    }
    else
    {
      out = aux.update(input, inputOffset, inputLen);
      if (out == null) {
        return null;
      }
      currentCount += out.length;
      if (currentCount == outputByteCount)
      {
        aux = null;
      }
      else if (currentCount > outputByteCount)
      {
        if (1 == getCipherMode()) {
          throw new IllegalStateException("currentCount=" + currentCount + " > outputByteCount=" + outputByteCount);
        }
        int finalBytesLen = finalBytes == null ? 0 : finalBytes.length;
        long diff = outputByteCount - (currentCount - out.length) - finalBytesLen;
        currentCount = (outputByteCount - finalBytesLen);
        aux = null;
        return Arrays.copyOf(out, (int)diff);
      }
    }
    return out;
  }
  
  private int checkMax(int delta)
  {
    if (outputByteCount + delta > 68719476704L)
    {
      securityViolated = true;
      throw new SecurityException("Number of bytes processed has exceeded the maximum allowed by AES/GCM; [outputByteCount=" + outputByteCount + ", delta=" + delta + "]");
    }
    return delta;
  }
  
  long mark()
  {
    return markedCount = aux == null ? outputByteCount : currentCount;
  }
  
  boolean markSupported()
  {
    return true;
  }
  
  void reset()
  {
    if ((markedCount < outputByteCount) || (invisiblyProcessed)) {
      try
      {
        aux = createAuxiliary(markedCount);
        
        currentCount = markedCount;
      }
      catch (Exception e)
      {
        throw ((e instanceof RuntimeException) ? (RuntimeException)e : new IllegalStateException(e));
      }
    }
  }
  
  byte[] getFinalBytes()
  {
    return finalBytes == null ? null : (byte[])finalBytes.clone();
  }
  
  byte[] getTag()
  {
    return (getCipherMode() != 1) || (finalBytes == null) ? null : 
    
      Arrays.copyOfRange(finalBytes, finalBytes.length - tagLen, finalBytes.length);
  }
  
  long getOutputByteCount()
  {
    return outputByteCount;
  }
  
  long getCurrentCount()
  {
    return currentCount;
  }
  
  long getMarkedCount()
  {
    return markedCount;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.GCMCipherLite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */