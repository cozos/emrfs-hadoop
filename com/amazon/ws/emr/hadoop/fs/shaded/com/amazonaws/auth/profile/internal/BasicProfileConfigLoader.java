package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

@SdkInternalApi
public class BasicProfileConfigLoader
{
  private static final Log LOG = LogFactory.getLog(BasicProfileConfigLoader.class);
  public static final BasicProfileConfigLoader INSTANCE = new BasicProfileConfigLoader();
  
  public AllProfiles loadProfiles(File file)
  {
    if (file == null) {
      throw new IllegalArgumentException("Unable to load AWS profiles: specified file is null.");
    }
    if ((!file.exists()) || (!file.isFile())) {
      throw new IllegalArgumentException("AWS credential profiles file not found in the given path: " + file.getAbsolutePath());
    }
    FileInputStream fis = null;
    try
    {
      fis = new FileInputStream(file);
      return loadProfiles(fis);
    }
    catch (IOException ioe)
    {
      throw new SdkClientException("Unable to load AWS credential profiles file at: " + file.getAbsolutePath(), ioe);
    }
    finally
    {
      if (fis != null) {
        try
        {
          fis.close();
        }
        catch (IOException localIOException2) {}
      }
    }
  }
  
  private AllProfiles loadProfiles(InputStream is)
    throws IOException
  {
    ProfilesConfigFileLoaderHelper helper = new ProfilesConfigFileLoaderHelper(null);
    
    Map<String, Map<String, String>> allProfileProperties = helper.parseProfileProperties(new Scanner(is, StringUtils.UTF8.name()));
    
    Map<String, BasicProfile> profilesByName = new LinkedHashMap();
    for (Map.Entry<String, Map<String, String>> entry : allProfileProperties.entrySet())
    {
      String profileName = (String)entry.getKey();
      Map<String, String> properties = (Map)entry.getValue();
      if (profileName.startsWith("profile ")) {
        LOG.warn("Your profile name includes a 'profile ' prefix. This is considered part of the profile name in the Java SDK, so you will need to include this prefix in your profile name when you reference this profile from your Java code.");
      }
      assertParameterNotEmpty(profileName, "Unable to load properties from profile: Profile name is empty.");
      
      profilesByName.put(profileName, new BasicProfile(profileName, properties));
    }
    return new AllProfiles(profilesByName);
  }
  
  private void assertParameterNotEmpty(String parameterValue, String errorMessage)
  {
    if (StringUtils.isNullOrEmpty(parameterValue)) {
      throw new SdkClientException(errorMessage);
    }
  }
  
  private static class ProfilesConfigFileLoaderHelper
    extends AbstractProfilesConfigFileScanner
  {
    protected final Map<String, Map<String, String>> allProfileProperties = new LinkedHashMap();
    
    public Map<String, Map<String, String>> parseProfileProperties(Scanner scanner)
    {
      allProfileProperties.clear();
      run(scanner);
      return new LinkedHashMap(allProfileProperties);
    }
    
    protected void onEmptyOrCommentLine(String profileName, String line) {}
    
    protected void onProfileStartingLine(String newProfileName, String line)
    {
      allProfileProperties.put(newProfileName, new HashMap());
    }
    
    protected void onProfileEndingLine(String prevProfileName) {}
    
    protected void onProfileProperty(String profileName, String propertyKey, String propertyValue, boolean isSupportedProperty, String line)
    {
      Map<String, String> properties = (Map)allProfileProperties.get(profileName);
      if (properties.containsKey(propertyKey)) {
        throw new IllegalArgumentException("Duplicate property values for [" + propertyKey + "].");
      }
      properties.put(propertyKey, propertyValue);
    }
    
    protected void onEndOfFile() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfileConfigLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */