package com.healthcare.controller;

import com.healthcare.entity.Role;
import com.healthcare.service.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "Brain Health Initiative API")
@Tag(name = "Role", description = "Endpoint to maintain different types of roles present")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @GetMapping("")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{roleName}")
    public Role getRole(@PathVariable String roleName){
        return roleService.getRoleByName(roleName);
    }

    @GetMapping("/doctors")
    public List<Role> getDoctorRoles(){
        return roleService.getDoctorRoles();
    }
}
