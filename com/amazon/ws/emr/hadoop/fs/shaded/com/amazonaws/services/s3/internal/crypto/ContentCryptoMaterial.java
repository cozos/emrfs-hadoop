package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.KeyWrapException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CryptoMode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ExtraMaterialsDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.KMSEncryptionMaterials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MaterialsDescriptionProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BinaryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.KeyPair;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

final class ContentCryptoMaterial
{
  private final String keyWrappingAlgorithm;
  private final CipherLite cipherLite;
  private final Map<String, String> kekMaterialsDescription;
  private final byte[] encryptedCEK;
  
  ContentCryptoMaterial(Map<String, String> kekMaterialsDescription, byte[] encryptedCEK, String keyWrappingAlgorithm, CipherLite cipherLite)
  {
    this.cipherLite = cipherLite;
    this.keyWrappingAlgorithm = keyWrappingAlgorithm;
    this.encryptedCEK = ((byte[])encryptedCEK.clone());
    this.kekMaterialsDescription = kekMaterialsDescription;
  }
  
  String getKeyWrappingAlgorithm()
  {
    return keyWrappingAlgorithm;
  }
  
  private boolean usesKMSKey()
  {
    return KMSSecuredCEK.isKMSKeyWrapped(keyWrappingAlgorithm);
  }
  
  ContentCryptoScheme getContentCryptoScheme()
  {
    return cipherLite.getContentCryptoScheme();
  }
  
  ObjectMetadata toObjectMetadata(ObjectMetadata metadata, CryptoMode mode)
  {
    return (mode == CryptoMode.EncryptionOnly) && (!usesKMSKey()) ? 
      toObjectMetadataEO(metadata) : 
      toObjectMetadata(metadata);
  }
  
  private ObjectMetadata toObjectMetadata(ObjectMetadata metadata)
  {
    byte[] encryptedCEK = getEncryptedCEK();
    metadata.addUserMetadata("x-amz-key-v2", 
      Base64.encodeAsString(encryptedCEK));
    
    byte[] iv = cipherLite.getIV();
    metadata.addUserMetadata("x-amz-iv", Base64.encodeAsString(iv));
    
    metadata.addUserMetadata("x-amz-matdesc", 
      kekMaterialDescAsJson());
    
    ContentCryptoScheme scheme = getContentCryptoScheme();
    metadata.addUserMetadata("x-amz-cek-alg", scheme
      .getCipherAlgorithm());
    int tagLen = scheme.getTagLengthInBits();
    if (tagLen > 0) {
      metadata.addUserMetadata("x-amz-tag-len", 
        String.valueOf(tagLen));
    }
    String keyWrapAlgo = getKeyWrappingAlgorithm();
    if (keyWrapAlgo != null) {
      metadata.addUserMetadata("x-amz-wrap-alg", keyWrapAlgo);
    }
    return metadata;
  }
  
  private ObjectMetadata toObjectMetadataEO(ObjectMetadata metadata)
  {
    byte[] encryptedCEK = getEncryptedCEK();
    metadata.addUserMetadata("x-amz-key", 
      Base64.encodeAsString(encryptedCEK));
    
    byte[] iv = cipherLite.getIV();
    metadata.addUserMetadata("x-amz-iv", Base64.encodeAsString(iv));
    
    metadata.addUserMetadata("x-amz-matdesc", 
      kekMaterialDescAsJson());
    return metadata;
  }
  
  String toJsonString(CryptoMode mode)
  {
    return (mode == CryptoMode.EncryptionOnly) && (!usesKMSKey()) ? 
      toJsonStringEO() : toJsonString();
  }
  
  private String toJsonString()
  {
    Map<String, String> map = new HashMap();
    byte[] encryptedCEK = getEncryptedCEK();
    map.put("x-amz-key-v2", Base64.encodeAsString(encryptedCEK));
    byte[] iv = cipherLite.getIV();
    map.put("x-amz-iv", Base64.encodeAsString(iv));
    map.put("x-amz-matdesc", kekMaterialDescAsJson());
    
    ContentCryptoScheme scheme = getContentCryptoScheme();
    map.put("x-amz-cek-alg", scheme.getCipherAlgorithm());
    int tagLen = scheme.getTagLengthInBits();
    if (tagLen > 0) {
      map.put("x-amz-tag-len", String.valueOf(tagLen));
    }
    String keyWrapAlgo = getKeyWrappingAlgorithm();
    if (keyWrapAlgo != null) {
      map.put("x-amz-wrap-alg", keyWrapAlgo);
    }
    return Jackson.toJsonString(map);
  }
  
  private String toJsonStringEO()
  {
    Map<String, String> map = new HashMap();
    byte[] encryptedCEK = getEncryptedCEK();
    map.put("x-amz-key", Base64.encodeAsString(encryptedCEK));
    byte[] iv = cipherLite.getIV();
    map.put("x-amz-iv", Base64.encodeAsString(iv));
    map.put("x-amz-matdesc", kekMaterialDescAsJson());
    return Jackson.toJsonString(map);
  }
  
  private String kekMaterialDescAsJson()
  {
    Map<String, String> kekMaterialDesc = getKEKMaterialsDescription();
    if (kekMaterialDesc == null) {
      kekMaterialDesc = Collections.emptyMap();
    }
    return Jackson.toJsonString(kekMaterialDesc);
  }
  
  private static Map<String, String> matdescFromJson(String json)
  {
    Map<String, String> map = (Map)Jackson.fromJsonString(json, Map.class);
    return map == null ? null : Collections.unmodifiableMap(map);
  }
  
  private static SecretKey cek(byte[] cekSecured, String keyWrapAlgo, EncryptionMaterials materials, Provider securityProvider, ContentCryptoScheme contentCryptoScheme, AWSKMS kms)
  {
    if (KMSSecuredCEK.isKMSKeyWrapped(keyWrapAlgo)) {
      return cekByKMS(cekSecured, keyWrapAlgo, materials, contentCryptoScheme, kms);
    }
    Key kek;
    if (materials.getKeyPair() != null)
    {
      Key kek = materials.getKeyPair().getPrivate();
      if (kek == null) {
        throw new SdkClientException("Key encrypting key not available");
      }
    }
    else
    {
      kek = materials.getSymmetricKey();
      if (kek == null) {
        throw new SdkClientException("Key encrypting key not available");
      }
    }
    try
    {
      if (keyWrapAlgo != null)
      {
        Cipher cipher = securityProvider == null ? Cipher.getInstance(keyWrapAlgo) : Cipher.getInstance(keyWrapAlgo, securityProvider);
        
        cipher.init(4, kek);
        return (SecretKey)cipher.unwrap(cekSecured, keyWrapAlgo, 3);
      }
      Cipher cipher;
      Cipher cipher;
      if (securityProvider != null) {
        cipher = Cipher.getInstance(kek.getAlgorithm(), securityProvider);
      } else {
        cipher = Cipher.getInstance(kek.getAlgorithm());
      }
      cipher.init(2, kek);
      byte[] decryptedSymmetricKeyBytes = cipher.doFinal(cekSecured);
      return new SecretKeySpec(decryptedSymmetricKeyBytes, "AES");
    }
    catch (Exception e)
    {
      throw Throwables.failure(e, "Unable to decrypt symmetric key from object metadata");
    }
  }
  
  private static SecretKey cekByKMS(byte[] cekSecured, String keyWrapAlgo, EncryptionMaterials materials, ContentCryptoScheme contentCryptoScheme, AWSKMS kms)
  {
    DecryptRequest kmsreq = new DecryptRequest().withEncryptionContext(materials.getMaterialsDescription()).withCiphertextBlob(ByteBuffer.wrap(cekSecured));
    DecryptResult result = kms.decrypt(kmsreq);
    return new SecretKeySpec(BinaryUtils.copyAllBytesFrom(result.getPlaintext()), contentCryptoScheme
      .getKeyGeneratorAlgorithm());
  }
  
  static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata metadata, EncryptionMaterialsAccessor kekMaterialAccessor, Provider securityProvider, boolean alwaysUseSecurityProvider, boolean keyWrapExpected, AWSKMS kms)
  {
    return fromObjectMetadata0(metadata, kekMaterialAccessor, securityProvider, alwaysUseSecurityProvider, null, ExtraMaterialsDescription.NONE, keyWrapExpected, kms);
  }
  
  static ContentCryptoMaterial fromObjectMetadata(ObjectMetadata metadata, EncryptionMaterialsAccessor kekMaterialAccessor, Provider securityProvider, boolean alwaysUseSecurityProvider, long[] range, ExtraMaterialsDescription extra, boolean keyWrapExpected, AWSKMS kms)
  {
    return fromObjectMetadata0(metadata, kekMaterialAccessor, securityProvider, alwaysUseSecurityProvider, range, extra, keyWrapExpected, kms);
  }
  
  private static ContentCryptoMaterial fromObjectMetadata0(ObjectMetadata metadata, EncryptionMaterialsAccessor kekMaterialAccessor, Provider securityProvider, boolean alwaysUseSecurityProvider, long[] range, ExtraMaterialsDescription extra, boolean keyWrapExpected, AWSKMS kms)
  {
    Map<String, String> userMeta = metadata.getUserMetadata();
    String b64key = (String)userMeta.get("x-amz-key-v2");
    if (b64key == null)
    {
      b64key = (String)userMeta.get("x-amz-key");
      if (b64key == null) {
        throw new SdkClientException("Content encrypting key not found.");
      }
    }
    byte[] cekWrapped = Base64.decode(b64key);
    byte[] iv = Base64.decode((String)userMeta.get("x-amz-iv"));
    if ((cekWrapped == null) || (iv == null)) {
      throw new SdkClientException("Content encrypting key or IV not found.");
    }
    String matdescStr = (String)userMeta.get("x-amz-matdesc");
    String keyWrapAlgo = (String)userMeta.get("x-amz-wrap-alg");
    boolean isKMS = KMSSecuredCEK.isKMSKeyWrapped(keyWrapAlgo);
    Map<String, String> core = matdescFromJson(matdescStr);
    
    Map<String, String> merged = (isKMS) || (extra == null) ? core : extra.mergeInto(core);
    EncryptionMaterials materials;
    if (isKMS)
    {
      EncryptionMaterials materials = new KMSEncryptionMaterials((String)core.get("kms_cmk_id"));
      materials.addDescriptions(core);
    }
    else
    {
      materials = kekMaterialAccessor == null ? null : kekMaterialAccessor.getEncryptionMaterials(merged);
      if (materials == null) {
        throw new SdkClientException("Unable to retrieve the client encryption materials");
      }
    }
    String cekAlgo = (String)userMeta.get("x-amz-cek-alg");
    boolean isRangeGet = range != null;
    
    ContentCryptoScheme contentCryptoScheme = ContentCryptoScheme.fromCEKAlgo(cekAlgo, isRangeGet);
    if (isRangeGet)
    {
      iv = contentCryptoScheme.adjustIV(iv, range[0]);
    }
    else
    {
      int tagLenExpected = contentCryptoScheme.getTagLengthInBits();
      if (tagLenExpected > 0)
      {
        String s = (String)userMeta.get("x-amz-tag-len");
        int tagLenActual = Integer.parseInt(s);
        if (tagLenExpected != tagLenActual) {
          throw new SdkClientException("Unsupported tag length: " + tagLenActual + ", expected: " + tagLenExpected);
        }
      }
    }
    if ((keyWrapExpected) && (keyWrapAlgo == null)) {
      throw newKeyWrapException();
    }
    SecretKey cek = cek(cekWrapped, keyWrapAlgo, materials, securityProvider, contentCryptoScheme, kms);
    
    return new ContentCryptoMaterial(merged, cekWrapped, keyWrapAlgo, contentCryptoScheme
      .createCipherLite(cek, iv, 2, securityProvider, alwaysUseSecurityProvider));
  }
  
  private static KeyWrapException newKeyWrapException()
  {
    return new KeyWrapException("Missing key-wrap for the content-encrypting-key");
  }
  
  static ContentCryptoMaterial fromInstructionFile(Map<String, String> instFile, EncryptionMaterialsAccessor kekMaterialAccessor, Provider securityProvider, boolean alwaysUseSecurityProvider, boolean keyWrapExpected, AWSKMS kms)
  {
    return fromInstructionFile0(instFile, kekMaterialAccessor, securityProvider, alwaysUseSecurityProvider, null, ExtraMaterialsDescription.NONE, keyWrapExpected, kms);
  }
  
  static ContentCryptoMaterial fromInstructionFile(Map<String, String> instFile, EncryptionMaterialsAccessor kekMaterialAccessor, Provider securityProvider, boolean alwaysUseSecurityProvider, long[] range, ExtraMaterialsDescription extra, boolean keyWrapExpected, AWSKMS kms)
  {
    return fromInstructionFile0(instFile, kekMaterialAccessor, securityProvider, alwaysUseSecurityProvider, range, extra, keyWrapExpected, kms);
  }
  
  private static ContentCryptoMaterial fromInstructionFile0(Map<String, String> instFile, EncryptionMaterialsAccessor kekMaterialAccessor, Provider securityProvider, boolean alwaysUseSecurityProvider, long[] range, ExtraMaterialsDescription extra, boolean keyWrapExpected, AWSKMS kms)
  {
    String b64key = (String)instFile.get("x-amz-key-v2");
    if (b64key == null)
    {
      b64key = (String)instFile.get("x-amz-key");
      if (b64key == null) {
        throw new SdkClientException("Content encrypting key not found.");
      }
    }
    byte[] cekWrapped = Base64.decode(b64key);
    byte[] iv = Base64.decode((String)instFile.get("x-amz-iv"));
    if ((cekWrapped == null) || (iv == null)) {
      throw new SdkClientException("Necessary encryption info not found in the instruction file " + instFile);
    }
    String keyWrapAlgo = (String)instFile.get("x-amz-wrap-alg");
    boolean isKMS = KMSSecuredCEK.isKMSKeyWrapped(keyWrapAlgo);
    
    String matdescStr = (String)instFile.get("x-amz-matdesc");
    Map<String, String> core = matdescFromJson(matdescStr);
    
    Map<String, String> merged = (extra == null) || (isKMS) ? core : extra.mergeInto(core);
    EncryptionMaterials materials;
    if (isKMS)
    {
      EncryptionMaterials materials = new KMSEncryptionMaterials((String)core.get("kms_cmk_id"));
      materials.addDescriptions(core);
    }
    else
    {
      materials = kekMaterialAccessor == null ? null : kekMaterialAccessor.getEncryptionMaterials(merged);
      if (materials == null) {
        throw new SdkClientException("Unable to retrieve the encryption materials that originally encrypted object corresponding to instruction file " + instFile);
      }
    }
    String cekAlgo = (String)instFile.get("x-amz-cek-alg");
    boolean isRangeGet = range != null;
    
    ContentCryptoScheme contentCryptoScheme = ContentCryptoScheme.fromCEKAlgo(cekAlgo, isRangeGet);
    if (isRangeGet)
    {
      iv = contentCryptoScheme.adjustIV(iv, range[0]);
    }
    else
    {
      int tagLenExpected = contentCryptoScheme.getTagLengthInBits();
      if (tagLenExpected > 0)
      {
        String s = (String)instFile.get("x-amz-tag-len");
        int tagLenActual = Integer.parseInt(s);
        if (tagLenExpected != tagLenActual) {
          throw new SdkClientException("Unsupported tag length: " + tagLenActual + ", expected: " + tagLenExpected);
        }
      }
    }
    if ((keyWrapExpected) && (keyWrapAlgo == null)) {
      throw newKeyWrapException();
    }
    SecretKey cek = cek(cekWrapped, keyWrapAlgo, materials, securityProvider, contentCryptoScheme, kms);
    
    return new ContentCryptoMaterial(merged, cekWrapped, keyWrapAlgo, contentCryptoScheme
      .createCipherLite(cek, iv, 2, securityProvider, alwaysUseSecurityProvider));
  }
  
  static String parseInstructionFile(S3Object instructionFile)
  {
    try
    {
      return convertStreamToString(instructionFile.getObjectContent());
    }
    catch (Exception e)
    {
      throw Throwables.failure(e, "Error parsing JSON instruction file");
    }
  }
  
  private static String convertStreamToString(InputStream inputStream)
    throws IOException
  {
    if (inputStream == null) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8));
      String line;
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line);
      }
    }
    finally
    {
      inputStream.close();
    }
    String line;
    return stringBuilder.toString();
  }
  
  CipherLite getCipherLite()
  {
    return cipherLite;
  }
  
  Map<String, String> getKEKMaterialsDescription()
  {
    return kekMaterialsDescription;
  }
  
  byte[] getEncryptedCEK()
  {
    return (byte[])encryptedCEK.clone();
  }
  
  ContentCryptoMaterial recreate(Map<String, String> newKEKMatDesc, EncryptionMaterialsAccessor accessor, S3CryptoScheme targetScheme, CryptoConfiguration config, AWSKMS kms, AmazonWebServiceRequest req)
  {
    if ((!usesKMSKey()) && (newKEKMatDesc.equals(kekMaterialsDescription))) {
      throw new SecurityException("Material description of the new KEK must differ from the current one");
    }
    EncryptionMaterials origKEK;
    EncryptionMaterials origKEK;
    if (usesKMSKey()) {
      origKEK = new KMSEncryptionMaterials((String)kekMaterialsDescription.get("kms_cmk_id"));
    } else {
      origKEK = accessor.getEncryptionMaterials(kekMaterialsDescription);
    }
    EncryptionMaterials newKEK = accessor.getEncryptionMaterials(newKEKMatDesc);
    if (newKEK == null) {
      throw new SdkClientException("No material available with the description " + newKEKMatDesc + " from the encryption material provider");
    }
    SecretKey cek = cek(encryptedCEK, keyWrappingAlgorithm, origKEK, config.getCryptoProvider(), 
      getContentCryptoScheme(), kms);
    ContentCryptoMaterial output = create(cek, cipherLite.getIV(), newKEK, 
      getContentCryptoScheme(), targetScheme, config, kms, req);
    if (Arrays.equals(encryptedCEK, encryptedCEK)) {
      throw new SecurityException("The new KEK must differ from the original");
    }
    return output;
  }
  
  ContentCryptoMaterial recreate(EncryptionMaterials newKEK, EncryptionMaterialsAccessor accessor, S3CryptoScheme targetScheme, CryptoConfiguration config, AWSKMS kms, AmazonWebServiceRequest req)
  {
    if ((!usesKMSKey()) && 
      (newKEK.getMaterialsDescription().equals(kekMaterialsDescription))) {
      throw new SecurityException("Material description of the new KEK must differ from the current one");
    }
    EncryptionMaterials origKEK;
    EncryptionMaterials origKEK;
    if (usesKMSKey()) {
      origKEK = new KMSEncryptionMaterials((String)kekMaterialsDescription.get("kms_cmk_id"));
    } else {
      origKEK = accessor.getEncryptionMaterials(kekMaterialsDescription);
    }
    SecretKey cek = cek(encryptedCEK, keyWrappingAlgorithm, origKEK, config.getCryptoProvider(), 
      getContentCryptoScheme(), kms);
    
    ContentCryptoMaterial output = create(cek, cipherLite.getIV(), newKEK, 
      getContentCryptoScheme(), targetScheme, config, kms, req);
    if (Arrays.equals(encryptedCEK, encryptedCEK)) {
      throw new SecurityException("The new KEK must differ from the original");
    }
    return output;
  }
  
  static ContentCryptoMaterial create(SecretKey cek, byte[] iv, EncryptionMaterials kekMaterials, ContentCryptoScheme contentCryptoScheme, S3CryptoScheme targetScheme, CryptoConfiguration config, AWSKMS kms, AmazonWebServiceRequest req)
  {
    return doCreate(cek, iv, kekMaterials, contentCryptoScheme, targetScheme, config, kms, req);
  }
  
  static ContentCryptoMaterial create(SecretKey cek, byte[] iv, EncryptionMaterials kekMaterials, S3CryptoScheme scheme, CryptoConfiguration config, AWSKMS kms, AmazonWebServiceRequest req)
  {
    return doCreate(cek, iv, kekMaterials, scheme.getContentCryptoScheme(), scheme, config, kms, req);
  }
  
  private static ContentCryptoMaterial doCreate(SecretKey cek, byte[] iv, EncryptionMaterials kekMaterials, ContentCryptoScheme contentCryptoScheme, S3CryptoScheme targetS3CryptoScheme, CryptoConfiguration config, AWSKMS kms, AmazonWebServiceRequest req)
  {
    SecuredCEK cekSecured = secureCEK(cek, kekMaterials, targetS3CryptoScheme
      .getKeyWrapScheme(), config, kms, req);
    
    return wrap(cek, iv, contentCryptoScheme, config.getCryptoProvider(), config
      .getAlwaysUseCryptoProvider(), cekSecured);
  }
  
  public static ContentCryptoMaterial wrap(SecretKey cek, byte[] iv, ContentCryptoScheme contentCryptoScheme, Provider provider, boolean alwaysUseProvider, SecuredCEK cekSecured)
  {
    return new ContentCryptoMaterial(cekSecured
      .getMaterialDescription(), cekSecured
      .getEncrypted(), cekSecured
      .getKeyWrapAlgorithm(), contentCryptoScheme
      
      .createCipherLite(cek, iv, 1, provider, alwaysUseProvider));
  }
  
  private static SecuredCEK secureCEK(SecretKey cek, EncryptionMaterials materials, S3KeyWrapScheme kwScheme, CryptoConfiguration config, AWSKMS kms, AmazonWebServiceRequest req)
  {
    if (materials.isKMSEnabled())
    {
      Map<String, String> matdesc = mergeMaterialDescriptions(materials, req);
      
      EncryptRequest encryptRequest = new EncryptRequest().withEncryptionContext(matdesc).withKeyId(materials.getCustomerMasterKeyId()).withPlaintext(ByteBuffer.wrap(cek.getEncoded()));
      
      encryptRequest
        .withGeneralProgressListener(req.getGeneralProgressListener())
        .withRequestMetricCollector(req.getRequestMetricCollector());
      
      EncryptResult encryptResult = kms.encrypt(encryptRequest);
      byte[] keyBlob = BinaryUtils.copyAllBytesFrom(encryptResult.getCiphertextBlob());
      return new KMSSecuredCEK(keyBlob, matdesc);
    }
    Map<String, String> matdesc = materials.getMaterialsDescription();
    Key kek;
    Key kek;
    if (materials.getKeyPair() != null) {
      kek = materials.getKeyPair().getPublic();
    } else {
      kek = materials.getSymmetricKey();
    }
    String keyWrapAlgo = kwScheme.getKeyWrapAlgorithm(kek);
    Provider provider = config.getCryptoProvider();
    SecureRandom srand = config.getSecureRandom();
    try
    {
      if (keyWrapAlgo != null)
      {
        Cipher cipher = provider == null ? Cipher.getInstance(keyWrapAlgo) : Cipher.getInstance(keyWrapAlgo, provider);
        
        cipher.init(3, kek, srand);
        return new SecuredCEK(cipher.wrap(cek), keyWrapAlgo, matdesc);
      }
      byte[] toBeEncryptedBytes = cek.getEncoded();
      String algo = kek.getAlgorithm();
      Cipher cipher;
      Cipher cipher;
      if (provider != null) {
        cipher = Cipher.getInstance(algo, provider);
      } else {
        cipher = Cipher.getInstance(algo);
      }
      cipher.init(1, kek);
      return new SecuredCEK(cipher.doFinal(toBeEncryptedBytes), null, matdesc);
    }
    catch (Exception e)
    {
      throw Throwables.failure(e, "Unable to encrypt symmetric key");
    }
  }
  
  static Map<String, String> mergeMaterialDescriptions(EncryptionMaterials materials, AmazonWebServiceRequest req)
  {
    Map<String, String> matdesc = materials.getMaterialsDescription();
    if ((req instanceof MaterialsDescriptionProvider))
    {
      MaterialsDescriptionProvider mdp = (MaterialsDescriptionProvider)req;
      Map<String, String> matdesc_req = mdp.getMaterialsDescription();
      if (matdesc_req != null)
      {
        matdesc = new TreeMap(matdesc);
        matdesc.putAll(matdesc_req);
      }
    }
    return matdesc;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.crypto.ContentCryptoMaterial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */