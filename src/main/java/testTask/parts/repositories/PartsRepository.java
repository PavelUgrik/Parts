package testTask.parts.repositories;

import testTask.parts.entities.Part;

import java.util.List;


public interface PartsRepository {
    List<Part> allParts(int page);
    List<Part> allPartsSortByNeed(int page);
    List<Part> allPartsSortByUtility(int page);
    int partsCount();
    int numberOfComputers();
}
