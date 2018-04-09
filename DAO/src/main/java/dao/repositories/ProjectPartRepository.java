package dao.repositories;

import com.models.entity.Project;
import com.models.entity.ProjectPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectPartRepository extends JpaRepository<ProjectPart, Integer> {
    ProjectPart getProjectPartById(final Integer id);
    List<ProjectPart> getProjectPartsByProject(final Project project);
}
