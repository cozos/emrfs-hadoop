package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import java.security.MessageDigest;

class NTLMEngineImpl$HMACMD5
{
  protected final byte[] ipad;
  protected final byte[] opad;
  protected final MessageDigest md5;
  
  NTLMEngineImpl$HMACMD5(byte[] input)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.NTLMEngineImpl.HMACMD5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */