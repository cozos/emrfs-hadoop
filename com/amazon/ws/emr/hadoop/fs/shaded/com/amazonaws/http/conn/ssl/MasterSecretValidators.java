package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.privileged.PrivilegedMasterSecretValidator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JavaVersionParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JavaVersionParser.JavaVersion;
import java.net.Socket;

public class MasterSecretValidators
{
  private static final JavaVersionParser.JavaVersion FIXED_JAVA_6 = new JavaVersionParser.JavaVersion(Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), Integer.valueOf(91));
  private static final JavaVersionParser.JavaVersion FIXED_JAVA_7 = new JavaVersionParser.JavaVersion(Integer.valueOf(1), Integer.valueOf(7), Integer.valueOf(0), Integer.valueOf(51));
  private static final JavaVersionParser.JavaVersion FIXED_JAVA_8 = new JavaVersionParser.JavaVersion(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(0), Integer.valueOf(31));
  
  public static MasterSecretValidator getMasterSecretValidator()
  {
    return getMasterSecretValidator(JavaVersionParser.getCurrentJavaVersion());
  }
  
  public static MasterSecretValidator getMasterSecretValidator(JavaVersionParser.JavaVersion javaVersion)
  {
    switch (javaVersion.getKnownVersion())
    {
    case JAVA_6: 
      if (javaVersion.compareTo(FIXED_JAVA_6) < 0) {
        return new PrivilegedMasterSecretValidator();
      }
      break;
    case JAVA_7: 
      if (javaVersion.compareTo(FIXED_JAVA_7) < 0) {
        return new PrivilegedMasterSecretValidator();
      }
      break;
    case JAVA_8: 
      if (javaVersion.compareTo(FIXED_JAVA_8) < 0) {
        return new PrivilegedMasterSecretValidator();
      }
      break;
    }
    return new NoOpMasterSecretValidator();
  }
  
  public static class NoOpMasterSecretValidator
    implements MasterSecretValidators.MasterSecretValidator
  {
    public boolean isMasterSecretValid(Socket socket)
    {
      return true;
    }
  }
  
  public static abstract interface MasterSecretValidator
  {
    public abstract boolean isMasterSecretValid(Socket paramSocket);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.conn.ssl.MasterSecretValidators
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */