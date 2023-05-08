package com.example.bpm.controller;

import com.example.bpm.dto.ProjectDto;
import com.example.bpm.dto.ProjectRoleDto;
import com.example.bpm.dto.UserDto;
import com.example.bpm.service.ProjectSerivce;
//import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@Builder
public class ProjectController {

    @Autowired
    final private ProjectSerivce projectSerivce;

    /* - - - - 프로젝트를 생성하고 선택하는 매핑 - - - -  */
    //로그인을 성공 했을 떄 redirect로 session 값을 같이 가져와야함 (현재 session에는 로그인된 유저의 정보를 담고있어야한다)
    @GetMapping("/project/projectList")
    public String getProjectList(HttpSession session, Model model) {
        //세션에서 현재 로그인 되어있는 유저의 정보를 가져온다
        UserDto sessionUser = (UserDto) session.getAttribute("userInfo");
        //UUID를 활용하여 권한자 / 비권한자 프로젝트 리스트를 불러온다
        List<ProjectRoleDto> ManagerToProjectList = projectSerivce.findManagerToProjectList(sessionUser.getUuid());
        List<ProjectRoleDto> ParticipantsToProjectList = projectSerivce.findParticipantsToProjectList(sessionUser.getUuid());
        if (ManagerToProjectList.isEmpty()) {
            if (ParticipantsToProjectList.isEmpty()) {
                log.info("참여중인 리스트가 없음");
            } else {
                log.info("비권한자 리스트만 있음");
            }
        } else {
            if (ParticipantsToProjectList.isEmpty()) {
                log.info("권한자 리스트만 있음");
            } else {
                log.info("둘다 리스트 있음");
            }
        }
        //null값이던 데이터가 존재하던 어쨋든 리스트 창을 보여줘야한다. (빈 공백이라도)
        model.addAttribute("ListToM", ManagerToProjectList);
        model.addAttribute("ListToP", ParticipantsToProjectList);
        return "projectList 페이지로 ";
    }


    @GetMapping("/project/createPage")
    public String goToCreateProject() {
        return "project/home";
    }


    //프로젝트 생성 버튼을 누르는 순간 프로젝트 생성되는 메서드
    @PostMapping("/project/createPage")
    public String createProject(@ModelAttribute ProjectDto projectDto, HttpSession session, Model model) {
        if (projectDto.equals(null)) {
            log.info("값을 다 입력하지 못했음 (컨트롤러 작동)");
            return "project/createPage";
        } else {
            projectSerivce.createProject(projectDto);
            log.info("프로젝트 생성 정상 작동(컨트롤러 작동)");
            return "project/home";
        }
    }

    //프로젝트 삭제
    @GetMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectSerivce.deleteProject(id);
        log.info("프로젝트 정상 삭제 (컨트롤러 작동)");
        return "redirect:/project/projectList";
    }



  //프로젝트 선택 시 그 프로젝트 정보를 가져오며 프로젝트 창으로 넘어가는 메서드
    @GetMapping("/project/projectList/{id}")
    public String selectProject(@PathVariable Long id, Model model) {
        ProjectDto presentDto = projectSerivce.selectProject(id);
        model.addAttribute(presentDto);
        //프로젝트 id 값을 넘겨야되는데
        return "project/{id}";
    }


    /* - - - - 프로젝트를 생성하고 선택하는 매핑 끝 - - - -  */
    
    /* - - - - 프로젝트 안에 사이드바 메뉴 (다 getmapping 처리 해주면 댐) - - - - */
    
    //목표
    //작업
    //문서
    //프로젝트생성



    
}


