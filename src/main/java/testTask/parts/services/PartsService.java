package testTask.parts.services;

import testTask.parts.entities.Part;

import java.util.List;


public interface PartsService {
    List<Part> allParts(int page);
    int partsCount();
    int numberOfComputers();
}
