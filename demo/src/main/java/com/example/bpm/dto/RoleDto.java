package com.example.bpm.dto;

import com.example.bpm.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private String roleName;

    public static RoleDto toRoleDto(RoleEntity roleEntity){
        RoleDto roleDto = new RoleDto();
        roleDto.setId(roleEntity.getId());
        roleDto.setRoleName(roleEntity.getRoleName());
        return roleDto;
    }
}
