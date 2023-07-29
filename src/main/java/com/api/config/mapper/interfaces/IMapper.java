package com.api.config.mapper.interfaces;

import com.api.dtos.BancosDiaDTO;
import com.api.dtos.UsuarioCreateDTO;
import com.api.dtos.gnreDTO;
import com.api.model.BancoDoDiaModel;
import com.api.model.BancosDiaModel;
import com.api.model.GnreModel;
import com.api.model.UsuarioNovoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMapper {
    IMapper INSTANCE = Mappers.getMapper(IMapper.class);

    BancosDiaModel createBancoDTOtoBanco(BancosDiaDTO dto);

    UsuarioNovoModel createDTOtoUsuarioNovo(UsuarioCreateDTO dto);

}
