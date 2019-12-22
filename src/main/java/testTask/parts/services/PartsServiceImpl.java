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

    public List<Part> allParts(int page, String sort) {
        switch (sort) {
            case "needed" : return partsRepository.allPartsSortByNeed(page);
            case "utility" : return partsRepository.allPartsSortByUtility(page);
            default: return partsRepository.allParts(page);
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
}
