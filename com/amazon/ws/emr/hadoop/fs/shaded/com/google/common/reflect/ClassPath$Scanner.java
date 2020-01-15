package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedSet.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Ordering;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@VisibleForTesting
final class ClassPath$Scanner
{
  private final ImmutableSortedSet.Builder<ClassPath.ResourceInfo> resources = new ImmutableSortedSet.Builder(Ordering.usingToString());
  private final Set<URI> scannedUris = Sets.newHashSet();
  
  ImmutableSortedSet<ClassPath.ResourceInfo> getResources()
  {
    return resources.build();
  }
  
  void scan(URI uri, ClassLoader classloader)
    throws IOException
  {
    if ((uri.getScheme().equals("file")) && (scannedUris.add(uri))) {
      scanFrom(new File(uri), classloader);
    }
  }
  
  @VisibleForTesting
  void scanFrom(File file, ClassLoader classloader)
    throws IOException
  {
    if (!file.exists()) {
      return;
    }
    if (file.isDirectory()) {
      scanDirectory(file, classloader);
    } else {
      scanJar(file, classloader);
    }
  }
  
  private void scanDirectory(File directory, ClassLoader classloader)
    throws IOException
  {
    scanDirectory(directory, classloader, "", ImmutableSet.of());
  }
  
  /* Error */
  private void scanDirectory(File directory, ClassLoader classloader, String packagePrefix, ImmutableSet<File> ancestors)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 126	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   4: astore 5
    //   6: aload 4
    //   8: aload 5
    //   10: invokevirtual 129	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet:contains	(Ljava/lang/Object;)Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_1
    //   18: invokevirtual 133	java/io/File:listFiles	()[Ljava/io/File;
    //   21: astore 6
    //   23: aload 6
    //   25: ifnonnull +47 -> 72
    //   28: invokestatic 137	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/reflect/ClassPath:access$100	()Ljava/util/logging/Logger;
    //   31: aload_1
    //   32: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   38: astore 7
    //   40: new 143	java/lang/StringBuilder
    //   43: dup
    //   44: bipush 22
    //   46: aload 7
    //   48: invokevirtual 147	java/lang/String:length	()I
    //   51: iadd
    //   52: invokespecial 150	java/lang/StringBuilder:<init>	(I)V
    //   55: ldc -104
    //   57: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload 7
    //   62: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 165	java/util/logging/Logger:warning	(Ljava/lang/String;)V
    //   71: return
    //   72: invokestatic 171	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet:builder	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder;
    //   75: aload 4
    //   77: invokevirtual 175	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder:addAll	(Ljava/lang/Iterable;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder;
    //   80: aload 5
    //   82: invokevirtual 178	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder:add	(Ljava/lang/Object;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder;
    //   85: invokevirtual 180	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder:build	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet;
    //   88: astore 7
    //   90: aload 6
    //   92: astore 8
    //   94: aload 8
    //   96: arraylength
    //   97: istore 9
    //   99: iconst_0
    //   100: istore 10
    //   102: iload 10
    //   104: iload 9
    //   106: if_icmpge +157 -> 263
    //   109: aload 8
    //   111: iload 10
    //   113: aaload
    //   114: astore 11
    //   116: aload 11
    //   118: invokevirtual 185	java/io/File:getName	()Ljava/lang/String;
    //   121: astore 12
    //   123: aload 11
    //   125: invokevirtual 105	java/io/File:isDirectory	()Z
    //   128: ifeq +72 -> 200
    //   131: aload_0
    //   132: aload 11
    //   134: aload_2
    //   135: aload_3
    //   136: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: astore 13
    //   144: aload 12
    //   146: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   149: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   152: astore 14
    //   154: new 143	java/lang/StringBuilder
    //   157: dup
    //   158: iconst_1
    //   159: aload 13
    //   161: invokevirtual 147	java/lang/String:length	()I
    //   164: iadd
    //   165: aload 14
    //   167: invokevirtual 147	java/lang/String:length	()I
    //   170: iadd
    //   171: invokespecial 150	java/lang/StringBuilder:<init>	(I)V
    //   174: aload 13
    //   176: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 14
    //   181: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc -69
    //   186: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aload 7
    //   194: invokespecial 121	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/reflect/ClassPath$Scanner:scanDirectory	(Ljava/io/File;Ljava/lang/ClassLoader;Ljava/lang/String;Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet;)V
    //   197: goto +60 -> 257
    //   200: aload_3
    //   201: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   204: aload 12
    //   206: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   209: dup
    //   210: invokevirtual 147	java/lang/String:length	()I
    //   213: ifeq +9 -> 222
    //   216: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   219: goto +12 -> 231
    //   222: pop
    //   223: new 76	java/lang/String
    //   226: dup_x1
    //   227: swap
    //   228: invokespecial 193	java/lang/String:<init>	(Ljava/lang/String;)V
    //   231: astore 13
    //   233: aload 13
    //   235: ldc -61
    //   237: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   240: ifne +17 -> 257
    //   243: aload_0
    //   244: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/reflect/ClassPath$Scanner:resources	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSortedSet$Builder;
    //   247: aload 13
    //   249: aload_2
    //   250: invokestatic 198	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/reflect/ClassPath$ResourceInfo:of	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/reflect/ClassPath$ResourceInfo;
    //   253: invokevirtual 201	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSortedSet$Builder:add	(Ljava/lang/Object;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSortedSet$Builder;
    //   256: pop
    //   257: iinc 10 1
    //   260: goto -158 -> 102
    //   263: return
    // Line number table:
    //   Java source line #338	-> byte code offset #0
    //   Java source line #339	-> byte code offset #6
    //   Java source line #341	-> byte code offset #16
    //   Java source line #343	-> byte code offset #17
    //   Java source line #344	-> byte code offset #23
    //   Java source line #345	-> byte code offset #28
    //   Java source line #347	-> byte code offset #71
    //   Java source line #349	-> byte code offset #72
    //   Java source line #353	-> byte code offset #90
    //   Java source line #354	-> byte code offset #116
    //   Java source line #355	-> byte code offset #123
    //   Java source line #356	-> byte code offset #131
    //   Java source line #357	-> byte code offset #197
    //   Java source line #358	-> byte code offset #200
    //   Java source line #359	-> byte code offset #233
    //   Java source line #360	-> byte code offset #243
    //   Java source line #353	-> byte code offset #257
    //   Java source line #364	-> byte code offset #263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	Scanner
    //   0	264	1	directory	File
    //   0	264	2	classloader	ClassLoader
    //   0	264	3	packagePrefix	String
    //   0	264	4	ancestors	ImmutableSet<File>
    //   6	258	5	canonical	File
    //   23	241	6	files	File[]
    //   90	174	7	newAncestors	ImmutableSet<File>
    //   94	169	8	arr$	File[]
    //   99	164	9	len$	int
    //   102	161	10	i$	int
    //   116	141	11	f	File
    //   123	134	12	name	String
    //   233	24	13	resourceName	String
  }
  
  private void scanJar(File file, ClassLoader classloader)
    throws IOException
  {
    JarFile jarFile;
    try
    {
      jarFile = new JarFile(file);
    }
    catch (IOException e)
    {
      return;
    }
    try
    {
      for (URI uri : getClassPathFromManifest(file, jarFile.getManifest())) {
        scan(uri, classloader);
      }
      Enumeration<JarEntry> entries = jarFile.entries();
      while (entries.hasMoreElements())
      {
        JarEntry entry = (JarEntry)entries.nextElement();
        if ((!entry.isDirectory()) && (!entry.getName().equals("META-INF/MANIFEST.MF"))) {
          resources.add(ClassPath.ResourceInfo.of(entry.getName(), classloader));
        }
      }
      return;
    }
    finally
    {
      try
      {
        jarFile.close();
      }
      catch (IOException ignored) {}
    }
  }
  
  /* Error */
  @VisibleForTesting
  static ImmutableSet<URI> getClassPathFromManifest(File jarFile, @javax.annotation.Nullable java.util.jar.Manifest manifest)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: invokestatic 118	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet:of	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet;
    //   7: areturn
    //   8: invokestatic 171	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet:builder	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder;
    //   11: astore_2
    //   12: aload_1
    //   13: invokevirtual 284	java/util/jar/Manifest:getMainAttributes	()Ljava/util/jar/Attributes;
    //   16: getstatic 288	java/util/jar/Attributes$Name:CLASS_PATH	Ljava/util/jar/Attributes$Name;
    //   19: invokevirtual 289	java/util/jar/Attributes$Name:toString	()Ljava/lang/String;
    //   22: invokevirtual 292	java/util/jar/Attributes:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +101 -> 128
    //   30: invokestatic 296	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/reflect/ClassPath:access$200	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Splitter;
    //   33: aload_3
    //   34: invokevirtual 302	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Splitter:split	(Ljava/lang/CharSequence;)Ljava/lang/Iterable;
    //   37: invokeinterface 305 1 0
    //   42: astore 4
    //   44: aload 4
    //   46: invokeinterface 238 1 0
    //   51: ifeq +77 -> 128
    //   54: aload 4
    //   56: invokeinterface 242 1 0
    //   61: checkcast 76	java/lang/String
    //   64: astore 5
    //   66: aload_0
    //   67: aload 5
    //   69: invokestatic 309	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/reflect/ClassPath$Scanner:getClassPathEntry	(Ljava/io/File;Ljava/lang/String;)Ljava/net/URI;
    //   72: astore 6
    //   74: goto +44 -> 118
    //   77: astore 7
    //   79: invokestatic 137	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/reflect/ClassPath:access$100	()Ljava/util/logging/Logger;
    //   82: ldc_w 311
    //   85: aload 5
    //   87: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   90: dup
    //   91: invokevirtual 147	java/lang/String:length	()I
    //   94: ifeq +9 -> 103
    //   97: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   100: goto +12 -> 112
    //   103: pop
    //   104: new 76	java/lang/String
    //   107: dup_x1
    //   108: swap
    //   109: invokespecial 193	java/lang/String:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 165	java/util/logging/Logger:warning	(Ljava/lang/String;)V
    //   115: goto -71 -> 44
    //   118: aload_2
    //   119: aload 6
    //   121: invokevirtual 178	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder:add	(Ljava/lang/Object;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder;
    //   124: pop
    //   125: goto -81 -> 44
    //   128: aload_2
    //   129: invokevirtual 180	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet$Builder:build	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableSet;
    //   132: areturn
    // Line number table:
    //   Java source line #401	-> byte code offset #0
    //   Java source line #402	-> byte code offset #4
    //   Java source line #404	-> byte code offset #8
    //   Java source line #405	-> byte code offset #12
    //   Java source line #407	-> byte code offset #26
    //   Java source line #408	-> byte code offset #30
    //   Java source line #411	-> byte code offset #66
    //   Java source line #416	-> byte code offset #74
    //   Java source line #412	-> byte code offset #77
    //   Java source line #414	-> byte code offset #79
    //   Java source line #415	-> byte code offset #115
    //   Java source line #417	-> byte code offset #118
    //   Java source line #418	-> byte code offset #125
    //   Java source line #420	-> byte code offset #128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	jarFile	File
    //   0	133	1	manifest	java.util.jar.Manifest
    //   12	121	2	builder	com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet.Builder<URI>
    //   26	107	3	classpathAttribute	String
    //   44	84	4	i$	java.util.Iterator
    //   66	59	5	path	String
    //   74	51	6	uri	URI
    //   79	39	7	e	URISyntaxException
    // Exception table:
    //   from	to	target	type
    //   66	74	77	java/net/URISyntaxException
  }
  
  @VisibleForTesting
  static URI getClassPathEntry(File jarFile, String path)
    throws URISyntaxException
  {
    URI uri = new URI(path);
    if (uri.isAbsolute()) {
      return uri;
    }
    return new File(jarFile.getParentFile(), path.replace('/', File.separatorChar)).toURI();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.ClassPath.Scanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */