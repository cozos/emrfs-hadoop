package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthenticationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.ChallengeState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BufferedHeader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.BasicHttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EncodingUtils;
import java.nio.charset.Charset;
import java.security.Principal;

public class BasicScheme
  extends RFC2617Scheme
{
  private static final long serialVersionUID = -1931571557597830536L;
  private boolean complete;
  
  public BasicScheme(Charset credentialsCharset)
  {
    super(credentialsCharset);
    complete = false;
  }
  
  @Deprecated
  public BasicScheme(ChallengeState challengeState)
  {
    super(challengeState);
  }
  
  public BasicScheme()
  {
    this(Consts.ASCII);
  }
  
  public String getSchemeName()
  {
    return "basic";
  }
  
  public void processChallenge(Header header)
    throws MalformedChallengeException
  {
    super.processChallenge(header);
    complete = true;
  }
  
  public boolean isComplete()
  {
    return complete;
  }
  
  public boolean isConnectionBased()
  {
    return false;
  }
  
  @Deprecated
  public Header authenticate(Credentials credentials, HttpRequest request)
    throws AuthenticationException
  {
    return authenticate(credentials, request, new BasicHttpContext());
  }
  
  public Header authenticate(Credentials credentials, HttpRequest request, HttpContext context)
    throws AuthenticationException
  {
    Args.notNull(credentials, "Credentials");
    Args.notNull(request, "HTTP request");
    StringBuilder tmp = new StringBuilder();
    tmp.append(credentials.getUserPrincipal().getName());
    tmp.append(":");
    tmp.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
    
    Base64 base64codec = new Base64(0);
    byte[] base64password = base64codec.encode(EncodingUtils.getBytes(tmp.toString(), getCredentialsCharset(request)));
    
    CharArrayBuffer buffer = new CharArrayBuffer(32);
    if (isProxy()) {
      buffer.append("Proxy-Authorization");
    } else {
      buffer.append("Authorization");
    }
    buffer.append(": Basic ");
    buffer.append(base64password, 0, base64password.length);
    
    return new BufferedHeader(buffer);
  }
  
  @Deprecated
  public static Header authenticate(Credentials credentials, String charset, boolean proxy)
  {
    Args.notNull(credentials, "Credentials");
    Args.notNull(charset, "charset");
    
    StringBuilder tmp = new StringBuilder();
    tmp.append(credentials.getUserPrincipal().getName());
    tmp.append(":");
    tmp.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
    
    byte[] base64password = Base64.encodeBase64(EncodingUtils.getBytes(tmp.toString(), charset), false);
    
    CharArrayBuffer buffer = new CharArrayBuffer(32);
    if (proxy) {
      buffer.append("Proxy-Authorization");
    } else {
      buffer.append("Authorization");
    }
    buffer.append(": Basic ");
    buffer.append(base64password, 0, base64password.length);
    
    return new BufferedHeader(buffer);
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append("BASIC [complete=").append(complete).append("]");
    
    return builder.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.BasicScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */