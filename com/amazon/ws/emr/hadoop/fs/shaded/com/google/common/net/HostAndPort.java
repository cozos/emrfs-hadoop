package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@Immutable
@GwtCompatible
public final class HostAndPort
  implements Serializable
{
  private static final int NO_PORT = -1;
  private final String host;
  private final int port;
  private final boolean hasBracketlessColons;
  private static final long serialVersionUID = 0L;
  
  private HostAndPort(String host, int port, boolean hasBracketlessColons)
  {
    this.host = host;
    this.port = port;
    this.hasBracketlessColons = hasBracketlessColons;
  }
  
  public String getHostText()
  {
    return host;
  }
  
  public boolean hasPort()
  {
    return port >= 0;
  }
  
  public int getPort()
  {
    Preconditions.checkState(hasPort());
    return port;
  }
  
  public int getPortOrDefault(int defaultPort)
  {
    return hasPort() ? port : defaultPort;
  }
  
  public static HostAndPort fromParts(String host, int port)
  {
    Preconditions.checkArgument(isValidPort(port), "Port out of range: %s", new Object[] { Integer.valueOf(port) });
    HostAndPort parsedHost = fromString(host);
    Preconditions.checkArgument(!parsedHost.hasPort(), "Host has a port: %s", new Object[] { host });
    return new HostAndPort(host, port, hasBracketlessColons);
  }
  
  public static HostAndPort fromHost(String host)
  {
    HostAndPort parsedHost = fromString(host);
    Preconditions.checkArgument(!parsedHost.hasPort(), "Host has a port: %s", new Object[] { host });
    return parsedHost;
  }
  
  /* Error */
  public static HostAndPort fromString(String hostPortString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 86	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aconst_null
    //   6: astore_1
    //   7: iconst_0
    //   8: istore_2
    //   9: aload_0
    //   10: ldc 88
    //   12: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   15: ifeq +20 -> 35
    //   18: aload_0
    //   19: invokestatic 98	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostAndPort:getHostAndPortFromBracketedHost	(Ljava/lang/String;)[Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: iconst_0
    //   25: aaload
    //   26: astore 4
    //   28: aload_3
    //   29: iconst_1
    //   30: aaload
    //   31: astore_1
    //   32: goto +59 -> 91
    //   35: aload_0
    //   36: bipush 58
    //   38: invokevirtual 101	java/lang/String:indexOf	(I)I
    //   41: istore_3
    //   42: iload_3
    //   43: iflt +35 -> 78
    //   46: aload_0
    //   47: bipush 58
    //   49: iload_3
    //   50: iconst_1
    //   51: iadd
    //   52: invokevirtual 104	java/lang/String:indexOf	(II)I
    //   55: iconst_m1
    //   56: if_icmpne +22 -> 78
    //   59: aload_0
    //   60: iconst_0
    //   61: iload_3
    //   62: invokevirtual 108	java/lang/String:substring	(II)Ljava/lang/String;
    //   65: astore 4
    //   67: aload_0
    //   68: iload_3
    //   69: iconst_1
    //   70: iadd
    //   71: invokevirtual 111	java/lang/String:substring	(I)Ljava/lang/String;
    //   74: astore_1
    //   75: goto +16 -> 91
    //   78: aload_0
    //   79: astore 4
    //   81: iload_3
    //   82: iflt +7 -> 89
    //   85: iconst_1
    //   86: goto +4 -> 90
    //   89: iconst_0
    //   90: istore_2
    //   91: iconst_m1
    //   92: istore_3
    //   93: aload_1
    //   94: invokestatic 116	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Strings:isNullOrEmpty	(Ljava/lang/String;)Z
    //   97: ifne +93 -> 190
    //   100: aload_1
    //   101: ldc 118
    //   103: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   106: ifne +7 -> 113
    //   109: iconst_1
    //   110: goto +4 -> 114
    //   113: iconst_0
    //   114: ldc 120
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: aastore
    //   124: invokestatic 70	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Preconditions:checkArgument	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_1
    //   128: invokestatic 124	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   131: istore_3
    //   132: goto +41 -> 173
    //   135: astore 5
    //   137: new 126	java/lang/IllegalArgumentException
    //   140: dup
    //   141: ldc -128
    //   143: aload_0
    //   144: invokestatic 131	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   147: dup
    //   148: invokevirtual 134	java/lang/String:length	()I
    //   151: ifeq +9 -> 160
    //   154: invokevirtual 138	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   157: goto +12 -> 169
    //   160: pop
    //   161: new 90	java/lang/String
    //   164: dup_x1
    //   165: swap
    //   166: invokespecial 141	java/lang/String:<init>	(Ljava/lang/String;)V
    //   169: invokespecial 142	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   172: athrow
    //   173: iload_3
    //   174: invokestatic 58	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostAndPort:isValidPort	(I)Z
    //   177: ldc -112
    //   179: iconst_1
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_0
    //   186: aastore
    //   187: invokestatic 70	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Preconditions:checkArgument	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   190: new 2	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostAndPort
    //   193: dup
    //   194: aload 4
    //   196: iload_3
    //   197: iload_2
    //   198: invokespecial 78	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/net/HostAndPort:<init>	(Ljava/lang/String;IZ)V
    //   201: areturn
    // Line number table:
    //   Java source line #168	-> byte code offset #0
    //   Java source line #170	-> byte code offset #5
    //   Java source line #171	-> byte code offset #7
    //   Java source line #173	-> byte code offset #9
    //   Java source line #174	-> byte code offset #18
    //   Java source line #175	-> byte code offset #23
    //   Java source line #176	-> byte code offset #28
    //   Java source line #177	-> byte code offset #32
    //   Java source line #178	-> byte code offset #35
    //   Java source line #179	-> byte code offset #42
    //   Java source line #181	-> byte code offset #59
    //   Java source line #182	-> byte code offset #67
    //   Java source line #185	-> byte code offset #78
    //   Java source line #186	-> byte code offset #81
    //   Java source line #190	-> byte code offset #91
    //   Java source line #191	-> byte code offset #93
    //   Java source line #194	-> byte code offset #100
    //   Java source line #196	-> byte code offset #127
    //   Java source line #199	-> byte code offset #132
    //   Java source line #197	-> byte code offset #135
    //   Java source line #198	-> byte code offset #137
    //   Java source line #200	-> byte code offset #173
    //   Java source line #203	-> byte code offset #190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	hostPortString	String
    //   7	195	1	portString	String
    //   9	193	2	hasBracketlessColons	boolean
    //   23	9	3	hostAndPort	String[]
    //   42	49	3	colonPos	int
    //   93	109	3	port	int
    //   28	7	4	host	String
    //   67	11	4	host	String
    //   81	121	4	host	String
    //   137	36	5	e	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   127	132	135	java/lang/NumberFormatException
  }
  
  private static String[] getHostAndPortFromBracketedHost(String hostPortString)
  {
    int colonIndex = 0;
    int closeBracketIndex = 0;
    Preconditions.checkArgument(hostPortString.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", new Object[] { hostPortString });
    
    colonIndex = hostPortString.indexOf(':');
    closeBracketIndex = hostPortString.lastIndexOf(']');
    Preconditions.checkArgument((colonIndex > -1) && (closeBracketIndex > colonIndex), "Invalid bracketed host/port: %s", new Object[] { hostPortString });
    
    String host = hostPortString.substring(1, closeBracketIndex);
    if (closeBracketIndex + 1 == hostPortString.length()) {
      return new String[] { host, "" };
    }
    Preconditions.checkArgument(hostPortString.charAt(closeBracketIndex + 1) == ':', "Only a colon may follow a close bracket: %s", new Object[] { hostPortString });
    for (int i = closeBracketIndex + 2; i < hostPortString.length(); i++) {
      Preconditions.checkArgument(Character.isDigit(hostPortString.charAt(i)), "Port must be numeric: %s", new Object[] { hostPortString });
    }
    return new String[] { host, hostPortString.substring(closeBracketIndex + 2) };
  }
  
  public HostAndPort withDefaultPort(int defaultPort)
  {
    Preconditions.checkArgument(isValidPort(defaultPort));
    if ((hasPort()) || (port == defaultPort)) {
      return this;
    }
    return new HostAndPort(host, defaultPort, hasBracketlessColons);
  }
  
  public HostAndPort requireBracketsForIPv6()
  {
    Preconditions.checkArgument(!hasBracketlessColons, "Possible bracketless IPv6 literal: %s", new Object[] { host });
    return this;
  }
  
  public boolean equals(@Nullable Object other)
  {
    if (this == other) {
      return true;
    }
    if ((other instanceof HostAndPort))
    {
      HostAndPort that = (HostAndPort)other;
      return (Objects.equal(host, host)) && (port == port) && (hasBracketlessColons == hasBracketlessColons);
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { host, Integer.valueOf(port), Boolean.valueOf(hasBracketlessColons) });
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder(host.length() + 8);
    if (host.indexOf(':') >= 0) {
      builder.append('[').append(host).append(']');
    } else {
      builder.append(host);
    }
    if (hasPort()) {
      builder.append(':').append(port);
    }
    return builder.toString();
  }
  
  private static boolean isValidPort(int port)
  {
    return (port >= 0) && (port <= 65535);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.net.HostAndPort
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */