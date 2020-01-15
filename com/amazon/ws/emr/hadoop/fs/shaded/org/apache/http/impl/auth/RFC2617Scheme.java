package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Consts;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.ChallengeState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.MalformedChallengeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeaderValueParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.HeaderValueParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharsetUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class RFC2617Scheme
  extends AuthSchemeBase
  implements Serializable
{
  private static final long serialVersionUID = -2845454858205884623L;
  private final Map<String, String> params;
  private transient Charset credentialsCharset;
  
  @Deprecated
  public RFC2617Scheme(ChallengeState challengeState)
  {
    super(challengeState);
    params = new HashMap();
    credentialsCharset = Consts.ASCII;
  }
  
  public RFC2617Scheme(Charset credentialsCharset)
  {
    params = new HashMap();
    this.credentialsCharset = (credentialsCharset != null ? credentialsCharset : Consts.ASCII);
  }
  
  public RFC2617Scheme()
  {
    this(Consts.ASCII);
  }
  
  public Charset getCredentialsCharset()
  {
    return credentialsCharset != null ? credentialsCharset : Consts.ASCII;
  }
  
  String getCredentialsCharset(HttpRequest request)
  {
    String charset = (String)request.getParams().getParameter("http.auth.credential-charset");
    if (charset == null) {
      charset = getCredentialsCharset().name();
    }
    return charset;
  }
  
  protected void parseChallenge(CharArrayBuffer buffer, int pos, int len)
    throws MalformedChallengeException
  {
    HeaderValueParser parser = BasicHeaderValueParser.INSTANCE;
    ParserCursor cursor = new ParserCursor(pos, buffer.length());
    HeaderElement[] elements = parser.parseElements(buffer, cursor);
    params.clear();
    for (HeaderElement element : elements) {
      params.put(element.getName().toLowerCase(Locale.ROOT), element.getValue());
    }
  }
  
  protected Map<String, String> getParameters()
  {
    return params;
  }
  
  public String getParameter(String name)
  {
    if (name == null) {
      return null;
    }
    return (String)params.get(name.toLowerCase(Locale.ROOT));
  }
  
  public String getRealm()
  {
    return getParameter("realm");
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    out.defaultWriteObject();
    out.writeUTF(credentialsCharset.name());
    out.writeObject(challengeState);
  }
  
  private void readObject(ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    in.defaultReadObject();
    credentialsCharset = CharsetUtils.get(in.readUTF());
    if (credentialsCharset == null) {
      credentialsCharset = Consts.ASCII;
    }
    challengeState = ((ChallengeState)in.readObject());
  }
  
  private void readObjectNoData()
    throws ObjectStreamException
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.RFC2617Scheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */