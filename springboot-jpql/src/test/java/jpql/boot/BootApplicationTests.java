package jpql.boot;

import jpql.boot.entity.Board;
import jpql.boot.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

	private Logger logger = LoggerFactory.getLogger(BootApplicationTests.class);
	@Autowired
	private BoardRepository boardRepo;

	@Test
	public void testInsert200(){
		for(int i = 0; i <= 200; i++){
			Board board = new Board();
			board.setTitle("제목 ..."+i);
			board.setContent("내용 ..."+i+ " 채우기");
			board.setWriter("user0" + (i % 10));
			boardRepo.save(board);
		}
	}

	@Test
	public void testByTitle(){
		boardRepo.findBoardByTitle("제목...177")
				.forEach(board -> logger.info("### START BY TITLE " + board));
	}

	@Test
	public void testByWriter(){
		Collection<Board> results = boardRepo.findByWriter("user00");
		results.forEach(
				board -> logger.info("### START BY WRITER " + board)
		);
	}

}
