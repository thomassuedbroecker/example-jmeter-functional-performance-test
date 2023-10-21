log.info("*******************************************")
log.info("*** 2. Load environment configuration ******")
log.info("*******************************************")

String username_env = System.getenv("_USERNAME")
String password_env = System.getenv("_PASSWORD")

log.info("*** Set JMeter variables")
vars.put("username", username_env )
vars.put("password", password_env)

String username = vars.get('username')
String password = vars.get('password')
log.info("*** Show local variables values")
log.info(username)
log.info(password)

log.info("*** Create base64 encoding")
def auth = username + ":" + password
auth_encoded = auth.bytes.encodeBase64().toString()
vars.put("auth_encoded",auth_encoded);
props.put("auth_encoded",auth_encoded);
log.info("*** Show encoding result")
log.info(auth)
log.info(auth_encoded)