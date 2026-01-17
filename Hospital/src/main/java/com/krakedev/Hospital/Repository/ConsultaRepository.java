package com.krakedev.Hospital.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.Hospital.Entity.ConsultaEntity;


@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

}
