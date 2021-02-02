package fr.sorbonne.paris.nord.university.api.controller;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.mapper.TeamMapper;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TeamControllerTest {

    private final TeamEntity teamEntity = new TeamEntity(10L,"ControllerTeamTest","LesControlleursTesteurs");


    @Autowired
    private TeamMapper teamMapper ;

    @Mock   // the fake
    private TeamService teamService;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(new TeamController(teamService,teamMapper));
    }

    @Test
    public void shouldReturn200_whenRequestGetAllTeams(){
        when(teamService.findAllTeams()).thenReturn(Arrays.asList(teamEntity));

        given()
                .when()
                .get("teams")
                .then()
                .statusCode(200);
    }
    @Test
    public void shouldReturn200_whenRequestGetId(){
        when(teamService.findTeamById(10L)).thenReturn(teamEntity);

        given()
                .when()
                .get("teams/{id}",10L)
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldReturn200_whenCreateTeam(){

        TeamEntity teamToCreate = new TeamEntity(11L,"ControllerCreateTest",
                "LesControlleursTesteursCreate");
        when(teamService.insertTeam(Mockito.any())).thenReturn(teamToCreate);

        given()
                .contentType("application/json")
                .body(teamMapper.toDto(teamToCreate))
                .when()
                .post("teams")
                .then()
                .statusCode(200);
    }
    @Test
    public void shouldReturn200_whenUpdateTeam(){

        TeamEntity updatedTeam = new TeamEntity(11L,"ControllerCreateTest Update",
                "LesControlleursTesteursCreate Update");
        when(teamService.updateTeam(Mockito.any())).thenReturn(updatedTeam);

        given()
                .contentType("application/json")
                .body(teamMapper.toDto(updatedTeam))
                .when()
                .put("teams")
                .then()
                .statusCode(200);
    }
    @Test
    public void shouldReturn200_whenDeleteTeam(){

        when(teamService.deleteTeamById(Mockito.any())).thenReturn(true);
        given()
                .delete("teams/{id}",10L)
                .then()
                .statusCode(200);
    }

}
