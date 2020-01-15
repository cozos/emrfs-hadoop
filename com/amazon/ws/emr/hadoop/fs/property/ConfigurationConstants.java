package com.amazon.ws.emr.hadoop.fs.property;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSEAlgorithm;

public final class ConfigurationConstants
{
  public static final String AWS_ACCESS_KEY_ID = "fs.s3.awsAccessKeyId";
  public static final String AWS_SECRET_KEY_ID = "fs.s3.awsSecretAccessKey";
  public static final String DYNAMODB_ENDPOINT = "fs.s3.consistent.dynamodb.endpoint";
  public static final String DELETE_MAX_BATCH_SIZE = "fs.s3.delete.maxBatchSize";
  public static final String METADATA_ACCESS_KEY = "fs.s3.consistent.metadata.accessKey";
  public static final String METADATA_SECRET_KEY = "fs.s3.consistent.metadata.secretKey";
  public static final String METADATA_TABLE_NAME = "fs.s3.consistent.metadata.tableName";
  public static final String METADATA_ETAG_VERIFICATION_ENABLED = "fs.s3.consistent.metadata.etag.verification.enabled";
  public static final String MULTIPART_FRACTION_PART_AVG_COMPLETION_TIME = "fs.s3.multipart.fraction.part.avg.completion.time";
  public static final String MULTIPART_PART_ATTEMPTS = "fs.s3.multipart.part.attempts";
  public static final String MULTIPART_UPLOAD_SPLIT_SIZE = "fs.s3n.multipart.uploads.split.size";
  public static final String PARTS_COMPLETED_THRESHOLD_PERCENT = "fs.s3.multipart.th.fraction.parts.completed";
  public static final String CLEAN_INCOMPLETE_MULTIPART_ENABLED = "fs.s3.multipart.clean.enabled";
  public static final String CLEAN_INCOMPLETE_MULTIPART_AGE_THRESHOLD_SECONDS = "fs.s3.multipart.clean.age.threshold";
  public static final String CLEAN_INCOMPLETE_MULTIPART_MAX_JITTER_DELAY_MILLIS = "fs.s3.multipart.clean.jitter.max";
  public static final String MULTIPART_UPLOAD_CSE_ADD_UNENCRYPTED_LEN_HEADER = "fs.s3.multipart.cse.add.unencrypted.length";
  public static final String S3_ENDPOINT = "fs.s3n.endpoint";
  public static final String S3_THREADPOOL_SIZE = "fs.s3.threadpool.size";
  public static final String S3_THREADPOOL_BUFFER_SIZE = "fs.s3.threadpool.buffer.size";
  public static final String SERVER_SIDE_ALGORITHM_FOR_KMS = SSEAlgorithm.KMS.getAlgorithm();
  public static final String SERVER_SIDE_ENCRYPTION_ALGORITHM = "fs.s3.serverSideEncryptionAlgorithm";
  public static final String SERVER_SIDE_ENCRYPTION_ENABLED = "fs.s3.enableServerSideEncryption";
  public static final String SERVER_SIDE_ENCRYPTION_KMS_KEY_ID = "fs.s3.serverSideEncryption.kms.keyId";
  public static final String STORAGE_CLASS = "fs.s3.storageClass";
  public static final String FS_S3_SEEK_STRATEGY = "fs.s3.seekStrategy";
  public static final String FS_S3_MAX_CONNECTIONS = "fs.s3.maxConnections";
  public static final String FS_S3_MAX_RETRIES = "fs.s3.maxRetries";
  public static final int FS_S3_MAX_RETRIES_DEFAULT = 10;
  public static final String FS_S3_RETRY_PERIOD_SECONDS = "fs.s3.retryPeriodSeconds";
  public static final String FS_S3_SEEK_STRATEGY_DEFAULT = SeekStrategyName.LAZY.getName();
  public static final String FS_S3_CONSISTENT_RETRY_POLICY_TYPE = "fs.s3.consistent.retryPolicyType";
  public static final String FS_S3_CONSISTENT_RETRY_POLICY_TYPE_DEFAULT = RetryPolicyType.EXPONENTIAL
    .getName();
  public static final String FS_S3_GET_OBJECT_INITIAL_SOCKET_TIMEOUT_MILLIS = "fs.s3.getObject.initialSocketTimeoutMilliseconds";
  public static final int DEFAULT_FS_S3_GET_OBJECT_INITIAL_SOCKET_TIMEOUT_MILLIS = 50000;
  public static final int MIN_FS_S3_TIMEOUT_SOCKET_MILLIS = 1;
  public static final String FS_S3_SIGNER_TYPE = "fs.s3.signerType";
  public static final String FS_S3N_SSL_ENABLED = "fs.s3n.ssl.enabled";
  public static final String FS_S3_USE_REQUESTER_PAYS_HEADER = "fs.s3.useRequesterPaysHeader";
  public static final String FS_CONSISTENT_METADATA_CAPACITY_AUTOINCREASE = "fs.s3.consistent.metadata.capacity.autoIncrease";
  public static final String FS_CONSISTENT_METADATA_CAPACITY_AUTOINCREASE_MAXREAD = "fs.s3.consistent.metadata.capacity.autoIncrease.maxRead";
  public static final String FS_CONSISTENT_METADATA_CAPACITY_AUTOINCREASE_MAXWRITE = "fs.s3.consistent.metadata.capacity.autoIncrease.maxWrite";
  public static final String FS_CONSISTENT_METADATA_CAPACITY_AUTOINCREASE_FACTOR = "fs.s3.consistent.metadata.capacity.autoIncrease.factor";
  public static final String FS_S3_CONSISTENT_METADATA_DELETE_TTL_EXPIRATION_SECONDS = "fs.s3.consistent.metadata.delete.ttl.expiration.seconds";
  public static final String FS_S3_CONSISTENT_METADATA_DELETE_TTL_ENABLED = "fs.s3.consistent.metadata.delete.ttl.enabled";
  public static final String FS_S3_BUFFER_DIR = "fs.s3.buffer.dir";
  public static final String FS_S3_CONSISTENT_METADATA_WRITE_CAPACITY = "fs.s3.consistent.metadata.write.capacity";
  public static final String FS_S3_CONSISTENT_METADATA_READ_CAPACITY = "fs.s3.consistent.metadata.read.capacity";
  public static final String FS_S3_CONSISTENT_RETRY_COUNT = "fs.s3.consistent.retryCount";
  public static final String FS_S3_CONSISTENT_RETRY_PERIOD_SECONDS = "fs.s3.consistent.retryPeriodSeconds";
  public static final String FS_S3_CANNED_ACL = "fs.s3.canned.acl";
  public static final String FS_S3_BUCKETS_CREATE_REGION = "fs.s3.buckets.create.region";
  public static final String FS_S3_BUCKETS_CREATE_ENABLED = "fs.s3.buckets.create.enabled";
  public static final String FS_S3N_MULTIPART_UPLOADS_ENABLED = "fs.s3n.multipart.uploads.enabled";
  public static final String FS_S3N_BLOCK_SIZE = "fs.s3n.block.size";
  public static final String FS_S3_CONSISTENT = "fs.s3.consistent";
  public static final String FS_AUTH_S3_ROLE_MAPPING = "fs.s3.authorization.roleMapping";
  public static final String FS_S3_AUTH_AUDIT_ENABLED = "fs.s3.authorization.audit.enabled";
  public static final boolean FS_S3_AUTH_AUDIT_ENABLED_DEFAULT = true;
  public static final String FS_S3_METADATA_CACHE_EXPIRATION_SECONDS = "fs.s3.metadata.cache.expiration.seconds";
  public static final long FS_S3_METADATA_CACHE_EXPIRATION_SECONDS_DEFAULT = 60L;
  public static final String FS_S3_CONFIGURATION_LOAD_ENABLED = "fs.s3.configuration.load.enabled";
  
  private ConfigurationConstants()
  {
    throw new AssertionError();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.property.ConfigurationConstants
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */