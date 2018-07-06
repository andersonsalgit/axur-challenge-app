package br.com.axur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.axur.model.Whitelist;

@Repository
public interface WhitelistRepository extends JpaRepository<Whitelist, Long>{

}
