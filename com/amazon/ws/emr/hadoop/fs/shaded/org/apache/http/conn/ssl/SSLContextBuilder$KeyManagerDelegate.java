package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.X509KeyManager;

class SSLContextBuilder$KeyManagerDelegate
  implements X509KeyManager
{
  private final X509KeyManager keyManager;
  private final PrivateKeyStrategy aliasStrategy;
  
  SSLContextBuilder$KeyManagerDelegate(X509KeyManager keyManager, PrivateKeyStrategy aliasStrategy)
  {
    this.keyManager = keyManager;
    this.aliasStrategy = aliasStrategy;
  }
  
  public String[] getClientAliases(String keyType, Principal[] issuers)
  {
    return keyManager.getClientAliases(keyType, issuers);
  }
  
  public String chooseClientAlias(String[] keyTypes, Principal[] issuers, Socket socket)
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
    return aliasStrategy.chooseAlias(validAliases, socket);
  }
  
  public String[] getServerAliases(String keyType, Principal[] issuers)
  {
    return keyManager.getServerAliases(keyType, issuers);
  }
  
  public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket)
  {
    Map<String, PrivateKeyDetails> validAliases = new HashMap();
    String[] aliases = keyManager.getServerAliases(keyType, issuers);
    if (aliases != null) {
      for (String alias : aliases) {
        validAliases.put(alias, new PrivateKeyDetails(keyType, keyManager.getCertificateChain(alias)));
      }
    }
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SSLContextBuilder.KeyManagerDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */