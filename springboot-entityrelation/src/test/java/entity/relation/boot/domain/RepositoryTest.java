package entity.relation.boot.domain;

import entity.relation.boot.repository.MemberRepository;
import entity.relation.boot.repository.ProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(RepositoryTest.class);

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Test
    public void createMember(){

        logger.info(" ");
        logger.info("### START CREATE MEMBER");
        Member member = new Member();
        member.setUid("아이디0");
        member.setUpw("비번0");
        member.setUname("이름0");
        memberRepository.save(member);

        logger.info("### END CREATE MEMBER");
        logger.info(" ");

    }

    @Test
    public void createProfile(){

        logger.info(" ");
        logger.info("### START CREATE Profile");

        Profile profile = new Profile();
        profile.setFno(1L);
        profile.setFname("프로필0");
        profile.setCurrent(false);
        profile.getMember();
        profileRepository.save(profile);

        logger.info("### END CREATE Profile");
        logger.info(" ");

    }

}