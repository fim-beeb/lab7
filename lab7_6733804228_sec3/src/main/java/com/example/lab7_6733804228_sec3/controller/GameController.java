package com.example.lab7_6733804228_sec3.controller;

import com.example.lab7_6733804228_sec3.model.Game;
import com.example.lab7_6733804228_sec3.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public String message(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("game", new Game());
        return "add";
    }

    @PostMapping("/save")
    public String games(@ModelAttribute("game") Game game, RedirectAttributes redirectAttributes){
        gameRepository.save(game);
        redirectAttributes.addFlashAttribute("message","บันทึกข้อมูลเกมเรียบร้อยแล้ว!");
        return "redirect:/games";
    }

    @PostMapping("/update/{id}")
    public String updateGame(@PathVariable("id") long id, @ModelAttribute("game") Game game, RedirectAttributes redirectAttributes){
        game.setId(id);
        gameRepository.save(game);
        redirectAttributes.addFlashAttribute("message", "อัปเดตข้อมูลเกมเรียบร้อยแล้ว!");
        return "redirect:/games";

    }

    @GetMapping("/delete/{id}")
    public String showDeleteFrom(@PathVariable("id") long id, Model model){
        Game game = gameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid game id:"+id));
        model.addAttribute("game", game);
        return "delete";
    }

    @PostMapping("delete/{id}")
    public String deleteGame(@PathVariable("id") long id, RedirectAttributes redirectAttributes){
        gameRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "ลบข้อมูลเกมเรียบร้อยแล้ว!");
        return "redirect:/games";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model){
        Game game = gameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid game id:"+id));
        model.addAttribute("game", game);
        return "edit";
    }

//    @PostMapping("/edit/{id}")
//    public String editGame(@PathVariable("id") long id , @ModelAttribute("game") Game game,RedirectAttributes redirectAttributes){
//        game.setId(id);
//        gameRepository.save(game);
//        redirectAttributes.addFlashAttribute("message", "อัปเดตข้อมูลเกมเรียบร้อยแล้ว!");
//        return "redirect:/games";
//    }

}
