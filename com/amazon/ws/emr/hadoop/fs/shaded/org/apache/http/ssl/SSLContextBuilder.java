package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;

public class SSLContextBuilder
{
  static final String TLS = "TLS";
  private String protocol;
  private final Set<KeyManager> keyManagers;
  private String keyManagerFactoryAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
  private String keyStoreType = KeyStore.getDefaultType();
  private final Set<TrustManager> trustManagers;
  private String trustManagerFactoryAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
  private SecureRandom secureRandom;
  private Provider provider;
  
  public static SSLContextBuilder create()
  {
    return new SSLContextBuilder();
  }
  
  public SSLContextBuilder()
  {
    keyManagers = new LinkedHashSet();
    trustManagers = new LinkedHashSet();
  }
  
  @Deprecated
  public SSLContextBuilder useProtocol(String protocol)
  {
    this.protocol = protocol;
    return this;
  }
  
  public SSLContextBuilder setProtocol(String protocol)
  {
    this.protocol = protocol;
    return this;
  }
  
  public SSLContextBuilder setSecureRandom(SecureRandom secureRandom)
  {
    this.secureRandom = secureRandom;
    return this;
  }
  
  public SSLContextBuilder setProvider(Provider provider)
  {
    this.provider = provider;
    return this;
  }
  
  public SSLContextBuilder setProvider(String name)
  {
    provider = Security.getProvider(name);
    return this;
  }
  
  public SSLContextBuilder setKeyStoreType(String keyStoreType)
  {
    this.keyStoreType = keyStoreType;
    return this;
  }
  
  public SSLContextBuilder setKeyManagerFactoryAlgorithm(String keyManagerFactoryAlgorithm)
  {
    this.keyManagerFactoryAlgorithm = keyManagerFactoryAlgorithm;
    return this;
  }
  
  public SSLContextBuilder setTrustManagerFactoryAlgorithm(String trustManagerFactoryAlgorithm)
  {
    this.trustManagerFactoryAlgorithm = trustManagerFactoryAlgorithm;
    return this;
  }
  
  public SSLContextBuilder loadTrustMaterial(KeyStore truststore, TrustStrategy trustStrategy)
    throws NoSuchAlgorithmException, KeyStoreException
  {
    TrustManagerFactory tmfactory = TrustManagerFactory.getInstance(trustManagerFactoryAlgorithm == null ? TrustManagerFactory.getDefaultAlgorithm() : trustManagerFactoryAlgorithm);
    
    tmfactory.init(truststore);
    TrustManager[] tms = tmfactory.getTrustManagers();
    if (tms != null)
    {
      if (trustStrategy != null) {
        for (int i = 0; i < tms.length; i++)
        {
          TrustManager tm = tms[i];
          if ((tm instanceof X509TrustManager)) {
            tms[i] = new TrustManagerDelegate((X509TrustManager)tm, trustStrategy);
          }
        }
      }
      for (TrustManager tm : tms) {
        trustManagers.add(tm);
      }
    }
    return this;
  }
  
  public SSLContextBuilder loadTrustMaterial(TrustStrategy trustStrategy)
    throws NoSuchAlgorithmException, KeyStoreException
  {
    return loadTrustMaterial(null, trustStrategy);
  }
  
  public SSLContextBuilder loadTrustMaterial(File file, char[] storePassword, TrustStrategy trustStrategy)
    throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException
  {
    Args.notNull(file, "Truststore file");
    KeyStore trustStore = KeyStore.getInstance(keyStoreType);
    FileInputStream instream = new FileInputStream(file);
    try
    {
      trustStore.load(instream, storePassword);
    }
    finally
    {
      instream.close();
    }
    return loadTrustMaterial(trustStore, trustStrategy);
  }
  
  public SSLContextBuilder loadTrustMaterial(File file, char[] storePassword)
    throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException
  {
    return loadTrustMaterial(file, storePassword, null);
  }
  
  public SSLContextBuilder loadTrustMaterial(File file)
    throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException
  {
    return loadTrustMaterial(file, null);
  }
  
  public SSLContextBuilder loadTrustMaterial(URL url, char[] storePassword, TrustStrategy trustStrategy)
    throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException
  {
    Args.notNull(url, "Truststore URL");
    KeyStore trustStore = KeyStore.getInstance(keyStoreType);
    InputStream instream = url.openStream();
    try
    {
      trustStore.load(instream, storePassword);
    }
    finally
    {
      instream.close();
    }
    return loadTrustMaterial(trustStore, trustStrategy);
  }
  
  public SSLContextBuilder loadTrustMaterial(URL url, char[] storePassword)
    throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException
  {
    return loadTrustMaterial(url, storePassword, null);
  }
  
  public SSLContextBuilder loadKeyMaterial(KeyStore keystore, char[] keyPassword, PrivateKeyStrategy aliasStrategy)
    throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException
  {
    KeyManagerFactory kmfactory = KeyManagerFactory.getInstance(keyManagerFactoryAlgorithm == null ? KeyManagerFactory.getDefaultAlgorithm() : keyManagerFactoryAlgorithm);
    
    kmfactory.init(keystore, keyPassword);
    KeyManager[] kms = kmfactory.getKeyManagers();
    if (kms != null)
    {
      if (aliasStrategy != null) {
        for (int i = 0; i < kms.length; i++)
        {
          KeyManager km = kms[i];
          if ((km instanceof X509ExtendedKeyManager)) {
            kms[i] = new KeyManagerDelegate((X509ExtendedKeyManager)km, aliasStrategy);
          }
        }
      }
      for (KeyManager km : kms) {
        keyManagers.add(km);
      }
    }
    return this;
  }
  
  public SSLContextBuilder loadKeyMaterial(KeyStore keystore, char[] keyPassword)
    throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException
  {
    return loadKeyMaterial(keystore, keyPassword, null);
  }
  
  public SSLContextBuilder loadKeyMaterial(File file, char[] storePassword, char[] keyPassword, PrivateKeyStrategy aliasStrategy)
    throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException
  {
    Args.notNull(file, "Keystore file");
    KeyStore identityStore = KeyStore.getInstance(keyStoreType);
    FileInputStream instream = new FileInputStream(file);
    try
    {
      identityStore.load(instream, storePassword);
    }
    finally
    {
      instream.close();
    }
    return loadKeyMaterial(identityStore, keyPassword, aliasStrategy);
  }
  
  public SSLContextBuilder loadKeyMaterial(File file, char[] storePassword, char[] keyPassword)
    throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException
  {
    return loadKeyMaterial(file, storePassword, keyPassword, null);
  }
  
  public SSLContextBuilder loadKeyMaterial(URL url, char[] storePassword, char[] keyPassword, PrivateKeyStrategy aliasStrategy)
    throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException
  {
    Args.notNull(url, "Keystore URL");
    KeyStore identityStore = KeyStore.getInstance(keyStoreType);
    InputStream instream = url.openStream();
    try
    {
      identityStore.load(instream, storePassword);
    }
    finally
    {
      instream.close();
    }
    return loadKeyMaterial(identityStore, keyPassword, aliasStrategy);
  }
  
  public SSLContextBuilder loadKeyMaterial(URL url, char[] storePassword, char[] keyPassword)
    throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException
  {
    return loadKeyMaterial(url, storePassword, keyPassword, null);
  }
  
  protected void initSSLContext(SSLContext sslContext, Collection<KeyManager> keyManagers, Collection<TrustManager> trustManagers, SecureRandom secureRandom)
    throws KeyManagementException
  {
    sslContext.init(!keyManagers.isEmpty() ? (KeyManager[])keyManagers.toArray(new KeyManager[keyManagers.size()]) : null, !trustManagers.isEmpty() ? (TrustManager[])trustManagers.toArray(new TrustManager[trustManagers.size()]) : null, secureRandom);
  }
  
  public SSLContext build()
    throws NoSuchAlgorithmException, KeyManagementException
  {
    String protocolStr = protocol != null ? protocol : "TLS";
    SSLContext sslContext;
    SSLContext sslContext;
    if (provider != null) {
      sslContext = SSLContext.getInstance(protocolStr, provider);
    } else {
      sslContext = SSLContext.getInstance(protocolStr);
    }
    initSSLContext(sslContext, keyManagers, trustManagers, secureRandom);
    return sslContext;
  }
  
  static class TrustManagerDelegate
    implements X509TrustManager
  {
    private final X509TrustManager trustManager;
    private final TrustStrategy trustStrategy;
    
    TrustManagerDelegate(X509TrustManager trustManager, TrustStrategy trustStrategy)
    {
      this.trustManager = trustManager;
      this.trustStrategy = trustStrategy;
    }
    
    public void checkClientTrusted(X509Certificate[] chain, String authType)
      throws CertificateException
    {
      trustManager.checkClientTrusted(chain, authType);
    }
    
    public void checkServerTrusted(X509Certificate[] chain, String authType)
      throws CertificateException
    {
      if (!trustStrategy.isTrusted(chain, authType)) {
        trustManager.checkServerTrusted(chain, authType);
      }
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return trustManager.getAcceptedIssuers();
    }
  }
  
  static class KeyManagerDelegate
    extends X509ExtendedKeyManager
  {
    private final X509ExtendedKeyManager keyManager;
    private final PrivateKeyStrategy aliasStrategy;
    
    KeyManagerDelegate(X509ExtendedKeyManager keyManager, PrivateKeyStrategy aliasStrategy)
    {
      this.keyManager = keyManager;
      this.aliasStrategy = aliasStrategy;
    }
    
    public String[] getClientAliases(String keyType, Principal[] issuers)
    {
      return keyManager.getClientAliases(keyType, issuers);
    }
    
    public Map<String, PrivateKeyDetails> getClientAliasMap(String[] keyTypes, Principal[] issuers)
    {
      Map<String, PrivateKeyDetails> validAliases = new HashMap();
      for (String keyType : keyTypes)
      {
        String[] aliases = keyManager.getClientAliases(keyType, issuers);
        if (aliases != null) {
          for (String alias : aliases) {
            validAliases.put(alias, new PrivateKeyDetails(keyType, keyManager.getCertificateChain(alias)));
          }
        }
      }
      return validAliases;
    }
    
    public Map<String, PrivateKeyDetails> getServerAliasMap(String keyType, Principal[] issuers)
    {
      Map<String, PrivateKeyDetails> validAliases = new HashMap();
      String[] aliases = keyManager.getServerAliases(keyType, issuers);
      if (aliases != null) {
        for (String alias : aliases) {
          validAliases.put(alias, new PrivateKeyDetails(keyType, keyManager.getCertificateChain(alias)));
        }
      }
      return validAliases;
    }
    
    public String chooseClientAlias(String[] keyTypes, Principal[] issuers, Socket socket)
    {
      Map<String, PrivateKeyDetails> validAliases = getClientAliasMap(keyTypes, issuers);
      return aliasStrategy.chooseAlias(validAliases, socket);
    }
    
    public String[] getServerAliases(String keyType, Principal[] issuers)
    {
      return keyManager.getServerAliases(keyType, issuers);
    }
    
    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket)
    {
      Map<String, PrivateKeyDetails> validAliases = getServerAliasMap(keyType, issuers);
      return aliasStrategy.chooseAlias(validAliases, socket);
    }
    
    public X509Certificate[] getCertificateChain(String alias)
    {
      return keyManager.getCertificateChain(alias);
    }
    
    public PrivateKey getPrivateKey(String alias)
    {
      return keyManager.getPrivateKey(alias);
    }
    
    public String chooseEngineClientAlias(String[] keyTypes, Principal[] issuers, SSLEngine sslEngine)
    {
      Map<String, PrivateKeyDetails> validAliases = getClientAliasMap(keyTypes, issuers);
      return aliasStrategy.chooseAlias(validAliases, null);
    }
    
    public String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine sslEngine)
    {
      Map<String, PrivateKeyDetails> validAliases = getServerAliasMap(keyType, issuers);
      return aliasStrategy.chooseAlias(validAliases, null);
    }
  }
  
  public String toString()
  {
    return "[provider=" + provider + ", protocol=" + protocol + ", keyStoreType=" + keyStoreType + ", keyManagerFactoryAlgorithm=" + keyManagerFactoryAlgorithm + ", keyManagers=" + keyManagers + ", trustManagerFactoryAlgorithm=" + trustManagerFactoryAlgorithm + ", trustManagers=" + trustManagers + ", secureRandom=" + secureRandom + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl.SSLContextBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */