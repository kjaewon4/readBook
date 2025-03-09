package com.book.book.service;


import com.book.book.dto.TbBookStoreDto;
import com.book.book.dto.TbBookStoreResponseDto;
import com.book.book.entity.TbBookStore;
import com.book.book.repository.TbBookStoreRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringReader;

// API 호출 및 DB 저장 서비스 구현
@Service
@RequiredArgsConstructor
public class TbBookStoreService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final TbBookStoreRepository tbBookStoreRepository;

    @Value("${ttb.key}")  // application.properties에서 ttb.key 값을 가져옴
    private String ttbKey;

    public void fetchAndSaveData(String itemId) throws JAXBException {
//        // API URL 구성
//        String url = UriComponentsBuilder.fromHttpUrl("http://www.aladin.co.kr/ttb/api/ItemOffStoreList.aspx")
//                .queryParam("TTBKey", ttbKey)
//                .queryParam("itemIdType", "ISBN13")
//                .queryParam("ItemId", itemId)
//                .queryParam("output", "xml")
//                .toUriString();
//
//        // API 호출 후 XML 응답을 받아옴
//        String xmlResponse = restTemplate.getForObject(url, String.class);
//
//        // XML 응답을 그대로 출력
//        if (xmlResponse != null) {
//            System.out.println("API 응답 XML:");
//            System.out.println(xmlResponse);
//        } else {
//            System.out.println("API 호출 실패 또는 응답이 없습니다.");
//        }

        String url = UriComponentsBuilder.fromHttpUrl("http://www.aladin.co.kr/ttb/api/ItemOffStoreList.aspx")
                .queryParam("TTBKey", ttbKey)
                .queryParam("itemIdType", "ISBN13") // 10자리랑 13자리로 분기해야 될 듯
                .queryParam("ItemId", itemId)
                .queryParam("output", "xml")
                .toUriString();

        // API 호출 후 XML 응답을 받아옴      GET 형식으로 요청한 결과를 객체로 반환
        String xmlResponse = restTemplate.getForObject(url, String.class);

        if (xmlResponse != null) {
            System.out.println("API 응답 XML:");
            System.out.println(xmlResponse);

            // XML을 DTO로 변환
            TbBookStoreResponseDto apiResponse = parseXml(xmlResponse);

            // 매장 정보 저장
            if (apiResponse.getItemOffStoreList() != null) {
                for (TbBookStoreDto store : apiResponse.getItemOffStoreList()) {
                    TbBookStore tbBookStore = new TbBookStore();
                    tbBookStore.setOffName(store.getOffName());
                    tbBookStore.setLink(store.getLink());
                    tbBookStoreRepository.save(tbBookStore);
                }
            }
        }else{
            System.out.println("API 호출 실패 또는 응답이 없습니다.");

        }
    }

    // JAXB를 이용해 XML을 DTO로 변환
    private TbBookStoreResponseDto parseXml(String xmlResponse) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TbBookStoreResponseDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xmlResponse);
        return (TbBookStoreResponseDto) unmarshaller.unmarshal(reader);
    }

}
