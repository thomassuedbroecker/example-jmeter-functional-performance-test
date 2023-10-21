log.info("*******************************************")
log.info("***** 4. Create payload for the request ***")
log.info("*******************************************")
String question = vars.get('question')
props.put('question: ',question)
log.info("Question" + question)

String json_payload = "{\"query\":\"text:" + question + "\"}";
vars.put("json_payload",json_payload);
log.info("*** json payload ******")
log.info(json_payload)