package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.EvaluationResponseDto;
import com.bein.gescoapi.entities.Evaluation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EvaluationMapper {

    EvaluationMapper INSTANCE = Mappers.getMapper(EvaluationMapper.class);


    EvaluationResponseDto fromEntityToResponse(Evaluation evaluation);

}
