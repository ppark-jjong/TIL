package com.example.bpm.repository;

import com.example.bpm.entity.ProjectRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//send와 recv로 id를 식별하고 get() 함수로 projectid를 찾는 방식을 써야한다.
//아마 오류 뜰 확률 ㅈㄴ 높음 String이 PK 키인데 Long 타입이 껴있음....
public interface ProjectRequestRepository extends JpaRepository<ProjectRequestEntity, String> {

    @Query(value = // 괄호한 value 값의 sql문을 실행시킴
            "delete FROM" +
                    " project_requst " +
                    "WHERE send_uuid = :sendUUID AND recv_uuid = :recvUUID AND project_id = :projectId ",
            nativeQuery = true )
    void deleteByAllId(String sendUUID, String recvUUID, Long projectId);

    @Query(value = "insert into project_requst(send_uuid, recv_uuid, project_id) " +
            "values ( :sendUser, :recvUser, :projectId)", nativeQuery = true)
    void plusProjectRequest(String sendUser, String recvUser, Long projectId);


    @Query(value = "select * " +
            "from project_requst where send_uuid = :sendUser AND recv_uuid = :recvUser AND project_id = :projectId ", nativeQuery = true)
    Optional<ProjectRequestEntity> selectTorequestRow(String sendUser, String recvUser, Long projectId);

    @Query(value = "select * from project_requst where recv_uuid = :recvUUID", nativeQuery = true)
    List<ProjectRequestEntity> selectParticipantsList(String recvUUID);
}
