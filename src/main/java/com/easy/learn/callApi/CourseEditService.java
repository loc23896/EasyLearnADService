package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.CourseEdit.CourseEditDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
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

        CourseEditDTO courseEditDTO = responseEntity.getBody();

        return  courseEditDTO.getList();
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

        CourseEditDTO courseEditDTO = responseEntity.getBody();

        return  courseEditDTO.getData();
    }
    public CourseEdit createCourseEdit(CourseEditDTO dto) {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_CREATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CourseEditDTO> entity = new HttpEntity<>(dto, headers);

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

    public CourseEdit updateCourseEdit(CourseEditDTO dto) {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CourseEditDTO> entity = new HttpEntity<>(dto, headers);

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

    public CourseEdit saveOrUpdateCourseEdit(CourseEditDTO dto) {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_SAVE_OR_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CourseEditDTO> entity = new HttpEntity<>(dto, headers);

        try {
            ResponseEntity<CourseEdit> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    CourseEdit.class
            );

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            } else {
                log.error("Error while saving or updating CourseEdit. Status code: {}, Response: {}",
                        responseEntity.getStatusCode(), responseEntity.getBody());
                throw new RuntimeException("Failed to save or update CourseEdit");
            }
        } catch (Exception e) {
            log.error("Exception while saving or updating CourseEdit", e);
            throw new RuntimeException("An error occurred while saving or updating CourseEdit", e);
        }
    }

}
