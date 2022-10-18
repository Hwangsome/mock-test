package com.example.service;

import com.example.model.People;
import org.springframework.stereotype.Service;

import java.util.List;
public interface TestApi {
    List<People> getPeoples();
}
