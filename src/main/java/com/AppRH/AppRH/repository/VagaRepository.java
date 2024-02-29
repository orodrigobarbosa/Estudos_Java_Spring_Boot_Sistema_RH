package com.AppRH.AppRH.repository;

import com.AppRH.AppRH.models.Vaga;

import java.util.List;

public interface VagaRepository {
    void save(Vaga vaga);

    Vaga findByCodigo (long codigo);
    List<Vaga> findByNome(String nome);

    Iterable<Vaga> findAll();
}
