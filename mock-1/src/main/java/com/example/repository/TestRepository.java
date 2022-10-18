package com.example.repository;

import com.example.model.People;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TestRepository {
    public List<People> getPeoples() {
        List<People> peoples = Arrays.asList(new People(1,"zs"), new People(2,"ls"));
        return peoples;
    }
}
