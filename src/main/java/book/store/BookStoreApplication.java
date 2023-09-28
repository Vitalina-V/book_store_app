package book.store;

import book.store.model.Book;
import book.store.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book kobzar = new Book();
                kobzar.setTitle("Кобзар");
                kobzar.setAuthor("Т.Г.Шевченко");
                kobzar.setPrice(BigDecimal.valueOf(300));
                kobzar.setDescription("Перша книга-збірка поетичних творів"
                        + " Тараса Шевченка 1840 року");
                kobzar.setIsbn("1222 1211 12121");

                bookService.save(kobzar);
                System.out.println(bookService.findAll());
            }
        };
    }
}


