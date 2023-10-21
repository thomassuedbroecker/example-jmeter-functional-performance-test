log.info("*******************************************")
log.info("*** 1. Load environment configuration  ****")
log.info("*******************************************")

log.info("*** Load env variables");
String question_csv_path_env = System.getenv("_QUESTIONS_CSV_PATH");
String results_csv_path_env = System.getenv("_RESULTS_CSV_PATH");

log.info("*** Set JMeter variables");
vars.put("question_csv_path", question_csv_path_env );
props.put("question_csv_path", question_csv_path_env);
vars.put("results_csv_path_env", results_csv_path_env );
props.put("results_csv_path_env", results_csv_path_env);


log.info("*** Show local variable and property values")
log.info(question_csv_path_env)
log.info(results_csv_path_env)
