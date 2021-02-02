package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Test
    public void shouldReturnTrue_whenGetATeamById(){
       // Given
        String teamName = "PSG";
        Long id = 1L;

        // When
        TeamEntity teamEntity =  teamService.findTeamById(1L);

        // Then
        Assertions.assertThat(teamEntity.getName()).isEqualTo(teamName);
    }
    @Test
    public void shouldReturnAllTheTeams(){
       // Given
        TeamEntity teamEntity = new TeamEntity(7L,"TestAddedTeam","Les testeurs");
        List<TeamEntity> teamEntityListBefore =  teamService.findAllTeams();

        // When
        teamService.insertTeam(teamEntity);
        List<TeamEntity> teamEntityListAfter =  teamService.findAllTeams();

        // Then
        Assertions.assertThat(teamEntityListAfter).isNotEmpty().isNotNull();
        Assertions.assertThat(teamEntityListAfter.size()).isEqualTo(teamEntityListBefore.size() + 1);

        TeamEntity teamResult = teamService.findTeamById(teamEntity.getId());
        Assertions.assertThat(teamEntityListAfter.contains(teamEntity));
        Assertions.assertThat(teamResult.getName()).isEqualTo(teamEntity.getName());
        Assertions.assertThat(teamResult.getSlogan()).isEqualTo(teamEntity.getSlogan());
    }
    @Test
    public void shouldReturnTrue_WhenATeamIsInsert(){
       // Given
        TeamEntity teamEntity = new TeamEntity(6L,"TestTeam","Les testeurs");

        // When
        teamService.insertTeam(teamEntity);

        // Then
        TeamEntity resultTeam = teamService.findTeamById(teamEntity.getId());
        Assertions.assertThat(resultTeam.getName()).isEqualTo(teamEntity.getName());
        Assertions.assertThat(resultTeam.getSlogan()).isEqualTo(teamEntity.getSlogan());

    }
    @Test
    public void shouldReturnTrue_WhenATeamIsModified(){
       // Given
        TeamEntity teamEntityBefore = new TeamEntity(6L,"TestTeam","Les testeurs");
        TeamEntity teamEntityAfter = new TeamEntity(6L,"TestTeamUpdate","Les testeursUpdate");

        // When
        teamService.insertTeam(teamEntityBefore);
        teamService.updateTeam(teamEntityAfter);

        // Then
        TeamEntity resultTeam = teamService.findTeamById(teamEntityBefore.getId());
        Assertions.assertThat(resultTeam.getName()).isEqualTo(teamEntityAfter.getName());
        Assertions.assertThat(resultTeam.getSlogan()).isEqualTo(teamEntityAfter.getSlogan());

    }
    @Test
    public void shouldReturnTrue_WhenATeamIsDelete(){
        // Given
        TeamEntity teamEntity = new TeamEntity(7L,"TestAddedTeam","Les testeurs");

        // When
        teamService.insertTeam(teamEntity);
        teamService.deleteTeamById(teamEntity.getId());
        List<TeamEntity> teamEntityListAfter =  teamService.findAllTeams();

        // Then
        TeamEntity teamResult = teamService.findTeamById(teamEntity.getId());
        Assertions.assertThat(teamEntityListAfter.contains(teamEntity)).isFalse();
        Assertions.assertThat(teamResult).isNull();

    }


}
