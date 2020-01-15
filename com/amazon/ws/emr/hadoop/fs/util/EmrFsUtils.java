package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.annotation.AnnotationProcessorImpl;
import com.amazon.ws.emr.hadoop.fs.annotation.Annotations;
import com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner;
import com.amazon.ws.emr.hadoop.fs.property.RetryPolicyType;
import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.retry.RetryPolicies;
import org.apache.hadoop.io.retry.RetryPolicy;
import org.apache.hadoop.io.retry.RetryProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmrFsUtils
{
  private static final Logger LOG = LoggerFactory.getLogger(EmrFsUtils.class);
  private static final Map<Region, String> REGION_ENDPOINT_OVERRIDES = ImmutableMap.of(
    Region.getRegion(Regions.GovCloud), "s3-fips-us-gov-west-1.amazonaws.com");
  private static final String jobFlowId = getJobFlowId();
  private static final String DEFAULT_JOB_FLOW_ID = "UnknownJobFlowId";
  static final String S3_GOV_WEST_FIPS_ENDPOINT = "s3-fips-us-gov-west-1.amazonaws.com";
  
  public static String getDefaultScheme()
  {
    return "s3n";
  }
  
  public static String pathToBucket(Path path)
  {
    return uriToBucket(path.toUri());
  }
  
  public static String uriToBucket(URI uri)
  {
    return uri.getAuthority();
  }
  
  public static String pathToKey(Path path)
  {
    if ((path.toUri().getScheme() != null) && (path.toUri().getPath().isEmpty())) {
      return "";
    }
    Preconditions.checkState(path.isAbsolute(), "Invalid path - must be absolute: " + path);
    String ret = path.toUri().getPath().substring(1);
    if ((ret.endsWith("/")) && (ret.indexOf("/") != ret.length() - 1)) {
      ret = ret.substring(0, ret.length() - 1);
    }
    return ret;
  }
  
  public static Path getPathForS3Object(String bucket, String key)
  {
    return new Path("s3://" + bucket + "/" + key);
  }
  
  public static Path keyToPath(String bucket, String key)
  {
    return new Path("/" + bucket + "/" + key);
  }
  
  public static Path keyToPath(String key)
  {
    return new Path("/" + key);
  }
  
  /* Error */
  public static String execCmd(String cmd)
  {
    // Byte code:
    //   0: new 133	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/DefaultExecutor
    //   3: dup
    //   4: invokespecial 134	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/DefaultExecutor:<init>	()V
    //   7: astore_1
    //   8: new 136	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/ExecuteWatchdog
    //   11: dup
    //   12: ldc2_w 137
    //   15: invokespecial 141	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/ExecuteWatchdog:<init>	(J)V
    //   18: astore_2
    //   19: new 143	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/DefaultExecuteResultHandler
    //   22: dup
    //   23: invokespecial 144	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/DefaultExecuteResultHandler:<init>	()V
    //   26: astore_3
    //   27: aload_1
    //   28: aload_2
    //   29: invokeinterface 150 2 0
    //   34: new 152	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/CommandLine
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 153	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/CommandLine:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: new 155	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream
    //   47: dup
    //   48: invokespecial 156	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:<init>	()V
    //   51: astore 5
    //   53: aconst_null
    //   54: astore 6
    //   56: new 155	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 156	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:<init>	()V
    //   63: astore 7
    //   65: aconst_null
    //   66: astore 8
    //   68: new 158	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/PumpStreamHandler
    //   71: dup
    //   72: aload 5
    //   74: aload 7
    //   76: invokespecial 161	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/PumpStreamHandler:<init>	(Ljava/io/OutputStream;Ljava/io/OutputStream;)V
    //   79: astore 9
    //   81: aload_1
    //   82: aload 9
    //   84: invokeinterface 165 2 0
    //   89: aload_1
    //   90: aload 4
    //   92: aload_3
    //   93: invokeinterface 169 3 0
    //   98: aload_3
    //   99: invokevirtual 172	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/DefaultExecuteResultHandler:waitFor	()V
    //   102: aload_3
    //   103: invokevirtual 175	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/DefaultExecuteResultHandler:getExitValue	()I
    //   106: istore 10
    //   108: goto +15 -> 123
    //   111: astore 11
    //   113: new 177	java/lang/RuntimeException
    //   116: dup
    //   117: aload 11
    //   119: invokespecial 180	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   122: athrow
    //   123: aload 9
    //   125: invokevirtual 183	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/exec/PumpStreamHandler:stop	()V
    //   128: aload 5
    //   130: getstatic 189	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   133: invokevirtual 194	java/nio/charset/Charset:name	()Ljava/lang/String;
    //   136: invokevirtual 196	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 11
    //   141: iload 10
    //   143: ifne +80 -> 223
    //   146: aload 11
    //   148: astore 12
    //   150: aload 7
    //   152: ifnull +33 -> 185
    //   155: aload 8
    //   157: ifnull +23 -> 180
    //   160: aload 7
    //   162: invokevirtual 199	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   165: goto +20 -> 185
    //   168: astore 13
    //   170: aload 8
    //   172: aload 13
    //   174: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   177: goto +8 -> 185
    //   180: aload 7
    //   182: invokevirtual 199	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   185: aload 5
    //   187: ifnull +33 -> 220
    //   190: aload 6
    //   192: ifnull +23 -> 215
    //   195: aload 5
    //   197: invokevirtual 199	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   200: goto +20 -> 220
    //   203: astore 13
    //   205: aload 6
    //   207: aload 13
    //   209: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   212: goto +8 -> 220
    //   215: aload 5
    //   217: invokevirtual 199	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   220: aload 12
    //   222: areturn
    //   223: getstatic 204	com/amazon/ws/emr/hadoop/fs/util/EmrFsUtils:LOG	Lorg/slf4j/Logger;
    //   226: ldc -50
    //   228: iload 10
    //   230: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: aload_0
    //   234: invokeinterface 218 4 0
    //   239: getstatic 204	com/amazon/ws/emr/hadoop/fs/util/EmrFsUtils:LOG	Lorg/slf4j/Logger;
    //   242: ldc -36
    //   244: aload 11
    //   246: invokeinterface 223 3 0
    //   251: aload 7
    //   253: getstatic 189	java/nio/charset/StandardCharsets:UTF_8	Ljava/nio/charset/Charset;
    //   256: invokevirtual 194	java/nio/charset/Charset:name	()Ljava/lang/String;
    //   259: invokevirtual 196	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 12
    //   264: getstatic 204	com/amazon/ws/emr/hadoop/fs/util/EmrFsUtils:LOG	Lorg/slf4j/Logger;
    //   267: ldc -31
    //   269: aload 12
    //   271: invokeinterface 223 3 0
    //   276: new 177	java/lang/RuntimeException
    //   279: dup
    //   280: ldc -29
    //   282: iconst_2
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: iload 10
    //   290: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: aload_0
    //   297: aastore
    //   298: invokestatic 231	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   301: invokespecial 232	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   304: athrow
    //   305: astore 9
    //   307: aload 9
    //   309: astore 8
    //   311: aload 9
    //   313: athrow
    //   314: astore 14
    //   316: aload 7
    //   318: ifnull +33 -> 351
    //   321: aload 8
    //   323: ifnull +23 -> 346
    //   326: aload 7
    //   328: invokevirtual 199	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   331: goto +20 -> 351
    //   334: astore 15
    //   336: aload 8
    //   338: aload 15
    //   340: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   343: goto +8 -> 351
    //   346: aload 7
    //   348: invokevirtual 199	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   351: aload 14
    //   353: athrow
    //   354: astore 7
    //   356: aload 7
    //   358: astore 6
    //   360: aload 7
    //   362: athrow
    //   363: astore 16
    //   365: aload 5
    //   367: ifnull +33 -> 400
    //   370: aload 6
    //   372: ifnull +23 -> 395
    //   375: aload 5
    //   377: invokevirtual 199	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   380: goto +20 -> 400
    //   383: astore 17
    //   385: aload 6
    //   387: aload 17
    //   389: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   392: goto +8 -> 400
    //   395: aload 5
    //   397: invokevirtual 199	com/amazon/ws/emr/hadoop/fs/shaded/org/apache/commons/io/output/ByteArrayOutputStream:close	()V
    //   400: aload 16
    //   402: athrow
    //   403: astore 5
    //   405: new 177	java/lang/RuntimeException
    //   408: dup
    //   409: aload 5
    //   411: invokespecial 180	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   414: athrow
    // Line number table:
    //   Java source line #125	-> byte code offset #0
    //   Java source line #126	-> byte code offset #8
    //   Java source line #127	-> byte code offset #19
    //   Java source line #128	-> byte code offset #27
    //   Java source line #129	-> byte code offset #34
    //   Java source line #130	-> byte code offset #44
    //   Java source line #131	-> byte code offset #56
    //   Java source line #130	-> byte code offset #65
    //   Java source line #132	-> byte code offset #68
    //   Java source line #133	-> byte code offset #81
    //   Java source line #134	-> byte code offset #89
    //   Java source line #137	-> byte code offset #98
    //   Java source line #138	-> byte code offset #102
    //   Java source line #141	-> byte code offset #108
    //   Java source line #139	-> byte code offset #111
    //   Java source line #140	-> byte code offset #113
    //   Java source line #142	-> byte code offset #123
    //   Java source line #143	-> byte code offset #128
    //   Java source line #144	-> byte code offset #141
    //   Java source line #145	-> byte code offset #146
    //   Java source line #153	-> byte code offset #150
    //   Java source line #145	-> byte code offset #220
    //   Java source line #147	-> byte code offset #223
    //   Java source line #148	-> byte code offset #239
    //   Java source line #149	-> byte code offset #251
    //   Java source line #150	-> byte code offset #264
    //   Java source line #151	-> byte code offset #276
    //   Java source line #130	-> byte code offset #305
    //   Java source line #153	-> byte code offset #314
    //   Java source line #130	-> byte code offset #354
    //   Java source line #153	-> byte code offset #363
    //   Java source line #154	-> byte code offset #405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	cmd	String
    //   7	83	1	executor	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.Executor
    //   18	11	2	watchdog	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.ExecuteWatchdog
    //   26	77	3	resultHandler	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.DefaultExecuteResultHandler
    //   42	49	4	commandLine	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.CommandLine
    //   51	345	5	stdOutStream	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output.ByteArrayOutputStream
    //   403	7	5	e	java.io.IOException
    //   54	332	6	localThrowable6	Throwable
    //   63	284	7	stdErrStream	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.output.ByteArrayOutputStream
    //   354	7	7	localThrowable4	Throwable
    //   66	271	8	localThrowable7	Throwable
    //   79	45	9	pumpStreamHandler	com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.PumpStreamHandler
    //   305	7	9	localThrowable2	Throwable
    //   106	3	10	exitValue	int
    //   123	166	10	exitValue	int
    //   111	7	11	e	InterruptedException
    //   139	106	11	stdOut	String
    //   262	8	12	stdErr	String
    //   168	5	13	localThrowable	Throwable
    //   203	5	13	localThrowable1	Throwable
    //   314	38	14	localObject1	Object
    //   334	5	15	localThrowable3	Throwable
    //   363	38	16	localObject2	Object
    //   383	5	17	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   98	108	111	java/lang/InterruptedException
    //   160	165	168	java/lang/Throwable
    //   195	200	203	java/lang/Throwable
    //   68	150	305	java/lang/Throwable
    //   223	305	305	java/lang/Throwable
    //   68	150	314	finally
    //   223	316	314	finally
    //   326	331	334	java/lang/Throwable
    //   56	185	354	java/lang/Throwable
    //   223	354	354	java/lang/Throwable
    //   56	185	363	finally
    //   223	365	363	finally
    //   375	380	383	java/lang/Throwable
    //   44	220	403	java/io/IOException
    //   223	403	403	java/io/IOException
  }
  
  public static ByteBuffer safeCreateByteBuffer(byte[] buffer)
  {
    return ByteBuffer.wrap(buffer == null ? new byte[0] : buffer);
  }
  
  private static String getEmrVersion()
  {
    String defaultValue = "1.0.0";
    String programPath = "/usr/share/aws/emr/util/version";
    File amiVersionProgram = new File(programPath);
    if (amiVersionProgram.exists()) {
      try
      {
        String result = execCmd(programPath);
        if (!Strings.isNullOrEmpty(result)) {
          return result;
        }
      }
      catch (Exception e)
      {
        LOG.warn("Unable to retrieve version information, error while executing 'version'", e);
      }
    }
    return defaultValue;
  }
  
  private static String addAnnotationsIfPresent(String userAgent, Configuration configuration)
  {
    try
    {
      if (EmrFsUtils.class.getClassLoader().getResource("emrfs-annotations.properties") == null) {
        return userAgent;
      }
      String annotations = new AnnotationProcessorImpl(configuration).process("emrfs-annotations.properties").toString();
      LOG.debug("EMRFS annotations: {}.", annotations);
      if (StringUtils.isBlank(annotations)) {
        return userAgent;
      }
      return userAgent + " " + annotations;
    }
    catch (Throwable t)
    {
      LOG.error("Adding EmrFs annotations failed.", t);
    }
    return userAgent;
  }
  
  private static String addFileSystemOwnerInformation(String userAgent, FileSystemOwner fileSystemOwner, Configuration configuration)
  {
    String fileSystemOwnerInformationFormat = " user:%s,groups:[%s]";
    if ((!ConfigurationUtils.isAuthorizationAuditingEnabled(configuration)) || (fileSystemOwner == null)) {
      return userAgent;
    }
    String username = fileSystemOwner.getFullUserName();
    String groups = Joiner.on(',').join(fileSystemOwner.getGroupNames());
    return userAgent + String.format(fileSystemOwnerInformationFormat, new Object[] { username, groups });
  }
  
  public static String getUserAgent(Configuration configuration)
  {
    return getUserAgent(null, configuration);
  }
  
  public static String getUserAgent(FileSystemOwner fileSystemOwner, Configuration configuration)
  {
    boolean isConsistencyEnabled = ConfigurationUtils.isConsistencyEnabled(configuration);
    String subFsName = isConsistencyEnabled ? "s3c" : "s3n";
    String emrVersion = getEmrVersion().replaceAll("\\s+", "");
    String userAgent = String.format("ElasticMapReduce/%s emrfs/%s", new Object[] { emrVersion, subFsName });
    
    userAgent = addAnnotationsIfPresent(userAgent, configuration);
    userAgent = addFileSystemOwnerInformation(userAgent, fileSystemOwner, configuration);
    return userAgent;
  }
  
  public static String makeDestFileKey(String srcDir, String dstDir, String srcFileKey)
  {
    String suffix = srcFileKey.substring(srcDir.length());
    String dstFileKey;
    String dstFileKey;
    if ((dstDir.charAt(dstDir.length() - 1) != '/') && (suffix.charAt(0) != '/')) {
      dstFileKey = dstDir + "/" + suffix;
    } else {
      dstFileKey = dstDir + suffix;
    }
    return dstFileKey;
  }
  
  public static AmazonS3Lite getAmazonS3LiteWithRetryPolicy(AmazonS3Lite s3)
  {
    return getAmazonS3LiteWithRetryPolicy(s3, 5);
  }
  
  public static AmazonS3Lite getAmazonS3LiteWithRetryPolicy(AmazonS3Lite s3, int maxRetries)
  {
    RetryPolicy basePolicy = RetryPolicies.exponentialBackoffRetry(maxRetries, 3L, TimeUnit.SECONDS);
    Map<Class<? extends Exception>, RetryPolicy> exceptionToPolicyMap = new HashMap();
    exceptionToPolicyMap.put(AmazonServiceException.class, basePolicy);
    exceptionToPolicyMap.put(AmazonClientException.class, basePolicy);
    exceptionToPolicyMap.put(AmazonS3Exception.class, basePolicy);
    
    RetryPolicy methodPolicy = RetryPolicies.retryByException(RetryPolicies.TRY_ONCE_THEN_FAIL, exceptionToPolicyMap);
    Map<String, RetryPolicy> methodNameToPolicyMap = new HashMap();
    methodNameToPolicyMap.put("completeMultipartUpload", methodPolicy);
    methodNameToPolicyMap.put("abortMultipartUpload", methodPolicy);
    methodNameToPolicyMap.put("uploadPart", methodPolicy);
    return (AmazonS3Lite)RetryProxy.create(AmazonS3Lite.class, s3, methodNameToPolicyMap);
  }
  
  public static String getRegion(Configuration configuration, String regionConf)
  {
    if ((regionConf != null) && (configuration != null) && (configuration.get(regionConf) != null)) {
      return configuration.get(regionConf);
    }
    if (Regions.getCurrentRegion() != null) {
      return Regions.getCurrentRegion().getName();
    }
    LOG.warn("Cannot get region info from Ec2 metadata, using us-east-1 for desktop.");
    return Regions.US_EAST_1.getName();
  }
  
  private static Region getRegion()
  {
    Region region = Regions.getCurrentRegion();
    if (region == null)
    {
      LOG.info("Unable to get region id from EC2 metadata. Defaulting to us-east-1");
      region = RegionUtils.getRegion(Regions.US_EAST_1.getName());
    }
    return region;
  }
  
  public static String getEndpoint(String service, Configuration config)
  {
    String endpoint;
    String endpoint;
    String endpoint;
    switch (service)
    {
    case "s3": 
      endpoint = getS3Endpoint(config); break;
    case "dynamodb": 
      endpoint = getDynamoDbEndpoint(config); break;
    default: 
      endpoint = getEndpoint(service, getRegion());
    }
    LOG.debug("Using endpoint {} for service {}.", endpoint, service);
    return endpoint;
  }
  
  static String getEndpoint(String service, Region region)
  {
    return region.getServiceEndpoint(service);
  }
  
  public static String getDynamoDbEndpoint(Configuration config)
  {
    String configuredEndpoint = config.get("fs.s3.consistent.dynamodb.endpoint");
    if (configuredEndpoint != null) {
      return configuredEndpoint;
    }
    return getEndpoint("dynamodb", getRegion());
  }
  
  public static String getS3Endpoint(Configuration config)
  {
    String configuredEndpoint = config.get("fs.s3n.endpoint");
    if (configuredEndpoint != null) {
      return configuredEndpoint;
    }
    return getS3Endpoint(getRegion());
  }
  
  public static String getS3Endpoint(Region region)
  {
    String endpoint = (String)REGION_ENDPOINT_OVERRIDES.get(region);
    if (endpoint != null) {
      return endpoint;
    }
    return getEndpoint("s3", region);
  }
  
  public static String getS3Endpoint(Regions region)
  {
    return getS3Endpoint(Region.getRegion(region));
  }
  
  public static String getJobFlowId()
  {
    if (Strings.isNullOrEmpty(jobFlowId))
    {
      String id = PlatformInfo.forDefaultResourceLocations().getJobFlowId();
      return Strings.isNullOrEmpty(id) ? "UnknownJobFlowId" : id;
    }
    return jobFlowId;
  }
  
  public static long calculateRetryInterval(RetryPolicyType retryPolicyType, long baseRetryInterval, int numOfAttempts)
  {
    double randomInterval = new Random().nextDouble() + 0.5D;
    long retryInterval = baseRetryInterval;
    switch (retryPolicyType)
    {
    case EXPONENTIAL: 
      retryInterval = Math.min(retryInterval * (1L << numOfAttempts), Long.MAX_VALUE);
      break;
    case FIXED: 
    default: 
      retryInterval = Math.min(retryInterval, Long.MAX_VALUE);
    }
    return (retryInterval * randomInterval);
  }
  
  public static void sleep(long backOffInterval)
  {
    try
    {
      Thread.sleep(backOffInterval);
    }
    catch (InterruptedException ie)
    {
      throw new RuntimeException("Retry's backoff was interrupted by other process", ie);
    }
  }
  
  public static Path makeAbsolute(Path workingDirectory, Path path)
  {
    return path.isAbsolute() ? path : new Path(workingDirectory, path);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */