package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JavaVersionParser.JavaVersion;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;

public class ShouldClearSslSessionPredicate
  extends SdkPredicate<SSLException>
{
  public static final JavaVersionParser.JavaVersion FIXED_JAVA_7 = new JavaVersionParser.JavaVersion(Integer.valueOf(1), Integer.valueOf(7), Integer.valueOf(0), Integer.valueOf(85));
  public static final JavaVersionParser.JavaVersion FIXED_JAVA_8 = new JavaVersionParser.JavaVersion(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(0), Integer.valueOf(60));
  private static List<String> EXCEPTION_MESSAGE_WHITELIST = Arrays.asList(new String[] { "server certificate change is restricted", "peer not authenticated" });
  private final JavaVersionParser.JavaVersion javaVersion;
  
  public ShouldClearSslSessionPredicate(JavaVersionParser.JavaVersion javaVersion)
  {
    this.javaVersion = javaVersion;
  }
  
  public boolean test(SSLException sslEx)
  {
    return (isExceptionAffected(sslEx.getMessage())) && (isJvmAffected());
  }
  
  private boolean isJvmAffected()
  {
    switch (javaVersion.getKnownVersion())
    {
    case JAVA_6: 
      return true;
    case JAVA_7: 
      return javaVersion.compareTo(FIXED_JAVA_7) < 0;
    case JAVA_8: 
      return javaVersion.compareTo(FIXED_JAVA_8) < 0;
    case JAVA_9: 
      return false;
    case UNKNOWN: 
      return true;
    }
    return true;
  }
  
  private boolean isExceptionAffected(String exceptionMessage)
  {
    if (exceptionMessage != null) {
      for (String affectedMessage : EXCEPTION_MESSAGE_WHITELIST) {
        if (exceptionMessage.contains(affectedMessage)) {
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.ShouldClearSslSessionPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */