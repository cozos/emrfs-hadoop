package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ReleasableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ResettableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.InputSubstream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.Mimetypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3Direct;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbstractPutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoStorageMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InstructionFileId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MaterialsDescriptionProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutInstructionFileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3DataSource.Utils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectId;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.LengthCheckInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsFactory;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public abstract class S3CryptoModuleBase<T extends MultipartUploadCryptoContext>
  extends S3CryptoModule<T>
{
  private static final boolean IS_MULTI_PART = true;
  protected static final int DEFAULT_BUFFER_SIZE = 2048;
  protected final EncryptionMaterialsProvider kekMaterialsProvider;
  protected final Log log = LogFactory.getLog(getClass());
  protected final S3CryptoScheme cryptoScheme;
  protected final ContentCryptoScheme contentCryptoScheme;
  protected final CryptoConfiguration cryptoConfig;
  protected final Map<String, T> multipartUploadContexts = Collections.synchronizedMap(new HashMap());
  protected final S3Direct s3;
  protected final AWSKMS kms;
  
  protected S3CryptoModuleBase(AWSKMS kms, S3Direct s3, AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider kekMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    if (!cryptoConfig.isReadOnly()) {
      throw new IllegalArgumentException("The cryto configuration parameter is required to be read-only");
    }
    this.kekMaterialsProvider = kekMaterialsProvider;
    this.s3 = s3;
    this.cryptoConfig = cryptoConfig;
    cryptoScheme = S3CryptoScheme.from(cryptoConfig.getCryptoMode());
    contentCryptoScheme = cryptoScheme.getContentCryptoScheme();
    this.kms = kms;
  }
  
  protected S3CryptoModuleBase(S3Direct s3, AWSCredentialsProvider credentialsProvider, EncryptionMaterialsProvider kekMaterialsProvider, CryptoConfiguration cryptoConfig)
  {
    this.kekMaterialsProvider = kekMaterialsProvider;
    this.s3 = s3;
    this.cryptoConfig = cryptoConfig;
    cryptoScheme = S3CryptoScheme.from(cryptoConfig.getCryptoMode());
    contentCryptoScheme = cryptoScheme.getContentCryptoScheme();
    kms = null;
  }
  
  protected abstract long ciphertextLength(long paramLong);
  
  public PutObjectResult putObjectSecurely(PutObjectRequest req)
  {
    appendUserAgent(req, AmazonS3EncryptionClient.USER_AGENT);
    return cryptoConfig.getStorageMode() == CryptoStorageMode.InstructionFile ? 
      putObjectUsingInstructionFile(req) : 
      putObjectUsingMetadata(req);
  }
  
  private PutObjectResult putObjectUsingMetadata(PutObjectRequest req)
  {
    ContentCryptoMaterial cekMaterial = createContentCryptoMaterial(req);
    
    File fileOrig = req.getFile();
    InputStream isOrig = req.getInputStream();
    PutObjectRequest wrappedReq = (PutObjectRequest)wrapWithCipher(req, cekMaterial);
    
    req.setMetadata(updateMetadataWithContentCryptoMaterial(req
      .getMetadata(), req.getFile(), cekMaterial));
    try
    {
      return s3.putObject(wrappedReq);
    }
    finally
    {
      S3DataSource.Utils.cleanupDataSource(req, fileOrig, isOrig, wrappedReq.getInputStream(), log);
    }
  }
  
  private PutObjectResult putObjectUsingInstructionFile(PutObjectRequest putObjectRequest)
  {
    File fileOrig = putObjectRequest.getFile();
    InputStream isOrig = putObjectRequest.getInputStream();
    
    PutObjectRequest putInstFileRequest = putObjectRequest.clone().withFile(null).withInputStream(null);
    
    putInstFileRequest.setKey(putInstFileRequest.getKey() + "." + "instruction");
    
    ContentCryptoMaterial cekMaterial = createContentCryptoMaterial(putObjectRequest);
    
    PutObjectRequest req = (PutObjectRequest)wrapWithCipher(putObjectRequest, cekMaterial);
    try
    {
      result = s3.putObject(req);
    }
    finally
    {
      PutObjectResult result;
      S3DataSource.Utils.cleanupDataSource(putObjectRequest, fileOrig, isOrig, req
        .getInputStream(), log);
    }
    PutObjectResult result;
    s3.putObject(updateInstructionPutRequest(putInstFileRequest, cekMaterial));
    
    return result;
  }
  
  public final void abortMultipartUploadSecurely(AbortMultipartUploadRequest req)
  {
    s3.abortMultipartUpload(req);
    multipartUploadContexts.remove(req.getUploadId());
  }
  
  public final CopyPartResult copyPartSecurely(CopyPartRequest copyPartRequest)
  {
    String uploadId = copyPartRequest.getUploadId();
    T uploadContext = (MultipartUploadCryptoContext)multipartUploadContexts.get(uploadId);
    CopyPartResult result = s3.copyPart(copyPartRequest);
    if ((uploadContext != null) && (!uploadContext.hasFinalPartBeenSeen())) {
      uploadContext.setHasFinalPartBeenSeen(true);
    }
    return result;
  }
  
  abstract T newUploadContext(InitiateMultipartUploadRequest paramInitiateMultipartUploadRequest, ContentCryptoMaterial paramContentCryptoMaterial);
  
  public InitiateMultipartUploadResult initiateMultipartUploadSecurely(InitiateMultipartUploadRequest req)
  {
    appendUserAgent(req, AmazonS3EncryptionClient.USER_AGENT);
    
    ContentCryptoMaterial cekMaterial = createContentCryptoMaterial(req);
    if (cryptoConfig.getStorageMode() == CryptoStorageMode.ObjectMetadata)
    {
      ObjectMetadata metadata = req.getObjectMetadata();
      if (metadata == null) {
        metadata = new ObjectMetadata();
      }
      req.setObjectMetadata(updateMetadataWithContentCryptoMaterial(metadata, null, cekMaterial));
    }
    InitiateMultipartUploadResult result = s3.initiateMultipartUpload(req);
    T uploadContext = newUploadContext(req, cekMaterial);
    if ((req instanceof MaterialsDescriptionProvider))
    {
      MaterialsDescriptionProvider p = (MaterialsDescriptionProvider)req;
      uploadContext.setMaterialsDescription(p.getMaterialsDescription());
    }
    multipartUploadContexts.put(result.getUploadId(), uploadContext);
    return result;
  }
  
  abstract CipherLite cipherLiteForNextPart(T paramT);
  
  abstract long computeLastPartSize(UploadPartRequest paramUploadPartRequest);
  
  abstract <I extends CipherLiteInputStream> SdkFilterInputStream wrapForMultipart(I paramI, long paramLong);
  
  abstract void updateUploadContext(T paramT, SdkFilterInputStream paramSdkFilterInputStream);
  
  public UploadPartResult uploadPartSecurely(UploadPartRequest req)
  {
    appendUserAgent(req, AmazonS3EncryptionClient.USER_AGENT);
    int blockSize = contentCryptoScheme.getBlockSizeInBytes();
    boolean isLastPart = req.isLastPart();
    String uploadId = req.getUploadId();
    long partSize = req.getPartSize();
    boolean partSizeMultipleOfCipherBlockSize = 0L == partSize % blockSize;
    if ((!isLastPart) && (!partSizeMultipleOfCipherBlockSize)) {
      throw new SdkClientException("Invalid part size: part sizes for encrypted multipart uploads must be multiples of the cipher block size (" + blockSize + ") with the exception of the last part.");
    }
    T uploadContext = (MultipartUploadCryptoContext)multipartUploadContexts.get(uploadId);
    if (uploadContext == null) {
      throw new SdkClientException("No client-side information available on upload ID " + uploadId);
    }
    uploadContext.beginPartUpload(req.getPartNumber());
    CipherLite cipherLite = cipherLiteForNextPart(uploadContext);
    File fileOrig = req.getFile();
    InputStream isOrig = req.getInputStream();
    SdkFilterInputStream isCurr = null;
    try
    {
      CipherLiteInputStream clis = newMultipartS3CipherInputStream(req, cipherLite);
      isCurr = clis;
      
      isCurr = wrapForMultipart(clis, partSize);
      req.setInputStream(isCurr);
      
      req.setFile(null);
      req.setFileOffset(0L);
      if (isLastPart)
      {
        long lastPartSize = computeLastPartSize(req);
        if (lastPartSize > -1L) {
          req.setPartSize(lastPartSize);
        }
        if (uploadContext.hasFinalPartBeenSeen()) {
          throw new SdkClientException("This part was specified as the last part in a multipart upload, but a previous part was already marked as the last part.  Only the last part of the upload should be marked as the last part.");
        }
      }
      result = s3.uploadPart(req);
    }
    finally
    {
      UploadPartResult result;
      S3DataSource.Utils.cleanupDataSource(req, fileOrig, isOrig, isCurr, log);
      uploadContext.endPartUpload();
    }
    UploadPartResult result;
    if (isLastPart) {
      uploadContext.setHasFinalPartBeenSeen(true);
    }
    updateUploadContext(uploadContext, isCurr);
    return result;
  }
  
  protected final CipherLiteInputStream newMultipartS3CipherInputStream(UploadPartRequest req, CipherLite cipherLite)
  {
    File fileOrig = req.getFile();
    InputStream isOrig = req.getInputStream();
    InputStream isCurr = null;
    try
    {
      if (fileOrig == null)
      {
        if (isOrig == null) {
          throw new IllegalArgumentException("A File or InputStream must be specified when uploading part");
        }
        isCurr = isOrig;
      }
      else
      {
        isCurr = new ResettableInputStream(fileOrig);
      }
      isCurr = new InputSubstream(isCurr, req.getFileOffset(), req.getPartSize(), req.isLastPart());
      return cipherLite.markSupported() ? new CipherLiteInputStream(isCurr, cipherLite, 2048, true, req
      
        .isLastPart()) : new RenewableCipherLiteInputStream(isCurr, cipherLite, 2048, true, req
        
        .isLastPart());
    }
    catch (Exception e)
    {
      S3DataSource.Utils.cleanupDataSource(req, fileOrig, isOrig, isCurr, log);
      throw Throwables.failure(e, "Unable to create cipher input stream");
    }
  }
  
  public CompleteMultipartUploadResult completeMultipartUploadSecurely(CompleteMultipartUploadRequest req)
  {
    appendUserAgent(req, AmazonS3EncryptionClient.USER_AGENT);
    String uploadId = req.getUploadId();
    T uploadContext = (MultipartUploadCryptoContext)multipartUploadContexts.get(uploadId);
    if ((uploadContext != null) && (!uploadContext.hasFinalPartBeenSeen())) {
      throw new SdkClientException("Unable to complete an encrypted multipart upload without being told which part was the last.  Without knowing which part was the last, the encrypted data in Amazon S3 is incomplete and corrupt.");
    }
    CompleteMultipartUploadResult result = s3.completeMultipartUpload(req);
    if ((uploadContext != null) && 
      (cryptoConfig.getStorageMode() == CryptoStorageMode.InstructionFile)) {
      s3.putObject(createInstructionPutRequest(uploadContext
        .getBucketName(), uploadContext.getKey(), uploadContext
        .getContentCryptoMaterial()));
    }
    multipartUploadContexts.remove(uploadId);
    return result;
  }
  
  protected final ObjectMetadata updateMetadataWithContentCryptoMaterial(ObjectMetadata metadata, File file, ContentCryptoMaterial instruction)
  {
    if (metadata == null) {
      metadata = new ObjectMetadata();
    }
    if (file != null)
    {
      Mimetypes mimetypes = Mimetypes.getInstance();
      metadata.setContentType(mimetypes.getMimetype(file));
    }
    return instruction.toObjectMetadata(metadata, cryptoConfig.getCryptoMode());
  }
  
  protected final ContentCryptoMaterial createContentCryptoMaterial(AmazonWebServiceRequest req)
  {
    if ((req instanceof EncryptionMaterialsFactory))
    {
      EncryptionMaterialsFactory f = (EncryptionMaterialsFactory)req;
      EncryptionMaterials materials = f.getEncryptionMaterials();
      if (materials != null) {
        return buildContentCryptoMaterial(materials, req);
      }
    }
    if ((req instanceof MaterialsDescriptionProvider))
    {
      MaterialsDescriptionProvider mdp = (MaterialsDescriptionProvider)req;
      Map<String, String> matdesc_req = mdp.getMaterialsDescription();
      ContentCryptoMaterial ccm = newContentCryptoMaterial(kekMaterialsProvider, matdesc_req, cryptoConfig
      
        .getCryptoProvider(), req);
      if (ccm != null) {
        return ccm;
      }
      if (matdesc_req != null)
      {
        EncryptionMaterials material = kekMaterialsProvider.getEncryptionMaterials();
        if (!material.isKMSEnabled()) {
          throw new SdkClientException("No material available from the encryption material provider for description " + matdesc_req);
        }
      }
    }
    return newContentCryptoMaterial(kekMaterialsProvider, cryptoConfig
      .getCryptoProvider(), req);
  }
  
  private ContentCryptoMaterial newContentCryptoMaterial(EncryptionMaterialsProvider kekMaterialProvider, Map<String, String> materialsDescription, Provider provider, AmazonWebServiceRequest req)
  {
    EncryptionMaterials kekMaterials = kekMaterialProvider.getEncryptionMaterials(materialsDescription);
    if (kekMaterials == null) {
      return null;
    }
    return buildContentCryptoMaterial(kekMaterials, req);
  }
  
  private ContentCryptoMaterial newContentCryptoMaterial(EncryptionMaterialsProvider kekMaterialProvider, Provider provider, AmazonWebServiceRequest req)
  {
    EncryptionMaterials kekMaterials = kekMaterialProvider.getEncryptionMaterials();
    if (kekMaterials == null) {
      throw new SdkClientException("No material available from the encryption material provider");
    }
    return buildContentCryptoMaterial(kekMaterials, req);
  }
  
  public final void putLocalObjectSecurely(UploadObjectRequest reqIn, String uploadId, OutputStream os)
    throws IOException
  {
    UploadObjectRequest req = reqIn.clone();
    
    File fileOrig = req.getFile();
    InputStream isOrig = req.getInputStream();
    
    T uploadContext = (MultipartUploadCryptoContext)multipartUploadContexts.get(uploadId);
    ContentCryptoMaterial cekMaterial = uploadContext.getContentCryptoMaterial();
    req = (UploadObjectRequest)wrapWithCipher(req, cekMaterial);
    try
    {
      IOUtils.copy(req.getInputStream(), os);
      
      uploadContext.setHasFinalPartBeenSeen(true);
    }
    finally
    {
      S3DataSource.Utils.cleanupDataSource(req, fileOrig, isOrig, req
        .getInputStream(), log);
      IOUtils.closeQuietly(os, log);
    }
  }
  
  private ContentCryptoMaterial buildContentCryptoMaterial(EncryptionMaterials materials, AmazonWebServiceRequest req)
  {
    byte[] iv = new byte[contentCryptoScheme.getIVLengthInBytes()];
    cryptoConfig.getSecureRandom().nextBytes(iv);
    if (materials.isKMSEnabled())
    {
      Map<String, String> encryptionContext = ContentCryptoMaterial.mergeMaterialDescriptions(materials, req);
      
      GenerateDataKeyRequest keyGenReq = new GenerateDataKeyRequest().withEncryptionContext(encryptionContext).withKeyId(materials.getCustomerMasterKeyId()).withKeySpec(contentCryptoScheme.getKeySpec());
      keyGenReq
        .withGeneralProgressListener(req.getGeneralProgressListener())
        .withRequestMetricCollector(req.getRequestMetricCollector());
      
      GenerateDataKeyResult keyGenRes = kms.generateDataKey(keyGenReq);
      
      SecretKey cek = new SecretKeySpec(BinaryUtils.copyAllBytesFrom(keyGenRes.getPlaintext()), contentCryptoScheme.getKeyGeneratorAlgorithm());
      byte[] keyBlob = BinaryUtils.copyAllBytesFrom(keyGenRes.getCiphertextBlob());
      return ContentCryptoMaterial.wrap(cek, iv, contentCryptoScheme, cryptoConfig
        .getCryptoProvider(), cryptoConfig
        .getAlwaysUseCryptoProvider(), new KMSSecuredCEK(keyBlob, encryptionContext));
    }
    return ContentCryptoMaterial.create(
      generateCEK(materials), iv, materials, cryptoScheme, cryptoConfig, kms, req);
  }
  
  protected final SecretKey generateCEK(EncryptionMaterials kekMaterials)
  {
    String keygenAlgo = contentCryptoScheme.getKeyGeneratorAlgorithm();
    try
    {
      KeyGenerator generator = cryptoConfig.getCryptoProvider() == null ? KeyGenerator.getInstance(keygenAlgo) : KeyGenerator.getInstance(keygenAlgo, cryptoConfig.getCryptoProvider());
      generator.init(contentCryptoScheme.getKeyLengthInBits(), cryptoConfig.getSecureRandom());
      
      boolean involvesBCPublicKey = false;
      KeyPair keypair = kekMaterials.getKeyPair();
      if (keypair != null)
      {
        String keyWrapAlgo = cryptoScheme.getKeyWrapScheme().getKeyWrapAlgorithm(keypair.getPublic());
        if (keyWrapAlgo == null)
        {
          Provider provider = generator.getProvider();
          String providerName = provider == null ? null : provider.getName();
          involvesBCPublicKey = "BC".equals(providerName);
        }
      }
      SecretKey secretKey = generator.generateKey();
      if ((!involvesBCPublicKey) || (secretKey.getEncoded()[0] != 0)) {
        return secretKey;
      }
      for (int retry = 0; retry < 9; retry++)
      {
        secretKey = generator.generateKey();
        if (secretKey.getEncoded()[0] != 0) {
          return secretKey;
        }
      }
      throw new SdkClientException("Failed to generate secret key");
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new SdkClientException("Unable to generate envelope symmetric key:" + e.getMessage(), e);
    }
  }
  
  protected final <R extends AbstractPutObjectRequest> R wrapWithCipher(R request, ContentCryptoMaterial cekMaterial)
  {
    ObjectMetadata metadata = request.getMetadata();
    if (metadata == null) {
      metadata = new ObjectMetadata();
    }
    if (metadata.getContentMD5() != null) {
      metadata.addUserMetadata("x-amz-unencrypted-content-md5", metadata
        .getContentMD5());
    }
    metadata.setContentMD5(null);
    
    long plaintextLength = plaintextLength(request, metadata);
    if (plaintextLength >= 0L)
    {
      metadata.addUserMetadata("x-amz-unencrypted-content-length", 
        Long.toString(plaintextLength));
      
      metadata.setContentLength(ciphertextLength(plaintextLength));
    }
    request.setMetadata(metadata);
    request.setInputStream(newS3CipherLiteInputStream(request, cekMaterial, plaintextLength));
    
    request.setFile(null);
    return request;
  }
  
  private CipherLiteInputStream newS3CipherLiteInputStream(AbstractPutObjectRequest req, ContentCryptoMaterial cekMaterial, long plaintextLength)
  {
    File fileOrig = req.getFile();
    InputStream isOrig = req.getInputStream();
    InputStream isCurr = null;
    try
    {
      if (fileOrig == null) {
        isCurr = isOrig == null ? null : ReleasableInputStream.wrap(isOrig);
      } else {
        isCurr = new ResettableInputStream(fileOrig);
      }
      if (plaintextLength > -1L) {
        isCurr = new LengthCheckInputStream(isCurr, plaintextLength, false);
      }
      CipherLite cipherLite = cekMaterial.getCipherLite();
      if (cipherLite.markSupported()) {
        return new CipherLiteInputStream(isCurr, cipherLite, 2048);
      }
      return new RenewableCipherLiteInputStream(isCurr, cipherLite, 2048);
    }
    catch (Exception e)
    {
      S3DataSource.Utils.cleanupDataSource(req, fileOrig, isOrig, isCurr, log);
      throw Throwables.failure(e, "Unable to create cipher input stream");
    }
  }
  
  protected final long plaintextLength(AbstractPutObjectRequest request, ObjectMetadata metadata)
  {
    if (request.getFile() != null) {
      return request.getFile().length();
    }
    if ((request.getInputStream() != null) && 
      (metadata.getRawMetadataValue("Content-Length") != null)) {
      return metadata.getContentLength();
    }
    return -1L;
  }
  
  public final S3CryptoScheme getS3CryptoScheme()
  {
    return cryptoScheme;
  }
  
  protected final PutObjectRequest updateInstructionPutRequest(PutObjectRequest req, ContentCryptoMaterial cekMaterial)
  {
    byte[] bytes = cekMaterial.toJsonString(cryptoConfig.getCryptoMode()).getBytes(StringUtils.UTF8);
    ObjectMetadata metadata = req.getMetadata();
    if (metadata == null)
    {
      metadata = new ObjectMetadata();
      req.setMetadata(metadata);
    }
    metadata.setContentLength(bytes.length);
    
    metadata.addUserMetadata("x-amz-crypto-instr-file", "");
    
    req.setMetadata(metadata);
    req.setInputStream(new ByteArrayInputStream(bytes));
    
    return req;
  }
  
  protected final PutObjectRequest createInstructionPutRequest(String bucketName, String key, ContentCryptoMaterial cekMaterial)
  {
    byte[] bytes = cekMaterial.toJsonString(cryptoConfig.getCryptoMode()).getBytes(StringUtils.UTF8);
    InputStream is = new ByteArrayInputStream(bytes);
    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentLength(bytes.length);
    metadata.addUserMetadata("x-amz-crypto-instr-file", "");
    
    InstructionFileId ifileId = new S3ObjectId(bucketName, key).instructionFileId();
    return new PutObjectRequest(ifileId.getBucket(), ifileId.getKey(), is, metadata);
  }
  
  final <X extends AmazonWebServiceRequest> X appendUserAgent(X request, String userAgent)
  {
    request.getRequestClientOptions().appendUserAgent(userAgent);
    return request;
  }
  
  protected void securityCheck(ContentCryptoMaterial cekMaterial, S3ObjectWrapper retrieved) {}
  
  final S3ObjectWrapper fetchInstructionFile(S3ObjectId s3ObjectId, String instFileSuffix)
  {
    try
    {
      S3Object o = s3.getObject(
        createInstructionGetRequest(s3ObjectId, instFileSuffix));
      return o == null ? null : new S3ObjectWrapper(o, s3ObjectId);
    }
    catch (AmazonServiceException e)
    {
      if (log.isDebugEnabled()) {
        log.debug("Unable to retrieve instruction file : " + e
          .getMessage());
      }
    }
    return null;
  }
  
  public final PutObjectResult putInstructionFileSecurely(PutInstructionFileRequest req)
  {
    S3ObjectId id = req.getS3ObjectId();
    GetObjectRequest getreq = new GetObjectRequest(id);
    appendUserAgent(getreq, AmazonS3EncryptionClient.USER_AGENT);
    
    S3Object retrieved = s3.getObject(getreq);
    
    IOUtils.closeQuietly(retrieved, log);
    if (retrieved == null) {
      throw new IllegalArgumentException("The specified S3 object (" + id + ") doesn't exist.");
    }
    S3ObjectWrapper wrapped = new S3ObjectWrapper(retrieved, id);
    try
    {
      ContentCryptoMaterial origCCM = contentCryptoMaterialOf(wrapped);
      if ((ContentCryptoScheme.AES_GCM.equals(origCCM.getContentCryptoScheme())) && 
        (cryptoConfig.getCryptoMode() == CryptoMode.EncryptionOnly)) {
        throw new SecurityException("Lowering the protection of encryption material is not allowed");
      }
      securityCheck(origCCM, wrapped);
      
      EncryptionMaterials newKEK = req.getEncryptionMaterials();
      ContentCryptoMaterial newCCM;
      ContentCryptoMaterial newCCM;
      if (newKEK == null) {
        newCCM = origCCM.recreate(req.getMaterialsDescription(), kekMaterialsProvider, cryptoScheme, cryptoConfig, kms, req);
      } else {
        newCCM = origCCM.recreate(newKEK, kekMaterialsProvider, cryptoScheme, cryptoConfig, kms, req);
      }
      PutObjectRequest putInstFileRequest = req.createPutObjectRequest(retrieved);
      
      return s3.putObject(updateInstructionPutRequest(putInstFileRequest, newCCM));
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
  
  private ContentCryptoMaterial contentCryptoMaterialOf(S3ObjectWrapper s3w)
  {
    if (s3w.hasEncryptionInfo()) {
      return 
        ContentCryptoMaterial.fromObjectMetadata(s3w.getObjectMetadata(), kekMaterialsProvider, cryptoConfig
        
        .getCryptoProvider(), cryptoConfig
        .getAlwaysUseCryptoProvider(), false, kms);
    }
    S3ObjectWrapper orig_ifile = fetchInstructionFile(s3w.getS3ObjectId(), null);
    if (orig_ifile == null) {
      throw new IllegalArgumentException("S3 object is not encrypted: " + s3w);
    }
    String json = orig_ifile.toJsonString();
    return ccmFromJson(json);
  }
  
  private ContentCryptoMaterial ccmFromJson(String json)
  {
    Map<String, String> instruction = Collections.unmodifiableMap(
      (Map)Jackson.fromJsonString(json, Map.class));
    return ContentCryptoMaterial.fromInstructionFile(instruction, kekMaterialsProvider, cryptoConfig
    
      .getCryptoProvider(), cryptoConfig
      .getAlwaysUseCryptoProvider(), false, kms);
  }
  
  final GetObjectRequest createInstructionGetRequest(S3ObjectId id)
  {
    return createInstructionGetRequest(id, null);
  }
  
  final GetObjectRequest createInstructionGetRequest(S3ObjectId s3objectId, String instFileSuffix)
  {
    return new GetObjectRequest(s3objectId
      .instructionFileId(instFileSuffix));
  }
  
  static long[] getAdjustedCryptoRange(long[] range)
  {
    if ((range == null) || (range[0] > range[1])) {
      return null;
    }
    long[] adjustedCryptoRange = new long[2];
    adjustedCryptoRange[0] = getCipherBlockLowerBound(range[0]);
    adjustedCryptoRange[1] = getCipherBlockUpperBound(range[1]);
    return adjustedCryptoRange;
  }
  
  private static long getCipherBlockLowerBound(long leftmostBytePosition)
  {
    long cipherBlockSize = 16L;
    long offset = leftmostBytePosition % cipherBlockSize;
    long lowerBound = leftmostBytePosition - offset - cipherBlockSize;
    return lowerBound < 0L ? 0L : lowerBound;
  }
  
  private static long getCipherBlockUpperBound(long rightmostBytePosition)
  {
    long cipherBlockSize = 16L;
    long offset = cipherBlockSize - rightmostBytePosition % cipherBlockSize;
    long upperBound = rightmostBytePosition + offset + cipherBlockSize;
    return upperBound < 0L ? Long.MAX_VALUE : upperBound;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */