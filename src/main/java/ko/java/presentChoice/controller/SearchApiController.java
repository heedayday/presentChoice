package ko.java.presentChoice.controller;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;


@Controller
@RequestMapping("/search")
public class SearchApiController {

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;

    private static final Logger logger = LoggerFactory.getLogger(SearchApiController.class);

    @PostMapping("/searchResultList.ajax")
    @ResponseBody
    public List<String> getSearchResultList(@RequestBody Map<String,Object> paramMap, Model model) {
        String searchInputText = (String) paramMap.get("searchInputText");
        List<String> selectedCategories = (List<String>) paramMap.get("selectedCategories");
        model.addAttribute("searchInputText", searchInputText);
        model.addAttribute("selectedCategories", selectedCategories);
        System.out.println("검색어: " + searchInputText);
        System.out.println("카테고리: " + selectedCategories);

        logger.info("API 호출::: 입력한 검색어:{}, 선택한 카테고리: {}", searchInputText,selectedCategories.toString());
        SearchApiController();
        logger.info("API 호출끝 :::");
        try{
            if(StringUtils.isBlank(searchInputText)) {
                throw new IllegalArgumentException("검색어 입력값이 필요합니다.");
            }
            return selectedCategories;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void SearchApiController() {

        Map<String,String> clientInfoList = getClient();

        String clientId = clientInfoList.get("clientId"); //애플리케이션 클라이언트 아이디
        String clientSecret = clientInfoList.get("clientSecret"); //애플리케이션 클라이언트 시크릿


        String text = null;
        try {
            text = URLEncoder.encode("그린팩토리", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);


        System.out.println(responseBody);
    }

    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }

    private static Map<String, String> getClient(){
        Properties props = new Properties();
        Map<String, String> clientInfoList = new HashMap<>();
        try (InputStream input = new FileInputStream("application.properties")) {
            props.load(input);
            clientInfoList.put("client_id", props.getProperty("client_id"));
            clientInfoList.put("client_secret", props.getProperty("client_secret"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientInfoList;
    }
}
