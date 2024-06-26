package com.example.spontecular.controller;

import com.example.spontecular.dto.*;
import com.example.spontecular.feature.classes.Classes;
import com.example.spontecular.feature.constraints.Constraints;
import com.example.spontecular.feature.hierarchy.Hierarchy;
import com.example.spontecular.feature.relations.Relations;
import com.example.spontecular.jena.JenaService;
import com.example.spontecular.specification.SpecificationService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AppController {

    @Value("${default.definition.classes}")
    private String defaultClassesDefinition;

    @Value("${default.definition.hierarchy}")
    private String defaultHierarchyDefinition;

    @Value("${default.definition.relations}")
    private String defaultRelationsDefinition;

    @Value("${default.definition.constraints}")
    private String defaultConstraintsDefinition;

    @GetMapping({"/", "/restart"})
    public String index(Model model, HttpSession session) {
        SettingsForm settings;

        if (session.getAttribute("settings") != null ) {
            settings = (SettingsForm) session.getAttribute("settings");
        } else {
            settings = SettingsForm.builder()
                    .classesDefinition(defaultClassesDefinition)
                    .hierarchyDefinition(defaultHierarchyDefinition)
                    .relationsDefinition(defaultRelationsDefinition)
                    .constraintsDefinition(defaultConstraintsDefinition)
                    .build();
            session.setAttribute("settings", settings);
        }

        model.addAttribute("settings", settings);
        return "index";
    }

    @PostMapping("/updateSettings")
    public ResponseEntity<Void> updateSettings(@ModelAttribute SettingsForm settings, HttpSession session) {
        session.setAttribute("settings", settings);
        return ResponseEntity.ok().build();
    }

    @GetMapping("favicon.ico")
    void favicon(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
