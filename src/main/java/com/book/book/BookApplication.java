package com.book.book;

import com.book.book.service.TbBookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.book.book.repository")
@SpringBootApplication(scanBasePackages = "com.book.book")
public class BookApplication implements CommandLineRunner {
	@Autowired
	private TbBookStoreService tbBookStoreService;

    public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception {
		if (args.length > 0) {
			String itemId = args[0];  // 첫 번째 파라미터로 itemId를 가져옴
			tbBookStoreService.fetchAndSaveData(itemId);
		} else {
			System.out.println("itemId 파라미터가 필요합니다.");
		}
	}

}
