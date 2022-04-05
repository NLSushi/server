package ewha.nlsushi.newsum.repository;

import ewha.nlsushi.newsum.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUserId(String userId);
}
