/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gabriela.portfolio.controller;

import com.gabriela.portfolio.model.Project;
import com.gabriela.portfolio.service.IProjectService;
import static java.lang.Long.parseLong;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriela
 */
@RestController
public class ProjectController {
    
    @Autowired
    private IProjectService projServ;
    
    @GetMapping("/show/projects")
    @ResponseBody
    public List<Project> showPojects(){
        return projServ.showProjects();
    }
    
    @PostMapping("/add/project")
    public void addProject(@RequestBody Project proj){
        projServ.addProject(proj);
    }
    
    @PutMapping("/edit/project")
    public void editProject(@RequestBody Project p, @RequestParam String idProject){
        Long id = parseLong(idProject);
        p.setIdProject(id);
        projServ.editProject(p);
    }
    
    @DeleteMapping("delete/project")
    public void deleteProject(@RequestBody String idProject){
        Long id = parseLong(idProject);
        projServ.deleteProject(id);
    }
}
