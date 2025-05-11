package ko.java.presentChoice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchService {

    public List<String> searchResultList() {
        List<String> list = new ArrayList<String>();
        list = Arrays.asList("선택된 리스트 내용","선택된 것");
        return list;
    }
}
