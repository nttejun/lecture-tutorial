package entity.relation.boot.repository;

import entity.relation.boot.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String>{
}
