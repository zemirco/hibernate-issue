package com.example.demo.NpmPackage;

import com.example.demo.NpmPackageVersion.NpmPackageVersion;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NaturalId;

@Entity
public class NpmPackage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NaturalId private String name;

  @OneToMany(mappedBy = "npmPackage", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<NpmPackageVersion> versions = new HashSet<>();

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    NpmPackage other = (NpmPackage) obj;
    return Objects.equals(name, other.name);
  }

  public void addVersion(NpmPackageVersion version) {
    this.versions.add(version);
    version.setNpmPackage(this);
  }

  public void removeVersion(NpmPackageVersion version) {
    this.versions.remove(version);
    version.setNpmPackage(null);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<NpmPackageVersion> getVersions() {
    return versions;
  }

  public void setVersions(Set<NpmPackageVersion> versions) {
    this.versions = versions;
  }
}
