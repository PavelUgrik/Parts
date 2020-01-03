package testTask.parts.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testTask.parts.entities.Part;
import testTask.parts.services.PartsService;

import java.util.List;

@Controller
public class PartsController {
    private PartsService partsService;
    private int page;

    @Autowired
    public void setPartsService(PartsService partsService) {
        this.partsService = partsService;
    }

    @GetMapping(value = "/")
    public ModelAndView parts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "all") String sort, @RequestParam(required = false) String query) {
        this.page = page;
        List<Part> partList = partsService.allParts(page, sort, query);
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

    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPart");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addPart(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page=" + this.page);
        partsService.add(part);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id) {
        Part part = partsService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPart");
        modelAndView.addObject("part", part);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editPart(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page=" + this.page);
        partsService.edit(part);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deletePart(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page=" + this.page);
        Part part = partsService.getById(id);
        partsService.delete(part);
        return modelAndView;
    }
}
