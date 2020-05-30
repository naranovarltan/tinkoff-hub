package me.antandtim.tinkoff.hub

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class ArchTest {

    @Test
    fun servicesAndRepositoriesShouldNotDependOnWebLayer() {

        val importedClasses = ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("me.antandtim.tinkoff.hub")

        noClasses()
            .that()
                .resideInAnyPackage("me.antandtim.tinkoff.hub.service..")
            .or()
                .resideInAnyPackage("me.antandtim.tinkoff.hub.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..me.antandtim.tinkoff.hub.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses)
    }
}
