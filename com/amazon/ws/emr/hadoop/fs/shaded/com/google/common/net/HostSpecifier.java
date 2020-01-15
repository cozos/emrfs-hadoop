package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
public final class HostSpecifier
{
  private final String canonicalForm;
  
  private HostSpecifier(String canonicalForm)
  {
    this.canonicalForm = canonicalForm;
  }
  
  /* Error */
  public static HostSpecifier fromValid(String specifier)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostAndPort:fromString	(Ljava/lang/String;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostAndPort;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 31	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostAndPort:hasPort	()Z
    //   9: ifne +7 -> 16
    //   12: iconst_1
    //   13: goto +4 -> 17
    //   16: iconst_0
    //   17: invokestatic 37	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Preconditions:checkArgument	(Z)V
    //   20: aload_1
    //   21: invokevirtual 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostAndPort:getHostText	()Ljava/lang/String;
    //   24: astore_2
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_2
    //   28: invokestatic 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/InetAddresses:forString	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   31: astore_3
    //   32: goto +5 -> 37
    //   35: astore 4
    //   37: aload_3
    //   38: ifnull +15 -> 53
    //   41: new 2	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostSpecifier
    //   44: dup
    //   45: aload_3
    //   46: invokestatic 55	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/InetAddresses:toUriString	(Ljava/net/InetAddress;)Ljava/lang/String;
    //   49: invokespecial 57	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostSpecifier:<init>	(Ljava/lang/String;)V
    //   52: areturn
    //   53: aload_2
    //   54: invokestatic 63	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/InternetDomainName:from	(Ljava/lang/String;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/InternetDomainName;
    //   57: astore 4
    //   59: aload 4
    //   61: invokevirtual 66	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/InternetDomainName:hasPublicSuffix	()Z
    //   64: ifeq +16 -> 80
    //   67: new 2	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostSpecifier
    //   70: dup
    //   71: aload 4
    //   73: invokevirtual 69	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/InternetDomainName:toString	()Ljava/lang/String;
    //   76: invokespecial 57	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostSpecifier:<init>	(Ljava/lang/String;)V
    //   79: areturn
    //   80: new 21	java/lang/IllegalArgumentException
    //   83: dup
    //   84: ldc 71
    //   86: aload_2
    //   87: invokestatic 75	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   90: dup
    //   91: invokevirtual 79	java/lang/String:length	()I
    //   94: ifeq +9 -> 103
    //   97: invokevirtual 83	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   100: goto +12 -> 112
    //   103: pop
    //   104: new 49	java/lang/String
    //   107: dup_x1
    //   108: swap
    //   109: invokespecial 84	java/lang/String:<init>	(Ljava/lang/String;)V
    //   112: invokespecial 85	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    // Line number table:
    //   Java source line #78	-> byte code offset #0
    //   Java source line #79	-> byte code offset #5
    //   Java source line #80	-> byte code offset #20
    //   Java source line #86	-> byte code offset #25
    //   Java source line #88	-> byte code offset #27
    //   Java source line #91	-> byte code offset #32
    //   Java source line #89	-> byte code offset #35
    //   Java source line #93	-> byte code offset #37
    //   Java source line #94	-> byte code offset #41
    //   Java source line #100	-> byte code offset #53
    //   Java source line #102	-> byte code offset #59
    //   Java source line #103	-> byte code offset #67
    //   Java source line #106	-> byte code offset #80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	specifier	String
    //   5	111	1	parsedHost	HostAndPort
    //   25	91	2	host	String
    //   27	89	3	addr	java.net.InetAddress
    //   37	0	4	e	IllegalArgumentException
    //   59	57	4	domain	InternetDomainName
    // Exception table:
    //   from	to	target	type
    //   27	32	35	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public static HostSpecifier from(String specifier)
    throws java.text.ParseException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 99	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostSpecifier:fromValid	(Ljava/lang/String;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostSpecifier;
    //   4: areturn
    //   5: astore_1
    //   6: new 97	java/text/ParseException
    //   9: dup
    //   10: ldc 101
    //   12: aload_0
    //   13: invokestatic 75	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: dup
    //   17: invokevirtual 79	java/lang/String:length	()I
    //   20: ifeq +9 -> 29
    //   23: invokevirtual 83	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   26: goto +12 -> 38
    //   29: pop
    //   30: new 49	java/lang/String
    //   33: dup_x1
    //   34: swap
    //   35: invokespecial 84	java/lang/String:<init>	(Ljava/lang/String;)V
    //   38: iconst_0
    //   39: invokespecial 104	java/text/ParseException:<init>	(Ljava/lang/String;I)V
    //   42: astore_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 108	java/text/ParseException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   48: pop
    //   49: aload_2
    //   50: athrow
    // Line number table:
    //   Java source line #121	-> byte code offset #0
    //   Java source line #122	-> byte code offset #5
    //   Java source line #127	-> byte code offset #6
    //   Java source line #129	-> byte code offset #43
    //   Java source line #130	-> byte code offset #49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	specifier	String
    //   6	45	1	e	IllegalArgumentException
    //   43	8	2	parseException	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   0	4	5	java/lang/IllegalArgumentException
  }
  
  public static boolean isValid(String specifier)
  {
    try
    {
      fromValid(specifier);
      return true;
    }
    catch (IllegalArgumentException e) {}
    return false;
  }
  
  public boolean equals(@Nullable Object other)
  {
    if (this == other) {
      return true;
    }
    if ((other instanceof HostSpecifier))
    {
      HostSpecifier that = (HostSpecifier)other;
      return canonicalForm.equals(canonicalForm);
    }
    return false;
  }
  
  public int hashCode()
  {
    return canonicalForm.hashCode();
  }
  
  public String toString()
  {
    return canonicalForm;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net.HostSpecifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */