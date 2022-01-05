package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.MaterialBalanceDto;
import com.ecxfoi.wbl.wienerbergerbackend.model.Material;
import org.springframework.stereotype.Component;

@Component
public class MaterialBalanceMapper implements GenericMapper<MaterialBalanceDto, Material>
{
    @Override
    public MaterialBalanceDto mapDto(final Material entity)
    {
        if (entity == null)
        {
            return null;
        }

        MaterialBalanceDto materialBalanceDto = new MaterialBalanceDto();

        materialBalanceDto.setMaterialNumber(entity.getMaterialNumber());
        materialBalanceDto.setName(entity.getName());
        materialBalanceDto.setQuantity(entity.getQuantity());
        materialBalanceDto.setCost(entity.getCost());

        return materialBalanceDto;
    }

    @Override
    public Material map(final MaterialBalanceDto dto) throws Exception
    {
        if (dto == null)
        {
            return null;
        }

        Material material = new Material();
        material.setMaterialNumber(dto.getMaterialNumber());
        material.setName(dto.getName());
        material.setCost(dto.getCost());
        material.setQuantity(dto.getQuantity());

        return material;
    }
}
