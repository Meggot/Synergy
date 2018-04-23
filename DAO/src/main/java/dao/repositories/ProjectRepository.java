package dao.repositories;

import com.models.entity.Account;
import com.models.entity.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.ReportAsSingleViolation;
import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
    Project getProjectById(Integer projectId);
    List<Project> getProjectsByTitle(String title);
    List<Project> getProjectsByOwner(Account owner);
    List<Project> getProjectsByCreationDateBetween(Date from, Date to);
    List<Project> getProjectsSorted(Pageable limit, Sort sort);
}
