function getKarateConfig() {
  // get environment from the system property 'karate.env'
  var env = karate.env || 'local';
  karate.log('karate environment is:', env);

  // Read environment-dependant settings
  var config = read('classpath:env-settings-'+env+'.yml');
  karate.log("Environment settings: " + config);

  // Generic configuration
  karate.configure('logPrettyRequest', true);
  karate.configure('logPrettyResponse', true);
  karate.configure('connectTimeout', 10000);
  karate.configure('readTimeout', 10000);

  return config;
}
