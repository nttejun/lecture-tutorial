package web.service.springbootcrud.persistence;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import web.service.springbootcrud.vo.Board;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(BoardRepositoryTest.class);

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void classInfo() {

        //객체의 실제 이름
        Class<?> cls = boardRepository.getClass();
        System.out.println(cls);

        //클래스가 구현하고 있는 인터페이스 목록
        Class<?>[] interfaces = cls.getInterfaces();
        Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));

        //클래스의 부모 클래스
        Class<?> superClasses = cls.getSuperclass();
        System.out.println(superClasses.getName());

    }
    @Test
    public void insertBoardTest(){

        logger.info(" ");
        logger.info("### BOARD ENTITY INSERT TEST START");

        Board board = new Board();
        board.setTitle("게시물제목01");
        board.setContent("게시물 내용보기01...");
        board.setWriter("user01");

        boardRepository.save(board);

        logger.info("### BOARD ENTITY INSERT TEST END >> " + board);
        logger.info(" ");

    }

    @Test
    public void readBoardTest(){

        logger.info(" ");
        logger.info("### BOARD ENTITY READ TEST START");

        boardRepository.findById(1L).ifPresent((board)->{

            logger.info("### BOARD ENTITY READ TEST END >> " + board);
            logger.info(" ");

        });
    }

    @Test
    public void uptBoardTest(){

        logger.info(" ");
        logger.info("### BOARD ENTITY UPDATE TEST START");

        Board board = boardRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("FAILED FIND BOARD"));

        board.setContent("수정된 파일...");

        logger.info("### Call Save()");
        boardRepository.save(board);

        logger.info("### BOARD ENTITY UPDATE TEST END >> " + board);
        logger.info(" ");
    }

    @Test
    public void deleteBoardTest(){

        logger.info(" ");
        logger.info("### BOARD ENTITY DELETE TEST START");

        boardRepository.deleteById(7L);

        logger.info("### BOARD ENTITY DELETE TEST END");
        logger.info(" ");


    }
}
