package com.lzf.controller;

import com.lzf.controller.utils.R;
import com.lzf.domain.Book;
import com.lzf.service.IBookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll() {
        return new R(iBookService.list(), true);
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(iBookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(iBookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(iBookService.getById(id), true);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(iBookService.getPage(currentPage, pageSize), true);
    }

}
