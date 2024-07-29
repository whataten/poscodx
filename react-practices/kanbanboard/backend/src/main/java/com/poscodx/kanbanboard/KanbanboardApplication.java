package com.poscodx.kanbanboard;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.script_runner;
import org.apache.ibatis.session.sql_session_factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.application_arguments;
import org.springframework.boot.application_runner;
import org.springframework.boot.spring_application;
import org.springframework.boot.autoconfigure.spring_boot_application;
import org.springframework.context.annotation.Bean;

@spring_boot_application
public class kanbanboard_application {

	public static void main(String[] args) {
		spring_application.run(kanbanboard_application.class, args);
	}
	
	@Bean
	public application_runner script_runner() {
		return new application_runner() {
			@Autowired
			private sql_session_factory sql_session_factory;
			
			@Override
			public void run(application_arguments args) throws Exception {
				script_runner script_runner = new script_runner(sql_session_factory.get_configuration().get_environment().get_data_source().get_connection());
				script_runner.run_script(Resources.get_resource_as_reader("sql/db-setup.sql"));
			}
		};
	}
}
