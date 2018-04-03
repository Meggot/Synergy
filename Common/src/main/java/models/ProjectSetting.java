package models;

import javax.persistence.*;

@Entity
@Table(name="Project_Settings")
public class ProjectSetting extends EntityObject {
    @Column(name="pk_setting_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @OneToOne
    @JoinColumn(name="fk_project_id")
    private Project project;
    @Column(name="key")
    private String key;
    @Column(name="value")
    private String value;

    public ProjectSetting(final Project project, final String key, final String value) {
        super();
        this.project = project;
        this.key = key;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(final Project project) {
        this.project = project;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ProjectSetting that = (ProjectSetting) o;

        if (id != that.id) return false;
        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
