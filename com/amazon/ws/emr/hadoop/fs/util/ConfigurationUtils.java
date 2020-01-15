package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.cse.CSEConstants;
import com.amazon.ws.emr.hadoop.fs.property.AwsS3SignerType;
import com.amazon.ws.emr.hadoop.fs.property.ConfigurationConstants;
import com.amazon.ws.emr.hadoop.fs.property.RetryPolicyType;
import com.amazon.ws.emr.hadoop.fs.property.SeekStrategyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Protocol;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoStorageMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSEAlgorithm;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.StorageClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConfigurationUtils
{
  private static final Logger LOG = LoggerFactory.getLogger(ConfigurationUtils.class);
  
  public static boolean isConsistencyEnabled(Configuration configuration)
  {
    return configuration.getBoolean("fs.s3.consistent", false);
  }
  
  public static long getDefaultPartSize(Configuration conf)
  {
    long partSizeConf = conf.getLong("fs.s3n.multipart.uploads.split.size", 134217728L);
    if (partSizeConf < 5242880L)
    {
      LOG.warn("fs.s3n.multipart.uploads.split.size = " + partSizeConf + " is too small, setting to min " + 5242880L);
      
      partSizeConf = 5242880L;
    }
    else if (partSizeConf > 5368709120L)
    {
      LOG.warn("fs.s3n.multipart.uploads.split.size = " + partSizeConf + " is too large, setting to max " + 5368709120L);
      
      partSizeConf = 5368709120L;
    }
    return partSizeConf;
  }
  
  public static double getPartsCompletedThresholdPercent(Configuration conf)
  {
    double thFractionPartsCompleted = conf.getDouble("fs.s3.multipart.th.fraction.parts.completed", 0.5D);
    if ((thFractionPartsCompleted <= 0.0D) || (thFractionPartsCompleted >= 1.0D))
    {
      LOG.warn("The value of fs.s3.multipart.th.fraction.parts.completed is not in valid range: (0,1). Will set to default: 0.5");
      
      thFractionPartsCompleted = 0.5D;
    }
    return thFractionPartsCompleted;
  }
  
  public static double getFractionPartAvgCompletionTime(Configuration conf)
  {
    double fractionPartAvgCompletionTime = conf.getDouble("fs.s3.multipart.fraction.part.avg.completion.time", 1.0D);
    if ((fractionPartAvgCompletionTime <= 0.0D) || (fractionPartAvgCompletionTime > 1.0D))
    {
      LOG.warn("The value of fs.s3.multipart.fraction.part.avg.completion.time is not in valid range: (0,1]. Will set to default: 1.0");
      
      fractionPartAvgCompletionTime = 1.0D;
    }
    return fractionPartAvgCompletionTime;
  }
  
  public static int getPartAttempts(Configuration conf)
  {
    int partAttempts = conf.getInt("fs.s3.multipart.part.attempts", 5);
    if (partAttempts < 2)
    {
      LOG.warn("The value of fs.s3.multipart.part.attempts is less than min value: 2. Will default to min value.");
      
      partAttempts = 2;
    }
    return partAttempts;
  }
  
  public static long getBlockSize(Configuration conf)
  {
    return conf.getLong("fs.s3n.block.size", 67108864L);
  }
  
  public static boolean isClientSideEncryptionEnabled(Configuration configuration)
  {
    return configuration.getBoolean("fs.s3.cse.enabled", false);
  }
  
  public static boolean isMultipartUploadEnabled(Configuration configuration)
  {
    return configuration.getBoolean("fs.s3n.multipart.uploads.enabled", true);
  }
  
  public static boolean isCreateBucketEnabled(Configuration configuration)
  {
    return configuration.getBoolean("fs.s3.buckets.create.enabled", false);
  }
  
  public static String getBucketsCreateRegion(Configuration configuration)
  {
    return configuration.get("fs.s3.buckets.create.region");
  }
  
  public static boolean isLazySeekEnabled(Configuration configuration)
  {
    String seekStrategy = configuration.get("fs.s3.seekStrategy", ConfigurationConstants.FS_S3_SEEK_STRATEGY_DEFAULT);
    
    SeekStrategyName seekStrategyName = SeekStrategyName.fromName(seekStrategy);
    if (seekStrategyName == null)
    {
      LOG.warn("Invalid strategy specified in {}: {}. Valid strategies are: {}. Will default to {} strategy", new Object[] { "fs.s3.seekStrategy", seekStrategy, 
      
        SeekStrategyName.getNamesAsString(), ConfigurationConstants.FS_S3_SEEK_STRATEGY_DEFAULT });
      
      seekStrategyName = SeekStrategyName.LAZY;
    }
    return seekStrategyName.isLazySeekStrategy();
  }
  
  public static StorageClass getStorageClass(Configuration configuration)
  {
    String storageClassName = configuration.get("fs.s3.storageClass");
    if (!Strings.isNullOrEmpty(storageClassName)) {
      try
      {
        StorageClass storageClass = StorageClass.fromValue(storageClassName);
        if (StorageClass.Glacier.equals(storageClass))
        {
          LOG.warn("Invalid storage class infs.s3.storageClass: " + storageClassName);
          
          return null;
        }
        return storageClass;
      }
      catch (IllegalArgumentException e)
      {
        LOG.warn("Invalid storage class name in fs.s3.storageClass: " + storageClassName);
      }
    }
    return null;
  }
  
  public static CannedAccessControlList getAcl(Configuration configuration)
  {
    if (configuration == null) {
      return null;
    }
    String aclName = configuration.get("fs.s3.canned.acl");
    CannedAccessControlList acl = null;
    if (aclName != null) {
      try
      {
        acl = CannedAccessControlList.valueOf(aclName);
      }
      catch (IllegalArgumentException e)
      {
        LOG.warn("Invalid canned ACL name in fs.s3.canned.acl: " + aclName);
      }
    }
    return acl;
  }
  
  public static int getMaxConnections(Configuration configuration)
  {
    return configuration.getInt("fs.s3.maxConnections", 50);
  }
  
  public static int getMaxRetries(Configuration configuration)
  {
    return configuration.getInt("fs.s3.maxRetries", 10);
  }
  
  public static int getRetryPeriodSeconds(Configuration configuration)
  {
    return configuration.getInt("fs.s3.retryPeriodSeconds", 
      getConsistencyRetryPeriodSeconds(configuration));
  }
  
  public static int getConsistencyRetryPeriodSeconds(Configuration configuration)
  {
    return configuration.getInt("fs.s3.consistent.retryPeriodSeconds", 1);
  }
  
  public static int getConsistencyRetryCount(Configuration configuration)
  {
    return configuration.getInt("fs.s3.consistent.retryCount", 10);
  }
  
  public static boolean isS3InitialTimeoutEnabled(Configuration configuration)
  {
    int s3InitialSocketTimeoutMilliSeconds = getS3InitialSocketTimeoutMillis(configuration);
    return s3InitialSocketTimeoutMilliSeconds < 50000;
  }
  
  public static int getS3InitialSocketTimeoutMillis(Configuration configuration)
  {
    int s3InitialSocketTimeoutMilliSeconds = configuration.getInt("fs.s3.getObject.initialSocketTimeoutMilliseconds", 50000);
    if (s3InitialSocketTimeoutMilliSeconds > 50000)
    {
      LOG.warn("S3 getObject initial socket timeout ({} ms) is longer than default socket timeout ({} ms). Ignored.", 
      
        Integer.valueOf(s3InitialSocketTimeoutMilliSeconds), 
        Integer.valueOf(50000));
      return 50000;
    }
    if (s3InitialSocketTimeoutMilliSeconds < 1)
    {
      LOG.warn("S3 getObject initial socket timeout ({} ms) is shorter than minimum socket timeout ({} ms). Using {} ms instead.", new Object[] {
      
        Integer.valueOf(s3InitialSocketTimeoutMilliSeconds), 
        Integer.valueOf(1), 
        Integer.valueOf(1) });
      return 1;
    }
    return s3InitialSocketTimeoutMilliSeconds;
  }
  
  public static Protocol getProtocol(Configuration configuration)
  {
    return configuration.getBoolean("fs.s3n.ssl.enabled", true) ? Protocol.HTTPS : Protocol.HTTP;
  }
  
  public static boolean isServerSideEncryptionEnabled(Configuration configuration)
  {
    return configuration.getBoolean("fs.s3.enableServerSideEncryption", false);
  }
  
  public static String getS3SignerType(Configuration configuration)
  {
    String s3SignerType = configuration.get("fs.s3.signerType");
    if ((s3SignerType != null) && (!AwsS3SignerType.isValidName(s3SignerType))) {
      throw new IllegalArgumentException(String.format("The %s S3 signer type is not supported and current supported types are %s", new Object[] { s3SignerType, 
        StringUtils.join(AwsS3SignerType.getNames(), " ") }));
    }
    return s3SignerType;
  }
  
  public static String getServerSideEncryptionAlgorithm(Configuration configuration)
  {
    if (!Strings.isNullOrEmpty(getServerSideEncryptionKmsKeyId(configuration))) {
      return configuration.get("fs.s3.serverSideEncryptionAlgorithm", SSEAlgorithm.KMS.getAlgorithm());
    }
    return configuration.get("fs.s3.serverSideEncryptionAlgorithm", SSEAlgorithm.AES256
      .getAlgorithm());
  }
  
  public static String getServerSideEncryptionKmsKeyId(Configuration configuration)
  {
    return configuration.get("fs.s3.serverSideEncryption.kms.keyId", null);
  }
  
  public static String getAwsAccessKey(Configuration configuration)
  {
    return configuration.get("fs.s3.awsAccessKeyId", null);
  }
  
  public static String getAwsSecretKey(Configuration configuration)
  {
    return configuration.get("fs.s3.awsSecretAccessKey", null);
  }
  
  public static String getMetadataTableName(Configuration configuration)
  {
    return configuration.get("fs.s3.consistent.metadata.tableName", "EmrFSMetadata");
  }
  
  public static long getDefaultReadCapacity(Configuration configuration)
  {
    return configuration.getLong("fs.s3.consistent.metadata.read.capacity", 500L);
  }
  
  public static long getDefaultWriteCapacity(Configuration configuration)
  {
    return configuration.getLong("fs.s3.consistent.metadata.write.capacity", 100L);
  }
  
  public static boolean getEtagVerificationEnabled(Configuration configuration)
  {
    return configuration.getBoolean("fs.s3.consistent.metadata.etag.verification.enabled", true);
  }
  
  public static RetryPolicyType getRetryPolicyType(Configuration configuration)
  {
    String retryPolicy = configuration.get("fs.s3.consistent.retryPolicyType", ConfigurationConstants.FS_S3_CONSISTENT_RETRY_POLICY_TYPE_DEFAULT);
    
    RetryPolicyType retryPolicyType = RetryPolicyType.fromName(retryPolicy);
    if (retryPolicyType == null)
    {
      LOG.warn("Invalid retry policy type specified in {}: {}. Valid retry policy types are: {}. Will default to {} retry policy type", new Object[] { "fs.s3.consistent.retryPolicyType", retryPolicy, 
      
        RetryPolicyType.getNamesAsString(), ConfigurationConstants.FS_S3_CONSISTENT_RETRY_POLICY_TYPE_DEFAULT });
      
      retryPolicyType = RetryPolicyType.EXPONENTIAL;
    }
    return retryPolicyType;
  }
  
  public static List<Path> getTestedTempPaths(Configuration conf)
  {
    String[] s3BufferDirNames = conf.getStrings("fs.s3.buffer.dir");
    List<Path> tempDirs = new ArrayList(s3BufferDirNames.length);
    for (String s3BufferDirName : s3BufferDirNames)
    {
      Path s3BufferDirPath = Paths.get(s3BufferDirName, new String[0]);
      try
      {
        Files.createDirectories(s3BufferDirPath, new FileAttribute[0]);
        Files.delete(Files.createTempFile(s3BufferDirPath, "testfile-", ".tmp", new FileAttribute[0]));
        tempDirs.add(s3BufferDirPath);
      }
      catch (Exception logged)
      {
        LOG.warn("Cannot create temp dir with proper permission: {}", s3BufferDirPath, logged);
      }
    }
    if (tempDirs.isEmpty()) {
      throw new RuntimeException("Cannot create temp dirs: " + Arrays.toString(s3BufferDirNames));
    }
    return tempDirs;
  }
  
  public static boolean isDeleteTTLEnabled(Configuration conf)
  {
    return conf.getBoolean("fs.s3.consistent.metadata.delete.ttl.enabled", false);
  }
  
  public static Boolean isCSEUnencryptedLengthHeaderMPUEnabled(Configuration conf)
  {
    return Boolean.valueOf(conf.getBoolean("fs.s3.multipart.cse.add.unencrypted.length", false));
  }
  
  public static boolean isLoadConfigurationEnabled(Configuration conf)
  {
    return conf.getBoolean("fs.s3.configuration.load.enabled", true);
  }
  
  public static long getDeleteTTLExpirationLength(Configuration conf)
  {
    return conf.getLong("fs.s3.consistent.metadata.delete.ttl.expiration.seconds", 43200L);
  }
  
  public static EncryptionMaterialsProvider getEncryptionMaterialsProvider(Configuration conf)
  {
    return (EncryptionMaterialsProvider)ReflectionUtils.newInstance(getEncryptionMaterialsProviderClass(conf), conf);
  }
  
  private static Class<? extends EncryptionMaterialsProvider> getEncryptionMaterialsProviderClass(Configuration conf)
  {
    String className = conf.get("fs.s3.cse.encryptionMaterialsProvider");
    if (Strings.isNullOrEmpty(className)) {
      throw new IllegalArgumentException("EncryptionMaterialsProvider is not specified using fs.s3.cse.encryptionMaterialsProvider");
    }
    try
    {
      return Class.forName(className).asSubclass(EncryptionMaterialsProvider.class);
    }
    catch (ClassNotFoundException e)
    {
      throw new IllegalArgumentException("EncryptionMaterialsProvider not found: " + className, e);
    }
  }
  
  public static CryptoConfiguration getCryptoConfiguration(Configuration conf)
  {
    CryptoMode cryptoMode = CryptoMode.valueOf(conf.get("fs.s3.cse.cryptoMode", CSEConstants.CSE_CRYPTO_MODE_DEFAULT));
    
    CryptoStorageMode storageMode = CryptoStorageMode.valueOf(conf.get("fs.s3.cse.cryptoStorageMode", CSEConstants.CSE_CRYPTO_STORAGE_MODE_DEFAULT));
    
    CryptoConfiguration cryptoConfiguration = new CryptoConfiguration().withCryptoMode(cryptoMode).withStorageMode(storageMode);
    String kmsRegion = EmrFsUtils.getRegion(conf, "fs.s3.cse.kms.region");
    if (!Strings.isNullOrEmpty(kmsRegion)) {
      cryptoConfiguration.setAwsKmsRegion(RegionUtils.getRegion(kmsRegion));
    }
    return cryptoConfiguration;
  }
  
  public static boolean isAuthorizationAuditingEnabled(Configuration conf)
  {
    return conf.getBoolean("fs.s3.authorization.audit.enabled", true);
  }
  
  public static Boolean isUseRequesterPaysHeader(Configuration conf)
  {
    return Boolean.valueOf(conf.getBoolean("fs.s3.useRequesterPaysHeader", false));
  }
  
  public static long getMetadataCacheExpirationSeconds(Configuration conf)
  {
    long expirationSeconds = conf.getLong("fs.s3.metadata.cache.expiration.seconds", 60L);
    
    Preconditions.checkArgument(expirationSeconds >= 0L, "Configured value for %s must not be negative (was: %s)", new Object[] { "fs.s3.metadata.cache.expiration.seconds", 
    
      Long.valueOf(expirationSeconds) });
    return expirationSeconds;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */