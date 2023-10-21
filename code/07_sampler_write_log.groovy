import groovy.json.*;
import groovy.csv.*;
import java.nio.file.Files;
import java.nio.file.Paths;

log.info("*************************************")
log.info("***** 7. Write custom CSV file ******")
log.info("*************************************")

// Don't include sampler result
SampleResult.setIgnore();

// values properies
String loop_counter = vars.get('loop_counter')
String question = vars.get('question')
String answer = ""
String response_type = ""
String responsecode = prev.getResponseCode();
String results_csv_path = props.get('results_csv_path');
String message = "";

if (responsecode == "200") {
	def response = prev.getResponseDataAsString();  
	def json_response = new JsonSlurper().parseText(response);
     String document_retrieval_strategy = json_response.retrievalDetails.document_retrieval_strategy;
     
	if (document_retrieval_strategy.equals("llm")) {
		  answer = json_response.results[0].text[0];	
	} else {				
	       message = "responsecode:\n" + responsecode + "\nquestion:\n" + question + "\nfull json response: \n" + json_response
	       answer = message;
	}
} else {
	message = "responsecode:\n" + responsecode + "\nquestion:\n" + question + "\n doesn't work";
	answer = message;
	log.info("error")
}

log.info(results_csv_path)
log.info(loop_counter)
log.info(question)
log.info(answer)
log.info(responsecode)

answer = answer.replaceAll("\"","'");
question = question.replaceAll("\"","'");

FileWriter fstream = new FileWriter(results_csv_path ,true);
BufferedWriter out = new BufferedWriter(fstream);

String w_question = '"' + question + '"'
String w_answer = '"' + answer + '"'
String w_loop_counter = '"' + loop_counter + '"'
String w_responsecode = '"' + responsecode + '"'

out.write(w_loop_counter);
out.write(",");
out.write(w_responsecode);
out.write(",");
out.write(w_question);
out.write(",");
out.write(w_answer);
out.newLine();
out.flush();

// Set SampleResult
SampleResult.setResponseData("Logfile creation in sampler: Values are written to CSV file: " + results_csv_path);
SampleResult.sampleEnd();
SampleResult.setResponseCode("200");