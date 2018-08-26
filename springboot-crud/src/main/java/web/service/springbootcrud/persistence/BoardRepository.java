package web.service.springbootcrud.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.service.springbootcrud.vo.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

}
