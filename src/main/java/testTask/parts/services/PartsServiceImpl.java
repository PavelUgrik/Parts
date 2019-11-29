package testTask.parts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public List<Part> allParts(int page) {
        return partsRepository.allParts(page);
    }

//    @Override
//    public int numberOfComputers(List<Part> partList) {
//        int minAmount = Integer.MAX_VALUE;
//        for (Part p : partList) {
//            if (p.isNeeded() && p.getAmount() < minAmount) minAmount = p.getAmount();
//        }
//        return minAmount;
//    }

    @Override
    public int partsCount() {
        return partsRepository.partsCount();
    }

    @Override
    public int numberOfComputers() {
        return partsRepository.numberOfComputers();
    }
}
