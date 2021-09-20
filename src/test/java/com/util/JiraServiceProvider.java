package com.util;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import TestCases.baseTest;
import io.github.bonigarcia.wdm.HttpClient;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider extends baseTest {

	public JiraClient jira;
	public String project;
	public Issue newInssue;

	public JiraServiceProvider() {
		BasicCredentials creds = new BasicCredentials(jiraUsername, jiraPassword);
		jira = new JiraClient(jiraUrl, creds);
		this.project = Project;
	}

	public void createJiraTicket(String issueType, String Summary, String Description, String Assignee,
			String Priority) {

		try {
			FluentCreate obj_fluentCreate = jira.createIssue(project, issueType);
			obj_fluentCreate.field(Field.SUMMARY, Summary);
			obj_fluentCreate.field(Field.DESCRIPTION, Description);
			obj_fluentCreate.field(Field.ASSIGNEE, Assignee);
			obj_fluentCreate.field(Field.PRIORITY, Priority);
			// obj_fluentCreate.field(Field.ATTACHMENT,
			// TestJiraListener.saveFailureScreenShot(driver));
			newInssue = obj_fluentCreate.execute();
			System.out.println("New Issue created in JIRA with ID : " + newInssue);
		} catch (JiraException e) {
			e.printStackTrace();
		}

	}

	public void addAttachmentToJiraIssue(Issue newInssue, String filePath) throws ClientProtocolException, IOException {
		String pathname = filePath;
		File fileUpload = new File(pathname);

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		String url = "https://pos-demo.atlassian.net" + "/rest/api/3/issue/" + newInssue + "/attachments";
		HttpPost postRequest = new HttpPost(url);

		// BASE64Encoder base=new BASE64Encoder();
		// String encoding = base.encode((jiraUserName+":"+jiraAccessKey).getBytes());
		String encoding = Base64.getEncoder().encodeToString((jiraUsername + ":" + jiraPassword).getBytes());

		postRequest.setHeader("Authorization", "Basic " + encoding);
		postRequest.setHeader("X-Atlassian-Token", "nocheck");

		MultipartEntityBuilder entity = MultipartEntityBuilder.create();
		entity.addPart("file", new FileBody(fileUpload));
		postRequest.setEntity(entity.build());
		HttpResponse response = httpClient.execute(postRequest);
		System.out.println(response.getStatusLine());

		if (response.getStatusLine().toString().contains("200 OK")) {
			System.out.println("Attachment uploaded");
		} else {
			System.out.println("Attachment not uploaded");
		}

	}
}
