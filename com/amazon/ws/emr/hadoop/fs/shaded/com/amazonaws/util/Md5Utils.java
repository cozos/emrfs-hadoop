package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils
{
  private static final int SIXTEEN_K = 16384;
  
  public static byte[] computeMD5Hash(InputStream is)
    throws IOException
  {
    BufferedInputStream bis = new BufferedInputStream(is);
    try
    {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      byte[] buffer = new byte['䀀'];
      int bytesRead;
      while ((bytesRead = bis.read(buffer, 0, buffer.length)) != -1) {
        messageDigest.update(buffer, 0, bytesRead);
      }
      return messageDigest.digest();
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new IllegalStateException(e);
    }
    finally
    {
      try
      {
        bis.close();
      }
      catch (Exception e)
      {
        LogFactory.getLog(Md5Utils.class).debug("Unable to close input stream of hash candidate: " + e);
      }
    }
  }
  
  public static String md5AsBase64(InputStream is)
    throws IOException
  {
    return Base64.encodeAsString(computeMD5Hash(is));
  }
  
  public static byte[] computeMD5Hash(byte[] input)
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      return md.digest(input);
    }
    catch (NoSuchAlgorithmException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static String md5AsBase64(byte[] input)
  {
    return Base64.encodeAsString(computeMD5Hash(input));
  }
  
  public static byte[] computeMD5Hash(File file)
    throws FileNotFoundException, IOException
  {
    return computeMD5Hash(new FileInputStream(file));
  }
  
  public static String md5AsBase64(File file)
    throws FileNotFoundException, IOException
  {
    return Base64.encodeAsString(computeMD5Hash(file));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Md5Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */