package dao.repositories;

import com.models.entity.Author;
import com.models.entity.Project;
import com.models.entity.ProjectPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author getAuthorById(Integer authorId);
    List<Author> getAuthorsByProjectPart_Project(Project project);
    List<Author> getAuthorsByProjectPart(ProjectPart projectPart);
}
