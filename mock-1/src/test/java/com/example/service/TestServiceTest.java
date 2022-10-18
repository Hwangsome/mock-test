package com.example.service;


import com.example.model.People;
import com.example.repository.TestRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestServiceTest {

    @Mock
    private TestRepository testRepository;

    /**
     * TestService 依赖TestRepository
     * 当TestRepository 使用@Mock 时，TestService 上使用@InjectMocks的时候
     * 会将TestRepository 注入到TestService
     */
    @InjectMocks
    private TestService testService;

    @Test
    public void test1(){
        when(testRepository.getPeoples()).thenReturn(buildGetPeopleResponse());
        List<People> peoples = testService.getPeoples();
        assertEquals(peoples.size(), 2);
        verify(testRepository,times(1)).getPeoples();
    }

    private List<People> buildGetPeopleResponse(){
     return Arrays.asList(new People(5, "aa"), new People(6, "bb"));
    }
}
