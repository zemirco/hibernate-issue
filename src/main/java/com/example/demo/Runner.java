package com.example.demo;

import com.example.demo.Maintainer.Maintainer;
import com.example.demo.NpmPackage.NpmPackage;
import com.example.demo.NpmPackage.NpmPackageRepository;
import com.example.demo.NpmPackageVersion.NpmPackageVersion;
import com.example.demo.Registry.RegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class Runner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

  @Autowired private RegistryService registryService;

  @Autowired private NpmPackageRepository npmPackageRepository;

  @Override
  public void run(String... args) throws Exception {
    var pkg = registryService.get("json2csv");
    logger.info("pkg: {}", pkg.maintainers());

    var npmPackage = new NpmPackage();
    npmPackage.setName(pkg.name());

    var versions = pkg.versions();
    if (versions != null) {
      versions.forEach(
          (version, value) -> {
            // logger.info("value: {}", value.maintainers());

            var npmPackageVersion = new NpmPackageVersion();
            npmPackageVersion.setVersion(version);
            npmPackageVersion.setDescription(value.description());
            npmPackageVersion.setHomepage(value.homepage());
            if (value.maintainers() != null) {
              value
                  .maintainers()
                  .forEach(
                      dto -> {
                        var maintainer = new Maintainer();
                        maintainer.setEmail(dto.email());
                        maintainer.setName(dto.name());
                        maintainer.setUrl(dto.url());
                        npmPackageVersion.addMaintainer(maintainer);
                      });
            }

            npmPackage.addVersion(npmPackageVersion);
          });
    }

    npmPackageRepository.save(npmPackage);
  }
}
