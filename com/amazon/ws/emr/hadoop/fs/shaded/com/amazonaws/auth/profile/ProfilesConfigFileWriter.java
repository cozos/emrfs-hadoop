package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AbstractProfilesConfigFileScanner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.Profile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class ProfilesConfigFileWriter
{
  private static final Log LOG = LogFactory.getLog(ProfilesConfigFileWriter.class);
  
  public static void dumpToFile(File destination, boolean overwrite, Profile... profiles)
  {
    if ((destination.exists()) && (!overwrite)) {
      throw new SdkClientException("The destination file already exists. Set overwrite=true if you want to clobber the existing content and completely re-write the file.");
    }
    try
    {
      writer = new OutputStreamWriter(new FileOutputStream(destination, false), StringUtils.UTF8);
    }
    catch (IOException ioe)
    {
      OutputStreamWriter writer;
      throw new SdkClientException("Unable to open the destination file.", ioe);
    }
    try
    {
      OutputStreamWriter writer;
      Map<String, Profile> modifications = new LinkedHashMap();
      for (Profile profile : profiles) {
        modifications.put(profile.getProfileName(), profile);
      }
      ProfilesConfigFileWriterHelper writerHelper = new ProfilesConfigFileWriterHelper(writer, modifications);
      
      writerHelper.writeWithoutExistingContent(); return;
    }
    finally
    {
      try
      {
        writer.close();
      }
      catch (IOException localIOException2) {}
    }
  }
  
  public static void modifyOrInsertProfiles(File destination, Profile... profiles)
  {
    Map<String, Profile> modifications = new LinkedHashMap();
    for (Profile profile : profiles) {
      modifications.put(profile.getProfileName(), profile);
    }
    modifyProfiles(destination, modifications);
  }
  
  public static void modifyOneProfile(File destination, String profileName, Profile newProfile)
  {
    Map<String, Profile> modifications = Collections.singletonMap(profileName, newProfile);
    
    modifyProfiles(destination, modifications);
  }
  
  public static void deleteProfiles(File destination, String... profileNames)
  {
    Map<String, Profile> modifications = new LinkedHashMap();
    for (String profileName : profileNames) {
      modifications.put(profileName, null);
    }
    modifyProfiles(destination, modifications);
  }
  
  static void modifyProfiles(File destination, Map<String, Profile> modifications)
  {
    boolean inPlaceModify = destination.exists();
    File stashLocation = null;
    if (inPlaceModify)
    {
      boolean stashed = false;
      try
      {
        stashLocation = new File(destination.getParentFile(), destination.getName() + ".bak." + UUID.randomUUID().toString());
        stashed = destination.renameTo(stashLocation);
        if (LOG.isDebugEnabled()) {
          LOG.debug(
            String.format("The original credentials file is stashed to location (%s).", new Object[] {stashLocation
            .getAbsolutePath() }));
        }
      }
      finally
      {
        if (!stashed) {
          throw new SdkClientException("Failed to stash the existing credentials file before applying the changes.");
        }
      }
    }
    OutputStreamWriter writer = null;
    try
    {
      writer = new OutputStreamWriter(new FileOutputStream(destination), StringUtils.UTF8);
      ProfilesConfigFileWriterHelper writerHelper = new ProfilesConfigFileWriterHelper(writer, modifications);
      if (inPlaceModify)
      {
        Scanner existingContent = new Scanner(stashLocation, StringUtils.UTF8.name());
        writerHelper.writeWithExistingContent(existingContent);
      }
      else
      {
        writerHelper.writeWithoutExistingContent();
      }
      new ProfilesConfigFile(destination);
      if ((inPlaceModify) && (!stashLocation.delete()) && 
        (LOG.isDebugEnabled())) {
        LOG.debug(
          String.format("Successfully modified the credentials file. But failed to delete the stashed copy of the original file (%s).", new Object[] {stashLocation
          
          .getAbsolutePath() }));
      }
      boolean restored;
      return;
    }
    catch (Exception e)
    {
      if (inPlaceModify)
      {
        restored = false;
        try
        {
          if (!destination.delete()) {
            LOG.debug("Unable to remove the credentials file before restoring the original one.");
          }
          restored = stashLocation.renameTo(destination);
        }
        finally
        {
          if (!restored) {
            throw new SdkClientException("Unable to restore the original credentials file. File content stashed in " + stashLocation.getAbsolutePath());
          }
        }
      }
      throw new SdkClientException("Unable to modify the credentials file. (The original file has been restored.)", e);
    }
    finally
    {
      try
      {
        if (writer != null) {
          writer.close();
        }
      }
      catch (IOException localIOException1) {}
    }
  }
  
  private static class ProfilesConfigFileWriterHelper
    extends AbstractProfilesConfigFileScanner
  {
    private final Writer writer;
    private final Map<String, Profile> newProfiles = new LinkedHashMap();
    private final Set<String> deletedProfiles = new HashSet();
    private final StringBuilder buffer = new StringBuilder();
    private final Map<String, Set<String>> existingProfileProperties = new HashMap();
    
    public ProfilesConfigFileWriterHelper(Writer writer, Map<String, Profile> modifications)
    {
      this.writer = writer;
      for (Map.Entry<String, Profile> entry : modifications.entrySet())
      {
        String profileName = (String)entry.getKey();
        Profile profile = (Profile)entry.getValue();
        if (profile == null) {
          deletedProfiles.add(profileName);
        } else {
          newProfiles.put(profileName, profile);
        }
      }
    }
    
    public void writeWithoutExistingContent()
    {
      buffer.setLength(0);
      existingProfileProperties.clear();
      
      run(new Scanner(""));
    }
    
    public void writeWithExistingContent(Scanner existingContent)
    {
      buffer.setLength(0);
      existingProfileProperties.clear();
      
      run(existingContent);
    }
    
    protected void onEmptyOrCommentLine(String profileName, String line)
    {
      if ((profileName == null) || (!deletedProfiles.contains(profileName))) {
        buffer(line);
      }
    }
    
    protected void onProfileStartingLine(String profileName, String line)
    {
      existingProfileProperties.put(profileName, new HashSet());
      
      flush();
      if (deletedProfiles.contains(profileName)) {
        return;
      }
      if (newProfiles.get(profileName) != null)
      {
        String newProfileName = ((Profile)newProfiles.get(profileName)).getProfileName();
        if (!newProfileName.equals(profileName)) {
          line = "[" + newProfileName + "]";
        }
      }
      writeLine(line);
    }
    
    protected void onProfileEndingLine(String prevProfileName)
    {
      Profile modifiedProfile = (Profile)newProfiles.get(prevProfileName);
      if (modifiedProfile != null) {
        for (Map.Entry<String, String> entry : modifiedProfile.getProperties().entrySet())
        {
          String propertyKey = (String)entry.getKey();
          String propertyValue = (String)entry.getValue();
          if (!((Set)existingProfileProperties.get(prevProfileName)).contains(propertyKey)) {
            writeProperty(propertyKey, propertyValue);
          }
        }
      }
      flush();
    }
    
    protected void onProfileProperty(String profileName, String propertyKey, String propertyValue, boolean isSupportedProperty, String line)
    {
      if (existingProfileProperties.get(profileName) == null) {
        existingProfileProperties.put(profileName, new HashSet());
      }
      ((Set)existingProfileProperties.get(profileName)).add(propertyKey);
      if (deletedProfiles.contains(profileName)) {
        return;
      }
      if (!isSupportedProperty)
      {
        writeLine(line);
        return;
      }
      flush();
      if (newProfiles.containsKey(profileName))
      {
        String newValue = ((Profile)newProfiles.get(profileName)).getPropertyValue(propertyKey);
        if (newValue != null) {
          writeProperty(propertyKey, newValue);
        }
      }
      else
      {
        writeLine(line);
      }
    }
    
    protected void onEndOfFile()
    {
      for (Map.Entry<String, Profile> entry : newProfiles.entrySet())
      {
        String profileName = (String)entry.getKey();
        Profile profile = (Profile)entry.getValue();
        if (!existingProfileProperties.containsKey(profileName))
        {
          writeProfile(profile);
          writeLine("");
        }
      }
      try
      {
        writer.flush();
      }
      catch (IOException ioe)
      {
        throw new SdkClientException("Unable to write to the target file to persist the profile credentials.", ioe);
      }
    }
    
    protected boolean isSupportedProperty(String propertyName)
    {
      return ("aws_access_key_id".equals(propertyName)) || 
        ("aws_secret_access_key".equals(propertyName)) || 
        ("aws_session_token".equals(propertyName)) || 
        ("external_id".equals(propertyName)) || 
        ("role_arn".equals(propertyName)) || 
        ("role_session_name".equals(propertyName)) || 
        ("source_profile".equals(propertyName));
    }
    
    private void writeProfile(Profile profile)
    {
      writeProfileName(profile.getProfileName());
      for (Map.Entry<String, String> entry : profile.getProperties().entrySet()) {
        writeProperty((String)entry.getKey(), (String)entry.getValue());
      }
    }
    
    private void writeProfileName(String profileName)
    {
      writeLine(String.format("[%s]", new Object[] { profileName }));
    }
    
    private void writeProperty(String propertyKey, String propertyValue)
    {
      writeLine(String.format("%s=%s", new Object[] { propertyKey, propertyValue }));
    }
    
    private void writeLine(String line)
    {
      append(String.format("%s%n", new Object[] { line }));
    }
    
    private void append(String str)
    {
      try
      {
        writer.append(str);
      }
      catch (IOException ioe)
      {
        throw new SdkClientException("Unable to write to the target file to persist the profile credentials.", ioe);
      }
    }
    
    private void flush()
    {
      if (buffer.length() != 0)
      {
        append(buffer.toString());
        buffer.setLength(0);
      }
    }
    
    private void buffer(String line)
    {
      buffer.append(String.format("%s%n", new Object[] { line }));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.ProfilesConfigFileWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */