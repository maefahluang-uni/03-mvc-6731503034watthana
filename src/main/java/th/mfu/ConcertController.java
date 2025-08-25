package th.mfu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConcertController {

    private Map<Integer, Concert> concerts = new HashMap<>();
    private int nextId = 1;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/concerts")
    public String listConcerts(Model model) {
        model.addAttribute("concerts", concerts.values());
        return "list-concert"; // ไปที่ concert-list.html
    }

    @GetMapping("/add-concert")
    public String addAConcertForm(Model model) {
        model.addAttribute("concert", new Concert());
        return "add-concert"; // ไปที่ add-concert.html
    }

    @PostMapping("/concerts")
    public String saveConcert(@ModelAttribute Concert concert) {
        concert.setId(nextId++);
        concerts.put(concert.getId(), concert);
        return "redirect:/concerts";
    }

    @GetMapping("/delete-concert/{id}")
    public String deleteConcert(@PathVariable int id) {
        concerts.remove(id);
        return "redirect:/concerts";
    }

    @GetMapping("/delete-concert")
    public String removeAllConcerts() {
        concerts.clear();
        nextId = 1;
        return "redirect:/concerts";
    }
}
