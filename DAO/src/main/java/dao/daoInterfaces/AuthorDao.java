package dao.daoInterfaces;

import com.models.entity.Author;
import com.models.entity.Project;
import com.models.entity.ProjectPart;

import java.util.List;

public interface AuthorDao {

    public Author getAuthorById(Integer authorId);
    public List<Author> getAuthorsByProjectPart_Project(Project project);
    public List<Author> getAuthorsByProjectPart(ProjectPart projectPart);
}
