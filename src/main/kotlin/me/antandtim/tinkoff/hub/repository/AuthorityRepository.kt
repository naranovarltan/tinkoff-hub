package me.antandtim.tinkoff.hub.repository

import me.antandtim.tinkoff.hub.domain.Authority
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Spring Data JPA repository for the [Authority] entity.
 */

interface AuthorityRepository : JpaRepository<Authority, String>
