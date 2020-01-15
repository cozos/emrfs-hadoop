package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Direct;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptedGetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ExtraMaterialsDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

class S3CryptoModuleAE
  extends S3CryptoModuleBase<MultipartUploadCryptoContext>
{
  S3CryptoModuleAE(AWSKMS kms, S3Direct s3, AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    super(kms, s3, credentialsProvider, encryptionMaterialsProvider, cryptoConfig);
    
    CryptoMode mode = cryptoConfig.getCryptoMode();
    if ((mode != CryptoMode.StrictAuthenticatedEncryption) && (mode != CryptoMode.AuthenticatedEncryption)) {
      throw new IllegalArgumentException();
    }
  }
  
  S3CryptoModuleAE(S3Direct s3, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    this(null, s3, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfig);
  }
  
  S3CryptoModuleAE(AWSKMS kms, S3Direct s3, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    this(kms, s3, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfig);
  }
  
  protected boolean isStrict()
  {
    return false;
  }
  
  public S3Object getObjectSecurely(GetObjectRequest req)
  {
    appendUserAgent(req, AmazonS3EncryptionClient.USER_AGENT);
    
    long[] desiredRange = req.getRange();
    if ((isStrict()) && ((desiredRange != null) || (req.getPartNumber() != null))) {
      throw new SecurityException("Range get and getting a part are not allowed in strict crypto mode");
    }
    long[] adjustedCryptoRange = getAdjustedCryptoRange(desiredRange);
    if (adjustedCryptoRange != null) {
      req.setRange(adjustedCryptoRange[0], adjustedCryptoRange[1]);
    }
    S3Object retrieved = s3.getObject(req);
    if (retrieved == null) {
      return null;
    }
    String suffix = null;
    if ((req instanceof EncryptedGetObjectRequest))
    {
      EncryptedGetObjectRequest ereq = (EncryptedGetObjectRequest)req;
      suffix = ereq.getInstructionFileSuffix();
    }
    try
    {
      return (suffix == null) || (suffix.trim().isEmpty()) ? 
        decipher(req, desiredRange, adjustedCryptoRange, retrieved) : 
        decipherWithInstFileSuffix(req, desiredRange, adjustedCryptoRange, retrieved, suffix);
    }
    catch (RuntimeException ex)
    {
      IOUtils.closeQuietly(retrieved, log);
      throw ex;
    }
    catch (Error error)
    {
      IOUtils.closeQuietly(retrieved, log);
      throw error;
    }
  }
  
  private S3Object decipher(GetObjectRequest req, long[] desiredRange, long[] cryptoRange, S3Object retrieved)
  {
    S3ObjectWrapper wrapped = new S3ObjectWrapper(retrieved, req.getS3ObjectId());
    if (wrapped.hasEncryptionInfo()) {
      return decipherWithMetadata(req, desiredRange, cryptoRange, wrapped);
    }
    S3ObjectWrapper ifile = fetchInstructionFile(req.getS3ObjectId(), null);
    if (ifile != null) {
      try
      {
        return decipherWithInstructionFile(req, desiredRange, cryptoRange, wrapped, ifile);
      }
      finally
      {
        IOUtils.closeQuietly(ifile, log);
      }
    }
    if ((isStrict()) || (!cryptoConfig.isIgnoreMissingInstructionFile()))
    {
      IOUtils.closeQuietly(wrapped, log);
      
      throw new SecurityException("Instruction file not found for S3 object with bucket name: " + retrieved.getBucketName() + ", key: " + retrieved.getKey());
    }
    log.warn(String.format("Unable to detect encryption information for object '%s' in bucket '%s'. Returning object without decryption.", new Object[] {retrieved
    
      .getKey(), retrieved
      .getBucketName() }));
    
    S3ObjectWrapper adjusted = adjustToDesiredRange(wrapped, desiredRange, null);
    return adjusted.getS3Object();
  }
  
  private S3Object decipherWithInstFileSuffix(GetObjectRequest req, long[] desiredRange, long[] cryptoRange, S3Object retrieved, String instFileSuffix)
  {
    S3ObjectId id = req.getS3ObjectId();
    
    S3ObjectWrapper ifile = fetchInstructionFile(id, instFileSuffix);
    if (ifile == null) {
      throw new SdkClientException("Instruction file with suffix " + instFileSuffix + " is not found for " + retrieved);
    }
    try
    {
      return decipherWithInstructionFile(req, desiredRange, cryptoRange, new S3ObjectWrapper(retrieved, id), ifile);
    }
    finally
    {
      IOUtils.closeQuietly(ifile, log);
    }
  }
  
  private S3Object decipherWithInstructionFile(GetObjectRequest req, long[] desiredRange, long[] cryptoRange, S3ObjectWrapper retrieved, S3ObjectWrapper instructionFile)
  {
    ExtraMaterialsDescription extraMatDesc = ExtraMaterialsDescription.NONE;
    boolean keyWrapExpected = isStrict();
    if ((req instanceof EncryptedGetObjectRequest))
    {
      EncryptedGetObjectRequest ereq = (EncryptedGetObjectRequest)req;
      extraMatDesc = ereq.getExtraMaterialDescription();
      if (!keyWrapExpected) {
        keyWrapExpected = ereq.isKeyWrapExpected();
      }
    }
    String json = instructionFile.toJsonString();
    
    Map<String, String> matdesc = Collections.unmodifiableMap((Map)Jackson.fromJsonString(json, Map.class));
    
    ContentCryptoMaterial cekMaterial = ContentCryptoMaterial.fromInstructionFile(matdesc, kekMaterialsProvider, cryptoConfig
    
      .getCryptoProvider(), cryptoConfig
      .getAlwaysUseCryptoProvider(), cryptoRange, extraMatDesc, keyWrapExpected, kms);
    
    securityCheck(cekMaterial, retrieved);
    S3ObjectWrapper decrypted = decrypt(retrieved, cekMaterial, cryptoRange);
    
    S3ObjectWrapper adjusted = adjustToDesiredRange(decrypted, desiredRange, matdesc);
    
    return adjusted.getS3Object();
  }
  
  private S3Object decipherWithMetadata(GetObjectRequest req, long[] desiredRange, long[] cryptoRange, S3ObjectWrapper retrieved)
  {
    ExtraMaterialsDescription extraMatDesc = ExtraMaterialsDescription.NONE;
    boolean keyWrapExpected = isStrict();
    if ((req instanceof EncryptedGetObjectRequest))
    {
      EncryptedGetObjectRequest ereq = (EncryptedGetObjectRequest)req;
      extraMatDesc = ereq.getExtraMaterialDescription();
      if (!keyWrapExpected) {
        keyWrapExpected = ereq.isKeyWrapExpected();
      }
    }
    ContentCryptoMaterial cekMaterial = ContentCryptoMaterial.fromObjectMetadata(retrieved.getObjectMetadata(), kekMaterialsProvider, cryptoConfig
    
      .getCryptoProvider(), cryptoConfig
      .getAlwaysUseCryptoProvider(), cryptoRange, extraMatDesc, keyWrapExpected, kms);
    
    securityCheck(cekMaterial, retrieved);
    S3ObjectWrapper decrypted = decrypt(retrieved, cekMaterial, cryptoRange);
    
    S3ObjectWrapper adjusted = adjustToDesiredRange(decrypted, desiredRange, null);
    
    return adjusted.getS3Object();
  }
  
  protected final S3ObjectWrapper adjustToDesiredRange(S3ObjectWrapper s3object, long[] range, Map<String, String> instruction)
  {
    if (range == null) {
      return s3object;
    }
    ContentCryptoScheme encryptionScheme = s3object.encryptionSchemeOf(instruction);
    
    long instanceLen = s3object.getObjectMetadata().getInstanceLength();
    long maxOffset = instanceLen - encryptionScheme.getTagLengthInBits() / 8 - 1L;
    if (range[1] > maxOffset)
    {
      range[1] = maxOffset;
      if (range[0] > range[1])
      {
        IOUtils.closeQuietly(s3object.getObjectContent(), log);
        s3object.setObjectContent(new ByteArrayInputStream(new byte[0]));
        return s3object;
      }
    }
    if (range[0] > range[1]) {
      return s3object;
    }
    try
    {
      S3ObjectInputStream objectContent = s3object.getObjectContent();
      InputStream adjustedRangeContents = new AdjustedRangeInputStream(objectContent, range[0], range[1]);
      s3object.setObjectContent(new S3ObjectInputStream(adjustedRangeContents, objectContent.getHttpRequest()));
      return s3object;
    }
    catch (IOException e)
    {
      throw new SdkClientException("Error adjusting output to desired byte range: " + e.getMessage());
    }
  }
  
  public ObjectMetadata getObjectSecurely(GetObjectRequest getObjectRequest, File destinationFile)
  {
    assertParameterNotNull(destinationFile, "The destination file parameter must be specified when downloading an object directly to a file");
    
    S3Object s3Object = getObjectSecurely(getObjectRequest);
    if (s3Object == null) {
      return null;
    }
    OutputStream outputStream = null;
    try
    {
      outputStream = new BufferedOutputStream(new FileOutputStream(destinationFile));
      byte[] buffer = new byte['⠀'];
      int bytesRead;
      while ((bytesRead = s3Object.getObjectContent().read(buffer)) > -1) {
        outputStream.write(buffer, 0, bytesRead);
      }
    }
    catch (IOException e)
    {
      throw new SdkClientException("Unable to store object contents to disk: " + e.getMessage(), e);
    }
    finally
    {
      IOUtils.closeQuietly(outputStream, log);
      IOUtils.closeQuietly(s3Object.getObjectContent(), log);
    }
    return s3Object.getObjectMetadata();
  }
  
  final MultipartUploadCryptoContext newUploadContext(InitiateMultipartUploadRequest req, ContentCryptoMaterial cekMaterial)
  {
    return new MultipartUploadCryptoContext(req
      .getBucketName(), req.getKey(), cekMaterial);
  }
  
  final CipherLite cipherLiteForNextPart(MultipartUploadCryptoContext uploadContext)
  {
    return uploadContext.getCipherLite();
  }
  
  final SdkFilterInputStream wrapForMultipart(CipherLiteInputStream is, long partSize)
  {
    return is;
  }
  
  final long computeLastPartSize(UploadPartRequest req)
  {
    return 
      req.getPartSize() + contentCryptoScheme.getTagLengthInBits() / 8;
  }
  
  final void updateUploadContext(MultipartUploadCryptoContext uploadContext, SdkFilterInputStream is) {}
  
  private S3ObjectWrapper decrypt(S3ObjectWrapper wrapper, ContentCryptoMaterial cekMaterial, long[] range)
  {
    S3ObjectInputStream objectContent = wrapper.getObjectContent();
    wrapper.setObjectContent(new S3ObjectInputStream(new CipherLiteInputStream(objectContent, cekMaterial
    
      .getCipherLite(), 2048), objectContent
      
      .getHttpRequest()));
    return wrapper;
  }
  
  private void assertParameterNotNull(Object parameterValue, String errorMessage)
  {
    if (parameterValue == null) {
      throw new IllegalArgumentException(errorMessage);
    }
  }
  
  protected final long ciphertextLength(long originalContentLength)
  {
    return originalContentLength + contentCryptoScheme.getTagLengthInBits() / 8;
  }
  
  static {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3CryptoModuleAE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */