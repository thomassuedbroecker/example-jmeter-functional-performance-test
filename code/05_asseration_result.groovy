import groovy.json.*;

log.info("**********************************")
log.info("***** 5. JSONContent-Assertion ***")
log.info("**********************************")

String responsecode = prev.getResponseCode();
props.put('responsecode',responsecode)

def response = prev.getResponseDataAsString();  
def json_response = new JsonSlurper().parseText(response);
String document_retrieval_strategy = json_response.retrievalDetails.document_retrieval_strategy;
String assertion_name = "document_retrieval_strategy";
String message = "";
boolean verfication = false;

if (document_retrieval_strategy.equals("llm") && (responsecode == "200")){
	verfication = false;
	AssertionResult.setError(verfication);
	AssertionResult.setFailure(verfication);
	log.info("success")
	String answer = json_response.results[0].text[0];
     props.put('answer',answer)
     props.put('status','success')
} else {
	verfication = true;
	String question = vars.get('question')
	message = "responsecode:\n" + responsecode + "\nquestion:\n" + question + "\nfull json response: \n" + json_response;
	AssertionResult.setFailureMessage(message);
	AssertionResult.setFailure(verfication);
	AssertionResult.setError(verfication)
	log.info("error")
	String answer = message;
     props.put('answer',answer)
     props.put('status','failed')
}