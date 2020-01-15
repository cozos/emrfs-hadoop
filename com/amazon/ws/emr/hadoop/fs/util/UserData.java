package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EC2MetadataUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UserData
{
  private static final String USER_DATA_LOCAL_FILE_PATH = "/var/aws/emr/userData.json";
  private static final ObjectMapper mapper = new ObjectMapper();
  private static final Logger LOG = LoggerFactory.getLogger(UserData.class);
  private static UserData defaultUserData;
  private final AwsClientConfiguration instanceAwsClientConfiguration;
  
  static
  {
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
  
  UserData(String userDataFilePath)
  {
    Optional<UserData> userData = getUserData(userDataFilePath);
    
    instanceAwsClientConfiguration = (userData.isPresent() ? getinstanceAwsClientConfiguration : null);
  }
  
  @JsonCreator
  UserData(@JsonProperty("instanceAwsClientConfiguration") AwsClientConfiguration instanceAwsClientConfiguration)
  {
    this.instanceAwsClientConfiguration = instanceAwsClientConfiguration;
  }
  
  static UserData ofDefaultResourceLocations()
  {
    if (defaultUserData == null) {
      defaultUserData = new UserData("/var/aws/emr/userData.json");
    }
    return defaultUserData;
  }
  
  private Optional<UserData> getUserData(String userDataFilePath)
  {
    String userDataJson = "";
    try
    {
      File userDataFile = new File(userDataFilePath);
      if (userDataFile.exists()) {
        userDataJson = FileUtils.readFileToString(userDataFile);
      } else {
        userDataJson = EC2MetadataUtils.getUserData();
      }
      return Optional.ofNullable(mapper.readValue(userDataJson, UserData.class));
    }
    catch (JsonParseException|JsonMappingException ex)
    {
      LOG.error("Error parsing user data json: " + userDataJson, ex);
    }
    catch (Exception ex)
    {
      LOG.error("Error encountered while try to get user data", ex);
    }
    return Optional.empty();
  }
  
  Optional<AwsClientConfiguration> getInstanceAwsClientConfiguration()
  {
    return Optional.ofNullable(instanceAwsClientConfiguration);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.UserData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */