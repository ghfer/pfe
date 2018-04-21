package pfe.projet.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pfe.projet.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.login like :x")
	public Page <User> chercher(@Param("x") String mc,Pageable pageRequest);

}
