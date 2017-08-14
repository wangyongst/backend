package myweb.dao.jpa.hibernate;

import myweb.pojo.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Test.class, idClass = Integer.class)
public interface TestRepository extends JpaRepository<Test,Integer> {

    public List<Test> findByLessonAndTestOrderByOrdAsc(int lesson, int test);

    public List<Test> findByIdAndYes(int id, int yes);

}