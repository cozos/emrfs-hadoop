package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.NTCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.UsernamePasswordCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.PasswordAuthentication;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading=ThreadingBehavior.SAFE)
public class SystemDefaultCredentialsProvider
  implements CredentialsProvider
{
  private static final Map<String, String> SCHEME_MAP = new ConcurrentHashMap();
  private final BasicCredentialsProvider internal;
  
  static
  {
    SCHEME_MAP.put("Basic".toUpperCase(Locale.ROOT), "Basic");
    SCHEME_MAP.put("Digest".toUpperCase(Locale.ROOT), "Digest");
    SCHEME_MAP.put("NTLM".toUpperCase(Locale.ROOT), "NTLM");
    SCHEME_MAP.put("Negotiate".toUpperCase(Locale.ROOT), "SPNEGO");
    SCHEME_MAP.put("Kerberos".toUpperCase(Locale.ROOT), "Kerberos");
  }
  
  private static String translateScheme(String key)
  {
    if (key == null) {
      return null;
    }
    String s = (String)SCHEME_MAP.get(key);
    return s != null ? s : key;
  }
  
  public SystemDefaultCredentialsProvider()
  {
    internal = new BasicCredentialsProvider();
  }
  
  public void setCredentials(AuthScope authscope, Credentials credentials)
  {
    internal.setCredentials(authscope, credentials);
  }
  
  private static PasswordAuthentication getSystemCreds(String protocol, AuthScope authscope, Authenticator.RequestorType requestorType)
  {
    return Authenticator.requestPasswordAuthentication(authscope.getHost(), null, authscope.getPort(), protocol, null, translateScheme(authscope.getScheme()), null, requestorType);
  }
  
  public Credentials getCredentials(AuthScope authscope)
  {
    Args.notNull(authscope, "Auth scope");
    Credentials localcreds = internal.getCredentials(authscope);
    if (localcreds != null) {
      return localcreds;
    }
    String host = authscope.getHost();
    if (host != null)
    {
      HttpHost origin = authscope.getOrigin();
      String protocol = authscope.getPort() == 443 ? "https" : origin != null ? origin.getSchemeName() : "http";
      PasswordAuthentication systemcreds = getSystemCreds(protocol, authscope, Authenticator.RequestorType.SERVER);
      if (systemcreds == null) {
        systemcreds = getSystemCreds(protocol, authscope, Authenticator.RequestorType.PROXY);
      }
      if (systemcreds == null)
      {
        String proxyHost = System.getProperty(protocol + ".proxyHost");
        if (proxyHost != null)
        {
          String proxyPort = System.getProperty(protocol + ".proxyPort");
          if (proxyPort != null) {
            try
            {
              AuthScope systemScope = new AuthScope(proxyHost, Integer.parseInt(proxyPort));
              if (authscope.match(systemScope) >= 0)
              {
                String proxyUser = System.getProperty(protocol + ".proxyUser");
                if (proxyUser != null)
                {
                  String proxyPassword = System.getProperty(protocol + ".proxyPassword");
                  systemcreds = new PasswordAuthentication(proxyUser, proxyPassword != null ? proxyPassword.toCharArray() : new char[0]);
                }
              }
            }
            catch (NumberFormatException ex) {}
          }
        }
      }
      if (systemcreds != null)
      {
        String domain = System.getProperty("http.auth.ntlm.domain");
        if (domain != null) {
          return new NTCredentials(systemcreds.getUserName(), new String(systemcreds.getPassword()), null, domain);
        }
        if ("NTLM".equalsIgnoreCase(authscope.getScheme())) {
          return new NTCredentials(systemcreds.getUserName(), new String(systemcreds.getPassword()), null, null);
        }
        return new UsernamePasswordCredentials(systemcreds.getUserName(), new String(systemcreds.getPassword()));
      }
    }
    return null;
  }
  
  public void clear()
  {
    internal.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.SystemDefaultCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */