package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.spi.security;

import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.List;

public class TLSArtifacts
{
  private final PrivateKey privateKey;
  private final List<Certificate> trustedCertificates;
  private final List<Certificate> certificateChain;
  
  public TLSArtifacts(PrivateKey privateKey, List<Certificate> certificateChain)
  {
    this(privateKey, certificateChain, null);
  }
  
  public TLSArtifacts(PrivateKey privateKey, List<Certificate> certificateChain, List<Certificate> trustedCertificates)
  {
    this.privateKey = privateKey;
    this.certificateChain = certificateChain;
    this.trustedCertificates = trustedCertificates;
  }
  
  public PrivateKey getPrivateKey()
  {
    return privateKey;
  }
  
  public List<Certificate> getTrustedCertificates()
  {
    return trustedCertificates;
  }
  
  public List<Certificate> getCertificateChain()
  {
    return certificateChain;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.spi.security.TLSArtifacts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */