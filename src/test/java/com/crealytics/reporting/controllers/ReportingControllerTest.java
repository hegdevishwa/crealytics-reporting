package com.crealytics.reporting.controllers;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingControllerTest {


    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();

    private String createURL(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    public void test_getReportByMonthAndSite() throws JSONException {
        HttpEntity entity = new HttpEntity(null, null);
        String url = createURL("/api/v1/reports/January/mobile_web");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,
                String.class);
        System.out.println(response.getBody());
        String expected = "{\n" +
                "\"site\": \"mobile web\",\n" +
                "\"requests\": 9905942,\n" +
                "\"impressions\": 9401153,\n" +
                "\"clicks\": 25291,\n" +
                "\"conversions\": 6216,\n" +
                "\"revenue\": 19053.61,\n" +
                "\"fill_rate\": 94.9,\n" +
                "\"eCPM\": 0.2,\n" +
                "\"month\": \"January\",\n" +
                "\"ctr\": 0.27,\n" +
                "\"cr\": 0.07\n" +
                "}";
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void test_getReportByMonthAndSite_monthAsShortForm() throws JSONException {
        HttpEntity entity = new HttpEntity(null, null);
        String url = createURL("/api/v1/reports/jan/iOS");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,
                String.class);
        System.out.println(response.getBody());
        String expected = "{\n" +
                "\"site\": \"iOS\",\n" +
                "\"requests\": 2550165,\n" +
                "\"impressions\": 2419733,\n" +
                "\"clicks\": 6331,\n" +
                "\"conversions\": 1564,\n" +
                "\"revenue\": 4692.28,\n" +
                "\"fill_rate\": 94.89,\n" +
                "\"eCPM\": 0.19,\n" +
                "\"month\": \"January\",\n" +
                "\"ctr\": 0.26,\n" +
                "\"cr\": 0.06\n" +
                "}";
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void test_getReportByMonthAndSite_monthAsFullForm() throws JSONException {
        HttpEntity entity = new HttpEntity(null, null);
        String url = createURL("/api/v1/reports/February/mobile_web");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,
                String.class);
        System.out.println(response.getBody());
        String expected = "{\n" +
                "\"site\": \"mobile web\",\n" +
                "\"requests\": 8804521,\n" +
                "\"impressions\": 8101153,\n" +
                "\"clicks\": 15365,\n" +
                "\"conversions\": 5267,\n" +
                "\"revenue\": 18053.34,\n" +
                "\"fill_rate\": 92.01,\n" +
                "\"eCPM\": 0.22,\n" +
                "\"month\": \"February\",\n" +
                "\"ctr\": 0.19,\n" +
                "\"cr\": 0.07\n" +
                "}";
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

}