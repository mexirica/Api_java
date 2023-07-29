package com.api.repository;

import com.api.model.BancosDiaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BancosRepository extends JpaRepository<BancosDiaModel, Integer> {

    List<BancosDiaModel> findByEmpresaId(Integer empresaId);

    BancosDiaModel findByBancoConta(Integer conta);
}
