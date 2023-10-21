import groovy.json.*;
import groovy.csv.*;
import java.nio.file.Files;
import java.nio.file.Paths;

log.info("*************************************")
log.info("***** 6. Write custom CSV file ******")
log.info("*************************************")

// get properies and variables
String loop_counter = vars.get('loop_counter')
String question = props.get('question')
String answer = props.get('answer')
String status = props.get('status')
String responsecode = props.get('responsecode')
String results_csv_path_env = props.get('results_csv_path_env');

log.info(results_csv_path_env)
log.info(loop_counter)
log.info(status)
log.info(question)
log.info(answer)
log.info(responsecode)

answer = answer.replaceAll("\"","'");
question = question.replaceAll("\"","'");

// Create csv output file
FileWriter fstream = new FileWriter(results_csv_path_env ,true);
BufferedWriter out = new BufferedWriter(fstream);

String w_question = '"' + question + '"'
String w_answer = '"' + answer + '"'
String w_loop_counter = '"' + loop_counter + '"'
String w_status = '"' + status + '"'
String w_responsecode = '"' + responsecode + '"'

out.write(w_loop_counter);
out.write(",");
out.write(w_responsecode);
out.write(",");
out.write(w_status);
out.write(",");
out.write(w_question);
out.write(",");
out.write(w_answer);
out.newLine();
out.flush();

// reset properies
props.put('question','unknown')
props.put('answer','unknown')
props.put('status','unknown')
props.put('responsecode','unknown')