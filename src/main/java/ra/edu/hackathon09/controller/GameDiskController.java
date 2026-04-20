package ra.edu.hackathon09.controller;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.edu.hackathon09.model.dto.GameDiskDTO;
import ra.edu.hackathon09.model.entity.GameDisk;
import ra.edu.hackathon09.service.GameDiskService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/games")
public class GameDiskController {
    @Autowired
    private GameDiskService service;

    @Autowired
    private ServletContext servletContext;

    @GetMapping
    public String list(@RequestParam(name = "title", required = false) String title, @RequestParam(name = "genre", required = false) String genre, Model model) {
        List<GameDisk> games;

        if ((title != null && !title.isEmpty()) || (genre != null && !genre.isEmpty())) {
            games = this.service.search(title, genre);
        } else {
            games = this.service.findAll();
        }

        model.addAttribute("games", games);
        model.addAttribute("title", title);
        model.addAttribute("genre", genre);

        return "gamedisk-list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("gameDTO", new GameDiskDTO());
        return "gamedisk-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("gameDTO") GameDiskDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "gamedisk-form";
        }
        GameDisk game = new GameDisk();

        game.setTitle(dto.getTitle());
        game.setGenre(dto.getGenre());
        game.setQuantity(dto.getQuantity());

        MultipartFile file = dto.getCoverImage();

        if (file != null && !file.isEmpty()) {
            String path = servletContext.getRealPath("/uploads");
            File folder = new File(path);
            if (!folder.exists()) folder.mkdirs();

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            try {
                file.transferTo(new File(path + File.separator + fileName));
                game.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        service.save(game);
        return "redirect:/games";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        GameDisk game = service.findById(id);

        if (game == null) {
            return "redirect:/games";
        }

        GameDiskDTO dto = new GameDiskDTO();
        dto.setId(game.getId());
        dto.setTitle(game.getTitle());
        dto.setGenre(game.getGenre());
        dto.setQuantity(game.getQuantity());

        model.addAttribute("gameDTO", dto);
        return "gamedisk-form";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("gameDTO") GameDiskDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return "gamedisk-form";
        }

        GameDisk game = service.findById(dto.getId());

        if (game == null) {
            return "redirect:/games";
        }

        game.setTitle(dto.getTitle());
        game.setGenre(dto.getGenre());
        game.setQuantity(dto.getQuantity());

        MultipartFile file = dto.getCoverImage();

        if (file != null && !file.isEmpty()) {
            String path = servletContext.getRealPath("/uploads");
            File folder = new File(path);
            if (!folder.exists()) folder.mkdirs();

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            try {
                file.transferTo(new File(path + File.separator + fileName));
                game.setImage(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        service.update(game);
        return "redirect:/games";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        service.delete(id);
        return "redirect:/games";
    }
}