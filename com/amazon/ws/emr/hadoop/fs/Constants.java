package com.amazon.ws.emr.hadoop.fs;

public final class Constants
{
  public static final int EMR_FS_FILE_PROTO_VERSION = 1;
  public static final String FOLDER_SUFFIX = "_$folder$";
  public static final String CONFIGURATION_FILE_NAME = "emrfs-site.xml";
  public static final String ANNOTATIONS_CONF_FILE_NAME = "emrfs-annotations.properties";
  public static final String ENTITYSTORE_TAG_HASHKEY = "MultiKeyStoreTag";
  public static final String ENTITYSTORE_TAG_TABLEROLE_KEY = "TableRole";
  public static final String MULTIKEYSTORE_TAG_TABLEROLE_VALUE = "EmrMetadata";
  public static final String DEFAULT_EMRFS_METADATA_TABLE_NAME = "EmrFSMetadata";
  public static final boolean DEFAULT_EMRFS_METADATA_ETAG_VERIFICATION = true;
  public static final int DEFAULT_READ_CAPACITY = 500;
  public static final int DEFAULT_WRITE_CAPACITY = 100;
  public static final long DEFAULT_PART_SIZE = 134217728L;
  public static final long MIN_PART_SIZE = 5242880L;
  public static final long MAX_PART_SIZE = 5368709120L;
  public static final double DEFAULT_PARTS_COMPLETED_THRESHOLD_PERCENT = 0.5D;
  public static final double DEFAULT_MULTIPART_FRACTION_PART_AVG_COMPLETION_TIME = 1.0D;
  public static final int MIN_PART_ATTEMPTS = 2;
  public static final int DEFAULT_PART_ATTEMPTS = 5;
  public static final boolean DEFAULT_CLEAN_INCOMPLETE_MULTIPART_ENABLED = false;
  public static final long DEFAULT_CLEAN_INCOMPLETE_MULTIPART_AGE_THRESHOLD_SECONDS = 604800L;
  public static final int DEFAULT_CLEAN_INCOMPLETE_MULTIPART_MAX_JITTER_DELAY_MILLIS = 10000;
  public static final long CLEANER_THREAD_INITIAL_DELAY_SECONDS = 0L;
  public static final long CLEANER_THREAD_FIXED_DELAY_SECONDS = 900L;
  public static final int DEFAULT_S3_THREADPOOL_SIZE = 20;
  public static final int MAX_S3_THREADPOOL_SIZE = 40;
  public static final int DEFAULT_S3_THREADPOOL_BUFFER_SIZE = 10000;
  public static final String YARN_RESOURCE_MANAGER_URL_CONF_NAME = "yarn.resourcemanager.webapp.address";
  public static final String YARN_APPLICATION_TYPE_CONF_NAME = "yarn.application.type";
  public static final String FS_S3_BUCKET_REGEX = "^fs\\.s3\\.bucket\\.";
  public static final String FS_S3_PREFIX = "fs.s3.";
  public static final String REQUESTER_PAYS_HEADER_KEY = "x-amz-request-payer";
  public static final String REQUESTER_PAYS_HEADER_VALUE = "requester";
  
  private Constants()
  {
    throw new AssertionError();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.Constants
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */