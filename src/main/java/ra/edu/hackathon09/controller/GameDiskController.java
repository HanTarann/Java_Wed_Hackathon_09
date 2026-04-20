package ra.edu.hackathon09.controller;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.edu.hackathon09.model.dto.GameDiskDTO;
import ra.edu.hackathon09.model.entity.GameDisk;
import ra.edu.hackathon09.service.GameDiskService;

import java.util.List;


@Controller;
@RequestMapping("/gamedisk")
public class GameDiskController {

        @Autowired
        private GameDiskService service;

        @Autowired
        private ServletContext servletContext;

        @GetMapping
        public String list(@RequestParam(value = "keyword", required = false) String keyword,
                           @RequestParam(value = "position", required = false) String position,
                           Model model) {

            List<GameDisk> members;

            if ((keyword != null && !keyword.isEmpty()) ||
                    (position != null && !position.isEmpty())) {

                members = this.service.search(keyword, position);
            } else {
                members = this.service.findAll();
            }

            model.addAttribute("members", members);
            model.addAttribute("keyword", keyword);
            model.addAttribute("position", position);

            return "gamedisk-list";
        }

        @GetMapping("/create")
        public String createForm(Model model) {
            model.addAttribute("memberDTO", new GameDiskDTO());
            return "member-form";
        }

        @PostMapping("/save")
        public String save(@Valid @ModelAttribute("memberDTO") GameDiskDTO dto, BindingResult result) {
            if (result.hasErrors()) {
                return "member-form";
            }

            GameDisk gameDisk = new GameDisk();

            gameDisk.setTitle(dto.getTitle());
            gameDisk.setGenre(dto.getGenre());
            gameDisk.setQuantity(dto.getQuantity());

            return "redirect:/gamedisk";
        }

        @GetMapping("/edit/{id}")
        public String edit(@PathVariable("id") Long id, Model model) {

            GameDisk gameDisk = this.service.findById(id);

            GameDiskDTO dto = new GameDiskDTO();

            dto.setId(gameDisk.getId());
            dto.setTitle(gameDisk.getTitle());
            dto.setQuantity(gameDisk.getQuantity());;

            model.addAttribute("gamediskDTO", dto);
            return "gamedisk-form";
        }

        @PostMapping("/update")
        public String update(@Valid @ModelAttribute("memberDTO") GameDiskDTO dto, BindingResult result) {

            if (result.hasErrors()) {
                return "member-form";
            }

            GameDisk gameDisk = this.service.findById(dto.getId());

            return "redirect:/gamedisk";
        }

        @GetMapping("/delete/{id}")
        public String delete(@PathVariable("id") Long id) {
            this.service.delete(id);
            return "redirect:/gamedisk";
        }
    }
}
