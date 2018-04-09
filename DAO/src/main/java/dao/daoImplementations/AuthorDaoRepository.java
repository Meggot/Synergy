package dao.daoImplementations;

import com.models.entity.Author;
import com.models.entity.Project;
import com.models.entity.ProjectPart;
import dao.daoInterfaces.AuthorDao;
import dao.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorDaoRepository implements AuthorDao{
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author getAuthorById(final Integer authorId) {
        return authorRepository.getAuthorById(authorId);
    }

    @Override
    public List<Author> getAuthorsByProjectPart_Project(final Project project) {
        return authorRepository.getAuthorsByProjectPart_Project(project);
    }

    @Override
    public List<Author> getAuthorsByProjectPart(final ProjectPart projectPart) {
        return authorRepository.getAuthorsByProjectPart(projectPart);
    }
}
