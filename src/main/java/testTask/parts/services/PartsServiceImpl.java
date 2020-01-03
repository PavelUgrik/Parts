package testTask.parts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTask.parts.entities.Part;
import testTask.parts.repositories.PartsRepository;

import java.util.List;

@Service
public class PartsServiceImpl implements PartsService {
    private PartsRepository partsRepository;

    @Autowired
    public void setPartsRepository(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    @Override
    public List<Part> allParts(int page, String sort, String query) {
        if (query == null || query.isEmpty()) {
            switch (sort) {
                case "needed":
                    return partsRepository.allPartsSortByNeed(page);
                case "utility":
                    return partsRepository.allPartsSortByUtility(page);
                default:
                    return partsRepository.allParts(page);
            }
        } else {
            return partsRepository.getByName(query);
        }
    }

    @Override
    public int partsCount() {
        return partsRepository.partsCount();
    }

    @Override
    public int numberOfComputers() {
        return partsRepository.numberOfComputers();
    }

    @Override
    public void add(Part part) {
        partsRepository.add(part);
    }

    @Override
    public void edit(Part part) {
        partsRepository.edit(part);
    }

    @Override
    public void delete(Part part) {
        partsRepository.delete(part);
    }

    @Override
    public Part getById(int id) {
        return partsRepository.getById(id);
    }

    @Override
    public List<Part> getByName(String query) {
        return query == null || query.isEmpty() ? partsRepository.allParts(1) : partsRepository.getByName(query);
    }
}
