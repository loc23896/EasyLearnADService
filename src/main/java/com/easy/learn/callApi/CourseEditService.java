package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.CourseEdit.CourseEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseEditService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;


    public List<CourseEdit> getAllCourseEdit() {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_GET_ALL;
        HttpHeaders headers = new HttpHeaders();


        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CourseEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<CourseEditDTO>() {});

        CourseEditDTO CourseEditDTO = responseEntity.getBody();

        return  CourseEditDTO.getList();
    }
    public CourseEdit getCourseEditById(Long id) {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_GET_ONE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CourseEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<CourseEditDTO>() {});

        CourseEditDTO CourseEditDTO = responseEntity.getBody();

        return  CourseEditDTO.getData();
    }
    public CourseEdit createCourseEdit(CourseEditDTO CourseEditDTO) {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_CREATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CourseEditDTO> entity = new HttpEntity<>(CourseEditDTO, headers);

        ResponseEntity<CourseEdit> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                CourseEdit.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public CourseEdit updateCourseEdit(CourseEditDTO CourseEditDTO) {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CourseEditDTO> entity = new HttpEntity<>(CourseEditDTO, headers);

        ResponseEntity<CourseEdit> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                CourseEdit.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle the error case
            // You might want to throw an exception or return null, depending on your use case
            return null;
        }
    }

    public boolean deleteCourseEdit(Long id) {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_DELETE + "?id=" + id;

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
}
