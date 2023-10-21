log.info("******************************************")
log.info("** 3.Load environment configuration ******")
log.info("******************************************")

String endpoint_env = System.getenv("_ENDPOINT");
String api_path_env = System.getenv("_API_PATH");
String port_env = System.getenv("_PORT");
String protocol_env = System.getenv("_PROTOCOL");

vars.put("endpoint", endpoint_env );
vars.put("api_path", api_path_env );
props.put("endpoint",endpoint_env);
props.put("api_path",api_path_env);
vars.put("port", port_env );
props.put("port", port_env);
vars.put("protocol", protocol_env );
props.put("protocol", protocol_env);

String endpoint= vars.get('endpoint')
String api_path= vars.get('api_path')
String port= vars.get('port')
String protocol= vars.get('protocol')

log.info("*** Show local variables values")
log.info(endpoint)
log.info(api_path)
log.info(port)
log.info(protocol)