package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;

final class S3CryptoScheme
{
  static final String AES = "AES";
  static final String RSA = "RSA";
  private final S3KeyWrapScheme kwScheme;
  private final ContentCryptoScheme contentCryptoScheme;
  
  private S3CryptoScheme(ContentCryptoScheme contentCryptoScheme, S3KeyWrapScheme kwScheme)
  {
    this.contentCryptoScheme = contentCryptoScheme;
    this.kwScheme = kwScheme;
  }
  
  ContentCryptoScheme getContentCryptoScheme()
  {
    return contentCryptoScheme;
  }
  
  S3KeyWrapScheme getKeyWrapScheme()
  {
    return kwScheme;
  }
  
  static boolean isAesGcm(String cipherAlgorithm)
  {
    return ContentCryptoScheme.AES_GCM.getCipherAlgorithm().equals(cipherAlgorithm);
  }
  
  static S3CryptoScheme from(CryptoMode mode)
  {
    switch (mode)
    {
    case EncryptionOnly: 
      return new S3CryptoScheme(ContentCryptoScheme.AES_CBC, S3KeyWrapScheme.NONE);
    case AuthenticatedEncryption: 
    case StrictAuthenticatedEncryption: 
      return new S3CryptoScheme(ContentCryptoScheme.AES_GCM, new S3KeyWrapScheme());
    }
    throw new IllegalStateException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3CryptoScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */