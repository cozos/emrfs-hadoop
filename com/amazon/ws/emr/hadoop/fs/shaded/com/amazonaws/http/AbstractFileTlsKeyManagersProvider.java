package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

@SdkInternalApi
abstract class AbstractFileTlsKeyManagersProvider
  implements TlsKeyManagersProvider
{
  private static final Log log = LogFactory.getLog(AbstractFileTlsKeyManagersProvider.class);
  
  protected final KeyManager[] createKeyManagers(File storePath, String storeType, char[] password)
    throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, UnrecoverableKeyException
  {
    KeyStore ks = createKeyStore(storePath, storeType, password);
    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
    kmf.init(ks, password);
    return kmf.getKeyManagers();
  }
  
  private KeyStore createKeyStore(File storePath, String storeType, char[] password)
    throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException
  {
    KeyStore ks = KeyStore.getInstance(storeType);
    InputStream storeIs = null;
    try
    {
      storeIs = new FileInputStream(storePath);
      ks.load(storeIs, password);
      return ks;
    }
    finally
    {
      if (storeIs != null) {
        IOUtils.closeQuietly(storeIs, log);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AbstractFileTlsKeyManagersProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */