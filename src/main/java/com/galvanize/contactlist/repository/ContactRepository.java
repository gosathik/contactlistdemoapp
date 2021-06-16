package com.galvanize.contactlist.repository;

import com.galvanize.contactlist.domain.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contacts,Long> {

    List<Contacts> findByGivenName(String givenName);

    @Query("SELECT c FROM Contacts c WHERE c.givenName = ?1 AND c.surname = ?2 ")
    List<Contacts> findByNames(String givenName, String surname );
}
