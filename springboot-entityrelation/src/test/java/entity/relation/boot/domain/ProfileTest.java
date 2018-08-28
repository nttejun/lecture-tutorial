package entity.relation.boot.domain;

import entity.relation.boot.repository.MemberRepository;
import entity.relation.boot.repository.ProfileRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class ProfileTest {

    @Autowired
    MemberRepository memberRepo;

    @Autowired
    ProfileRepository profileRepo;

    // 회원 데이터 추가
    @Test
    public void testInsertMember(){
        IntStream.range(1, 101).forEach(i -> {
            Member member = new Member();
            member.setUid("user"+i);
            member.setUpw("pw"+i);
            member.setUname("사용자"+i);
            memberRepo.save(member);
        });
    }

    // TBL_MEMBER 테이블의 uid 컬럼을 참조하는 TBL_PROFILE 테이블의 member_uid 컬럼/데이터 추가
    @Test
    public void testInsertProfile(){
        Member member = new Member();
        member.setUid("user1");

        for(int i=1; i<5; i++){
            Profile profile = new Profile();
            profile.setFname("face"+i+".jpg");

            if(i == 1){
                profile.setCurrent(true);
            }

            profile.setMember(member);

            profileRepo.save(profile);
        }
    }

}