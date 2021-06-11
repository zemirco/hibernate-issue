package com.example.demo.NpmPackageVersion;

import com.example.demo.Maintainer.Maintainer;
import com.example.demo.NpmPackage.NpmPackage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class NpmPackageVersion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonBackReference
  private NpmPackage npmPackage;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<Maintainer> maintainers = new HashSet<>();

  private String version;

  private String description;

  private String homepage;

  @Override
  public int hashCode() {
    return Objects.hash(id, version);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    NpmPackageVersion other = (NpmPackageVersion) obj;
    return Objects.equals(id, other.id) && Objects.equals(version, other.version);
  }

  public void addMaintainer(Maintainer maintainer) {
    this.maintainers.add(maintainer);
    maintainer.getNpmPackageVersions().add(this);
  }

  public void removeMaintainer(Maintainer maintainer) {
    this.maintainers.remove(maintainer);
    maintainer.getNpmPackageVersions().remove(this);
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public NpmPackage getNpmPackage() {
    return npmPackage;
  }

  public void setNpmPackage(NpmPackage npmPackage) {
    this.npmPackage = npmPackage;
  }

  public Set<Maintainer> getMaintainers() {
    return maintainers;
  }

  public void setMaintainers(Set<Maintainer> maintainers) {
    this.maintainers = maintainers;
  }
}
