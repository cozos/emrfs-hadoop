package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

public abstract interface Headers
{
  public static final String CACHE_CONTROL = "Cache-Control";
  public static final String CONTENT_DISPOSITION = "Content-Disposition";
  public static final String CONTENT_ENCODING = "Content-Encoding";
  public static final String CONTENT_LENGTH = "Content-Length";
  public static final String CONTENT_RANGE = "Content-Range";
  public static final String CONTENT_MD5 = "Content-MD5";
  public static final String CONTENT_TYPE = "Content-Type";
  public static final String CONTENT_LANGUAGE = "Content-Language";
  public static final String DATE = "Date";
  public static final String ETAG = "ETag";
  public static final String LAST_MODIFIED = "Last-Modified";
  public static final String SERVER = "Server";
  public static final String CONNECTION = "Connection";
  public static final String AMAZON_PREFIX = "x-amz-";
  public static final String S3_CANNED_ACL = "x-amz-acl";
  public static final String S3_ALTERNATE_DATE = "x-amz-date";
  public static final String S3_USER_METADATA_PREFIX = "x-amz-meta-";
  public static final String S3_VERSION_ID = "x-amz-version-id";
  public static final String S3_MFA = "x-amz-mfa";
  public static final String REQUEST_ID = "x-amz-request-id";
  public static final String EXTENDED_REQUEST_ID = "x-amz-id-2";
  public static final String CLOUD_FRONT_ID = "X-Amz-Cf-Id";
  public static final String METADATA_DIRECTIVE = "x-amz-metadata-directive";
  public static final String SECURITY_TOKEN = "x-amz-security-token";
  public static final String STORAGE_CLASS = "x-amz-storage-class";
  public static final String SERVER_SIDE_ENCRYPTION = "x-amz-server-side-encryption";
  public static final String SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM = "x-amz-server-side-encryption-customer-algorithm";
  public static final String SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY = "x-amz-server-side-encryption-customer-key";
  public static final String SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5 = "x-amz-server-side-encryption-customer-key-MD5";
  public static final String COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM = "x-amz-copy-source-server-side-encryption-customer-algorithm";
  public static final String COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY = "x-amz-copy-source-server-side-encryption-customer-key";
  public static final String COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5 = "x-amz-copy-source-server-side-encryption-customer-key-MD5";
  public static final String EXPIRATION = "x-amz-expiration";
  public static final String EXPIRES = "Expires";
  public static final String COPY_SOURCE_IF_MATCH = "x-amz-copy-source-if-match";
  public static final String COPY_SOURCE_IF_NO_MATCH = "x-amz-copy-source-if-none-match";
  public static final String COPY_SOURCE_IF_UNMODIFIED_SINCE = "x-amz-copy-source-if-unmodified-since";
  public static final String COPY_SOURCE_IF_MODIFIED_SINCE = "x-amz-copy-source-if-modified-since";
  public static final String RANGE = "Range";
  public static final String COPY_PART_RANGE = "x-amz-copy-source-range";
  public static final String GET_OBJECT_IF_MODIFIED_SINCE = "If-Modified-Since";
  public static final String GET_OBJECT_IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
  public static final String GET_OBJECT_IF_MATCH = "If-Match";
  public static final String GET_OBJECT_IF_NONE_MATCH = "If-None-Match";
  public static final String CRYPTO_KEY = "x-amz-key";
  public static final String CRYPTO_KEY_V2 = "x-amz-key-v2";
  public static final String CRYPTO_IV = "x-amz-iv";
  public static final String MATERIALS_DESCRIPTION = "x-amz-matdesc";
  public static final String CRYPTO_INSTRUCTION_FILE = "x-amz-crypto-instr-file";
  public static final String UNENCRYPTED_CONTENT_LENGTH = "x-amz-unencrypted-content-length";
  public static final String UNENCRYPTED_CONTENT_MD5 = "x-amz-unencrypted-content-md5";
  public static final String REDIRECT_LOCATION = "x-amz-website-redirect-location";
  public static final String RESTORE = "x-amz-restore";
  public static final String CRYPTO_KEYWRAP_ALGORITHM = "x-amz-wrap-alg";
  public static final String CRYPTO_CEK_ALGORITHM = "x-amz-cek-alg";
  public static final String CRYPTO_TAG_LENGTH = "x-amz-tag-len";
  public static final String REQUESTER_PAYS_HEADER = "x-amz-request-payer";
  public static final String REQUESTER_CHARGED_HEADER = "x-amz-request-charged";
  public static final String SERVER_SIDE_ENCRYPTION_AWS_KMS_KEYID = "x-amz-server-side-encryption-aws-kms-key-id";
  public static final String SERVER_SIDE_ENCRYPTION_AWS_KMS_CONTEXT = "x-amz-server-side-encryption-context";
  public static final String OBJECT_REPLICATION_STATUS = "x-amz-replication-status";
  public static final String S3_SERVING_REGION = "x-amz-region";
  public static final String S3_BUCKET_REGION = "x-amz-bucket-region";
  public static final String ABORT_DATE = "x-amz-abort-date";
  public static final String ABORT_RULE_ID = "x-amz-abort-rule-id";
  public static final String S3_PARTS_COUNT = "x-amz-mp-parts-count";
  public static final String S3_TAGGING = "x-amz-tagging";
  public static final String S3_TAGGING_COUNT = "x-amz-tagging-count";
  public static final String TAGGING_DIRECTIVE = "x-amz-tagging-directive";
  public static final String REMOVE_SELF_BUCKET_ACCESS = "x-amz-confirm-remove-self-bucket-access";
  public static final String S3_RESTORE_OUTPUT_PATH = "x-amz-restore-output-path";
  public static final String OBJECT_LOCK_MODE = "x-amz-object-lock-mode";
  public static final String OBJECT_LOCK_RETAIN_UNTIL_DATE = "x-amz-object-lock-retain-until-date";
  public static final String OBJECT_LOCK_LEGAL_HOLD_STATUS = "x-amz-object-lock-legal-hold";
  public static final String OBJECT_LOCK_TOKEN = "x-amz-bucket-object-lock-token";
  public static final String OBJECT_LOCK_ENABLED_FOR_BUCKET = "x-amz-bucket-object-lock-enabled";
  public static final String BYPASS_GOVERNANCE_RETENTION = "x-amz-bypass-governance-retention";
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.Headers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */