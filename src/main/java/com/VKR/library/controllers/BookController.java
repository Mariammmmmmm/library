package com.VKR.library.controllers;

import com.VKR.library.models.Book;
import com.VKR.library.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public String bookMain(Model model){
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-main";
    }

    @GetMapping("/book/add")
    public String bookAdd(Model model){
        return "book-add";
    }

    @PostMapping("/book/add")
    public String bookDataAdd(@RequestParam String title,@RequestParam String description,
                              @RequestParam String binding, @RequestParam String subject, Model model){
        Book book = new Book(title, description, binding, subject);
        bookRepository.save(book);
        return "redirect:/book";
    }

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(value = "id") long id, Model model){
        if (!bookRepository.existsById(id)){
            return "redirect:/book";
        }

        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res =new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book-details";
    }

    @GetMapping("/book/{id}/edit")
    public String bookEdit(@PathVariable(value = "id") long id, Model model){
        if (!bookRepository.existsById(id)){
            return "redirect:/book";
        }

        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res =new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book-edit";
    }

    @PostMapping("/book/{id}/edit")
    public String bookUpdate(@PathVariable(value = "id") long id,
                             @RequestParam String title,@RequestParam String description,
                              @RequestParam String binding, @RequestParam String subject, Model model){
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setDescription(description);
        book.setBinding(binding);
        book.setSubject(subject);
        bookRepository.save(book);
        return "redirect:/book";
    }

    @PostMapping("/book/{id}/remove")
    public String bookDelete(@PathVariable(value = "id") long id, Model model){
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return "redirect:/book";
    }

}
