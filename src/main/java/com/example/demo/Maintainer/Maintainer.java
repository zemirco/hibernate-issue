package com.example.demo.Maintainer;

import com.example.demo.NpmPackageVersion.NpmPackageVersion;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.NaturalId;

@Entity
public class Maintainer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @NaturalId private String email;

  private String url;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "maintainers")
  private Set<NpmPackageVersion> npmPackageVersions = new HashSet<>();

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Maintainer other = (Maintainer) obj;
    return Objects.equals(email, other.email);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Set<NpmPackageVersion> getNpmPackageVersions() {
    return npmPackageVersions;
  }

  public void setNpmPackageVersions(Set<NpmPackageVersion> npmPackageVersions) {
    this.npmPackageVersions = npmPackageVersions;
  }
}
