package io.redutan.springboot.inaction.book;

import io.redutan.springboot.inaction.AmazonProperties;
import io.redutan.springboot.inaction.reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {
    private final ReadingListRepository readingListRepository;
    private final AmazonProperties amazonProperties;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties amazonProperties) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readerBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        model.addAttribute("books", readingList);
        model.addAttribute("reader", reader);
        model.addAttribute("amazonId", amazonProperties.getAssociateId());
        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
