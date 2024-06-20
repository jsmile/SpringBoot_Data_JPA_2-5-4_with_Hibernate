package sdj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Book;
import sdj.entity.Ebook;
import sdj.entity.Paperback;
import sdj.repository.BookRepository;
import sdj.repository.EbookRepository;
import sdj.repository.PaperbackRepository;

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
        Ebook ebook = new Ebook();
        ebook.setIsbn("002-SDJ");
        ebook.setTitle("The Good Parts");
        ebook.setFormat("kindle");
        
        Paperback paperback = new Paperback();
        paperback.setIsbn("003-SDJ");
        paperback.setTitle("Best Practices");
        paperback.setSize("4 x 1 x 6");
        paperback.setWeight("2");

        ebookRepository.save(ebook);
        paperbackRepository.save(paperback); 
    }
	
	@Transactional(readOnly = true)
    public void findAnEbook() {		
        Ebook ebook = ebookRepository.findById(1L).get();
        System.out.println(ebook);
    }
	
	@Transactional(readOnly = true)
    public void findAllBooks() {		
		List<Book> books = bookRepository.findAll(); //throws exception
        System.out.println(books);
    }

}
