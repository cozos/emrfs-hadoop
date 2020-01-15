package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Mimetypes
{
  private static final Log log = LogFactory.getLog(Mimetypes.class);
  public static final String MIMETYPE_XML = "application/xml";
  public static final String MIMETYPE_HTML = "text/html";
  public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
  public static final String MIMETYPE_GZIP = "application/x-gzip";
  private static Mimetypes mimetypes = null;
  private HashMap<String, String> extensionToMimetypeMap = new HashMap();
  
  public static synchronized Mimetypes getInstance()
  {
    if (mimetypes != null) {
      return mimetypes;
    }
    mimetypes = new Mimetypes();
    InputStream is = mimetypes.getClass().getResourceAsStream("/mime.types");
    if (is != null)
    {
      if (log.isDebugEnabled()) {
        log.debug("Loading mime types from file in the classpath: mime.types");
      }
      try
      {
        mimetypes.loadAndReplaceMimetypes(is);
      }
      catch (IOException e)
      {
        if (log.isErrorEnabled()) {
          log.error("Failed to load mime types from file in the classpath: mime.types", e);
        }
      }
      finally
      {
        try
        {
          is.close();
        }
        catch (IOException ex)
        {
          log.debug("", ex);
        }
      }
    }
    if (log.isWarnEnabled()) {
      log.warn("Unable to find 'mime.types' file in classpath");
    }
    return mimetypes;
  }
  
  public void loadAndReplaceMimetypes(InputStream is)
    throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(is, StringUtils.UTF8));
    
    String line = null;
    while ((line = br.readLine()) != null)
    {
      line = line.trim();
      if ((!line.startsWith("#")) && (line.length() != 0))
      {
        StringTokenizer st = new StringTokenizer(line, " \t");
        if (st.countTokens() > 1)
        {
          String mimetype = st.nextToken();
          while (st.hasMoreTokens())
          {
            String extension = st.nextToken();
            extensionToMimetypeMap.put(StringUtils.lowerCase(extension), mimetype);
            if (log.isDebugEnabled()) {
              log.debug("Setting mime type for extension '" + StringUtils.lowerCase(extension) + "' to '" + mimetype + "'");
            }
          }
        }
        else if (log.isDebugEnabled())
        {
          log.debug("Ignoring mimetype with no associated file extensions: '" + line + "'");
        }
      }
    }
  }
  
  public String getMimetype(String fileName)
  {
    int lastPeriodIndex = fileName.lastIndexOf(".");
    if ((lastPeriodIndex > 0) && (lastPeriodIndex + 1 < fileName.length()))
    {
      String ext = StringUtils.lowerCase(fileName.substring(lastPeriodIndex + 1));
      if (extensionToMimetypeMap.keySet().contains(ext))
      {
        String mimetype = (String)extensionToMimetypeMap.get(ext);
        if (log.isDebugEnabled()) {
          log.debug("Recognised extension '" + ext + "', mimetype is: '" + mimetype + "'");
        }
        return mimetype;
      }
      if (log.isDebugEnabled()) {
        log.debug("Extension '" + ext + "' is unrecognized in mime type listing, using default mime type: '" + "application/octet-stream" + "'");
      }
    }
    else if (log.isDebugEnabled())
    {
      log.debug("File name has no extension, mime type cannot be recognised for: " + fileName);
    }
    return "application/octet-stream";
  }
  
  public String getMimetype(File file)
  {
    return getMimetype(file.getName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.Mimetypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */