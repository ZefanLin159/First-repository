package com.lzf.controller;

import com.lzf.pojo.Books;
import com.lzf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    //    controller调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //    查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> listBook = bookService.queryAllBook();
        System.out.println("listBook:" + listBook);
        model.addAttribute("listBook", listBook);
        return "allBook";
    }

//    跳转到添加书籍页面

    @RequestMapping("/toAddBook")
    public String toAddPaper(Books books) {

        return "addBook";
    }

    //    添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook = " + books);
        bookService.addBook(books);
        return "redirect:/books/allBook";//重定向
    }

    //    跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(Model model, int id) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbooks", books);
        return "updateBook";
    }

    //     修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook = " + books);
        int i = bookService.updateBook(books);
        if (i > 0) {
            System.out.println("添加成功" + books);
        }
        List<Books> testBook = bookService.queryAllBook();
        for (Books books1 : testBook) {
            System.out.println(books1);
        }
        return "redirect:/books/allBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(Model model, int id, Books books) {
        int i = bookService.deleteBookById(id);
        if (i > 0) {
            System.out.println("删除成功");
        }
//        List<Books> list = bookService.queryAllBook();
//        model.addAttribute("Dbooks",list);

        return "redirect:/books/allBook";
    }

    //    查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = bookService.qureyBookByName(queryBookName);
        List<Books> listBook = new ArrayList<Books>();
        listBook.add(books);
        if (books == null) {
            listBook = bookService.queryAllBook();
            model.addAttribute("error", "未找到");
        }
        model.addAttribute("listBook", listBook);

        return "allBook";
    }
}
