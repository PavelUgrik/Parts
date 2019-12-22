package testTask.parts.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import testTask.parts.entities.Part;
import testTask.parts.services.PartsService;

import java.util.List;

@Controller
public class PartsController {
    private PartsService partsService;

    @Autowired
    public void setPartsService(PartsService partsService) {
        this.partsService = partsService;
    }

    @GetMapping(value = "/")
    public ModelAndView parts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "all") String sort) {
        List<Part> partList = partsService.allParts(page, sort);
        int partsCount = partsService.partsCount();
        int pageCount = (partsCount + 9) / 10;
        int numberOfComputers = partsService.numberOfComputers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("parts");
        modelAndView.addObject("PartList", partList);
        modelAndView.addObject("NumberOfComputers", numberOfComputers);
        modelAndView.addObject("pageCount", pageCount);
        return modelAndView;
    }
}
