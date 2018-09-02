package jpql.boot;

import jpql.boot.entity.Board;
import jpql.boot.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

	private Logger logger = LoggerFactory.getLogger(BootApplicationTests.class);

	@Autowired
	private BoardRepository boardRepo;

	@Test
	public void insert200(){
		for(int i = 0; i <= 200; i++){
			Board board = new Board();
			board.setTitle("제목 ..."+i);
			board.setContent("내용 ..."+i+ " 채우기");
			board.setWriter("user0" + (i % 10));
			boardRepo.save(board);
		}
	}

	@Test
	public void findByTitle(){
		boardRepo.findBoardByTitle("제목...177")
				.forEach(board -> logger.info("### START BY TITLE " + board));
	}

	@Test
	public void findByWriter(){
		Collection<Board> results = boardRepo.findByWriter("user00");
		results.forEach(
				board -> logger.info("### START BY WRITER " + board)
		);
	}

	@Test
	public void writerContaining(){
		Collection<Board> result = boardRepo.findByWriterContaining("05");
		result.forEach(board -> System.out.println(board));
	}

	@Test
	public void writerContainingOrTitleContainingLike(){
		Collection<Board> result = boardRepo.findByWriterContainingOrTitleContaining("05", "%2%");
		result.forEach(board -> System.out.println(board));
	}

	@Test
	public void titleAndBno(){
		Collection<Board> result = boardRepo.findByTitleContainingAndBnoGreaterThan("5",50L);
		result.forEach(board -> System.out.println(board));
	}

	@Test
	public void bnoGreaterThanOrderByBnoDesc(){
		Collection<Board> result = boardRepo.findByBnoGreaterThanOrderByBnoDesc(90L);
		result.forEach(board -> System.out.println(board));
	}

	@Test
	public void bnoGreaterThanOrderByBnoDescPaging(){
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "bno");
		Collection<Board> result = boardRepo.findByBnoGreaterThanOrderByBnoDesc(0L, paging);
		result.forEach(board -> System.out.println(board));
	}

	@Test
	public void bnoPagingSort(){
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "bno");
		Page<Board> result = boardRepo.findByBnoGreaterThan(0L, paging);
		System.out.println("PAGE SiZE: " + result.getSize());
		System.out.println("TOTAL PAGES: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());

		// 다음 페이지는 어떻게 ?
		List<Board> list = result.getContent();
		list.forEach(board -> System.out.println(board));
	}

	@Test
	public void findByTitleQuery(){
		boardRepo.findByTitle("17")
				.forEach(board -> System.out.println(board));
	}

}
