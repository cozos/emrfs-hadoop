package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBContext;

public enum Base64
{
  private static final InternalLogApi LOG;
  private static final Base64Codec codec;
  private static final boolean isJaxbAvailable;
  
  static
  {
    LOG = InternalLogFactory.getLog(Base64.class);
    codec = new Base64Codec();
    boolean available;
    try
    {
      Class.forName("javax.xml.bind.DatatypeConverter");
      available = true;
    }
    catch (Exception e)
    {
      boolean available;
      available = false;
    }
    isJaxbAvailable = available;
    if (isJaxbAvailable)
    {
      Map<String, String> inconsistentJaxbImpls = new HashMap();
      inconsistentJaxbImpls.put("org.apache.ws.jaxme.impl.JAXBContextImpl", "Apache JaxMe");
      try
      {
        String className = JAXBContext.newInstance(new Class[0]).getClass().getName();
        if (inconsistentJaxbImpls.containsKey(className)) {
          LOG.warn("A JAXB implementation known to produce base64 encodings that are inconsistent with the reference implementation has been detected. The results of the encodeAsString() method may be incorrect. Implementation: " + 
          
            (String)inconsistentJaxbImpls.get(className));
        }
      }
      catch (Exception localException1) {}catch (NoClassDefFoundError localNoClassDefFoundError) {}
    }
    else
    {
      LOG.warn("JAXB is unavailable. Will fallback to SDK implementation which may be less performant.If you are using Java 9+, you will need to include javax.xml.bind:jaxb-api as a dependency.");
    }
  }
  
  public static String encodeAsString(byte... bytes)
  {
    if (bytes == null) {
      return null;
    }
    if (isJaxbAvailable) {
      try
      {
        return DatatypeConverter.printBase64Binary(bytes);
      }
      catch (NullPointerException ex)
      {
        LOG.debug("Recovering from JAXB bug: https://netbeans.org/bugzilla/show_bug.cgi?id=224923", ex);
      }
    }
    return bytes.length == 0 ? "" : CodecUtils.toStringDirect(codec.encode(bytes));
  }
  
  public static byte[] encode(byte[] bytes)
  {
    return (bytes == null) || (bytes.length == 0) ? bytes : codec.encode(bytes);
  }
  
  public static byte[] decode(String b64)
  {
    if (b64 == null) {
      return null;
    }
    if (b64.length() == 0) {
      return new byte[0];
    }
    byte[] buf = new byte[b64.length()];
    int len = CodecUtils.sanitize(b64, buf);
    return codec.decode(buf, len);
  }
  
  public static byte[] decode(byte[] b64)
  {
    return (b64 == null) || (b64.length == 0) ? b64 : codec.decode(b64, b64.length);
  }
  
  private Base64() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */