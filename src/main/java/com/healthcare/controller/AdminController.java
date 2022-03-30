package com.healthcare.controller;

import com.healthcare.entity.Admin;
import com.healthcare.service.AdminService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SecurityRequirement(name = "Brain Health Initiative API")
@Tag(name = "Admin")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin)
    {
        Admin a = adminService.createAdmin(admin);
        return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    private Admin getAdmin(@PathVariable("id") Long id)
    {
        return adminService.getAdminById(id);
    }
    @GetMapping("")
    public List<Admin> getAllAdmins(){
        List<Admin> doctors = adminService.getAllAdmins();
        return doctors;
    }
    @DeleteMapping("/{id}")
    private void deleteAdmin(@PathVariable("id") long id)
    {
        adminService.deleteAdmin(id);
        System.out.println("Deleted");
    }

    @PutMapping("")
    private Admin update(@RequestBody Admin admin)
    {
        return adminService.updateAdmin(admin);

    }
}
