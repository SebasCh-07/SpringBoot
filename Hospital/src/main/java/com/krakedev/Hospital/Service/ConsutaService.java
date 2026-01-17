package com.krakedev.Hospital.Service;

import java.util.List;

import com.krakedev.Hospital.Entity.ConsultaEntity;

public interface ConsutaService {
    ConsultaEntity registrarConsulta(ConsultaEntity consulta);
    List<ConsultaEntity> listarConsultas();
}
