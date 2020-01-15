package com.amazon.ws.emr.hadoop.fs.cse;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoStorageMode;

public class CSEConstants
{
  public static final String CSE_ENABLE_CONF = "fs.s3.cse.enabled";
  public static final boolean CSE_ENABLE_DEFAULT = false;
  public static final String CSE_MATERIALS_DESC_ENABLE_CONF = "fs.s3.cse.materialsDescription.enabled";
  public static final boolean CSE_MATERIALS_DESC_ENABLE_DEFAULT = false;
  public static final String CSE_PLAINTEXT_LEN_ENABLE_CONF = "fs.s3.cse.plaintextLength.enabled";
  public static final boolean CSE_PLAINTEXT_LEN_ENABLE_DEFAULT = true;
  public static final String CSE_PROVIDER_CONF = "fs.s3.cse.encryptionMaterialsProvider";
  public static final String CSE_CRYPTO_STORAGE_MODE_CONF = "fs.s3.cse.cryptoStorageMode";
  public static final String CSE_CRYPTO_STORAGE_MODE_DEFAULT = CryptoStorageMode.ObjectMetadata.name();
  public static final String CSE_CRYPTO_STORAGE_MODE_DELETE_INSTRUCTION_FILES_CONF = "fs.s3.cse.cryptoStorageMode.deleteInstructionFiles.enabled";
  public static final boolean CSE_CRYPTO_STORAGE_MODE_DELETE_INSTRUCTION_FILES_DEFAULT = false;
  public static final String CSE_CRYPTO_MODE_CONF = "fs.s3.cse.cryptoMode";
  public static final String CSE_CRYPTO_MODE_DEFAULT = CryptoMode.EncryptionOnly.name();
  public static final String CSE_KMS_KEY_ID_CONF = "fs.s3.cse.kms.keyId";
  public static final String CSE_KMS_REGION_CONF = "fs.s3.cse.kms.region";
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.CSEConstants
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */