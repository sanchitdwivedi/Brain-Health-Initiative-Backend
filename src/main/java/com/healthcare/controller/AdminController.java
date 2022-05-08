package com.healthcare.controller;

import com.healthcare.entity.Admin;
import com.healthcare.entity.Doctor;
import com.healthcare.service.AdminService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updatePassword(@PathVariable long id, @Schema(description = "Password must be atleast 8 characters long",
            example = "{\"newPassword\":\"string\"}") @RequestBody HashMap<String, String> object){
        Admin admin = adminService.updatePassword(id, object);
        return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
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
    private void deleteAdmin(@PathVariable("id") int id)
    {
        adminService.deleteAdmin(id);
        //System.out.println("Deleted");
    }

    @PutMapping("/update/{id}")
    private Admin update(@RequestBody Admin admin,@PathVariable int id)
    {
        admin.setUuid(id);
        return adminService.updateAdmin(admin);

    }
}
