package com.example.bpm.service;

import com.example.bpm.dto.ProjectDto;
import com.example.bpm.dto.ProjectRequestDto;
import com.example.bpm.dto.ProjectRoleDto;
import com.example.bpm.entity.ProjectEntity;
import com.example.bpm.entity.ProjectRequestEntity;
import com.example.bpm.entity.ProjectRoleEntity;
import com.example.bpm.repository.ProjectRepository;
import com.example.bpm.repository.ProjectRequestRepository;
import com.example.bpm.repository.ProjectRoleRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Builder
//메서드 리턴타입은 무조건 Dto로 나오게 하자.
//파라미터는 String 형식으로 받기로 하자 (절대 객체단위로 받으면 안됨 헷갈리기도 하고 NULL 오류가 잘 생김)
/*해당 클래스는 프로젝트에 접근하는 방식에 관련된 권한, 초대 등을 다루고 있는 클래스이다*/
public class ProjectSerivce {
    @Autowired
    final private ProjectRequestRepository projectRequestRepository;
    @Autowired
    final private ProjectRepository projectRepository;
    @Autowired
    final private ProjectRoleRepository projectRoleRepository;

    /*Request Table 관련 기능*/

    //프로젝트 초대를 보내는 메서드      리턴 데이터는 send 한 기록을 보여준다
    public ProjectRequestDto sendInvite(String sendUser, String recvUser, Long projectId) {
        if (sendUser != null && recvUser != null) {
            projectRequestRepository.plusProjectRequest(sendUser, recvUser, projectId);
            log.info("친구 요청 정상 작동 (서비스 작동)");

            Optional<ProjectRequestEntity> projectRequestEntity
                    = projectRequestRepository.findById(sendUser);
            //만약 정상 친구요청이 되면 그 row을 확인할 수 있게 return 한다
            return ProjectRequestDto.toProjectRequestDto(projectRequestEntity.get());
        } else {
            log.info("Dto NULL 값 (서비스 작동)");
            return null;
        }
    }

    //초대를 확인하는 메서드 recvUUID로만 보여짐
    public List<ProjectRequestDto> findAllToRequestProject(String recvUUID) {
        List<ProjectRequestEntity> entityList = projectRequestRepository.selectParticipantsList(recvUUID);
        List<ProjectRequestDto> dtoList = new ArrayList<>();

        for (ProjectRequestEntity projectRequestEntity :
                entityList) {
            dtoList.add(ProjectRequestDto.toProjectRequestDto(projectRequestEntity));
        }
        log.info("recvUUID를 이용한 초대 수신 메서드 정상작동 (서비스 작동)");
        return dtoList;
    }


    //초대 수락하는 메서드(무조건 비권한자로써 수락받는다)
    //서비스의 파라미터로 true false 값을 받아와도 되지만 파라미터가 ㅈㄴ 많으므로 컨트롤러에서 if 문을 거칠 필요가 있음 (코드 개더럽네)
    public ProjectRoleDto submitInvite(String sendUUID, String recvUUID, Long projectId, Long input) {
        //수락
        if (input == 1) {
            //ProjectRquest에 있는 데이터 삭제
            projectRequestRepository.deleteByAllId(sendUUID, recvUUID, projectId);
            log.info("수락 요청으로 인한 요청테이블 데이터 삭제 작동 (서비스 작동)");
            //ProejctRole Table에 데이터 추가
            ProjectRoleEntity projectRoleEntity = projectRoleRepository.insertToRoleEntity(projectId, recvUUID, Long.valueOf(1));
            log.info("수락 요청으로 인한 Role Table에 데이터 삽입 (서비스 작동)");
            return ProjectRoleDto.toProjectRoleDto(projectRoleEntity);
        }
        //거절
        else if (input == 2) {
            //ProjectRquest에 있는 데이터 삭제
            projectRequestRepository.deleteByAllId(sendUUID, recvUUID, projectId);
            log.info("거절 요청으로 인한 요청테이블 데이터 삭제 작동 (서비스 작동)");
            return null;
        } else {
            log.info("수락 요청의 변수값이 잘못되었습니다. (서비스 작동)");
            return null;
        }
    }
    /*Request Table 관련 메서드 끝*/




    /*ProjectRole + Project Table 관련 기능*/

    //본인이 참여하고있는 권한자 프로젝트 리스트를 리턴해주는 메서드 (프로젝트 리스트 페이지에서 필요함)
    public List<ProjectRoleDto> findManagerToProjectList(String userId) {
        List<ProjectRoleEntity> entityList = projectRoleRepository.findByAlltoUserId(userId);
        List<ProjectRoleDto> dtoListToM = new ArrayList<>();
        for (ProjectRoleEntity projectRoleEntity :
                entityList) {
            //1 == 권한자 (프로젝트 생성자)
            if (projectRoleEntity.getRole().equals(1)) {
                log.info("관리자 권한으로 된 프로젝트가 있음 (서비스 작동)");
                dtoListToM.add(ProjectRoleDto.toProjectRoleDto(projectRoleEntity));
            }
        }
        if (dtoListToM.isEmpty()) {
            log.info("관리자 권한으로 된 프로젝트가 없음 (서비스 작동)");
            return null;
        } else {
            return dtoListToM;
        }
    }

    //본인이 참여하고있는 비권한자 프로젝트 리스트를 리턴해주는 메서드 (프로젝트 리스트 페이지에서 필요함)
    public List<ProjectRoleDto> findParticipantsToProjectList(String userId) {
        List<ProjectRoleEntity> entityList = projectRoleRepository.findByAlltoUserId(userId);
        List<ProjectRoleDto> dtoListToP = new ArrayList<>();
        for (ProjectRoleEntity projectRoleEntity :
                entityList) {
            //2 == 비권한자 (프로젝트 참여자)
            if (projectRoleEntity.getRole().equals(2)) {
                log.info("비관리자 권한으로 된 프로젝트가 있음 (서비스 작동)");
                dtoListToP.add(ProjectRoleDto.toProjectRoleDto(projectRoleEntity));
            }
        }
        if (dtoListToP.isEmpty()) {
            log.info("비관리자 권한으로 된 프로젝트가 없음 (서비스 작동)");
            return null;
        } else {
            return dtoListToP;
        }
    }


    //생성 메서드
    public ProjectDto createProject(ProjectDto projectDto) {
        ProjectEntity projectEntity = projectRepository.save(ProjectEntity.toProjectEntity(projectDto));
        log.info("프로젝트 정상 생성 (서비스 작동)");
        return ProjectDto.toProjectDto(projectEntity);
    }

    //프로젝트 접속하는 메서드
    public ProjectDto selectProject(Long projectId) {
        Optional<ProjectEntity> projectEntity = projectRepository.findById(projectId);
        return ProjectDto.toProjectDto(projectEntity.get());
    }

    //프로젝트를 삭제하는 메서드
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
        if (projectRepository.findById(projectId).isPresent()) {
            log.info("삭제 오류 (서비스 작동)");
        } else {
            log.info("삭제 성공(서비스 작동)");
        }
    }

}
