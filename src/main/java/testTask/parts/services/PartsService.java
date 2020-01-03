package testTask.parts.services;

import testTask.parts.entities.Part;

import java.util.List;


public interface PartsService {
//  List<Part> allParts(int page, String sort);
List<Part> allParts(int page, String sort, String query);
    int partsCount();
    int numberOfComputers();
    void add(Part part);
    void edit(Part part);
    void delete(Part part);
    Part getById(int id);
    List<Part> getByName(String query);
}
