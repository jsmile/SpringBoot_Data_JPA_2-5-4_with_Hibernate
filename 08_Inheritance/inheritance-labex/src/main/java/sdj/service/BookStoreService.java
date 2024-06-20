package sdj.service;

import sdj.repository.BookRepository;
import sdj.entity.Book;
import sdj.entity.Paperback;
import sdj.entity.Ebook;
import sdj.repository.EbookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdj.repository.PaperbackRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookStoreService {

	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
    private EbookRepository ebookRepository;
	
	@Autowired
    private PaperbackRepository paperbackRepository;

	@Transactional
    public void persistBooks() {
    	Book book = new Book();
        book.setIsbn("001-SDJ");
        book.setTitle("Core");

        Ebook ebook = new Ebook();
        ebook.setIsbn("002-SDJ");
        ebook.setTitle("The Good Parts");
        ebook.setFormat("kindle");
        
        Paperback paperback = new Paperback();
        paperback.setIsbn("003-SDJ");
        paperback.setTitle("Best Practices");
        paperback.setSize("4 x 1 x 6");
        paperback.setWeight("2");

        bookRepository.save(book);
        ebookRepository.save(ebook);
        paperbackRepository.save(paperback);        
    }

}
