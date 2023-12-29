package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.LessonEdit.LessonEdit;
import com.easy.learn.dto.LessonEdit.LessonEditDTO;
import com.easy.learn.dto.LessonEdit.LessonEdit;
import com.easy.learn.dto.LessonEdit.LessonEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class LessonEditService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;


    public List<LessonEdit> getAllLessonEdit() {
        String url = apiHostUrl + ApiPath.LESSON_EDIT_GET_ALL;
        HttpHeaders headers = new HttpHeaders();


        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<LessonEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<LessonEditDTO>() {});

        LessonEditDTO lessonEditDTO = responseEntity.getBody();

        return  lessonEditDTO.getList();
    }
    public LessonEdit getLessonEditById(Long id) {
        String url = apiHostUrl + ApiPath.LESSON_EDIT_GET_ONE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<LessonEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<LessonEditDTO>() {});

        LessonEditDTO lessonEditDTO = responseEntity.getBody();

        return  lessonEditDTO.getData();
    }
    public LessonEdit createLessonEdit(LessonEditDTO dto) {
        String url = apiHostUrl + ApiPath.LESSON_EDIT_CREATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LessonEditDTO> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<LessonEdit> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                LessonEdit.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public LessonEdit updateLessonEdit(LessonEditDTO dto) {
        String url = apiHostUrl + ApiPath.LESSON_EDIT_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LessonEditDTO> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<LessonEdit> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                LessonEdit.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle the error case
            // You might want to throw an exception or return null, depending on your use case
            return null;
        }
    }

    public boolean deleteLessonEdit(Long id) {
        String url = apiHostUrl + ApiPath.LESSON_EDIT_DELETE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                entity,
                Void.class
        );

        return responseEntity.getStatusCode() == HttpStatus.OK;
    }


    public LessonEdit saveOrUpdateLessonEdit(LessonEditDTO dto) {
        String url = apiHostUrl + ApiPath.LESSON_EDIT_SAVE_OR_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LessonEditDTO> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<LessonEdit> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                LessonEdit.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
}
