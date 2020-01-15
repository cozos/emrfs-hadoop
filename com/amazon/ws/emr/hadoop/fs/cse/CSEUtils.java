package com.amazon.ws.emr.hadoop.fs.cse;

import com.amazon.ws.emr.hadoop.fs.s3.lite.AmazonS3Lite;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoStorageMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InstructionFileId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import com.amazon.ws.emr.hadoop.fs.util.ConfigurationUtils;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSEUtils
{
  private static final Logger LOG = LoggerFactory.getLogger(CSEUtils.class);
  public static final int CBC_GCM_BLOCK_SIZE = 16;
  public static final String DESC_PATH = "Path";
  public static final String DESC_DST_PATH = "DstPath";
  public static final String DESC_JOBFLOWID = "JobflowId";
  public static final String jobflowId = EmrFsUtils.getJobFlowId();
  
  public static boolean isInstructionFile(String key)
  {
    if ((StringUtils.isNotBlank(key)) && 
      (key.endsWith(".instruction"))) {
      return true;
    }
    return false;
  }
  
  public static boolean isObjectEncrypted(AmazonS3Lite s3, String bucket, String key)
  {
    return isObjectEncrypted(s3, bucket, key, s3.getObjectMetadata(bucket, key));
  }
  
  public static boolean isObjectEncrypted(AmazonS3Lite s3, String bucket, String key, ObjectMetadata metadata)
  {
    if ((metadata.getUserMetaDataOf("x-amz-key") != null) || 
      (metadata.getUserMetaDataOf("x-amz-key-v2") != null)) {
      return true;
    }
    S3ObjectId objectId = new S3ObjectId(bucket, key);
    InstructionFileId inst = objectId.instructionFileId();
    try
    {
      s3.getObjectMetadata(new GetObjectMetadataRequest(inst.getBucket(), inst.getKey()));
      return true;
    }
    catch (AmazonServiceException e)
    {
      if (e.getStatusCode() == 404) {
        return false;
      }
      throw e;
    }
  }
  
  public static long getPlaintextLength(AmazonS3Lite s3, String bucket, String key, ObjectMetadata metadata, Configuration conf)
  {
    return getPlaintextLength(s3, bucket, key, metadata, 
      ConfigurationUtils.isClientSideEncryptionEnabled(conf));
  }
  
  public static long getPlaintextLength(AmazonS3Lite s3, String bucket, String key, ObjectMetadata metadata, boolean isCseEnabled)
  {
    if (metadata == null) {
      metadata = s3.getObjectMetadata(bucket, key);
    }
    long contentLength = metadata.getContentLength();
    long plaintextLength = contentLength;
    if (!isCseEnabled) {
      return plaintextLength;
    }
    if ((contentLength != 0L) && (isObjectEncrypted(s3, bucket, key, metadata))) {
      if (metadata.getUserMetaDataOf("x-amz-unencrypted-content-length") != null)
      {
        plaintextLength = Long.parseLong((String)metadata.getUserMetadata().get("x-amz-unencrypted-content-length"));
      }
      else
      {
        long minPlaintextLength = contentLength - 16L;
        if (minPlaintextLength < 0L) {
          minPlaintextLength = 0L;
        }
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, key).withRange(minPlaintextLength, contentLength);
        S3Object object = s3.getObject(getObjectRequest);
        try
        {
          InputStream is = object.getObjectContent();Throwable localThrowable3 = null;
          try
          {
            int i = 0;
            while (is.read() != -1) {
              i++;
            }
            plaintextLength = minPlaintextLength + i;
          }
          catch (Throwable localThrowable1)
          {
            localThrowable3 = localThrowable1;throw localThrowable1;
          }
          finally
          {
            if (is != null) {
              if (localThrowable3 != null) {
                try
                {
                  is.close();
                }
                catch (Throwable localThrowable2)
                {
                  localThrowable3.addSuppressed(localThrowable2);
                }
              } else {
                is.close();
              }
            }
          }
        }
        catch (IOException e)
        {
          throw new RuntimeException(e);
        }
      }
    }
    return plaintextLength;
  }
  
  public static Map<String, String> getMaterialsDescription(Configuration conf, Path path)
  {
    return getMaterialsDescription(conf, path, null);
  }
  
  public static Map<String, String> getMaterialsDescription(Configuration conf, Path path, Path destPath)
  {
    Map<String, String> desc = null;
    if (KMSEncryptionMaterialsProvider.class.getName().equals(conf.get("fs.s3.cse.encryptionMaterialsProvider")))
    {
      desc = new HashMap();
      desc.put("kms_cmk_id", conf.get("fs.s3.cse.kms.keyId"));
    }
    else if (conf.getBoolean("fs.s3.cse.materialsDescription.enabled", false))
    {
      desc = new HashMap();
      desc.put("Path", path.toString());
      if (destPath != null) {
        desc.put("DstPath", destPath.toString());
      }
      if (StringUtils.isNotBlank(jobflowId)) {
        desc.put("JobflowId", jobflowId);
      }
    }
    return desc;
  }
  
  public static boolean shouldDeletePreviousInstructionFiles(Configuration conf)
  {
    boolean deletionEnabled = conf.getBoolean("fs.s3.cse.cryptoStorageMode.deleteInstructionFiles.enabled", false);
    
    boolean encryptionEnabled = ConfigurationUtils.isClientSideEncryptionEnabled(conf);
    boolean usingInstructionFiles = CryptoStorageMode.InstructionFile.name().equals(conf
      .get("fs.s3.cse.cryptoStorageMode"));
    return (deletionEnabled) && ((!encryptionEnabled) || ((encryptionEnabled) && (!usingInstructionFiles)));
  }
  
  public static void deletePreviousInstructionFileIfNecessary(Configuration conf, AmazonS3Lite s3, String bucket, String key)
  {
    deletePreviousInstructionFileIfNecessary(conf, s3, bucket, key, false);
  }
  
  public static void deletePreviousInstructionFileIfNecessary(Configuration conf, AmazonS3Lite s3, String bucket, String key, boolean force)
  {
    if ((force) || (shouldDeletePreviousInstructionFiles(conf)))
    {
      String instFileKey = new S3ObjectId(bucket, key).instructionFileId().getKey();
      try
      {
        s3.getObjectMetadata(bucket, instFileKey);
      }
      catch (AmazonServiceException e)
      {
        if (e.getStatusCode() == 404)
        {
          LOG.debug("Found no previous instruction file at {}/{}", bucket, instFileKey);
          return;
        }
        throw e;
      }
      s3.deleteObject(bucket, instFileKey);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.cse.CSEUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */