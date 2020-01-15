package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import java.security.Provider;
import java.security.SecureRandom;

final class CryptoConfiguration$ReadOnly
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration.ReadOnly
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */