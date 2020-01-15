package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.CryptoRuntime;
import java.io.Serializable;
import java.security.Provider;
import java.security.SecureRandom;

public class CryptoConfiguration
  implements Cloneable, Serializable
{
  private static final long serialVersionUID = -8646831898339939580L;
  private static final SecureRandom SRAND = new SecureRandom();
  private CryptoMode cryptoMode;
  private CryptoStorageMode storageMode;
  private Provider cryptoProvider;
  private boolean alwaysUseCryptoProvider;
  private SecureRandom secureRandom;
  private boolean ignoreMissingInstructionFile = true;
  private transient Region awskmsRegion;
  
  public CryptoConfiguration()
  {
    this(CryptoMode.EncryptionOnly);
  }
  
  public CryptoConfiguration(CryptoMode cryptoMode)
  {
    check(cryptoMode);
    
    storageMode = CryptoStorageMode.ObjectMetadata;
    
    cryptoProvider = null;
    secureRandom = SRAND;
    this.cryptoMode = cryptoMode;
  }
  
  public void setStorageMode(CryptoStorageMode storageMode)
  {
    this.storageMode = storageMode;
  }
  
  public CryptoConfiguration withStorageMode(CryptoStorageMode storageMode)
  {
    this.storageMode = storageMode;
    return this;
  }
  
  public CryptoStorageMode getStorageMode()
  {
    return storageMode;
  }
  
  public void setCryptoProvider(Provider cryptoProvider)
  {
    this.cryptoProvider = cryptoProvider;
  }
  
  public CryptoConfiguration withCryptoProvider(Provider cryptoProvider)
  {
    this.cryptoProvider = cryptoProvider;
    return this;
  }
  
  public Provider getCryptoProvider()
  {
    return cryptoProvider;
  }
  
  public void setAlwaysUseCryptoProvider(boolean value)
  {
    alwaysUseCryptoProvider = value;
  }
  
  public CryptoConfiguration withAlwaysUseCryptoProvider(boolean value)
  {
    alwaysUseCryptoProvider = value;
    return this;
  }
  
  public boolean getAlwaysUseCryptoProvider()
  {
    return alwaysUseCryptoProvider;
  }
  
  public SecureRandom getSecureRandom()
  {
    return secureRandom;
  }
  
  public void setSecureRandom(SecureRandom secureRandom)
  {
    this.secureRandom = secureRandom;
  }
  
  public CryptoConfiguration withSecureRandom(SecureRandom secureRandom)
  {
    this.secureRandom = secureRandom;
    return this;
  }
  
  public CryptoMode getCryptoMode()
  {
    return cryptoMode;
  }
  
  public void setCryptoMode(CryptoMode cryptoMode)
    throws UnsupportedOperationException
  {
    this.cryptoMode = cryptoMode;
    check(cryptoMode);
  }
  
  public CryptoConfiguration withCryptoMode(CryptoMode cryptoMode)
    throws UnsupportedOperationException
  {
    this.cryptoMode = cryptoMode;
    check(cryptoMode);
    return this;
  }
  
  public boolean isIgnoreMissingInstructionFile()
  {
    return ignoreMissingInstructionFile;
  }
  
  public void setIgnoreMissingInstructionFile(boolean ignoreMissingInstructionFile)
  {
    this.ignoreMissingInstructionFile = ignoreMissingInstructionFile;
  }
  
  public CryptoConfiguration withIgnoreMissingInstructionFile(boolean ignoreMissingInstructionFile)
  {
    this.ignoreMissingInstructionFile = ignoreMissingInstructionFile;
    return this;
  }
  
  private void check(CryptoMode cryptoMode)
  {
    boolean preferBC = (cryptoMode == CryptoMode.AuthenticatedEncryption) || (cryptoMode == CryptoMode.StrictAuthenticatedEncryption);
    
    boolean haveOverride = (cryptoProvider != null) && (alwaysUseCryptoProvider);
    if ((preferBC) && (!haveOverride))
    {
      if (!CryptoRuntime.isBouncyCastleAvailable())
      {
        CryptoRuntime.enableBouncyCastle();
        if (!CryptoRuntime.isBouncyCastleAvailable()) {
          throw new UnsupportedOperationException("The Bouncy castle library jar is required on the classpath to enable authenticated encryption");
        }
      }
      if (!CryptoRuntime.isAesGcmAvailable()) {
        throw new UnsupportedOperationException("More recent version of the Bouncy castle library is required to enable authenticated encryption");
      }
    }
  }
  
  public boolean isReadOnly()
  {
    return false;
  }
  
  private static final class ReadOnly
    extends CryptoConfiguration
  {
    public boolean isReadOnly()
    {
      return true;
    }
    
    public void setStorageMode(CryptoStorageMode storageMode)
    {
      throw new UnsupportedOperationException();
    }
    
    public CryptoConfiguration withStorageMode(CryptoStorageMode storageMode)
    {
      throw new UnsupportedOperationException();
    }
    
    public void setCryptoProvider(Provider cryptoProvider)
    {
      throw new UnsupportedOperationException();
    }
    
    public CryptoConfiguration withCryptoProvider(Provider cryptoProvider)
    {
      throw new UnsupportedOperationException();
    }
    
    public void setAlwaysUseCryptoProvider(boolean value)
    {
      throw new UnsupportedOperationException();
    }
    
    public CryptoConfiguration withAlwaysUseCryptoProvider(boolean value)
    {
      throw new UnsupportedOperationException();
    }
    
    public void setSecureRandom(SecureRandom random)
    {
      throw new UnsupportedOperationException();
    }
    
    public CryptoConfiguration withSecureRandom(SecureRandom random)
    {
      throw new UnsupportedOperationException();
    }
    
    public void setCryptoMode(CryptoMode cryptoMode)
    {
      throw new UnsupportedOperationException();
    }
    
    public CryptoConfiguration withCryptoMode(CryptoMode cryptoMode)
    {
      throw new UnsupportedOperationException();
    }
    
    public void setIgnoreMissingInstructionFile(boolean ignoreMissingInstructionFile)
    {
      throw new UnsupportedOperationException();
    }
    
    public CryptoConfiguration withIgnoreMissingInstructionFile(boolean ignoreMissingInstructionFile)
    {
      throw new UnsupportedOperationException();
    }
    
    public void setKmsRegion(Regions kmsRegion)
    {
      throw new UnsupportedOperationException();
    }
    
    public CryptoConfiguration withKmsRegion(Regions kmsRegion)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public CryptoConfiguration readOnly()
  {
    if (isReadOnly()) {
      return this;
    }
    return copyTo(new ReadOnly(null));
  }
  
  public CryptoConfiguration clone()
  {
    return copyTo(new CryptoConfiguration());
  }
  
  private CryptoConfiguration copyTo(CryptoConfiguration that)
  {
    cryptoMode = cryptoMode;
    storageMode = storageMode;
    cryptoProvider = cryptoProvider;
    alwaysUseCryptoProvider = alwaysUseCryptoProvider;
    secureRandom = secureRandom;
    ignoreMissingInstructionFile = ignoreMissingInstructionFile;
    awskmsRegion = awskmsRegion;
    return that;
  }
  
  @Deprecated
  public Regions getKmsRegion()
  {
    if (awskmsRegion == null) {
      return null;
    }
    return Regions.fromName(awskmsRegion.getName());
  }
  
  @Deprecated
  public void setKmsRegion(Regions kmsRegion)
  {
    if (kmsRegion != null) {
      setAwsKmsRegion(Region.getRegion(kmsRegion));
    } else {
      setAwsKmsRegion(null);
    }
  }
  
  @Deprecated
  public CryptoConfiguration withKmsRegion(Regions kmsRegion)
  {
    setKmsRegion(kmsRegion);
    return this;
  }
  
  public Region getAwsKmsRegion()
  {
    return awskmsRegion;
  }
  
  public void setAwsKmsRegion(Region awsKmsRegion)
  {
    awskmsRegion = awsKmsRegion;
  }
  
  public CryptoConfiguration withAwsKmsRegion(Region awsKmsRegion)
  {
    awskmsRegion = awsKmsRegion;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */