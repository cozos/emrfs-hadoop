package com.amazon.ws.emr.hadoop.fs.annotation;

import com.amazon.ws.emr.hadoop.fs.client.YarnClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.StrSubstitutor;
import com.amazon.ws.emr.hadoop.fs.util.JobUtils;
import com.amazonaws.services.elasticmapreduce.spi.EMRFSAnnotationProvider;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationProcessorImpl
  implements AnnotationProcessor
{
  private final StrSubstitutor systemVariableResolver;
  private final Configuration configuration;
  
  static enum ApplicationType
  {
    MAPREDUCE,  SPARK,  OTHER;
    
    private ApplicationType() {}
  }
  
  static final Pattern SYSTEM_VARIABLE_PATTERN = Pattern.compile("^\\$\\{.+\\}$");
  private static final Logger LOG = LoggerFactory.getLogger(AnnotationProcessorImpl.class);
  
  public AnnotationProcessorImpl(Configuration configuration)
  {
    this.configuration = configuration;
    try
    {
      YarnClient yarnClient = new YarnClient(configuration);Throwable localThrowable3 = null;
      try
      {
        String applicationId = JobUtils.getApplicationId();
        this.configuration.set("yarn.application.type", yarnClient.getApplicationTypeById(applicationId));
      }
      catch (Throwable localThrowable1)
      {
        localThrowable3 = localThrowable1;throw localThrowable1;
      }
      finally
      {
        if (yarnClient != null) {
          if (localThrowable3 != null) {
            try
            {
              yarnClient.close();
            }
            catch (Throwable localThrowable2)
            {
              localThrowable3.addSuppressed(localThrowable2);
            }
          } else {
            yarnClient.close();
          }
        }
      }
    }
    catch (IOException e)
    {
      LOG.warn("Yarn Http client could not be closed.", e);
    }
    systemVariableResolver = new StrSubstitutor(new SystemVariableLookup(configuration));
  }
  
  @VisibleForTesting
  AnnotationProcessorImpl(Configuration configuration, ApplicationType applicationType)
  {
    this.configuration = configuration;
    this.configuration.set("yarn.application.type", applicationType.name());
    systemVariableResolver = new StrSubstitutor(new SystemVariableLookup(configuration));
  }
  
  public Annotations process(String annotationConfigurationFile)
  {
    try
    {
      Map<String, String> annotationEntries = loadAnnotationEntries(annotationConfigurationFile);
      validateCharsetAndSize(annotationEntries);
      Map<String, String> resolvedAnnotationEntries = resolveSystemVariables(annotationEntries);
      return Annotations.of(resolvedAnnotationEntries);
    }
    catch (AnnotationProcessException ex)
    {
      LOG.warn("Annotation processing failed.", ex);
      return Annotations.of(ex.getErrorCode());
    }
    catch (Exception ex)
    {
      LOG.error("Annotation processing failed due to internal error.", ex);
    }
    return Annotations.of(AnnotationProcessErrorCode.EMRFSAnnotationProcessError);
  }
  
  /* Error */
  @VisibleForTesting
  Map<String, String> loadAnnotationEntries(String annotationConfigurationFile)
    throws AnnotationProcessException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 154	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 160	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   7: aload_1
    //   8: invokevirtual 166	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   11: ifnonnull +7 -> 18
    //   14: invokestatic 172	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 154	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: invokevirtual 160	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   25: aload_1
    //   26: invokevirtual 176	java/lang/ClassLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_2
    //   30: aconst_null
    //   31: astore_3
    //   32: new 178	java/util/Properties
    //   35: dup
    //   36: invokespecial 179	java/util/Properties:<init>	()V
    //   39: astore 4
    //   41: aload 4
    //   43: aload_2
    //   44: invokevirtual 183	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   47: aload 4
    //   49: invokestatic 189	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Maps:fromProperties	(Ljava/util/Properties;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableMap;
    //   52: invokestatic 193	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Maps:newHashMap	(Ljava/util/Map;)Ljava/util/HashMap;
    //   55: astore 5
    //   57: aload 4
    //   59: ldc -61
    //   61: invokevirtual 198	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +30 -> 98
    //   71: aload 5
    //   73: ldc -61
    //   75: invokeinterface 202 2 0
    //   80: pop
    //   81: aload_0
    //   82: aload 6
    //   84: invokespecial 205	com/amazon/ws/emr/hadoop/fs/annotation/AnnotationProcessorImpl:loadAnnotationEntriesFromCustomAnnotationProvider	(Ljava/lang/String;)Ljava/util/Map;
    //   87: astore 7
    //   89: aload 5
    //   91: aload 7
    //   93: invokeinterface 208 2 0
    //   98: aload 5
    //   100: astore 7
    //   102: aload_2
    //   103: ifnull +29 -> 132
    //   106: aload_3
    //   107: ifnull +21 -> 128
    //   110: aload_2
    //   111: invokevirtual 213	java/io/InputStream:close	()V
    //   114: goto +18 -> 132
    //   117: astore 8
    //   119: aload_3
    //   120: aload 8
    //   122: invokevirtual 63	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   125: goto +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 213	java/io/InputStream:close	()V
    //   132: aload 7
    //   134: areturn
    //   135: astore 4
    //   137: aload 4
    //   139: astore_3
    //   140: aload 4
    //   142: athrow
    //   143: astore 9
    //   145: aload_2
    //   146: ifnull +29 -> 175
    //   149: aload_3
    //   150: ifnull +21 -> 171
    //   153: aload_2
    //   154: invokevirtual 213	java/io/InputStream:close	()V
    //   157: goto +18 -> 175
    //   160: astore 10
    //   162: aload_3
    //   163: aload 10
    //   165: invokevirtual 63	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   168: goto +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 213	java/io/InputStream:close	()V
    //   175: aload 9
    //   177: athrow
    //   178: astore_2
    //   179: getstatic 65	com/amazon/ws/emr/hadoop/fs/annotation/AnnotationProcessorImpl:LOG	Lorg/slf4j/Logger;
    //   182: ldc -41
    //   184: aload_2
    //   185: invokeinterface 136 3 0
    //   190: new 102	com/amazon/ws/emr/hadoop/fs/annotation/AnnotationProcessException
    //   193: dup
    //   194: getstatic 142	com/amazon/ws/emr/hadoop/fs/annotation/AnnotationProcessErrorCode:EMRFSAnnotationProcessError	Lcom/amazon/ws/emr/hadoop/fs/annotation/AnnotationProcessErrorCode;
    //   197: ldc -39
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_1
    //   206: aastore
    //   207: invokestatic 221	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   210: aload_2
    //   211: invokespecial 224	com/amazon/ws/emr/hadoop/fs/annotation/AnnotationProcessException:<init>	(Lcom/amazon/ws/emr/hadoop/fs/annotation/AnnotationProcessErrorCode;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: athrow
    // Line number table:
    //   Java source line #84	-> byte code offset #0
    //   Java source line #87	-> byte code offset #14
    //   Java source line #90	-> byte code offset #18
    //   Java source line #91	-> byte code offset #19
    //   Java source line #90	-> byte code offset #30
    //   Java source line #92	-> byte code offset #32
    //   Java source line #93	-> byte code offset #41
    //   Java source line #95	-> byte code offset #47
    //   Java source line #96	-> byte code offset #57
    //   Java source line #97	-> byte code offset #66
    //   Java source line #99	-> byte code offset #71
    //   Java source line #100	-> byte code offset #81
    //   Java source line #101	-> byte code offset #84
    //   Java source line #103	-> byte code offset #89
    //   Java source line #106	-> byte code offset #98
    //   Java source line #107	-> byte code offset #102
    //   Java source line #106	-> byte code offset #132
    //   Java source line #90	-> byte code offset #135
    //   Java source line #107	-> byte code offset #143
    //   Java source line #108	-> byte code offset #179
    //   Java source line #109	-> byte code offset #190
    //   Java source line #110	-> byte code offset #207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	AnnotationProcessorImpl
    //   0	215	1	annotationConfigurationFile	String
    //   29	143	2	annotationEntriesInputStream	java.io.InputStream
    //   178	33	2	ex	IOException
    //   31	132	3	localThrowable3	Throwable
    //   39	19	4	annotationProperties	java.util.Properties
    //   135	6	4	localThrowable1	Throwable
    //   55	44	5	annotationEntries	Map<String, String>
    //   64	19	6	annotationProviderClassName	String
    //   87	46	7	annotationEntriesFromProvider	Map<String, String>
    //   117	4	8	localThrowable	Throwable
    //   143	33	9	localObject	Object
    //   160	4	10	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   110	114	117	java/lang/Throwable
    //   32	102	135	java/lang/Throwable
    //   32	102	143	finally
    //   135	145	143	finally
    //   153	157	160	java/lang/Throwable
    //   18	132	178	java/io/IOException
    //   135	178	178	java/io/IOException
  }
  
  private Map<String, String> loadAnnotationEntriesFromCustomAnnotationProvider(String annotationProviderClass)
    throws AnnotationProcessException
  {
    try
    {
      EMRFSAnnotationProvider annotationProvider = (EMRFSAnnotationProvider)ReflectionUtils.newInstance(
        Class.forName(annotationProviderClass), configuration);
      
      return annotationProvider.getAnnotations();
    }
    catch (ClassNotFoundException e)
    {
      LOG.warn("class not found: {}", annotationProviderClass, e);
      throw new AnnotationProcessException(AnnotationProcessErrorCode.EMRFSAnnotationProviderNotFoundError);
    }
    catch (ClassCastException e)
    {
      LOG.warn("class {} cannot be casted to EMRFSAnnotationProvider.", annotationProviderClass, e);
      throw new AnnotationProcessException(AnnotationProcessErrorCode.EMRFSAnnotationProviderCastError);
    }
    catch (Throwable t)
    {
      LOG.warn("class {} execution failed.", annotationProviderClass, t);
      throw new AnnotationProcessException(AnnotationProcessErrorCode.EMRFSAnnotationProviderExecutionError);
    }
  }
  
  @VisibleForTesting
  Map<String, String> resolveSystemVariables(Map<String, String> annotationEntries)
  {
    Map<String, String> resolvedAnnotationEntries = new HashMap();
    for (Map.Entry<String, String> entry : annotationEntries.entrySet())
    {
      String key = (String)entry.getKey();
      String value = (String)entry.getValue();
      if (containsSystemVariable(value)) {
        try
        {
          value = systemVariableResolver.replace(value);
        }
        catch (IllegalArgumentException ex)
        {
          LOG.warn("Invalid system variable {}.", value, ex);
        }
      }
      resolvedAnnotationEntries.put(key, value);
    }
    return resolvedAnnotationEntries;
  }
  
  private boolean containsSystemVariable(String value)
  {
    return SYSTEM_VARIABLE_PATTERN.matcher(StringUtils.trimToEmpty(value)).matches();
  }
  
  @VisibleForTesting
  void validateCharsetAndSize(Map<String, String> annotationEntries)
    throws AnnotationProcessException
  {
    int byteSize = 0;
    for (Map.Entry<String, String> entry : annotationEntries.entrySet())
    {
      String key = (String)entry.getKey();
      String value = (String)entry.getValue();
      if ((containsInvalidCharacters(key)) || (containsInvalidCharacters(value))) {
        throw new AnnotationProcessException(AnnotationProcessErrorCode.EMRFSAnnotationInvalidCharacterError);
      }
      byteSize += key.getBytes(SUPPORTED_CHARSET).length;
      byteSize += value.getBytes(SUPPORTED_CHARSET).length;
    }
    if (byteSize > 2048) {
      throw new AnnotationProcessException(AnnotationProcessErrorCode.EMRFSAnnotationSizeLimitExceededError);
    }
  }
  
  private boolean containsInvalidCharacters(String value)
  {
    if (StringUtils.isBlank(value)) {
      return false;
    }
    return !SUPPORTED_CHARSET.newEncoder().canEncode(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.annotation.AnnotationProcessorImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */