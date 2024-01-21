package com.example.demo.updaters;

import java.util.List;

public interface IRandomDataClient {
    List<RandomPersonDto> getRandomPeople(int size);
}
